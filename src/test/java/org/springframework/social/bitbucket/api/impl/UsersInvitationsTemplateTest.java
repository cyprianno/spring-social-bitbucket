/**
 * Copyright (C) 2012 Eric Bottard / Guillaume Lederrey (eric.bottard+ghpublic@gmail.com / guillaume.lederrey@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketInvitation;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withNoContent;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class UsersInvitationsTemplateTest extends BaseTemplateTest {

    private static final String TEST_ACCOUNTNAME = "testaccount";
    private static final String TEST_EMAIL = "test@email.tld";
    private static final String TEST_GROUPOWNER = "testgroupowner";
    private static final String TEST_GROUPSLUG = "testgroupslug";

    @Test
    public void testGetPendingInvitations() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/invitations")).andExpect(method(GET)).andRespond(
                withSuccess(jsonResource("get-pending-invitations"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketInvitation> result = bitBucket.usersOperations().usersInvitationsOperations().getPendingInvitations(TEST_ACCOUNTNAME);
        //then
        mockServer.verify();
        assertEquals(2, result.size());
        Iterator<BitBucketInvitation> iterator = result.iterator();
        BitBucketInvitation firstInvitation = iterator.next();
        BitBucketInvitation secondInvitation = iterator.next();
        assertEquals(1, firstInvitation.getGroups().size());
        assertNotNull(firstInvitation.getInvitedBy());
        assertEquals("buserbb", firstInvitation.getInvitedBy().getUsername());
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd HH:mm:ssZ");
        Date expectedDate = dateFormatter.parse("2012-07-19 16:22:51+0000", Locale.getDefault());
        assertEquals(expectedDate, firstInvitation.getUtcSentOn());
        assertEquals("joe789@yahoo.com", firstInvitation.getEmail());
        assertEquals(2, secondInvitation.getGroups().size());
        assertEquals("buserbb/testgroup", secondInvitation.getGroups().iterator().next());
        assertEquals("sally_jones@gmail.com", secondInvitation.getEmail());
    }

    @Test
    public void testGetPendingInvitationsForEmail() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/invitations/test@email.tld")).andExpect(method(GET)).andRespond(
                withSuccess(jsonResource("get-pending-invitations-for-email"), MediaType.APPLICATION_JSON));
        //when
        BitBucketInvitation result = bitBucket.usersOperations().usersInvitationsOperations().getPendingInvitationsForEmail(TEST_ACCOUNTNAME, TEST_EMAIL);
        //then
        mockServer.verify();
        assertEquals(2, result.getGroups().size());
        assertEquals("buserbb/testgroup", result.getGroups().iterator().next());
        assertEquals("sally_jones@gmail.com", result.getEmail());
        assertEquals("B", result.getInvitedBy().getFirstName());
    }

    @Test
    public void testGetPendingInvitationForGroupMembershipPositive() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/invitations/test@email.tld/testgroupowner/testgroupslug")).andExpect(
                method(GET)).andRespond(withSuccess("OK", MediaType.APPLICATION_JSON));
        //when
        boolean result = bitBucket.usersOperations().usersInvitationsOperations()
                .getPendingInvitationForGroupMembership(TEST_ACCOUNTNAME, TEST_GROUPOWNER, TEST_GROUPSLUG, TEST_EMAIL);
        //then
        mockServer.verify();
        assertTrue(result);
    }

    @Test
    public void testGetPendingInvitationForGroupMembershipNegative() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/invitations/test@email.tld/testgroupowner/testgroupslug")).andExpect(
                method(GET)).andRespond(withSuccess("Not found", MediaType.APPLICATION_JSON));
        //when
        boolean result = bitBucket.usersOperations().usersInvitationsOperations()
                .getPendingInvitationForGroupMembership(TEST_ACCOUNTNAME, TEST_GROUPOWNER, TEST_GROUPSLUG, TEST_EMAIL);
        //then
        mockServer.verify();
        assertFalse(result);
    }

    @Test
    public void testIssueInvitationToGroup() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/invitations/test@email.tld/testgroupowner/testgroupslug")).andExpect(
                method(PUT)).andRespond(withSuccess("Not found", MediaType.APPLICATION_JSON));
        //when
        boolean result = bitBucket.usersOperations().usersInvitationsOperations()
                .issueInvitationToGroup(TEST_ACCOUNTNAME, TEST_GROUPOWNER, TEST_GROUPSLUG, TEST_EMAIL);
        //then
        mockServer.verify();
        assertFalse(result);
    }

    @Test
    public void testRemoveInitationByEmail() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/invitations/test@email.tld")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.usersOperations().usersInvitationsOperations().removeInitationByEmail(TEST_ACCOUNTNAME, TEST_EMAIL);
        //then
        mockServer.verify();
    }

    @Test
    public void testRemoveInvitationByGroup() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/invitations/test@email.tld/testgroupowner/testgroupslug")).andExpect(
                method(DELETE)).andRespond(withNoContent());
        //when
        bitBucket.usersOperations().usersInvitationsOperations().removeInvitationByGroup(TEST_ACCOUNTNAME, TEST_GROUPOWNER, TEST_GROUPSLUG, TEST_EMAIL);
        //then
        mockServer.verify();
    }
}
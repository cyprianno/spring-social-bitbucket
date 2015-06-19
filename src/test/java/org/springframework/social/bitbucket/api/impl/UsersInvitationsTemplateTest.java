package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketInvitation;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
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
        assertTrue(false);
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/repositories/tortoisehg/thg/followers/"))
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(jsonResource("get-pending-invitations"),
                                MediaType.APPLICATION_JSON));
        //when
        List<BitBucketInvitation> result = bitBucket.usersOperations().usersInvitationsOperations().getPendingInvitations(TEST_ACCOUNTNAME);
        //then
        mockServer.verify();
    }

    @Test
    public void testGetPendingInvitationsForEmail() throws Exception {
        assertTrue(false);
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/repositories/tortoisehg/thg/followers/"))
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(jsonResource("get-pending-invitations-for-email"),
                                MediaType.APPLICATION_JSON));
        //when
        List<BitBucketInvitation> result = bitBucket.usersOperations().usersInvitationsOperations()
                .getPendingInvitationsForEmail(TEST_ACCOUNTNAME, TEST_EMAIL);
        //then
        mockServer.verify();
    }

    @Test
    public void testGetPendingInvitationForGroupMembership() throws Exception {
        assertTrue(false);
        //xxx
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/repositories/tortoisehg/thg/followers/"))
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(jsonResource("repo-followers"),
                                MediaType.APPLICATION_JSON));
        //when
        boolean result = bitBucket.usersOperations().usersInvitationsOperations()
                .getPendingInvitationForGroupMembership(TEST_ACCOUNTNAME, TEST_GROUPOWNER, TEST_GROUPSLUG, TEST_EMAIL);
        //then
        mockServer.verify();
    }

    @Test
    public void testIssueInvitationToGroup() throws Exception {
        assertTrue(false);
        //xxx
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/repositories/tortoisehg/thg/followers/"))
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(jsonResource("repo-followers"),
                                MediaType.APPLICATION_JSON));
        //when
        boolean result = bitBucket.usersOperations().usersInvitationsOperations()
                .issueInvitationToGroup(TEST_ACCOUNTNAME, TEST_GROUPOWNER, TEST_GROUPSLUG, TEST_EMAIL);
        //then
        mockServer.verify();
    }

    @Test
    public void testRemoveInitationByEmail() throws Exception {
        assertTrue(false);
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/privileges/evzijst/test/jespern"))
                .andExpect(method(DELETE)).andRespond(withNoContent());
        //when
        bitBucket.usersOperations().usersInvitationsOperations().removeInitationByEmail(TEST_ACCOUNTNAME, TEST_EMAIL);
        //then
        mockServer.verify();
    }

    @Test
    public void testRemoveInvitationByGroup() throws Exception {
        assertTrue(false);
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/privileges/evzijst/test/jespern"))
                .andExpect(method(DELETE)).andRespond(withNoContent());
        //when
        bitBucket.usersOperations().usersInvitationsOperations().removeInvitationByGroup(TEST_ACCOUNTNAME, TEST_GROUPOWNER, TEST_GROUPSLUG, TEST_EMAIL);
        //then
        mockServer.verify();
    }
}
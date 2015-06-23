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
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketGroup;
import org.springframework.social.bitbucket.api.BitBucketPrivilege;
import org.springframework.social.bitbucket.api.BitBucketUser;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withNoContent;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class GroupsTemplateTest extends BaseTemplateTest {

    private static final String TEST_ACCOUNT_NAME = "testaccount";
    private static final String TEST_GROUP_NAME = "testgroupname";
    private static final String TEST_GROUP_SLUG = "testgroupslug";
    private static final String TEST_MEMBER_NAME = "testmembername";

    @Test
    public void testGetAListOfGroups() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/groups/testaccount")).andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("get-a-list-of-groups"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketGroup> result = bitBucket.groupsOperations().getAListOfGroups(TEST_ACCOUNT_NAME);
        //then
        mockServer.verify();
        assertEquals(1, result.size());
        BitBucketGroup firstGroup = result.iterator().next();
        assertEquals("developers", firstGroup.getName());
        assertEquals("developers", firstGroup.getSlug());
        assertEquals(BitBucketPrivilege.read, firstGroup.getPermission());
        assertEquals(false, firstGroup.isAutoAdd());
        assertEquals(2, firstGroup.getMembers().size());
        Iterator<BitBucketUser> membersIterator = firstGroup.getMembers().iterator();
        BitBucketUser firstMember = membersIterator.next();
        assertEquals("jstepka", firstMember.getUsername());
        BitBucketUser secondMember = membersIterator.next();
        assertEquals("detkin", secondMember.getUsername());
        assertEquals("baratrion", firstGroup.getOwner().getUsername());
    }

    @Test
    public void testPostANewGroup() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/groups/testaccount")).andExpect(method(POST)).andExpect(
                content().string("name=testgroupname")).andRespond(withSuccess(jsonResource("post-a-new-group"), MediaType.APPLICATION_JSON));
        //when
        BitBucketGroup result = bitBucket.groupsOperations().postANewGroup(TEST_ACCOUNT_NAME, TEST_GROUP_NAME);
        //then
        mockServer.verify();
        assertEquals("the designers", result.getName());
        assertEquals("the-designers", result.getSlug());
        assertNull(result.getPermission());
        assertEquals(false, result.isAutoAdd());
        assertTrue(result.getMembers().isEmpty());
        assertEquals("2team", result.getOwner().getUsername());
    }

    @Test
    public void testUpdateAGroup() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/groups/testaccount/testgroupslug")).andExpect(method(PUT)).andExpect(
                content().string("{\"name\":\"testgroupname\",\"permission\":\"admin\",\"auto_add\":true}")).andRespond(withSuccess(jsonResource("update-a-group"), MediaType.APPLICATION_JSON));
        //when
        BitBucketGroup result = bitBucket.groupsOperations()
                .updateAGroup(TEST_ACCOUNT_NAME, TEST_GROUP_NAME, TEST_GROUP_SLUG, true, BitBucketPrivilege.admin);
        //then
        mockServer.verify();
        assertEquals("developers", result.getName());
        assertEquals("developers", result.getSlug());
        assertEquals(BitBucketPrivilege.write, result.getPermission());
        assertEquals(true, result.isAutoAdd());
        assertTrue(result.getMembers().isEmpty());
        assertEquals("baratrion", result.getOwner().getUsername());
    }

    @Test
    public void testRemoveGroup() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/groups/testaccount/testgroupslug"))
                .andExpect(method(DELETE)).andRespond(withNoContent());
        //when
        bitBucket.groupsOperations().removeGroup(TEST_ACCOUNT_NAME, TEST_GROUP_SLUG);
        //then
        mockServer.verify();
    }

    @Test
    public void testGetTheGroupMembers() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/groups/testaccount/testgroupslug/members")).andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("get-the-group-members"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketUser> result = bitBucket.groupsOperations().getTheGroupMembers(TEST_ACCOUNT_NAME, TEST_GROUP_SLUG);
        //then
        mockServer.verify();
        assertEquals(2, result.size());
        Iterator<BitBucketUser> memberIterator = result.iterator();
        BitBucketUser firstUser = memberIterator.next();
        BitBucketUser secondUser = memberIterator.next();
        assertEquals("Justen", firstUser.getFirstName());
        assertEquals("Etkin", secondUser.getLastName());
    }

    @Test
    public void testPutNewMemberIntoAGroup() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/groups/testaccount/testgroupslug/members/testmembername")).andExpect(method(PUT))
                .andRespond(withSuccess(jsonResource("put-new-member-into-a-group"), MediaType.APPLICATION_JSON));
        //when
        BitBucketUser result = bitBucket.groupsOperations().putNewMemberIntoAGroup(TEST_ACCOUNT_NAME, TEST_GROUP_SLUG, TEST_MEMBER_NAME);
        //then
        mockServer.verify();
        assertEquals("atlassian_tutorial", result.getUsername());
        assertEquals(true, result.getTeam());
        assertEquals("Atlassian Tutorials", result.getFirstName());
    }

    @Test
    public void testRemoveMember() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/groups/testaccount/testgroupslug/members/testmembername"))
                .andExpect(method(DELETE)).andRespond(withNoContent());
        //when
        bitBucket.groupsOperations().removeMember(TEST_ACCOUNT_NAME, TEST_GROUP_SLUG, TEST_MEMBER_NAME);
        //then
        mockServer.verify();
    }
}
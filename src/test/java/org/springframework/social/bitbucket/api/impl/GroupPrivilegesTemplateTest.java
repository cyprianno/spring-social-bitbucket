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
import org.springframework.social.bitbucket.api.BitBucketPrivilegeGroup;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
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
public class GroupPrivilegesTemplateTest extends BaseTemplateTest {
    private static final String TEST_ACCOUNT_NAME = "testaccount";
    private static final String TEST_GROUP_SLUG = "testgroupslug";
    private static final String TEST_OWNER = "testowner";
    private static final String TEST_REPOSITORY_SLUG = "test-repository";

    @Test
    public void testGetPrivilegedGroups() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/group-privileges/testaccount")).andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("get-privileged-groups"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketPrivilegeGroup> result = bitBucket.groupPrivilegesOperations().getPrivilegedGroups(TEST_ACCOUNT_NAME);
        //then
        mockServer.verify();
        assertEquals(2, result.size());
        BitBucketPrivilegeGroup firstPrivilegeGroup = result.iterator().next();
        assertEquals("mcatalbas/test", firstPrivilegeGroup.getRepo());
        assertEquals(BitBucketPrivilege.write, firstPrivilegeGroup.getPrivilege());
        assertNotNull(firstPrivilegeGroup.getGroup());
        BitBucketGroup firstPrivilegeGroupGroup = firstPrivilegeGroup.getGroup();
        assertEquals("Mehmet", firstPrivilegeGroupGroup.getOwner().getFirstName());
        assertEquals("developers", firstPrivilegeGroupGroup.getName());
        assertEquals(2, firstPrivilegeGroupGroup.getMembers().size());
        assertEquals("Venegas", firstPrivilegeGroupGroup.getMembers().iterator().next().getLastName());
        assertNotNull(firstPrivilegeGroup.getRepository());
        assertNotNull(firstPrivilegeGroup.getRepository().getOwner());
        assertEquals("test", firstPrivilegeGroup.getRepository().getSlug());
    }

    @Test
    public void testGetPrivilegedGroupsForRepository() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/group-privileges/testaccount/test-repository")).andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("get-privileged-groups-for-repository"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketPrivilegeGroup> result = bitBucket.groupPrivilegesOperations()
                .getPrivilegedGroupsForRepository(TEST_ACCOUNT_NAME, TEST_REPOSITORY_SLUG);
        //then
        mockServer.verify();
        assertEquals(3, result.size());
        BitBucketPrivilegeGroup firstPrivilegeGroup = result.iterator().next();
        assertEquals("2team/grouptest", firstPrivilegeGroup.getRepo());
        assertEquals(BitBucketPrivilege.read, firstPrivilegeGroup.getPrivilege());
        assertNotNull(firstPrivilegeGroup.getGroup());
        assertNotNull(firstPrivilegeGroup.getRepository());
        assertNotNull(firstPrivilegeGroup.getGroup().getOwner());
        assertNotNull(firstPrivilegeGroup.getGroup().getMembers());
        assertTrue(firstPrivilegeGroup.getGroup().getMembers().isEmpty());
        assertEquals("Contractors", firstPrivilegeGroup.getGroup().getName());
        assertTrue(firstPrivilegeGroup.getRepository().getOwner().isTeam());
        assertEquals("grouptest", firstPrivilegeGroup.getRepository().getName());
    }

    @Test
    public void testGetGroupOnRepository() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/group-privileges/testaccount/test-repository/testowner/testgroupslug")).andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("get-group-on-repository"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketPrivilegeGroup> result = bitBucket.groupPrivilegesOperations()
                .getGroupOnRepository(TEST_ACCOUNT_NAME, TEST_REPOSITORY_SLUG, TEST_OWNER, TEST_GROUP_SLUG);
        //then
        mockServer.verify();
        assertEquals(1, result.size());
        BitBucketPrivilegeGroup firstPrivilegeGroup = result.iterator().next();
        assertEquals(BitBucketPrivilege.write, firstPrivilegeGroup.getPrivilege());
        assertNotNull(firstPrivilegeGroup.getGroup());
        assertNotNull(firstPrivilegeGroup.getRepository());
        assertNotNull(firstPrivilegeGroup.getGroup().getOwner());
        assertNotNull(firstPrivilegeGroup.getGroup().getMembers());
        assertEquals(1, firstPrivilegeGroup.getGroup().getMembers().size());
        assertEquals("Developers", firstPrivilegeGroup.getGroup().getName());
        assertTrue(firstPrivilegeGroup.getRepository().getOwner().isTeam());
        assertEquals("grouptest", firstPrivilegeGroup.getRepository().getName());
    }

    @Test
    public void testGetListOfRepositoriesWithPrivilegeGroup() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/group-privileges/testaccount/testowner/testgroupslug")).andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("get-list-of-repositories-with-privilege-group"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketPrivilegeGroup> result = bitBucket.groupPrivilegesOperations()
                .getListOfRepositoriesWithPrivilegeGroup(TEST_ACCOUNT_NAME, TEST_OWNER, TEST_GROUP_SLUG);
        //then
        mockServer.verify();
        assertEquals(4, result.size());
        BitBucketPrivilegeGroup firstPrivilegeGroup = result.iterator().next();
        assertEquals(BitBucketPrivilege.write, firstPrivilegeGroup.getPrivilege());
        assertNotNull(firstPrivilegeGroup.getGroup());
        assertNotNull(firstPrivilegeGroup.getRepository());
        assertNotNull(firstPrivilegeGroup.getGroup().getOwner());
        assertNotNull(firstPrivilegeGroup.getGroup().getMembers());
        assertEquals(1, firstPrivilegeGroup.getGroup().getMembers().size());
        assertEquals("Developers", firstPrivilegeGroup.getGroup().getName());
        assertTrue(firstPrivilegeGroup.getRepository().getOwner().isTeam());
        assertEquals("public2teamrepo", firstPrivilegeGroup.getRepository().getName());
    }

    @Test
    public void testUpdatePrivilegesGroupOnRepository() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/group-privileges/testaccount/test-repository/testowner/testgroupslug"))
                .andExpect(method(PUT)).andExpect(content().string("admin"))
                .andRespond(withSuccess(jsonResource("update-privileges-group-on-repository"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketPrivilegeGroup> result = bitBucket.groupPrivilegesOperations()
                .updatePrivilegesGroupOnRepository(TEST_ACCOUNT_NAME, TEST_REPOSITORY_SLUG, TEST_OWNER, TEST_GROUP_SLUG, BitBucketPrivilege.admin);
        //then
        mockServer.verify();
        assertEquals(1, result.size());
        BitBucketPrivilegeGroup firstPrivilegeGroup = result.iterator().next();
        assertEquals(BitBucketPrivilege.write, firstPrivilegeGroup.getPrivilege());
        assertEquals("2team/grouptest", firstPrivilegeGroup.getRepo());
        assertNotNull(firstPrivilegeGroup.getGroup());
        assertNotNull(firstPrivilegeGroup.getRepository());
        assertNotNull(firstPrivilegeGroup.getGroup().getOwner());
        assertNotNull(firstPrivilegeGroup.getGroup().getMembers());
        assertEquals(1, firstPrivilegeGroup.getGroup().getMembers().size());
        assertFalse(firstPrivilegeGroup.getGroup().getMembers().iterator().next().isTeam());
        assertEquals("Developers", firstPrivilegeGroup.getGroup().getName());
        assertTrue(firstPrivilegeGroup.getRepository().getOwner().isTeam());
        assertEquals("grouptest", firstPrivilegeGroup.getRepository().getName());
    }

    @Test
    public void testRemoveGroupPrivilegesFromRepository() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/group-privileges/testaccount/test-repository/testowner/testgroupslug"))
                .andExpect(method(DELETE)).andRespond(withNoContent());
        //when
        bitBucket.groupPrivilegesOperations().removeGroupPrivilegesFromRepository(TEST_ACCOUNT_NAME, TEST_REPOSITORY_SLUG, TEST_OWNER, TEST_GROUP_SLUG);
        //then
        mockServer.verify();
    }

    @Test
    public void testRemovePrivilegesForGroupAcrossAllRepositories() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/group-privileges/testaccount/testowner/testgroupslug"))
                .andExpect(method(DELETE)).andRespond(withNoContent());
        //when
        bitBucket.groupPrivilegesOperations().removePrivilegesForGroupAcrossAllRepositories(TEST_ACCOUNT_NAME, TEST_OWNER, TEST_GROUP_SLUG);
        //then
        mockServer.verify();
    }
}
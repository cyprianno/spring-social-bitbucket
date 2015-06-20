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
import org.springframework.social.bitbucket.api.BitBucketTeamPrivilege;

import java.util.Map;

import static org.junit.Assert.assertEquals;
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
public class UsersPrivilegesTemplateTest extends BaseTemplateTest {
    private static final String TEST_ACCOUNTNAME = "testaccount";
    private static final String TEST_OWNER = "testowner";
    private static final String TEST_GROUPSLUG = "testgroupslug";

    @Test
    public void testGetPrigilegeGroupOnTeamAccount() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/privileges")).andExpect(method(GET)).andRespond(
                withSuccess(jsonResource("get-privilege-group-on-team-account"), MediaType.APPLICATION_JSON));
        //when
        Map<String, BitBucketTeamPrivilege> result = bitBucket.usersOperations().usersPrivilegesOperations()
                .getPrigilegeGroupOnTeamAccount(TEST_ACCOUNTNAME, TEST_GROUPSLUG);
        //then
        mockServer.verify();
        assertEquals(2, result.size());
        assertTrue(result.containsKey("2team/administrators"));
        assertTrue(result.containsKey("2team/developers"));
        assertEquals(BitBucketTeamPrivilege.admin, result.get("2team/administrators"));
        assertEquals(BitBucketTeamPrivilege.collaborator, result.get("2team/developers"));
    }

    @Test
    public void testGetPrivilegesAssociatedWithGroup() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/privileges/testowner/testgroupslug")).andExpect(method(GET)).andRespond(
                withSuccess(jsonResource("get-privilege-group-associated-with-group"), MediaType.APPLICATION_JSON));
        //when
        BitBucketTeamPrivilege result = bitBucket.usersOperations().usersPrivilegesOperations()
                .getPrivilegesAssociatedWithGroup(TEST_ACCOUNTNAME, TEST_OWNER, TEST_GROUPSLUG);
        //then
        mockServer.verify();
        assertEquals(BitBucketTeamPrivilege.collaborator, result);
    }

    @Test
    public void testUpdateGroupPrivilegesOnTeamAccount() throws Exception {
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/privileges/testowner/testgroupslug"))
                .andExpect(method(PUT))
                .andExpect(content().string("privileges=collaborator"))
                .andRespond(
                        withSuccess(jsonResource("update-group-privileges-on-team-account"),
                                MediaType.APPLICATION_JSON));
        //when
        Map<String, BitBucketTeamPrivilege> result = bitBucket.usersOperations().usersPrivilegesOperations()
                .updateGroupPrivilegesOnTeamAccount(TEST_ACCOUNTNAME, TEST_OWNER, TEST_GROUPSLUG, BitBucketTeamPrivilege.collaborator);
        //then
        mockServer.verify();
        assertEquals(1, result.size());
        assertTrue(result.containsKey("2team/contractors"));
        assertEquals(BitBucketTeamPrivilege.admin, result.get("2team/contractors"));
    }

    @Test
    public void testPostNewPrivilege() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/privileges/testowner/testgroupslug")).andExpect(method(POST)).andExpect(
                content().string("privileges=admin")).andRespond(withSuccess(jsonResource("post-new-privilege"), MediaType.APPLICATION_JSON));
        //when
        Map<String, BitBucketTeamPrivilege> result = bitBucket.usersOperations().usersPrivilegesOperations()
                .postNewPrivilege(TEST_ACCOUNTNAME, TEST_OWNER, TEST_GROUPSLUG, BitBucketTeamPrivilege.admin);
        //then
        mockServer.verify();
        assertEquals(1, result.size());
        assertTrue(result.containsKey("2team/contractors"));
        assertEquals(BitBucketTeamPrivilege.admin, result.get("2team/contractors"));
    }

    @Test
    public void testRemovePrivilegeGroup() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/privileges/testowner/testgroupslug")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.usersOperations().usersPrivilegesOperations().removePrivilegeGroup(TEST_ACCOUNTNAME, TEST_OWNER, TEST_GROUPSLUG);
        //then
        mockServer.verify();
    }
}
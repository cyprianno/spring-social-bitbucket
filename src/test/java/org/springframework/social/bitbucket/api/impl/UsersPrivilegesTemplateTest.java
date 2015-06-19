package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketTeamPrivilege;

import java.util.Map;

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
public class UsersPrivilegesTemplateTest extends BaseTemplateTest {
    private static final String TEST_ACCOUNTNAME = "testaccount";
    private static final String TEST_OWNER = "testowner";
    private static final String TEST_GROUPSLUG = "testgroupslug";
    @Test
    public void testGetPrigilegeGroupOnTeamAccount() throws Exception {
        assertTrue(false);
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/repositories/tortoisehg/thg/followers/"))
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(jsonResource("get-privilege-group-on-team-account"),
                                MediaType.APPLICATION_JSON));
        //when
        Map<String, BitBucketTeamPrivilege> result = bitBucket.usersOperations().usersPrivilegesOperations()
                .getPrigilegeGroupOnTeamAccount(TEST_ACCOUNTNAME, TEST_GROUPSLUG);
        //then
        mockServer.verify();
    }

    @Test
    public void testGetPrivilegesAssociatedWithGroup() throws Exception {
        assertTrue(false);
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/repositories/tortoisehg/thg/followers/"))
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(jsonResource("get-privilege-group-associated-with-group"),
                                MediaType.APPLICATION_JSON));
        //when
        BitBucketTeamPrivilege result = bitBucket.usersOperations().usersPrivilegesOperations()
                .getPrivilegesAssociatedWithGroup(TEST_ACCOUNTNAME, TEST_OWNER, TEST_GROUPSLUG);
        //then
        mockServer.verify();
    }

    @Test
    public void testUpdateGroupPrivilegesOnTeamAccount() throws Exception {
        assertTrue(false);
        //update-group-privileges-on-team-account
        //given
        //when
        Map<String, BitBucketTeamPrivilege> result = bitBucket.usersOperations().usersPrivilegesOperations()
                .updateGroupPrivilegesOnTeamAccount(TEST_ACCOUNTNAME, TEST_OWNER, TEST_GROUPSLUG, BitBucketTeamPrivilege.collaborator);
        //then
        mockServer.verify();
    }

    @Test
    public void testPostNewPrivilege() throws Exception {
        assertTrue(false);
        //post-new-privilege
        //given
        //when
        Map<String, BitBucketTeamPrivilege> result = bitBucket.usersOperations().usersPrivilegesOperations()
                .postNewPrivilege(TEST_ACCOUNTNAME, TEST_OWNER, TEST_GROUPSLUG, BitBucketTeamPrivilege.admin);
        //then
        mockServer.verify();
    }

    @Test
    public void testRemovePrivilegeGroup() throws Exception {
        assertTrue(false);
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/privileges/evzijst/test/jespern"))
                .andExpect(method(DELETE)).andRespond(withNoContent());
        //when
        bitBucket.usersOperations().usersPrivilegesOperations().removePrivilegeGroup(TEST_ACCOUNTNAME, TEST_OWNER, TEST_GROUPSLUG);
        //then
        mockServer.verify();
    }
}
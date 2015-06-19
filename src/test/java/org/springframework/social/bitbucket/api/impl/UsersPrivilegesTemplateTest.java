package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.social.bitbucket.api.BitBucketTeamPrivilege;

import java.util.Map;

import static org.junit.Assert.assertTrue;

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
        //get-privilege-group-on-team-account
        //given
        //when
        Map<String, BitBucketTeamPrivilege> result = bitBucket.usersOperations().usersPrivilegesOperations()
                .getPrigilegeGroupOnTeamAccount(TEST_ACCOUNTNAME, TEST_GROUPSLUG);
        //then
    }

    @Test
    public void testGetPrivilegesAssociatedWithGroup() throws Exception {
        assertTrue(false);
        //get-privilege-group-associated-with-group
        //given
        //when
        BitBucketTeamPrivilege result = bitBucket.usersOperations().usersPrivilegesOperations()
                .getPrivilegesAssociatedWithGroup(TEST_ACCOUNTNAME, TEST_OWNER, TEST_GROUPSLUG);
        //then
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
    }

    @Test
    public void testRemovePrivilegeGroup() throws Exception {
        assertTrue(false);
        //given
        //when
        bitBucket.usersOperations().usersPrivilegesOperations().removePrivilegeGroup(TEST_ACCOUNTNAME, TEST_OWNER, TEST_GROUPSLUG);
        //then
    }
}
package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.social.bitbucket.api.BitBucketInvitation;

import java.util.List;

import static org.junit.Assert.assertTrue;

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
        //get-pending-invitations
        //given
        //when
        List<BitBucketInvitation> result = bitBucket.usersOperations().usersInvitationsOperations().getPendingInvitations(TEST_ACCOUNTNAME);
        //then
    }

    @Test
    public void testGetPendingInvitationsForEmail() throws Exception {
        assertTrue(false);
//        get-pending-invitations-for-email
        //given
        //when
        List<BitBucketInvitation> result = bitBucket.usersOperations().usersInvitationsOperations()
                .getPendingInvitationsForEmail(TEST_ACCOUNTNAME, TEST_EMAIL);
        //then
    }

    @Test
    public void testGetPendingInvitationForGroupMembership() throws Exception {
        assertTrue(false);
        //
        //given
        //when
        boolean result = bitBucket.usersOperations().usersInvitationsOperations()
                .getPendingInvitationForGroupMembership(TEST_ACCOUNTNAME, TEST_GROUPOWNER, TEST_GROUPSLUG, TEST_EMAIL);
        //then
    }

    @Test
    public void testIssueInvitationToGroup() throws Exception {
        assertTrue(false);
        //
        //given
        //when
        boolean result = bitBucket.usersOperations().usersInvitationsOperations()
                .issueInvitationToGroup(TEST_ACCOUNTNAME, TEST_GROUPOWNER, TEST_GROUPSLUG, TEST_EMAIL);
        //then
    }

    @Test
    public void testRemoveInitationByEmail() throws Exception {
        assertTrue(false);
        //given
        //when
        bitBucket.usersOperations().usersInvitationsOperations().removeInitationByEmail(TEST_ACCOUNTNAME, TEST_EMAIL);
        //then
    }

    @Test
    public void testRemoveInvitationByGroup() throws Exception {
        assertTrue(false);
        //given
        //when
        bitBucket.usersOperations().usersInvitationsOperations().removeInvitationByGroup(TEST_ACCOUNTNAME, TEST_GROUPOWNER, TEST_GROUPSLUG, TEST_EMAIL);
        //then
    }
}
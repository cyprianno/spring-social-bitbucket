package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.social.bitbucket.api.BitBucketEvent;
import org.springframework.social.bitbucket.api.BitBucketUser;
import org.springframework.social.bitbucket.api.UserWithRepositories;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class UsersAccountTemplateTest extends BaseTemplateTest {

    private static final String TEST_USERNAME = "username";

    @Test
    public void testGetProfileUnauthenticated() throws Exception {
        assertTrue(false);
        //get-profile-unauthenticated
        //given
        //when
        UserWithRepositories result = bitBucket.usersOperations().usersAccountOperations().getProfile(TEST_USERNAME);
        //then
    }

    @Test
    public void testGetProfileAuthenticated() throws Exception {
        assertTrue(false);
        //get-profile-authenticated
        //given
        //when
        UserWithRepositories result = bitBucket.usersOperations().usersAccountOperations().getProfile(TEST_USERNAME);
        //then
    }

    @Test
    public void testGetPlan() throws Exception {
        assertTrue(false);
        //get-plan
        //given
        //when
        Long result = bitBucket.usersOperations().usersAccountOperations().getPlan(TEST_USERNAME);
        //then
    }

    @Test
    public void testGetFollowers() throws Exception {
        assertTrue(false);
        //get-followers
        //given
        //when
        List<BitBucketUser> result = bitBucket.usersOperations().usersAccountOperations().getFollowers(TEST_USERNAME);
        //then
    }

    @Test
    public void testGetEvents() throws Exception {
        assertTrue(false);
        //get-events
        //given
        //when
        List<BitBucketEvent> result = bitBucket.usersOperations().usersAccountOperations().getEvents(TEST_USERNAME);
        //then
    }
}
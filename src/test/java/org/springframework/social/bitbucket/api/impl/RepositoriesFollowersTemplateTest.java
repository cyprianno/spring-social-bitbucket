package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesFollowersTemplateTest extends BaseTemplateTest {
    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";
    private static final String TEST_NODE = "testnode";
    @Test
    public void testGetFollowers() throws Exception {
        assertTrue(false);
        //get-list-repo-followers
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesFollowersOperations().getFollowers(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertTrue(false);
    }
}
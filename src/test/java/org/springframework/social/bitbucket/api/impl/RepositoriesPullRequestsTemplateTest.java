package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesPullRequestsTemplateTest extends BaseTemplateTest {

    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";

    @Test
    public void testPostNewComment() throws Exception {
        assertTrue(false);
        //post-pullrequest-comment
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesPullRequestsOperations().postNewComment(TEST_USERNAME, TEST_REPOSLUG, 1L, "ccontent");
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testUpdateComment() throws Exception {
        assertTrue(false);
        //put-pullrequest-comment
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesPullRequestsOperations().updateComment(TEST_USERNAME, TEST_REPOSLUG, 1L, 2L, "ucontent");
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testRemoveComment() throws Exception {
        assertTrue(false);
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesPullRequestsOperations().removeComment(TEST_USERNAME, TEST_REPOSLUG, 1L, 2L);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testToggleSpam() throws Exception {
        assertTrue(false);
        //toggle-pullrequest-comment-spam
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesPullRequestsOperations().toggleSpam(TEST_USERNAME, TEST_REPOSLUG, 1L, 2L);
        //then
        mockServer.verify();
        assertTrue(false);
    }
}
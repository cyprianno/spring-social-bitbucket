package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.social.bitbucket.api.BitBucketComment;

import static org.junit.Assert.*;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesChangesetsTemplateTest extends BaseTemplateTest {

    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";
    private static final String TEST_NODE = "testnode";

    @Test
    public void testGetChangesets() throws Exception {
        assertTrue(false);
        //get-changesets
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesChangesetsOperations().getChangesets(TEST_USERNAME, TEST_REPOSLUG, "1", 10);
        //then
        mockServer.verify();

    }

    @Test
    public void testGetChangeset() throws Exception {
        assertTrue(false);
        //get-changeset
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesChangesetsOperations().getChangeset(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE);
        //then
        mockServer.verify();

    }

    @Test
    public void testGetStatistics() throws Exception {
        assertTrue(false);
        //get-statistics
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesChangesetsOperations().getStatistics(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE);
        //then
        mockServer.verify();

    }

    @Test
    public void testGetDiff() throws Exception {
        assertTrue(false);
        //get-diff
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesChangesetsOperations().getDiff(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE);
        //then
        mockServer.verify();

    }

    @Test
    public void testGetComments() throws Exception {
        assertTrue(false);
        //get-comments
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesChangesetsOperations().getComments(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE);
        //then
        mockServer.verify();

    }

    @Test
    public void testRemoveComment() throws Exception {
        assertTrue(false);
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesChangesetsOperations().removeComment(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE, 1L);
        //then
        mockServer.verify();

    }

    @Test
    public void testPostComment() throws Exception {
        assertTrue(false);
        //post comment
        //given
        BitBucketComment comment = BitBucketComment.builder().content("content").build();
        //when
        bitBucket.repositoriesOperations().repositoriesChangesetsOperations().postComment(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE, comment);
        //then
        mockServer.verify();

    }

    @Test
    public void testUpdateComment() throws Exception {
        assertTrue(false);
        //put-comment-update
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesChangesetsOperations().updateComment(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE, 1L);
        //then
        mockServer.verify();

    }

    @Test
    public void testToogleSpamComment() throws Exception {
        assertTrue(false);
        //toggle-changeset-comment-spam
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesChangesetsOperations().toggleSpamComment(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE, 1L);
        //then
        mockServer.verify();

    }
}
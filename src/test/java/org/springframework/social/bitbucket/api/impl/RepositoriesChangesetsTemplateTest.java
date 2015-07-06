package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketChangeset;
import org.springframework.social.bitbucket.api.BitBucketChangesets;
import org.springframework.social.bitbucket.api.BitBucketComment;
import org.springframework.social.bitbucket.api.BitBucketRepositoryStatistics;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

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
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets?limit=10&start=nodestart"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-changesets"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketChangesets> result = bitBucket.repositoriesOperations().repositoriesChangesetsOperations().getChangesets(TEST_USERNAME, TEST_REPOSLUG,
                "nodestart", 10);
        //then
        mockServer.verify();
        assertNotNull(result);
        //TODO
        assertTrue(false);
        assertEquals(10, result.size());
    }

    @Test
    public void testGetChangeset() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-changeset"), MediaType.APPLICATION_JSON));
        //when
        BitBucketChangeset result = bitBucket.repositoriesOperations().repositoriesChangesetsOperations()
                .getChangeset(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertTrue(false);
    }

    @Test
    public void testGetStatistics() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/diffstat"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-statistics"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketRepositoryStatistics> result = bitBucket.repositoriesOperations().repositoriesChangesetsOperations()
                .getStatistics(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertTrue(false);
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
        assertTrue(false);
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
        assertTrue(false);
    }

    @Test
    public void testRemoveComment() throws Exception {
        assertTrue(false);
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesChangesetsOperations().removeComment(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
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
        assertTrue(false);
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
        assertTrue(false);
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
        assertTrue(false);
    }
}
package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketChangeset;
import org.springframework.social.bitbucket.api.BitBucketComment;
import org.springframework.social.bitbucket.api.BitBucketDiff;
import org.springframework.social.bitbucket.api.BitBucketFileModificationType;
import org.springframework.social.bitbucket.api.BitBucketRepositoryStatistics;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
public class RepositoriesChangesetsTemplateTest extends BaseTemplateTest {

    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";
    private static final String TEST_NODE = "testnode";
    private static final DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd HH:mm:ssZ");

    @Test
    public void testGetChangesets() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets?limit=10&start=nodestart"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-changesets"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketChangeset> result = bitBucket.repositoriesOperations().repositoriesChangesetsOperations()
                .getChangesets(TEST_USERNAME, TEST_REPOSLUG, 10, "nodestart");
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(2, result.size());
        BitBucketChangeset firstElement = result.iterator().next();
        //Two "node" fields in sample response.
        //assertEquals("712e4a5e776f", firstElement.getNode());
        assertEquals("712e4a5e776fbb4c7f0660a5fd8c2f152e787d90", firstElement.getNode());
        assertEquals(1, firstElement.getFiles().size());
        BitBucketChangeset.FileModification firstFile = firstElement.getFiles().iterator().next();
        assertEquals(BitBucketFileModificationType.added, firstFile.getType());
        assertEquals("Readme", firstFile.getFile());
        assertEquals("Your Name <manthony@bitbucket.org>", firstElement.getRawAuthor());
        assertEquals(-1, firstElement.getSize());
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
        //Two "node" fields in sample response.
        //assertEquals("abdeaf1b2b4a", firstElement.getNode());
        assertEquals("abdeaf1b2b4a6b9ddf742c1e1754236380435a62", result.getNode());
        assertEquals(2, result.getFiles().size());
        BitBucketChangeset.FileModification firstFile = result.getFiles().get(0);
        assertEquals(BitBucketFileModificationType.added, firstFile.getType());
        assertEquals("AnotherFile.txt", firstFile.getFile());
        BitBucketChangeset.FileModification secondFile = result.getFiles().get(1);
        assertEquals(BitBucketFileModificationType.modified, secondFile.getType());
        assertEquals("Readme", secondFile.getFile());
        assertEquals("Mary Anthony <manthony@172-28-13-105.staff.sf.atlassian.com>", result.getRawAuthor());
        String expectedStringDateAsGMT = "2012-07-23 22:26:36+0000";
        Date expectedDate = dateFormatter.parse(expectedStringDateAsGMT, Locale.getDefault());
        assertEquals(expectedDate, result.getUtcTimestamp());
        assertEquals("abdeaf1b2b4a6b9ddf742c1e1754236380435a62", result.getNode());
        assertEquals(1, result.getParents().size());
        assertEquals("86432202a2d5", result.getParents().iterator().next());
        assertEquals("master", result.getBranch());
        assertEquals("making some changes\n", result.getMessage());
        assertNull(result.getRevision());
        assertEquals(-1, result.getSize());
    }

    @Test
    public void testGetStatistics() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/diffstat"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-statistics"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketRepositoryStatistics> result = bitBucket.repositoriesOperations().repositoriesChangesetsOperations()
                .getStatistics(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(3, result.size());
        BitBucketRepositoryStatistics firstElement = result.iterator().next();
        assertEquals(BitBucketFileModificationType.added, firstElement.getType());
        assertEquals("AnotherFile.txt", firstElement.getFile());
        assertEquals((Long) 0L, firstElement.getDiffstat().getRemoved());
        assertEquals((Long) 0L, firstElement.getDiffstat().getAdded());
    }

    @Test
    public void testGetDiff() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/diff"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-diff"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketDiff> result = bitBucket.repositoriesOperations().repositoriesChangesetsOperations().getDiff(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE);
        //then
        mockServer.verify();
        assertEquals(1, result.size());
        BitBucketDiff firstElement = result.iterator().next();
        assertEquals(100, firstElement.getFromLinesPerPage());
        assertEquals(10, firstElement.getFromPagesPerBlock());
        assertEquals(null, firstElement.getNote());
    }

    @Test
    public void testGetComments() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketComment> result = bitBucket.repositoriesOperations().repositoriesChangesetsOperations()
                .getComments(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE);
        //then
        mockServer.verify();
        assertEquals(2, result.size());
        assertEquals(25570L, result.iterator().next().getCommentId());
    }

    @Test
    public void testRemoveComment() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments/1")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesChangesetsOperations().removeComment(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE, 1L);
        //then
        mockServer.verify();
    }

    @Test
    public void testPostComment() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/ssh-keys")).andExpect(method(POST)).andExpect(
                content().string("content=content&parent_id=1")).andRespond(withSuccess(jsonResource("post-comment"), MediaType.APPLICATION_JSON));
        String content = "content";
        long parentId = 2L;
        //when
        BitBucketComment result = bitBucket.repositoriesOperations().repositoriesChangesetsOperations()
                .postComment(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE, content, parentId);
        //then
        mockServer.verify();
        assertEquals("buserbb", result.getUsername());
    }

    @Test
    public void testUpdateComment() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/emails/test@email.tld")).andExpect(method(PUT))
                .andExpect(content().string("content=newcontent")).andRespond(withSuccess(jsonResource("put-comment-update"), MediaType.APPLICATION_JSON));
        String content = "newcontent";
        //when
        BitBucketComment result = bitBucket.repositoriesOperations().repositoriesChangesetsOperations()
                .updateComment(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE, 1L, content);
        //then
        mockServer.verify();
        assertEquals("buserbb", result.getUsername());
    }

    @Test
    public void testToogleSpamComment() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/emails/test@email.tld")).andExpect(method(PUT))
                .andExpect(content().string("primary=true")).andRespond(withSuccess(jsonResource("toggle-changeset-comment-spam"), MediaType.APPLICATION_JSON));
        //when
        BitBucketComment result = bitBucket.repositoriesOperations().repositoriesChangesetsOperations()
                .toggleSpamComment(TEST_USERNAME, TEST_REPOSLUG, TEST_NODE, 1L);
        //then
        mockServer.verify();
        assertEquals("buserbb", result.getUsername());
    }
}
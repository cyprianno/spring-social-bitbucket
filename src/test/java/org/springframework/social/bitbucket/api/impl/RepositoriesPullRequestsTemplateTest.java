package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketComment;

import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withNoContent;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Cyprian Śniegota
 * @author Łucja Śniegota
 * @since 2.0.0
 */
public class RepositoriesPullRequestsTemplateTest extends BaseTemplateTest {

    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";

    @Test
    public void testPostNewComment() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/pullrequests/1/comments")).andExpect(method(POST)).andExpect(
                content().string("content=ccontent")).andRespond(withSuccess(jsonResource("post-pullrequest-comment"), MediaType.APPLICATION_JSON));
        //when
        BitBucketComment result = bitBucket.repositoriesOperations().repositoriesPullRequestsOperations().postNewComment(TEST_USERNAME, TEST_REPOSLUG, 1L, "ccontent");
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals("tutorials", result.getUsername());
        assertEquals(672L, result.getPullRequestId());
        assertEquals(14356L, result.getCommentId());
        assertEquals("tutorials", result.getDisplayName());
        assertNull(result.getParentId());
        assertFalse(result.isDeleted());
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd HH:mm:ssZ");
        String expectedStringDateAsGMT = "2012-08-12 20:04:38+0000";
        Date expectedDate = dateFormatter.parse(expectedStringDateAsGMT, Locale.getDefault());
        assertEquals(expectedDate, result.getUtcLastUpdated());
        assertNull(result.getFilenameHash());
        assertEquals("174eecac678c", result.getBaseRev());
        assertNull(result.getFilename());
        assertEquals("This is yet another comment", result.getContent());
        assertEquals("<p>This is yet another comment</p>\n", result.getContentRendered());
        assertEquals("https://secure.gravatar.com/avatar/0bc5bd490000b8e63c35c0f54e667b9e?d=identicon&s=32", result.getUserAvatarUrl());
        assertNull(result.getLineFrom());
        assertNull(result.getLineTo());
        assertEquals("101f16a95c13", result.getDestRev());
        expectedStringDateAsGMT = "2012-08-12 20:04:38+0000";
        expectedDate = dateFormatter.parse(expectedStringDateAsGMT, Locale.getDefault());
        assertEquals(expectedDate, result.getUtcCreatedOn());
        assertEquals("a18fd07465b5", result.getAnchor());
        assertFalse(result.isSpam());
    }

    @Test
    public void testUpdateComment() throws Exception {

        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/pullrequests/1/comments/2")).andExpect(method(PUT))
                .andExpect(content().string("content=ucontent")).andRespond(withSuccess(jsonResource("put-pullrequest-comment"), MediaType.APPLICATION_JSON));
        //when
        BitBucketComment result = bitBucket.repositoriesOperations().repositoriesPullRequestsOperations().updateComment(TEST_USERNAME, TEST_REPOSLUG, 1L, 2L, "ucontent");
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals("tutorials", result.getUsername());
        assertEquals(672L, result.getPullRequestId());
        assertEquals(14356L, result.getCommentId());
        assertEquals("tutorials", result.getDisplayName());
        assertNull(result.getParentId());
        assertFalse(result.isDeleted());
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd HH:mm:ssZ");
        String expectedStringDateAsGMT = "2012-08-12 20:04:38+0000";
        Date expectedDate = dateFormatter.parse(expectedStringDateAsGMT, Locale.getDefault());
        assertEquals(expectedDate, result.getUtcLastUpdated());
        assertNull(result.getFilenameHash());
        assertEquals("174eecac678c", result.getBaseRev());
        assertNull(result.getFilename());
        assertEquals("This is an update to my comment.", result.getContent());
        assertEquals("<p>This is an update to my comment.</p>\n", result.getContentRendered());
        assertEquals("https://secure.gravatar.com/avatar/0bc5bd490000b8e63c35c0f54e667b9e?d=identicon&s=32", result.getUserAvatarUrl());
        assertNull(result.getLineFrom());
        assertNull(result.getLineTo());
        assertEquals("101f16a95c13", result.getDestRev());
        expectedStringDateAsGMT = "2012-08-12 20:04:38+0000";
        expectedDate = dateFormatter.parse(expectedStringDateAsGMT, Locale.getDefault());
        assertEquals(expectedDate, result.getUtcCreatedOn());
        assertEquals("a18fd07465b5", result.getAnchor());
        assertFalse(result.isSpam());
    }

    @Test
    public void testRemoveComment() throws Exception {

        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/pullrequests/1/comments/2")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesPullRequestsOperations().removeComment(TEST_USERNAME, TEST_REPOSLUG, 1L, 2L);
        //then
        mockServer.verify();

    }

    @Test
    public void testToggleSpam() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/pullrequests/1/comments/spam/2")).andExpect(method(PUT))
                .andRespond(withSuccess(jsonResource("toggle-pullrequest-comment-spam"), MediaType.APPLICATION_JSON));
        //when
        BitBucketComment result = bitBucket.repositoriesOperations().repositoriesPullRequestsOperations().toggleSpam(TEST_USERNAME, TEST_REPOSLUG, 1L, 2L);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals("auserbb", result.getUsername());
        assertEquals("abdeaf1b2b4a", result.getNode());
        assertEquals(25720L, result.getCommentId());
        assertEquals("A User", result.getDisplayName());
        assertEquals((Long) 25711L, result.getParentId());
        assertFalse(result.isDeleted());
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd HH:mm:ssZ");
        String expectedStringDateAsGMT = "2012-07-24 21:39:12+0000";
        Date expectedDate = dateFormatter.parse(expectedStringDateAsGMT, Locale.getDefault());
        assertEquals(expectedDate, result.getUtcLastUpdated());
        assertEquals("36e1237b957fa2002d264c5fd031c547", result.getFilenameHash());
        assertEquals("Readme", result.getFilename());
        assertEquals("what the eff", result.getContent());
        assertEquals("<p>what the eff</p>\n", result.getContentRendered());
        assertEquals("https://secure.gravatar.com/avatar/49bd0ee69e520e8bc250adb95710bbb8?d=identicon&s=32", result.getUserAvatarUrl());
        assertEquals((Long) 3L, result.getLineFrom());
        assertEquals((Long) 6L, result.getLineTo());
        expectedStringDateAsGMT = "2012-07-24 21:06:33+0000";
        expectedDate = dateFormatter.parse(expectedStringDateAsGMT, Locale.getDefault());
        assertEquals(expectedDate, result.getUtcCreatedOn());
        assertFalse(result.isSpam());
    }
}
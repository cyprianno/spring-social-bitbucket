package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;

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
        assertTrue(false);
        //post-pullrequest-comment
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/ssh-keys")).andExpect(method(POST)).andExpect(
                content().string("key=123123123")).andRespond(withSuccess(jsonResource("post-key"), MediaType.APPLICATION_JSON));
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
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/emails/test@email.tld")).andExpect(method(PUT))
                .andExpect(content().string("primary=true")).andRespond(withSuccess(jsonResource("update-email-address"), MediaType.APPLICATION_JSON));
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
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/invitations/test@email.tld")).andExpect(method(DELETE))
                .andRespond(withNoContent());
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
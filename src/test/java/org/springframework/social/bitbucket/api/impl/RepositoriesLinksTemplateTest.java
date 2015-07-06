package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketLink;

import static org.junit.Assert.*;
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
public class RepositoriesLinksTemplateTest extends BaseTemplateTest {

    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";

    @Test
    public void testGetLinks() throws Exception {
        assertTrue(false);
        //get-links
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesLinksOperations().getLinks(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetLink() throws Exception {
        assertTrue(false);
        //get-link
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesLinksOperations().getLink(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testPostNewLink() throws Exception {
        assertTrue(false);
        //post-link
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/ssh-keys")).andExpect(method(POST)).andExpect(
                content().string("key=123123123")).andRespond(withSuccess(jsonResource("post-key"), MediaType.APPLICATION_JSON));
        BitBucketLink.BitBucketLinkHandler handler = BitBucketLink.BitBucketLinkHandler.builder().name("handlername").build();
        BitBucketLink link = BitBucketLink.builder().handler(handler).build();
        //when
        bitBucket.repositoriesOperations().repositoriesLinksOperations().postNewLink(TEST_USERNAME, TEST_REPOSLUG, link);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testUpdateLink() throws Exception {
        assertTrue(false);
        //put-link
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/emails/test@email.tld")).andExpect(method(PUT))
                .andExpect(content().string("primary=true")).andRespond(withSuccess(jsonResource("update-email-address"), MediaType.APPLICATION_JSON));
        BitBucketLink.BitBucketLinkHandler handler = BitBucketLink.BitBucketLinkHandler.builder().name("handlername").build();
        BitBucketLink link = BitBucketLink.builder().handler(handler).build();
        //when
        bitBucket.repositoriesOperations().repositoriesLinksOperations().updateLink(TEST_USERNAME, TEST_REPOSLUG, 1L, link);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testRemoveLink() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/invitations/test@email.tld")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesLinksOperations().removeLink(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }
}
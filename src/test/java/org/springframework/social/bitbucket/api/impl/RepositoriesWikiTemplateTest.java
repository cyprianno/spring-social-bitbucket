package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesWikiTemplateTest extends BaseTemplateTest {

    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";

    @Test
    public void testGetContent() throws Exception {
        assertTrue(false);
        //get-wiki-raw-content
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesWikiOperations().getContent(TEST_USERNAME, TEST_REPOSLUG, "/home/page");
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testPostNewPage() throws Exception {
        assertTrue(false);
        //OK
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/ssh-keys")).andExpect(method(POST)).andExpect(
                content().string("key=123123123")).andRespond(withSuccess(jsonResource("post-key"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesWikiOperations().postNewPage(TEST_USERNAME, TEST_REPOSLUG, "/home/newpage", "Content");
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testUpdatePage() throws Exception {
        assertTrue(false);
        //OK
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/emails/test@email.tld")).andExpect(method(PUT))
                .andExpect(content().string("primary=true")).andRespond(withSuccess(jsonResource("update-email-address"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesWikiOperations().updatePage(TEST_USERNAME, TEST_REPOSLUG, "/home/newpage", "new content");
        //then
        mockServer.verify();
        assertTrue(false);
    }
}
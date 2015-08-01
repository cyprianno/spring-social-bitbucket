package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketMarkup;
import org.springframework.social.bitbucket.api.BitBucketWikipage;

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
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/wiki/home/page"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-wiki-raw-content"), MediaType.APPLICATION_JSON));
        //when
        BitBucketWikipage result = bitBucket.repositoriesOperations().repositoriesWikiOperations().getContent(TEST_USERNAME, TEST_REPOSLUG, "/home/page");
        //then
        mockServer.verify();
        assertEquals("This is inline text: {{{<<file index.html>>}}} followed by more.\n\nTrying to get back to the tutorial for this project? It's here: https://confluence.atlassian.com/display/BITBUCKET/Bitbucket+101\n\n[Two](Two)", result.getData());
        assertEquals(BitBucketMarkup.markdown, result.getMarkup());
        assertEquals("e9247a427a2eba5fa01158ea4aedb6045f2a59dc", result.getRev());
    }

    @Test
    public void testPostNewPage() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/wiki/home/newpage")).andExpect(method(POST)).andExpect(
                content().string("content=Content")).andRespond(withSuccess("OK", MediaType.TEXT_PLAIN));
        //when
        boolean result = bitBucket.repositoriesOperations().repositoriesWikiOperations().postNewPage(TEST_USERNAME, TEST_REPOSLUG, "/home/newpage", "Content");
        //then
        mockServer.verify();
        assertTrue(result);
    }

    @Test
    public void testUpdatePage() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/wiki/home/newpage")).andExpect(method(PUT))
                .andExpect(content().string("content=new content")).andRespond(withSuccess("OK", MediaType.TEXT_PLAIN));
        //when
        boolean result = bitBucket.repositoriesOperations().repositoriesWikiOperations().updatePage(TEST_USERNAME, TEST_REPOSLUG, "/home/newpage", "new content");
        //then
        mockServer.verify();
        assertTrue(result);
    }
}
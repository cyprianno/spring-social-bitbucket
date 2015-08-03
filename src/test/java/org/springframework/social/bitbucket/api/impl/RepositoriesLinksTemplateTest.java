package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucket;
import org.springframework.social.bitbucket.api.BitBucketLink;
import org.springframework.social.bitbucket.api.BitBucketRepository;
import org.springframework.social.bitbucket.api.command.LinkCreateUpdate;

import java.util.List;

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
 * @author Łucja Śniegota
 * @since 2.0.0
 */
public class RepositoriesLinksTemplateTest extends BaseTemplateTest {

    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";

    @Test
    public void testGetLinks() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/links"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-links"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketLink> result = bitBucket.repositoriesOperations().repositoriesLinksOperations().getLinks(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(2, result.size());
        BitBucketLink firstBucketLink = result.get(0);
        BitBucketLink.BitBucketLinkHandler handler = firstBucketLink.getHandler();
        assertEquals("http://172-28-13-105.staff.sf.atlassian.com:2990/jira/browse/\\1", handler.getDisplayTo());
        assertEquals("http://172-28-13-105.staff.sf.atlassian.com:2990/jira/browse/\\1", handler.getReplacementUrl());
        assertEquals("(?<!\\w)([A-Z|a-z]{2,}-\\d+)(?!\\w)", handler.getRawRegex());
        assertEquals("custom", handler.getName());
        assertEquals("Custom ((?<!\\w)([A-Z|a-z]{2,}-\\d+)(?!\\w))", handler.getDisplayFrom());
        assertEquals(25991L, firstBucketLink.getId());
    }

    @Test
    public void testGetLink() throws Exception {


        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/links/1"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-link"), MediaType.APPLICATION_JSON));
        //when
        BitBucketLink result = bitBucket.repositoriesOperations().repositoriesLinksOperations().getLink(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertNotNull(result);
        BitBucketLink.BitBucketLinkHandler handler = result.getHandler();
        assertEquals("http://172-28-13-105.staff.sf.atlassian.com:2990/jira/browse/\\1", handler.getDisplayTo());
        assertEquals("http://172-28-13-105.staff.sf.atlassian.com:2990/jira/browse/\\1", handler.getReplacementUrl());
        assertEquals("(?<!\\w)([A-Z|a-z]{2,}-\\d+)(?!\\w)", handler.getRawRegex());
        assertEquals("custom", handler.getName());
        assertEquals("Custom ((?<!\\w)([A-Z|a-z]{2,}-\\d+)(?!\\w))", handler.getDisplayFrom());
        assertEquals(25991L, result.getId());
    }

    @Test
    public void testPostNewLink() throws Exception {

        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/links")).andExpect(method(POST)).andExpect(
                content().string("name=handlername")).andRespond(withSuccess(jsonResource("post-link"), MediaType.APPLICATION_JSON));
        LinkCreateUpdate link = new LinkCreateUpdate(null, null, "handlername");
        //when
        BitBucketLink result = bitBucket.repositoriesOperations().repositoriesLinksOperations().postNewLink(TEST_USERNAME, TEST_REPOSLUG, link);
        //then
        mockServer.verify();
        assertNotNull(result);
        BitBucketLink.BitBucketLinkHandler handlerResult = result.getHandler();
        assertEquals("http://yourjira.com/", handlerResult.getUrl());
        assertEquals("JIRA (PROJ)", handlerResult.getDisplayFrom());
        assertEquals("jira", handlerResult.getName());
        assertEquals("PROJ", handlerResult.getKey());
        assertEquals("http://yourjira.com/", handlerResult.getDisplayTo());
        assertEquals(87L, result.getId());

    }

    @Test
    public void testUpdateLink() throws Exception {

        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/links/1")).andExpect(method(PUT))
                .andExpect(content().string("name=handlername")).andRespond(withSuccess(jsonResource("put-link"), MediaType.APPLICATION_JSON));
        LinkCreateUpdate link = new LinkCreateUpdate(null, null, "handlername");
        //when
        BitBucketLink result = bitBucket.repositoriesOperations().repositoriesLinksOperations().updateLink(TEST_USERNAME, TEST_REPOSLUG, 1L, link);
        //then
        mockServer.verify();
        assertNotNull(result);
        BitBucketLink.BitBucketLinkHandler handlerResult = result.getHandler();
        assertEquals("http://yourjira.com/", handlerResult.getUrl());
        assertEquals("JIRA (BB)", handlerResult.getDisplayFrom());
        assertEquals("jira", handlerResult.getName());
        assertEquals("BB", handlerResult.getKey());
        assertEquals("http://yourjira.com/", handlerResult.getDisplayTo());
        assertEquals(87L, result.getId());
    }

    @Test
    public void testRemoveLink() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/links/1")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesLinksOperations().removeLink(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();

    }
}
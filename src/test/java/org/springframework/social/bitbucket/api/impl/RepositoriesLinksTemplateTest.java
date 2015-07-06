package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.social.bitbucket.api.BitBucketLink;

import static org.junit.Assert.*;

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
        //when
        bitBucket.repositoriesOperations().repositoriesLinksOperations().removeLink(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }
}
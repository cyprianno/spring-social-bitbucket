package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;

import static org.junit.Assert.*;

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
        //when
        bitBucket.repositoriesOperations().repositoriesWikiOperations().getContent(TEST_USERNAME, TEST_REPOSLUG, "/home/page");
        //then
        mockServer.verify();

    }

    @Test
    public void testPostNewPage() throws Exception {
        assertTrue(false);
        //OK
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesWikiOperations().postNewPage(TEST_USERNAME, TEST_REPOSLUG, "/home/newpage", "Content");
        //then
        mockServer.verify();

    }

    @Test
    public void testUpdatePage() throws Exception {
        assertTrue(false);
        //OK
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesWikiOperations().updatePage(TEST_USERNAME, TEST_REPOSLUG, "/home/newpage", "new content");
        //then
        mockServer.verify();

    }
}
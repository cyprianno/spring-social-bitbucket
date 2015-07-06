package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesSrcTemplateTest extends BaseTemplateTest {
    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";
    @Test
    public void testGetElements() throws Exception {
        assertTrue(false);
        //get-list-repo-source
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesSrcOperations().getElements(TEST_USERNAME, TEST_REPOSLUG, "xrev", "/src/file.txt");
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetContent() throws Exception {
        assertTrue(false);
        //get-raw-content
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesSrcOperations().getContent(TEST_USERNAME, TEST_REPOSLUG, "xrev", "/src/file.txt");
        //then
        mockServer.verify();
        assertTrue(false);
    }
}
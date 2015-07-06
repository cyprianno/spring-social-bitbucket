package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesDeployKeysTemplateTest extends BaseTemplateTest {
    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";
    private static final String TEST_NODE = "testnode";

    @Test
    public void testGetDeployKeys() throws Exception {
        assertTrue(false);
        //get-keys
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesDeployKeysOperations().getDeployKeys(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();

    }

    @Test
    public void testGetDeployKey() throws Exception {
        assertTrue(false);
        //get-key
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesDeployKeysOperations().getDeployKey(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();

    }

    @Test
    public void testPostDeployKey() throws Exception {
        assertTrue(false);
        //post-key
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesDeployKeysOperations().postDeployKey(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();

    }

    @Test
    public void testRemoveDeployKey() throws Exception {
        assertTrue(false);
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesDeployKeysOperations().removeDeployKey(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();

    }
}
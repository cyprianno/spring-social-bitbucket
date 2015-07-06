package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.social.bitbucket.api.BitBucketRepository;

import static org.junit.Assert.*;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesRepositoryTemplateTest extends BaseTemplateTest {
    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";

    @Test
    public void testCreateNewFork() throws Exception {
        assertTrue(false);
        //post-repository-fork
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().createNewFork(TEST_USERNAME, TEST_REPOSLUG, "fname", "fdesc", "php", true);
        //then
        mockServer.verify();

    }

    @Test
    public void testUpdateRepository() throws Exception {
        assertTrue(false);
        //put-repository
        //given
        BitBucketRepository repository = BitBucketRepository.builder().description("desc").build();
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().updateRepository(TEST_USERNAME, TEST_REPOSLUG, repository);
        //then
        mockServer.verify();

    }

    @Test
    public void testGetBranches() throws Exception {
        assertTrue(false);
        //get-branches
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getBranches(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();

    }

    @Test
    public void testGetMainBranch() throws Exception {
        assertTrue(false);
        //get-main-branch
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getMainBranch(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();

    }

    @Test
    public void testGetBranchesTags() throws Exception {
        assertTrue(false);
        //get-branches-tags
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getBranchesTags(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();

    }

    @Test
    public void testGetManifest() throws Exception {
        assertTrue(false);
        //get-repository-manifest
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getManifest(TEST_USERNAME, TEST_REPOSLUG, "revasdf");
        //then
        mockServer.verify();

    }

    @Test
    public void testGetTags() throws Exception {
        assertTrue(false);
        //get-repository-tags
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getTags(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();

    }

    @Test
    public void testGetRawSource() throws Exception {
        assertTrue(false);
        //get-repository-raw-source
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getRawSource(TEST_USERNAME, TEST_REPOSLUG, "revasdf", "/src/main/file.txt");
        //then
        mockServer.verify();

    }

    @Test
    public void testGetHistoryOfFile() throws Exception {
        assertTrue(false);
        //get-repository-history-file
        //given
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getHistoryOfFile(TEST_USERNAME, TEST_REPOSLUG, "testnode", "/src/main/file.txt");
        //then
        mockServer.verify();

    }
}
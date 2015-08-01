package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketRepository;

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
public class RepositoriesRepositoryTemplateTest extends BaseTemplateTest {
    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";

    @Test
    public void testCreateNewFork() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/ssh-keys")).andExpect(method(POST)).andExpect(
                content().string("key=123123123")).andRespond(withSuccess(jsonResource("post-repository-fork"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().createNewFork(TEST_USERNAME, TEST_REPOSLUG, "fname", "fdesc", "php", true);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testUpdateRepository() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/emails/test@email.tld")).andExpect(method(PUT))
                .andExpect(content().string("primary=true")).andRespond(withSuccess(jsonResource("put-repository"), MediaType.APPLICATION_JSON));
        BitBucketRepository repository = BitBucketRepository.builder().description("desc").build();
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().updateRepository(TEST_USERNAME, TEST_REPOSLUG, repository);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetBranches() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-branches"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getBranches(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetMainBranch() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-main-branch"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getMainBranch(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetBranchesTags() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-branches-tags"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getBranchesTags(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetManifest() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-repository-manifest"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getManifest(TEST_USERNAME, TEST_REPOSLUG, "revasdf");
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetTags() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-repository-tags"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getTags(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetRawSource() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-repository-raw-source"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getRawSource(TEST_USERNAME, TEST_REPOSLUG, "revasdf", "/src/main/file.txt");
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetHistoryOfFile() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-repository-history-file"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getHistoryOfFile(TEST_USERNAME, TEST_REPOSLUG, "testnode", "/src/main/file.txt");
        //then
        mockServer.verify();
        assertTrue(false);
    }
}
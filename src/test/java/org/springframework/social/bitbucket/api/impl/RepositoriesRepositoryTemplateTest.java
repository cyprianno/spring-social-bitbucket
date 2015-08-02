package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketBranch;
import org.springframework.social.bitbucket.api.BitBucketBranchesTags;
import org.springframework.social.bitbucket.api.BitBucketRepository;
import org.springframework.social.bitbucket.api.BitBucketSCM;
import org.springframework.social.bitbucket.api.command.RepositoryCreateUpdate;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/fork")).andExpect(method(POST)).andExpect(
                content().string("name=mynewrepo")).andRespond(withSuccess(jsonResource("post-repository-fork"), MediaType.APPLICATION_JSON));
        //when
        BitBucketRepository result = bitBucket.repositoriesOperations().repositoriesRepositoryOperations().createNewFork(TEST_USERNAME, TEST_REPOSLUG, "fname", "fdesc", "php", true);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(BitBucketSCM.hg, result.getScm());
        assertTrue(result.isHasWiki());
    }

    @Test
    public void testUpdateRepository() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug")).andExpect(method(PUT))
                .andExpect(content().string("description=long description")).andRespond(withSuccess(jsonResource("put-repository"), MediaType.APPLICATION_JSON));
        RepositoryCreateUpdate repository = new RepositoryCreateUpdate("desc");
        //when
        BitBucketRepository result = bitBucket.repositoriesOperations().repositoriesRepositoryOperations().updateRepository(TEST_USERNAME, TEST_REPOSLUG, repository);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(BitBucketSCM.hg, result.getScm());
        assertTrue(result.isHasWiki());
    }

    @Test
    public void testGetBranches() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/branches"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-branches"), MediaType.APPLICATION_JSON));
        //when
        Map<String, BitBucketBranch> result = bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getBranches(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertEquals(1, result.size());
        assertEquals("master", result.keySet().iterator().next());
        BitBucketBranch firstValue = result.values().iterator().next();
        assertEquals("0b64d6000dad", firstValue.getNode());
    }

    @Test
    public void testGetMainBranch() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/main-branch"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-main-branch"), MediaType.APPLICATION_JSON));
        //when
        String result = bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getMainBranch(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertEquals("master", result);
    }

    @Test
    public void testGetBranchesTags() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/branches-tags"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-branches-tags"), MediaType.APPLICATION_JSON));
        //when
        BitBucketBranchesTags result = bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getBranchesTags(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertEquals(1, result.getTags().size());
        assertEquals(1, result.getBranches().size());
    }

    @Test
    public void testGetManifest() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/revasdf"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-repository-manifest"), MediaType.APPLICATION_JSON));
        //when
        Map<String, String> result = bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getManifest(TEST_USERNAME, TEST_REPOSLUG, "revasdf");
        //then
        mockServer.verify();
        assertEquals(2, result.size());
        Iterator<String> keys = result.keySet().iterator();
        assertEquals("Readme", keys.next());
        assertEquals("index.html", keys.next());
        Iterator<String> values = result.values().iterator();
        assertEquals("cfed61d1bfe1", values.next());
        assertEquals("2151785dae36", values.next());
    }

    @Test
    public void testGetTags() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/tags"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-repository-tags"), MediaType.APPLICATION_JSON));
        //when
        Map<String, BitBucketBranch> tags = bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getTags(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertEquals(1, tags.size());
        assertEquals("tip", tags.keySet().iterator().next());
        BitBucketBranch firstTag = tags.values().iterator().next();
        assertEquals("562344e0ae10", firstTag.getNode());
    }

    @Test
    public void testGetRawSource() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/raw/revasdf/src/main/file.txt"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-repository-raw-source"), MediaType.APPLICATION_JSON));
        //when
        String result = bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getRawSource(TEST_USERNAME, TEST_REPOSLUG, "revasdf", "/src/main/file.txt");
        //then
        mockServer.verify();
        assertEquals("xyz", result);
    }

    @Test
    public void testGetHistoryOfFile() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/filehistory/testnode/src/main/file.txt"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-repository-history-file"), MediaType.APPLICATION_JSON));
        //when
        BitBucketBranch result = bitBucket.repositoriesOperations().repositoriesRepositoryOperations().getHistoryOfFile(TEST_USERNAME, TEST_REPOSLUG, "testnode", "/src/main/file.txt");
        //then
        mockServer.verify();
        assertEquals("1b8a451e04ec", result.getNode());
    }
}
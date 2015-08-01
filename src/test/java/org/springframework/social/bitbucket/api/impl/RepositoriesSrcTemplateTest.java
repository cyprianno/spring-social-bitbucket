package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketFile;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesSrcTemplateTest extends BaseTemplateTest {
    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";
    @Test
    public void testGetElements() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/src/xrev/src/file.txt"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-list-repo-source"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketFile> result = bitBucket.repositoriesOperations().repositoriesSrcOperations().getElements(TEST_USERNAME, TEST_REPOSLUG, "xrev", "/src/file.txt");
        //then
        mockServer.verify();
        assertEquals(1, result.size());
        BitBucketFile firstFile = result.iterator().next();
        assertEquals("40e232b389b9", firstFile.getNode());
        assertEquals("Readme", firstFile.getPath());
        assertEquals("Favorite Quotes from bitbuckians\n--------------------\n\nThis page lists \n", firstFile.getData());
        assertEquals(571L, firstFile.getSize());
    }

    @Test
    public void testGetContent() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/raw/xrev/src/file.txt"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-raw-content"), MediaType.APPLICATION_JSON));
        //when
        String result = bitBucket.repositoriesOperations().repositoriesSrcOperations().getContent(TEST_USERNAME, TEST_REPOSLUG, "xrev", "/src/file.txt");
        //then
        mockServer.verify();
        assertEquals("Favorite Quotes from bitbuckians\n--------------------\n\nThis page lists \n", result);
    }
}
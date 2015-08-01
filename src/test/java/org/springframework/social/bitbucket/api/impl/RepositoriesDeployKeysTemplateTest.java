package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketDeployKey;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
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
public class RepositoriesDeployKeysTemplateTest extends BaseTemplateTest {
    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";
    private static final String TEST_NODE = "testnode";

    @Test
    public void testGetDeployKeys() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/deploy-keys"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-keys"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketDeployKey> result = bitBucket.repositoriesOperations().repositoriesDeployKeysOperations()
                .getDeployKeys(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(1, result.size());
        BitBucketDeployKey firstDeployKey = result.iterator().next();
        assertEquals(171052L, firstDeployKey.getPk());
        assertEquals("ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDMl/FZf5AtrJBth+8swfDfJrRWetHHnew/LTwX86OGdcG4sJWE5QpWzO9K+szpxaFmMF72"
                + "9bKAUBMBWNoPrYApayyalirpe7fjzHqIWoq5CsP/wKDVSyMxVOiBwBnXSukS7i9iOiC2J5PyEQwAq7GJXI3E2UWyymW7rVyaDdYKLH9PdUMNmLf"
                + "BpsDUyjdGO40pLjr6KCiyOTLI07Qy5iVz44VTRm6IBlxhee0DV3gw4GADHllSRVVOOngO+3453543sgfsfgsgsffgs3345345DFG346qi4WTeEC"
                + "B6JH87FhdCGS6mFyavpvOnrZdR9jGD auserbb", firstDeployKey.getKey());
        assertEquals("home", firstDeployKey.getLabel());
    }

    @Test
    public void testGetDeployKey() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/deploy-keys/1"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-key"), MediaType.APPLICATION_JSON));
        //when
        BitBucketDeployKey result = bitBucket.repositoriesOperations().repositoriesDeployKeysOperations()
                .getDeployKey(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(171052L, result.getPk());
        assertEquals("home", result.getLabel());
        assertNotNull(result.getKey());
    }

    @Test
    public void testPostDeployKey() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/deploy-keys")).andExpect(method(POST)).andExpect(
                content().string("key=123123123")).andRespond(withSuccess(jsonResource("post-key"), MediaType.APPLICATION_JSON));
        //when
        BitBucketDeployKey result = bitBucket.repositoriesOperations().repositoriesDeployKeysOperations().postDeployKey(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(171052L, result.getPk());
        assertEquals("home", result.getLabel());
        assertNotNull(result.getKey());
    }

    @Test
    public void testRemoveDeployKey() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/deploy-keys")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesDeployKeysOperations().removeDeployKey(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();

    }
}
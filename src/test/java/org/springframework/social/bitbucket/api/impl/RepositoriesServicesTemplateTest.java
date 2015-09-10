/**
 * Copyright (C) 2012 Eric Bottard / Guillaume Lederrey (eric.bottard+ghpublic@gmail.com / guillaume.lederrey@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketService;

import java.util.*;

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
 * @since 2.0.0
 */
public class RepositoriesServicesTemplateTest extends BaseTemplateTest {

    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";

    @Test
    public void testGetServices() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/services"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-services"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketService> result = bitBucket.repositoriesOperations().repositoriesServicesOperations().getServices(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertEquals(2, result.size());
        BitBucketService firstService = result.iterator().next();
        assertEquals(3L, firstService.getId());
        assertNotNull(firstService.getService());
        assertEquals("Email", firstService.getService().getType());
    }

    @Test
    public void testGetService() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/services/1"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-service"), MediaType.APPLICATION_JSON));
        //when
        BitBucketService result = bitBucket.repositoriesOperations().repositoriesServicesOperations().getService(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(4L, result.getId());
        assertEquals("POST", result.getService().getType());
        assertEquals(1, result.getService().getFields().size());
        BitBucketService.BitBucketServiceProfileField firstField = result.getService().getFields().iterator().next();
        assertEquals("URL", firstField.getName());
        assertEquals("http://example.com/post", firstField.getValue());
    }

    @Test
    public void testPostNewService() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/services")).andExpect(method(POST)).andExpect(
                content().string("type=POST&URL=https%3A%2F%2Fbitbucket.org%2Fpost")).andRespond(withSuccess(jsonResource("post-service"), MediaType.APPLICATION_JSON));
        Map<String, String> fields = Collections.singletonMap("URL", "https://bitbucket.org/post");
        //when
        BitBucketService result = bitBucket.repositoriesOperations().repositoriesServicesOperations().postNewService(TEST_USERNAME, TEST_REPOSLUG, "POST", fields);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(5L, result.getId());
        assertEquals("POST", result.getService().getType());
        assertEquals(1, result.getService().getFields().size());
        BitBucketService.BitBucketServiceProfileField firstField = result.getService().getFields().iterator().next();
        assertEquals("URL", firstField.getName());
        assertEquals("https://bitbucket.org/post", firstField.getValue());
    }

    @Test
    public void testUpdateService() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/services/1")).andExpect(method(PUT))
                .andExpect(content().string("URL=https%3A%2F%2Fbitbucket.org%2Fpost")).andRespond(withSuccess(jsonResource("put-service"), MediaType.APPLICATION_JSON));
        Map<String, String> fields = Collections.singletonMap("URL", "https://bitbucket.org/post");
        //when
        BitBucketService result = bitBucket.repositoriesOperations().repositoriesServicesOperations().updateService(TEST_USERNAME, TEST_REPOSLUG, 1L, fields);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(5L, result.getId());
        assertEquals("POST", result.getService().getType());
        assertEquals(1, result.getService().getFields().size());
        BitBucketService.BitBucketServiceProfileField firstField = result.getService().getFields().iterator().next();
        assertEquals("URL", firstField.getName());
        assertEquals("https://bitbucket.org/new_post", firstField.getValue());
    }

    @Test
    public void testRemoveService() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/services/1")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesServicesOperations().removeService(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
    }
}
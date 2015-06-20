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
import org.springframework.social.bitbucket.api.BitBucketConsumer;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
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
public class UsersConsumersTemplateTest extends BaseTemplateTest {

    private static final String TEST_USERNAME = "testusername";
    private static final long TEST_ID = 2976;
    private static final String TEST_NAME = "testname";
    private static final String TEST_DESCRIPTION = "testdesc";
    private static final String TEST_URL = "testurl";

    @Test
    public void testGetConsumers() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testusername/consumers")).andExpect(method(GET)).andRespond(
                withSuccess(jsonResource("get-consumers"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketConsumer> result = bitBucket.usersOperations().usersConsumersOperations().getConsumers(TEST_USERNAME);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(2, result.size());
        BitBucketConsumer firstConsumer = result.iterator().next();
        assertEquals("", firstConsumer.getDescription());
        assertEquals(22779L, firstConsumer.getId());
        assertEquals("y9spXwJKNcygKdWBH2", firstConsumer.getKey());
        assertEquals("TestDVCS", firstConsumer.getName());
        assertEquals("bQWTaGRpT9RhB24TQWYP9M2LcvZy9Pkw", firstConsumer.getSecret());
        assertEquals("", firstConsumer.getUrl());
    }

    @Test
    public void testGetConsumer() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testusername/consumers/2976")).andExpect(method(GET)).andRespond(
                withSuccess(jsonResource("get-consumer"), MediaType.APPLICATION_JSON));
        //when
        BitBucketConsumer result = bitBucket.usersOperations().usersConsumersOperations().getConsumer(TEST_USERNAME, TEST_ID);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals("", result.getDescription());
        assertEquals(22779L, result.getId());
        assertEquals("y9spXwJKNcygKdWBH2", result.getKey());
        assertEquals("TestDVCS", result.getName());
        assertEquals("bQWTaGRpT9RhB24TQWYP9M2LcvZy9Pkw", result.getSecret());
        assertEquals("", result.getUrl());
    }

    @Test
    public void testUpdateConsumer() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testusername/2976")).andExpect(method(PUT)).andExpect(
                content().string("name=testname&description=testdesc&url=testurl")).andRespond(
                withSuccess(jsonResource("update-consumer"), MediaType.APPLICATION_JSON));
        //when
        BitBucketConsumer result = bitBucket.usersOperations().usersConsumersOperations()
                .updateConsumer(TEST_USERNAME, TEST_ID, TEST_NAME, TEST_DESCRIPTION, TEST_URL);
        //then
        mockServer.verify();
        assertEquals("here", result.getDescription());
    }

    @Test
    public void testRemoveConsumer() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testusername/consumers/2976")).andExpect(method(DELETE)).andRespond(withNoContent());
        //when
        bitBucket.usersOperations().usersConsumersOperations().removeConsumer(TEST_USERNAME, TEST_ID);
        //then
        mockServer.verify();
    }
}
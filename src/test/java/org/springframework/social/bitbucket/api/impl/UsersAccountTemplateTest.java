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
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketEvent;
import org.springframework.social.bitbucket.api.BitBucketUser;
import org.springframework.social.bitbucket.api.UserWithRepositories;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class UsersAccountTemplateTest extends BaseTemplateTest {

    private static final String TEST_USERNAME = "testusername";

    @Test
    public void testGetProfileUnauthenticated() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testusername")).andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("get-profile-unauthenticated"), MediaType.APPLICATION_JSON));
        //when
        UserWithRepositories result = bitBucket.usersOperations().usersAccountOperations().getProfile(TEST_USERNAME);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(1, result.getRepositories().size());
        assertEquals("User", result.getUser().getLastName());
        assertNull(result.getUser().getTeam());
    }

    @Test
    public void testGetProfileAuthenticated() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testusername")).andExpect(method(GET)).andRespond(
                withSuccess(jsonResource("get-profile-authenticated"), MediaType.APPLICATION_JSON));
        //when
        UserWithRepositories result = bitBucket.usersOperations().usersAccountOperations().getProfile(TEST_USERNAME);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(2, result.getRepositories().size());
        assertEquals("User", result.getUser().getLastName());
        assertNotNull(result.getUser().getTeam());
    }

    @Test
    public void testGetPlan() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testusername/plan")).andExpect(method(GET)).andRespond(
                withSuccess(jsonResource("get-plan"), MediaType.APPLICATION_JSON));
        //when
        long result = bitBucket.usersOperations().usersAccountOperations().getPlan(TEST_USERNAME);
        //then
        mockServer.verify();
        assertEquals(3L, result);
    }

    @Test
    public void testGetFollowers() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testusername/followers")).andExpect(method(GET)).andRespond(
                withSuccess(jsonResource("get-followers"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketUser> result = bitBucket.usersOperations().usersAccountOperations().getFollowers(TEST_USERNAME);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(3, result.size());

    }

    @Test
    public void testGetEvents() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testusername/events")).andExpect(method(GET)).andRespond(
                withSuccess(jsonResource("get-events"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketEvent> result = bitBucket.usersOperations().usersAccountOperations().getEvents(TEST_USERNAME);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(2, result.size());
        BitBucketEvent firstEvent = result.iterator().next();
        assertNull(firstEvent.getNode());
        assertNull(firstEvent.getDescription());
        assertNotNull(firstEvent.getUser());
        assertNotNull(firstEvent.getRepository());
        assertEquals("pullrequest_fulfilled", firstEvent.getEvent());
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd HH:mm:ssZ");
        Date expectedDate = dateFormatter.parse("2013-02-20 00:15:53+0000", Locale.getDefault());
        assertEquals(expectedDate, firstEvent.getCreatedOn());
        Date expectedDateUtc = dateFormatter.parse("2013-02-19 23:15:53+0000", Locale.getDefault());
        assertEquals(expectedDateUtc, firstEvent.getUtcCreatedOn());
    }
}
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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author ericbottard
 * @author Cyprian Śniegota
 */
public class UserTemplateTest extends BaseTemplateTest {

    @Test
    public void testGetUser() throws Exception {
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/user")).andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("get-user"), MediaType.APPLICATION_JSON));

        UserWithRepositories profile = bitBucket.userOperations()
                .getUserWithRepositories();

        assertEquals("ericbottard", profile.getUser().getUsername());
        assertEquals("Eric", profile.getUser().getFirstName());
        assertEquals("Bottard", profile.getUser().getLastName());
        assertEquals(
                "https://secure.gravatar.com/avatar/9adf9e4ee93fea30ea27b469cfa3bae8?d=identicon&s=32",
                profile.getUser().getAvatarImageUrl());

        assertEquals(3, profile.getRepositories().size());
        BitBucketRepository repo = profile.getRepositories().iterator().next();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        assertEquals(sdf.parse("2011-11-20 18:25:29"), repo.getCreatedAt());
        assertEquals("ericbottard", repo.getOwner());
        assertEquals(BitBucketSCM.git, repo.getScm());
        assertTrue(repo.isHasWiki());
        assertEquals(29397517L, repo.getSize());
        assertFalse(repo.isReadOnly());
        assertTrue(repo.isPrivate());
        assertEquals(sdf.parse("2012-02-20 21:29:16+00:00"),
                repo.getLastUpdatedOn());

    }

    @Test
    public void testGetUserFollowers() throws Exception {
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/cleonello/followers"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("user-followers"), MediaType.APPLICATION_JSON));

        List<BitBucketUser> followers = bitBucket.userOperations()
                .getFollowers("cleonello");
        assertEquals(11, followers.size());
        BitBucketUser follower = followers.get(0);

        assertEquals("tobami", follower.getUsername());
        assertEquals("Miquel", follower.getFirstName());
        assertEquals("Torres", follower.getLastName());
        assertEquals(
                "https://secure.gravatar.com/avatar/a804ab4bb149c5c612a087e75d2c656c?d=identicon&s=32",
                follower.getAvatarImageUrl());
    }

    @Test
    public void testUpdateUser() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/user"))
                .andExpect(method(PUT)).andExpect(content().string("first_name=fname&last_name=lname"))
                .andRespond(withSuccess(jsonResource("update-user"), MediaType.APPLICATION_JSON));
        BitBucketUser testUserProfile = new ObjectMapper().readValue(
                "{\"username\":\"testuser\",\"first_name\":\"fname\",\"last_name\":\"lname\"}", BitBucketUser.class);
        //when
        BitBucketUser result = bitBucket.userOperations().updateUser(testUserProfile);
        //then
        mockServer.verify();
        assertEquals("auserbb", result.getUsername());
        assertEquals("foo", result.getFirstName());
        assertEquals("User", result.getLastName());
        assertFalse(result.getTeam());
        assertEquals("https://secure.gravatar.com/avatar/49bd0ee69e520e8bc250adb95710bbb8?d=identicon&s=32", result.getAvatarImageUrl());
//        assertEquals("/1.0/users/auserbb", result.getResourceURI());
    }

    @Test
    public void testGetUserPrivileges() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/user/privileges"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("get-user-privileges"), MediaType.APPLICATION_JSON));
        //when
        Map<String, String> result = bitBucket.userOperations().getUserPrivileges();
        //then
        mockServer.verify();
        assertEquals(3, result.size());
        assertTrue(result.containsKey("auserbb"));
        assertTrue(result.containsKey("1team"));
        assertTrue(result.containsKey("2team"));
        assertTrue(result.containsValue("admin"));
        assertTrue(result.containsValue("collaborator"));
        assertTrue(result.containsValue("admin"));
    }

    @Test
    public void testGetRepositoriesAccountFollows() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/user/follows"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("get-repositories-account-follows"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketRepository> result = bitBucket.userOperations().getRepositoriesAccountFollows();
        //then
        mockServer.verify();
        assertEquals(3, result.size());
        BitBucketRepository firstRepository = result.iterator().next();
        assertEquals(BitBucketSCM.git, firstRepository.getScm());
        assertFalse(firstRepository.isHasWiki());
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd HH:mm:ssZ");
        Date utcCreatedOn = dateFormatter.parse("2012-06-26 22:22:15+0000", Locale.getDefault());
        Date utcLastUpdated = dateFormatter.parse("2012-06-26 22:22:15+0000", Locale.getDefault());
        assertEquals(utcLastUpdated, firstRepository.getLastUpdatedOn());
        assertEquals(utcCreatedOn, firstRepository.getCreatedAt());
        assertEquals("1team", firstRepository.getOwner());
        assertNull(firstRepository.getLogo());
        assertEquals("", firstRepository.getEmailMailingList());
        assertFalse(firstRepository.isMq());
        assertEquals(580L, firstRepository.getSize());
        assertEquals(false, firstRepository.isReadOnly());
        assertNull(firstRepository.getForkOf());//repo
        assertNull(firstRepository.getMqOf());
        assertEquals(2L, firstRepository.getFollowersCount());
        assertEquals("available", firstRepository.getState());
        assertEquals("", firstRepository.getWebsite());
        assertEquals("", firstRepository.getDescription());
        assertFalse(firstRepository.isHasIssues());
        assertFalse(firstRepository.isFork());
        assertEquals("justdirectteam", firstRepository.getSlug());
        assertTrue(firstRepository.isPrivate());
        assertEquals("justdirectteam", firstRepository.getName());
        assertEquals("", firstRepository.getLanguage());
        assertTrue(firstRepository.isEmailWriters());
        assertFalse(firstRepository.isNoPublicForks());
        assertEquals("/1.0/repositories/1team/justdirectteam", firstRepository.getResourceUri());
    }

    @Test
    public void testGetRepositoriesVisible() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/user/repositories"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("get-repositories-visible"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketRepository> result = bitBucket.userOperations().getRepositoriesVisible();
        //then
        mockServer.verify();
        assertEquals(3, result.size());
        BitBucketRepository firstRepository = result.iterator().next();
        assertEquals(BitBucketSCM.git, firstRepository.getScm());
        assertFalse(firstRepository.isHasWiki());
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd HH:mm:ssZ");
        Date utcCreatedOn = dateFormatter.parse("2012-06-26 22:22:15+0000", Locale.getDefault());
        Date utcLastUpdated = dateFormatter.parse("2012-06-26 22:22:15+0000", Locale.getDefault());
        assertEquals(utcLastUpdated, firstRepository.getLastUpdatedOn());
        assertEquals(utcCreatedOn, firstRepository.getCreatedAt());
        assertEquals("1team", firstRepository.getOwner());
    }

    @Test
    public void testGetRepositoriesFollowing() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/user/repositories/overview"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("get-repositories-following"), MediaType.APPLICATION_JSON));
        //when
        BitBucketFollowingRepositories result = bitBucket.userOperations().getRepositoriesFollowing();
        //then
        mockServer.verify();
//        assertEquals(3, result.size());
        BitBucketRepository firstRepository = result.getUpdated().iterator().next();//result.iterator().next();
        assertNull(firstRepository.getScm());
//        assertNull(firstRepository.isHasWiki());
        assertTrue(firstRepository.isPrivate());
        assertEquals("auserbb", firstRepository.getOwner());
        assertEquals("auser-justdirectteam", firstRepository.getName());
        assertEquals("auser-justdirectteam", firstRepository.getSlug());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetRepositoriesOnDashboard() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/user/repositories/dashboard"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("get-repositories-on-dashboard"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketRepository> result = bitBucket.userOperations().getRepositoriesOnDashboard();
        //then
        mockServer.verify();
    }
}

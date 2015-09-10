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
import org.springframework.social.bitbucket.api.BitBucketUser;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Cyprian Śniegota
 * @author Łucja Śniegota
 * @since 2.0.0
 */
public class RepositoriesFollowersTemplateTest extends BaseTemplateTest {
    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";
    private static final String TEST_NODE = "testnode";
    @Test
    public void testGetFollowers() throws Exception {

        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/followers"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-list-repo-followers"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketUser> result = bitBucket.repositoriesOperations().repositoriesFollowersOperations().getFollowers(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(4, result.size());
        BitBucketUser firstBucketUser = result.get(0);
        assertEquals("Saage", firstBucketUser.getUsername());
        assertEquals("Rodrigo", firstBucketUser.getFirstName());
        assertEquals(false, firstBucketUser.getTeam());
        assertEquals("https://secure.gravatar.com/avatar/f9c6710cefefb1eb9903d5a076135dc6?d=identicon&s=32", firstBucketUser.getAvatarImageUrl());
        assertEquals("/1.0/users/Saage", firstBucketUser.getResourceUri());
    }
}
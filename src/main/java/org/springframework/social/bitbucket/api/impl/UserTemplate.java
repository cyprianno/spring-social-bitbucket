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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.*;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * @author ericbottard
 * @author Cyprian Śniegota
 */
class UserTemplate extends AbstractBitBucketOperations implements
        UserOperations {

    public UserTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public UserWithRepositories getUserWithRepositories() {
        return getRestTemplate().getForObject(buildUrl("/user"),
                UserWithRepositories.class);
    }

    @Override
    public BitBucketUser updateUser(BitBucketUser userProfileDataToUpdate) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/user"), HttpMethod.PUT, new HttpEntity<>(
                new UpdateUserParameters(userProfileDataToUpdate.getFirstName(), userProfileDataToUpdate.getLastName(),
                        userProfileDataToUpdate.getAvatarImageUrl()), httpHeaders), BitBucketUser.class).getBody();
    }

    @Override
    public Map<String, String> getUserPrivileges() {
        return getRestTemplate().getForObject(buildUrl("/user/privileges"), PrivilegesHolder.class).getTeams();
    }

    @Override
    public List<BitBucketRepository> getRepositoriesAccountFollows() {
        return asList(getRestTemplate().getForObject(
                buildUrl("/user/follows"), BitBucketRepository[].class));
    }

    @Override
    public List<BitBucketRepository> getRepositoriesVisible() {
        return asList(getRestTemplate().getForObject(
                buildUrl("/user/repositories"), BitBucketRepository[].class));
    }

    @Override
    public BitBucketFollowingRepositories getRepositoriesFollowing() {
        return getRestTemplate().getForObject(
                buildUrl("/user/repositories/overview"), BitBucketFollowingRepositories.class);
    }

    @Override
    public List<BitBucketRepository> getRepositoriesOnDashboard() {
        throw new UnsupportedOperationException(
                "Get repositories on dashboard is not implemented. Json source is not readable.");
    }

    @Override
    public List<BitBucketUser> getFollowers(String user) {
        return getRestTemplate().getForObject(buildUrl("/users/{user}/followers"),
                FollowersHolder.class, user).getFollowers();
    }

    private static final class UpdateUserParameters extends ParameterMap {
        public UpdateUserParameters(String firstName, String lastName, String avatarImageUrl) {
            if (avatarImageUrl != null) {
                add("avatar_image_url", avatarImageUrl);
            }
            if (firstName != null) {
                add("first_name", firstName);
            }
            if (lastName != null) {
                add("last_name", lastName);
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static final class FollowersHolder {
        @JsonProperty @Getter
        private List<BitBucketUser> followers;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static final class PrivilegesHolder {
        @JsonProperty @Getter
        private Map<String, String> teams = new HashMap<>();
    }

}

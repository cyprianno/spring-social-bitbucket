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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketGroup;
import org.springframework.social.bitbucket.api.BitBucketPrivilege;
import org.springframework.social.bitbucket.api.BitBucketUser;
import org.springframework.social.bitbucket.api.GroupsOperations;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class GroupsTemplate extends AbstractBitBucketOperations implements GroupsOperations {

    public GroupsTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketGroup> getAListOfGroups(String accountName) {
        return asList(getRestTemplate().getForObject(buildUrl("/groups/{accountname}"), BitBucketGroup[].class, accountName));
    }

    @Override
    public final BitBucketGroup postANewGroup(String accountName, String name) {
        return getRestTemplate().postForObject(buildUrl("/groups/{accountname}"), new GroupCreate(name), BitBucketGroup.class, accountName);
    }

    @Override
    public final BitBucketGroup updateAGroup(String accountName, String name, String groupSlug, Boolean autAdd, BitBucketPrivilege permission) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GroupUpdate> requestEntity = new HttpEntity<>(new GroupUpdate(name, permission, autAdd), httpHeaders);
        return getRestTemplate().exchange(
                buildUrl("/groups/{accountname}/{group_slug}"),
                HttpMethod.PUT, requestEntity,
                BitBucketGroup.class, accountName, groupSlug).getBody();
    }

    @Override
    public final void removeGroup(String accountName, String groupSlug) {
        getRestTemplate().delete(buildUrl("/groups/{accountname}/{group_slug}"), accountName, groupSlug);
    }

    @Override
    public final List<BitBucketUser> getTheGroupMembers(String accountName, String groupSlug) {
        return asList(getRestTemplate().getForObject(buildUrl("/groups/{accountname}/{group_slug}/members"), BitBucketUser[].class, accountName, groupSlug));
    }

    @Override
    public final BitBucketUser putNewMemberIntoAGroup(String accountName, String groupSlug, String memberName) {
        return getRestTemplate()
                .exchange(buildUrl("/groups/{accountname}/{group_slug}/members/{membername}"), HttpMethod.PUT, null, BitBucketUser.class, accountName,
                        groupSlug, memberName).getBody();
    }

    @Override
    public final void removeMember(String accountName, String groupSlug, String memberName) {
        getRestTemplate().delete(buildUrl("/groups/{accountname}/{group_slug}/members/{membername}"), accountName, groupSlug, memberName);
    }

    private static final class GroupCreate extends ParameterMap {

        public GroupCreate(String name) {
            set("name", name);
        }

        public String getName() {
            return getFirst("name");
        }
    }

    private static final class GroupUpdate {

        @JsonProperty @Getter
        private final String name;
        @JsonProperty @Getter
        private final BitBucketPrivilege permission;
        @JsonProperty(value = "auto_add") @Getter
        private final Boolean autoAdd;

        public GroupUpdate(String nameParam, BitBucketPrivilege permissionParam, Boolean autoAddParam) {
            this.name = nameParam;
            this.permission = permissionParam;
            this.autoAdd = autoAddParam;
        }
    }

}

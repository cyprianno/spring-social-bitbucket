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

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.social.bitbucket.api.BitBucketTeamPrivilege;
import org.springframework.social.bitbucket.api.UsersPrivilegesOperations;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class UsersPrivilegesTemplate extends AbstractBitBucketOperations implements UsersPrivilegesOperations {
    public UsersPrivilegesTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final Map<String, BitBucketTeamPrivilege> getPrigilegeGroupOnTeamAccount(String accountName, String groupSlug) {
        return getRestTemplate().getForObject(buildUrl("/users/{accountname}/privileges"), TeamPrivilegeHolder.class, accountName);
    }

    @Override
    public final BitBucketTeamPrivilege getPrivilegesAssociatedWithGroup(String accountName, String owner, String groupSlug) {
        return getRestTemplate()
                .getForObject(buildUrl("/users/{accountname}/privileges/{owner}/{group_slug}"), TeamPrivilegeHolder.class, accountName, owner, groupSlug)
                .get("privilege");
    }

    @Override
    public final Map<String, BitBucketTeamPrivilege> updateGroupPrivilegesOnTeamAccount(String accountName, String owner, String groupSlug,
            BitBucketTeamPrivilege privilege) {
        return getRestTemplate().exchange(buildUrl("/users/{accountname}/privileges/{owner}/{group_slug}"), HttpMethod.PUT,
                new HttpEntity<>("privileges=" + privilege.toString()), TeamPrivilegeHolder.class, accountName, owner, groupSlug).getBody();
    }

    @Override
    public final Map<String, BitBucketTeamPrivilege> postNewPrivilege(String accountName, String owner, String groupSlug, BitBucketTeamPrivilege privilege) {
        return getRestTemplate()
                .postForObject(buildUrl("/users/{accountname}/privileges/{owner}/{group_slug}"), new HttpEntity<>("privileges=" + privilege.name()),
                        TeamPrivilegeHolder.class, accountName, owner, groupSlug);
    }

    @Override
    public final void removePrivilegeGroup(String accountName, String owner, String groupSlug) {
        getRestTemplate().delete(buildUrl("/users/{accountname}/privileges/{owner}/{group_slug}"), accountName, owner, groupSlug);
    }

    private static final class TeamPrivilegeHolder extends HashMap<String, BitBucketTeamPrivilege> {
    }
}

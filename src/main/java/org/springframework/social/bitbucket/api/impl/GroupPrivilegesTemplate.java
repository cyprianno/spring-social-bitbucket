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
import org.springframework.social.bitbucket.api.BitBucketPrivilege;
import org.springframework.social.bitbucket.api.BitBucketPrivilegeGroup;
import org.springframework.social.bitbucket.api.GroupPrivilegesOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class GroupPrivilegesTemplate extends AbstractBitBucketOperations implements GroupPrivilegesOperations {

    public GroupPrivilegesTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketPrivilegeGroup> getPrivilegedGroups(String accountName) {
        return asList(getRestTemplate().getForObject(buildUrl("/group-privileges/{accountname}"), BitBucketPrivilegeGroup[].class, accountName));
    }

    @Override
    public final List<BitBucketPrivilegeGroup> getPrivilegedGroupsForRepository(String accountName, String repoSlug) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/group-privileges/{accountname}/{repo_slug}"), BitBucketPrivilegeGroup[].class, accountName, repoSlug));
    }

    @Override
    public final List<BitBucketPrivilegeGroup> getGroupOnRepository(String accountName, String repoSlug, String groupOwner, String groupSlug) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/group-privileges/{accountname}/{repo_slug}/{group_owner}/{group_slug}"), BitBucketPrivilegeGroup[].class, accountName,
                        repoSlug, groupOwner, groupSlug));
    }

    @Override
    public final List<BitBucketPrivilegeGroup> getListOfRepositoriesWithPrivilegeGroup(String accountName, String groupOwner, String groupSlug) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/group-privileges/{accountname}/{group_owner}/{group_slug}"), BitBucketPrivilegeGroup[].class, accountName, groupOwner,
                        groupSlug));
    }

    @Override
    public final List<BitBucketPrivilegeGroup> updatePrivilegesGroupOnRepository(String accountName, String repoSlug, String groupOwner, String groupSlug,
            BitBucketPrivilege privilege) {
        return asList(getRestTemplate().exchange(buildUrl("/group-privileges/{accountname}/{repo_slug}/{group_owner}/{group_slug}"), HttpMethod.PUT,
                new HttpEntity<>(privilege.toString()), BitBucketPrivilegeGroup[].class, accountName, repoSlug, groupOwner, groupSlug).getBody());
    }

    @Override
    public final void removeGroupPrivilegesFromRepository(String accountName, String repoSlug, String groupOwner, String groupSlug) {
        getRestTemplate()
                .delete(buildUrl("/group-privileges/{accountname}/{repo_slug}/{group_owner}/{group_slug}"), accountName, repoSlug, groupOwner, groupSlug);
    }

    @Override
    public final void removePrivilegesForGroupAcrossAllRepositories(String accountName, String groupOwner, String groupSlug) {
        getRestTemplate().delete(buildUrl("/group-privileges/{accountname}/{group_owner}/{group_slug}"), accountName, groupOwner, groupSlug);
    }
}

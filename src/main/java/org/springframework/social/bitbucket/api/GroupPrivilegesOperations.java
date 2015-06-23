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
package org.springframework.social.bitbucket.api;

import java.util.List;

/**
 * Use the group-privileges resource to query and manipulate the group privileges (permissions)
 * of an account's repositories. An account owner (or team account administrator)
 * defines groups at the account level.
 *
 * @see "https://confluence.atlassian.com/display/BITBUCKET/group-privileges+Endpoint"
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public interface GroupPrivilegesOperations {

    /**
     * Gets an array of all the groups granted access to an account's repositories.
     * The caller must authenticate as a user with administrative rights on the account.
     * API call: GET https://bitbucket.org/api/1.0/group-privileges/{accountname}
     *
     * @param accountName The team or individual account.
     * @return a list of privileged groups
     */
    List<BitBucketPrivilegeGroup> getPrivilegedGroups(String accountName);

    /**
     * Get a list of the privilege groups for a specific repository.
     * The caller must authenticate successfully and have administrative rights on the account.
     * API call: GET https://bitbucket.org/api/1.0/group-privileges/{accountname}/{repo_slug}
     *
     * @param accountName The team or individual account.
     * @param repoSlug    A repository belonging to the account.
     * @return a list of privileged groups
     */
    List<BitBucketPrivilegeGroup> getPrivilegedGroupsForRepository(String accountName, String repoSlug);

    /**
     * Gets the privileges of a group on a repository.
     * The caller must authenticate as a user with administrative rights on the account.
     * API call: GET  https://bitbucket.org/api/1.0/group-privileges/{accountname}/{repo_slug}/{group_owner}/{group_slug}
     *
     * @param accountName The team or individual account.
     * @param repoSlug    A repository belonging to the account.
     * @param groupOwner  The account that owns the group.
     * @param groupSlug   The group slug.
     * @return a list of privileged groups
     */
    List<BitBucketPrivilegeGroup> getGroupOnRepository(String accountName, String repoSlug, String groupOwner, String groupSlug);

    /**
     * Get a list of the repositories on which a particular privilege group appears.
     * This method operates on a single account, it does not list across acounts.
     * The caller must authenticate as a user with administrative rights on the account.
     * API call: GET https://bitbucket.org/api/1.0/group-privileges/{accountname}/{group_owner}/{group_slug}
     *
     * @param accountName The team or individual account.
     * @param groupOwner  The account that owns the group.
     * @param groupSlug   The group slug.
     * @return a list of privileged groups
     */
    List<BitBucketPrivilegeGroup> getListOfRepositoriesWithPrivilegeGroup(String accountName, String groupOwner, String groupSlug);

    /**
     * Grant group privileges on a repository with a PUT method.
     * The caller must authenticate as a user with administrative rights on the account.
     * API call: PUT https://bitbucket.org/api/1.0/group-privileges/{accountname}/{repo_slug}/{group_owner}/{group_slug}
     * --data "{privilege}"
     *
     * @param accountName The team or individual account.
     * @param repoSlug    A repository belonging to the account.
     * @param groupOwner  The account that owns the group.
     * @param groupSlug   The group slug.
     * @param privilege   A privilege value
     * @return a list of privileged groups
     */
    List<BitBucketPrivilegeGroup> updatePrivilegesGroupOnRepository(String accountName, String repoSlug, String groupOwner, String groupSlug, BitBucketPrivilege privilege);

    /**
     * DELETE a privilege group from a repository.  The caller must authenticate as a user with administrative rights on the account.
     * API call: DELETE https://bitbucket.org/api/1.0/group-privileges/{accountname}/{repo_slug}/{group_owner}/{group_slug}
     *
     * @param accountName The team or individual account.
     * @param repoSlug    The repository to grant privileges on.
     * @param groupOwner  The account that owns the group.
     * @param groupSlug   The group slug.
     */
    void removeGroupPrivilegesFromRepository(String accountName, String repoSlug, String groupOwner, String groupSlug);

    /**
     * Deletes the privileges for a group on every repository where it appears.  The caller must authenticate as a user with administrative rights on the account.
     * API call: DELETE https://bitbucket.org/api/1.0/group-privileges/{accountname}/group_owner}/{group_slug}
     *
     * @param accountName The team or individual account.
     * @param groupOwner  The account that owns the group.
     * @param groupSlug   The group slug.
     */
    void removePrivilegesForGroupAcrossAllRepositories(String accountName, String groupOwner, String groupSlug);
}


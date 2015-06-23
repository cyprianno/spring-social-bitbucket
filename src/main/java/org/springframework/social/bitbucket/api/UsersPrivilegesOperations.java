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

import java.util.Map;

/**
 * Use this resource to manage privilege settings for a team account.
 * Team accounts can grant groups account privileges as well as repository access.
 * Groups with account privileges are those with can administer this account (admin rights) or can create repositories in this account (collaborator rights)
 * You can make these calls on an individual account but the result is an empty set. This is because individual accounts do not let you set account privileges.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/privileges+Resource"
 * @since 2.0.0
 */
public interface UsersPrivilegesOperations {
    /**
     * Gets the groups with account privileges defined for a team account.
     * Administer rights automatically include collaborator rights.
     * If you have a group without either option set, it is omitted from the results.
     * The caller must authenticate.
     * The access credentials must come from an account with owner or administrative privileges — either the team account
     * access credentials or a member who can administer the team account.
     * API call: GET https://bitbucket.org/api/1.0/users/{accountname}/privileges
     *
     * @param accountName The team or individual account name.
     * @param groupSlug   The group's slug.
     * @return a map with group as a key, privilege as a value
     */
    Map<String, BitBucketTeamPrivilege> getPrigilegeGroupOnTeamAccount(String accountName, String groupSlug);

    /**
     * Gets the privilege associated with the specified groupname.
     * The privilege is can be either collaborator or admin. The caller must authenticate.
     * The access credentials must come from an account with owner or administrative privileges — either the team account
     * access credentials or a member who can administer the team account.
     * API call: GET https://bitbucket.org/api/1.0/users/{accountname}/privileges/{owner}/{group_slug}
     *
     * @param accountName The team or individual account name.
     * @param owner       The account that owns the group.
     * @param groupSlug   The group's slug.
     * @return Associated privilege.
     */
    BitBucketTeamPrivilege getPrivilegesAssociatedWithGroup(String accountName, String owner, String groupSlug);

    /**
     * Updates an existing group's privileges for a team account.
     * You can set a group's privileges to admin or collaborator.
     * This call returns the changed group. The caller must authenticate.
     * The access credentials must come from an account with owner or administrative privileges — either the team account
     * access credentials or a member who can administer the team account.
     * API call: PUT https://bitbucket.org/api/1.0/users/{accountname}/privileges/{owner}/{group_slug} --data "privileges=admin"
     *
     * @param accountName The team or individual account name.
     * @param owner       The account that owns the group.
     * @param groupSlug   The group's slug.
     * @param privilege   Either admin or collaborator.
     * @return upated privilege as key: group, value: privilege
     */
    Map<String, BitBucketTeamPrivilege> updateGroupPrivilegesOnTeamAccount(String accountName, String owner, String groupSlug,
            BitBucketTeamPrivilege privilege);

    /**
     * Adds a privilege to a group without any. The caller must authenticate.
     * The access credentials must come from an account with owner or administrative privileges — either the team account
     * access credentials or a member who can administer the team account.
     * API call: POST https://bitbucket.org/api/1.0/users/{accountname}/privileges/{owner}/{group_slug} --data "privileges=admin"
     *
     * @param accountName The team or individual account name.
     * @param owner       The account that owns the group.
     * @param groupSlug   The group's slug.
     * @param privilege   Either admin or collaborator.
     * @return Created privilege as key: group, value: privilege
     */
    Map<String, BitBucketTeamPrivilege> postNewPrivilege(String accountName, String owner, String groupSlug, BitBucketTeamPrivilege privilege);

    /**
     * Deletes a privilege. The caller must authenticate.
     * The access credentials must come from an account with owner or administrative privileges — either the team account
     * access credentials or a member who can administer the team account.
     * API call: DELETE https://bitbucket.org/api/1.0/users/{accountname}/privileges/{owner}/{group_slug}
     *
     * @param accountName The team or individual account name.
     * @param owner       The account that owns the group.
     * @param groupSlug   The group's slug.
     */
    void removePrivilegeGroup(String accountName, String owner, String groupSlug);
}

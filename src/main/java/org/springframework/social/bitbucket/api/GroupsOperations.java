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
 * The groups endpoint provides functionality for querying information about groups,
 * creating new ones, updating memberships, and deleting them.
 * Both individual and team accounts can define groups.
 * To manage group information on an individual account,
 * the caller must authenticate with administrative rights on the account.
 * To manage groups for a team account, the caller must authenticate as a team member
 * with administrative rights on the team.
 *
 * @see "https://confluence.atlassian.com/display/BITBUCKET/groups+Endpoint"
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public interface GroupsOperations {

    /**
     * Get a list of an account's groups.  The caller must authenticate with administrative rights on the account or as a group member to view a group.
     * API call: GET https://bitbucket.org/api/1.0/groups/{accountname}/
     *
     * @param accountName The team or individual account name. You can supply a user name or a valid email address.
     * @return list of groups
     */
    List<BitBucketGroup> getAListOfGroups(String accountName);

    /**
     * Creates a new group.  The caller must authenticate with administrative rights on an account to access its groups.
     * API call: POST https://bitbucket.org/api/1.0/groups/{accountname}  --data "name=string"
     *
     * @param accountName The team or individual account name. You can supply a user name or a valid email address.
     * @param name The name of the group.
     * @return newly created group
     */
    BitBucketGroup postANewGroup(String accountName, String name);

    /**
     * Updates an existing group resource. The caller must authenticate with administrative rights on the account.
     * API call: PUT https://bitbucket.org/api/1.0/groups/{accountname}/{group_slug}/  --header "Accept: application/json"
     * --data '{"name":"developers","permission":"write","auto_add":true}'
     *
     * @param accountName The team or individual account name. You can supply an account name or the primary email address for the account.
     * @param name The name of the group.
     * @param groupSlug The group's slug.
     * @param autAdd A boolean value. True to automatically add the group
     * @param permission One of read, write, or admin.
     * @return updated group
     */
    BitBucketGroup updateAGroup(String accountName, String name, String groupSlug, Boolean autAdd, BitBucketPrivilege permission);

    /**
     * Deletes a group.  The caller must authenticate with administrative rights on the account.
     * API call: DELETE https://bitbucket.org/api/1.0/groups/{accountname}/{group_slug}/
     *
     * @param accountName The team or individual account name. You can supply an account name or the primary email address for the account.
     * @param groupSlug The group's slug.
     */
    void removeGroup(String accountName, String groupSlug);

    /**
     * Gets the membership for a group. The caller must authenticate with administrative rights on the account.
     * API call: GET https://bitbucket.org/api/1.0/groups/{accountname}/{group_slug}/members
     *
     * @param accountName The team or individual account name. You can supply an account name or the primary email address for the account.
     * @param groupSlug The group's slug.
     * @return list of group members
     */
    List<BitBucketUser> getTheGroupMembers(String accountName, String groupSlug);

    /**
     * Adds a member to a group. Finally, the caller must authenticate with administrative rights on an account to access its groups.
     * API call: PUT https://bitbucket.org/api/1.0/groups/{accountname}/{group_slug}/members/{membername}
     *
     * @param accountName The team or individual account name. You can supply an account name or the primary email address for the account.
     * @param groupSlug The slug of the group.
     * @param memberName An individual account. You can supply an account name or the primary email address for the account. Account names are case sensitive.
     * @return member data
     */
    BitBucketUser putNewMemberIntoAGroup(String accountName, String groupSlug, String memberName);

    /**
     * Deletes a member from a group.  The caller must authenticate with administrative rights on the account.
     * API call: DELETE https://bitbucket.org/api/1.0/groups/{accountname}/{group_slug}/members/{membername}
     *
     * @param accountName The team or individual account name. You can supply an account name or the primary email address for the account.
     * @param groupSlug The group's slug.
     * @param memberName A individual account name. You can supply an account name or the primary email address for the account.
     */
    void removeMember(String accountName, String groupSlug, String memberName);


}

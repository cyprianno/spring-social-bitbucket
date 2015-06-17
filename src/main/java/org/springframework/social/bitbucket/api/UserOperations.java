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
import java.util.Map;

/**
 * BitBucket sub-API that allows interaction with user accounts.
 *
 * @author ericbottard
 * @author Cyprian Śniegota
 */
public interface UserOperations {

    /**
     * Returns information about the current user, as well as the list of
     * repositories he/she owns.
     * GET https://bitbucket.org/api/1.0/user
     *
     * @return user profile
     */
    UserWithRepositories getUserWithRepositories();

    /**
     * Updates the basic information associated with an account.
     * It operates on the currently authenticated user.
     * Specify one or more fields with the exception of the username field.
     * This call ignores changes to the username field. Omitted fields retain their existing values.
     * PUT https://bitbucket.org/api/1.0/user --data "field=value&field=value&..."
     *
     * @param userProfileDataToUpdate user data to update
     * @return user profile
     */
    BitBucketUser updateUser(BitBucketUser userProfileDataToUpdate);

    /**
     * Gets the account-level privileges for an individual or team account.
     * Use this call to locate the accounts that the currently authenticated  accountname has access to.
     * An account can have admin or collaborator (member) privileges.
     * The accountname always has admin privileges on itself.
     * GET   https://bitbucket.org/api/1.0/user/privileges
     *
     * @return map {accountname, privilege string}
     */
    Map<String, String> getUserPrivileges();

    /**
     * Gets the details of the repositories that the individual or team account follows.
     * This call returns the full data about the repositories
     * including if the repository is a fork of another repository.
     * An account always "follows" its own repositories.
     * GET https://bitbucket.org/api/1.0/user/follows
     *
     * @return list of repositories
     */
    List<BitBucketRepository> getRepositoriesAccountFollows();

    /**
     * Gets the details of the repositories that the user owns or has at least read access to.
     * Use this if you're looking for a full list of all of the repositories associated with a user.
     * GET https://bitbucket.org/api/1.0/user/repositories
     *
     * @return list of repositories
     */
    List<BitBucketRepository> getRepositoriesVisible();

    /**
     * Gets a list of the repositories the account follows.
     * This is the same list that appears on the Following tab on your account dashboard.
     * GET https://bitbucket.org/api/1.0/user/repositories/overview
     *
     * @return list of repositories
     */
    BitBucketFollowingRepositories getRepositoriesFollowing();

    /**
     * NOT IMPLEMENTED due to bad json format in response.
     * Gets the repositories list from the account's dashboard.
     * GET https://bitbucket.org/api/1.0/user/repositories/dashboard
     *
     * @return list of repositories
     */
    List<BitBucketRepository> getRepositoriesOnDashboard();

    /**
     * Returns the list of users that follow the given {@code user}.
     * @deprecated will be moved to the followers endpoint template
     */
    List<BitBucketUser> getFollowers(String user);

}

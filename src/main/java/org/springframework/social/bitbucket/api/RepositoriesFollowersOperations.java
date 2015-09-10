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
 * Users can follow another user or a repository. Use this resource to list a repository's followers.
 * This resource does not require authentication. For a list of repositories an individual user follows, see user Endpoint.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/followers+Resource"
 * @since 2.0.0
 */
public interface RepositoriesFollowersOperations {

    /**
     * Gets a count and the list of accounts following a repository.
     * Use this API to get a list of the accounts following a repository.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/followers
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @return List of followers.
     */
    List<BitBucketUser> getFollowers(String accountName, String repoSlug);
}

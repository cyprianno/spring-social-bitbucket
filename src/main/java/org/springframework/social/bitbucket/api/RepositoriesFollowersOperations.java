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

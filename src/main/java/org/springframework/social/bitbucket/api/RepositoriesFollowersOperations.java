package org.springframework.social.bitbucket.api;

/**
 * Users can follow another user or a repository. Use this resource to list a repository's followers.
 * This resource does not require authentication. For a list of repositories an individual user follows, see user Endpoint.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/followers+Resource"
 * @since 2.0.0
 */
public interface RepositoriesFollowersOperations {

    void getFollowers(String accountName, String repoSlug);
}

/*###followers
- OK GET the repository followers
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/followers
RepoTemplate.getFollowers*/
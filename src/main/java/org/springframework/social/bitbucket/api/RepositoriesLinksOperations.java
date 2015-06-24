package org.springframework.social.bitbucket.api;

import java.util.List;

/**
 * Links connect your commit messages and code comments directly to your JIRA issue tracker or Bamboo build server.
 * You can also create custom link resources.
 * The links resource supplies functionality for adding, updating, removing, and viewing links associated with your repositories.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/links+Resources"
 * @since 2.0.0
 */
public interface RepositoriesLinksOperations {

    /**
     * Gets an array containing the links associated with a repository.
     * The caller must authenticate as a user with administrative access to the repository.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/links
     *
     * @param accountName
     * @param repoSlug
     * @return
     */
    List<BitBucketLink> getLinks(String accountName, String repoSlug);

    /**
     * Gets an individual link on a repository. The caller must authenticate as a user with administrative access to the repository.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/links/{object_id}
     *
     * @param accountName
     * @param repoSlug
     * @param linkId
     * @return
     */
    BitBucketLink getLink(String accountName, String repoSlug, Long linkId);

    /**
     *
     * @param accountName
     * @param repoSlug
     * @return
     */
    BitBucketLink postNewLink(String accountName, String repoSlug);

    BitBucketLink updateLink(String accountName, String repoSlug, Long linkId);

    void removeLink(String accountName, String repoSlug, Long linkId);
}
/*
* ###links
- TBD GET list of links
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/links
- TBD GET a link
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/links/{object_id}
- TBD POST a new link
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/links --data "handler=value" --data "link_url= http://somesite.com "
–data "link_key=value"
- TBD PUT an update to a link
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/links/{object_id} --data "link_key=value" --data "link_url= http://somesite.com "
- TBD DELETE a link
DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/links/{object_id}
*/
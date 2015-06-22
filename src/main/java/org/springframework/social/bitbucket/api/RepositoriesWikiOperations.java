package org.springframework.social.bitbucket.api;

/**
 * The wiki resource provides functionality for getting information from pages in a Bitbucket wiki, creating new pages, and updating them.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/wiki+Resources"
 * @since 2.0.0
 */
public interface RepositoriesWikiOperations {
}
/*###wiki
- GET the raw content of a Wiki page
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/wiki/{page}
- POST a new page
POST https://bitbucket.org/api/1.0/repositories/ {accountname}/{repo_slug}/wiki/{page} --data "content=string"
- PUT a page update
PUT https://bitbucket.org/api/1.0/repositories/ accountname/repo_name/wiki/{page} --data "path={path}&data=string" --data "rev=value"*/
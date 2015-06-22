package org.springframework.social.bitbucket.api;

/**
 * For the repository resource, you supply a  repo_slug that identifies the specific repository.
 * For example, the repo_slug for this repository  https://bitbucket.org/tortoisehg/thg is thg.
 * You can use this resource to create a new repository or edit a specific one.
 * There are several URLs that allow you to query for branch resources.
 * Unauthenticated calls for this resource only return values for public repositories.
 * To see private repositories, you must have at least read permissions on the repository.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/repository+Resource+1.0"
 * @since 2.0.0
 */
public interface RepositoriesRepositoryOperations {
}
/*###repository XXXX
- DEPRECATED POST a new repository
 https://bitbucket.org/api/1.0/repositories  --data "name=mynewrepo"
- TBD POST a new fork
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/fork  --data "name=mynewrepo"
- PUT a repository update
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug} --data "description=long description"
- DEPRECATED DELETE an existing repository
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}
- GET list of branches
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/branches
- GET the repository's main branch
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/main-branch
- GET list of branches-tags
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/branches-tags
- GET the repository manifest
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/{revision}
- GET a list of the tags
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/tags
- GET the raw source
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/raw/{revision}/{path}
- GETs the history of a file in a changeset
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/filehistory/{node}/{path}*/
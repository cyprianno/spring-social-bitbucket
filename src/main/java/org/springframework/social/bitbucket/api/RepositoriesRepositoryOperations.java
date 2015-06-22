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

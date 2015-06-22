package org.springframework.social.bitbucket.api;

/**
 * Use changesets resources to manage changesets resources on a repository.
 * Unauthenticated calls for these resources only return values for public repositories.
 * To see changeset resources on private repositories, the caller must authenticated and must have at least read permissions on the repository.
 * Changesets are read-only resources, you can't add or modify a changeset structure.
 * You can modify the secondary resources such as comments associated with an individual change set node.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/changesets+Resource"
 * @since 2.0.0
 */
public interface RepositoriesChangesetsOperations {
}

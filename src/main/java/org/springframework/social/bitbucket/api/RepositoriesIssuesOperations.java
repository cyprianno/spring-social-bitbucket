package org.springframework.social.bitbucket.api;

/**
 * The issues resource provides functionality for getting information on issues in an issue tracker,
 * creating new issues, updating them and deleting them.
 * You can access public issues without authentication, but you will only receive a subset of information,
 * and you can't gain access to private repositories' issues.
 * By authenticating, you will get a more detailed set of information, the ability to create issues,
 * as well as access to updating data or deleting issues you have access to.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/issues+Resource"
 * @since 2.0.0
 */
public interface RepositoriesIssuesOperations {
}

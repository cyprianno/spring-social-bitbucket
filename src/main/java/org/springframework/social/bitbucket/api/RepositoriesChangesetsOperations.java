package org.springframework.social.bitbucket.api;

import java.util.List;

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

    /**
     * Gets a list of change sets associated with a repository.
     * By default, this call returns the 15 most recent changesets.
     * It also returns the count which is the total number of changesets on the repository.
     * Private repositories require the caller to authenticate.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets?limit=integer?start=node
     *
     * @param accountName The team or individual account owning the repo.
     * @param repoSlug The repo identifier.
     * @param start An integer representing how many changesets to return. You can specify a limit between 0 and 50.
     *              If you specify 0 (zero), the system returns the count but returns empty values for the remaining fields.
     * @param limit A hash value representing the earliest node to start with.
     *              The system starts with the specified node and includes the older requests that preceded it.
     *              The Bitbucket GUI lists the nodes on the Commit tab. The default start value is the tip.
     * @return List of changesets
     */
    List<BitBucketChangesets> getChangesets(String accountName, String repoSlug, String start, int limit);

    /**
     * Gets a specific changeset  node. Private repositories require the caller to authenticate.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}
     *
     * @param accountName The team or individual account owning the repo.
     * @param repoSlug The repo identifier.
     * @param node The node changeset identifier.
     * @return Requested changeset.
     */
    BitBucketChangeset getChangeset(String accountName, String repoSlug, String node);

    /**
     * Returns an array containing statistics on changed file associated with a particular  node in a change set.
     * Private repositories require the caller to authenticate.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/diffstat
     *
     * @param accountName The team or individual account owning the repo.
     * @param repoSlug The repo identifier.
     * @param node The node changeset identifier.
     * @return List of repository statistics.
     */
    List<BitBucketRepositoryStatistics> getStatistics(String accountName, String repoSlug, String node);

    /**
     * Gets the actual diff associated with the changeset node. This call returns the output as a string containing JSON.
     * Private repositories require the caller to authenticate.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/diff
     *
     * @param accountName The team or individual account owning the repo.
     * @param repoSlug The repo identifier.
     * @param node The node changeset identifier.
     * @return List of diffs.
     */
    List<BitBucketDiff> getDiff(String accountName, String repoSlug, String node);

    /**
     * Gets the comments associated with a particular changeset node.
     * Users can create and edit comments on particular changesets.
     * Private repositories require the caller to authenticate.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/comments
     *
     * @param accountName The team or individual account owning the repo.
     * @param repoSlug The repo identifier.
     * @param node The node changeset identifier.
     * @return List of comments on changeset.
     */
    List<BitBucketComment> getComments(String accountName, String repoSlug, String node);

    /**
     * Deletes the specified  comment_id associated with a particular changeset  node.
     * To delete a comment, you must have administrative rights on the repository, the account,
     * or be authenticated as the username associated with the comment.
     * Private repositories require the caller to authenticate.
     * API call: DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/comments/{comment_id}
     *
     * @param accountName The team or individual account owning the repo.
     * @param repoSlug The repo identifier.
     * @param node The node changeset identifier.
     * @param commentId The comment identifier.
     */
    void removeComment(String accountName, String repoSlug, String node, Long commentId);

    /**
     * Adds a new comment to a changeset node. This call requires authentication.
     * The call can add a new comment or create a comment in reply to another specified by the parent_id parameter.
     * The system creates a comment on behalf of the authenticated caller.
     * The authenticated caller must have administrative or write rights on the repository to POST a new comment.
     * Private repositories require the caller to authenticate.
     * API call: POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/comments
     *
     * @param accountName The team or individual account owning the repo.
     * @param repoSlug The repo identifier.
     * @param node The node changeset identifier.
     * @param comment The comment metadata and content.
     * @return Created comment.
     */
    BitBucketComment postComment(String accountName, String repoSlug, String node, BitBucketComment comment);

    /**
     * Puts an update to an existing changeset comment identified by the comment_id.
     * This call requires authentication. The system updates a comment on behalf of the authenticated caller.
     * The caller must authenticate as a user with administrative privileges on the account, the repo, or as the user that created the comment.
     * Private repositories require the caller to authenticate.
     * API call: PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/comments/{comment_id}
     *
     * @param accountName The team or individual account owning the repo.
     * @param repoSlug The repo identifier.
     * @param node The node changeset identifier.
     * @param commentId The comment identifier.
     * @return Updated comment.
     */
    BitBucketComment updateComment(String accountName, String repoSlug, String node, Long commentId);

    /**
     * Toggles the spam flag on a changeset comment identified by the comment_id.
     * This call requires authentication.
     * API call: PUT  https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/comments/spam/{comment_id }
     *
     * @param accountName The team or individual account owning the repo.
     * @param repoSlug The repo identifier.
     * @param node The node changeset identifier.
     * @param commentId The comment identifier.
     * @return Updated comment.
     */
    BitBucketChangeset toogleSpamComment(String accountName, String repoSlug, String node, Long commentId);

}

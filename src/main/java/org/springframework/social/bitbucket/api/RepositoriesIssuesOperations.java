package org.springframework.social.bitbucket.api;

import org.springframework.social.bitbucket.api.command.IssueCreateUpdate;

import java.util.List;

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

    /**
     * Gets the list of issues in the repository.
     * If you issue this call without filtering parameters, the count value contains the total number of issues in the repository's tracker.
     * If you filter this call, the count value contains the total number of issues that meet the filter criteria.
     * Authorization is not required for public repositories with a public issue tracker.
     * Private repositories or private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * By default, this call returns 15 issues. If necessary you can specify the sort parameter to order the output.
     * API call:  GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues?parameter=value&parameter=value&...
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param start Start offset.
     * @param limit Number of elements to return.
     * @param sort Sort field
     * @return List of issues.
     */
    List<BitBucketIssue> getIssues(String accountName, String repoSlug, Integer start, Integer limit, String sort);

    /**
     * Gets in individual issue from a repository.
     * Authorisation is not required for public repositories with a public issue tracker.
     * Private repositories or private issue trackers require the caller to authenticate  with an account that has appropriate access.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param issueId The issue identifier.
     * @return Requested issue.
     */
    BitBucketIssue getIssue(String accountName, String repoSlug, long issueId);

    /**
     * Gets the followers for an individual issue from a repository.
     * Authorisation is not required for public repositories with a public issue tracker.
     * Private repositories or private issue trackers require the caller to authenticate with an account that has appropriate access.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/followers
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param issueId The issue identifier.
     * @return List of followers.
     */
    List<BitBucketUser> getFollowers(String accountName, String repoSlug, long issueId);

    /**
     * Creates a new issue in a repository. This call requires authentication.
     * Private repositories or private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * The authenticated user is used for the issue's reported_by field.
     * API call: POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues  --data "title=value&content=value"
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param issue The issue data.
     * @return Created object.
     */
    BitBucketIssue postNewIssue(String accountName, String repoSlug, IssueCreateUpdate issue);

    /**
     * Updates an existing issue.
     * Updating the title or content fields requires that the caller authenticate as a user with write access.
     * For other fields, the caller must authenticate as a user with read access.
     * Private repositories or private issue trackers require the caller to authenticate with an account that has appropriate access.
     * API call: PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}  --data "parameter=value&parameter=value"
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param issueId The issue identifier.
     * @param issue The issue data.
     * @return Updated object.
     */
    BitBucketIssue updateIssue(String accountName, String repoSlug, long issueId, IssueCreateUpdate issue);

    /**
     * Deletes the specified issue_id.
     * Private repositories or private issue trackers require the caller to authenticate with an account that has appropriate access.
     * API call: DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param issueId The issue identifier.
     */
    void removeIssue(String accountName, String repoSlug, long issueId);

    /**
     * Gets the array of comments on the specified issue.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param issueId The issue identifier.
     * @return List of comments.
     */
    List<BitBucketComment> getComments(String accountName, String repoSlug, long issueId);

    /**
     * Gets an individual comment on an issue.
     * Private repositories or private issue trackers require the caller to authenticate  with an account that has appropriate access.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments/{comment_id}
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param issueId The issue identifier.
     * @param commentId An integer representing an id for the comment. This is created by Bitbucket.
     * @return Requested comment.
     */
    BitBucketComment getComment(String accountName, String repoSlug, long issueId, long commentId);

    /**
     * Creates a new comment on an issue using the specified contentdata.
     * The caller must be authenticated and have access to the issue tracker to create an issue.
     * API call: POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments --data "content=string"
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param issueId The issue identifier.
     * @param content The content of the comment.
     * @return Created object.
     */
    BitBucketComment postNewComment(String accountName, String repoSlug, long issueId, String content);

    /**
     * Updates a comment on an issue using the specified content data.
     * The caller must be authenticated as a user that created the comment or as a user with administrative rights on the repository.
     * API call: PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments/{comment_id} --data "content=string"
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param issueId The issue identifier.
     * @param commentId An integer representing an id for the comment. This is created by Bitbucket.
     * @param content The content of the comment.
     * @return Updated object.
     */
    BitBucketComment updateComment(String accountName, String repoSlug, long issueId, long commentId, String content);

    /**
     * Gets an array of the components associated with the issue tracker.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @return List of components.
     */
    List<BitBucketComponent> getComponents(String accountName, String repoSlug);

    /**
     * Gets an individual component in an issue tracker.
     * To get a component, private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components/{object_id}
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param objectId The element identifier to delete.
     * @return Requested component.
     */
    BitBucketComponent getComponent(String accountName, String repoSlug, long objectId);

    /**
     * Creates a new component in an issue tracker.
     * You must supply a namevalue in the form of a string.
     * The server creates the id for you and it appears in the return value.
     * Public and private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * API call: POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components --data "name=String"
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param name The element name. A name cannot exceed 128 characters and must be unique.
     * @return Created object.
     */
    BitBucketComponent postNewComponent(String accountName, String repoSlug, String name);

    /**
     * Updates an existing component in an issue tracker.
     * You must supply a name value in the form of a string.
     * Public and private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * API call: PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components/{object_id} --data "name=String"
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param objectId The element identifier to delete.
     * @param name The element name. A name cannot exceed 128 characters and must be unique.
     * @return Updated object.
     */
    BitBucketComponent updateComponent(String accountName, String repoSlug, long objectId, String name);

    /**
     * Deletes a component in an issue tracker.
     * To delete a component, public and private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * Keep in mind that the component can be in use on existing issues.
     * When you delete a component, the system updates the issues and does the following:
     * - remove the component type
     * - leaves the issue's component value empty
     * - adds a comment to the issue explaining the change
     * API call: DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components/{object_id}
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param objectId The element identifier to delete.
     */
    void removeComponent(String accountName, String repoSlug, long objectId);

    /**
     * Gets an array of the versions associated with the issue tracker.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @return List of versions.
     */
    List<BitBucketVersion> getVersions(String accountName, String repoSlug);

    /**
     * Gets an individual version in an issue tracker.
     * Public and private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions/{object_id}
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param objectId The element identifier to delete.
     * @return Requested version.
     */
    BitBucketVersion getVersion(String accountName, String repoSlug, long objectId);

    /**
     * Creates a new version in an issue tracker.
     * You must supply a name value in the form of a string.
     * The server creates the id for you and it appears in the return value.
     * Public and private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * API call: POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions --data "name=String"
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param name The element name. A name cannot exceed 128 characters and must be unique.
     * @return Created object.
     */
    BitBucketVersion postNewVersion(String accountName, String repoSlug, String name);

    /**
     * Updates an existing version in an issue tracker.
     * You must supply a name value in the form of a string.
     * Public and private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * API call: PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions/{object_id} --data "name=String"
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param objectId The element identifier to delete.
     * @param name The element name. A name cannot exceed 128 characters and must be unique.
     * @return Updated object.
     */
    BitBucketVersion updateVersion(String accountName, String repoSlug, long objectId, String name);

    /**
     * Deletes a version in an issue tracker.
     * To delete a version, public and private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * Keep in mind that the version can be in use on existing issues.
     * When you delete a version, the system updates the issues and does the following:
     * - remove the version type
     * - leaves the issue's version value empty
     * - adds a comment to the issue explaining the change
     * API call: DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions/{object_id}
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param objectId The element identifier to delete.
     */
    void removeVersion(String accountName, String repoSlug, long objectId);

    /**
     * Gets an array of the milestones associated with the issue tracker.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @return List of milestones.
     */
    List<BitBucketMilestone> getMilestones(String accountName, String repoSlug);

    /**
     * Gets an individual milestone in an issue tracker.
     * Public and private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones/{object_id}
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param objectId The element identifier to delete.
     * @return Requested milestone.
     */
    BitBucketMilestone getMilestone(String accountName, String repoSlug, long objectId);

    /**
     * Creates a new milestone in an issue tracker.
     * You must supply a name value in the form of a string.
     * The server creates the id for you and it appears in the return value.
     * Public and private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * API call: POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones --data "name=String"
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param name The element name. A name cannot exceed 128 characters and must be unique.
     * @return Created object.
     */
    BitBucketMilestone postNewMilestone(String accountName, String repoSlug, String name);

    /**
     * Updates an existing milestone in an issue tracker.
     * You must supply a name value in the form of a string.
     * Public and private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * API call: PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones/{object_id} --data "name=String"
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param objectId The element identifier to delete.
     * @param name The element name. A name cannot exceed 128 characters and must be unique.
     * @return Updated object.
     */
    BitBucketMilestone updateMilestone(String accountName, String repoSlug, long objectId, String name);

    /**
     * Deletes a milestone in an issue tracker.
     * To delete a milestone, public and private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * Keep in mind that the milestone can be in use on existing issues.
     * When you delete a milestone, the system updates the issues and does the following:
     * - remove the milestone type
     * - leaves the issue's milestone value empty
     * - adds a comment to the issue explaining the change
     * API call: DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones/{object_id}
     *
     * @param accountName The team or individual account owning the repository.
     * @param repoSlug The repository identifier.
     * @param objectId The element identifier to delete.
     */
    void removeMilestone(String accountName, String repoSlug, long objectId);

}

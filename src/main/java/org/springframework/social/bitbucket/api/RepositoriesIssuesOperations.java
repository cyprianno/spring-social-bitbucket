package org.springframework.social.bitbucket.api;

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
     * @param accountName
     * @param repoSlug
     * @param start
     * @param limit
     * @param sort
     * @return List of issues.
     */
    List<BitBucketIssue> getIssues(String accountName, String repoSlug, Integer start, Integer limit, String sort);

    /**
     * Gets in individual issue from a repository.
     * Authorisation is not required for public repositories with a public issue tracker.
     * Private repositories or private issue trackers require the caller to authenticate  with an account that has appropriate access.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}
     *
     * @param accountName
     * @param repoSlug
     * @param issueId
     * @return
     */
    BitBucketIssue getIssue(String accountName, String repoSlug, Long issueId);

    /**
     * Gets the followers for an individual issue from a repository.
     * Authorisation is not required for public repositories with a public issue tracker.
     * Private repositories or private issue trackers require the caller to authenticate with an account that has appropriate access.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/followers
     *
     * @param accountName
     * @param repoSlug
     * @param issueId
     * @return
     */
    List<BitBucketUser> getFollowers(String accountName, String repoSlug, Long issueId);

    /**
     * Creates a new issue in a repository. This call requires authentication.
     * Private repositories or private issue trackers require the caller to authenticate with an account that has appropriate authorisation.
     * The authenticated user is used for the issue's reported_by field.
     * API call: POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues  --data "title=value&content=value"
     *
     * @param accountName
     * @param repoSlug
     * @param issue
     * @return
     */
    BitBucketIssue postNewIssue(String accountName, String repoSlug, BitBucketIssue issue);

    /**
     * Updates an existing issue.
     * Updating the title or content fields requires that the caller authenticate as a user with write access.
     * For other fields, the caller must authenticate as a user with read access.
     * Private repositories or private issue trackers require the caller to authenticate with an account that has appropriate access.
     * API call: PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}  --data "parameter=value&parameter=value"
     *
     * @param accountName
     * @param repoSlug
     * @param issueId
     * @param issue
     * @return
     */
    BitBucketIssue updateIssue(String accountName, String repoSlug, Long issueId, BitBucketIssue issue);

    /**
     * Deletes the specified issue_id.
     * Private repositories or private issue trackers require the caller to authenticate with an account that has appropriate access.
     * API call: DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}
     *
     * @param accountName
     * @param repoSlug
     * @param issueId
     */
    void removeIssue(String accountName, String repoSlug, Long issueId);

    /**
     * Gets the array of comments on the specified issue.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments
     *
     * @param accountName
     * @param repoSlug
     * @param issueId
     * @return
     */
    List<BitBucketComment> getComments(String accountName, String repoSlug, Long issueId);

    /**
     * Gets an individual comment on an issue.
     * Private repositories or private issue trackers require the caller to authenticate  with an account that has appropriate access.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments/{comment_id}
     *
     * @param accountName
     * @param repoSlug
     * @param issueId
     * @param commentId
     * @return
     */
    BitBucketComment getComment(String accountName, String repoSlug, Long issueId, Long commentId);

    /**
     * Creates a new comment on an issue using the specified contentdata.
     * The caller must be authenticated and have access to the issue tracker to create an issue.
     * API call: POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments --data "content=string"
     *
     * @param accountName
     * @param repoSlug
     * @param issueId
     * @param content
     * @return
     */
    BitBucketComment postNewComment(String accountName, String repoSlug, Long issueId, String content);

    /**
     * Updates a comment on an issue using the specified content data.
     * The caller must be authenticated as a user that created the comment or as a user with administrative rights on the repository.
     * API call: PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments/{comment_id} --data "content=string"
     *
     * @param accountName
     * @param repoSlug
     * @param issueId
     * @param commentId
     * @param content
     * @return
     */
    BitBucketComment updateComment(String accountName, String repoSlug, Long issueId, String commentId, String content);

//    void removeComment(String accountName, String repoSlug, Long commentId);


    List<BitBucketComponent> getComponents(String accountName, String repoSlug, Long issueId);

    BitBucketComponent getComponent(String accountName, String repoSlug, String issueId, Long componentId);

    BitBucketComponent postNewComponent(String accountName, String repoSlug, Long issueId);

    BitBucketComponent updateComponent(String accountName, String repoSlug, Long issueId, Long componentId);

    void removeComponent(String accountName, String repoSlug, Long componentId);

    List<String> getVersions(String accountName, String repoSlug, Long issueId);

    String getVersion(String accountName, String repoSlug, Long issueId, Long versionId);

    String postNewVersion(String accountName, String repoSlug, Long issueId);

    String updateVersion(String accountName, String repoSlug, Long issueId, Long versionId);

    void removeVersion(String accountName, String repoSlug, Long versionId);

    List<String> getMilestones(String accountName, String repoSlug, Long issueId);

    String getMilestone(String accountName, String repoSlug, Long issueId, Long milestoneId);

    String postNewMilestone(String accountName, String repoSlug, Long issueId);

    String updateMilestone(String accountName, String repoSlug, Long issueId, Long milestoneId);

    void removeMilestone(String accountName, String repoSlug, Long milestoneId);



}
/*###issues XXXX
- TBD GET a list of issues in a repository's tracker
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues?parameter=value&parameter=value&...
- TBD GET an individual issue
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}
- TBD GET a list of an issue's followers
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/followers
- TBD POST a new issue
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues  --data "title=value&content=value"
- TBD Update an existing issue
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}  --data "parameter=value&parameter=value"
- TBD DELETE an issue
DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}
- TBD GET the comments for an issue
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments
- TBD GET an individual comment
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments/{comment_id}
- TBD POST a new comment on the issue
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments --data "content=string"
- TBD Update a comment
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments/{comment_id} --data "content=string"
- TBD GET the components defined on an issue tracker
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components
- TBD GET an individual component
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components/{object_id}
- TBD POST a new component in an issue tracker
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components --data "name=String"
- TBD Update an existing component
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components/{object_id} --data "name=String"
- TBD DELETE a component from the issue tracker
DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components/{object_id}
- TBD GET a list of versions
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions
- TBD GET an individual version
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions/{object_id}
- TBD POST a new version
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions --data "name=String"
- TBD PUT an update to a version
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions/{object_id} --data "name=String"
- TBD DELETE a version
DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions/{object_id}
- TBD GET the defined milestones
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones
- TBD GET an individual milestone
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones/{object_id}
- TBD POST a new milestone
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones --data "name=String"
- TBD PUT an update to milestones
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones/{object_id} --data "name=String"
- TBD DELETE a milestone
DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones/{object_id}*/
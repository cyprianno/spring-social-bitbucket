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

    List<String> getIssues(String accountName, String repoSlug);

    String getIssue(String accountName, String repoSlug, String issueId);

    String getFollowers(String accountName, String repoSlug, String issueId);

    String postNewIssue(String accountName, String repoSlug, String issueId);

    String updateIssue(String accountName, String repoSlug, String issueId);

    void removeIssue(String accountName, String repoSlug, String issueId);

    List<String> getComments(String accountName, String repoSlug, String issueId);

    String getComment(String accountName, String repoSlug, String issueId, String commentId);

    String postNewComment(String accountName, String repoSlug, String issueId);

    String updateComment(String accountName, String repoSlug, String issueId, String commentId);

    void removeComment(String accountName, String repoSlug, String commentId);

    List<String> getComponents(String accountName, String repoSlug, String issueId);

    String getComponent(String accountName, String repoSlug, String issueId, String componentId);

    String postNewComponent(String accountName, String repoSlug, String issueId);

    String updateComponent(String accountName, String repoSlug, String issueId, String componentId);

    void removeComponent(String accountName, String repoSlug, String componentId);

    List<String> getVersions(String accountName, String repoSlug, String issueId);

    String getVersion(String accountName, String repoSlug, String issueId, String versionId);

    String postNewVersion(String accountName, String repoSlug, String issueId);

    String updateVersion(String accountName, String repoSlug, String issueId, String versionId);

    void removeVersion(String accountName, String repoSlug, String versionId);

    List<String> getMilestones(String accountName, String repoSlug, String issueId);

    String getMilestone(String accountName, String repoSlug, String issueId, String milestoneId);

    String postNewMilestone(String accountName, String repoSlug, String issueId);

    String updateMilestone(String accountName, String repoSlug, String issueId, String milestoneId);

    void removeMilestone(String accountName, String repoSlug, String milestoneId);



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
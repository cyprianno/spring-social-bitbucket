package org.springframework.social.bitbucket.api;

import java.util.List;

/**
 * Manage the comments on pull requests. Other users can reply to them. This allows for the construction of a thread of comments.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/pullrequests+Resource+1.0"
 * @since 2.0.0
 */
public interface RepositoriesPullRequestsOperations {

    String postNewComment(String accountName, String repoSlug, String pullRequestId);

    String updateComment(String accountName, String repoSlug, String issueId, String pullRequestId, String commentId);

    void removeComment(String accountName, String repoSlug, String pullRequestId, String commentId);

    void toggleSpam(String accountName, String repoSlug, String pullRequestId, String commentId);
}
/*###pullrequests
- DEPRECATED GET a list of a pull request comments DEPRECATED
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments
- DEPRECATED GET an individual pull request comment DEPRECATED
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/{comment_id}
- TBD POST a new comment
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments --data "content=string"
- TBD PUT an update on a comment
PUT  https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/{comment_id} --data "content=string"
- TBD DELETE a pull request comment
DELETE  https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/{comment_id}
- TBD Toggle spam flag on an existing pull request comment
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/spam/{comment_id}*/
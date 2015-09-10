/**
 * Copyright (C) 2012 Eric Bottard / Guillaume Lederrey (eric.bottard+ghpublic@gmail.com / guillaume.lederrey@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.bitbucket.api;

/**
 * Manage the comments on pull requests. Other users can reply to them. This allows for the construction of a thread of comments.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/pullrequests+Resource+1.0"
 * @since 2.0.0
 */
public interface RepositoriesPullRequestsOperations {

    /**
     * Creates a new comment on an request using the specified content data.
     * The caller must be authenticated and have access to the repository to create an request.
     * API call: POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments --data "content=string"
     *
     * @param accountName The team or individual account owning the repo.
     * @param repoSlug The repo identifier.
     * @param pullRequestId The pull_request_id changeset identifier.
     * @param content Comment's content.
     * @return Created comment.
     */
    BitBucketComment postNewComment(String accountName, String repoSlug, Long pullRequestId, String content);

    /**
     * Updates a comment on an request using the specified content data.
     * The caller must be authenticated as a user that created the comment or as a user with administrative rights on the repository.
     * API call: PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/{comment_id} --data "content=string"
     *
     * @param accountName The team or individual account owning the repo.
     * @param repoSlug The repo identifier.
     * @param pullRequestId The pull_request_id changeset identifier.
     * @param commentId The comment identifier.
     * @param content Comment's content.
     * @return Updated comment.
     */
    BitBucketComment updateComment(String accountName, String repoSlug, Long pullRequestId, Long commentId, String content);

    /**
     * Delete the comment with the corresponding comment_id.
     * The caller must be authenticated as a user that created the comment or as a user with administrative rights on the repository.
     * API call: DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/{comment_id}
     *
     * @param accountName The team or individual account owning the repo.
     * @param repoSlug The repo identifier.
     * @param pullRequestId The pull_request_id changeset identifier.
     * @param commentId The comment identifier.
     */
    void removeComment(String accountName, String repoSlug, Long pullRequestId, Long commentId);

    /**
     * Toggles the spam flag on a pull request comment identified by the pull_request_id.
     * This call requires authentication.
     * API call: PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/spam/{comment_id}
     *
     * @param accountName The team or individual account owning the repo.
     * @param repoSlug The repo identifier.
     * @param pullRequestId The pull_request_id changeset identifier.
     * @param commentId The comment identifier.
     * @return Updated comment.
     */
    BitBucketComment toggleSpam(String accountName, String repoSlug, Long pullRequestId, Long commentId);
}

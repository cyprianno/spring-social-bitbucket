package org.springframework.social.bitbucket.api.impl;

import org.springframework.http.HttpMethod;
import org.springframework.social.bitbucket.api.BitBucketComment;
import org.springframework.social.bitbucket.api.RepositoriesPullRequestsOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesPullRequestsTemplate extends AbstractBitBucketOperations implements RepositoriesPullRequestsOperations {
    public RepositoriesPullRequestsTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public  final BitBucketComment postNewComment(String accountName, String repoSlug, Long pullRequestId, String content) {
        return null;
    }

    @Override
    public  final BitBucketComment updateComment(String accountName, String repoSlug, Long pullRequestId, Long commentId, String content) {
        return null;
    }

    @Override
    public  final void removeComment(String accountName, String repoSlug, Long pullRequestId, Long commentId) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/{comment_id}"), accountName, repoSlug, pullRequestId,
                commentId);
    }

    @Override
    public  final BitBucketComment toggleSpam(String accountName, String repoSlug, Long pullRequestId, Long commentId) {
        return null;
    }
}

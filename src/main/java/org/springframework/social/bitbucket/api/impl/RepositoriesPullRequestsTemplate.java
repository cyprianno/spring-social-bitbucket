package org.springframework.social.bitbucket.api.impl;

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
    public BitBucketComment postNewComment(String accountName, String repoSlug, Long pullRequestId) {
        return null;
    }

    @Override
    public BitBucketComment updateComment(String accountName, String repoSlug, Long pullRequestId, Long commentId) {
        return null;
    }

    @Override
    public void removeComment(String accountName, String repoSlug, Long pullRequestId, Long commentId) {

    }

    @Override
    public BitBucketComment toggleSpam(String accountName, String repoSlug, Long pullRequestId, Long commentId) {
        return null;
    }
}

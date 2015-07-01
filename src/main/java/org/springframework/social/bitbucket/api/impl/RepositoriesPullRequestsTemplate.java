package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketComment;
import org.springframework.social.bitbucket.api.RepositoriesPullRequestsOperations;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesPullRequestsTemplate implements RepositoriesPullRequestsOperations {
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

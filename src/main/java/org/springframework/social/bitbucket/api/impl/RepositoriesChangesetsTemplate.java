package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketChangeset;
import org.springframework.social.bitbucket.api.BitBucketChangesets;
import org.springframework.social.bitbucket.api.BitBucketComment;
import org.springframework.social.bitbucket.api.BitBucketDiff;
import org.springframework.social.bitbucket.api.BitBucketRepositoryStatistics;
import org.springframework.social.bitbucket.api.RepositoriesChangesetsOperations;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesChangesetsTemplate implements RepositoriesChangesetsOperations {
    @Override
    public List<BitBucketChangesets> getChangesets(String accountName, String repoSlug, String start, int limit) {
        return null;
    }

    @Override
    public BitBucketChangeset getChangeset(String accountName, String repoSlug, String node) {
        return null;
    }

    @Override
    public List<BitBucketRepositoryStatistics> getStatistics(String accountName, String repoSlug, String node) {
        return null;
    }

    @Override
    public List<BitBucketDiff> getDiff(String accountName, String repoSlug, String node) {
        return null;
    }

    @Override
    public List<BitBucketComment> getComments(String accountName, String repoSlug, String node) {
        return null;
    }

    @Override
    public void removeComment(String accountName, String repoSlug, String node, Long commentId) {

    }

    @Override
    public BitBucketComment postComment(String accountName, String repoSlug, String node, BitBucketComment comment) {
        return null;
    }

    @Override
    public BitBucketComment updateComment(String accountName, String repoSlug, String node, Long commentId) {
        return null;
    }

    @Override
    public BitBucketChangeset toogleSpamComment(String accountName, String repoSlug, String node, Long commentId) {
        return null;
    }
}

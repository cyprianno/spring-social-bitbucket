package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketChangeset;
import org.springframework.social.bitbucket.api.BitBucketChangesets;
import org.springframework.social.bitbucket.api.BitBucketComment;
import org.springframework.social.bitbucket.api.BitBucketDiff;
import org.springframework.social.bitbucket.api.BitBucketRepository;
import org.springframework.social.bitbucket.api.BitBucketRepositoryStatistics;
import org.springframework.social.bitbucket.api.RepositoriesChangesetsOperations;
import org.springframework.social.bitbucket.api.UserWithRepositories;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesChangesetsTemplate extends AbstractBitBucketOperations implements RepositoriesChangesetsOperations {
    public RepositoriesChangesetsTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketChangeset> getChangesets(String accountName, String repoSlug, int limit, String start) {
        BitBucketChangesets result = getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/changesets?limit={limit}&start={start}"), BitBucketChangesets.class,
                        accountName, repoSlug, limit, start);
        return result.getChangesets();
    }

    @Override
    public  final BitBucketChangeset getChangeset(String accountName, String repoSlug, String node) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/changesets/{node}"), BitBucketChangeset.class,
                        accountName, repoSlug, node);
    }

    @Override
    public  final List<BitBucketRepositoryStatistics> getStatistics(String accountName, String repoSlug, String node) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/changesets/{node}/diffstat"), BitBucketRepositoryStatistics[].class,
                        accountName, repoSlug, node));
    }

    @Override
    public  final List<BitBucketDiff> getDiff(String accountName, String repoSlug, String node) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/changesets/{node}/diff"), BitBucketDiff[].class,
                        accountName, repoSlug, node));
    }

    @Override
    public  final List<BitBucketComment> getComments(String accountName, String repoSlug, String node) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/changesets/{node}/comments"), BitBucketComment[].class,
                        accountName, repoSlug, node));
    }

    @Override
    public  final void removeComment(String accountName, String repoSlug, String node, long commentId) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/changesets/{node}/comments/{comment_id}"), accountName, repoSlug, node,
                commentId);
    }

    @Override
    public  final BitBucketComment postComment(String accountName, String repoSlug, String node, String content, long parentId) {
        return null;
    }

    @Override
    public  final BitBucketComment updateComment(String accountName, String repoSlug, String node, Long commentId, String content) {
        return null;
    }

    @Override
    public  final BitBucketComment toggleSpamComment(String accountName, String repoSlug, String node, Long commentId) {
        return null;
    }
}

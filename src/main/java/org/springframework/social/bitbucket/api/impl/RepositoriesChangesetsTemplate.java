package org.springframework.social.bitbucket.api.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.*;
import org.springframework.social.support.ParameterMap;
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
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/changesets/{node}/comments"), new CommentCreate(content,parentId), BitBucketComment.class,
                        accountName, repoSlug, node);
    }

    @Override
    public  final BitBucketComment updateComment(String accountName, String repoSlug, String node, Long commentId, String content) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/changesets/{node}/comments/{comment_id}"), HttpMethod.PUT,
                new HttpEntity<>(new CommentUpdate(content), httpHeaders),
                BitBucketComment.class, accountName, repoSlug, node, commentId).getBody();
    }

    @Override
    public  final BitBucketComment toggleSpamComment(String accountName, String repoSlug, String node, Long commentId) {
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/changesets/{node}/comments/spam/{comment_id}"), HttpMethod.PUT, null,
                BitBucketComment.class, accountName, repoSlug, node, commentId).getBody();
    }

    private static final class CommentCreate extends ParameterMap {

        public CommentCreate(String content, long parentId) {
            set("content", content);
            set("parent_id", String.valueOf(parentId));
        }

    }

    private static final class CommentUpdate extends ParameterMap {
        public CommentUpdate(String content) {
            set("content", content);
        }
    }
}

package org.springframework.social.bitbucket.api.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketComment;
import org.springframework.social.bitbucket.api.BitBucketComponent;
import org.springframework.social.bitbucket.api.BitBucketIssue;
import org.springframework.social.bitbucket.api.BitBucketMilestone;
import org.springframework.social.bitbucket.api.BitBucketUser;
import org.springframework.social.bitbucket.api.BitBucketVersion;
import org.springframework.social.bitbucket.api.RepositoriesIssuesOperations;
import org.springframework.social.bitbucket.api.command.IssueCreateUpdate;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesIssuesTemplate extends AbstractBitBucketOperations implements RepositoriesIssuesOperations {
    public RepositoriesIssuesTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public  final List<BitBucketIssue> getIssues(String accountName, String repoSlug, Integer start, Integer limit, String sort) {
        return null;
    }

    @Override
    public  final BitBucketIssue getIssue(String accountName, String repoSlug, long issueId) {
        return null;
    }

    @Override
    public  final List<BitBucketUser> getFollowers(String accountName, String repoSlug, long issueId) {
        return null;
    }

    @Override
    public  final BitBucketIssue postNewIssue(String accountName, String repoSlug, IssueCreateUpdate issue) {
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues"), issue, BitBucketIssue.class,
                        accountName, repoSlug);
    }

    @Override
    public  final BitBucketIssue updateIssue(String accountName, String repoSlug, long issueId, IssueCreateUpdate issue) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/issues/{issue_id}"), HttpMethod.PUT,
                new HttpEntity<>(issue, httpHeaders),
                BitBucketIssue.class, accountName, repoSlug, issueId).getBody();
    }

    @Override
    public  final void removeIssue(String accountName, String repoSlug, long issueId) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/issues/{issue_id}"), accountName, repoSlug, issueId);
    }

    @Override
    public  final List<BitBucketComment> getComments(String accountName, String repoSlug, long issueId) {
        return null;
    }

    @Override
    public  final BitBucketComment getComment(String accountName, String repoSlug, long issueId, long commentId) {
        return null;
    }

    @Override
    public  final BitBucketComment postNewComment(String accountName, String repoSlug, long issueId, String content) {
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments"), new CommentCreateUpdate(content), BitBucketComment.class,
                        accountName, repoSlug, issueId);
    }

    @Override
    public  final BitBucketComment updateComment(String accountName, String repoSlug, long issueId, long commentId, String content) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments/{comment_id}"), HttpMethod.PUT,
                new HttpEntity<>(new CommentCreateUpdate(content), httpHeaders),
                BitBucketComment.class, accountName, repoSlug, issueId, commentId).getBody();
    }

    @Override
    public  final List<BitBucketComponent> getComponents(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public  final BitBucketComponent getComponent(String accountName, String repoSlug, long objectId) {
        return null;
    }

    @Override
    public  final BitBucketComponent postNewComponent(String accountName, String repoSlug, String name) {
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/components"), new ComponentCreateUpdate(name), BitBucketComponent.class,
                        accountName, repoSlug);
    }

    @Override
    public  final BitBucketComponent updateComponent(String accountName, String repoSlug, long objectId, String name) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/issues/components/{object_id}"), HttpMethod.PUT,
                new HttpEntity<>(new ComponentCreateUpdate(name), httpHeaders),
                BitBucketComponent.class, accountName, repoSlug, objectId).getBody();
    }

    @Override
    public  final void removeComponent(String accountName, String repoSlug, long objectId) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/issues/components/{object_id}"), accountName, repoSlug, objectId);
    }

    @Override
    public  final List<BitBucketVersion> getVersions(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public  final BitBucketVersion getVersion(String accountName, String repoSlug, long objectId) {
        return null;
    }

    @Override
    public  final BitBucketVersion postNewVersion(String accountName, String repoSlug, String name) {
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/versions"), new VersionCreateUpdate(name), BitBucketVersion.class,
                        accountName, repoSlug);
    }

    @Override
    public  final BitBucketVersion updateVersion(String accountName, String repoSlug, long objectId, String name) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/issues/versions/{object_id}"), HttpMethod.PUT,
                new HttpEntity<>(new VersionCreateUpdate(name), httpHeaders),
                BitBucketVersion.class, accountName, repoSlug, objectId).getBody();
    }

    @Override
    public  final void removeVersion(String accountName, String repoSlug, long objectId) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/issues/versions/{object_id}"), accountName, repoSlug, objectId);
    }

    @Override
    public  final List<BitBucketMilestone> getMilestones(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public  final BitBucketMilestone getMilestone(String accountName, String repoSlug, long objectId) {
        return null;
    }

    @Override
    public  final BitBucketMilestone postNewMilestone(String accountName, String repoSlug, String name) {
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/milestones"), new MilestoneCreateUpdate(name), BitBucketMilestone.class,
                        accountName, repoSlug);
    }

    @Override
    public  final BitBucketMilestone updateMilestone(String accountName, String repoSlug, long objectId, String name) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/issues/milestones/{object_id}"), HttpMethod.PUT,
                new HttpEntity<>(new MilestoneCreateUpdate(name), httpHeaders),
                BitBucketMilestone.class, accountName, repoSlug, objectId).getBody();
    }

    @Override
    public  final void removeMilestone(String accountName, String repoSlug, long objectId) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/issues/milestones/{object_id}"), accountName, repoSlug, objectId);
    }

    private class VersionCreateUpdate extends ParameterMap {
        public VersionCreateUpdate(String name) {
            set("name", name);
        }
    }

    private class MilestoneCreateUpdate extends ParameterMap {
        public MilestoneCreateUpdate(String name) {
            set("name", name);
        }
    }

    private class ComponentCreateUpdate extends ParameterMap {
        public ComponentCreateUpdate(String name) {
            set("name", name);
        }
    }

    private class CommentCreateUpdate extends ParameterMap {
        public CommentCreateUpdate(String content) {
            set("content", content);
        }
    }
}

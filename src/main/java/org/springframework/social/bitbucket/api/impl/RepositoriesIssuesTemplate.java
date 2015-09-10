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
package org.springframework.social.bitbucket.api.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.*;
import org.springframework.social.bitbucket.api.command.IssueCreateUpdate;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesIssuesTemplate extends AbstractBitBucketOperations implements RepositoriesIssuesOperations {
    public RepositoriesIssuesTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketIssue> getIssues(String accountName, String repoSlug, Integer start, Integer limit, String sort) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues"), IssuesWrapper.class,
                        accountName, repoSlug).getIssues();
    }

    @Override
    public final BitBucketIssue getIssue(String accountName, String repoSlug, long issueId) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/{issue_id}"), BitBucketIssue.class,
                        accountName, repoSlug, issueId);
    }

    @Override
    public final List<BitBucketUser> getFollowers(String accountName, String repoSlug, long issueId) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/{issue_id}/followers"), FollowersWrapper.class,
                        accountName, repoSlug, issueId).getFollowers();
    }

    @Override
    public final BitBucketIssue postNewIssue(String accountName, String repoSlug, IssueCreateUpdate issue) {
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues"), issue, BitBucketIssue.class,
                        accountName, repoSlug);
    }

    @Override
    public final BitBucketIssue updateIssue(String accountName, String repoSlug, long issueId, IssueCreateUpdate issue) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/issues/{issue_id}"), HttpMethod.PUT,
                new HttpEntity<>(issue, httpHeaders),
                BitBucketIssue.class, accountName, repoSlug, issueId).getBody();
    }

    @Override
    public final void removeIssue(String accountName, String repoSlug, long issueId) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/issues/{issue_id}"), accountName, repoSlug, issueId);
    }

    @Override
    public final List<BitBucketComment> getComments(String accountName, String repoSlug, long issueId) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments"), BitBucketComment[].class,
                        accountName, repoSlug, issueId));
    }

    @Override
    public final BitBucketComment getComment(String accountName, String repoSlug, long issueId, long commentId) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments/{comment_id}"), BitBucketComment.class,
                        accountName, repoSlug, issueId, commentId);
    }

    @Override
    public final BitBucketComment postNewComment(String accountName, String repoSlug, long issueId, String content) {
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments"), new CommentCreateUpdate(content), BitBucketComment.class,
                        accountName, repoSlug, issueId);
    }

    @Override
    public final BitBucketComment updateComment(String accountName, String repoSlug, long issueId, long commentId, String content) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments/{comment_id}"), HttpMethod.PUT,
                new HttpEntity<>(new CommentCreateUpdate(content), httpHeaders),
                BitBucketComment.class, accountName, repoSlug, issueId, commentId).getBody();
    }

    @Override
    public final List<BitBucketComponent> getComponents(String accountName, String repoSlug) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/components"), BitBucketComponent[].class,
                        accountName, repoSlug));
    }

    @Override
    public final BitBucketComponent getComponent(String accountName, String repoSlug, long objectId) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/components/{object_id}"), BitBucketComponent.class,
                        accountName, repoSlug, objectId);
    }

    @Override
    public final BitBucketComponent postNewComponent(String accountName, String repoSlug, String name) {
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/components"), new ComponentCreateUpdate(name), BitBucketComponent.class,
                        accountName, repoSlug);
    }

    @Override
    public final BitBucketComponent updateComponent(String accountName, String repoSlug, long objectId, String name) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/issues/components/{object_id}"), HttpMethod.PUT,
                new HttpEntity<>(new ComponentCreateUpdate(name), httpHeaders),
                BitBucketComponent.class, accountName, repoSlug, objectId).getBody();
    }

    @Override
    public final void removeComponent(String accountName, String repoSlug, long objectId) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/issues/components/{object_id}"), accountName, repoSlug, objectId);
    }

    @Override
    public final List<BitBucketVersion> getVersions(String accountName, String repoSlug) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/versions"), BitBucketVersion[].class,
                        accountName, repoSlug));
    }

    @Override
    public final BitBucketVersion getVersion(String accountName, String repoSlug, long objectId) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/versions/{object_id}"), BitBucketVersion.class,
                        accountName, repoSlug, objectId);
    }

    @Override
    public final BitBucketVersion postNewVersion(String accountName, String repoSlug, String name) {
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/versions"), new VersionCreateUpdate(name), BitBucketVersion.class,
                        accountName, repoSlug);
    }

    @Override
    public final BitBucketVersion updateVersion(String accountName, String repoSlug, long objectId, String name) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/issues/versions/{object_id}"), HttpMethod.PUT,
                new HttpEntity<>(new VersionCreateUpdate(name), httpHeaders),
                BitBucketVersion.class, accountName, repoSlug, objectId).getBody();
    }

    @Override
    public final void removeVersion(String accountName, String repoSlug, long objectId) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/issues/versions/{object_id}"), accountName, repoSlug, objectId);
    }

    @Override
    public final List<BitBucketMilestone> getMilestones(String accountName, String repoSlug) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/milestones"), BitBucketMilestone[].class,
                        accountName, repoSlug));
    }

    @Override
    public final BitBucketMilestone getMilestone(String accountName, String repoSlug, long objectId) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/milestones/{object_id}"), BitBucketMilestone.class,
                        accountName, repoSlug, objectId);
    }

    @Override
    public final BitBucketMilestone postNewMilestone(String accountName, String repoSlug, String name) {
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/issues/milestones"), new MilestoneCreateUpdate(name), BitBucketMilestone.class,
                        accountName, repoSlug);
    }

    @Override
    public final BitBucketMilestone updateMilestone(String accountName, String repoSlug, long objectId, String name) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/issues/milestones/{object_id}"), HttpMethod.PUT,
                new HttpEntity<>(new MilestoneCreateUpdate(name), httpHeaders),
                BitBucketMilestone.class, accountName, repoSlug, objectId).getBody();
    }

    @Override
    public final void removeMilestone(String accountName, String repoSlug, long objectId) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/issues/milestones/{object_id}"), accountName, repoSlug, objectId);
    }

    private static class VersionCreateUpdate extends ParameterMap {
        public VersionCreateUpdate(String name) {
            set("name", name);
        }
    }

    private static class MilestoneCreateUpdate extends ParameterMap {
        public MilestoneCreateUpdate(String name) {
            set("name", name);
        }
    }

    private static class ComponentCreateUpdate extends ParameterMap {
        public ComponentCreateUpdate(String name) {
            set("name", name);
        }
    }

    private static class CommentCreateUpdate extends ParameterMap {
        public CommentCreateUpdate(String content) {
            set("content", content);
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class IssuesWrapper {

        @JsonProperty
        @Getter
        private List<BitBucketIssue> issues;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class FollowersWrapper {
        @JsonProperty
        @Getter
        private int count;
        @JsonProperty
        @Getter
        private List<BitBucketUser> followers;
    }
}

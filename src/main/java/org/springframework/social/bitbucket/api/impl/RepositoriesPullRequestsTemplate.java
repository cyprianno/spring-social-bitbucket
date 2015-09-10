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

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketComment;
import org.springframework.social.bitbucket.api.RepositoriesPullRequestsOperations;
import org.springframework.social.bitbucket.api.command.CommentCreateUpdate;
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
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments"), new CommentCreateUpdate(content, null), BitBucketComment.class,
                        accountName, repoSlug, pullRequestId);
    }

    @Override
    public  final BitBucketComment updateComment(String accountName, String repoSlug, Long pullRequestId, Long commentId, String content) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/{comment_id}"), HttpMethod.PUT,
                new HttpEntity<>(new CommentCreateUpdate(content, null), httpHeaders),
                BitBucketComment.class, accountName, repoSlug, pullRequestId, commentId).getBody();
    }

    @Override
    public  final void removeComment(String accountName, String repoSlug, Long pullRequestId, Long commentId) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/{comment_id}"), accountName, repoSlug, pullRequestId,
                commentId);
    }

    @Override
    public  final BitBucketComment toggleSpam(String accountName, String repoSlug, Long pullRequestId, Long commentId) {
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/spam/{comment_id}"), HttpMethod.PUT, null,
                BitBucketComment.class, accountName, repoSlug, pullRequestId, commentId).getBody();
    }
}

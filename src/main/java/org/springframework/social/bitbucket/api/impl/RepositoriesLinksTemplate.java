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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.*;
import org.springframework.social.bitbucket.api.command.CommentCreateUpdate;
import org.springframework.social.bitbucket.api.command.LinkCreateUpdate;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesLinksTemplate extends AbstractBitBucketOperations implements RepositoriesLinksOperations {
    public RepositoriesLinksTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketLink> getLinks(String accountName, String repoSlug) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/links"), BitBucketLink[].class,
                        accountName, repoSlug));
    }


    @Override
    public  final BitBucketLink getLink(String accountName, String repoSlug, Long linkId) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/links/{object_id}"), BitBucketLink.class,
                        accountName, repoSlug, linkId);
    }

    @Override
    public  final BitBucketLink postNewLink(String accountName, String repoSlug, LinkCreateUpdate link) {
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/links"), link, BitBucketLink.class,
                        accountName, repoSlug);
    }


    @Override
    public  final BitBucketLink updateLink(String accountName, String repoSlug, Long linkId, LinkCreateUpdate link) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/links/{object_id}"), HttpMethod.PUT,
                new HttpEntity<>(link, httpHeaders),
                BitBucketLink.class, accountName, repoSlug, linkId).getBody();
    }

    @Override
    public  final void removeLink(String accountName, String repoSlug, Long linkId) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/links/{object_id}"), accountName, repoSlug, linkId);
    }
}

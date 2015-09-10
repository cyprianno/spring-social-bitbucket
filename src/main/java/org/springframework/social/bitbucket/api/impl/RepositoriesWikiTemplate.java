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
import org.springframework.social.bitbucket.api.BitBucketIssue;
import org.springframework.social.bitbucket.api.BitBucketWikipage;
import org.springframework.social.bitbucket.api.RepositoriesWikiOperations;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesWikiTemplate extends AbstractBitBucketOperations implements RepositoriesWikiOperations {
    public RepositoriesWikiTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final BitBucketWikipage getContent(String accountName, String repoSlug, String page) {
        String pageParam = page;
        if (page.startsWith("/")) {
            pageParam = page.substring(1);
        }
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/wiki/{page}"), BitBucketWikipage.class,
                        accountName, repoSlug, pageParam);
    }

    @Override
    public final boolean postNewPage(String accountName, String repoSlug, String page, String content) {
        String pageParam = page;
        if (page.startsWith("/")) {
            pageParam = page.substring(1);
        }
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/wiki/{page}"), new WikiParamWrapper(content), String.class,
                        accountName, repoSlug, pageParam).equals("OK");
    }

    @Override
    public final boolean updatePage(String accountName, String repoSlug, String page, String content) {
        String pageParam = page;
        if (page.startsWith("/")) {
            pageParam = page.substring(1);
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_name}/wiki/{page}"), HttpMethod.PUT,
                new HttpEntity<>(new WikiParamWrapper(content), httpHeaders),
                String.class, accountName, repoSlug, pageParam).getBody().equals("OK");
    }

    private static class WikiParamWrapper extends ParameterMap {
        public WikiParamWrapper(String content) {
            add("content", content);
        }
    }
}

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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketBranch;
import org.springframework.social.bitbucket.api.BitBucketBranchesTags;
import org.springframework.social.bitbucket.api.BitBucketRepository;
import org.springframework.social.bitbucket.api.RepositoriesRepositoryOperations;
import org.springframework.social.bitbucket.api.command.RepositoryCreateUpdate;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesRepositoryTemplate extends AbstractBitBucketOperations implements RepositoriesRepositoryOperations {
    public RepositoriesRepositoryTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final BitBucketRepository createNewFork(String accountName, String repoSlug, String name, String description, String language, Boolean isPrivate) {
        RepositoryCreateUpdate repositoryData = new RepositoryCreateUpdate(name, description, language, isPrivate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/fork"), HttpMethod.POST,
                new HttpEntity<>(repositoryData, httpHeaders),
                BitBucketRepository.class, accountName, repoSlug).getBody();
    }

    @Override
    public final BitBucketRepository updateRepository(String accountName, String repoSlug, RepositoryCreateUpdate repositoryData) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}"), HttpMethod.PUT,
                new HttpEntity<>(repositoryData, httpHeaders),
                BitBucketRepository.class, accountName, repoSlug).getBody();
    }

    @Override
    public final Map<String, BitBucketBranch> getBranches(String accountName, String repositorySlug) {
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/branches"),
                HttpMethod.GET, null, new ParameterizedMapTypeReferenceBranch(),
                accountName, repositorySlug).getBody();
    }

    @Override
    public final String getMainBranch(String accountName, String repositorySlug) {
        return getRestTemplate().getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/main-branch"), BranchNameWrapper.class, accountName, repositorySlug).getName();
    }

    @Override
    public final BitBucketBranchesTags getBranchesTags(String accountName, String repositorySlug) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/branches-tags"), BitBucketBranchesTags.class,
                        accountName, repositorySlug);
    }

    @Override
    public final Map<String, String> getManifest(String accountName, String repositorySlug, String revision) {
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/{revision}"),
                HttpMethod.GET, null, new ParameterizedMapTypeReference<String, String>(),
                accountName, repositorySlug, revision).getBody();
    }

    @Override
    public final Map<String, BitBucketBranch> getTags(String accountName, String repositorySlug) {
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/tags"),
                HttpMethod.GET, null, new ParameterizedMapTypeReferenceBranch(),
                accountName, repositorySlug).getBody();
    }

    @Override
    public final String getRawSource(String accountName, String repositorySlug, String revision, String path) {
        String filePath = path.startsWith("/") ? path.substring(1) : path;
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/raw/{revision}/{path}"), String.class,
                        accountName, repositorySlug, revision, filePath);
    }

    @Override
    public final BitBucketBranch getHistoryOfFile(String accountName, String repositorySlug, String node, String path) {
        return getRestTemplate().getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/filehistory/{node}/{path}"), BitBucketBranch.class, accountName, repositorySlug, node, path);
    }

    private static class BranchNameWrapper {
        @JsonProperty
        @Getter
        private String name;
    }

    private static class ParameterizedMapTypeReference<T,R> extends ParameterizedTypeReference<Map<T,R>> {}

    public static class ParameterizedMapTypeReferenceBranch extends ParameterizedTypeReference<Map<String, BitBucketBranch>> {

    }

}

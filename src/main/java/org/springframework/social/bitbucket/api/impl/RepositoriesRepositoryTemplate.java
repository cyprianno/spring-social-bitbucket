package org.springframework.social.bitbucket.api.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.*;
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
    public final BitBucketRepository createNewFork(String accountName, String repositorySlug, String name, String description, String language, Boolean isPrivate) {
        return null;
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
                HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, BitBucketBranch>>() {
        },
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
                HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, String>>() {
                },
                accountName, repositorySlug, revision).getBody();
    }

    @Override
    public final Map<String, BitBucketBranch> getTags(String accountName, String repositorySlug) {
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/tags"),
                HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, BitBucketBranch>>() {
                },
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

}

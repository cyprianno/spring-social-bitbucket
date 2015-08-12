package org.springframework.social.bitbucket.api.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.social.bitbucket.api.*;
import org.springframework.social.bitbucket.api.command.RepositoryCreateUpdate;
import org.springframework.web.client.RestTemplate;

import java.util.List;
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
    public  final BitBucketRepository createNewFork(String accountName, String repositorySlug, String name, String description, String language, Boolean isPrivate) {
        return null;
    }

    @Override
    public  final BitBucketRepository updateRepository(String accountName, String repositorySlug, RepositoryCreateUpdate respositoryData) {
        return null;
    }

    @Override
    public  final Map<String, BitBucketBranch> getBranches(String accountName, String repositorySlug) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/branches"), BranchWrapper.class,
                        accountName, repositorySlug).getBranches();
    }

    @Override
    public  final String getMainBranch(String accountName, String repositorySlug) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/main-branch"), String.class,
                        accountName, repositorySlug);
    }

    @Override
    public  final BitBucketBranchesTags getBranchesTags(String accountName, String repositorySlug) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/branches-tags"), BitBucketBranchesTags.class,
                        accountName, repositorySlug);
    }

    @Override
    public  final Map<String, String> getManifest(String accountName, String repositorySlug, String revision) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/{revision}"), BranchesTagsWrapper.class,
                        accountName, repositorySlug, revision).getManifest() ;
    }

    @Override
    public  final Map<String, BitBucketBranch> getTags(String accountName, String repositorySlug) {
        return null;
    }

    @Override
    public  final String getRawSource(String accountName, String repositorySlug, String revision, String path) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/raw/{revision}/{path}"), String.class,
                        accountName, repositorySlug, revision, path);
    }

    @Override
    public  final BitBucketBranch getHistoryOfFile(String accountName, String repositorySlug, String node, String path) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/filehistory/{node}/{path}"), BitBucketBranch.class,
                        accountName, repositorySlug, node, path);
    }


    private static class BranchWrapper {
        @JsonProperty @Getter
        private String master;
        @JsonProperty @Getter
        private Map<String, BitBucketBranch> branch;

        public Map<String,BitBucketBranch> getBranches() {

            return branch;
        }
    }
    private static class BranchesTagsWrapper {
        @JsonProperty @Getter
        private Map<String, String> readme;

        public Map<String,String> getManifest() {
            return readme;}
        }
    }

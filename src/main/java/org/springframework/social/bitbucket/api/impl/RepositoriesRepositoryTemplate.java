package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketBranch;
import org.springframework.social.bitbucket.api.BitBucketBranchesTags;
import org.springframework.social.bitbucket.api.BitBucketRepository;
import org.springframework.social.bitbucket.api.RepositoriesRepositoryOperations;

import java.util.List;
import java.util.Map;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesRepositoryTemplate implements RepositoriesRepositoryOperations {
    @Override
    public BitBucketRepository createNewFork(String accountName, String repositorySlug, String name, String description, String language, Boolean isPrivate) {
        return null;
    }

    @Override
    public BitBucketRepository updateRepository(String accountName, String repositorySlug, BitBucketRepository respositoryData) {
        return null;
    }

    @Override
    public Map<String, BitBucketBranch> getBranches(String accountName, String repositorySlug) {
        return null;
    }

    @Override
    public String getMainBranch(String accountName, String repositorySlug) {
        return null;
    }

    @Override
    public List<BitBucketBranchesTags> getBranchesTags(String accountName, String repositorySlug) {
        return null;
    }

    @Override
    public Map<String, String> getManifest(String accountName, String repositorySlug, String revision) {
        return null;
    }

    @Override
    public Map<String, BitBucketBranch> getTags(String accountName, String repositorySlug) {
        return null;
    }

    @Override
    public String getRawSource(String accountName, String repositorySlug, String revision, String path) {
        return null;
    }

    @Override
    public BitBucketBranch getHistoryOfFile(String accountName, String repositorySlug, String node, String path) {
        return null;
    }
}

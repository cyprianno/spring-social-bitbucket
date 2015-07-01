package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketBranch;
import org.springframework.social.bitbucket.api.BitBucketBranchesTags;
import org.springframework.social.bitbucket.api.BitBucketRepository;
import org.springframework.social.bitbucket.api.RepositoriesRepositoryOperations;
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
    public  final BitBucketRepository updateRepository(String accountName, String repositorySlug, BitBucketRepository respositoryData) {
        return null;
    }

    @Override
    public  final Map<String, BitBucketBranch> getBranches(String accountName, String repositorySlug) {
        return null;
    }

    @Override
    public  final String getMainBranch(String accountName, String repositorySlug) {
        return null;
    }

    @Override
    public  final List<BitBucketBranchesTags> getBranchesTags(String accountName, String repositorySlug) {
        return null;
    }

    @Override
    public  final Map<String, String> getManifest(String accountName, String repositorySlug, String revision) {
        return null;
    }

    @Override
    public  final Map<String, BitBucketBranch> getTags(String accountName, String repositorySlug) {
        return null;
    }

    @Override
    public  final String getRawSource(String accountName, String repositorySlug, String revision, String path) {
        return null;
    }

    @Override
    public  final BitBucketBranch getHistoryOfFile(String accountName, String repositorySlug, String node, String path) {
        return null;
    }
}

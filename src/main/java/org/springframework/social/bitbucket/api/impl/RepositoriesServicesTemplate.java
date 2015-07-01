package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketService;
import org.springframework.social.bitbucket.api.RepositoriesServicesOperations;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesServicesTemplate implements RepositoriesServicesOperations {
    @Override
    public List<BitBucketService> getServices(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public BitBucketService getService(String accountName, String repoSlug, Long serviceId) {
        return null;
    }

    @Override
    public BitBucketService postNewService(String accountName, String repoSlug, String type, List<BitBucketService.BitBucketServiceProfileField> fields) {
        return null;
    }

    @Override
    public BitBucketService updateService(String accountName, String repoSlug, String serviceId, List<BitBucketService.BitBucketServiceProfileField> fields) {
        return null;
    }

    @Override
    public void removeService(String accountName, String repoSlug, String serviceId) {

    }
}

package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketDeployKey;
import org.springframework.social.bitbucket.api.RepositoriesDeployKeysOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesDeployKeysTemplate extends AbstractBitBucketOperations implements RepositoriesDeployKeysOperations {
    public RepositoriesDeployKeysTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public  final List<BitBucketDeployKey> getDeployKeys(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public  final BitBucketDeployKey getDeployKey(String accountName, String repoSlug, Long pk) {
        return null;
    }

    @Override
    public  final BitBucketDeployKey postDeployKey(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public  final void removeDeployKey(String accountName, String repoSlug, Long pk) {

    }
}

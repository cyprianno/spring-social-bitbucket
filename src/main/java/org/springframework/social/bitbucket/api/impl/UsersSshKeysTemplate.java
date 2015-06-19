package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketSshKey;
import org.springframework.social.bitbucket.api.UsersSshKeysOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class UsersSshKeysTemplate extends AbstractBitBucketOperations implements UsersSshKeysOperations {
    public UsersSshKeysTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public List<BitBucketSshKey> getKeys(String accountName) {
        return null;
    }

    @Override
    public BitBucketSshKey postKey(String accountName, String label, String key) {
        return null;
    }

    @Override
    public BitBucketSshKey getKey(String accountName, String keyId, String label) {
        return null;
    }

    @Override
    public void removeKey(String accountName, String keyId) {

    }
}

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
    public final List<BitBucketSshKey> getKeys(String accountName) {
        return null;
    }

    @Override
    public final BitBucketSshKey postKey(String accountName, String label, String key) {
        return null;
    }

    @Override
    public final BitBucketSshKey getKey(String accountName, long keyId, String label) {
        return null;
    }

    @Override
    public final void removeKey(String accountName, long keyId) {

    }
}

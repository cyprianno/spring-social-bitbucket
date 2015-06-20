package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketSshKey;
import org.springframework.social.bitbucket.api.UsersSshKeysOperations;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

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
        return asList(getRestTemplate().getForObject(buildUrl("/users/{accountname}/ssh-keys"), BitBucketSshKey[].class, accountName));
    }

    @Override
    public final BitBucketSshKey postKey(String accountName, String label, String key) {
        return getRestTemplate()
                .postForObject(buildUrl("/users/{accountname}/ssh-keys"), new CreateKeyParameters(key), BitBucketSshKey[].class, accountName)[0];
    }

    @Override
    public final BitBucketSshKey getKey(String accountName, long keyId, String label) {
        String queryKey = label != null ? label : String.valueOf(keyId);
        List<BitBucketSshKey> result = asList(
                getRestTemplate().getForObject(buildUrl("/users/{accountname}/ssh-keys/{key_id}"), BitBucketSshKey[].class, accountName, queryKey));
        return result.isEmpty() ? null : result.iterator().next();
    }

    @Override
    public final void removeKey(String accountName, long keyId) {
        getRestTemplate().delete(buildUrl("/users/{accountname}/ssh-keys/{key_id}"), accountName, keyId);
    }

    private static class CreateKeyParameters extends ParameterMap {
        public CreateKeyParameters(String key) {
            set("key", key);
        }
    }
}

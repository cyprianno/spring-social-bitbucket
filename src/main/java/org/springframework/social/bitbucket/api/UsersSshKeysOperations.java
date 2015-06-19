package org.springframework.social.bitbucket.api;

/**
 * Use the ssh-keys resource to manipulate the ssh-keys on an individual or team account.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/ssh-keys+Resource"
 * @since 2.0.0
 */
public interface UsersSshKeysOperations {
    void getKeys(String accountName);

    void postKey(String accountName, String label, String key);

    void getKey(String accountName, String keyId, String label);

    void removeKey(String accountName, String keyId);
}


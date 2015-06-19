package org.springframework.social.bitbucket.api;

/**
 * Use the ssh-keys resource to manipulate the ssh-keys on an individual or team account.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/ssh-keys+Resource"
 * @since 2.0.0
 */
public interface UsersSshKeysOperations {

    /**
     * Gets a list of the keys associated with an account. This call requires authentication.
     * GET https://bitbucket.org/api/1.0/users/{accountname}/ssh-keys
     *
     * @param accountName The name of an individual or team account.
     */
    void getKeys(String accountName);

    /**
     * Creates a key on the specified account.
     * You must supply a valid key that is unique across the Bitbucket service.
     * A public key contains characters need to be escaped before sending it as a POST data.
     * So, use the proper escaping ( urlencode ), if you are testing to add a key via your terminal.
     * POST https://bitbucket.org/api/1.0/users/{accountname}/ssh-keys --data "key=value"
     *
     * @param accountName The name of an individual or team account.
     * @param label       A label for the key.
     * @param key         The key value.
     */
    void postKey(String accountName, String label, String key);

    /**
     * Gets the content of the specified key_id. This call requires authentication. This call requires authentication.
     * GET https://bitbucket.org/api/1.0/users/{accountname}/ssh-keys/{key_id}
     *
     * @param accountName The name of an individual or team account.
     * @param keyId       The key identifier. This is an internal value created by Bitbucket when the key is added.
     * @param label       A label for the key.
     */
    void getKey(String accountName, String keyId, String label);

    /**
     * Deletes the key specified by the key_id value. This call requires authentication.
     * DELETE https://bitbucket.org/api/1.0/users/{accountname}/ssh-keys/{key_id}
     *
     * @param accountName The name of an individual or team account.
     * @param keyId       The key identifier. This is an internal value created by Bitbucket when the key is added.
     */
    void removeKey(String accountName, String keyId);
}


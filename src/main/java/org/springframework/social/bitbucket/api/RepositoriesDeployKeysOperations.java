package org.springframework.social.bitbucket.api;

import java.util.List;

/**
 * Manage ssh keys used for deploying product builds. All the calls for this resource require authentication as the account owner.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/deploy-keys+Resource"
 * @since 2.0.0
 */
public interface RepositoriesDeployKeysOperations {

    /**
     * Gets a list of the keys associated with an repository.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/deploy-keys
     *
     * @param accountName The team or individual account.
     * @param repoSlug    The repo identifier (not to be confused with the repo's name).
     * @return List of deploy keys.
     */
    List<BitBucketDeployKey> getDeployKeys(String accountName, String repoSlug);

    /**
     * Gets the content of the specified key_id. This call requires authentication.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/deploy-keys/{pk}
     *
     * @param accountName The team or individual account.
     * @param repoSlug    The repo identifier (not to be confused with the repo's name).
     * @param pk          The key identifier assigned by Bitbucket. Use the GET call to obtain this value.
     * @return Specified deploy key.
     */
    BitBucketDeployKey getDeployKey(String accountName, String repoSlug, Long pk);

    /**
     * Creates a key on the specified account. You must supply a valid key that is unique across the Bitbucket service.
     * A public key contains characters need to be escaped before sending it as a POST data.
     * So, use the proper escaping ( urlencode ), if you are testing to add a key via your terminal.
     * This call requires authentication.
     * API call: POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/deploy-keys --data "key=value"
     *
     * @param accountName The team or individual account.
     * @param repoSlug    The repo identifier (not to be confused with the repo's name).
     * @param key         The key.
     * @return Created deploy key.
     */
    BitBucketDeployKey postDeployKey(String accountName, String repoSlug, String key);

    /**
     * Deletes the key specified by the key_id value. This call requires authentication.
     * API call: DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/deploy-keys/{pk}
     *
     * @param accountName The team or individual account.
     * @param repoSlug    The repo identifier (not to be confused with the repo's name).
     * @param pk          The key identifier assigned by Bitbucket. Use the GET call to obtain this value.
     */
    void removeDeployKey(String accountName, String repoSlug, Long pk);
}

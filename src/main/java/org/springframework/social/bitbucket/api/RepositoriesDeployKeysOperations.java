package org.springframework.social.bitbucket.api;

/**
 * Manage ssh keys used for deploying product builds. All the calls for this resource require authentication as the account owner.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/deploy-keys+Resource"
 * @since 2.0.0
 */
public interface RepositoriesDeployKeysOperations {

    void getDeployKeys();

    void getDeployKey();

    void postDeployKey();

    void removeDeployKey();
}
/*- TBD GET a list of keys
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/deploy-keys
- TBD GET the key's content
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/deploy-keys/{pk}
- TBD POST a new key
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/deploy-keys --data "key=value"
- TBD DELETE a key
DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/deploy-keys/{pk}*/
package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.*;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

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
        return asList(getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/deploy-keys"), BitBucketDeployKey[].class,
                        accountName, repoSlug));
    }

    @Override
    public  final BitBucketDeployKey getDeployKey(String accountName, String repoSlug, Long pk) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/deploy-keys/{pk}"), BitBucketDeployKey.class,
                        accountName, repoSlug, pk);
    }

    @Override
    public  final BitBucketDeployKey postDeployKey(String accountName, String repoSlug, String key) {
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/deploy-keys"), new DeployKeyCreate(key), BitBucketDeployKey.class,
                        accountName, repoSlug);
    }

    @Override
    public  final void removeDeployKey(String accountName, String repoSlug, Long pk) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/deploy-keys/{pk}"), accountName, repoSlug, pk);

    }

    private class DeployKeyCreate extends ParameterMap {
        public DeployKeyCreate(String key) {
            set("key", key);
        }
    }
}

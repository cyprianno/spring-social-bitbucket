package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketChangeset;
import org.springframework.social.bitbucket.api.BitBucketDeployKey;
import org.springframework.social.bitbucket.api.BitBucketRepositoryStatistics;
import org.springframework.social.bitbucket.api.RepositoriesDeployKeysOperations;
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
    public  final BitBucketDeployKey postDeployKey(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public  final void removeDeployKey(String accountName, String repoSlug, Long pk) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/deploy-keys/{pk}"), accountName, repoSlug, pk);

    }
}

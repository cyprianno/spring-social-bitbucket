package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketDeployKey;
import org.springframework.social.bitbucket.api.BitBucketUser;
import org.springframework.social.bitbucket.api.RepositoriesFollowersOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesFollowersTemplate extends AbstractBitBucketOperations implements RepositoriesFollowersOperations {
    public RepositoriesFollowersTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketUser> getFollowers(String accountName, String repoSlug) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/followers"), BitBucketUser[].class,
                        accountName, repoSlug));
    }
}

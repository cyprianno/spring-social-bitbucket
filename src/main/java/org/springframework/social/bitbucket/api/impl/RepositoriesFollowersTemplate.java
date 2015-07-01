package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketUser;
import org.springframework.social.bitbucket.api.RepositoriesFollowersOperations;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesFollowersTemplate implements RepositoriesFollowersOperations {
    @Override
    public List<BitBucketUser> getFollowers(String accountName, String repoSlug) {
        return null;
    }
}

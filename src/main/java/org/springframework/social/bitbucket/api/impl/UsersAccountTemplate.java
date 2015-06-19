package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketEvent;
import org.springframework.social.bitbucket.api.BitBucketUser;
import org.springframework.social.bitbucket.api.UserWithRepositories;
import org.springframework.social.bitbucket.api.UsersAccountOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class UsersAccountTemplate extends AbstractBitBucketOperations implements UsersAccountOperations {
    public UsersAccountTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public UserWithRepositories getProfile(String accountName) {
        return null;
    }

    @Override
    public Long getPlan(String accountName) {
        return null;
    }

    @Override
    public List<BitBucketUser> getFollowers(String accountName) {
        return null;
    }

    @Override
    public List<BitBucketEvent> getEvents(String accountName) {
        return null;
    }
}

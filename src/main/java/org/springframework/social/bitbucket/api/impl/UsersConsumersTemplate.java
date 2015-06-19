package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketConsumer;
import org.springframework.social.bitbucket.api.UsersConsumersOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class UsersConsumersTemplate extends AbstractBitBucketOperations implements UsersConsumersOperations {
    public UsersConsumersTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketConsumer> getConsumers(String accountName) {
        return null;
    }

    @Override
    public final BitBucketConsumer getConsumer(String accountName, long id) {
        return null;
    }

    @Override
    public final BitBucketConsumer updateConsumer(String accountName, long id, String name, String description, String url) {
        return null;
    }

    @Override
    public final void removeConsumer(String accountName, long id) {

    }
}

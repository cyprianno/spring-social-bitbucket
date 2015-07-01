package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketEvent;
import org.springframework.social.bitbucket.api.RepositoriesEventsOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesEventsTemplate extends AbstractBitBucketOperations implements RepositoriesEventsOperations {
    public RepositoriesEventsTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public List<BitBucketEvent> getEvents(String accountName, String repoSlug, Integer start, Integer limit, String type) {
        return null;
    }
}

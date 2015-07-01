package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketEvent;
import org.springframework.social.bitbucket.api.RepositoriesEventsOperations;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesEventsTemplate implements RepositoriesEventsOperations {
    @Override
    public List<BitBucketEvent> getEvents(String accountName, String repoSlug, Integer start, Integer limit, String type) {
        return null;
    }
}

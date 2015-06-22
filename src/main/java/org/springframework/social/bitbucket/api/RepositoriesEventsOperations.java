package org.springframework.social.bitbucket.api;

import java.util.List;

/**
 * You can use events to track events that occur on public repositories or private repositories that you have access to.
 * Currently, Bitbucket does not support displaying events from private repositories.
 * This endpoint does not require authentication and is a read-only resource.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/events+Resources"
 * @since 2.0.0
 */
public interface RepositoriesEventsOperations {

    List<BitBucketEvent> getEvents(String accountName, String repoSlug, Integer start, Integer limit);
}
/*- TBD GET a list of events
GET https:// bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/events?limit=integer&start=integer&type=event
*/
/**
 * Copyright (C) 2012 Eric Bottard / Guillaume Lederrey (eric.bottard+ghpublic@gmail.com / guillaume.lederrey@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

    /**
     * Gets a list of a repository's events associated with the specified repo_slug.
     * By default, this call returns the top 25 events.
     * API call: GET https:// bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/events?limit=integer&start=integer&type=event
     *
     * @param accountName The team or individual account owning the repo.
     * @param repoSlug The repo identifier.
     * @param start Could be null. An integer specifying the offset to start with. By default, this call starts with 0.
     * @param limit Could be null. An integer specifying the number of events to return. You can specify a value between 0 and 50.
     *              If you specify 0, the system returns the count but the events array is empty.
     * @param type Could be null. The event type to return. If you specify a type parameter,
     *             the count contains the total number of events of that type associated with the account.
     * @return List of events.
     */
    List<BitBucketEvent> getEvents(String accountName, String repoSlug, Integer start, Integer limit, String type);
}

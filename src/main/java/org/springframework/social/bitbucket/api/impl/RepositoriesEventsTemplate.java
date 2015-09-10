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
package org.springframework.social.bitbucket.api.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.social.bitbucket.api.BitBucketDiff;
import org.springframework.social.bitbucket.api.BitBucketEvent;
import org.springframework.social.bitbucket.api.RepositoriesEventsOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesEventsTemplate extends AbstractBitBucketOperations implements RepositoriesEventsOperations {
    public RepositoriesEventsTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketEvent> getEvents(String accountName, String repoSlug, Integer start, Integer limit, String type) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/events?limit={limit}&start={start}&type={type}"), EventsWrapper.class,
                        accountName, repoSlug, start, limit, type).getEvents();
    }

    private static class EventsWrapper
    {@JsonProperty
    @Getter
    private int count;
        @JsonProperty @Getter
        private List<BitBucketEvent> events;

    }
}

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import org.springframework.social.bitbucket.api.impl.UTCDateDeserializer;
import org.springframework.social.bitbucket.utils.DateUtils;

import java.util.Date;

/**
 * Describes an event.
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketEvent {

    /**
     * If the event is a commit, this field contains the changset node. Otherwise, this field contains null.
     */
    @JsonProperty
    @Getter
    private String node;

    /**
     * If the event is a commit, this field contains the commit from the raw commit.Otherwise, this field contains null
     */
    @JsonProperty
    @Getter
    private String description;

    /**
     * Contains a repository structure if the event was on a specific repository. Otherwise, this field contains null.
     */
    @JsonProperty
    @Getter
    private BitBucketRepository repository;

    /**
     * The time the event occurred. If the event was a commit, this is the time from the raw commit.
     */
    @JsonProperty("created_on")
    @JsonDeserialize(using = UTCDateDeserializer.class)
    private Date createdOn;

    /**
     * Contains the user profile structure.
     */
    @JsonProperty
    @Getter
    private BitBucketUser user;

    /**
     * Universal time clock time of the event.
     */
    @JsonProperty("utc_created_on")
    @JsonDeserialize(using = UTCDateDeserializer.class)
    private Date utcCreatedOn;

    /**
     * The event type.
     */
    @JsonProperty
    @Getter
    private String event;

    public final Date getCreatedOn() {
        return DateUtils.copyNullable(createdOn);
    }

    public final Date getUtcCreatedOn() {
        return DateUtils.copyNullable(utcCreatedOn);
    }
}

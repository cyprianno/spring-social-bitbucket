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

import java.io.Serializable;
import java.util.Date;

/**
 * A BitBucket repository, possibly with additional metadata.
 *
 * @author ericbottard
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketRepository implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("is_private")
    private boolean isPrivate;

    @JsonProperty("utc_created_on")
    @JsonDeserialize(using = UTCDateDeserializer.class)
    private Date createdAt;

    @JsonProperty @Getter
    private String website;

    /** A description of the repository, as entered by its creator. */
    @JsonProperty @Getter
    private String description;

    @JsonProperty("has_wiki")
    private boolean hasWiki;

    @JsonProperty("utc_last_updated")
    @JsonDeserialize(using = UTCDateDeserializer.class)
    private Date lastUpdatedOn;

    /** A user friendly name for this repository (may differ from its {@link #getSlug() slug}). */
    @JsonProperty @Getter
    private String name;

    /** The username of the repository owner. */
    @JsonProperty @Getter
    private String owner;

    @JsonProperty("read_only") @Getter
    private boolean readOnly;

    /** The source control management system this repository uses. */
    @JsonProperty @Getter
    private BitBucketSCM scm;

    /** The size of this repository, in bytes. */
    @JsonProperty @Getter
    private long size;

    /** This repository's "slug", <i>ie.</i> its technical id in BitBucket terms. */
    @JsonProperty @Getter
    private String slug;

    @JsonProperty @Getter
    private String logo;

    @JsonProperty("email_mailinglist") @Getter
    private String emailMailingList;

    @JsonProperty @Getter
    private String language;

    @JsonProperty @Getter
    private String state;

    @JsonProperty("resource_uri") @Getter
    private String resourceUri;

    @JsonProperty("fork_of") @Getter
    private BitBucketRepository forkOf;

    @JsonProperty @Getter
    private boolean mq;

    @JsonProperty("mq_of") @Getter
    private BitBucketRepository mqOf;

    @JsonProperty("has_issues") @Getter
    private boolean hasIssues;

    @JsonProperty @Getter
    private boolean fork;

    @JsonProperty("email_writers") @Getter
    private boolean emailWriters;

    @JsonProperty("no_public_forks") @Getter
    private boolean noPublicForks;

    @JsonProperty("followers_count") @Getter
    private long followersCount;

    /** The date when the repository was created. */
    public final Date getCreatedAt() {
        if (createdAt == null) {
            return null;
        }
        return (Date) createdAt.clone();
    }

    /** When this repository was last updated. */
    public final Date getLastUpdatedOn() {
        if (lastUpdatedOn == null) {
            return null;
        }
        return (Date) lastUpdatedOn.clone();
    }

    /**
     * Whether this repository has an attached wiki.
     */
    public final boolean isHasWiki() {
        return hasWiki;
    }

    /**
     * Whether this repository is private (authenticated user needs access to
     * it) or is for everyone to see.
     */
    public final boolean isPrivate() {
        return isPrivate;
    }

}

package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

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
    @Getter
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
    @Getter
    private Date utcCreatedOn;

    /**
     * The event type.
     */
    @JsonProperty
    @Getter
    private String event;
}

package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;
import org.springframework.social.bitbucket.api.impl.UTCDateDeserializer;
import org.springframework.social.bitbucket.utils.DateUtils;

import java.util.Date;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class BitBucketIssue {

    public class BitBucketIssueMetadata {
        @JsonProperty @Getter
        private String kind;
        @JsonProperty @Getter
        private String version;
        @JsonProperty @Getter
        private String component;
        @JsonProperty @Getter
        private String milestone;
    }

    @JsonProperty @Getter
    private String status;

    @JsonProperty @Getter
    private String priority;

    @JsonProperty @Getter
    private String title;

    @JsonProperty @JsonDeserialize(using = UTCDateDeserializer.class)
    private Date utcLastUpdated;

    @JsonProperty @Getter
    private long commentCount;

    @JsonProperty @Getter
    private BitBucketIssueMetadata metadata;

    @JsonProperty @Getter
    private String content;

    @JsonProperty @JsonDeserialize(using = UTCDateDeserializer.class)
    private Date createdOn;

    @JsonProperty @JsonDeserialize(using = UTCDateDeserializer.class)
    private Date utcCreatedOn;

    @JsonProperty @Getter
    private long localId;

    @JsonProperty @Getter
    private long followerCount;

    @JsonProperty @Getter
    private String resourceUri;

    @JsonProperty @Getter
    private boolean spam;

    public Date getUtcLastUpdated() {
        return DateUtils.copyNullable(utcLastUpdated);
    }

    public Date getCreatedOn() {
        return DateUtils.copyNullable(createdOn);
    }

    public Date getUtcCreatedOn() {
        return DateUtils.copyNullable(utcCreatedOn);
    }
}

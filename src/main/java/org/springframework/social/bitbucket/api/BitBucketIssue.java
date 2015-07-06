package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

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

    @JsonProperty @Getter
    private Date utcLastUpdated;

    @JsonProperty @Getter
    private Long commentCount;

    @JsonProperty @Getter
    private BitBucketIssueMetadata metadata;

    @JsonProperty @Getter
    private String content;

    @JsonProperty @Getter
    private Date createdOn;

    @JsonProperty @Getter
    private Date utcCreatedOn;

    @JsonProperty @Getter
    private Long localId;

    @JsonProperty @Getter
    private Long followerCount;

    @JsonProperty @Getter
    private String resourceUri;

    @JsonProperty @Getter
    private boolean spam;
}

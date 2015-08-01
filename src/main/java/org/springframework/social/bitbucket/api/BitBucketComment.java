package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import org.springframework.social.bitbucket.api.impl.UTCDateDeserializer;
import org.springframework.social.bitbucket.utils.DateUtils;

import java.util.Date;

/**
 * Comment with metadata.
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = BitBucketComment.BitBucketCommentBuilder.class)
public class BitBucketComment {
    @JsonPOJOBuilder(withPrefix = "")
    public static final class BitBucketCommentBuilder {
        @JsonProperty(value = "comment_id")
        public BitBucketCommentBuilder commentId(Long commentId) {
            return this;
        }
    }

    @JsonProperty @Getter
    private String username;

    @JsonProperty @Getter
    private String node;

    @JsonProperty(value = "comment_id") @Getter
    private long commentId;

    @JsonProperty("pull_request_id") @Getter
    private long pullRequestId;

    @JsonProperty("display_name") @Getter
    private String displayName;

    @JsonProperty("parent_id") @Getter
    private long parentId;

    @JsonProperty @Getter
    private boolean deleted;

    @JsonProperty("utc_last_updated") @JsonDeserialize(using = UTCDateDeserializer.class)
    private Date utcLastUpdated;

    @JsonProperty("filename_hash") @Getter
    private String filenameHash;

    @JsonProperty @Getter
    private String filename;

    @JsonProperty @Getter
    private String content;

    @JsonProperty("content_rendered") @Getter
    private String contentRendered;

    @JsonProperty("user_avatar_url") @Getter
    private String userAvatarUrl;

    @JsonProperty("line_from") @Getter
    private long lineFrom;

    @JsonProperty("line_to") @Getter
    private long lineTo;

    @JsonProperty("author_info") @Getter
    private BitBucketUser authorInfo;

    @JsonProperty("utc_created_on") @JsonDeserialize(using = UTCDateDeserializer.class)
    private Date utcCreatedOn;

    @JsonProperty("is_spam") @Getter
    private boolean spam;

    @JsonProperty("base_rev") @Getter
    private String baseRev;

    @JsonProperty("anchor") @Getter
    private String anchor;

    @JsonProperty("dest_rev") @Getter
    private String destRev;

    public Date getUtcLastUpdated() {
        return DateUtils.copyNullable(utcLastUpdated);
    }

    public Date getUtcCreatedOn() {
        return DateUtils.copyNullable(utcCreatedOn);
    }
}

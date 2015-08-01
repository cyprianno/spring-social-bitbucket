package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import org.springframework.social.bitbucket.api.impl.UTCDateDeserializer;
import org.springframework.social.bitbucket.utils.DateUtils;

import javax.annotation.Nullable;
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
    private Long pullRequestId;

    @JsonProperty("display_name") @Getter
    private String displayName;

    @JsonProperty("parent_id") @Getter
    @Nullable
    private Long parentId;

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
    private Long lineFrom;

    @JsonProperty("line_to") @Getter
    private Long lineTo;

    @JsonProperty("author_info") @Getter
    private BitBucketUser authorInfo;

    @JsonProperty("utc_created_on") @JsonDeserialize(using = UTCDateDeserializer.class)
    private Date utcCreatedOn;

    @JsonProperty("is_spam") @Getter
    private boolean spam;

    public Date getUtcLastUpdated() {
        return DateUtils.copyNullable(utcLastUpdated);
    }

    public Date getUtcCreatedOn() {
        return DateUtils.copyNullable(utcCreatedOn);
    }
}

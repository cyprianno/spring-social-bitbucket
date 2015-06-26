package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;

/**
 * Comment with metadata.
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class BitBucketComment {
    @JsonProperty @Getter
    private String username;

    @JsonProperty @Getter
    private String node;

    @JsonProperty("comment_id") @Getter
    private Long commentId;

    @JsonProperty("pull_request_id") @Getter
    private Long pullRequestId;

    @JsonProperty("display_name") @Getter
    private String displayName;

    @JsonProperty("parent_id") @Getter
    private Long parentId;

    @JsonProperty @Getter
    private boolean deleted;

    @JsonProperty("utc_last_updated") @Getter
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

    @JsonProperty("utc_created_on") @Getter
    private Date utcCreatedOn;

    @JsonProperty("is_spam") @Getter
    private boolean spam;

}

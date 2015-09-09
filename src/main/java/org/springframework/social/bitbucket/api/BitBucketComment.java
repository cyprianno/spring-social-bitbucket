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

import javax.annotation.Nullable;
import java.util.Date;

/**
 * Comment with metadata.
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketComment {

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
    @Nullable
    private Long lineFrom;

    @JsonProperty("line_to") @Getter
    @Nullable
    private Long lineTo;

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

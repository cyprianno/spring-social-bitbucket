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
import java.util.List;
import java.util.Set;

/**
 * Branch full info.
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketBranch {

    @JsonProperty @Getter
    private String node;
    @JsonProperty @Getter
    private List<BitBucketFile> files;
    @JsonProperty @Getter
    private String rawAuthor;
    @JsonProperty @JsonDeserialize(using = UTCDateDeserializer.class)
    private Date utcTimestamp;
    @JsonProperty @Getter
    private String author;
    @JsonProperty @JsonDeserialize(using = UTCDateDeserializer.class)
    private Date timestamp;
    @JsonProperty @Getter
    private String rawNode;
    @JsonProperty @Getter
    private Set<String> parents;
    @JsonProperty @Getter
    private String branch;
    @JsonProperty @Getter
    private String message;
    @JsonProperty @Getter
    private String revision;
    @JsonProperty @Getter
    private Long size;

    public Date getUtcTimestamp() {
        return DateUtils.copyNullable(utcTimestamp);
    }

    public Date getTimestamp() {
        return DateUtils.copyNullable(timestamp);
    }
}

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
import lombok.Getter;

import javax.annotation.Nullable;
import java.io.Serializable;

/**
 * Statistics data about repository file.
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketRepositoryStatistics implements Serializable {

    /**
     * Change statistics in numbers; Instance exists only as a part of BitBucketRepositoryStatistics.
     */
    public static class BitBucketDiffstat implements Serializable {
        /**
         * Number of lines removed.
         * Could be null if it is a large difference
         */
        @JsonProperty @Getter @Nullable
        private Long removed;
        /**
         * Number of lines added.
         * Could be null if it is a large difference
         */
        @JsonProperty @Getter @Nullable
        private Long added;
    }

    /**
     * Type of file change. Currently known values are:
     * added, modified
     */
    @JsonProperty @Getter
    private BitBucketFileModificationType type;

    /**
     * Changed file name.
     */
    @JsonProperty @Getter
    private String file;

    /**
     * Change statistics.
     */
    @JsonProperty@Getter
    private BitBucketDiffstat diffstat;

}

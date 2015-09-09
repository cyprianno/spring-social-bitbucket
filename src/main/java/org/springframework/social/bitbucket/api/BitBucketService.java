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

import java.util.ArrayList;
import java.util.List;

/**
 * BitBucket Service info.
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketService {

    public static class BitBucketServiceProfile {
        @JsonProperty @Getter
        private List<BitBucketServiceProfileField> fields = new ArrayList<>();
        @JsonProperty @Getter
        private String type;
    }

    public static class BitBucketServiceProfileField {

        @JsonProperty @Getter
        private String name;
        @JsonProperty @Getter
        private String value;
    }

    @JsonProperty @Getter
    private long id;

    @JsonProperty @Getter
    private BitBucketServiceProfile service;
}

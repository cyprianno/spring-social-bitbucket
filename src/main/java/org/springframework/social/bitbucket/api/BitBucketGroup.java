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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty
    private String name;

    @JsonProperty
    private BitBucketPrivilege permission;

    @JsonProperty("auto_add")
    private boolean autoAdd;

    @JsonProperty
    private String slug;

    @JsonProperty
    private List<BitBucketUser> members = new ArrayList<>();

    @JsonProperty
    private BitBucketUser owner;

    public final String getName() {
        return name;
    }

    public final BitBucketPrivilege getPermission() {
        return permission;
    }

    public final boolean isAutoAdd() {
        return autoAdd;
    }

    public final String getSlug() {
        return slug;
    }

    public final List<BitBucketUser> getMembers() {
        return members;
    }

    public final BitBucketUser getOwner() {
        return owner;
    }
}

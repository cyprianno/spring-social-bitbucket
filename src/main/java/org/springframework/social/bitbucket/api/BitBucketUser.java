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
 * A BitBucket user account.
 *
 * @author Eric Bottard
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketUser implements Serializable {

    /**
     * User name
     */
    @JsonProperty @Getter
    private String username;

    /**
     * First name
     */
    @JsonProperty("first_name") @Getter
    private String firstName;

    /**
     * Last name
     */
    @JsonProperty("last_name") @Getter
    private String lastName;

    /**
     * Is a Team?
     * Could be null if data was fetched by unauthorized user.
     */
    @JsonProperty("is_team") @Getter
    @Nullable
    private Boolean team;

    /**
     * Avatar url (by default Gravatar is used)
     */
    @JsonProperty("avatar") @Getter
    private String avatarImageUrl;

}

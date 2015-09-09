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
package org.springframework.social.bitbucket.api.command;

import org.springframework.social.support.ParameterMap;

/**
 * DTO class to provide repository/fork create or update data.
 *
 * @author Cyprian Sniegota
 * @since 2.0.0
 */
public class RepositoryCreateUpdate extends ParameterMap {
    public RepositoryCreateUpdate(String name, String description, String language, Boolean isPrivate) {
        if (name != null) {
            set("name", name);
        }
        if (description != null) {
            set("description", description);
        }
        if (language != null) {
            set("language", language);
        }
        if (isPrivate != null) {
            set("isPrivate", String.valueOf(isPrivate));
        }
    }
}

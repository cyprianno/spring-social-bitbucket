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
package org.springframework.social.bitbucket.utils;

import java.util.Date;

/**
 * Shared code to manipulate Date objects
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public final class DateUtils {

    private DateUtils() { }

    /**
     * Clone Date object
     *
     * @param dateToCopy A date to copy (could be null)
     * @return null or copy of the given Date object
     */
    public static Date copyNullable(Date dateToCopy) {
        return dateToCopy == null ? null : new Date(dateToCopy.getTime());
    }
}

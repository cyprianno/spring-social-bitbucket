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

import org.junit.Test;
import org.springframework.format.datetime.DateFormatter;

import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class DateUtilsTest {

    @Test
    public void shouldCreateDateCopyGMT() throws Exception {
        //given
        Date dateToCopy = new DateFormatter("yyyy-MM-dd HH:mm:ssZ").parse("2011-01-11 01:03:31+0000", Locale.getDefault());
        //when
        Date result = DateUtils.copyNullable(dateToCopy);
        //then
        assertNotNull(result);
        assertEquals(dateToCopy, result);
        assertFalse(dateToCopy == result);
    }

    @Test
    public void shouldCreateDateCopyCEST() throws Exception {
        //given
        Date dateToCopy = new DateFormatter("yyyy-MM-dd HH:mm:ssZ").parse("2011-06-11 01:03:31+0200", Locale.getDefault());
        //when
        Date result = DateUtils.copyNullable(dateToCopy);
        //then
        assertNotNull(result);
        assertEquals(dateToCopy, result);
        assertFalse(dateToCopy == result);
    }

    @Test
    public void shouldCreateDateCopyNull() throws Exception {
        //given
        //when
        Date result = DateUtils.copyNullable(null);
        //then
        assertNull(result);
    }

}
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
package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketFile;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesSrcTemplateTest extends BaseTemplateTest {
    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";
    @Test
    public void testGetElements() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/src/xrev/src/file.txt"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-list-repo-source"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketFile> result = bitBucket.repositoriesOperations().repositoriesSrcOperations().getElements(TEST_USERNAME, TEST_REPOSLUG, "xrev", "/src/file.txt");
        //then
        mockServer.verify();
        assertEquals(1, result.size());
        BitBucketFile firstFile = result.iterator().next();
        assertEquals("40e232b389b9", firstFile.getNode());
        assertEquals("Readme", firstFile.getPath());
        assertEquals("Favorite Quotes from bitbuckians\n--------------------\n\nThis page lists \n", firstFile.getData());
        assertEquals(571L, firstFile.getSize());
    }

    @Test
    public void testGetContent() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/raw/xrev/src/file.txt"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-raw-content"), MediaType.APPLICATION_JSON));
        //when
        String result = bitBucket.repositoriesOperations().repositoriesSrcOperations().getContent(TEST_USERNAME, TEST_REPOSLUG, "xrev", "/src/file.txt");
        //then
        mockServer.verify();
        assertEquals("Favorite Quotes from bitbuckians\n--------------------------------\n\nThis page lists\n", result);
    }
}
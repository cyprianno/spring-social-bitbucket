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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketEvent;
import org.springframework.social.bitbucket.api.BitBucketRepository;
import org.springframework.social.bitbucket.api.BitBucketSCM;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Cyprian Śniegota
 * @author Łucja Śniegota
 * @since 2.0.0
 */
public class RepositoriesEventsTemplateTest extends BaseTemplateTest {
    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";
    private static final String TEST_NODE = "testnode";

    @Test
    public void testGetEvents() throws Exception {

        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/events?limit=1&start=10&type=testtype"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-list-repo-events"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketEvent> result = bitBucket.repositoriesOperations().repositoriesEventsOperations().getEvents(TEST_USERNAME, TEST_REPOSLUG, 1, 10, "testtype");
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(1, result.size());
        BitBucketEvent firstBucketEvent = result.get(0);
        assertEquals("abdeaf1b2b4a", firstBucketEvent.getNode());
        assertEquals("making some changes\n", firstBucketEvent.getDescription());
        BitBucketRepository repository = firstBucketEvent.getRepository();
        assertEquals(BitBucketSCM.git, repository.getScm());
        assertEquals(true, repository.isHasWiki());


    }

}
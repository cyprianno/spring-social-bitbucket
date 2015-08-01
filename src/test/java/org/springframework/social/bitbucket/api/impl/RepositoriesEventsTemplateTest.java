package org.springframework.social.bitbucket.api.impl;

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
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-list-repo-events"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketEvent> result = bitBucket.repositoriesOperations().repositoriesEventsOperations().getEvents(TEST_USERNAME, TEST_NODE, 1, 10, "testtype");
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
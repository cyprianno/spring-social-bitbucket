package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesEventsTemplateTest extends BaseTemplateTest {
    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";
    private static final String TEST_NODE = "testnode";

    @Test
    public void testGetEvents() throws Exception {
        assertTrue(false);
        //get-list-repo-events
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesEventsOperations().getEvents(TEST_USERNAME, TEST_NODE, 1, 10, "testtype");
        //then
        mockServer.verify();
        assertTrue(false);
    }
}
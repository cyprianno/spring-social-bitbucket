package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;

import static org.junit.Assert.*;

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
        //when
        bitBucket.repositoriesOperations().repositoriesEventsOperations().getEvents(TEST_USERNAME, TEST_NODE, 1, 10, "testtype");
        //then
        mockServer.verify();
        assertTrue(false);
    }
}
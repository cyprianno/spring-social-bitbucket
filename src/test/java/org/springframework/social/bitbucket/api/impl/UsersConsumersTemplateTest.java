package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.social.bitbucket.api.BitBucketConsumer;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class UsersConsumersTemplateTest extends BaseTemplateTest {

    private static final String TEST_USERNAME = "username";
    private static final String TEST_ID = "testid";
    private static final String TEST_NAME = "testname";
    private static final String TEST_DESCRIPTION = "testdesc";
    private static final String TEST_URL = "testurl";

    @Test
    public void testGetConsumers() throws Exception {
        assertTrue(false);
        //get-consumers
        //given
        //when
        List<BitBucketConsumer> result = bitBucket.usersOperations().usersConsumersOperations().getConsumers(TEST_USERNAME);
        //then
    }

    @Test
    public void testGetConsumer() throws Exception {
        assertTrue(false);
        //get-consumer
        //given
        //when
        BitBucketConsumer result = bitBucket.usersOperations().usersConsumersOperations().getConsumer(TEST_USERNAME, TEST_ID);
        //then
    }

    @Test
    public void testUpdateConsumer() throws Exception {
        assertTrue(false);
        //update-consumer
        //given
        //when
        BitBucketConsumer result = bitBucket.usersOperations().usersConsumersOperations()
                .updateConsumer(TEST_USERNAME, TEST_ID, TEST_NAME, TEST_DESCRIPTION, TEST_URL);
        //then
    }

    @Test
    public void testRemoveConsumer() throws Exception {
        assertTrue(false);
        //given
        //when
        bitBucket.usersOperations().usersConsumersOperations().removeConsumer(TEST_USERNAME, TEST_ID);
        //then
    }
}
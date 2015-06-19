package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketConsumer;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withNoContent;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

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
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/repositories/tortoisehg/thg/followers/"))
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(jsonResource("get-consumers"),
                                MediaType.APPLICATION_JSON));
        //when
        List<BitBucketConsumer> result = bitBucket.usersOperations().usersConsumersOperations().getConsumers(TEST_USERNAME);
        //then
        mockServer.verify();
    }

    @Test
    public void testGetConsumer() throws Exception {
        assertTrue(false);
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/repositories/tortoisehg/thg/followers/"))
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(jsonResource("get-consumer"),
                                MediaType.APPLICATION_JSON));
        //when
        BitBucketConsumer result = bitBucket.usersOperations().usersConsumersOperations().getConsumer(TEST_USERNAME, TEST_ID);
        //then
        mockServer.verify();
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
        mockServer.verify();
    }

    @Test
    public void testRemoveConsumer() throws Exception {
        assertTrue(false);
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/privileges/evzijst/test/jespern"))
                .andExpect(method(DELETE)).andRespond(withNoContent());
        //when
        bitBucket.usersOperations().usersConsumersOperations().removeConsumer(TEST_USERNAME, TEST_ID);
        //then
        mockServer.verify();
    }
}
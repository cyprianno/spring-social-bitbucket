package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withNoContent;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesServicesTemplateTest extends BaseTemplateTest {

    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";

    @Test
    public void testGetServices() throws Exception {
        assertTrue(false);
        //get-services
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesServicesOperations().getServices(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetService() throws Exception {
        assertTrue(false);
        //get-service
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesServicesOperations().getService(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testPostNewService() throws Exception {
        assertTrue(false);
        //post-service
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/ssh-keys")).andExpect(method(POST)).andExpect(
                content().string("key=123123123")).andRespond(withSuccess(jsonResource("post-key"), MediaType.APPLICATION_JSON));
        List<BitBucketService.BitBucketServiceProfileField> fields = Collections.singletonList(
                BitBucketService.BitBucketServiceProfileField.builder().name("fname").value("fval").build());
        //when
        bitBucket.repositoriesOperations().repositoriesServicesOperations().postNewService(TEST_USERNAME, TEST_REPOSLUG, "type", fields);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testUpdateService() throws Exception {
        assertTrue(false);
        //put-service
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/emails/test@email.tld")).andExpect(method(PUT))
                .andExpect(content().string("primary=true")).andRespond(withSuccess(jsonResource("update-email-address"), MediaType.APPLICATION_JSON));
        List<BitBucketService.BitBucketServiceProfileField> fields = Collections.singletonList(
                BitBucketService.BitBucketServiceProfileField.builder().name("fname").value("fval").build());
        //when
        bitBucket.repositoriesOperations().repositoriesServicesOperations().updateService(TEST_USERNAME, TEST_REPOSLUG, 1L, fields);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testRemoveService() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/invitations/test@email.tld")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesServicesOperations().removeService(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }
}
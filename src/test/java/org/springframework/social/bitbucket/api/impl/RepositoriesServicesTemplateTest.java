package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.social.bitbucket.api.BitBucketService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

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
        //when
        bitBucket.repositoriesOperations().repositoriesServicesOperations().removeService(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }
}
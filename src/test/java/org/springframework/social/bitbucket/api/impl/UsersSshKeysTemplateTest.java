package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketSshKey;

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
public class UsersSshKeysTemplateTest extends BaseTemplateTest {
    private static final String TEST_ACCOUNTNAME = "testaccount";
    private static final String TEST_KEYID = "keyid";
    private static final String TEST_KEY = "123123123";
    private static final String TEST_LABEL = "testgroupslug";
    @Test
    public void testGetKeys() throws Exception {
        assertTrue(false);
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/repositories/tortoisehg/thg/followers/"))
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(jsonResource("get-keys"),
                                MediaType.APPLICATION_JSON));
        //when
        List<BitBucketSshKey> result = bitBucket.usersOperations().usersSshKeysOperations().getKeys(TEST_ACCOUNTNAME);
        //then
        mockServer.verify();
    }

    @Test
    public void testPostKey() throws Exception {
        assertTrue(false);
        //post-key
        //given
        //when
        BitBucketSshKey result = bitBucket.usersOperations().usersSshKeysOperations().postKey(TEST_ACCOUNTNAME, TEST_LABEL, TEST_KEY);
        //then
        mockServer.verify();
    }

    @Test
    public void testGetKey() throws Exception {
        assertTrue(false);
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/repositories/tortoisehg/thg/followers/"))
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(jsonResource("get-key"),
                                MediaType.APPLICATION_JSON));
        //when
        BitBucketSshKey result = bitBucket.usersOperations().usersSshKeysOperations().getKey(TEST_ACCOUNTNAME, TEST_KEYID, TEST_LABEL);
        //then
        mockServer.verify();
    }

    @Test
    public void testRemoveKey() throws Exception {
        assertTrue(false);
        //given
        mockServer
                .expect(requestTo("https://api.bitbucket.org/1.0/privileges/evzijst/test/jespern"))
                .andExpect(method(DELETE)).andRespond(withNoContent());
        //when
        bitBucket.usersOperations().usersSshKeysOperations().removeKey(TEST_ACCOUNTNAME, TEST_KEYID);
        //then
        mockServer.verify();
    }
}
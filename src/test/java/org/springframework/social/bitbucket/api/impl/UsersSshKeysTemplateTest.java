package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.social.bitbucket.api.BitBucketSshKey;

import java.util.List;

import static org.junit.Assert.assertTrue;

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
        //get-keys
        //given
        //when
        List<BitBucketSshKey> result = bitBucket.usersOperations().usersSshKeysOperations().getKeys(TEST_ACCOUNTNAME);
        //then
    }

    @Test
    public void testPostKey() throws Exception {
        assertTrue(false);
        //post-key
        //given
        //when
        BitBucketSshKey result = bitBucket.usersOperations().usersSshKeysOperations().postKey(TEST_ACCOUNTNAME, TEST_LABEL, TEST_KEY);
        //then
    }

    @Test
    public void testGetKey() throws Exception {
        assertTrue(false);
        //get-key
        //given
        //when
        BitBucketSshKey result = bitBucket.usersOperations().usersSshKeysOperations().getKey(TEST_ACCOUNTNAME, TEST_KEYID, TEST_LABEL);
        //then
    }

    @Test
    public void testRemoveKey() throws Exception {
        assertTrue(false);
        //given
        //when
        bitBucket.usersOperations().usersSshKeysOperations().removeKey(TEST_ACCOUNTNAME, TEST_KEYID);
        //then
    }
}
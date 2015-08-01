package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketUser;

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
public class RepositoriesFollowersTemplateTest extends BaseTemplateTest {
    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";
    private static final String TEST_NODE = "testnode";
    @Test
    public void testGetFollowers() throws Exception {

        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-list-repo-followers"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketUser> result = bitBucket.repositoriesOperations().repositoriesFollowersOperations().getFollowers(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertNotNull(result);
        assertEquals(4, result.size());
        BitBucketUser firstBucketUser = result.get(0);
        assertEquals("Saage", firstBucketUser.getUsername());
        assertEquals("Rodrigo", firstBucketUser.getFirstName());
        assertEquals(false, firstBucketUser.getTeam());
        assertEquals("https://secure.gravatar.com/avatar/f9c6710cefefb1eb9903d5a076135dc6?d=identicon&s=32", firstBucketUser.getAvatarImageUrl());
        assertEquals("/1.0/users/Saage", firstBucketUser.getResourceUri());
    }
}
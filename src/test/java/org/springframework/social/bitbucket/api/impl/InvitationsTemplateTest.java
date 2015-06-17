/**
 * Copyright (C) 2012 Eric Bottard / Guillaume Lederrey (eric.bottard+ghpublic@gmail.com / guillaume.lederrey@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketInvitation;
import org.springframework.social.bitbucket.api.BitBucketPrivilege;

import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class InvitationsTemplateTest extends BaseTemplateTest {
    private static final String TEST_ACCOUNT_NAME = "testaccount";
    private static final String TEST_REPOSITORY_SLUG = "testrepositoryslug";
    private static final String TEST_EMAIL_ADDRESS = "john@example.com";

    @Test
    public void testSendInvitation() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/invitations/testaccount/testrepositoryslug/john@example.com")).andExpect(method(POST))
                .andExpect(
                        content().string("permission=admin")).andRespond(withSuccess(jsonResource("send-an-invite"), MediaType.APPLICATION_JSON));
        //when
        BitBucketInvitation result = bitBucket.invitationsOperations()
                .sendInvitation(TEST_ACCOUNT_NAME, TEST_REPOSITORY_SLUG, TEST_EMAIL_ADDRESS, BitBucketPrivilege.admin);
        //then
        mockServer.verify();
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd HH:mm:ssZ");
        String expectedStringDateAsGMT = "2011-01-11 01:03:31+0000";
        Date expectedDate = dateFormatter.parse(expectedStringDateAsGMT, Locale.getDefault());
        assertEquals(expectedDate, result.getSentOn());
        assertEquals(BitBucketPrivilege.write, result.getPermission());
        assertEquals("john@example.com", result.getEmail());
        assertNotNull(result.getInvitedBy());
        assertNotNull(result.getRepository());
        assertEquals("roger", result.getInvitedBy().getUsername());
        assertEquals("", result.getRepository().getWebsite());
        assertFalse(result.getRepository().isReadOnly());
        assertEquals("ramjet", result.getRepository().getSlug());
    }
}
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

import org.springframework.http.HttpMethod;
import org.springframework.social.bitbucket.api.BitBucketInvitation;
import org.springframework.social.bitbucket.api.UsersInvitationsOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class UsersInvitationsTemplate extends AbstractBitBucketOperations implements UsersInvitationsOperations {
    public UsersInvitationsTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketInvitation> getPendingInvitations(String accountName) {
        return asList(getRestTemplate().getForObject(buildUrl("/users/{accountname}/invitations"), BitBucketInvitation[].class, accountName));
    }

    @Override
    public final BitBucketInvitation getPendingInvitationsForEmail(String accountName, String emailAddress) {
        return getRestTemplate().getForObject(buildUrl("/users/{accountname}/invitations/{email}"), BitBucketInvitation.class, accountName, emailAddress);
    }

    @Override
    public final boolean getPendingInvitationForGroupMembership(String accountName, String groupOwner, String groupSlug, String emailAddress) {
        return getRestTemplate()
                .getForObject(buildUrl("/users/{accountname}/invitations/{email_address}/{group_owner}/{group_slug}"), String.class, accountName, emailAddress,
                        groupOwner, groupSlug).equals("OK");
    }

    @Override
    public final boolean issueInvitationToGroup(String accountName, String groupOwner, String groupSlug, String emailAddress) {
        return getRestTemplate().exchange(buildUrl("/users/{accountname}/invitations/{email_address}/{group_owner}/{group_slug}"), HttpMethod.PUT, null,
                String.class, accountName, emailAddress, groupOwner, groupSlug).getBody().equals("OK");
    }

    @Override
    public final void removeInitationByEmail(String accountName, String emailAddress) {
        getRestTemplate().delete(buildUrl("/users/{accountname}/invitations/{email_address}"), accountName, emailAddress);
    }

    @Override
    public final void removeInvitationByGroup(String accountName, String groupOwner, String groupSlug, String emailAddress) {
        getRestTemplate().delete(buildUrl("/users/{accountname}/invitations/{email_address}/{group_owner}/{group_slug}"), accountName, emailAddress, groupOwner,
                groupSlug);
    }
}

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

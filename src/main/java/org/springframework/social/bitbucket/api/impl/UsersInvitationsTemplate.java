package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketInvitation;
import org.springframework.social.bitbucket.api.UsersInvitationsOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
        return null;
    }

    @Override
    public final List<BitBucketInvitation> getPendingInvitationsForEmail(String accountName, String emailAddress) {
        return null;
    }

    @Override
    public final boolean getPendingInvitationForGroupMembership(String accountName, String groupOwner, String groupSlug, String emailAddress) {
        return false;
    }

    @Override
    public final boolean issueInvitationToGroup(String accountName, String groupOwner, String groupSlug, String emailAddress) {
        return false;
    }

    @Override
    public final void removeInitationByEmail(String accountName, String emailAddress) {

    }

    @Override
    public final void removeInvitationByGroup(String accountName, String groupOwner, String groupSlug, String emailAddress) {

    }
}

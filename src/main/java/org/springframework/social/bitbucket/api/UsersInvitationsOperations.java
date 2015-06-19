package org.springframework.social.bitbucket.api;

/**
 * An invitation is a request sent to an external email address to participate one or more of an account's groups.
 * Any user with admin access to the account can invite someone to a group.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/invitations+Resource"
 * @since 2.0.0
 */
public interface UsersInvitationsOperations {
    void getPendingInvitations(String accountName);

    void getPendingInvitationsForEmail(String accountName, String emailAddress);

    void getPendingInvitationForGroupMembership(String accountName, String groupOwner, String groupSlug, String emailAddress);

    void issueInvitationToGroup(String accountName, String groupOwner, String groupSlug, String emailAddress);

    void removeInitationByEmail(String accountName, String emailAddress);

    void removeInvitationByGroup(String accountName, String groupOwner, String groupSlug, String emailAddress);
}

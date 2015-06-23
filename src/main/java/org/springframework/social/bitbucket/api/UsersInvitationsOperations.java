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
package org.springframework.social.bitbucket.api;

import java.util.List;

/**
 * An invitation is a request sent to an external email address to participate one or more of an account's groups.
 * Any user with admin access to the account can invite someone to a group.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/invitations+Resource"
 * @since 2.0.0
 */
public interface UsersInvitationsOperations {
    /**
     * Gets a list of pending invitations on a team or individual account.
     * This call requires authorization and the caller must have administrative rights on the account.
     * API call: GET https://bitbucket.org/api/1.0/users/{accountname}/invitations
     *
     * @param accountName The name of an individual or team account.
     */
    List<BitBucketInvitation> getPendingInvitations(String accountName);

    /**
     * Gets any pending invitations on a team or individual account for a particular email address.
     * Any user with admin access to the account can invite someone to a group.
     * This call requires authorization and the caller must have administrative rights on the account.
     * Gets any pending invitations on a team or individual account for a particular email address.
     * Any user with admin access to the account can invite someone to a group.
     * This call requires authorization and the caller must have administrative rights on the account.
     * API call: GET https://bitbucket.org/api/1.0/users/{accountname}/invitations/{email_address}
     *
     * @param accountName  The name of an individual or team account.
     * @param emailAddress The email address to get.
     * @return pending invitation
     */
    BitBucketInvitation getPendingInvitationsForEmail(String accountName, String emailAddress);

    /**
     * Tests whether there is a pending invitation for a particular email on account's group.
     * An invitation is a request sent to an external email address to participate one or more of an account's groups.
     * Any user with admin access to the account can invite someone to a group.
     * This call requires authorization and the caller must have administrative rights on the account.
     * API call: GET https://bitbucket.org/api/1.0/users/{accountname}/invitations/{email_address}/{group_owner}/{group_slug}
     *
     * @param accountName  The name of an individual or team account.
     * @param groupOwner   The name of an individual or team account that owns the group.
     * @param groupSlug    An identifier for the group. The  slug  is an identifier constructed by the Bitbucket service.
     *                     Bitbucket creates a  slug  by converting spaces to dashes and making all text lower case.
     * @param emailAddress The email address.
     * @return true if invitation exists, false otherwise.
     */
    boolean getPendingInvitationForGroupMembership(String accountName, String groupOwner, String groupSlug, String emailAddress);

    /**
     * Issues an invitation to the specified account group.
     * An invitation is a request sent to an external email address to participate one or more of an account's groups.
     * Any user with admin access to the account can invite someone to a group.
     * This call requires authorization and the caller must have administrative rights on the account.
     * This call does not check validate the email address.
     * When making this call, you must provide a Content-Length header even if the length is 0 (zero).
     * API call: PUT https://bitbucket.org/api/1.0/users/{accountname}/invitations/{email_address}/{group_owner}/{group_slug}
     *
     * @param accountName  The name of an individual or team account.
     * @param groupOwner   The name of an individual or team account that owns the group.
     * @param groupSlug    An identifier for the group. The  slug  is an identifier constructed by the Bitbucket service.
     *                     Bitbucket creates a  slug  by converting spaces to dashes and making all text lower case.
     * @param emailAddress The email address.
     * @return true if the invitation succeeds, false otherwise.
     */
    boolean issueInvitationToGroup(String accountName, String groupOwner, String groupSlug, String emailAddress);

    /**
     * Deletes any pending invitations on a team or individual account for a particular email address.
     * An invitation is a request sent to an external email address to participate one or more of an account's groups.
     * If a email is invited on multiple groups, the invitation is removed from all groups.
     * This call requires authorization and the caller must have administrative rights on the account.
     * API call: DELETE https://bitbucket.org/api/1.0/users/{accountname}/invitations/{email_address}
     *
     * @param accountName  The name of an individual or team account.
     * @param emailAddress Name of the email address to delete.
     */
    void removeInitationByEmail(String accountName, String emailAddress);

    /**
     * Deletes a pending invitation for a particular email on account's group.
     * An invitation is a request sent to an external email address to participate one or more of an account's groups.
     * Any user with admin access to the account can invite someone to a group.
     * This call requires authorization and the caller must have administrative rights on the account.
     * API call: DELETE https://bitbucket.org/api/1.0/users/{accountname}/invitations/{email_address}/{group_owner}/{group_slug}
     *
     * @param accountName  The name of an individual or team account.
     * @param groupOwner   The name of an individual or team account that owns the group.
     * @param groupSlug    An identifier for the group. The  slug  is an identifier constructed by the Bitbucket service.
     *                     Bitbucket creates a  slug  by converting spaces to dashes and making all text lower case.
     * @param emailAddress Name of the email address to delete.
     */
    void removeInvitationByGroup(String accountName, String groupOwner, String groupSlug, String emailAddress);
}

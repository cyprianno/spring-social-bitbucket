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

/**
 * The invitations endpoint allows repository administrators to send email invitations to grant read, write,
 * or admin privileges to a repository.  The email sent to a user includes a URL for accepting the invitation.
 * If the recipient already has a Bitbucket account corresponding to that email address,
 * he or she must log into that account to access the repository.
 * If the user does not have a Bitbucket account, the user must create a Bitbucket account before accessing the repository.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/invitations+Endpoint"
 * @since 2.0.0
 */
public interface InvitationsOperations {

    /**
     * Invites a user to a repository.
     * API call: POST https://bitbucket.org/api/1.0/invitations/{accountname}/{repo_slug}/{emailaddress} --data permission={perm}
     *
     * @param accountName  The team or individual account.
     * @param repoSlug     A repository belonging to the account.
     * @param emailAddress The email recipient.
     * @param perm         The permission the recipient is granted.
     * @return invitation data object
     */
    BitBucketInvitation sendInvitation(String accountName, String repoSlug, String emailAddress, BitBucketPrivilege perm);
}

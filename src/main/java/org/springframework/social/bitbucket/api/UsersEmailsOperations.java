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
 * An account can have one or more email addresses associated with it.
 * Use this end point to list, change, or create an email address.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/emails+Resource"
 * @since 2.0.0
 */
public interface UsersEmailsOperations {

    /**
     * Gets the email addresses associated with the account.
     * API call: GET https://bitbucket.org/api/1.0/users/{accountname}/emails
     *
     * @param accountName The name of an individual or team account.
     * @return list of email addresses
     */
    List<BitBucketEmailAddress> getEmailAddresses(String accountName);

    /**
     * Gets an individual email address associated with an account.
     * API call: GET https://bitbucket.org/api/1.0/users/{accountname}/emails/{email_address}
     *
     * @param accountName  The name of an individual or team account.
     * @param emailAddress The email address to get.
     * @return email address
     */
    BitBucketEmailAddress getEmailAddress(String accountName, String emailAddress);

    /**
     * Adds additional email addresses to an account.
     * API call: POST https://bitbucket.org/api/1.0/users/{accountname}/emails/{email_address} --data"email=value"
     *
     * @param accountName  The name of an individual or team account.
     * @param emailAddress The email address to post.
     * @return list of email addresses
     */
    List<BitBucketEmailAddress> postNewEmailAddress(String accountName, String emailAddress);

    /**
     * Sets an individual email address associated with an account to primary.
     * The primary email address is the main email contact for the account.
     * Only a single address on an account can be primary.
     * If another address had primary set prior to this call, after it is no longer primary.
     * API call: PUT https://bitbucket.org/api/1.0/users/{accountname}/emails/{email_address} --data "primary=true"
     *
     * @param accountName  The name of an individual or team account.
     * @param emailAddress The email address to modify.
     * @return modified email address
     */
    BitBucketEmailAddress updateEmailAddress(String accountName, String emailAddress);

}

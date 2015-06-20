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

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.social.bitbucket.api.BitBucketEmailAddress;
import org.springframework.social.bitbucket.api.UsersEmailsOperations;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class UsersEmailsTemplate extends AbstractBitBucketOperations implements UsersEmailsOperations {

    public UsersEmailsTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketEmailAddress> getEmailAddresses(String accountName) {
        return asList(getRestTemplate().getForObject(buildUrl("/users/{accountname}/emails"),
                BitBucketEmailAddress[].class, accountName));
    }

    @Override
    public final BitBucketEmailAddress getEmailAddress(String accountName, String emailAddress) {
        return getRestTemplate().getForObject(buildUrl("/users/{accountname}/emails/{email_address}"),
                BitBucketEmailAddress.class, accountName, emailAddress);
    }

    @Override
    public final List<BitBucketEmailAddress> postNewEmailAddress(String accountName, String emailAddress) {
        return asList(getRestTemplate()
                .postForObject(buildUrl("/users/{accountname}/emails/{email_address}"), new EmailAddressCreate(emailAddress), BitBucketEmailAddress[].class,
                        accountName, emailAddress));
    }

    @Override
    public final BitBucketEmailAddress updateEmailAddress(String accountName, String emailAddress) {
        return getRestTemplate().exchange(buildUrl("/users/{accountname}/emails/{email_address}"), HttpMethod.PUT, new HttpEntity<>("primary=true"),
                BitBucketEmailAddress.class, accountName, emailAddress).getBody();
    }

    private static final class EmailAddressCreate extends ParameterMap {

        public EmailAddressCreate(String name) {
            set("email", name);
        }

    }
}

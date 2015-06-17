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

import org.springframework.social.bitbucket.api.BitBucketInvitation;
import org.springframework.social.bitbucket.api.BitBucketPrivilege;
import org.springframework.social.bitbucket.api.InvitationsOperations;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class InvitationsTemplate extends AbstractBitBucketOperations implements InvitationsOperations {

    public InvitationsTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final BitBucketInvitation sendInvitation(String accountName, String repoSlug, String emailAddress, BitBucketPrivilege perm) {
        return getRestTemplate().postForObject(buildUrl("/invitations/{accountname}/{repo_slug}/{emailaddress}"),
                new SendInvitationParametersHolder(perm), BitBucketInvitation.class, accountName, repoSlug, emailAddress);
    }

    private static final class SendInvitationParametersHolder extends ParameterMap {
        public SendInvitationParametersHolder(BitBucketPrivilege privilege) {
            add("permission", privilege.toString());
        }
    }
}

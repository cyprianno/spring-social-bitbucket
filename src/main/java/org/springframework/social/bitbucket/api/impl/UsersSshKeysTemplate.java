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

import org.springframework.social.bitbucket.api.BitBucketSshKey;
import org.springframework.social.bitbucket.api.UsersSshKeysOperations;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class UsersSshKeysTemplate extends AbstractBitBucketOperations implements UsersSshKeysOperations {
    public UsersSshKeysTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketSshKey> getKeys(String accountName) {
        return asList(getRestTemplate().getForObject(buildUrl("/users/{accountname}/ssh-keys"), BitBucketSshKey[].class, accountName));
    }

    @Override
    public final BitBucketSshKey postKey(String accountName, String label, String key) {
        return getRestTemplate()
                .postForObject(buildUrl("/users/{accountname}/ssh-keys"), new CreateKeyParameters(key), BitBucketSshKey[].class, accountName)[0];
    }

    @Override
    public final BitBucketSshKey getKey(String accountName, long keyId, String label) {
        String queryKey = label != null ? label : String.valueOf(keyId);
        List<BitBucketSshKey> result = asList(
                getRestTemplate().getForObject(buildUrl("/users/{accountname}/ssh-keys/{key_id}"), BitBucketSshKey[].class, accountName, queryKey));
        return result.isEmpty() ? null : result.iterator().next();
    }

    @Override
    public final void removeKey(String accountName, long keyId) {
        getRestTemplate().delete(buildUrl("/users/{accountname}/ssh-keys/{key_id}"), accountName, keyId);
    }

    private static class CreateKeyParameters extends ParameterMap {
        public CreateKeyParameters(String key) {
            set("key", key);
        }
    }
}

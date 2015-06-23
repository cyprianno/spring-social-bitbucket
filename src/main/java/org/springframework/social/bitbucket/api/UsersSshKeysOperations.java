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
 * Use the ssh-keys resource to manipulate the ssh-keys on an individual or team account.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/ssh-keys+Resource"
 * @since 2.0.0
 */
public interface UsersSshKeysOperations {

    /**
     * Gets a list of the keys associated with an account. This call requires authentication.
     * API call: GET https://bitbucket.org/api/1.0/users/{accountname}/ssh-keys
     *
     * @param accountName The name of an individual or team account.
     * @return A list of ssh keys.
     */
    List<BitBucketSshKey> getKeys(String accountName);

    /**
     * Creates a key on the specified account.
     * You must supply a valid key that is unique across the Bitbucket service.
     * A public key contains characters need to be escaped before sending it as a POST data.
     * So, use the proper escaping ( urlencode ), if you are testing to add a key via your terminal.
     * API call: POST https://bitbucket.org/api/1.0/users/{accountname}/ssh-keys --data "key=value"
     *
     * @param accountName The name of an individual or team account.
     * @param label       A label for the key.
     * @param key         The key value.
     * @return Ssh key.
     */
    BitBucketSshKey postKey(String accountName, String label, String key);

    /**
     * Gets the content of the specified key_id. This call requires authentication. This call requires authentication.
     * API call: GET https://bitbucket.org/api/1.0/users/{accountname}/ssh-keys/{key_id}
     *
     * @param accountName The name of an individual or team account.
     * @param keyId       The key identifier. This is an internal value created by Bitbucket when the key is added.
     * @param label       A label for the key.
     * @return Ssh key.
     */
    BitBucketSshKey getKey(String accountName, long keyId, String label);

    /**
     * Deletes the key specified by the key_id value. This call requires authentication.
     * API call: DELETE https://bitbucket.org/api/1.0/users/{accountname}/ssh-keys/{key_id}
     *
     * @param accountName The name of an individual or team account.
     * @param keyId       The key identifier. This is an internal value created by Bitbucket when the key is added.
     */
    void removeKey(String accountName, long keyId);
}


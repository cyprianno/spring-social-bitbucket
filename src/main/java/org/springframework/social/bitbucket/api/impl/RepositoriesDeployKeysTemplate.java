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

import org.springframework.social.bitbucket.api.*;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesDeployKeysTemplate extends AbstractBitBucketOperations implements RepositoriesDeployKeysOperations {
    public RepositoriesDeployKeysTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public  final List<BitBucketDeployKey> getDeployKeys(String accountName, String repoSlug) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/deploy-keys"), BitBucketDeployKey[].class,
                        accountName, repoSlug));
    }

    @Override
    public  final BitBucketDeployKey getDeployKey(String accountName, String repoSlug, Long pk) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/deploy-keys/{pk}"), BitBucketDeployKey.class,
                        accountName, repoSlug, pk);
    }

    @Override
    public  final BitBucketDeployKey postDeployKey(String accountName, String repoSlug, String key) {
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/deploy-keys"), new DeployKeyCreate(key), BitBucketDeployKey.class,
                        accountName, repoSlug);
    }

    @Override
    public  final void removeDeployKey(String accountName, String repoSlug, Long pk) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/deploy-keys/{pk}"), accountName, repoSlug, pk);

    }

    private static class DeployKeyCreate extends ParameterMap {
        public DeployKeyCreate(String key) {
            set("key", key);
        }
    }
}

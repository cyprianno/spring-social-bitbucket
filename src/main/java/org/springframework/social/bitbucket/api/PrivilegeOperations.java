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

public interface PrivilegeOperations {

    /**
     * Get the privileges on a given repository.
     * GET https://bitbucket.org/api/1.0/privileges/{accountname}/{repo_slug}
     *
     * @param accountName     repository owner
     * @param repoSlug name of the repository
     */
    List<RepoPrivilege> getRepoPrivileges(String accountName, String repoSlug);

    /**
     * Get a list of privileges for an individual account.
     * Only the repository owner, a team account administrator, or an account with administrative rights on the repository can make this call.
     * GET https://api.bitbucket.org/1.0/privileges/{accountname}/{repo_slug}/{privilege_account}
     *
     * @param accountName  username
     * @param repoSlug repo_slug
     * @param privilegeAccount privilege_account
     * @return list of privileges
     */
    List<RepoPrivilege> getPrivilegesForAnIndividual(String accountName, String repoSlug, String privilegeAccount);

    /**
     * Gets a list of all the privilege across all an account's repositories.
     * If a repository has no individual users with privileges, it does not appear in this list.
     * Only the repository owner, a team account administrator, or an account with administrative rights on the repository can make this call.
     * GET https://api.bitbucket.org/1.0/privileges/{accountname}
     * GET https://api.bitbucket.org/1.0/privileges/{accountname}?filter={filter}
     *
     * @param accountName account_name
     * @return list of privileges
     */
    List<RepoPrivilege> getPrivilegesAcrossAllRepositories(String accountName);

    /**
     * Set or change the privilege for the given recipient on some repository.
     * PUT  https://api.bitbucket.org/1.0/privileges/{accountname}/{repo_slug}/{privilege_account} --data {read}
     *
     * @param accountName     the repository owner
     * @param repoSlug  the repository name
     * @param recipient user for which to set the privilege
     * @param privilege new privilege value to set
     */
    RepoPrivilege setPrivilege(String accountName, String repoSlug, String recipient, BitBucketPrivilege privilege);

    /**
     * Removes the current privilege of the given recipient from some
     * repository.
     * DELETE  https://bitbucket.org/api/1.0/privileges/{accountname}/{repo_slug}/{privilege_account}
     *
     * @param accountName     the repository owner
     * @param repoSlug  the repository name
     * @param recipient user for which to remove the privilege
     */
    void removePrivilege(String accountName, String repoSlug, String recipient);

    /**
     * Delete all privileges from a repository.
     * Only the repository owner, a team account administrator, or an account with administrative rights on the repository can make this call.
     * DELETE  https://bitbucket.org/api/1.0/privileges/{accountname}/{repo_slug}
     *
     * @param accountName Owner of the repository.
     * @param repoSlug Repository identifier.
     */
    void removeAllPrivilegesFromARepository(String accountName, String repoSlug);

    /**
     * DELETE an privileges from all repositories.
     * Only the repository owner, a team account administrator, or an account with administrative rights on the repository can make this call.
     * DELETE  https://bitbucket.org/api/1.0/privileges/{accountname}
     *
     * @param accountName Owner of the repositories.
     */
    void removeAllPrivilegesFromAllRepositories(String accountName);
}

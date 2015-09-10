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
 * You can use the Bitbucket src resource to browse directories and view files. This is a read-only resource.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/src+Resources"
 * @since 2.0.0
 */
public interface RepositoriesSrcOperations {

    /**
     * Gets a list of the src in a repository.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/src/{revision}/{path}
     *
     * @param accountName A team or individual account name.
     * @param repoSlug The repository's name.
     * @param revision A value representing the revision or branch to list.
     * @param path The path can be a filename or a directory path.
     *             If path ends with / (forward slash), Bitbucket interprets the path as a directory and returns a list.
     * @return List of files.
     */
    List<BitBucketFile> getElements(String accountName, String repoSlug, String revision, String path);

    /**
     * Gets information about an individual file. This method returns the file's size and contents.
     * If the file is encoded, this method returns the files encoding; Currently, Bitbucket supports only base64 encoding.
     * API call: https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/raw/{revision}/{path}
     *
     * @param accountName A team or individual account name.
     * @param repoSlug The repository's name.
     * @param revision A value representing the revision or branch to list.
     * @param path The path can be a filename or a directory path.
     *             If path ends with / (forward slash), Bitbucket interprets the path as a directory and returns a list.
     * @return File content.
     */
    String getContent(String accountName, String repoSlug, String revision, String path);
}

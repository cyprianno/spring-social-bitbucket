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

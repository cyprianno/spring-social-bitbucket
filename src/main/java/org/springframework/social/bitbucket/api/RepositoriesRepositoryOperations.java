package org.springframework.social.bitbucket.api;

import java.util.List;
import java.util.Map;

/**
 * For the repository resource, you supply a  repo_slug that identifies the specific repository.
 * For example, the repo_slug for this repository  https://bitbucket.org/tortoisehg/thg is thg.
 * You can use this resource to create a new repository or edit a specific one.
 * There are several URLs that allow you to query for branch resources.
 * Unauthenticated calls for this resource only return values for public repositories.
 * To see private repositories, you must have at least read permissions on the repository.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/repository+Resource+1.0"
 * @since 2.0.0
 */
public interface RepositoriesRepositoryOperations {

    /**
     * Forks a new repository under the account of the currently authenticated user.   The account automatically becomes the owner.
     * API call: POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/fork  --data "name=mynewrepo"
     *
     * @param accountName The team or individual account.
     * @param repositorySlug A repository belonging to the account.
     * @param name The name of the repository
     * @param description A description of the repository.
     * @param language The language used for source code in the repository.
     * @param isPrivate Boolean specifying if the repository is private (true) or public (false).  The default is false.
     * @return Created fork.
     */
    BitBucketRepository createNewFork(String accountName, String repositorySlug, String name, String description, String language, Boolean isPrivate);

    /**
     * Updates an existing repository.   The caller must authenticate as a user with administrative privileges to the account.
     * API call: PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug} --data "description=long description"
     *
     * @param accountName The team or individual account.
     * @param repositorySlug A repository belonging to the account.
     * @param respositoryData Repository data to update.
     * @return Updated repository.
     */
    BitBucketRepository updateRepository(String accountName, String repositorySlug, BitBucketRepository respositoryData);

    /**
     * Gets a list of branches associated with a repository.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/branches
     *
     * @param accountName The team or individual account.
     * @param repositorySlug A repository belonging to the account.
     * @return Map branch name/branch data.
     */
    Map<String, BitBucketBranch> getBranches(String accountName, String repositorySlug);

    /**
     * Gets the main-branch associated with the repository. You set the main branch from a repository's Repository details page.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/main-branch
     *
     * @param accountName The team or individual account.
     * @param repositorySlug A repository belonging to the account.
     * @return Name of branch.
     */
    String getMainBranch(String accountName, String repositorySlug);

    /**
     * Gets a list of branches and associated tags for a repository.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/branches-tags
     *
     * @param accountName The team or individual account.
     * @param repositorySlug A repository belonging to the account.
     * @return List of aggregated branches and tags.
     */
    List<BitBucketBranchesTags> getBranchesTags(String accountName, String repositorySlug);

    /**
     * Gets a repository's manifest for a revision.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/{revision}
     *
     * @param accountName The team or individual account.
     * @param repositorySlug A repository belonging to the account.
     * @param revision A value representing the revision or branch.
     * @return Map filename/revision.
     */
    Map<String, String> getManifest(String accountName, String repositorySlug, String revision);

    /**
     * Use this resource to list the tags and branches for a given repository.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/tags
     *
     * @param accountName The team or individual account.
     * @param repositorySlug A repository belonging to the account.
     * @return Map of tags tag name/tag info.
     */
    Map<String, BitBucketBranch> getTags(String accountName, String repositorySlug);

    /**
     * Use this resource to get the raw content of a file or directory.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/raw/{revision}/{path}
     *
     * @param accountName The team or individual account.
     * @param repositorySlug A repository belonging to the account.
     * @param revision A value representing the revision or branch.
     * @param path Filename.
     * @return Raw source of file.
     */
    String getRawSource(String accountName, String repositorySlug, String revision, String path);

    /**
     * Returns the history of a file starting from the provided changeset.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/filehistory/{node}/{path}
     *
     * @param accountName The team or individual account.
     * @param repositorySlug A repository belonging to the account.
     * @param node The simple changeset node id.
     * @param path Filename.
     * @return History as a branch.
     */
    BitBucketBranch getHistoryOfFile(String accountName, String repositorySlug, String node, String path);

}

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

/**
 * The repositories endpoint has a number of resources you can use to manage repository resources.
 * For all repository resources, you supply a  repo_slug that identifies the specific repository.
 * For example, the repo_slug for the repository https://bitbucket.org/tortoisehg/thg is thg.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/repositories+Endpoint+-+1.0"
 * @since 2.0.0
 */
public interface RepositoriesOperations {

    /**
     * Use changesets resources to manage changesets resources on a repository.
     *
     * @see RepositoriesChangesetsOperations
     * @return changesets resource
     */
    RepositoriesChangesetsOperations repositoriesChangesetsOperations();

    /**
     * Manage ssh keys used for deploying product builds.
     *
     * @see RepositoriesDeployKeysOperations
     * @return deploy-keys resource
     */
    RepositoriesDeployKeysOperations repositoriesDeployKeysOperations();

    /**
     * You can use events to track events that occur on public repositories or private repositories that you have access to.
     *
     * @see RepositoriesEventsOperations
     * @return events resource
     */
    RepositoriesEventsOperations repositoriesEventsOperations();

    /**
     * Users can follow another user or a repository. Use this resource to list a repository's followers.
     *
     * @see RepositoriesFollowersOperations
     * @return followers resource
     */
    RepositoriesFollowersOperations repositoriesFollowersOperations();

    /**
     * The issues resource provides functionality for getting information on issues in an issue tracker, creating new issues, updating them and deleting them.
     *
     * @see RepositoriesIssuesOperations
     * @return issues resource
     */
    RepositoriesIssuesOperations repositoriesIssuesOperations();

    /**
     * Links connect your commit messages and code comments directly to your JIRA issue tracker or Bamboo build server.
     *
     * @see RepositoriesLinksOperations
     * @return links resource
     */
    RepositoriesLinksOperations repositoriesLinksOperations();

    /**
     * Manage the comments on pull requests.
     *
     * @see RepositoriesPullRequestsOperations
     * @return pull requests resource
     */
    RepositoriesPullRequestsOperations repositoriesPullRequestsOperations();

    /**
     * You can use this resource to view, create a new repository or edit a specific one.
     *
     * @see RepositoriesRepositoryOperations
     * @return repository resource
     */
    RepositoriesRepositoryOperations repositoriesRepositoryOperations();

    /**
     * Bitbucket integrates with external services (hooks) through a set of brokers that run in response to certain events.
     *
     * @see RepositoriesServicesOperations
     * @return services resource
     */
    RepositoriesServicesOperations repositoriesServicesOperations();

    /**
     * You can use the Bitbucket src resource to browse directories and view files.
     *
     * @see RepositoriesSrcOperations
     * @return src resource
     */
    RepositoriesSrcOperations repositoriesSrcOperations();

    /**
     * The wiki resource provides functionality for getting information from pages in a Bitbucket wiki, creating new pages, and updating them.
     *
     * @see RepositoriesWikiOperations
     * @return wiki opeartions
     */
    RepositoriesWikiOperations repositoriesWikiOperations();

}

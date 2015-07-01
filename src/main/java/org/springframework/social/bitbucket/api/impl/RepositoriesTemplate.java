package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.RepositoriesChangesetsOperations;
import org.springframework.social.bitbucket.api.RepositoriesDeployKeysOperations;
import org.springframework.social.bitbucket.api.RepositoriesEventsOperations;
import org.springframework.social.bitbucket.api.RepositoriesFollowersOperations;
import org.springframework.social.bitbucket.api.RepositoriesIssuesOperations;
import org.springframework.social.bitbucket.api.RepositoriesLinksOperations;
import org.springframework.social.bitbucket.api.RepositoriesOperations;
import org.springframework.social.bitbucket.api.RepositoriesPullRequestsOperations;
import org.springframework.social.bitbucket.api.RepositoriesRepositoryOperations;
import org.springframework.social.bitbucket.api.RepositoriesServicesOperations;
import org.springframework.social.bitbucket.api.RepositoriesSrcOperations;
import org.springframework.social.bitbucket.api.RepositoriesWikiOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesTemplate extends AbstractBitBucketOperations implements RepositoriesOperations {

    private final RepositoriesChangesetsOperations repositoriesChangesetsOperations;
    private final RepositoriesDeployKeysOperations repositoriesDeployKeysOperations;
    private final RepositoriesEventsOperations repositoriesEventsOperations;
    private final RepositoriesFollowersOperations repositoriesFollowersOperations;
    private final RepositoriesIssuesOperations repositoriesIssuesOperations;
    private final RepositoriesLinksOperations repositoriesLinksOperations;
    private final RepositoriesPullRequestsOperations repositoriesPullRequestsOperations;
    private final RepositoriesRepositoryOperations repositoriesRepositoryOperations;
    private final RepositoriesServicesOperations repositoriesServicesOperations;
    private final RepositoriesSrcOperations repositoriesSrcOperations;
    private final RepositoriesWikiOperations repositoriesWikiOperations;

    public RepositoriesTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
        repositoriesChangesetsOperations = new RepositoriesChangesetsTemplate(getRestTemplate(), isAuthorized());
        repositoriesDeployKeysOperations = new RepositoriesDeployKeysTemplate(getRestTemplate(), isAuthorized());
        repositoriesEventsOperations = new RepositoriesEventsTemplate(getRestTemplate(), isAuthorized());
        repositoriesFollowersOperations = new RepositoriesFollowersTemplate(getRestTemplate(), isAuthorized());
        repositoriesIssuesOperations = new RepositoriesIssuesTemplate(getRestTemplate(), isAuthorized());
        repositoriesLinksOperations = new RepositoriesLinksTemplate(getRestTemplate(), isAuthorized());
        repositoriesPullRequestsOperations = new RepositoriesPullRequestsTemplate(getRestTemplate(), isAuthorized());
        repositoriesRepositoryOperations = new RepositoriesRepositoryTemplate(getRestTemplate(), isAuthorized());
        repositoriesServicesOperations = new RepositoriesServicesTemplate(getRestTemplate(), isAuthorized());
        repositoriesSrcOperations = new RepositoriesSrcTemplate(getRestTemplate(), isAuthorized());
        repositoriesWikiOperations = new RepositoriesWikiTemplate(getRestTemplate(), isAuthorized());
    }

    @Override
    public RepositoriesChangesetsOperations repositoriesChangesetsOperations() {
        return repositoriesChangesetsOperations;
    }

    @Override
    public RepositoriesDeployKeysOperations repositoriesDeployKeysOperations() {
        return repositoriesDeployKeysOperations;
    }

    @Override
    public RepositoriesEventsOperations repositoriesEventsOperations() {
        return repositoriesEventsOperations;
    }

    @Override
    public RepositoriesFollowersOperations repositoriesFollowersOperations() {
        return repositoriesFollowersOperations;
    }

    @Override
    public RepositoriesIssuesOperations repositoriesIssuesOperations() {
        return repositoriesIssuesOperations;
    }

    @Override
    public RepositoriesLinksOperations repositoriesLinksOperations() {
        return repositoriesLinksOperations;
    }

    @Override
    public RepositoriesPullRequestsOperations repositoriesPullRequestsOperations() {
        return repositoriesPullRequestsOperations;
    }

    @Override
    public RepositoriesRepositoryOperations repositoriesRepositoryOperations() {
        return repositoriesRepositoryOperations;
    }

    @Override
    public RepositoriesServicesOperations repositoriesServicesOperations() {
        return repositoriesServicesOperations;
    }

    @Override
    public RepositoriesSrcOperations repositoriesSrcOperations() {
        return repositoriesSrcOperations;
    }

    @Override
    public RepositoriesWikiOperations repositoriesWikiOperations() {
        return repositoriesWikiOperations;
    }
}

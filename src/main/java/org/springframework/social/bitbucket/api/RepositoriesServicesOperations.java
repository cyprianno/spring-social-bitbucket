package org.springframework.social.bitbucket.api;

/**
 * Bitbucket integrates with external services (hooks) through a set of brokers that run in response to certain events.
 * Brokers are Python scripts that receive information about an event and then take one or more actions.
 * For example, there is a Bamboo broker for integrating with Bamboo.
 * The Bitbucket team developed many of our brokers. Third-party vendors also developed several brokers.
 * The Bitbucket services resource provides functionality for adding, removing, and configuring brokers on your repositories.
 * All the methods on this resource require the caller to authenticate.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/services+Resource"
 * @since 2.0.0
 */
public interface RepositoriesServicesOperations {
}
/*
###services
- GET a list of services on a repository
GET https://api.bitbucket.org/1.0/repositories/{accountname}/{repo_slug}/services
- GET a single service attached to your repository
GET https://api.bitbucket.org/1.0/repositories/{accountname}/{repo_slug}/services/{id}
- POST a new service
POST https://api.bitbucket.org/1.0/repositories/{accountname}/{repo_slug}/services/ --data "type=value&parameter=value&..."
- PUT a change to a service
PUT https://api.bitbucket.org/1.0/repositories/{accountname}/{repo_slug}/services/{id} --data "parameter=value"  --data "parameter=value" ...
- DELETE a service
DELETE https://api.bitbucket.org/1.0/repositories/{accountname}/{repo_slug}/services/{id}*/
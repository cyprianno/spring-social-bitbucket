package org.springframework.social.bitbucket.api;

import java.util.List;

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

    /**
     * Lists the services existing on a repository.
     * API call: GET https://api.bitbucket.org/1.0/repositories/{accountname}/{repo_slug}/services
     *
     * @param accountName A team or individual account name.
     * @param repoSlug The repository's name.
     * @return List of services.
     */
    List<BitBucketService> getServices(String accountName, String repoSlug);

    /**
     * Returns the profile of a single service attached to your repository.  You must have the service Id to use this call.
     * API call: GET https://api.bitbucket.org/1.0/repositories/{accountname}/{repo_slug}/services/{id}
     *
     * @param accountName A team or individual account name.
     * @param repoSlug The repository's name.
     * @param serviceId A Bitbucket assigned integer representing a unique identifier for the service.
     * @return Specified service.
     */
    BitBucketService getService(String accountName, String repoSlug, Long serviceId);

    /**
     * Adds a service to a repository. Only the type of the service is required in the POST data. (Service type is a case-insensitive match.)
     * Optionally, you can provide all the service parameters.  You can update service fields later.
     * API call: POST https://api.bitbucket.org/1.0/repositories/{accountname}/services/ -d "type=POST&URL=https%3A%2F%2Fbitbucket.org/post"
     *
     * @param accountName A team or individual account name.
     * @param repoSlug The repository's name.
     * @param type One of the supported services. The type is a case-insensitive value.
     * @param fields A parameter array containing a name and value pair for each parameter associated with the service.
     * @return Created service.
     */
    BitBucketService postNewService(String accountName, String repoSlug, String type, List<BitBucketService.BitBucketServiceProfileField> fields);

    /**
     * To update a service, issue a PUT request with the id of the repository service included in the URL.
     * Pass each parameter separately.  You must include all the parameters in the service.
     * If you omit a parameter or pass an invalid parameter, the PUT removes all the values for the service.
     *
     * API call: PUT https://api.bitbucket.org/1.0/repositories/{accountname}/services/{id} --data "URL=https://bitbucket.org/new_post"
     *
     * @param accountName A team or individual account name.
     * @param repoSlug The repository's name.
     * @param serviceId A Bitbucket assigned integer representing a unique identifier for the service.
     * @param fields A parameter array containing a name and value pair for each parameter associated with the service.
     * @return Updated service.
     */
    BitBucketService updateService(String accountName, String repoSlug, Long serviceId, List<BitBucketService.BitBucketServiceProfileField> fields);

    /**
     * Removes a service. The caller must supply the id of the service to remove.
     * API call: DELETE https://api.bitbucket.org/1.0/repositories/{accountname}/services/{id}
     *
     * @param accountName A team or individual account name.
     * @param repoSlug The repository's name.
     * @param serviceId A Bitbucket assigned integer representing a unique identifier for the service.
     */
    void removeService(String accountName, String repoSlug, Long serviceId);
}

package org.springframework.social.bitbucket.api;

import java.util.List;

/**
 * Account Resource
 * This resource returns a user structure and the repositories array associated with an existing account
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/account+Resource"
 * @since 2.0.0
 */
public interface UsersAccountOperations {

    /**
     * Gets the information associated with an account.
     * The information returned by this call depends on whether you authenticate with the  accountname:password
     * combination or not. An an unauthenticated gets a user's basic information and lists any public repositories for that user.
     * GET https://bitbucket.org/api/1.0/users/{accountname}
     * GET https://bitbucket.org/api/1.0/users/{emailaddress}
     *
     * @param accountName The name of an individual or team account. You can also use a validated email address in place of the accountname value.
     * @return User with repositories
     */
    UserWithRepositories getProfile(String accountName);

    /**
     * Gets the number of users counted against an account's plan. This call requires authentication.
     * GET https://bitbucket.org/api/1.0/users/{accountname}/plan
     *
     * @param accountName The name of an individual or team account. You can also use a validated email address in place of the accountname value.
     * @return The number of users.
     */
    Long getPlan(String accountName);

    /**
     * Gets a count and the list of accounts following an account.
     * Use this API to get a list of the individuals following an account.
     * Currently, the Bitbucket UI does not list each account, it only displays the count.
     * Users can follow another user or a repository.
     * Use this resource to list an account's followers. This resource does not require authentication.
     * GET https://bitbucket.org/api/1.0/users/{accountname}/followers
     *
     * @param accountName The name of an individual or team account. You can also use a validated email address in place of the accountname value.
     * @return List of followers.
     */
    List<BitBucketUser> getFollowers(String accountName);

    /**
     * Gets a count and the list of events associated with an account. This call requires authentication.
     * GET https://bitbucket.org/api/1.0/users/{accountname}/events
     *
     * @param accountName The name of an individual or team account. You can also use a validated email address in place of the accountname value.
     * @return List of events.
     */
    List<BitBucketEvent> getEvents(String accountName);

}

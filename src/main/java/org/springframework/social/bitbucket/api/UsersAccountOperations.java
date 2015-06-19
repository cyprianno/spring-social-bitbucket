package org.springframework.social.bitbucket.api;

/**
 * Account Resource
 * This resource returns a user structure and the repositories array associated with an existing account
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/account+Resource"
 * @since 2.0.0
 */
public interface UsersAccountOperations {

    void getProfile(String accountName);

    void getPlan(String accountName);

    void getFollowers(String accountName);

    void getEvents(String accountName);

}

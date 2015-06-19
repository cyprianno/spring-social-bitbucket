package org.springframework.social.bitbucket.api;

/**
 * A consumer is an application authorized to integrate with a Bitbucket account.
 * Account owners or team administrators can give third-party web applications access to a Bitbucket individual account or a team.
 * By integrating an application with Bitbucket, you authorize that account to act as your user.
 * So, for example, if you have read/write access to all of the account, the application does as well.
 * Anything you could do when logged into Bitbucket, that application can also do.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/consumers+Resource"
 * @since 2.0.0
 */
public interface UsersConsumersOperations {
    void getConsumers(String accountName);

    void getConsumer(String accountName, String id);

    void updateConsumer(String accountName, String id, String name, String description);

    void removeConsumer(String accountName, String id);
}


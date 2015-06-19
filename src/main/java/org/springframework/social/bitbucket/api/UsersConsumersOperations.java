package org.springframework.social.bitbucket.api;

import java.util.List;

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
    /**
     * Returns an array of consumers integrated with the account.
     * GET https://api.bitbucket.org/1.0/users/{accountname}/consumers
     *
     * @param accountName The team or individual account name.
     * @return list of Consumers
     */
    List<BitBucketConsumer> getConsumers(String accountName);

    /**
     * Gets an individual consumer for an account.
     * GET https://api.bitbucket.org/1.0/users/{accountname}/consumers/{id}
     *
     * @param accountName The team or individual account name.
     * @param id          Identifier for the key
     * @return Consumer
     */
    BitBucketConsumer getConsumer(String accountName, long id);

    /**
     * Updates an individual consumer for an account.  You must supply the consumer's name parameter.
     * PUT https://api.bitbucket.org/1.0/users/{accountname}/{id} -d"name={name}&description={string}&url={url}"
     *
     * @param accountName The team or individual account name.
     * @param id          Identifier for the key
     * @param name        Name of the consumer.
     * @param description Description for the consumer.
     * @param url         The url
     * @return Updated Consumer.
     */
    BitBucketConsumer updateConsumer(String accountName, long id, String name, String description, String url);

    /**
     * Deletes an individual consumer from an account.
     * DELETE https://api.bitbucket.org/1.0/users/{accountname}/{id}
     *
     * @param accountName The team or individual account name.
     * @param id          Identifier for the key
     */
    void removeConsumer(String accountName, long id);
}


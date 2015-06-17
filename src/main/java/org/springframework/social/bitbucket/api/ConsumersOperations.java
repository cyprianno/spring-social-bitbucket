package org.springframework.social.bitbucket.api;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public interface ConsumersOperations {
    void getConsumers();

    void getConsumer();

    void updateConsumer();

    void removeConsumer();
}

/*###consumers
- GET a list of an account's consumers
GET https://api.bitbucket.org/1.0/users/{accountname}/consumers
- GET a consumer
GET https://api.bitbucket.org/1.0/users/{accountname}/{id}
- PUT an updated consumer
PUT https://api.bitbucket.org/1.0/users/{accountname}/{id} -d"name={name}&description={string}&url={url}"
- DELETES a consumer
DELETE https://api.bitbucket.org/1.0/users/{accountname}/{id}

getConsumers
getConsumer
updateConsumer
removeConsumer
*/

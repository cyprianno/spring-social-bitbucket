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

1. create interface
2. update javadoc (description + url from docs)
3. model (if necessary)
4. create empty implementation
5. optional - connect new operations class to base template
6. create tests
7. template implementation
8. file headers
9. real test (on connection with all permissions)

*/

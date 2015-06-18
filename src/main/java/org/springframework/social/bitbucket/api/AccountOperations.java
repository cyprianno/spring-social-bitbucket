package org.springframework.social.bitbucket.api;

/**
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public interface AccountOperations {

    void getProfile();
    void getPlan();
    void getFollowers();
    void getEvents();

}

/*
###account
- GET the account profile
GET https://bitbucket.org/api/1.0/users/{accountname}
GET https://bitbucket.org/api/1.0/users/{emailaddress}
- GET the account plan
GET https://bitbucket.org/api/1.0/users/{accountname}/plan
- !MOVE FROM USER! GET the followers
GET https://bitbucket.org/api/1.0/users/{accountname}/followers
- GET the events
GET https://bitbucket.org/api/1.0/users/{accountname}/events

getProfile
getPlan
getFollowers
getEvents

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

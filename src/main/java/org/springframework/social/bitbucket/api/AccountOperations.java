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
*/

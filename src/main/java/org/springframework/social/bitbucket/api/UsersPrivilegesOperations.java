package org.springframework.social.bitbucket.api;

/**
 * Use this resource to manage privilege settings for a team account.
 * Team accounts can grant groups account privileges as well as repository access.
 * Groups with account privileges are those with can administer this account (admin rights) or can create repositories in this account (collaborator rights)
 * You can make these calls on an individual account but the result is an empty set. This is because individual accounts do not let you set account privileges.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/privileges+Resource"
 * @since 2.0.0
 */
public interface UsersPrivilegesOperations {
    void getPrigilegeGroupOnTeamAccount(String accountName, String groupSlug);

    void getPrivilegesAssociatedWithGroup(String accountName, String owner, String groupSlug);

    void updateGroupPrivilegesOnTeamAccount(String accountName, String owner, String groupSlug, String privilege);

    void postNewPrivilege(String accountName, String owner, String groupSlug, String privilege);

    void removePrivilegeGroup(String accountName, String owner, String groupSlug);
}

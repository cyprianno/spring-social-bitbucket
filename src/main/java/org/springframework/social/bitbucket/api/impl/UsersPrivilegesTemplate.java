package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketInvitation;
import org.springframework.social.bitbucket.api.BitBucketTeamPrivilege;
import org.springframework.social.bitbucket.api.UsersPrivilegesOperations;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class UsersPrivilegesTemplate extends AbstractBitBucketOperations implements UsersPrivilegesOperations {
    public UsersPrivilegesTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final Map<String, BitBucketTeamPrivilege> getPrigilegeGroupOnTeamAccount(String accountName, String groupSlug) {
        return getRestTemplate().getForObject(buildUrl("/users/{accountname}/privileges"), TeamPrivilegeHolder.class, accountName);
    }

    @Override
    public final BitBucketTeamPrivilege getPrivilegesAssociatedWithGroup(String accountName, String owner, String groupSlug) {
        return getRestTemplate()
                .getForObject(buildUrl("/users/{accountname}/privileges/{owner}/{group_slug}"), TeamPrivilegeHolder.class, accountName, owner, groupSlug).get("privilege");
    }

    @Override
    public final Map<String, BitBucketTeamPrivilege> updateGroupPrivilegesOnTeamAccount(String accountName, String owner, String groupSlug, BitBucketTeamPrivilege privilege) {
        return null;
    }

    @Override
    public final Map<String, BitBucketTeamPrivilege> postNewPrivilege(String accountName, String owner, String groupSlug, BitBucketTeamPrivilege privilege) {
        return null;
    }

    @Override
    public final void removePrivilegeGroup(String accountName, String owner, String groupSlug) {
        getRestTemplate().delete(buildUrl("/users/{accountname}/privileges/{owner}/{group_slug}"), accountName, owner, groupSlug);
    }

    private static final class TeamPrivilegeHolder extends HashMap<String, BitBucketTeamPrivilege> {
    }
}

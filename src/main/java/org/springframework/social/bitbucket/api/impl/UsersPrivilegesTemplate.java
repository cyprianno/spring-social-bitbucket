package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketTeamPrivilege;
import org.springframework.social.bitbucket.api.UsersPrivilegesOperations;
import org.springframework.web.client.RestTemplate;

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
    public Map<String, BitBucketTeamPrivilege> getPrigilegeGroupOnTeamAccount(String accountName, String groupSlug) {
        return null;
    }

    @Override
    public BitBucketTeamPrivilege getPrivilegesAssociatedWithGroup(String accountName, String owner, String groupSlug) {
        return null;
    }

    @Override
    public Map<String, BitBucketTeamPrivilege> updateGroupPrivilegesOnTeamAccount(String accountName, String owner, String groupSlug, String privilege) {
        return null;
    }

    @Override
    public Map<String, BitBucketTeamPrivilege> postNewPrivilege(String accountName, String owner, String groupSlug, String privilege) {
        return null;
    }

    @Override
    public void removePrivilegeGroup(String accountName, String owner, String groupSlug) {

    }
}

package org.springframework.social.bitbucket.api.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.social.bitbucket.api.*;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesLinksTemplate extends AbstractBitBucketOperations implements RepositoriesLinksOperations {
    public RepositoriesLinksTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketLink> getLinks(String accountName, String repoSlug) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/links"), BitBucketLink[].class,
                        accountName, repoSlug));
    }


    @Override
    public  final BitBucketLink getLink(String accountName, String repoSlug, Long linkId) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/links/{object_id}"), BitBucketLink.class,
                        accountName, repoSlug, linkId);
    }

    @Override
    public  final BitBucketLink postNewLink(String accountName, String repoSlug, BitBucketLink link) {
        return null;
    }


    @Override
    public  final BitBucketLink updateLink(String accountName, String repoSlug, Long linkId, BitBucketLink link) {
        return null;
    }

    @Override
    public  final void removeLink(String accountName, String repoSlug, Long linkId) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/links/{object_id}"), accountName, repoSlug, linkId);
    }
}

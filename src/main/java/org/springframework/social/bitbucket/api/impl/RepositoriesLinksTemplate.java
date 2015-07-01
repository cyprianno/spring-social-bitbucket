package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketLink;
import org.springframework.social.bitbucket.api.RepositoriesLinksOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesLinksTemplate extends AbstractBitBucketOperations implements RepositoriesLinksOperations {
    public RepositoriesLinksTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public  final List<BitBucketLink> getLinks(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public  final BitBucketLink getLink(String accountName, String repoSlug, Long linkId) {
        return null;
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

    }
}

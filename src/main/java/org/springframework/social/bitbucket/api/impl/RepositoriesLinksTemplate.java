package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketLink;
import org.springframework.social.bitbucket.api.RepositoriesLinksOperations;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesLinksTemplate implements RepositoriesLinksOperations {
    @Override
    public List<BitBucketLink> getLinks(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public BitBucketLink getLink(String accountName, String repoSlug, Long linkId) {
        return null;
    }

    @Override
    public BitBucketLink postNewLink(String accountName, String repoSlug, BitBucketLink link) {
        return null;
    }

    @Override
    public BitBucketLink updateLink(String accountName, String repoSlug, Long linkId, BitBucketLink link) {
        return null;
    }

    @Override
    public void removeLink(String accountName, String repoSlug, Long linkId) {

    }
}

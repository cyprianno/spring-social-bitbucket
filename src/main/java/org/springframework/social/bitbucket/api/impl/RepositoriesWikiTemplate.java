package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketWikipage;
import org.springframework.social.bitbucket.api.RepositoriesWikiOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesWikiTemplate extends AbstractBitBucketOperations implements RepositoriesWikiOperations {
    public RepositoriesWikiTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public BitBucketWikipage getContent(String accountName, String repoSlug, String page) {
        return null;
    }

    @Override
    public boolean postNewPage(String accountName, String repoSlug, String page, String content) {
        return false;
    }

    @Override
    public boolean updatePage(String accountName, String repoSlug, String page, String content) {
        return false;
    }
}

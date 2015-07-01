package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketFile;
import org.springframework.social.bitbucket.api.RepositoriesSrcOperations;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesSrcTemplate implements RepositoriesSrcOperations {
    @Override
    public List<BitBucketFile> getElements(String accountName, String repoSlug, String revision, String path) {
        return null;
    }

    @Override
    public String getContent(String accountName, String repoSlug, String revision, String path) {
        return null;
    }
}

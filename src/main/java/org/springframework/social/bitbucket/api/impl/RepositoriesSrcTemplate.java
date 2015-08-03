package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketFile;
import org.springframework.social.bitbucket.api.BitBucketWikipage;
import org.springframework.social.bitbucket.api.RepositoriesSrcOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesSrcTemplate extends AbstractBitBucketOperations implements RepositoriesSrcOperations {
    public RepositoriesSrcTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketFile> getElements(String accountName, String repoSlug, String revision, String path) {
        String pageParam = path;
        if (path.startsWith("/")) {
            pageParam = path.substring(1);
        }
        return asList(getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/src/{revision}/{path}"), BitBucketFile[].class,
                        accountName, repoSlug, revision, pageParam));
    }

    @Override
    public final String getContent(String accountName, String repoSlug, String revision, String path) {
        String pageParam = path;
        if (path.startsWith("/")) {
            pageParam = path.substring(1);
        }
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/raw/{revision}/{path}"), String.class,
                        accountName, repoSlug, revision, pageParam);
    }
}

package org.springframework.social.bitbucket.api.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketIssue;
import org.springframework.social.bitbucket.api.BitBucketWikipage;
import org.springframework.social.bitbucket.api.RepositoriesWikiOperations;
import org.springframework.social.support.ParameterMap;
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
    public final BitBucketWikipage getContent(String accountName, String repoSlug, String page) {
        String pageParam = page;
        if (page.startsWith("/")) {
            pageParam = page.substring(1);
        }
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/wiki/{page}"), BitBucketWikipage.class,
                        accountName, repoSlug, pageParam);
    }

    @Override
    public final boolean postNewPage(String accountName, String repoSlug, String page, String content) {
        String pageParam = page;
        if (page.startsWith("/")) {
            pageParam = page.substring(1);
        }
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/wiki/{page}"), new WikiParamWrapper(content), String.class,
                        accountName, repoSlug, pageParam).equals("OK");
    }

    @Override
    public final boolean updatePage(String accountName, String repoSlug, String page, String content) {
        String pageParam = page;
        if (page.startsWith("/")) {
            pageParam = page.substring(1);
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_name}/wiki/{page}"), HttpMethod.PUT,
                new HttpEntity<>(new WikiParamWrapper(content), httpHeaders),
                String.class, accountName, repoSlug, pageParam).getBody().equals("OK");
    }

    private static class WikiParamWrapper extends ParameterMap {
        public WikiParamWrapper(String content) {
            add("content", content);
        }
    }
}

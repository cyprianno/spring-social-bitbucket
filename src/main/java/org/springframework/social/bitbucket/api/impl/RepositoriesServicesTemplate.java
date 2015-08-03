package org.springframework.social.bitbucket.api.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketService;
import org.springframework.social.bitbucket.api.RepositoriesServicesOperations;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesServicesTemplate extends AbstractBitBucketOperations implements RepositoriesServicesOperations {
    public RepositoriesServicesTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketService> getServices(String accountName, String repoSlug) {
        return asList(getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/services"), BitBucketService[].class,
                        accountName, repoSlug));
    }

    @Override
    public final BitBucketService getService(String accountName, String repoSlug, Long serviceId) {
        return getRestTemplate()
                .getForObject(buildUrl("/repositories/{accountname}/{repo_slug}/services/{id}"), BitBucketService.class,
                        accountName, repoSlug, serviceId);
    }

    @Override
    public final BitBucketService postNewService(String accountName, String repoSlug, String type, Map<String, String> fields) {
        return getRestTemplate()
                .postForObject(buildUrl("/repositories/{accountname}/{repo_slug}/services"), new ServiceCreateUpdate(type, fields), BitBucketService.class,
                        accountName, repoSlug);
    }

    @Override
    public final BitBucketService updateService(String accountName, String repoSlug, Long serviceId, Map<String, String> fields) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestTemplate().exchange(buildUrl("/repositories/{accountname}/{repo_slug}/services/{id}"), HttpMethod.PUT,
                new HttpEntity<>(new ServiceCreateUpdate(null, fields), httpHeaders),
                BitBucketService.class, accountName, repoSlug, serviceId).getBody();
    }

    @Override
    public final void removeService(String accountName, String repoSlug, Long serviceId) {
        getRestTemplate().delete(buildUrl("/repositories/{accountname}/{repo_slug}/services/{id}"), accountName, repoSlug, serviceId);
    }

    private static class ServiceCreateUpdate extends ParameterMap {

        public ServiceCreateUpdate(String type, Map<String, String> fields) {
            if (type != null) {
                add("type", type);
            }
            for (String key : fields.keySet()) {
                add(key, fields.get(key));
            }
        }
    }
}

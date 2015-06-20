package org.springframework.social.bitbucket.api.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.social.bitbucket.api.BitBucketConsumer;
import org.springframework.social.bitbucket.api.RepoPrivilege;
import org.springframework.social.bitbucket.api.UserWithRepositories;
import org.springframework.social.bitbucket.api.UsersConsumersOperations;
import org.springframework.social.support.ParameterMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class UsersConsumersTemplate extends AbstractBitBucketOperations implements UsersConsumersOperations {
    public UsersConsumersTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<BitBucketConsumer> getConsumers(String accountName) {
        return asList(getRestTemplate().getForObject(buildUrl("/users/{accountname}/consumers"), BitBucketConsumer[].class, accountName));
    }

    @Override
    public final BitBucketConsumer getConsumer(String accountName, long id) {
        return getRestTemplate().getForObject(buildUrl("/users/{accountname}/consumers/{id}"), BitBucketConsumer.class, accountName, id);
    }

    @Override
    public final BitBucketConsumer updateConsumer(String accountName, long id, String name, String description, String url) {
        return getRestTemplate().exchange(buildUrl("/users/{accountname}/{id}"), HttpMethod.PUT,
                new HttpEntity<>(new UpdateConsumerParameters(name, description, url)), BitBucketConsumer.class, accountName, id).getBody();
    }

    @Override
    public final void removeConsumer(String accountName, long id) {
        getRestTemplate().delete(buildUrl("/users/{accountname}/consumers/{id}"), accountName, id);
    }

    private static class UpdateConsumerParameters extends ParameterMap {
        public UpdateConsumerParameters(String name, String description, String url) {
            this.add("name", name);
            this.add("description", description);
            this.add("url", url);
        }
    }
}

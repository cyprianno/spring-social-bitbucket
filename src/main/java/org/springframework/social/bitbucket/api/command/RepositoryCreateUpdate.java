package org.springframework.social.bitbucket.api.command;

import org.springframework.social.support.ParameterMap;

/**
 * Created by Cyprian.Sniegota on 2015-08-02.
 */
public class RepositoryCreateUpdate extends ParameterMap {
    public RepositoryCreateUpdate(String description) {
        if (description != null) {
            set("description", description);
        }
    }
}
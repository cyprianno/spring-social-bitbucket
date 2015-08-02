package org.springframework.social.bitbucket.api.command;

import org.springframework.social.support.ParameterMap;

/**
 * Created by Cyprian.Sniegota on 2015-08-02.
 */
public class LinkCreateUpdate extends ParameterMap {
    public LinkCreateUpdate(String handlerUrl, String handlerDisplayFrom, String handlerName) {
        if (handlerUrl != null) {
            set("url", handlerUrl);
        }
        if (handlerDisplayFrom != null) {
            set("display_from", handlerDisplayFrom);
        }
        if (handlerName != null) {
            set("name", handlerName);
        }
    }

}
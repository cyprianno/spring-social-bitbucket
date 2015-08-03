package org.springframework.social.bitbucket.api.command;

import org.springframework.social.support.ParameterMap;

/**
 * Created by csniegot on 2015-08-03.
 */
public class CommentCreateUpdate extends ParameterMap {
    public CommentCreateUpdate(String content, Long parentId) {
        if (content != null) {
            set("content", content);
        }
        if (parentId != null) {
            set("parent_id", String.valueOf(parentId));
        }
    }
}

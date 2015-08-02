package org.springframework.social.bitbucket.api.command;

import org.springframework.social.support.ParameterMap;

/**
 * Data to create issue.
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class IssueCreateUpdate extends ParameterMap {
    public IssueCreateUpdate(String title, String content, String status) {
        if (status != null) {
            set("status", status);
        }
        if (content != null) {
            set("content", content);
        }
        if (title != null) {
            set("title", title);
        }
    }
}

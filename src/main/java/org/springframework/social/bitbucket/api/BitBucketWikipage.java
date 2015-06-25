package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Describes one wiki page.
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketWikipage {

    /**
     * Page content
     */
    @JsonProperty @Getter
    private String data;

    /**
     * Markup type.
     */
    @JsonProperty @Getter
    private BitBucketMarkup markup;

    /**
     * Revision hash.
     */
    @JsonProperty @Getter
    private String rev;
}

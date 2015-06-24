package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Links connect your commit messages and code comments directly to your JIRA issue tracker or Bamboo build server.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/links+Resources#linksResources-Overview"
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketLink {
    /**
     * BitBucket link handler. Exists only as a part of Link.
     * The content of the handler profile depends on whether the handler is a known type or a custom type.
     */
    public class BitBucketLinkHandler {
        /**
         * The location of the service.
         * For known types.
         */
        @JsonProperty
        @Getter
        private String url;

        /**
         * The display URL. Include references to capture groups with the syntax \1, \2, etc.
         * For both: known and unknown.
         */
        @JsonProperty("display_from")
        @Getter
        private String displayFrom;

        /**
         * The handler name.
         * For both: known and unknown.
         */
        @JsonProperty
        @Getter
        private String name;

        /**
         * A value identifying the project on the specified url.
         * For known types.
         */
        @JsonProperty
        @Getter
        private String key;

        /**
         * A value created by the Bitbucket service from the url.
         * The display name of the service.
         * For both: known and unknown.
         */
        @JsonProperty("display_to")
        @Getter
        private String displayTo;

        /**
         * Include references to capture groups with the syntax \1, \2, etc.
         * For unknown types.
         */
        @JsonProperty("replacement_url")
        @Getter
        private String replacementUrl;

        /**
         * Include capture groups for use in your link url.
         * For unknown types.
         */
        @JsonProperty
        @Getter
        private String rawRegex;

    }

    /**
     * A unique id assigned by Bitbucket.
     */
    @JsonProperty
    @Getter
    private Long id;

    /**
     * A profile of representing one of the following handler types:
     * - Jira
     * - Bamboo
     * - Cruicible
     * - Jenkins
     * - Custom
     */
    @JsonProperty
    @Getter
    private BitBucketLinkHandler handler;

}

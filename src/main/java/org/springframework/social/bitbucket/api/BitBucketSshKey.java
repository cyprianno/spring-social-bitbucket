package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketSshKey {

    /**
     * The key identifier (ID).
     */
    @JsonProperty
    @Getter
    private long pk;

    /**
     * Public key value.
     */
    @JsonProperty
    @Getter
    private String key;

    /**
     * The user-visible label on the key.
     */
    @JsonProperty
    @Getter
    private String label;
}

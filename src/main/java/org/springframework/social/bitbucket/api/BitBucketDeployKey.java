package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Description of ssh key used for deploying product builds.
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketDeployKey {

    /**
     * The key identifier (ID).
     */
    @JsonProperty @Getter
    private Long id;

    /**
     * Public key value.
     */
    @JsonProperty @Getter
    private String key;

    /**
     * The user-visible label on the key.
     */
    @JsonProperty @Getter
    private String label;
}

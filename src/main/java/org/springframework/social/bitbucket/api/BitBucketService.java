package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * BitBucket Service info.
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketService {

    public static class BitBucketServiceProfile {
        @JsonProperty @Getter
        private List<BitBucketServiceProfileField> fields = new ArrayList<>();
        @JsonProperty @Getter
        private String type;
    }

    public static class BitBucketServiceProfileField {

        @JsonProperty @Getter
        private String name;
        @JsonProperty @Getter
        private String value;
    }

    @JsonProperty @Getter
    private long id;

    @JsonProperty @Getter
    private BitBucketServiceProfile service;
}

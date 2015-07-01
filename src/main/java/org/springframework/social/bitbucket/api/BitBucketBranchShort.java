package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketBranchShort {
    @JsonProperty @Getter
    private String changeset;
    @JsonProperty @Getter
    private List<String> heads;
    @JsonProperty @Getter
    private String name;
    @JsonProperty @Getter
    private boolean mainBranch;
}

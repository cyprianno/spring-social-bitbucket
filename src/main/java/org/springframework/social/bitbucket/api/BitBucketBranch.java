package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketBranch {

    @JsonProperty @Getter
    private String node;
    @JsonProperty @Getter
    private List<BitBucketFile> files;
    @JsonProperty @Getter
    private String rawAuthor;
    @JsonProperty @Getter
    private Date utcTimestamp;
    @JsonProperty @Getter
    private String author;
    @JsonProperty @Getter
    private Date timestamp;
    @JsonProperty @Getter
    private String rawNode;
    @JsonProperty @Getter
    private Set<String> parents;
    @JsonProperty @Getter
    private String branch;
    @JsonProperty @Getter
    private String message;
    @JsonProperty @Getter
    private String revision;
    @JsonProperty @Getter
    private Long size;

}

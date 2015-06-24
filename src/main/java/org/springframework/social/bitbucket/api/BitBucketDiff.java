package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Diff of a file in changeset. Not fully implemented. Problem with parsing json data.
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketDiff {
    @JsonProperty @Getter
    private String note;

    @JsonProperty("from_lines_per_page") @Getter
    private long fromLinesPerPage;

    @JsonProperty("from_pages_per_block") @Getter
    private long fromPagesPerBlock;

}

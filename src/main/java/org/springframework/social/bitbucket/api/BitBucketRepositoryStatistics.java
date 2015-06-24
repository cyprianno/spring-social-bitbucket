package org.springframework.social.bitbucket.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.annotation.Nullable;
import java.io.Serializable;

/**
 * Statistics data about repository file.
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketRepositoryStatistics implements Serializable {

    /**
     * Change statistics in numbers; Instance exists only as a part of BitBucketRepositoryStatistics.
     */
    public class BitBucketDiffstat implements Serializable {
        /**
         * Number of lines removed.
         * Could be null if it is a large difference
         */
        @JsonProperty @Getter @Nullable
        private Long removed;
        /**
         * Number of lines added.
         * Could be null if it is a large difference
         */
        @JsonProperty @Getter @Nullable
        private Long added;
    }

    /**
     * Type of file change. Currently known values are:
     * added, modified
     */
    @JsonProperty @Getter
    private String type;

    /**
     * Changed file name.
     */
    @JsonProperty @Getter
    private String file;

    /**
     * Change statistics.
     */
    @JsonProperty@Getter
    private BitBucketDiffstat diffstat;

}

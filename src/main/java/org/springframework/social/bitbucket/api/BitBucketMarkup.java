package org.springframework.social.bitbucket.api;

/**
 * Markup type field.
 * Bitbucket surmises the mark up used in the Wiki based on the page extensions.
 * The file type may not always be correct in cases where there is no extension; these types appear as markdown.
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public enum BitBucketMarkup {
    markdown, creole, rest, textile
}

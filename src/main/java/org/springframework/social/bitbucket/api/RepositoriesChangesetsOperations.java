package org.springframework.social.bitbucket.api;

/**
 * Use changesets resources to manage changesets resources on a repository.
 * Unauthenticated calls for these resources only return values for public repositories.
 * To see changeset resources on private repositories, the caller must authenticated and must have at least read permissions on the repository.
 * Changesets are read-only resources, you can't add or modify a changeset structure.
 * You can modify the secondary resources such as comments associated with an individual change set node.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/changesets+Resource"
 * @since 2.0.0
 */
public interface RepositoriesChangesetsOperations {

    BitBucketChangesets getChangesets(String accountName, String repoSlug, String start, int limit);

    BitBucketChangeset getChangeset(String accountName, String repoSlug, String node);

    BitBucketChangeset getDiff(String accountName, String repoSlug, String node);

    BitBucketChangeset getComments(String accountName, String repoSlug, String node);

    void removeComment(String accountName, String repoSlug, String node);

    BitBucketChangeset postComment();

    BitBucketChangeset updateComment();

    BitBucketChangeset toogleSpamComment();

}

/* TBD GET participants associated with an individual changeset
GET https://bitbucket.org/api/2.0/repositories/{accountname}/{repo_slug}/commit/{sha1}
- TBD GET statistics associated with an individual changeset
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/diffstat
- TBD GET the diff associated with a changeset
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/diff
- TBD GET a list of comments on a changeset
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/comments
- TBD DELETE a comment on a changeset
DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/comments/{comment_id}
- TBD POST a new comment on a changeset
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/comments
- TBD PUT an update to an existing changeset comment
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/comments/{comment_id}
- TBD Toggle spam flag on an existing changeset comment
PUT  https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/comments/spam/{comment_id }*/

package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketComment;
import org.springframework.social.bitbucket.api.BitBucketComponent;
import org.springframework.social.bitbucket.api.BitBucketIssue;
import org.springframework.social.bitbucket.api.BitBucketMilestone;
import org.springframework.social.bitbucket.api.BitBucketUser;
import org.springframework.social.bitbucket.api.BitBucketVersion;
import org.springframework.social.bitbucket.api.RepositoriesIssuesOperations;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesIssuesTemplate implements RepositoriesIssuesOperations {
    @Override
    public List<BitBucketIssue> getIssues(String accountName, String repoSlug, Integer start, Integer limit, String sort) {
        return null;
    }

    @Override
    public BitBucketIssue getIssue(String accountName, String repoSlug, Long issueId) {
        return null;
    }

    @Override
    public List<BitBucketUser> getFollowers(String accountName, String repoSlug, Long issueId) {
        return null;
    }

    @Override
    public BitBucketIssue postNewIssue(String accountName, String repoSlug, BitBucketIssue issue) {
        return null;
    }

    @Override
    public BitBucketIssue updateIssue(String accountName, String repoSlug, Long issueId, BitBucketIssue issue) {
        return null;
    }

    @Override
    public void removeIssue(String accountName, String repoSlug, Long issueId) {

    }

    @Override
    public List<BitBucketComment> getComments(String accountName, String repoSlug, Long issueId) {
        return null;
    }

    @Override
    public BitBucketComment getComment(String accountName, String repoSlug, Long issueId, Long commentId) {
        return null;
    }

    @Override
    public BitBucketComment postNewComment(String accountName, String repoSlug, Long issueId, String content) {
        return null;
    }

    @Override
    public BitBucketComment updateComment(String accountName, String repoSlug, Long issueId, String commentId, String content) {
        return null;
    }

    @Override
    public List<BitBucketComponent> getComponents(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public BitBucketComponent getComponent(String accountName, String repoSlug, Long objectId) {
        return null;
    }

    @Override
    public BitBucketComponent postNewComponent(String accountName, String repoSlug, String name) {
        return null;
    }

    @Override
    public BitBucketComponent updateComponent(String accountName, String repoSlug, Long objectId, String name) {
        return null;
    }

    @Override
    public void removeComponent(String accountName, String repoSlug, Long objectId) {

    }

    @Override
    public List<BitBucketVersion> getVersions(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public BitBucketVersion getVersion(String accountName, String repoSlug, Long objectId) {
        return null;
    }

    @Override
    public BitBucketVersion postNewVersion(String accountName, String repoSlug, String name) {
        return null;
    }

    @Override
    public BitBucketVersion updateVersion(String accountName, String repoSlug, Long objectId, String name) {
        return null;
    }

    @Override
    public void removeVersion(String accountName, String repoSlug, Long objectId) {

    }

    @Override
    public List<BitBucketMilestone> getMilestones(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public BitBucketMilestone getMilestone(String accountName, String repoSlug, Long objectId) {
        return null;
    }

    @Override
    public BitBucketMilestone postNewMilestone(String accountName, String repoSlug, String name) {
        return null;
    }

    @Override
    public BitBucketMilestone updateMilestone(String accountName, String repoSlug, Long objectId, String name) {
        return null;
    }

    @Override
    public void removeMilestone(String accountName, String repoSlug, Long objectId) {

    }
}

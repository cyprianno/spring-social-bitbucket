package org.springframework.social.bitbucket.api.impl;

import org.springframework.social.bitbucket.api.BitBucketComment;
import org.springframework.social.bitbucket.api.BitBucketComponent;
import org.springframework.social.bitbucket.api.BitBucketIssue;
import org.springframework.social.bitbucket.api.BitBucketMilestone;
import org.springframework.social.bitbucket.api.BitBucketUser;
import org.springframework.social.bitbucket.api.BitBucketVersion;
import org.springframework.social.bitbucket.api.RepositoriesIssuesOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesIssuesTemplate extends AbstractBitBucketOperations implements RepositoriesIssuesOperations {
    public RepositoriesIssuesTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public  final List<BitBucketIssue> getIssues(String accountName, String repoSlug, Integer start, Integer limit, String sort) {
        return null;
    }

    @Override
    public  final BitBucketIssue getIssue(String accountName, String repoSlug, Long issueId) {
        return null;
    }

    @Override
    public  final List<BitBucketUser> getFollowers(String accountName, String repoSlug, Long issueId) {
        return null;
    }

    @Override
    public  final BitBucketIssue postNewIssue(String accountName, String repoSlug, BitBucketIssue issue) {
        return null;
    }

    @Override
    public  final BitBucketIssue updateIssue(String accountName, String repoSlug, Long issueId, BitBucketIssue issue) {
        return null;
    }

    @Override
    public  final void removeIssue(String accountName, String repoSlug, Long issueId) {

    }

    @Override
    public  final List<BitBucketComment> getComments(String accountName, String repoSlug, Long issueId) {
        return null;
    }

    @Override
    public  final BitBucketComment getComment(String accountName, String repoSlug, Long issueId, Long commentId) {
        return null;
    }

    @Override
    public  final BitBucketComment postNewComment(String accountName, String repoSlug, Long issueId, String content) {
        return null;
    }

    @Override
    public  final BitBucketComment updateComment(String accountName, String repoSlug, Long issueId, Long commentId, String content) {
        return null;
    }

    @Override
    public  final List<BitBucketComponent> getComponents(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public  final BitBucketComponent getComponent(String accountName, String repoSlug, Long objectId) {
        return null;
    }

    @Override
    public  final BitBucketComponent postNewComponent(String accountName, String repoSlug, String name) {
        return null;
    }

    @Override
    public  final BitBucketComponent updateComponent(String accountName, String repoSlug, Long objectId, String name) {
        return null;
    }

    @Override
    public  final void removeComponent(String accountName, String repoSlug, Long objectId) {

    }

    @Override
    public  final List<BitBucketVersion> getVersions(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public  final BitBucketVersion getVersion(String accountName, String repoSlug, Long objectId) {
        return null;
    }

    @Override
    public  final BitBucketVersion postNewVersion(String accountName, String repoSlug, String name) {
        return null;
    }

    @Override
    public  final BitBucketVersion updateVersion(String accountName, String repoSlug, Long objectId, String name) {
        return null;
    }

    @Override
    public  final void removeVersion(String accountName, String repoSlug, Long objectId) {

    }

    @Override
    public  final List<BitBucketMilestone> getMilestones(String accountName, String repoSlug) {
        return null;
    }

    @Override
    public  final BitBucketMilestone getMilestone(String accountName, String repoSlug, Long objectId) {
        return null;
    }

    @Override
    public  final BitBucketMilestone postNewMilestone(String accountName, String repoSlug, String name) {
        return null;
    }

    @Override
    public  final BitBucketMilestone updateMilestone(String accountName, String repoSlug, Long objectId, String name) {
        return null;
    }

    @Override
    public  final void removeMilestone(String accountName, String repoSlug, Long objectId) {

    }
}

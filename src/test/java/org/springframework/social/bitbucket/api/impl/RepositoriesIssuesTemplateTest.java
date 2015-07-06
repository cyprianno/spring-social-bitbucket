package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.BitBucketIssue;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withNoContent;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public class RepositoriesIssuesTemplateTest extends BaseTemplateTest {
    private static final String TEST_USERNAME = "testusername";
    private static final String TEST_REPOSLUG = "testreposlug";

    @Test
    public void testGetIssues() throws Exception {
        assertTrue(false);
        //get-issues
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().getIssues(TEST_USERNAME, TEST_REPOSLUG, 1, 10, null);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetIssue() throws Exception {
        assertTrue(false);
        //get-issue
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().getIssue(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetFollowers() throws Exception {
        assertTrue(false);
        //get-issue-followers
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().getFollowers(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testPostNewIssue() throws Exception {
        assertTrue(false);
        //post-issue
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/ssh-keys")).andExpect(method(POST)).andExpect(
                content().string("key=123123123")).andRespond(withSuccess(jsonResource("post-key"), MediaType.APPLICATION_JSON));
        BitBucketIssue issue = BitBucketIssue.builder().content("issuecontent").build();
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().postNewIssue(TEST_USERNAME, TEST_REPOSLUG, issue);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testUpdateIssue() throws Exception {
        assertTrue(false);
        //put-issue
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/emails/test@email.tld")).andExpect(method(PUT))
                .andExpect(content().string("primary=true")).andRespond(withSuccess(jsonResource("update-email-address"), MediaType.APPLICATION_JSON));
        BitBucketIssue issue = BitBucketIssue.builder().content("issuecontent").build();
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().updateIssue(TEST_USERNAME, TEST_REPOSLUG, 1L, issue);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testRemoveIssue() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/invitations/test@email.tld")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().removeIssue(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetComments() throws Exception {
        assertTrue(false);
        //get-issue-comments
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().getComments(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetComment() throws Exception {
        assertTrue(false);
        //get-issue-comment
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().getComment(TEST_USERNAME, TEST_REPOSLUG, 1L, 2L);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testPostNewComment() throws Exception {
        assertTrue(false);
        //post-issue-comment
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/ssh-keys")).andExpect(method(POST)).andExpect(
                content().string("key=123123123")).andRespond(withSuccess(jsonResource("post-key"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().postNewComment(TEST_USERNAME, TEST_REPOSLUG, 1L, "comment content");
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testUpdateComment() throws Exception {
        assertTrue(false);
        //put-issue-comment
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/emails/test@email.tld")).andExpect(method(PUT))
                .andExpect(content().string("primary=true")).andRespond(withSuccess(jsonResource("update-email-address"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().updateComment(TEST_USERNAME, TEST_REPOSLUG, 1L, 2L, "");

        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetComponents() throws Exception {
        assertTrue(false);
        //get-components
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().getComponents(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetComponent() throws Exception {
        assertTrue(false);
        //get-component
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().getComponent(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testPostNewComponent() throws Exception {
        assertTrue(false);
        //post-component
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/ssh-keys")).andExpect(method(POST)).andExpect(
                content().string("key=123123123")).andRespond(withSuccess(jsonResource("post-key"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().postNewComponent(TEST_USERNAME, TEST_REPOSLUG, "componentname");
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testUpdateComponent() throws Exception {
        assertTrue(false);
        //put-components
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/emails/test@email.tld")).andExpect(method(PUT))
                .andExpect(content().string("primary=true")).andRespond(withSuccess(jsonResource("update-email-address"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().updateComponent(TEST_USERNAME, TEST_REPOSLUG, 2L, "newname");
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testRemoveComponent() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/invitations/test@email.tld")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().removeComponent(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetVersions() throws Exception {
        assertTrue(false);
        //get-versions
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().getVersions(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetVersion() throws Exception {
        assertTrue(false);
        //get-version
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().getVersion(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testPostNewVersion() throws Exception {
        assertTrue(false);
        //post-version
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/ssh-keys")).andExpect(method(POST)).andExpect(
                content().string("key=123123123")).andRespond(withSuccess(jsonResource("post-key"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().postNewVersion(TEST_USERNAME, TEST_REPOSLUG, "vname");
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testUpdateVersion() throws Exception {
        assertTrue(false);
        //put-version
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/emails/test@email.tld")).andExpect(method(PUT))
                .andExpect(content().string("primary=true")).andRespond(withSuccess(jsonResource("update-email-address"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().updateVersion(TEST_USERNAME, TEST_REPOSLUG, 1L, "newname");
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testRemoveVersion() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/invitations/test@email.tld")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().removeVersion(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetMilestones() throws Exception {
        assertTrue(false);
        //get-milestones
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().getMilestones(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testGetMilestone() throws Exception {
        assertTrue(false);
        //get-milestone
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/changesets/testnode/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-comments"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().getMilestone(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testPostNewMilestone() throws Exception {
        assertTrue(false);
        //post-milestone
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/ssh-keys")).andExpect(method(POST)).andExpect(
                content().string("key=123123123")).andRespond(withSuccess(jsonResource("post-key"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().postNewMilestone(TEST_USERNAME, TEST_REPOSLUG, "mname");
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testUpdateMilestone() throws Exception {
        assertTrue(false);
        //put-milestone
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/emails/test@email.tld")).andExpect(method(PUT))
                .andExpect(content().string("primary=true")).andRespond(withSuccess(jsonResource("update-email-address"), MediaType.APPLICATION_JSON));
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().updateMilestone(TEST_USERNAME, TEST_REPOSLUG, 1L, "newname");
        //then
        mockServer.verify();
        assertTrue(false);
    }

    @Test
    public void testRemoveMilestone() throws Exception {
        assertTrue(false);
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/users/testaccount/invitations/test@email.tld")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().removeMilestone(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertTrue(false);
    }
}
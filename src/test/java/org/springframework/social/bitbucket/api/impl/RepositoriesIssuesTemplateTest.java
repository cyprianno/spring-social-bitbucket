/**
 * Copyright (C) 2012 Eric Bottard / Guillaume Lederrey (eric.bottard+ghpublic@gmail.com / guillaume.lederrey@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.bitbucket.api.impl;

import org.junit.Test;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.social.bitbucket.api.*;
import org.springframework.social.bitbucket.api.command.IssueCreateUpdate;

import java.util.Date;
import java.util.List;
import java.util.Locale;

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
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-issues"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketIssue> result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().getIssues(TEST_USERNAME, TEST_REPOSLUG, 1, 10, null);
        //then
        mockServer.verify();
        assertEquals(1, result.size());
    }

    @Test
    public void testGetIssue() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/1"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-issue"), MediaType.APPLICATION_JSON));
        //when
        BitBucketIssue result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().getIssue(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd HH:mm:ssZ");
        assertEquals("duplicate", result.getStatus());
        assertEquals("major", result.getPriority());
        assertEquals("Why  the FORBIDDEN code is 401?", result.getTitle());
        assertEquals(1, result.getCommentCount());
        assertEquals("The class rc_factory in the utils model has a dictionary with the http-codes.\r\n\r\nThe standard code for forbidden is 403.\r\n401 is used for unauthorized.\r\n\r\n", result.getContent());
        assertEquals(198L, result.getLocalId());
        assertEquals(0, result.getFollowerCount());
        assertEquals("/1.0/repositories/jespern/django-piston/issues/198", result.getResourceUri());
        assertFalse(result.isSpam());
        Date expectedDate = dateFormatter.parse("2012-05-29 14:38:42+0000", Locale.getDefault());
        assertEquals(expectedDate, result.getUtcLastUpdated());
        expectedDate = dateFormatter.parse("2011-10-04 23:37:00+0000", Locale.getDefault());
        assertEquals(expectedDate, result.getCreatedOn());
        expectedDate = dateFormatter.parse("2011-10-04 21:37:00+0000", Locale.getDefault());
        assertEquals(expectedDate, result.getUtcCreatedOn());
        assertNotNull(result.getMetadata());
        assertEquals("bug", result.getMetadata().getKind());
        assertNull(result.getMetadata().getVersion());
        assertNull(result.getMetadata().getComponent());
        assertNull(result.getMetadata().getMilestone());
    }

    @Test
    public void testGetFollowers() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/1/followers"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-issue-followers"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketUser> result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().getFollowers(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertEquals(2, result.size());
    }

    @Test
    public void testPostNewIssue() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues")).andExpect(method(POST)).andExpect(
                content().string("content=issuecontent&title=value")).andRespond(withSuccess(jsonResource("post-issue"), MediaType.APPLICATION_JSON));
        IssueCreateUpdate issue = new IssueCreateUpdate("value", "issuecontent", null);
        //when
        BitBucketIssue result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().postNewIssue(TEST_USERNAME, TEST_REPOSLUG, issue);
        //then
        mockServer.verify();
        assertEquals("new", result.getStatus());
        assertEquals("trivial", result.getPriority());
    }

    @Test
    public void testUpdateIssue() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/1")).andExpect(method(PUT))
                .andExpect(content().string("content=issuecontent")).andRespond(withSuccess(jsonResource("put-issue"), MediaType.APPLICATION_JSON));
        IssueCreateUpdate issue = new IssueCreateUpdate(null, "issuecontent", null);
        //when
        BitBucketIssue result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().updateIssue(TEST_USERNAME, TEST_REPOSLUG, 1L, issue);
        //then
        mockServer.verify();
        assertEquals("new", result.getStatus());
        assertEquals("trivial", result.getPriority());
    }

    @Test
    public void testRemoveIssue() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/1")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().removeIssue(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
    }

    @Test
    public void testGetComments() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/1/comments"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-issue-comments"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketComment> result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().getComments(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertEquals(1, result.size());
    }

    @Test
    public void testGetComment() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/1/comments/2"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-issue-comment"), MediaType.APPLICATION_JSON));
        //when
        BitBucketComment result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().getComment(TEST_USERNAME, TEST_REPOSLUG, 1L, 2L);
        //then
        mockServer.verify();
        assertEquals("This is a comment on the issue", result.getContent());
    }

    @Test
    public void testPostNewComment() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/1/comments")).andExpect(method(POST)).andExpect(
                content().string("content=comment+content")).andRespond(withSuccess(jsonResource("post-issue-comment"), MediaType.APPLICATION_JSON));
        //when
        BitBucketComment result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().postNewComment(TEST_USERNAME, TEST_REPOSLUG, 1L, "comment content");
        //then
        mockServer.verify();
        assertEquals(1742510L, result.getCommentId());
    }

    @Test
    public void testUpdateComment() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/1/comments/2")).andExpect(method(PUT))
                .andExpect(content().string("content=xxx")).andRespond(withSuccess(jsonResource("put-issue-comment"), MediaType.APPLICATION_JSON));
        //when
        BitBucketComment result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().updateComment(TEST_USERNAME, TEST_REPOSLUG, 1L, 2L, "xxx");

        //then
        mockServer.verify();
        assertNotNull(result.getAuthorInfo());
    }

    @Test
    public void testGetComponents() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/components"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-components"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketComponent> result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().getComponents(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertEquals(3, result.size());
    }

    @Test
    public void testGetComponent() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/components/1"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-component"), MediaType.APPLICATION_JSON));
        //when
        BitBucketComponent result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().getComponent(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertEquals("api", result.getName());
        assertEquals(37L, result.getId());
    }

    @Test
    public void testPostNewComponent() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/components")).andExpect(method(POST)).andExpect(
                content().string("name=componentname")).andRespond(withSuccess(jsonResource("post-component"), MediaType.APPLICATION_JSON));
        //when
        BitBucketComponent result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().postNewComponent(TEST_USERNAME, TEST_REPOSLUG, "componentname");
        //then
        mockServer.verify();
        assertEquals("gui", result.getName());
        assertEquals(908L, result.getId());
    }

    @Test
    public void testUpdateComponent() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/components/2")).andExpect(method(PUT))
                .andExpect(content().string("name=newname")).andRespond(withSuccess(jsonResource("put-component"), MediaType.APPLICATION_JSON));
        //when
        BitBucketComponent result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().updateComponent(TEST_USERNAME, TEST_REPOSLUG, 2L, "newname");
        //then
        mockServer.verify();
        assertEquals("GUI", result.getName());
        assertEquals(908L, result.getId());
    }

    @Test
    public void testRemoveComponent() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/components/1")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().removeComponent(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
    }

    @Test
    public void testGetVersions() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/versions"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-versions"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketVersion> result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().getVersions(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetVersion() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/versions/1"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-version"), MediaType.APPLICATION_JSON));
        //when
        BitBucketVersion result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().getVersion(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertEquals("api", result.getName());
        assertEquals(37L, result.getId());
    }

    @Test
    public void testPostNewVersion() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/versions")).andExpect(method(POST)).andExpect(
                content().string("name=vname")).andRespond(withSuccess(jsonResource("post-versions"), MediaType.APPLICATION_JSON));
        //when
        BitBucketVersion result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().postNewVersion(TEST_USERNAME, TEST_REPOSLUG, "vname");
        //then
        mockServer.verify();
        assertEquals("2.0", result.getName());
        assertEquals(9108L, result.getId());
    }

    @Test
    public void testUpdateVersion() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/versions/1")).andExpect(method(PUT))
                .andExpect(content().string("name=newname")).andRespond(withSuccess(jsonResource("put-versions"), MediaType.APPLICATION_JSON));
        //when
        BitBucketVersion result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().updateVersion(TEST_USERNAME, TEST_REPOSLUG, 1L, "newname");
        //then
        mockServer.verify();
        assertEquals("2.0.0", result.getName());
        assertEquals(9108L, result.getId());
    }

    @Test
    public void testRemoveVersion() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/versions/1")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().removeVersion(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
    }

    @Test
    public void testGetMilestones() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/milestones"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-milestones"), MediaType.APPLICATION_JSON));
        //when
        List<BitBucketMilestone> result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().getMilestones(TEST_USERNAME, TEST_REPOSLUG);
        //then
        mockServer.verify();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetMilestone() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/milestones/1"))
                .andExpect(method(GET)).andRespond(withSuccess(jsonResource("get-milestone"), MediaType.APPLICATION_JSON));
        //when
        BitBucketMilestone result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().getMilestone(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
        assertEquals("2", result.getName());
        assertEquals(12L, result.getId());
    }

    @Test
    public void testPostNewMilestone() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/milestones")).andExpect(method(POST)).andExpect(
                content().string("name=mname")).andRespond(withSuccess(jsonResource("post-milestone"), MediaType.APPLICATION_JSON));
        //when
        BitBucketMilestone result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().postNewMilestone(TEST_USERNAME, TEST_REPOSLUG, "mname");
        //then
        mockServer.verify();
        assertEquals("3", result.getName());
        assertEquals(998L, result.getId());
    }

    @Test
    public void testUpdateMilestone() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/milestones/1")).andExpect(method(PUT))
                .andExpect(content().string("name=newname")).andRespond(withSuccess(jsonResource("put-milestone"), MediaType.APPLICATION_JSON));
        //when
        BitBucketMilestone result = bitBucket.repositoriesOperations().repositoriesIssuesOperations().updateMilestone(TEST_USERNAME, TEST_REPOSLUG, 1L, "newname");
        //then
        mockServer.verify();
        assertEquals("23", result.getName());
        assertEquals(231L, result.getId());
    }

    @Test
    public void testRemoveMilestone() throws Exception {
        //given
        mockServer.expect(requestTo("https://api.bitbucket.org/1.0/repositories/testusername/testreposlug/issues/milestones/1")).andExpect(method(DELETE))
                .andRespond(withNoContent());
        //when
        bitBucket.repositoriesOperations().repositoriesIssuesOperations().removeMilestone(TEST_USERNAME, TEST_REPOSLUG, 1L);
        //then
        mockServer.verify();
    }
}
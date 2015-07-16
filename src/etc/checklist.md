Api snapshot: 2015-06-14

#API v1:

##privileges
- OK GET a list of individual user privileges granted on a repository
GET https://bitbucket.org/api/1.0/privileges/{accountname}/{repo_slug}
PrivilegeTemplate.getRepoPrivileges
- TBD GET privileges for an individual
GET https://bitbucket.org/api/1.0/privileges/{accountname}/{repo_slug}/{privilege_account}
- TBD GET a list of all privileges across all an account's repositories
GET https://bitbucket.org/api/1.0/privileges/{accountname}
- OK PUT a new privilege
PUT  https://bitbucket.org/api/1.0/privileges/{accountname}/{repo_slug}/{privilege_account} --data {read}
PrivilegeTemplate.setPrivilege
- OK DELETE account privileges from a repository
DELETE  https://bitbucket.org/api/1.0/privileges/{accountname}/{repo_slug}/{privilege_account}
PrivilegeTemplate.removePrivilege
- TBD DELETE all privileges from a repository  
DELETE  https://bitbucket.org/api/1.0/privileges/{accountname}/{repo_slug}
- TBD DELETE all privileges from all repositories
DELETE  https://bitbucket.org/api/1.0/privileges/{accountname} 

##groups
- TBD GET a list of matching groups
GET https://bitbucket.org/api/1.0/groups?{filter}&{filter}&...
- TBD GET a list of groups
GET https://bitbucket.org/api/1.0/groups/{accountname}/
- TBD POST a new group
POST https://bitbucket.org/api/1.0/groups/{accountname}  --data "name=string"
- TBD Update a group
PUT https://bitbucket.org/api/1.0/groups/{accountname}/{group_slug}/  --header "Accept: application/json" --data '{"name":"developers","permission":"write","auto_add":true}'
- TBD DELETE a group
DELETE  https://bitbucket.org/api/1.0/groups/{accountname}/{group_slug}/ 
- TBD GET the group members
GET https://bitbucket.org/api/1.0/groups/{accountname}/{group_slug}/members
- TBD PUT new member into a group
PUT https://bitbucket.org/api/1.0/groups/{accountname}/{group_slug}/members/{membername}
- TBD DELETE a member
DELETE  https://bitbucket.org/api/1.0/groups/{accountname}/{group_slug}/members/{membername}

##group-privileges
- TBD GET a list of privileged groups
 GET https://bitbucket.org/api/1.0/group-privileges/{accountname}
- TBD GET a list of privileged groups for a repository
GET https://bitbucket.org/api/1.0/group-privileges/{accountname}/{repo_slug}
- TBD GET a group on a repository
GET  https://bitbucket.org/api/1.0/group-privileges/{accountname}/{repo_slug}/{group_owner}/{group_slug}
- TBD GET a list of repositories with a specific privilege group
GET https://bitbucket.org/api/1.0/group-privileges/{accountname}/{group_owner}/{group_slug}
- TBD PUT group privileges on a repository
PUT https://bitbucket.org/api/1.0/group-privileges/{accountname}/{repo_slug}/{group_owner}/{group_slug} --data "{privilege}"
- TBD DELETE group privileges from a repository
DELETE https://bitbucket.org/api/1.0/group-privileges/{accountname}/{repo_slug}/{group_owner}/{group_slug} 
- TBD DELETE privileges for a group across all your repositories
DELETE https://bitbucket.org/api/1.0/group-privileges/{accountname}/group_owner}/{group_slug} 

##invitations
- TBD Sending an invite
POST https://bitbucket.org/api/1.0/invitations/{accountname}/{repo_slug}/{emailaddress} --data permission={perm}

##repositories

###changesets
- OK GET a list of changesets
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets?limit=integer?start=node
RepoTemplate.getChangesets
- TBD GET an individual changeset
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}
- TBD GET participants associated with an individual changeset
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
PUT  https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/changesets/{node}/comments/spam/{comment_id } 

###deploy-keys
- TBD GET a list of keys
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/deploy-keys
- TBD GET the key's content
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/deploy-keys/{pk}
- TBD POST a new key
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/deploy-keys --data "key=value"
- TBD DELETE a key
DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/deploy-keys/{pk}

###events
- TBD GET a list of events
GET https:// bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/events?limit=integer&start=integer&type=event

###followers
- OK GET the repository followers
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/followers
RepoTemplate.getFollowers

###issues
- TBD GET a list of issues in a repository's tracker
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues?parameter=value&parameter=value&...
- TBD GET an individual issue
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}
- TBD GET a list of an issue's followers
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/followers
- TBD POST a new issue
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues  --data "title=value&content=value"
- TBD Update an existing issue
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}  --data "parameter=value&parameter=value"
- TBD DELETE an issue
DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}
- TBD GET the comments for an issue
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments
- TBD GET an individual comment
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments/{comment_id}
- TBD POST a new comment on the issue
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments --data "content=string"
- TBD Update a comment
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/{issue_id}/comments/{comment_id} --data "content=string"
- TBD GET the components defined on an issue tracker
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components
- TBD GET an individual component
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components/{object_id}
- TBD POST a new component in an issue tracker
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components --data "name=String"
- TBD Update an existing component
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components/{object_id} --data "name=String"
- TBD DELETE a component from the issue tracker
DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/components/{object_id}
- TBD GET a list of versions
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions
- TBD GET an individual version
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions/{object_id}
- TBD POST a new version
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions --data "name=String"
- TBD PUT an update to a version
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions/{object_id} --data "name=String"
- TBD DELETE a version
DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/versions/{object_id}
- TBD GET the defined milestones
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones
- TBD GET an individual milestone
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones/{object_id}
- TBD POST a new milestone
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones --data "name=String"
- TBD PUT an update to milestones
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones/{object_id} --data "name=String"
- TBD DELETE a milestone
DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/issues/milestones/{object_id}

###links
- TBD GET list of links
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/links
- TBD GET a link
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/links/{object_id}
- TBD POST a new link
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/links --data "handler=value" --data "link_url= http://somesite.com " 
–data "link_key=value"
- TBD PUT an update to a link
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/links/{object_id} --data "link_key=value" --data "link_url= http://somesite.com "
- TBD DELETE a link
DELETE https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/links/{object_id} 

###pullrequests
- DEPRECATED GET a list of a pull request comments DEPRECATED
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments
- DEPRECATED GET an individual pull request comment DEPRECATED
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/{comment_id}
- TBD POST a new comment
POST https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments --data "content=string"
- TBD PUT an update on a comment
PUT  https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/{comment_id} --data "content=string"
- TBD DELETE a pull request comment
DELETE  https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/{comment_id}
- TBD Toggle spam flag on an existing pull request comment
PUT https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/pullrequests/{pull_request_id}/comments/spam/{comment_id} 

###repository
- DEPRECATED POST a new repository
 https://bitbucket.org/api/1.0/repositories  --data "name=mynewrepo"
- TBD POST a new fork
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/fork  --data "name=mynewrepo"
- PUT a repository update
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug} --data "description=long description"
- DEPRECATED DELETE an existing repository
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}
- GET list of branches
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/branches
- GET the repository's main branch
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/main-branch
- GET list of branches-tags
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/branches-tags
- GET the repository manifest
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/{revision}
- GET a list of the tags
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/tags
- GET the raw source
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/raw/{revision}/{path}
- GETs the history of a file in a changeset
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/filehistory/{node}/{path}

###services
- GET a list of services on a repository
GET https://api.bitbucket.org/1.0/repositories/{accountname}/{repo_slug}/services
- GET a single service attached to your repository
GET https://api.bitbucket.org/1.0/repositories/{accountname}/{repo_slug}/services/{id}
- POST a new service
POST https://api.bitbucket.org/1.0/repositories/{accountname}/{repo_slug}/services/ --data "type=value&parameter=value&..."
- PUT a change to a service
PUT https://api.bitbucket.org/1.0/repositories/{accountname}/{repo_slug}/services/{id} --data "parameter=value"  --data "parameter=value" ...
- DELETE a service
DELETE https://api.bitbucket.org/1.0/repositories/{accountname}/{repo_slug}/services/{id}

###src
- GET a list of repo source
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/src/{revision}/{path}
- GET raw content of an individual file
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/raw/{revision}/{path}

###wiki
- GET the raw content of a Wiki page
GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/wiki/{page}
- POST a new page
POST https://bitbucket.org/api/1.0/repositories/ {accountname}/{repo_slug}/wiki/{page} --data "content=string" 
- PUT a page update
PUT https://bitbucket.org/api/1.0/repositories/ accountname/repo_name/wiki/{page} --data "path={path}&data=string" --data "rev=value" 

##user
- OK GET a user profile
GET https://bitbucket.org/api/1.0/user
- TBD Update a user
PUT https://bitbucket.org/api/1.0/user --data "field=value&field=value&..." 
- TBD GET a list of user privileges
GET   https://bitbucket.org/api/1.0/user/privileges 
- TBD GET a list of repositories an account follows
GET https://bitbucket.org/api/1.0/user/follows
- !Move from Repo! GET a list of repositories visible to an account
GET https://bitbucket.org/api/1.0/user/repositories
- TBD GET a list of repositories the account is following
GET https://bitbucket.org/api/1.0/user/repositories/overview
- TBD GET the list of repositories on the dashboard
GET https://bitbucket.org/api/1.0/user/repositories/dashboard

##users

###account
- GET the account profile
GET https://bitbucket.org/api/1.0/users/{accountname} 
GET https://bitbucket.org/api/1.0/users/{emailaddress}
- GET the account plan
GET https://bitbucket.org/api/1.0/users/{accountname}/plan
- !MOVE FROM USER! GET the followers
GET https://bitbucket.org/api/1.0/users/{accountname}/followers
- GET the events
GET https://bitbucket.org/api/1.0/users/{accountname}/events

###consumers
- GET a list of an account's consumers
GET https://api.bitbucket.org/1.0/users/{accountname}/consumers
- GET a consumer
GET https://api.bitbucket.org/1.0/users/{accountname}/{id}
- PUT an updated consumer
PUT https://api.bitbucket.org/1.0/users/{accountname}/{id} -d"name={name}&description={string}&url={url}"
- DELETES a consumer
DELETE https://api.bitbucket.org/1.0/users/{accountname}/{id}

###emails
- GET a list of user's email addresses
GET https://bitbucket.org/api/1.0/users/{accountname}/emails
- GET an email address
GET https://bitbucket.org/api/1.0/users/{accountname}/emails/{email_address}
- POST a new email address
POST https://bitbucket.org/api/1.0/users/{accountname}/emails/{email_address} --data"email=value"
- Update an email address
PUT https://bitbucket.org/api/1.0/users/{accountname}/emails/{email_address} --data "primary=true"

###invitations
- GET a list of pending invitations
GET https://bitbucket.org/api/1.0/users/{accountname}
- GET pending invitations for a particular email address
GET https://bitbucket.org/api/1.0/users/{accountname}/invitations/{email_address}
- GET a pending invitation for group membership
GET https://bitbucket.org/api/1.0/users/{accountname}/invitations/{email_address}/{group_owner}/{group_slug} 
- Issue an invitation to a group.
PUT https://bitbucket.org/api/1.0/users/{accountname}/invitations/{email_address}/{group_owner}/{group_slug}
- DELETE pending invitations by email address
DELETE https://bitbucket.org/api/1.0/users/{accountname}/invitations/{email_address}
- DELETE pending invitation by group 
DELETE   https://bitbucket.org/api/1.0/users/{accountname}/invitations/{email_address}/{group_owner}/{group_slug}  

###oauth
- consumers duplicate

###privileges
- GET a list of privilege groups on a team account
GET https://bitbucket.org/api/1.0/users/{accountname}/privileges
- GET the privileges associated with a group
GET https://bitbucket.org/api/1.0/users/{accountname}/privileges/{owner}/{group_slug}
- Updates a group's privileges on a team account
PUT https://bitbucket.org/api/1.0/users/{accountname}/privileges/{owner}/{group_slug} --data "privileges=admin"
- POST a new privilege
POST https://bitbucket.org/api/1.0/users/{accountname}/privileges/{owner}/{group_slug} --data "privileges=admin"
- DELETE a privilege group
DELETE https://bitbucket.org/api/1.0/users/{accountname}/privileges/{owner}/{group_slug} 

###ssh-keys
- TBD GET /users/{accountname}/ssh-keys
GET https://bitbucket.org/api/1.0/users/{accountname}/ssh-keys
- TBD POST /users/{accountname}/ssh-keys
POST https://bitbucket.org/api/1.0/users/{accountname}/ssh-keys --data "key=value"
- TBD GET /users/{accountname}/ssh-keys/{key_id}
GET https://bitbucket.org/api/1.0/users/{accountname}/ssh-keys/{key_id}
- TBD DELETE /users/{accountname}/ssh-keys/{key_id}
DELETE https://bitbucket.org/api/1.0/users/{accountname}/ssh-keys/{key_id}

#API v2:

##repositories
- GET a list of repositories for an account
- GET a list of repositories for a team
- GET a list of all public repositories

###repository
- GET a repository
- POST a new repository
- DELETE a repository
- GET a list of watchers
- GET a list of forks

###pullrequests
- GET a list of open pull requests
- POST (create) a new pull request
- PUT a pull request update
- GET a specific pull request
- GET the commits for a pull request
- POST a pull request approval
- DELETE a pull request approval
- GET the diff for a pull request
- GET the log of all of a repository's pull request activity
- GET the activity for a pull request
- Accept and merge a pull request
- Decline or reject a pull request
- GET a list of a pull request comments
- GET an individual pull request comment 

###commits
- GET a commits list for a repository or compare commits across branches
- GET an individual commit
- GET a list of commit comments
- GET an individual commit comment
- POST a commit approval
- DELETE a commit approval

###branch-restrictions
- GET the branch-restrictions
- POST the branch-restrictions
- GET a specific restriction
- PUT a branch restriction update
- DELETE the branch restriction

###diff
- GET a diff
- GET a patch

###webhooks
- GET a webhook
- GET a list of webhooks
- POST a webhook
- PUT a webhook update
- DELETE the webhook

##teams
- GET a list of teams
- GET the team profile
- GET the team members
- GET the list of followers
- GET a list of accounts the team is following
- GET the team's repositories

##users
- GET the user profile
- GET the list of followers
- GET a list of accounts the user is following
- GET the user's repositories

##snippets

snippetsResource

-     POST a new snippet
-     POST Multipart considerations
-         multipart/related (RFC-2387)
-         multipart form
-     PUT an update to a snippet
-         application/json
-         multipart/related
-         multipart/form-data
-     DELETE a snippet
-     GET a specific snippet
-     GET a list of snippets for a user or a team
-     GET all snippets

commentsResource

-     POST a comment to a snippet
-     GET comments for a specific snippet
-     GET a specific snippet comment
-     DELETE a comment

watchResource

-     PUT start watching a snippet
-     DELETE stop watching a snippet
-     GET current watch status
-     GET a list of users watching a snippet

commitsResource

-     GET a list of commits for a snippet
-     GET a specific snippet commit

filesResource

-     GET a specific file in a snippet



##user
- GET a user profile
- GET email for a user
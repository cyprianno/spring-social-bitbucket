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
package org.springframework.social.bitbucket.api;

/**
 * The /users endpoints gets information related to an individual or team account.
 * Aggregates users operations
 * https://confluence.atlassian.com/display/BITBUCKET/users+Endpoint+-+1.0
 *
 * @author Cyprian Śniegota
 * @since 2.0.0
 */
public interface UsersOperations {

    /**
     * Account management API
     *
     * @return users account template
     */
    UsersAccountOperations usersAccountOperations();

    /**
     * Consumers management API
     *
     * @return users consumers template
     */
    UsersConsumersOperations usersConsumersOperations();

    /**
     * Invitations management API
     *
     * @return users initations template
     */
    UsersInvitationsOperations usersInvitationsOperations();

    /**
     * Privileges management API
     *
     * @return users privileges template
     */
    UsersPrivilegesOperations usersPrivilegesOperations();

    /**
     * Ssh keys management API
     *
     * @return users ssh keys template
     */
    UsersSshKeysOperations usersSshKeysOperations();

    /**
     * Emails managemet API
     *
     * @return emails management API template
     */
    UsersEmailsOperations usersEmailsOperations();
}

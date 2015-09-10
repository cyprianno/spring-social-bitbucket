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
 * The wiki resource provides functionality for getting information from pages in a Bitbucket wiki, creating new pages, and updating them.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/wiki+Resources"
 * @since 2.0.0
 */
public interface RepositoriesWikiOperations {

    /**
     * Gets the contents of a wiki page and the current revision. You must supply the title of a page to get.
     * When getting a page, do not include the extension .wiki. If you do not supply a page value, the default is the Home page.
     * Bitbucket surmises the mark up used in the Wiki based on the page extensions.
     * The file type may not always be correct in cases where there is no extension; these types appear as markdown.
     * API call: GET https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/wiki/{page}
     *
     * @param accountName The team or individual account.
     * @param repoSlug The repository identifier.
     * @param page The page name.
     * @return The content of the page.
     */
    BitBucketWikipage getContent(String accountName, String repoSlug, String page);

    /**
     * Creates a new wiki page.
     * API call: POST https://bitbucket.org/api/1.0/repositories/ {accountname}/{repo_slug}/wiki/{page} --data "content=string"
     *
     * @param accountName The team or individual account.
     * @param repoSlug The repository identifier.
     * @param page The page name.
     * @param content The page content.
     * @return True if ok.
     */
    boolean postNewPage(String accountName, String repoSlug, String page, String content);

    /**
     * Updates an existng wiki page.
     * API call: PUT https://bitbucket.org/api/1.0/repositories/ accountname/repo_name/wiki/{page} --data "path={path}&data=string" --data "rev=value"
     *
     * @param accountName The repository identifier.
     * @param repoSlug The repository identifier.
     * @param page The page name.
     * @param content The page content.
     * @return True if ok.
     */
    boolean updatePage(String accountName, String repoSlug, String page, String content);
}

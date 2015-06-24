package org.springframework.social.bitbucket.api;

import java.util.List;

/**
 * You can use the Bitbucket src resource to browse directories and view files. This is a read-only resource.
 *
 * @author Cyprian Śniegota
 * @see "https://confluence.atlassian.com/display/BITBUCKET/src+Resources"
 * @since 2.0.0
 */
public interface RepositoriesSrcOperations {
    List<String> getElements(String accountName, String repoSlug);

    String getContent(String accountName, String repoSlug, String path);
}
/*###src
- GET a list of repo source
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/src/{revision}/{path}
- GET raw content of an individual file
https://bitbucket.org/api/1.0/repositories/{accountname}/{repo_slug}/raw/{revision}/{path}*/
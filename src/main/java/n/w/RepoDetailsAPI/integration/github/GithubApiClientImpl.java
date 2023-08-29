
package n.w.RepoDetailsAPI.integration.github;

import n.w.RepoDetailsAPI.exception.UserNotFoundException;
import n.w.RepoDetailsAPI.integration.github.response.BranchInfo;
import n.w.RepoDetailsAPI.integration.github.response.RepoInfo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
class GithubApiClientImpl implements GithubApiClient {

    private static final String GITHUB_API_URL = "https://api.github.com";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<String> getUserRepositories(String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        try {
            ResponseEntity<RepoInfo[]> response = restTemplate.getForEntity(
                    GITHUB_API_URL + "/users/" + username + "/repos", RepoInfo[].class);

            return Arrays.stream(Objects.requireNonNull(response.getBody()))
                    .filter(repo -> !repo.isFork())
                    .map(RepoInfo::getName)
                    .collect(Collectors.toList());
        } catch (HttpClientErrorException.NotFound notFoundException) {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<BranchInfo> getBranchesInfo(String username, String repoName) {
        ResponseEntity<BranchInfo[]> response = restTemplate.getForEntity(
                GITHUB_API_URL + "/repos/" + username + "/" + repoName + "/branches", BranchInfo[].class);

        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }
}
package n.w.RepoDetailsAPI.integration.github;

import n.w.RepoDetailsAPI.integration.github.response.BranchInfo;

import java.util.List;

public interface GithubApiClient {

    List<String> getUserRepositories(String username);

    List<BranchInfo> getBranchesInfo(String username, String repoName);
}

package n.w.RepoDetailsAPI.service.impl;

import n.w.RepoDetailsAPI.integration.github.GithubApiClient;
import n.w.RepoDetailsAPI.model.UserRepoDetails;
import n.w.RepoDetailsAPI.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GithubServiceImpl implements GithubService {

    private final GithubApiClient githubClient;

    @Autowired
    public GithubServiceImpl(GithubApiClient githubClient) {
        this.githubClient = githubClient;
    }

    @Override
    public List<UserRepoDetails> getUserReposDetails(String username) {

        List<String> userRepos = githubClient.getUserRepositories(username);

        List<UserRepoDetails> result = new ArrayList<>();

        for (String repo: userRepos) {
            UserRepoDetails repoDetails = new UserRepoDetails(repo, username, githubClient.getBranchesInfo(username, repo));
            result.add(repoDetails);
        }

        return result;
    }
}
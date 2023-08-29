package n.w.RepoDetailsAPI.service;

import n.w.RepoDetailsAPI.model.UserRepoDetails;

import java.util.List;

public interface GithubService {

    List<UserRepoDetails> getUserReposDetails(String username);
}

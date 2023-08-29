package n.w.RepoDetailsAPI.controller;

import n.w.RepoDetailsAPI.exception.UserNotFoundException;
import n.w.RepoDetailsAPI.model.ErrorResponse;
import n.w.RepoDetailsAPI.model.UserRepoDetails;
import n.w.RepoDetailsAPI.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class GithubController {

    private final GithubService githubService;

    @Autowired
    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<UserRepoDetails>> getUserReposDetails(@PathVariable String username) {
        List<UserRepoDetails> userRepos = githubService.getUserReposDetails(username);
        return ResponseEntity.ok(userRepos);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, "User with given id not found.");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
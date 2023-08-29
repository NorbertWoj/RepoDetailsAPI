package n.w.RepoDetailsAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import n.w.RepoDetailsAPI.integration.github.response.BranchInfo;

import java.util.List;

@Data
@AllArgsConstructor
public class UserRepoDetails {

    private String name;
    private String ownerLogin;
    private List<BranchInfo> branches;

}

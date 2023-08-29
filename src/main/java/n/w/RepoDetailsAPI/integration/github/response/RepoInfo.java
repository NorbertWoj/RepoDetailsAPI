package n.w.RepoDetailsAPI.integration.github.response;

import lombok.Data;

@Data
public class RepoInfo {

    private String name;

    private boolean fork;
}

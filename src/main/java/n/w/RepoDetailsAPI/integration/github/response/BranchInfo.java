package n.w.RepoDetailsAPI.integration.github.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class BranchInfo {

    private String name;

    private String sha;

    @JsonProperty("commit")
    private void unwrapSha(Map<String, Object> commit) {
        this.sha = (String) commit.get("sha");
    }

}

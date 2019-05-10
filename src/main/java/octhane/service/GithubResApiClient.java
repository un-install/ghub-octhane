package octhane.service;

import octhane.entity.Comment;
import octhane.entity.Commit;

import java.util.List;

public interface GithubResApiClient {
    List<Commit> getCommits(String sincePeriod, String repo);

    List<Comment> getComments(String sincePeriod, String repo);

    List<Commit> getCommitsForPerson(String sincePeriod, String repo, String author);
}

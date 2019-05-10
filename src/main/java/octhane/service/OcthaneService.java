package octhane.service;

import octhane.entity.Commit;
import octhane.entity.GithubUser;

import java.util.List;
import java.util.Map;

public interface OcthaneService {
    Map<GithubUser, Long> getActRateSortedUsers(String sincePeriod, String repo);

    Map<String, Integer> getWordsStatistic(String sincePeriod, String repo);

    Map<Integer, List<Commit>> getCommitmentStatisticMap(String sincePeriod, String repo, String author);
}

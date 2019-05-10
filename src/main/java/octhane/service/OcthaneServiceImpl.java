package octhane.service;

import octhane.entity.Commit;
import octhane.entity.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

@Service
public class OcthaneServiceImpl implements OcthaneService {
    @Autowired
    private GithubResApiClient client;

    @Override
    public Map<GithubUser, Long> getActRateSortedUsers(String sincePeriod, String repo) {
        Map<GithubUser, Long> mapComits = client.getCommits(sincePeriod, repo).stream().map(com -> com.getAuthor())
                .filter(u -> u != null).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return mapComits.entrySet().stream().sorted(comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey,
                Map.Entry::getValue, (oldV, newV) -> newV, LinkedHashMap::new));
    }


    @Override
    public Map<String, Integer> getWordsStatistic(String sincePeriod, String repo) {
        List<String> words = client.getComments(sincePeriod, repo).stream().map(c -> c.getBody().toLowerCase()
                .replaceAll("[^a-zA-Z ]", "").split(" ")).flatMap(s -> Arrays.stream(s))
                .filter(w -> !w.isEmpty()).collect(Collectors.toList());

        return words.stream().collect(Collectors.toMap(w -> w, v -> new Integer(1), (old, neW) -> old + 1))
                .entrySet().stream().sorted(comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldV, newV) -> newV, LinkedHashMap::new));
    }

    @Override
    public Map<Integer, List<Commit>> getCommitmentStatisticMap(String sincePeriod, String repo, String author) {
        List<Commit> personalCommits = client.getCommitsForPerson(sincePeriod, repo, author);
        return personalCommits.stream().collect(Collectors.groupingBy(c -> c.getDate().getMonth()));
    }
}

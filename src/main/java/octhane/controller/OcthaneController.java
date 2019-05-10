package octhane.controller;

import octhane.entity.Commit;
import octhane.entity.GithubUser;
import octhane.service.OcthaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class OcthaneController {
    @Autowired
    private OcthaneService octhaneService;

    @GetMapping("/collaborators")
    public @ResponseBody
    Map<GithubUser, Long> getCommits(@RequestParam String sincePeriod,
                                     @RequestParam String repo) throws ParseException {
        return octhaneService.getActRateSortedUsers(sincePeriod, repo);
    }

    @GetMapping("/comments-stats")
    public @ResponseBody Map<String, Integer> getCommentsStatistic(@RequestParam String sincePeriod,
                                                                   @RequestParam String repo) throws ParseException {
        return octhaneService.getWordsStatistic(sincePeriod, repo);
    }

    @GetMapping("/{author}/commits")
    public@ResponseBody Map<Integer, List<Commit>> getPersonalCommitmentMap(@RequestParam String sincePeriod,
                                                                            @RequestParam String repo, @PathVariable("author") String author){
        return octhaneService.getCommitmentStatisticMap(sincePeriod, repo, author);
    }


}

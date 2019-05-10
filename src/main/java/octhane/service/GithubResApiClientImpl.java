package octhane.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import octhane.entity.Comment;
import octhane.entity.Commit;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class GithubResApiClientImpl implements GithubResApiClient {
    private static final String HTTPS_API_GITHUB_COM_REPOS = "https://api.github.com/repos";
//TODO: replace Type param main goal it doesn't need
    private  <T> List<T> getData(String url, Type listType) {
        List<T> typo = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        Gson googleJson = new Gson();
        String commitsJson;
        int page = 1;
        do {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("page", page);
            commitsJson = restTemplate.
                    getForObject(uriComponentsBuilder.toUriString(), String.class);
            typo.addAll(googleJson.fromJson(commitsJson, listType));
            page++;
        } while (!commitsJson.isEmpty() && page < 5);

        return typo;
    }

    @Override
    public List<Commit> getCommits(String sincePeriod, String repo) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(HTTPS_API_GITHUB_COM_REPOS)
                .path("/" + repo)
                .path("/commits")
                .queryParam("since", sincePeriod);
        return getData(uriComponentsBuilder.toUriString(), new TypeToken<ArrayList<Commit>>() {
        }.getType());
    }

    @Override
    public List<Comment> getComments(String sincePeriod, String repo) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(HTTPS_API_GITHUB_COM_REPOS)
                .path("/" + repo)
                .path("/comments")
                .queryParam("since", sincePeriod);
        return getData(uriComponentsBuilder.toUriString(), new TypeToken<ArrayList<Comment>>() {
        }.getType());
    }

    @Override
    public List<Commit> getCommitsForPerson(String sincePeriod, String repo, String author) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(HTTPS_API_GITHUB_COM_REPOS)
                .path("/" + repo)
                .path("/commits")
                .queryParam("since", sincePeriod)
                .queryParam("author", author);
        return getData(uriComponentsBuilder.toUriString(), new TypeToken<ArrayList<Commit>>() {
        }.getType());
    }
}

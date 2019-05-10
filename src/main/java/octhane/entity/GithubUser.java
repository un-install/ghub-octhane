package octhane.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class GithubUser implements Serializable {
    private String login;
    private String url;
    private BigDecimal id;

    public GithubUser(String login, String url, BigDecimal id) {
        this.login = login;
        this.url = url;
        this.id = id;
    }

    public GithubUser() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GithubUser)) return false;
        GithubUser that = (GithubUser) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(url, that.url) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, url, id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GithubUser{");
        sb.append("login='").append(login).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}

package octhane.entity;

import java.io.Serializable;
import java.util.Date;

public class Commit implements Serializable {
    private String sha;
    private GithubUser author;
    private CommitSubEntity commit;

    public Commit() {
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public GithubUser getAuthor() {
        return author;
    }

    public void setAuthor(GithubUser author) {
        this.author = author;
    }

    public CommitSubEntity getCommit() {
        return commit;
    }

    public void setCommit(CommitSubEntity commit) {
        this.commit = commit;
    }

    public Date getDate(){
        return this.commit.getCommitter().getDate();
    }
}

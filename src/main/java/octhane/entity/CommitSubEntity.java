package octhane.entity;

import java.io.Serializable;

public class CommitSubEntity implements Serializable {
    private Commiter committer;
    private String message;

    public CommitSubEntity() {
    }

    public Commiter getCommitter() {
        return committer;
    }

    public void setCommitter(Commiter committer) {
        this.committer = committer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

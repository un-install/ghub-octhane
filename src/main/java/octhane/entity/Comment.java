package octhane.entity;

import java.io.Serializable;
import java.util.Objects;

public class Comment implements Serializable {
    private String body;
    private Long id;

    public Comment() {
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comment{");
        sb.append("body='").append(body).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return Objects.equals(body, comment.body) &&
                Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, id);
    }
}

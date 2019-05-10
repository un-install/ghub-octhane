package octhane.entity;

import java.io.Serializable;
import java.util.Date;

public class Commiter implements Serializable {
    String name;
    Date date;

    public Commiter() {
    }

    public Commiter(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

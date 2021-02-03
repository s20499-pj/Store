package pl.pjatk.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Localization {
    @Id
    @GeneratedValue
    private int id;
    private String place;
    private boolean isEmpty;

    public Localization() {
    }

    public Localization(String place) {
        this.place = place;
        this.isEmpty = true;
    }

    public Localization(int id, String place) {
        this.id = id;
        this.place = place;
        this.isEmpty = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}

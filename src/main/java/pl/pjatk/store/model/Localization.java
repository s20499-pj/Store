package pl.pjatk.store.model;

public class Localization {
    int id;
    int place;
    boolean isEmpty;

    public Localization(int id, int place, boolean isEmpty) {
        this.id = id;
        this.place = place;
        this.isEmpty = isEmpty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}

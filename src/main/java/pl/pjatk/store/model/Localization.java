package pl.pjatk.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Localization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    private Long palletId;
    private boolean isEmpty;

    public Localization() {
    }

    public Localization(String place) {
        this.place = place;
        this.isEmpty = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getPalletId() {
        return palletId;
    }

    public void setPalletId(Long palletId) {
        this.palletId = palletId;
    }
}

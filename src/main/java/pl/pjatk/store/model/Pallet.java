package pl.pjatk.store.model;

import javax.persistence.*;

@Entity
public class Pallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    public Pallet() {
    }

    public Pallet(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

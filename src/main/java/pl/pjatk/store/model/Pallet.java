package pl.pjatk.store.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToMany
    private Set<Article> articles;

    public Pallet(int id) {
        this.id = id;
    }

    public Pallet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

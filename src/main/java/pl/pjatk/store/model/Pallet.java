package pl.pjatk.store.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToMany
    private Set<Article> articles;

    public Pallet(Long id) {
        this.id = id;
    }

    public Pallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

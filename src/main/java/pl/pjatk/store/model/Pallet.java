package pl.pjatk.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Pallet {

    @Id
    @GeneratedValue
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

    /*public List<Article> getList() {
        return list;
    }

    public void setList(List<Article> list) {
        this.list = list;
    }*/
}

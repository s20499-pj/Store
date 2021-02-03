package pl.pjatk.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pallet {

    @Id
    @GeneratedValue
    int id;
    //ArrayList list = new ArrayList();

    public Pallet(int id) {
        this.id = id;
        //this.list = list;
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

package pl.pjatk.store.model;

import java.util.ArrayList;
import java.util.List;

public class Pallet {
    int id;
    List<Article> list = new ArrayList();

    public Pallet(int id, List<Article> list) {
        this.id = id;
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Article> getList() {
        return list;
    }

    public void setList(List<Article> list) {
        this.list = list;
    }
}

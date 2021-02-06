package pl.pjatk.store.model;

import javax.persistence.*;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float weight;
    private int price;
    private int onPallet;

    public Article(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.onPallet = 0;
    }

    public Article() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOnPallet() {
        return onPallet;
    }

    public int setOnPallet(int idPallet) {
        this.onPallet = idPallet;
        return idPallet;
    }
}

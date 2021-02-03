package pl.pjatk.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private float weight;
    private int price;
    private int volume;

    public Article() {
    }

    public Article(String name, int weight, int price, int volume) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Article(int id, String name, int weight, int price, int volume) {
        this.name = name;
        this.id = id;
        this.weight = weight;
        this.price = price;
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


    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

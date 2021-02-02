package pl.pjatk.store.model;

public class Article {
    private String name;
    private int id;
    private int weight;
    private int price;

    public Article(String name, int number, int weight, int price) {
        this.name = name;
        this.id = number;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return id;
    }

    public void setNumber(int number) {
        this.id = number;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

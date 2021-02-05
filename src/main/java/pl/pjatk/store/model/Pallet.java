package pl.pjatk.store.model;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Entity
public class Pallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToMany
    private final Set<Article> articles;

    public Pallet() {
        this.articles = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void addArticle(Article article){
        articles.add(article);
    }

    public void removeArticle(Article article){
        articles.remove(article);
    }
}

package pl.pjatk.store.service;

import org.springframework.stereotype.Service;
import pl.pjatk.store.model.Article;
import pl.pjatk.store.repository.ArticleRepository;

import java.util.List;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    Article article = new Article("nożyczki", 1, 10, 300);
    Article article1 = new Article("patelnia", 3, 30, 100);
    Article article2 = new Article("kubek", 2, 20,2500);

    public Article save(Article player){
        return articleRepository.save(player);
    }
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

}

package pl.pjatk.store.service;

import org.springframework.stereotype.Service;
import pl.pjatk.store.exception.ArticleException;
import pl.pjatk.store.model.Article;
import pl.pjatk.store.repository.ArticleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Optional<Article> findById(int id) throws ArticleException {
        if (articleRepository.findById(id).isPresent()) {
            return articleRepository.findById(id);
        } else throw new ArticleException(id);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article addNew(Article player) {
        return articleRepository.save(player);
    }

    public void deleteByID(int id) {
        articleRepository.deleteById(id);
    }

    public Optional<Article> updateById(int id, String name, int price, int weight) {
        Optional<Article> updateArticle = articleRepository.findById(id);
        updateArticle.get().setName(name);
        updateArticle.get().setPrice(price);
        updateArticle.get().setWeight(weight);
        return updateArticle;
    }

    public List<Article> updateByName(String uniqueName, String name, int price, int weight) {
        List<Article> listOfAll = articleRepository.findAll();
        List<Article> updateArticles = new ArrayList<>();
        for (Article article : listOfAll) {
            if (article.getName().equals(uniqueName)) {
                article.setName(name);
                article.setPrice(price);
                article.setWeight(weight);
                updateArticles.add(article);
            }
        }
        return updateArticles;
    }
}

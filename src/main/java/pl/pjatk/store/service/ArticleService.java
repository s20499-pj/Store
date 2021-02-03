package pl.pjatk.store.service;

import org.springframework.stereotype.Service;
import pl.pjatk.store.model.Article;
import pl.pjatk.store.repository.ArticleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
        this.articleRepository.save(new Article("nożyczki", 1, 10));
        this.articleRepository.save(new Article("patelnia", 3, 30));
        this.articleRepository.save(new Article("kubek", 2, 20));
    }

    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }


    public Article addNew(Article player){
        return articleRepository.save(player);
    }

    public void deleteByID(Long id){
        articleRepository.deleteById(id);
    }


}

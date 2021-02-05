package pl.pjatk.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.store.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> { }

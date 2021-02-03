package pl.pjatk.store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.store.model.Article;
import pl.pjatk.store.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<List<Article>> findAll(){
        return ResponseEntity.ok(articleService.findAll());
    }

}

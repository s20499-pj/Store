package pl.pjatk.store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.store.exception.ArticleException;
import pl.pjatk.store.model.Article;
import pl.pjatk.store.service.ArticleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<List<Article>> findAll(){
        return ResponseEntity.ok(articleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Article>> findById(@PathVariable int id) throws ArticleException {
        Optional<Article> byId = articleService.findById(id);
        if (byId.isPresent()) return ResponseEntity.ok(byId);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Article> save(@RequestBody Article article) throws ArticleException {
        return ResponseEntity.ok(articleService.addNew(article));
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws ArticleException {
        articleService.deleteByID(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/pallet")
    public ResponseEntity<Integer> getOnPallet(@PathVariable int id) throws ArticleException {
        return ResponseEntity.ok(articleService.getOnPallet(id));
    }

    @PostMapping("/{idArticle}/pallet")
    public ResponseEntity setOnPallet(@PathVariable int idArticle, @RequestBody int idPallet) throws ArticleException{
        return ResponseEntity.ok(articleService.setOnPallet(idArticle, idPallet));
    }

    @DeleteMapping("/{idArticle}/pallet")
    public ResponseEntity<Void> takeFromPallet(@PathVariable int idArticle, @RequestBody int idPallet) throws ArticleException{
        articleService.takeFromPallet(idArticle, idPallet);
        return ResponseEntity.ok().build();
    }



}

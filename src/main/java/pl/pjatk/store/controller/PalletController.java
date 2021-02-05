package pl.pjatk.store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.store.exception.PalletException;
import pl.pjatk.store.model.Article;
import pl.pjatk.store.model.Pallet;
import pl.pjatk.store.service.PalletService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/pallet")
public class PalletController {
    private final PalletService palletService;
    private int idPallet;
    private int idArticle;

    public PalletController(PalletService palletService) {
        this.palletService = palletService;
    }

    @GetMapping
    public ResponseEntity<List<Pallet>> findAll(){
        return ResponseEntity.ok(palletService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pallet>> findById(@PathVariable int id){
        Optional<Pallet> byId = palletService.findById(id);
        if (byId.isPresent()) return ResponseEntity.ok(byId);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pallet> save(@RequestBody Pallet pallet){
        return ResponseEntity.ok(palletService.addNew(pallet));
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        palletService.deleteByID(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idPallet}/articles")
    public ResponseEntity<Set<Article>> getAll(@PathVariable int idPallet){
        return ResponseEntity.ok(palletService.findAllArticlesInId(idPallet));
    }

    @GetMapping("/{idPallet}/add/{idArticle}")
    public ResponseEntity.BodyBuilder addArtical(@PathVariable int idPallet, @PathVariable int idArticle) throws PalletException {
        palletService.addArticleToPallet(idArticle, idPallet);
        return ResponseEntity.ok();
    }

    @DeleteMapping("/{idPallet}/del/{idArticle}")
    public ResponseEntity<Void> removeArticleFromPallet(@PathVariable int idPallet,@PathVariable int idArticle) throws PalletException {
        palletService.removeArticleFromPallet(idArticle, idPallet);
        return ResponseEntity.ok().build();
    }


}

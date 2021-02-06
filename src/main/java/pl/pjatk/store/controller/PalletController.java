package pl.pjatk.store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.store.exception.PalletException;
import pl.pjatk.store.model.Pallet;
import pl.pjatk.store.service.PalletService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pallet")
public class PalletController {
    private final PalletService palletService;

    public PalletController(PalletService palletService) {
        this.palletService = palletService;
    }

    @GetMapping
    public ResponseEntity<List<Pallet>> findAll(){
        return ResponseEntity.ok(palletService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pallet>> findById(@PathVariable int id) throws PalletException {
        Optional<Pallet> byId = palletService.findById(id);
        if (byId.isPresent()) return ResponseEntity.ok(byId);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pallet> save(@RequestBody Pallet pallet){
        return ResponseEntity.ok(palletService.addNew(pallet));
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws PalletException {
        palletService.deleteByID(id);
        return ResponseEntity.ok().build();
    }
}

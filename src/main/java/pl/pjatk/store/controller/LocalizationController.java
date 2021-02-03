package pl.pjatk.store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.store.model.Localization;
import pl.pjatk.store.model.Pallet;
import pl.pjatk.store.service.LocalizationService;
import pl.pjatk.store.service.PalletService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/localization")
public class LocalizationController {

    public LocalizationService localizationService;
    public PalletService palletService;

    public LocalizationController(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @GetMapping
    public ResponseEntity<List<Localization>> findAll() {
        return ResponseEntity.ok(localizationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Localization>> findById(@PathVariable int id) {
        Optional<Localization> byId = localizationService.findById((long) id);
        if (byId.isPresent()) return ResponseEntity.ok(byId);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/empty")
    public ResponseEntity<List<Localization>> findAllEmpty() {
        return ResponseEntity.ok(localizationService.findAllEmpty());
    }

    @PostMapping
    public ResponseEntity<Localization> add(@RequestBody Localization localization) {
        boolean done = localizationService.add(localization);
        if (done) return ResponseEntity.ok(localization);
        else return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        localizationService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Optional<Localization>> rename(@PathVariable int id, @RequestBody String txt) {
        Optional<Localization> place = localizationService.findById((long) id);
        if (place.isPresent()) {
            place.get().setPlace(txt);
            return ResponseEntity.ok(place);
        } else return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{idLocalization}/{idPallet}")
    public ResponseEntity<Void> putPallete(@PathVariable int idLocalization, int idPallet) {
        Optional<Localization> place = localizationService.findById((long) idLocalization);
        Optional<Localization> pallete = localizationService.findById((long) idPallet);
        if (place.isPresent() && pallete.isPresent()) {
            place.get().setPalletId(pallete.get().getId());
            return ResponseEntity.ok().build();
        } else return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{idLocalization}/take")
    public ResponseEntity<Optional<Pallet>> takePallete(@PathVariable int idLocalization){
        Optional<Localization> place = localizationService.findById((long) idLocalization);
        if (place.isPresent() && !place.get().isEmpty()){
            int idPallete = localizationService.takePallete((long) idLocalization);
            Optional<Pallet> pallete = palletService.findById((int) idPallete);
            return ResponseEntity.ok(pallete);
        }else return ResponseEntity.badRequest().build();

    }
}

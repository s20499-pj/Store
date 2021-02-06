package pl.pjatk.store.service;

import org.springframework.stereotype.Service;;

import pl.pjatk.store.exception.PalletException;
import pl.pjatk.store.model.Pallet;
import pl.pjatk.store.repository.ArticleRepository;
import pl.pjatk.store.repository.PalletRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PalletService {

    private final PalletRepository palletRepository;

    public PalletService(PalletRepository palletRepository, ArticleRepository articleRepository) {
        this.palletRepository = palletRepository;
    }

    public Optional<Pallet> findById(int id) throws PalletException {
        if (palletRepository.findById(id).isPresent()) {
            return palletRepository.findById(id);
        } else throw new PalletException("Paleta nie istnieje");
    }

    public List<Pallet> findAll() {
        return palletRepository.findAll();
    }

    public Pallet addNew(Pallet pallet) {
        return palletRepository.save(pallet);
    }

    public void deleteByID(int id) throws PalletException {
        if (palletRepository.findById(id).isPresent()) {
            palletRepository.deleteById(id);
        } else throw new PalletException("Zły numer palety");
    }
}

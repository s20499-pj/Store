package pl.pjatk.store.service;

import org.springframework.stereotype.Service;
import pl.pjatk.store.model.Pallet;
import pl.pjatk.store.repository.PalletRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PalletService {

    private PalletRepository palletRepository;

    public PalletService(PalletRepository palletRepository) {
        this.palletRepository = palletRepository;
        this.palletRepository.save(new Pallet());
        this.palletRepository.save(new Pallet());
        this.palletRepository.save(new Pallet());
    }


    public Optional<Pallet> findById(Long id) {
        return palletRepository.findById(id);
    }

    public List<Pallet> findAll() {
        return palletRepository.findAll();
    }


    public Pallet addNew(Pallet pallet){
        return palletRepository.save(pallet);
    }

    public void deleteByID(Long id){
        palletRepository.deleteById(id);
    }
}

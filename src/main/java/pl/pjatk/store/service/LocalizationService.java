package pl.pjatk.store.service;

import org.springframework.stereotype.Service;
import pl.pjatk.store.model.Localization;
import pl.pjatk.store.repository.LocalizationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocalizationService {

    private final LocalizationRepository localizationRepository;

    public LocalizationService(LocalizationRepository localizationRepository) {
        this.localizationRepository = localizationRepository;
        this.localizationRepository.save(new Localization("r1 m1"));
        this.localizationRepository.save(new Localization("r1 m2"));
        this.localizationRepository.save(new Localization("r2 m1"));
        this.localizationRepository.save(new Localization("r2 m2"));
        this.localizationRepository.save(new Localization("r3 m1"));
        this.localizationRepository.save(new Localization("r3 m2"));
    }

    public Optional<Localization> findById(Long id) {
        return localizationRepository.findById(id);
    }

    public List<Localization> findAll() {
        return localizationRepository.findAll();
    }

    public List<Localization> findAllEmpty() {
        List<Localization> listOfEmpty = new ArrayList<>();
        for (Localization value : findAll()) {
            if (value.isEmpty()) {
                listOfEmpty.add(value);
                break;
            }
        }
        return listOfEmpty;
    }

    public boolean add(Localization localization) {
        List<Localization> list = findAll();
        boolean placeExist = false;
        for (Localization value : list) {
            if (value.getPlace().equals(localization.getPlace())) {
                placeExist = true;
                break;
            }
        }
        if (!placeExist) {
            localizationRepository.save(localization);
            return true;
        }
        else return false;
    }

    public void deleteById(Long id) {
        Optional<Localization> local = findById(id);
        if (local.isEmpty()) {
            localizationRepository.deleteById(id);
        }
    }

    public void renamePlace(Long id, String txt) {
        localizationRepository.findById(id).get().setPlace(txt);
    }

    public List<Localization> showEmpty() {
        List<Localization> listAll = findAll();
        List<Localization> listEmpty = new ArrayList<>();

        for (int i = 0; i < listAll.size(); i++) {
            if (listAll.get(i).isEmpty()) listEmpty.add(listAll.get(i));
        }
        return listEmpty;
    }

    public void putPalette(Long idPallet, Long idLocalization) {
        Localization local = localizationRepository.findById(idLocalization).get();
        if (local.isEmpty()) {
            local.setPalletId(idPallet);
            local.setEmpty(false);

        }
    }

    public int takePallete(Long idLocalization) {
        Localization local = localizationRepository.findById(idLocalization).get();
        int pallete = Math.toIntExact(local.getPalletId());
        local.setPalletId(0L);
        local.setEmpty(true);
        return pallete;
    }
}

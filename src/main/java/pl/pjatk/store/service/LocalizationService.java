package pl.pjatk.store.service;

import org.springframework.stereotype.Service;
import pl.pjatk.store.model.Localization;
import pl.pjatk.store.repository.LocalizationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocalizationService {

    private final LocalizationRepository localizationRepository;

    public LocalizationService(LocalizationRepository localizationRepository) {
        this.localizationRepository = localizationRepository;
    }

    public Optional<Localization> findById(Long id) {
        return localizationRepository.findById(id);
    }

    public List<Localization> findAll() {
        return localizationRepository.findAll();
    }

    public void add(Localization localization) {
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
        }
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
}

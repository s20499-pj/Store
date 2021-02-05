package pl.pjatk.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.store.model.Localization;

@Repository
public interface LocalizationRepository extends JpaRepository<Localization, Integer> { }
package pl.pjatk.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.store.model.Pallet;

@Repository
public interface PalletRepository extends JpaRepository<Pallet, Integer> { }

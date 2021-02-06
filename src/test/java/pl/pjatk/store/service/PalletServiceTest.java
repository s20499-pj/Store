package pl.pjatk.store.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.store.exception.PalletException;
import pl.pjatk.store.model.Pallet;
import pl.pjatk.store.repository.PalletRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PalletServiceTest {

    @Mock
    private PalletRepository palletRepository;
    Pallet pallet = new Pallet();
    Pallet pallet1 = new Pallet();
    List<Pallet> list = new ArrayList<>();

    @InjectMocks
    private PalletService palletService;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all test do nothing");
    }

    @BeforeEach
    public void beforeEach() {
        pallet = new Pallet();
        pallet1 = new Pallet();
        list = new ArrayList<>();
    }

    @AfterEach
    public void afterEach() {
    }

    @Test
    public void shouldFindById() throws PalletException {
        //Given
        when(palletRepository.findById(pallet.getId())).thenReturn(Optional.ofNullable(pallet));
        //When
        Optional<Pallet> test = palletService.findById(pallet.getId());
        //Then
        assertThat(test).isNotEmpty();
    }

    @Test
    public void shouldFindAll() {
        //Given
        list.add(pallet);
        list.add(pallet1);
        when(palletRepository.findAll()).thenReturn(list);
        //When
        List<Pallet> test = palletService.findAll();
        //Then
        assertThat(test).isEqualTo(list);
    }

    @Test
    public void shouldAddNew() {
        //Given
        when(palletRepository.save(pallet)).thenReturn(pallet);
        //When
        Pallet test = palletService.addNew(pallet);
        //Then
        assertThat(test).isEqualTo(pallet);
    }

    @Test
    public void shouldDeleteById() throws PalletException {
        //Given
        //When
        palletService.deleteByID(pallet.getId());
        //Then
        verify(palletRepository, times(1)).deleteById(pallet.getId());
    }

}

package com.monks.pokemon.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.monks.pokemon.model.BattleResult;
import com.monks.pokemon.repository.BattleResultRepository;
import com.monks.pokemon.repository.PokemonRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BattleServiceTest {

    @Mock
    private BattleResultRepository battleResultRepository;

    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private BattleService battleService;

    @Test
    void testGetBattleResultById() {
        // Prepare
        int id = 1;
        BattleResult battleResult = BattleResult.builder().id(id).build();
        when(battleResultRepository.getBattleResultById(id)).thenReturn(Optional.of(battleResult));

        // Execute
        Optional<BattleResult> result = battleService.getBattleResultById(id);

        // Verify
        assertEquals(Optional.of(battleResult), result);
        verify(battleResultRepository, times(1)).getBattleResultById(id);
    }

    @Test
    void testGetAllBattleResults() {
        // Prepare
        List<BattleResult> battleResults = new ArrayList<>();
        when(battleResultRepository.getBattleResults()).thenReturn(battleResults);

        // Execute
        List<BattleResult> result = battleService.getAllBattleResults();

        // Verify
        assertEquals(battleResults, result);
        verify(battleResultRepository, times(1)).getBattleResults();
    }

    @Test
    void testAddBattleResult() {
        // Prepare
        BattleResult battleResult = new BattleResult();
        when(battleResultRepository.addBattleResult(battleResult)).thenReturn(battleResult);

        // Execute
        BattleResult result = battleService.addBattleResult(battleResult);

        // Verify
        assertEquals(battleResult, result);
        verify(battleResultRepository, times(1)).addBattleResult(battleResult);
    }

    @Test
    void testUpdateBattleResult() {
        // Prepare
        int id = 1;
        BattleResult battleResult = BattleResult.builder().id(id).build();
        when(battleResultRepository.updateBattleResult(id, battleResult)).thenReturn(battleResult);

        // Execute
        BattleResult result = battleService.updateBattleResult(id, battleResult);

        // Verify
        assertEquals(battleResult, result);
        verify(battleResultRepository, times(1)).updateBattleResult(id, battleResult);
    }

    @Test
    void testRemoveBattleResult() {
        // Prepare
        int id = 1;
        when(battleResultRepository.removeBattleResult(id)).thenReturn(true);

        // Execute
        boolean result = battleService.removeBattleResult(id);

        // Verify
        assertTrue(result);
        verify(battleResultRepository, times(1)).removeBattleResult(id);
    }
}

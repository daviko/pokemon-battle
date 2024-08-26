package com.monks.pokemon.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.monks.pokemon.model.BattleRequest;
import com.monks.pokemon.model.BattleResult;
import com.monks.pokemon.service.BattleService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class BattleControllerTest {

    @Mock
    private BattleService battleService;

    @InjectMocks
    private BattleController battleController;

    @Test
    void testGetAllBattleResults() {
        // Prepare
        List<BattleResult> battleResults = new ArrayList<>();
        when(battleService.getAllBattleResults()).thenReturn(battleResults);

        // Execute
        ResponseEntity<List<BattleResult>> response = battleController.getAllBattleResults();

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(battleResults, response.getBody());
        verify(battleService, times(1)).getAllBattleResults();
    }

    @Test
    void testGetBattleResultById() {
        // Prepare
        int id = 1;
        BattleResult battleResult = new BattleResult();
        when(battleService.getBattleResultById(id)).thenReturn(Optional.of(battleResult));

        // Execute
        ResponseEntity<BattleResult> response = battleController.getBattleResultById(id);

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(battleResult, response.getBody());
        verify(battleService, times(1)).getBattleResultById(id);
    }

    @Test
    void testGetBattleResultById_NotFound() {
        // Prepare
        int id = 1;
        when(battleService.getBattleResultById(id)).thenReturn(Optional.empty());

        // Execute
        ResponseEntity<BattleResult> response = battleController.getBattleResultById(id);

        // Verify
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(battleService, times(1)).getBattleResultById(id);
    }

    @Test
    void testAddBattleResult() {
        // Prepare
        BattleResult battleResult = new BattleResult();
        when(battleService.addBattleResult(battleResult)).thenReturn(battleResult);

        // Execute
        ResponseEntity<BattleResult> response = battleController.addBattleResult(battleResult);

        // Verify
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(battleResult, response.getBody());
        verify(battleService, times(1)).addBattleResult(battleResult);
    }

    @Test
    void testAddBattleResult_InternalServerError() {
        // Prepare
        BattleResult battleResult = new BattleResult();
        when(battleService.addBattleResult(battleResult)).thenReturn(null);

        // Execute
        ResponseEntity<BattleResult> response = battleController.addBattleResult(battleResult);

        // Verify
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        verify(battleService, times(1)).addBattleResult(battleResult);
    }

    @Test
    void testUpdateBattleResult() {
        // Prepare
        int id = 1;
        BattleResult battleResult = new BattleResult();
        when(battleService.updateBattleResult(id, battleResult)).thenReturn(battleResult);

        // Execute
        ResponseEntity<BattleResult> response = battleController.updateBattleResult(id, battleResult);

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(battleResult, response.getBody());
        verify(battleService, times(1)).updateBattleResult(id, battleResult);
    }

    @Test
    void testUpdateBattleResult_NotFound() {
        // Prepare
        int id = 1;
        BattleResult battleResult = new BattleResult();
        when(battleService.updateBattleResult(id, battleResult)).thenReturn(null);

        // Execute
        ResponseEntity<BattleResult> response = battleController.updateBattleResult(id, battleResult);

        // Verify
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(battleService, times(1)).updateBattleResult(id, battleResult);
    }

    @Test
    void testRemoveBattleResult() {
        // Prepare
        int id = 1;
        when(battleService.removeBattleResult(id)).thenReturn(true);

        // Execute
        ResponseEntity<Void> response = battleController.removeBattleResult(id);

        // Verify
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(battleService, times(1)).removeBattleResult(id);
    }

    @Test
    void testRemoveBattleResult_NotFound() {
        // Prepare
        int id = 1;
        when(battleService.removeBattleResult(id)).thenReturn(false);

        // Execute
        ResponseEntity<Void> response = battleController.removeBattleResult(id);

        // Verify
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(battleService, times(1)).removeBattleResult(id);
    }

    @Test
    void testStartBattle() {
        // Prepare
        BattleRequest battleRequest = new BattleRequest();
        BattleResult battleResult = new BattleResult();
        when(battleService.prepareBattle(battleRequest)).thenReturn(battleResult);

        // Execute
        ResponseEntity<BattleResult> response = battleController.startBattle(battleRequest);

        // Verify
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(battleResult, response.getBody());
        verify(battleService, times(1)).prepareBattle(battleRequest);
    }

    @Test
    void testStartBattle_InternalServerError() {
        // Prepare
        BattleRequest battleRequest = new BattleRequest();
        when(battleService.prepareBattle(battleRequest)).thenReturn(null);

        // Execute
        ResponseEntity<BattleResult> response = battleController.startBattle(battleRequest);

        // Verify
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        verify(battleService, times(1)).prepareBattle(battleRequest);
    }
}

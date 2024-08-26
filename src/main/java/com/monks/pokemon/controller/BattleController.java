package com.monks.pokemon.controller;

import com.monks.pokemon.model.BattleRequest;
import com.monks.pokemon.model.BattleResult;
import com.monks.pokemon.service.BattleService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pokemon/battles")
public class BattleController {

    private final BattleService battleService;

    @Autowired
    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @GetMapping("/results")
    public ResponseEntity<List<BattleResult>> getAllBattleResults() {
        return ResponseEntity.ok(battleService.getAllBattleResults());
    }

    @GetMapping("/results/{id}")
    public ResponseEntity<BattleResult> getBattleResultById(@PathVariable("id") Integer id) {
        Optional<BattleResult> battleResult = battleService.getBattleResultById(id);
        return battleResult.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/results")
    public ResponseEntity<BattleResult> addBattleResult(@RequestBody @Valid BattleResult battleResult) {
        BattleResult battleResultCreated = battleService.addBattleResult(battleResult);

        return battleResultCreated == null ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            : ResponseEntity.status(HttpStatus.CREATED).body(battleResultCreated);
    }

    @PutMapping("/results/{id}")
    public ResponseEntity<BattleResult> updateBattleResult(@PathVariable("id") Integer id,
                                                           @RequestBody @Valid BattleResult battleResult) {
        BattleResult battleResultUpdated = battleService.updateBattleResult(id, battleResult);

        return battleResultUpdated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(battleResultUpdated);
    }

    @DeleteMapping("/results/{id}")
    public ResponseEntity<Void> removeBattleResult(@PathVariable("id") Integer id) {
        boolean wasRemoved = battleService.removeBattleResult(id);
        return wasRemoved ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/start-battle")
    public ResponseEntity<BattleResult> startBattle(@RequestBody @Valid BattleRequest battleRequest) {
        BattleResult battleResultCreated = battleService.prepareBattle(battleRequest);

        return battleResultCreated == null ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            : ResponseEntity.status(HttpStatus.CREATED).body(battleResultCreated);
    }
}

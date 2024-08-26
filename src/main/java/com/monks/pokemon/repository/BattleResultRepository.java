package com.monks.pokemon.repository;

import com.monks.pokemon.model.BattleResult;
import com.monks.pokemon.repository.util.BattleResultRepositoryUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Getter
@Repository
public class BattleResultRepository {

    private final BattleResultRepositoryUtil repositoryUtil;
    private List<BattleResult> battleResults;

    @Autowired
    public BattleResultRepository(BattleResultRepositoryUtil repositoryUtil) {
        this.repositoryUtil = repositoryUtil;
        battleResults = new ArrayList<>(this.repositoryUtil.createBattleResults());
    }

    public Optional<BattleResult> getBattleResultById(Integer id) {
        return battleResults.stream()
            .filter(battleResult -> battleResult.getId().equals(id))
            .findFirst();
    }

    public BattleResult addBattleResult(BattleResult battleResult) {
        if (battleResult.getId() == null) {
            battleResult.setId(getNextId());
            battleResults.add(battleResult);

            return battleResult;
        }
        return updateBattleResult(battleResult.getId(), battleResult);
    }

    public BattleResult updateBattleResult(Integer id, BattleResult battleResult) {
        if (existsInList(id)) {
            int index = findIndexInListById(id);
            battleResults.set(index, battleResult);
            return battleResult;
        }
        return null;
    }

    public boolean removeBattleResult(Integer id) {
        return battleResults.removeIf(battleResult -> battleResult.getId().equals(id));
    }

    private boolean existsInList(Integer id) {
        return battleResults.stream().anyMatch(battleResult -> battleResult.getId().equals(id));
    }

    private int findIndexInListById(int targetId) {
        return IntStream.range(0, battleResults.size())
            .filter(i -> battleResults.get(i).getId() == targetId)
            .findFirst()
            .orElse(-1);
    }

    private Integer getNextId() {
        return battleResults.stream()
            .mapToInt(BattleResult::getId)
            .max()
            .orElse(0) + 1;
    }
}

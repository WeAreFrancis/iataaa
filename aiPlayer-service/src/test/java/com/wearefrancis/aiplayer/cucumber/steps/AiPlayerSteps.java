package com.wearefrancis.aiplayer.cucumber.steps;

import com.wearefrancis.aiplayer.AiPlayerApplication;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import com.wearefrancis.aiplayer.domain.AiPlayer;
import com.wearefrancis.aiplayer.domain.util.Difficulty;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(classes = AiPlayerApplication.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class AiPlayerSteps extends AbstractSteps {

    @Given("^there are these aiPlayers data in database:$")
    public void thereAreTheseAiPlayersDataInDatabase(DataTable aiPlayers) throws Throwable {
        List<Map<String, String>> maps = aiPlayers.asMaps(String.class, String.class);
        maps.forEach(map -> {
            String id = map.get("id");
            Difficulty difficulty = Difficulty.valueOf(map.get("difficulty"));
            String name = map.get("name");
            String token = map.get("token");
            String ip = map.get("ip");
            int port = Integer.valueOf(map.get("port"));
            String path = map.get("path");

            persistAiPlayer(id, difficulty, name, token, ip, port, path);
        });
    }

    @Given("^the aiPlayers data database is:$")
    public void theAiPlayersDatabaseIs(DataTable aiPlayers) throws Throwable {
        List<Map<String, String>> maps = aiPlayers.asMaps(String.class, String.class);

        boolean isCorrectAiPlayerTableSize = aiPlayerTableSizeIs(maps.size());
        assertTrue(isCorrectAiPlayerTableSize);
        aiPlayerTableIsCorrect(maps);
    }

    // PRIVATE
    private void persistAiPlayer(
            String id, Difficulty difficulty, String name, String token, String ip, int port, String path
    ) {
        AiPlayer aiPlayer = new AiPlayer();
        aiPlayer.setId(id);
        aiPlayer.setDifficulty(difficulty);
        aiPlayer.setName(name);
        aiPlayer.setToken(token);
        aiPlayer.setIp(ip);
        aiPlayer.setPort(port);
        aiPlayer.setPath(path);

        entityManager.persist(aiPlayer);
    }

    private boolean aiPlayerTableSizeIs(long size) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(AiPlayer.class)));
        long sizeAiPlayerTable = entityManager.createQuery(cq).getSingleResult();
        return sizeAiPlayerTable == size;
    }

    private void aiPlayerTableIsCorrect(List<Map<String, String>> maps) {
        maps.forEach(map -> {
            String id = map.get("id");
            Difficulty difficulty = Difficulty.valueOf(map.get("difficulty"));
            String name = map.get("name");
            String token = map.get("token");
            String ip = map.get("ip");
            int port = Integer.valueOf(map.get("port"));
            String path = map.get("path");

            if (id == null)
                aiPlayerIsInDatabase(difficulty, name, token, ip, port, path);
            else
                aiPlayerIsInDatabase(id, difficulty, name, token, ip, port, path);
        });
    }

    private void aiPlayerIsInDatabase(
            Difficulty difficulty, String name, String token, String ip, int port, String path
    ) {
        AiPlayer aiPlayer = entityManager.createQuery(
                "SELECT l FROM AiPlayer l WHERE " +
                        "l.difficulty = :difficulty " +
                        "AND l.name = :name " +
                        "AND l.token = :token " +
                        "AND l.ip = :ip " +
                        "AND l.port = :port " +
                        "AND l.path = :path "
                , AiPlayer.class)

                .setParameter("difficulty", difficulty)
                .setParameter("name", name)
                .setParameter("token", token)
                .setParameter("ip", ip)
                .setParameter("port", port)
                .setParameter("path", path)
                .getSingleResult();
        assertThat(aiPlayer).isNotNull();
    }

    private void aiPlayerIsInDatabase(
            String id, Difficulty difficulty, String name, String token, String ip, int port, String path
    ) {
        AiPlayer aiPlayer = entityManager.createQuery(
                "SELECT l FROM AiPlayer l WHERE " +
                        "l.id = :id " +
                        "AND l.difficulty = :difficulty " +
                        "AND l.name = :name " +
                        "AND l.token = :token " +
                        "AND l.ip = :ip " +
                        "AND l.port = :port " +
                        "AND l.path = :path "
                , AiPlayer.class)
                .setParameter("id", id)
                .setParameter("difficulty", difficulty)
                .setParameter("name", name)
                .setParameter("token", token)
                .setParameter("ip", ip)
                .setParameter("port", port)
                .setParameter("path", path)
                .getSingleResult();
        assertThat(aiPlayer).isNotNull();
    }
}
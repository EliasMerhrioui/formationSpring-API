package com.postgresql.formationSpring.service;



import com.postgresql.formationSpring.dto.PlayerDTO;
import com.postgresql.formationSpring.model.Player;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.postgresql.formationSpring.repository.PlayerRepository;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Player createPlayer(PlayerDTO playerDTO) {
        Player player = new Player(null, playerDTO.getName(), playerDTO.getEmail(), playerDTO.getJerseyNumber(), playerDTO.getPosition(), playerDTO.getTeam());
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, PlayerDTO playerDTO) {
        Player existingPlayer = getPlayerById(id);
        existingPlayer.setName(playerDTO.getName());
        existingPlayer.setEmail(playerDTO.getEmail());
        existingPlayer.setJerseyNumber(playerDTO.getJerseyNumber());
        existingPlayer.setPosition(playerDTO.getPosition());
        existingPlayer.setTeam(playerDTO.getTeam());
        return playerRepository.save(existingPlayer);
    }

    public void deletePlayer(Long id) {
        Player player = getPlayerById(id);
        playerRepository.delete(player);
    }
}

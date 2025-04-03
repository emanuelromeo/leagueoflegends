package com.develhope.leagueoflegends;

import com.develhope.leagueoflegends.entity.Ability;
import com.develhope.leagueoflegends.entity.Champion;
import com.develhope.leagueoflegends.enumeration.ChampionRole;
import com.develhope.leagueoflegends.service.AbilityService;
import com.develhope.leagueoflegends.service.ChampionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ChampionTest {

    private Champion champion;

    @MockitoBean
    private ChampionService championService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        champion = new Champion();

        champion.setId(1L);
        champion.setName("Rollo");
        champion.setRole(ChampionRole.ASSASSIN);
        champion.setDifficulty(8);
        champion.setRegion("Sath");
        champion.setReleaseDate(LocalDate.now());
        champion.setHealth(100L);
        champion.setMana(10L);
        champion.setBaseDamage(20L);
    }

    // Test POST request to create a champion
    @Test
    public void create() throws Exception {
        when(championService.saveChampion(any(Champion.class))).thenReturn(champion);

        mockMvc.perform(post("/champions/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(champion)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(champion.getName()));
    }

    // Test POST request to create multiple champions
    @Test
    public void createMultiple() throws Exception {
        when(championService.saveMultipleChampions(anyList())).thenReturn(List.of(champion));

        mockMvc.perform(post("/champions/create-multiple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(List.of(champion))))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Test GET request to find all champions
    @Test
    public void findAll() throws Exception {
        when(championService.findAllChampions()).thenReturn(Collections.singletonList(champion));

        mockMvc.perform(get("/champions/find-all"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    // Test GET request to find a champion by id
    @Test
    public void findById() throws Exception {
        when(championService.findChampionById(anyLong())).thenReturn(Optional.of(champion));

        mockMvc.perform(get("/champions/find-by-id/" + champion.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(champion.getName()));
    }

    // Test GET request when champion not found by id
    @Test
    public void notFoundById() throws Exception {
        when(championService.findChampionById(anyLong())).thenReturn(Optional.empty());

        mockMvc.perform(get("/champions/find-by-id/" + champion.getId()))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    // Test PUT request to update a champion by id
    @Test
    public void update() throws Exception {
        when(championService.updateChampion(anyLong(), any(Champion.class))).thenReturn(Optional.of(champion));

        mockMvc.perform(put("/champions/update/" + champion.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(champion)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(champion.getName()));
    }

    // Test PUT request when champion to update not found by id
    @Test
    public void notFoundToUpdate() throws Exception {
        when(championService.updateChampion(anyLong(), any(Champion.class))).thenReturn(Optional.empty());

        mockMvc.perform(put("/champions/update/" + champion.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(champion)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    // Test DELETE request to delete a champion by id
    @Test
    public void deleteById() throws Exception {
        when(championService.deleteById(anyLong())).thenReturn("Champion Deleted");

        mockMvc.perform(delete("/champions/delete-by-id/" + champion.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Champion Deleted"));
    }

    // Test GET request to find champions by role
    @Test
    public void findByRole() throws Exception {
        when(championService.findByRole(any(ChampionRole.class))).thenReturn(List.of(champion));

        mockMvc.perform(get("/champions/find-by-role")
                        .param("role", "ASSASSIN"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Test GET request to find champions by region
    @Test
    public void findByRegion() throws Exception {
        when(championService.findByRole(any(ChampionRole.class))).thenReturn(List.of(champion));

        mockMvc.perform(get("/champions/find-by-region")
                        .param("region", "Sath"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Test GET request to find champions by difficulty
    @Test
    public void findByDifficulty() throws Exception {
        when(championService.findByRole(any(ChampionRole.class))).thenReturn(List.of(champion));

        mockMvc.perform(get("/champions/find-by-difficulty")
                        .param("difficulty", "8"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Test GET request to find champions by release date
    @Test
    public void findByReleaseDate() throws Exception {
        when(championService.findByRole(any(ChampionRole.class))).thenReturn(List.of(champion));

        mockMvc.perform(get("/champions/find-by-release-date")
                        .param("releaseDate", String.valueOf(LocalDate.now())))
                .andDo(print())
                .andExpect(status().isOk());
    }
}

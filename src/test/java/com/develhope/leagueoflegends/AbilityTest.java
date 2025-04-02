package com.develhope.leagueoflegends;

import com.develhope.leagueoflegends.entity.Ability;
import com.develhope.leagueoflegends.service.AbilityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AbilityTest {

    private Ability ability;

    @MockitoBean
    private AbilityService abilityService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        ability = new Ability();
        ability.setId(1L);
        ability.setName("Palla di fuoco");
        ability.setDamage(100L);
        ability.setManaRequired(50L);
    }

    @Test
    public void testCreateAbility() throws Exception {
        when(abilityService.createAbility(any(Ability.class))).thenReturn(ability);

        mockMvc.perform(post("/abilities/create-ability")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ability)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(ability.getName()));
    }

    @Test
    public void testFindAll() throws Exception {
        when(abilityService.findAllAbilities()).thenReturn(Collections.singletonList(ability));

        mockMvc.perform(get("/abilities/find-all"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void testFindById() throws Exception {
        when(abilityService.findAbilityById(anyLong())).thenReturn(Optional.of(ability));

        mockMvc.perform(get("/abilities/find-by-id/" + ability.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(ability.getName()));
    }

    @Test
    public void testUpdate() throws Exception {
        when(abilityService.updateAbility(anyLong(), any(Ability.class))).thenReturn(Optional.of(ability));

        mockMvc.perform(put("/abilities/update/" + ability.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ability)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(ability.getName()));
    }

    @Test
    public void testDelete() throws Exception {
        when(abilityService.deleteAbility(anyLong())).thenReturn("Ability Deleted");

        mockMvc.perform(delete("/abilities/delete-ability/" + ability.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Ability Deleted"));
    }
}

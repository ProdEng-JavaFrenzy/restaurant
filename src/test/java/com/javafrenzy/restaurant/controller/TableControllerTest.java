package com.javafrenzy.restaurant.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javafrenzy.restaurant.dto.TableRequestDto;
import com.javafrenzy.restaurant.model.Table;
import com.javafrenzy.restaurant.service.TableService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TableControllerTest {

    @Mock
    private TableService tableService;

    @InjectMocks
    private TableController tableController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(tableController).build();
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @Test
    void test_getAllTables_returnsAllTables() throws Exception {
        // Arrange
        List<Table> mockTables = List.of(new Table((short) 1, (short) 0), new Table((short) 2, (short) 1));
        when(tableService.getAllTables()).thenReturn(mockTables);

        // Act
        MvcResult result = mockMvc.perform(get("/tables"))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(mockTables));
    }

    @Test
    void test_addTable_savesAndReturnsTheNewTable() throws Exception {
        // Arrange
        TableRequestDto tableDto = new TableRequestDto((short) 1, (short) 2);
        Table table = new Table(tableDto.getCapacity(), tableDto.getFloor());
        when(tableService.addTable(any())).thenReturn(table);

        // Act
        MvcResult result = mockMvc.perform(post("/tables")
                .content(objectMapper.writeValueAsString(tableDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(table));
    }

    @Test
    void test_updateTableAndTableExists_updatesTheTable() throws Exception {
        // Arrange
        String tableId = "mockId";
        TableRequestDto tableDto = new TableRequestDto((short) 1, (short) 2);
        Table table = new Table((short) 3, (short) 4);
        when(tableService.updateTable(anyString(), any())).thenReturn(table);

        // Act
        MvcResult result = mockMvc.perform(put(String.format("/tables/%s", tableId))
                .content(objectMapper.writeValueAsString(tableDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(table));
    }

    @Test
    void test_deleteTableAndTableExists_deletesTheTable() throws Exception {
        // Arrange
        String tableId = "mockId";
        doNothing().when(tableService).deleteTable(tableId);

        // Act
        mockMvc.perform(delete(String.format("/tables/%s", tableId)))
                .andExpect(status().isOk())
                .andReturn();
    }
}

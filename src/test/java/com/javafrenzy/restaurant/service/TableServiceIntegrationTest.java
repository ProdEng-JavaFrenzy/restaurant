package com.javafrenzy.restaurant.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import com.javafrenzy.restaurant.dto.TableRequestDto;
import com.javafrenzy.restaurant.exception.TableNotFoundException;
import com.javafrenzy.restaurant.model.Table;
import com.javafrenzy.restaurant.repository.TableRepository;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class TableServiceIntegrationTest {
    @MockBean
    TableRepository mockTableRepository;

    @Autowired
    TableService tableService;

    @Test
    void test_getAllTables_returnsAllTables() {
        // Arrange
        List<Table> mockTables = List.of(new Table((short) 1, (short) 0), new Table((short) 2, (short) 1));

        when(mockTableRepository.findAll()).thenReturn(mockTables);

        // Act
        List<Table> tables = tableService.getAllTables();

        // Assert
        assertIterableEquals(mockTables, tables);
    }

    @Test
    void test_addTable_savesAndReturnsTheNewTable() {
        // Arrange
        TableRequestDto mockTableDto = new TableRequestDto((short) 1, (short) 0);
        Table mockTable = new Table(mockTableDto.getCapacity(), mockTableDto.getFloor());

        when(mockTableRepository.save(any())).thenReturn(mockTable);

        // Act
        Table table = tableService.addTable(mockTableDto);

        // Assert
        assertEquals(mockTable.getCapacity(), table.getCapacity());
        assertEquals(mockTable.getFloor(), table.getFloor());

        ArgumentCaptor<Table> tableArg = ArgumentCaptor.forClass(Table.class);
        verify(mockTableRepository, times(1)).save(tableArg.capture());
        assertEquals(mockTable.getCapacity(), tableArg.getValue().getCapacity());
        assertEquals(mockTable.getFloor(), tableArg.getValue().getFloor());
    }

    @Test
    void test_deleteTableAndTableExists_deletesTheTable() {
        // Arrange
        String tableId = "mockid";

        when(mockTableRepository.findById(tableId)).thenReturn(Optional.of(new Table((short) 1, (short) 2)));

        // Act
        tableService.deleteTable(tableId);

        // Assert
        verify(mockTableRepository, times(1)).findById(tableId);
        verify(mockTableRepository, times(1)).delete(any());
    }

    @Test
    void test_deleteTableAndTableDoesNotExist_throws() {
        // Arrange
        String tableId = "mockid";

        when(mockTableRepository.findById(tableId)).thenReturn(Optional.empty());

        // Act
        TableNotFoundException ex = assertThrows(TableNotFoundException.class, () -> tableService.deleteTable(tableId));

        // Assert
        verify(mockTableRepository, times(1)).findById(tableId);
        assertEquals(String.format("Table %s does not exist.", tableId), ex.getMessage());
    }

    @Test
    void test_updateTableAndTableExists_updatesTheTable() {
        // Arrange
        String tableId = "mockid";
        Table mockTable = new Table((short) 1, (short) 2);
        TableRequestDto mockTableDto = new TableRequestDto((short) 3, (short) 4);

        when(mockTableRepository.findById(tableId)).thenReturn(Optional.of(mockTable));
        when(mockTableRepository.save(mockTable)).thenReturn(mockTable);

        // Act
        Table updatedTable = tableService.updateTable(tableId, mockTableDto);

        // Assert
        assertEquals(mockTableDto.getCapacity(), updatedTable.getCapacity());
        assertEquals(mockTableDto.getFloor(), updatedTable.getFloor());
        verify(mockTableRepository, times(1)).findById(tableId);
        verify(mockTableRepository, times(1)).save(mockTable);
    }

    @Test
    void test_updateTableAndTableDoesNotExist_throws() {
        // Arrange
        String tableId = "mockid";
        TableRequestDto mockTableDto = new TableRequestDto((short) 1, (short) 2);

        when(mockTableRepository.findById(tableId)).thenReturn(Optional.empty());

        // Act
        TableNotFoundException ex = assertThrows(TableNotFoundException.class,
                () -> tableService.updateTable(tableId, mockTableDto));

        // Assert
        verify(mockTableRepository, times(1)).findById(tableId);
        assertEquals(String.format("Table %s does not exist.", tableId), ex.getMessage());
    }
}

package com.javafrenzy.restaurant.service;

import com.javafrenzy.restaurant.dto.TableRequestDto;
import com.javafrenzy.restaurant.exception.TableNotFoundException;
import com.javafrenzy.restaurant.model.Table;
import com.javafrenzy.restaurant.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }

    public Table addTable(TableRequestDto tableDto) {
        Table table = new Table(tableDto.getCapacity(), tableDto.getFloor());
        return tableRepository.save(table);
    }

    public void deleteTable(String id) {
        Table table = tableRepository.findById(id).orElseThrow(() -> new TableNotFoundException(id));
        tableRepository.delete(table);
    }

    public Table updateTable(String id, TableRequestDto tableDto) {
        return tableRepository.findById(id)
                .map((Table updateTable) -> {
                    updateTable.setCapacity(tableDto.getCapacity());
                    updateTable.setFloor(tableDto.getFloor());
                    return tableRepository.save(updateTable);
                })
                .orElseThrow(() -> new TableNotFoundException(id));
    }
}

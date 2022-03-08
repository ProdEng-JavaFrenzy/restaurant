package com.javafrenzy.restaurant.controller;

import java.util.List;

import com.javafrenzy.restaurant.dto.TableRequestDto;
import com.javafrenzy.restaurant.model.Table;
import com.javafrenzy.restaurant.service.TableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping("/tables")
    @ResponseBody
    public List<Table> getTables() {
        return tableService.getAllTables();
    }

    @PostMapping("/tables")
    @ResponseBody
    public Table addTable(@RequestBody TableRequestDto tableDto) {
        return tableService.addTable(tableDto);
    }

    @DeleteMapping("/tables/{id}")
    @ResponseBody
    public void deleteTable(@PathVariable String id) {
        tableService.deleteTable(id);
    }

    @PutMapping("/tables/{id}")
    @ResponseBody
    public Table updateTable(@PathVariable String id, @RequestBody TableRequestDto tableDto) {
        return tableService.updateTable(id, tableDto);
    }
}

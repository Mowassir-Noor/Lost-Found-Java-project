package com.gazi.lostFound.controller;
import com.gazi.lostFound.dto.ItemsDto;
//get  /items
//post /items
//delete /items
//update /items{id}

import ch.qos.logback.core.model.Model;
import com.gazi.lostFound.repositories.ItemsRepository;
import com.gazi.lostFound.services.ItemsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemsController {

    final private ItemsService itemsService;
    final private ItemsRepository itemsRepository;

    // creating a constructor and passing the data form Items service
    public ItemsController(ItemsService itemsService, ItemsRepository itemsRepository) {
        this.itemsService = itemsService;
        this.itemsRepository = itemsRepository;
    }


    @GetMapping(path = "/items/{id}")
    public ResponseEntity<ItemsDto> getItemsById(@PathVariable("id") Long itemsId){
        ItemsDto itemsDto = itemsService.getItemsById(itemsId);
        return ResponseEntity.ok(itemsDto);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemsDto>> getAllItems(){
        List<ItemsDto> itemsList = itemsService.getAllItems();
        return ResponseEntity.ok(itemsList);
    }


    @PostMapping(path="/items")
    public ResponseEntity<ItemsDto> addNewItem(@RequestBody ItemsDto itemsDto){
        ItemsDto createdItem = itemsService.addNewItem(itemsDto);
        return ResponseEntity.ok(createdItem);
    }


    @DeleteMapping(path = "/items/{id}")
    public ResponseEntity<Boolean> deleteItem(@PathVariable("id") Long itemsId){
        boolean result = itemsService.deleteItem(itemsId);
        return ResponseEntity.ok(result);
    }


    @PatchMapping(path="/items/{id}")
    public ResponseEntity<Boolean> updateItem(@PathVariable("id") Long itemId,@RequestBody ItemsDto itemsDto){
        boolean result = itemsService.updateItem(itemId, itemsDto);
        return ResponseEntity.ok(result);
    }



}

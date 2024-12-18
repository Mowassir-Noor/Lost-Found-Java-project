package com.gazi.lostFound.controller;


import com.gazi.lostFound.dto.ItemsDto;
import com.gazi.lostFound.dto.RegisterUserDto;
import com.gazi.lostFound.dto.UserResponseDto;
import com.gazi.lostFound.entities.ItemsEntity;
import com.gazi.lostFound.entities.UserEntity;
import com.gazi.lostFound.repositories.ItemsRepository;
import com.gazi.lostFound.repositories.UserRepository;
import com.gazi.lostFound.services.AuthService;
import com.gazi.lostFound.services.ItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// get
//post
//create
//update
//delete


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AuthService authService;
    private final ItemsService itemsService;
    private final UserRepository userRepository;
    private final ItemsRepository itemsRepository;

    public AdminController(AuthService authService, ItemsService itemsService, UserRepository userRepository, ItemsRepository itemsRepository) {
        this.authService = authService;
        this.itemsService = itemsService;
        this.userRepository = userRepository;
        this.itemsRepository = itemsRepository;
    }



    @GetMapping("/dashboard")
    public String dashboard() {
        return "Dashboard";
    }


    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(RegisterUserDto dto){
        UserResponseDto response = authService.adminRegister(dto);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/all-user")
    public ResponseEntity<?> getAllUsers(){
        List<UserEntity> allUsers =authService.getAll();
        if(!allUsers.isEmpty() && allUsers != null){
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

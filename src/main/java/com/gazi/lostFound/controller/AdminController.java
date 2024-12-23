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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

// get
//post
//create
//update
//delete

//api to add admin

@RestController
@RequestMapping("/admin")
public class AdminController implements ControllerInterface {

    private final AuthService authService;
    private final ItemsService itemsService;
//    private final UserRepository userRepository;
//    private final ItemsRepository itemsRepository;

    public AdminController(AuthService authService, ItemsService itemsService, UserRepository userRepository, ItemsRepository itemsRepository) {
        this.authService = authService;
        this.itemsService = itemsService;
//        this.userRepository = userRepository;
//        this.itemsRepository = itemsRepository;
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


//    endpoint to get item's detail by itemId
    @GetMapping(path = "/items/{id}")
    public ResponseEntity<ItemsDto> getItemsById(@PathVariable("id") Long itemsId){
        ItemsDto itemsDto = itemsService.getItemsById(itemsId);
        return ResponseEntity.ok(itemsDto);
    }

//endpoint to get the itemlist
    @GetMapping("/items")
    public ResponseEntity<List<ItemsDto>> getAllItems(){
        List<ItemsDto> itemsList = itemsService.getAllItems();
        return ResponseEntity.ok(itemsList);
    }

    //post for adding new item  with image
    @PostMapping("/items")
    public ResponseEntity<ItemsDto> addNewItem(@RequestPart("itemsDto") ItemsDto itemsDto,
                                               @RequestPart("file") MultipartFile imageFile){
        try {
            ItemsDto createdItem = itemsService.addNewItemWithImage(itemsDto,imageFile);
            return ResponseEntity.ok(createdItem);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

//    Endpoint for deleting the item
    @DeleteMapping(path = "/items/{id}")
    public ResponseEntity<Boolean> deleteItem(@PathVariable("id") Long itemsId){
        boolean result = itemsService.deleteItem(itemsId);
        return ResponseEntity.ok(result);
    }



    //   it's working, comment for image trial
//    @PostMapping(path="/items")
//    public ResponseEntity<ItemsDto> addNewItem(@RequestBody ItemsDto itemsDto) throws IOException {
//        ItemsDto createdItem = itemsService.addNewItem(itemsDto);
//        return ResponseEntity.ok(createdItem);
//    }








    @PatchMapping(path="/items/{id}")
    public ResponseEntity<Boolean> updateItem(@PathVariable("id") Long itemId,@RequestBody ItemsDto itemsDto){
        boolean result = itemsService.updateItem(itemId, itemsDto);
        return ResponseEntity.ok(result);
    }




}

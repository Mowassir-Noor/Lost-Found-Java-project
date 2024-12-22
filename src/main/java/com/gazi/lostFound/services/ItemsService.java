package com.gazi.lostFound.services;


import com.gazi.lostFound.dto.ItemsDto;
import com.gazi.lostFound.entities.ItemsEntity;
import com.gazi.lostFound.repositories.ItemsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemsService {

    //     initializing the itemsrepository and model mapper
    private final ItemsRepository itemsRepository;
    private final ModelMapper modelMapper;
    private final ResourceUrlProvider mvcResourceUrlProvider;


    //    initializing both the classes because of the final keyword
    public ItemsService(ItemsRepository itemsRepository, ModelMapper modelMapper, ResourceUrlProvider mvcResourceUrlProvider) {
        this.itemsRepository = itemsRepository;
        this.modelMapper = modelMapper;
        this.mvcResourceUrlProvider = mvcResourceUrlProvider;
    }


    public ItemsDto getItemsById(Long id) {

        ItemsEntity itemsEntity = itemsRepository.getById(id);

        // we can do this to convert the data of itemsEntity to ItemsDto or we can use model mapping
        // return new ItemsDto(itemsEntity.getItemId(),itemsEntity.getItemName(),itemsEntity.getItemDescription(),itemsEntity.getItemCategory(),itemsEntity.getItemDate(),itemsEntity.isFound());

        return modelMapper.map(itemsEntity, ItemsDto.class);
    }

    public ItemsDto addNewItem(ItemsDto itemsDto) throws IOException {
        ItemsEntity itemsEntity = modelMapper.map(itemsDto, ItemsEntity.class);

        return modelMapper.map(itemsRepository.save(itemsEntity), ItemsDto.class);
    }


    public List<ItemsDto> getAllItems() {
        return itemsRepository.findAll().stream().map(itemsEntity -> modelMapper.map(itemsEntity, ItemsDto.class)).collect(Collectors.toList());
    }

    public boolean deleteItem(Long itemsId) {

        if (itemsRepository.existsById(itemsId)) {
            itemsRepository.deleteById(itemsId);
            return true;

        } else return false;


    }

    public boolean updateItem(Long itemId, ItemsDto itemsDto) {
       if (itemsRepository.existsById(itemId)) {
            ItemsEntity existingData = itemsRepository.findById(itemId).get();
           if (itemsDto.getItemName() != null) {
               existingData.setItemName(itemsDto.getItemName());
           }
           if ((itemsDto.getItemCategory() != null)) {
               existingData.setItemCategory(itemsDto.getItemCategory());
           }
           if (itemsDto.getItemDescription()!=null) {
               existingData.setItemDescription(itemsDto.getItemDescription());
           }
           if (itemsDto.getItemDate()!=null){
               existingData.setItemDate(itemsDto.getItemDate());

           }



                existingData.setFound(itemsDto.isFound());


            itemsRepository.save(existingData);
            return true;

        }
        else{
            return false;
        }



    }
//
//    public ItemsDto addNewItemWithImage(ItemsDto itemsDto, MultipartFile imageFile) throws IOException {
//        ItemsEntity itemsEntity = modelMapper.map(itemsDto, ItemsEntity.class);
//        itemsEntity.setImageName(imageFile.getOriginalFilename());
//        itemsEntity.setImageType(imageFile.getContentType());
//        itemsEntity.setImageData(imageFile.getBytes());
//        itemsRepository.save(itemsEntity);
//        return itemsDto;
//
//    }



    public ItemsDto addNewItemWithImage(ItemsDto itemsDto, MultipartFile imageFile) throws IOException {
        // Validate file
        if (imageFile.isEmpty()) {
            throw new IllegalArgumentException("Uploaded file is empty");
        }
        if (!isValidImageType(imageFile.getContentType())) {
            throw new IllegalArgumentException("Invalid file type: " + imageFile.getContentType());
        }

        // Map DTO to Entity
        ItemsEntity itemsEntity = modelMapper.map(itemsDto, ItemsEntity.class);

        // Add image details to the entity
        itemsEntity.setImageName(imageFile.getOriginalFilename());
        itemsEntity.setImageType(imageFile.getContentType());
        itemsEntity.setImageData(imageFile.getBytes());

        // Save the entity to the database
        ItemsEntity savedEntity = itemsRepository.save(itemsEntity);

        // Map Entity back to DTO to include updated data like id
//        return modelMapper.map(savedEntity, ItemsDto.class);

//        returning itemsEntity because saved entity has image and sending an image will cost performance
//        return modelMapper.map(itemsRepository.save(savedEntity), ItemsDto.class);
        return modelMapper.map(itemsEntity, ItemsDto.class);
    }

    // Helper method to validate image types
    private boolean isValidImageType(String contentType) {
        return contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png"));
    }


    //    public boolean deleteAll() {
//        itemsRepository.deleteAll();
//        return true;
//    }
}



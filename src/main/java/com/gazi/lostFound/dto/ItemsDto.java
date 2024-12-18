package com.gazi.lostFound.dto;

import java.time.LocalDate;

public class ItemsDto {
    private Long itemId;
    private String itemName;
    private String itemDescription;
    private String itemCategory;
    private LocalDate itemDate;
    private boolean found;

//    //image relate information
    private String imageName;
    private String imageType;
    private byte[] imageData;

    // Default constructor
    public ItemsDto() {}

    // Parameterized constructor
    public ItemsDto(Long itemId, String itemName, String itemDescription, String itemCategory, LocalDate itemDate, boolean found,String imageName, String imageType, byte[] imageData) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.itemDate = itemDate;
        this.found = found;
        this.imageName = imageName;
        this.imageType = imageType;
        this.imageData = imageData;
    }

    // Getters and setters
    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getItemDescription() { return itemDescription; }
    public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }

    public String getItemCategory() { return itemCategory; }
    public void setItemCategory(String itemCategory) { this.itemCategory = itemCategory; }

    public LocalDate getItemDate() { return itemDate; }
    public void setItemDate(LocalDate itemDate) { this.itemDate = itemDate; }

    public boolean isFound() { return found; }
    public void setFound(boolean found) { this.found = found; }
//


    public String getImageName() { return imageName; }
    public void setImageName(String imageName) { this.imageName = imageName; }
    public String getImageType() { return imageType; }
    public void setImageType(String imageType) { this.imageType = imageType; }

    public byte[] getImageData() { return imageData; }
    public void setImageData(byte[] imageData) { this.imageData = imageData; }
}


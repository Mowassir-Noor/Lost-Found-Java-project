package com.gazi.lostFound.dto;

import java.time.LocalDate;

public class ItemsDto {
    private Long itemId;
    private String itemName;
    private String itemDescription;
    private String itemCategory;
    private LocalDate itemDate;
    private boolean found;

    // Default constructor
    public ItemsDto() {}

    // Parameterized constructor
    public ItemsDto(Long itemId, String itemName, String itemDescription, String itemCategory, LocalDate itemDate, boolean found) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.itemDate = itemDate;
        this.found = found;
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
}

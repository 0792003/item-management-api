package com.example.item_management_api.controller;
import com.example.item_management_api.model.Item;
import com.example.item_management_api.model.Item;
import com.example.item_management_api.model.Item;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/items")

public class ItemController {

    private List<Item> itemList = new ArrayList<>();

    // Add new item
    @PostMapping
    public Item addItem(@Valid @RequestBody Item item) {
        item.setId((long) (itemList.size() + 1));
        itemList.add(item);
        return item;
    }

    // Get item by ID
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        Optional<Item> item = itemList.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();

        return item.orElseThrow(() -> new RuntimeException("Item not found"));
    }
}
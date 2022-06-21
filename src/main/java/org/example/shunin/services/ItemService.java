package org.example.shunin.services;

import org.example.shunin.models.Item;
import org.example.shunin.models.Person;
import org.example.shunin.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }


    public List<Item> findByItemName(String itemName) {
        return itemsRepository.findByItemName(itemName);
    }


    public List<Item> findByOwner(Person owner) {
        return itemsRepository.findByOwner(owner);
    }


    public List<Item> findByItemName(String itemName, Pageable pageable) {
        pageable = PageRequest.of(0, 2);
        return itemsRepository.findByItemName(itemName, pageable);
    }


}

package jpabook.jpashop.service;

import jpabook.jpashop.controller.BookForm;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, UpdateItemDto itemDto) {
        Book findItem = (Book)itemRepository.findOne(itemId);
//        변경 하는 곳을 추척할 수 있게 끔
//        findItem.change();
        findItem.setPrice(itemDto.getPrice());
        findItem.setName(itemDto.getName());
        findItem.setStockQuantity(itemDto.getStockQuantity());
        findItem.setIsbn(itemDto.getIsbn());
        findItem.setAuthor(itemDto.getAuthor());
    }

    public List<Item> findItem() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

    @Transactional
    public void createBook(BookForm form) {
        Book book = new Book();
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());
        saveItem(book);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }
}

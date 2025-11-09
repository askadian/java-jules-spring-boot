package com.library.service;

import com.library.model.BookOrder;
import com.library.repository.BookOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookOrderServiceImpl implements BookOrderService {

    @Autowired
    private BookOrderRepository bookOrderRepository;

    @Override
    public BookOrder saveBookOrder(BookOrder bookOrder) {
        return bookOrderRepository.save(bookOrder);
    }

    @Override
    public List<BookOrder> getAllBookOrders() {
        return bookOrderRepository.findAll();
    }

    @Override
    public Optional<BookOrder> getBookOrderById(Long id) {
        return bookOrderRepository.findById(id);
    }

    @Override
    public void deleteBookOrder(Long id) {
        bookOrderRepository.deleteById(id);
    }
}

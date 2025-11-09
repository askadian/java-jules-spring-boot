package com.library.controller;

import com.library.model.BookOrder;
import com.library.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class BookOrderController {

    @Autowired
    private BookOrderService bookOrderService;

    @PostMapping
    public ResponseEntity<BookOrder> createBookOrder(@RequestBody BookOrder bookOrder) {
        BookOrder savedBookOrder = bookOrderService.saveBookOrder(bookOrder);
        return new ResponseEntity<>(savedBookOrder, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookOrder>> getAllBookOrders() {
        List<BookOrder> bookOrders = bookOrderService.getAllBookOrders();
        return new ResponseEntity<>(bookOrders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookOrder> getBookOrderById(@PathVariable Long id) {
        Optional<BookOrder> bookOrder = bookOrderService.getBookOrderById(id);
        return bookOrder.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookOrder> updateBookOrder(@PathVariable Long id, @RequestBody BookOrder bookOrderDetails) {
        Optional<BookOrder> optionalBookOrder = bookOrderService.getBookOrderById(id);
        if (optionalBookOrder.isPresent()) {
            BookOrder existingBookOrder = optionalBookOrder.get();
            if (bookOrderDetails.getBook() != null) {
                existingBookOrder.setBook(bookOrderDetails.getBook());
            }
            if (bookOrderDetails.getUser() != null) {
                existingBookOrder.setUser(bookOrderDetails.getUser());
            }
            if (bookOrderDetails.getOrderDatetime() != null) {
                existingBookOrder.setOrderDatetime(bookOrderDetails.getOrderDatetime());
            }
            if (bookOrderDetails.getFullfillmentDatetime() != null) {
                existingBookOrder.setFullfillmentDatetime(bookOrderDetails.getFullfillmentDatetime());
            }
            if (bookOrderDetails.getStatus() != null) {
                existingBookOrder.setStatus(bookOrderDetails.getStatus());
            }
            BookOrder updatedBookOrder = bookOrderService.saveBookOrder(existingBookOrder);
            return new ResponseEntity<>(updatedBookOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookOrder(@PathVariable Long id) {
        bookOrderService.deleteBookOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

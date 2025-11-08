package com.library.service;

import com.library.model.BookOrder;
import java.util.List;
import java.util.Optional;

public interface BookOrderService {
    BookOrder saveBookOrder(BookOrder bookOrder);
    List<BookOrder> getAllBookOrders();
    Optional<BookOrder> getBookOrderById(Long id);
    void deleteBookOrder(Long id);
}

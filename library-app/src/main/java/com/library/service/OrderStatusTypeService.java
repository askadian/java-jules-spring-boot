package com.library.service;

import com.library.model.OrderStatusType;
import java.util.List;
import java.util.Optional;

public interface OrderStatusTypeService {
    OrderStatusType saveOrderStatusType(OrderStatusType orderStatusType);
    List<OrderStatusType> getAllOrderStatusTypes();
    Optional<OrderStatusType> getOrderStatusTypeByName(String name);
    void deleteOrderStatusType(String name);
}

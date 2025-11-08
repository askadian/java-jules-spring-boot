package com.library.service;

import com.library.model.OrderStatusType;
import com.library.repository.OrderStatusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusTypeServiceImpl implements OrderStatusTypeService {

    @Autowired
    private OrderStatusTypeRepository orderStatusTypeRepository;

    @Override
    public OrderStatusType saveOrderStatusType(OrderStatusType orderStatusType) {
        return orderStatusTypeRepository.save(orderStatusType);
    }

    @Override
    public List<OrderStatusType> getAllOrderStatusTypes() {
        return orderStatusTypeRepository.findAll();
    }

    @Override
    public Optional<OrderStatusType> getOrderStatusTypeByName(String name) {
        return orderStatusTypeRepository.findById(name);
    }

    @Override
    public void deleteOrderStatusType(String name) {
        orderStatusTypeRepository.deleteById(name);
    }
}

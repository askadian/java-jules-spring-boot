package com.library.controller;

import com.library.model.OrderStatusType;
import com.library.service.OrderStatusTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metadata")
public class OrderStatusTypeController {

    @Autowired
    private OrderStatusTypeService orderStatusTypeService;

    @PostMapping
    public ResponseEntity<OrderStatusType> createOrderStatusType(@RequestBody OrderStatusType orderStatusType) {
        OrderStatusType savedOrderStatusType = orderStatusTypeService.saveOrderStatusType(orderStatusType);
        return new ResponseEntity<>(savedOrderStatusType, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderStatusType>> getAllOrderStatusTypes() {
        List<OrderStatusType> orderStatusTypes = orderStatusTypeService.getAllOrderStatusTypes();
        return new ResponseEntity<>(orderStatusTypes, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<OrderStatusType> getOrderStatusTypeByName(@PathVariable String name) {
        Optional<OrderStatusType> orderStatusType = orderStatusTypeService.getOrderStatusTypeByName(name);
        return orderStatusType.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping(value = "/{name}")
    public ResponseEntity<OrderStatusType> updateOrderStatusType(@PathVariable String name, @RequestBody OrderStatusType orderStatusTypeDetails) {
        Optional<OrderStatusType> optionalOrderStatusType = orderStatusTypeService.getOrderStatusTypeByName(name);
        if (optionalOrderStatusType.isPresent()) {
            OrderStatusType existingOrderStatusType = optionalOrderStatusType.get();
            if (orderStatusTypeDetails.getDescription() != null) {
                existingOrderStatusType.setDescription(orderStatusTypeDetails.getDescription());
            }
            OrderStatusType updatedOrderStatusType = orderStatusTypeService.saveOrderStatusType(existingOrderStatusType);
            return new ResponseEntity<>(updatedOrderStatusType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteOrderStatusType(@PathVariable String name) {
        orderStatusTypeService.deleteOrderStatusType(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

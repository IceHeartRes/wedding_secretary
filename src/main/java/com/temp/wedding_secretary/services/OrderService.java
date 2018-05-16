package com.temp.wedding_secretary.services;

import com.temp.wedding_secretary.dao.OrderDao;
import com.temp.wedding_secretary.models.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> getOrders(){
        return orderDao.getOrders();
    }
}

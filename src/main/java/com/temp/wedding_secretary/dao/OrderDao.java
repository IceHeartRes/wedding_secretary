package com.temp.wedding_secretary.dao;

import com.temp.wedding_secretary.models.domain.Order;

import java.util.List;

public interface OrderDao {

    /**
     * получить данные для сущности "Заявка"
     *
     * @return возвращает список сущностей с данными
     */
    List<Order> getOrders();

}

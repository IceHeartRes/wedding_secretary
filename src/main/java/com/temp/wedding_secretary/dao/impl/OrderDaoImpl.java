package com.temp.wedding_secretary.dao.impl;

import com.temp.wedding_secretary.dao.OrderDao;
import com.temp.wedding_secretary.mappers.OrderMapper;
import com.temp.wedding_secretary.models.domain.Order;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private String ordersSql;

    public OrderDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setOrders(@Value("classpath:scripts/dao/orders_select.sql") InputStream sqlStream) throws IOException {
        this.ordersSql = IOUtils.toString(sqlStream);
    }

    @Override
    public List<Order> getOrders() {
        return jdbcTemplate.query(ordersSql, new OrderMapper());
    }
}

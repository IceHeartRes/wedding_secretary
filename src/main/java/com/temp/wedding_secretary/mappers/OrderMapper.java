package com.temp.wedding_secretary.mappers;

import com.temp.wedding_secretary.constants.Columns;
import com.temp.wedding_secretary.models.dictionaries.City;
import com.temp.wedding_secretary.models.domain.Order;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Nullable
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();

        City city = new City();
        city.setCode(resultSet.getString(Columns.CODE));
        city.setName(resultSet.getString(Columns.CITY_NAME));
        city.setTimeZoneOffset(resultSet.getInt(Columns.TIME_ZONE_OFFSET));

        order.setCity(city);
        order.setEmail(resultSet.getString(Columns.EMAIL));
        order.setName(resultSet.getString(Columns.NAME));
        order.setPartition(resultSet.getString(Columns.PARTITION));
        order.setPhone(resultSet.getString(Columns.PHONE));
        return order;
    }
}

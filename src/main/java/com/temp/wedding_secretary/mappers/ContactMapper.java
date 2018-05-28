package com.temp.wedding_secretary.mappers;

import com.temp.wedding_secretary.constants.Columns;
import com.temp.wedding_secretary.models.Contact;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements RowMapper<Contact> {

    @Nullable
    @Override
    public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        Contact contact = new Contact();
        contact.setCode(resultSet.getString(Columns.CODE));
        contact.setDescription(resultSet.getString(Columns.DESCRIPTION));
        contact.setIconLink(resultSet.getString(Columns.ICON_LINK));
        contact.setType(resultSet.getString(Columns.TYPE));
        return contact;
    }
}

package com.temp.wedding_secretary.mappers;

import com.temp.wedding_secretary.constants.Columns;
import com.temp.wedding_secretary.models.domain.Specialist;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialistsMapper implements RowMapper<Specialist> {
    @Nullable
    @Override
    public Specialist mapRow(ResultSet resultSet, int i) throws SQLException {
        Specialist specialist = new Specialist();
        specialist.setDescription(resultSet.getString(Columns.DESCRIPTION));
        specialist.setName(resultSet.getString(Columns.NAME));


        return null;
    }
}

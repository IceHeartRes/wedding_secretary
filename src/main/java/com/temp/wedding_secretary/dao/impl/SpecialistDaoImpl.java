package com.temp.wedding_secretary.dao.impl;

import com.temp.wedding_secretary.dao.SpecialistDao;
import com.temp.wedding_secretary.models.domain.Specialist;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SpecialistDaoImpl implements SpecialistDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private String specialistsSql;

    public SpecialistDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setSpecialists(@Value("classpath:scripts/dao/articles_select.sql") InputStream sqlStream) throws IOException {
        this.specialistsSql = IOUtils.toString(sqlStream);
    }

    @Override
    public List<Specialist> getSpecilists() {
        List<Specialist> specialists = new ArrayList<>();

        Specialist specialist = new Specialist();
        specialist.setDescription("description");
        specialists.add(specialist);

        return specialists;
    }
}

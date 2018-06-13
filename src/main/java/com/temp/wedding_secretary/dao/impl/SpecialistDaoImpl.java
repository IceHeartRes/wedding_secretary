package com.temp.wedding_secretary.dao.impl;

import com.temp.wedding_secretary.constants.Columns;
import com.temp.wedding_secretary.dao.SpecialistDao;
import com.temp.wedding_secretary.mappers.SpecialistsMapper;
import com.temp.wedding_secretary.models.domain.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import utils.StreamToStringUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class SpecialistDaoImpl implements SpecialistDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private String specialistsSql;
    private String contactsSql;
    private String photesSql;
    private String videoLinksSql;

    public SpecialistDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setSpecialists(@Value("classpath:scripts/dao/specialists_select.sql") InputStream sqlStream) throws IOException {
        this.specialistsSql = StreamToStringUtil.toString(sqlStream);
    }

    @Autowired
    public void setContacts(@Value("classpath:scripts/dao/contacts_select.sql") InputStream sqlStream) throws IOException {
        this.contactsSql = StreamToStringUtil.toString(sqlStream);
    }

    @Autowired
    public void setPhotes(@Value("classpath:scripts/dao/photes_select.sql") InputStream sqlStream) throws IOException {
        this.photesSql = StreamToStringUtil.toString(sqlStream);
    }

    @Autowired
    public void setVideoLinks(@Value("classpath:scripts/dao/video_links_select.sql") InputStream sqlStream) throws IOException {
        this.videoLinksSql = StreamToStringUtil.toString(sqlStream);
    }

    @Override
    public List<Specialist> getSpecilists() {
        List<Specialist> specialists = jdbcTemplate.query(specialistsSql, new SpecialistsMapper());
        specialists.forEach(specialist -> {
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue(Columns.CODE, specialist.getCode());
            //TODO добавить контакты
            specialist.setPhotes(jdbcTemplate.queryForList(photesSql, mapSqlParameterSource, String.class));
            specialist.setVideoLinks(jdbcTemplate.queryForList(videoLinksSql, mapSqlParameterSource, String.class));
        });
        return specialists;
    }

    @Override
    public Boolean updateSpecilist() {
        return null;
    }
}

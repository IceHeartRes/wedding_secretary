package com.temp.wedding_secretary.dao.impl;

import com.temp.wedding_secretary.constants.Columns;
import com.temp.wedding_secretary.dao.SpecialistDao;
import com.temp.wedding_secretary.mappers.ContactMapper;
import com.temp.wedding_secretary.mappers.SpecialistsMapper;
import com.temp.wedding_secretary.models.Contact;
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
import java.util.UUID;

@Repository
public class SpecialistDaoImpl implements SpecialistDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private String specialistsSql;
    private String contactsSql;
    private String photoSql;
    private String videoLinksSql;
    private String specialistInsertSql;
    private String specialistUpdateSql;
    private String contactUpdateSql;
    private String contactInsertSql;
    private String photoUpdateSql;
    private String photoInsertSql;
    private String videoLinkUpdateSql;
    private String videoLinkInsertSql;

    @Autowired
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
    public void setPhoto(@Value("classpath:scripts/dao/photo_select.sql") InputStream sqlStream) throws IOException {
        this.photoSql = StreamToStringUtil.toString(sqlStream);
    }

    @Autowired
    public void setVideoLinks(@Value("classpath:scripts/dao/video_links_select.sql") InputStream sqlStream) throws IOException {
        this.videoLinksSql = StreamToStringUtil.toString(sqlStream);
    }

    @Autowired
    public void setSpecialistInsertSql(@Value("classpath:scripts/dao/specialist_insert.sql") InputStream sqlStream) throws IOException {
        this.specialistInsertSql = StreamToStringUtil.toString(sqlStream);
    }

    @Autowired
    public void setSpecialistUpdateSql(@Value("classpath:scripts/dao/specialist_update.sql") InputStream sqlStream) throws IOException {
        this.specialistUpdateSql = StreamToStringUtil.toString(sqlStream);
    }

    @Autowired
    public void setContactInsertSql(@Value("classpath:scripts/dao/contact_insert.sql") InputStream sqlStream) throws IOException {
        this.contactInsertSql = StreamToStringUtil.toString(sqlStream);
    }

    @Autowired
    public void setContactUpdateSql(@Value("classpath:scripts/dao/contact_update.sql") InputStream sqlStream) throws IOException {
        this.contactUpdateSql = StreamToStringUtil.toString(sqlStream);
    }

    @Autowired
    public void setPhotoInsertSqlSql(@Value("classpath:scripts/dao/photo_insert.sql") InputStream sqlStream) throws IOException {
        this.photoInsertSql = StreamToStringUtil.toString(sqlStream);
    }

    @Autowired
    public void setPhotoUpdateSqlSql(@Value("classpath:scripts/dao/photo_update.sql") InputStream sqlStream) throws IOException {
        this.photoUpdateSql = StreamToStringUtil.toString(sqlStream);
    }

    @Autowired
    public void setVideoLinkInsertSql(@Value("classpath:scripts/dao/video_link_insert.sql") InputStream sqlStream) throws IOException {
        this.videoLinkInsertSql = StreamToStringUtil.toString(sqlStream);
    }

    @Autowired
    public void setVideoLinkUpdateSql(@Value("classpath:scripts/dao/video_link_update.sql") InputStream sqlStream) throws IOException {
        this.videoLinkUpdateSql = StreamToStringUtil.toString(sqlStream);
    }

    @Override
    public List<Specialist> getSpecilists() {
        List<Specialist> specialists = jdbcTemplate.query(specialistsSql, new SpecialistsMapper());
        specialists.forEach(specialist -> {
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue(Columns.CODE, specialist.getCode());
            specialist.setContacts(jdbcTemplate.query(contactsSql, mapSqlParameterSource, new ContactMapper()));
            specialist.setPhoto(jdbcTemplate.queryForList(photoSql, mapSqlParameterSource, String.class));
            specialist.setVideoLinks(jdbcTemplate.queryForList(videoLinksSql, mapSqlParameterSource, String.class));
        });
        return specialists;
    }

    @Override
    public Boolean updateSpecialist(Specialist request) {
        String code = request.getCode();
        Boolean isUpdate = false;
        if (code != null) {
            jdbcTemplate.update(specialistUpdateSql, createMapSqlParameterSource(request, code));
            isUpdate = true;
        } else {
            code = UUID.randomUUID().toString();
            jdbcTemplate.update(specialistInsertSql, createMapSqlParameterSource(request, code));
        }
        if (request.getContacts() != null) {
            updateContacts(request.getContacts(), code, isUpdate);
        }
        if (request.getPhoto() != null) {
            updatePhoto(request.getPhoto(), code, isUpdate);
        }
        if (request.getVideoLinks() != null) {
            updateVideoLinks(request.getVideoLinks(), code, isUpdate);
        }
        return true;
    }

    private void updateContacts(List<Contact> contacts, String specialistCode, Boolean isUpdate) {
        contacts.forEach(contact -> {
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue(Columns.TYPE, contact.getType());
            mapSqlParameterSource.addValue(Columns.DESCRIPTION, contact.getDescription());
            mapSqlParameterSource.addValue(Columns.ICON_LINK, contact.getIconLink());
            mapSqlParameterSource.addValue(Columns.SPECIALIST_CODE, specialistCode);
            if (isUpdate) {
                mapSqlParameterSource.addValue(Columns.CODE, contact.getCode());
                jdbcTemplate.update(contactUpdateSql, mapSqlParameterSource);
            } else {
                mapSqlParameterSource.addValue(Columns.CODE, UUID.randomUUID().toString());
                jdbcTemplate.update(contactInsertSql, mapSqlParameterSource);
            }

        });
    }

    private void updatePhoto(List<String> photo, String code, Boolean isUpdate) {
        photo.forEach(s -> {
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue(Columns.SPECIALIST_CODE, code);
            mapSqlParameterSource.addValue(Columns.PHOTO_LINK, s);
            if (isUpdate) {
                jdbcTemplate.update(photoUpdateSql, mapSqlParameterSource);
            } else {
                jdbcTemplate.update(photoInsertSql, mapSqlParameterSource);
            }
        });
    }


    private void updateVideoLinks(List<String> videoLinks, String specialistCode, Boolean isUpdate) {
        videoLinks.forEach(s -> {
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue(Columns.SPECIALIST_CODE, specialistCode);
            mapSqlParameterSource.addValue(Columns.VIDEO_LINK, s);
            if (isUpdate) {
                jdbcTemplate.update(videoLinkUpdateSql, mapSqlParameterSource);
            } else {
                jdbcTemplate.update(videoLinkInsertSql, mapSqlParameterSource);
            }
        });
    }

    private MapSqlParameterSource createMapSqlParameterSource(Specialist request, String code) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(Columns.CODE, code);
        mapSqlParameterSource.addValue(Columns.NAME, request.getName());
        mapSqlParameterSource.addValue(Columns.DESCRIPTION, request.getDescription());
        mapSqlParameterSource.addValue(Columns.PROFESSIONAL_CATEGORY_CODE, request.getCategory().getCode());
        mapSqlParameterSource.addValue(Columns.PROFESSIONAL_CATEGORY_NAME, request.getCategory().getName());
        mapSqlParameterSource.addValue(Columns.PROFESSIONAL_CATEGORY_DESCRIPTION, request.getCategory().getDescription());
        return mapSqlParameterSource;
    }
}

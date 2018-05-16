package com.temp.wedding_secretary.dao;

import com.temp.wedding_secretary.models.domain.Specialist;

import java.util.List;

public interface SpecialistDao {

    /**
     * получить данные для сущности "Специалист"
     *
     * @return возвращает список сущностей с данными
     */
    List<Specialist> getSpecilists();
}

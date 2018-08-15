package com.temp.wedding_secretary.services;

import com.temp.wedding_secretary.dao.SpecialistDao;
import com.temp.wedding_secretary.models.domain.Specialist;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecialistService {

    private final SpecialistDao specialistDao;

    public SpecialistService(SpecialistDao specialistDao) {
        this.specialistDao = specialistDao;
    }

    public List<Specialist> getSpecialists() {
        return specialistDao.getSpecilists();
    }

    @Transactional
    public Boolean updateSpecilist(Specialist request) {
        return specialistDao.updateSpecialist(request);
    }
}

package wedding_secretary.temp.dao.impl;

import com.temp.wedding_secretary.dao.SpecialistDao;
import com.temp.wedding_secretary.mappers.ContactMapper;
import com.temp.wedding_secretary.mappers.SpecialistsMapper;
import com.temp.wedding_secretary.models.Contact;
import com.temp.wedding_secretary.models.dictionaries.ProfessionalCategory;
import com.temp.wedding_secretary.models.domain.Specialist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import wedding_secretary.temp.wedding_secretary.PropertiesConfig;
import wedding_secretary.temp.wedding_secretary.constants.Constants;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class SpecialistDaoImplTest extends PropertiesConfig.CommonContextConfigurationTest {

    @Autowired
    private SpecialistDao specialistDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Sql({"specialists_clear.sql", "specialists_insert.sql"})
    @Sql(scripts = "specialists_clear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void getSpecialistsTest() throws Exception {

        List<Specialist> specialists = specialistDao.getSpecilists();
        Specialist specialist = specialists.get(0);
        Contact contact = specialist.getContacts().get(0);

        assertNotNull(specialists);
        assertEquals(1, specialists.size());
        assertEquals(Constants.CODE, specialist.getCode());
        assertEquals(Constants.NAME, specialist.getName());
        assertEquals(Constants.DESCRIPTION, specialist.getDescription());
        assertEquals(Constants.PROFESSIONAL_CATEGORY_DESCRIPTION, specialist.getCategory().getDescription());
        assertEquals(Constants.PROFESSIONAL_CATEGORY_NAME, specialist.getCategory().getName());

        assertNotNull(contact);
        assertEquals(1, specialist.getContacts().size());
        assertEquals(Constants.CODE, contact.getCode());
        assertEquals(Constants.CONTACT_DESCRIPTION, contact.getDescription());
        assertEquals(Constants.ICON_LINK, contact.getIconLink());
        assertEquals(Constants.TYPE, contact.getType());

        assertEquals(1, specialist.getPhoto().size());
        assertEquals(Constants.PHOTO_LINK, specialist.getPhoto().get(0));

        assertEquals(1, specialist.getVideoLinks().size());
        assertEquals(Constants.VIDEO_LINK, specialist.getVideoLinks().get(0));
    }

    @Test
    @Sql({"specialists_clear.sql", "specialists_insert.sql"})
    @Sql(scripts = "specialists_clear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void updateTest() throws Exception {
        Specialist request = new Specialist();
        request.setName(Constants.NAME);
        request.setCode(Constants.CODE);
        request.setDescription(Constants.DESCRIPTION);

        ProfessionalCategory professionalCategory = new ProfessionalCategory();
        professionalCategory.setCode(Constants.CATEGORY_CODE);
        request.setCategory(professionalCategory);

        Contact contact = new Contact();
        contact.setType(Constants.TYPE);
        contact.setIconLink(Constants.ICON_LINK);
        contact.setDescription(Constants.DESCRIPTION);

        request.setContacts(Collections.singletonList(contact));
        request.setVideoLinks(Collections.singletonList(Constants.VIDEO_LINK));
        request.setPhoto(Collections.singletonList(Constants.PHOTO_LINK));

        Boolean result = specialistDao.updateSpecialist(request);

        List<Specialist> specialists = jdbcTemplate.query("SELECT\n" +
                "  s.code,\n" +
                "  s.name,\n" +
                "  s.description,\n" +
                "  s.category_code,\n" +
                "  ps.code        AS professional_category_code,\n" +
                "  ps.name        AS professional_category_name,\n" +
                "  ps.description AS professional_category_description\n" +
                "FROM specialists s\n" +
                "  JOIN professional_categories ps\n" +
                "    ON ps.code = s.category_code;\n", new SpecialistsMapper());

        List<Contact> contacts = jdbcTemplate.query("SELECT type, description, icon_link, code FROM contacts", new ContactMapper());

        String videoLink = jdbcTemplate.queryForObject(String.format("SELECT video_link FROM video_links WHERE specialist_code = '%s'", Constants.CODE), String.class);

        String photoLink = jdbcTemplate.queryForObject(String.format("SELECT photo_link FROM photo WHERE specialist_code = '%s'", Constants.CODE), String.class);

        Specialist specialist = specialists.get(0);
        Contact contactResult = contacts.get(0);

        assertNotNull(specialists);
        assertNotNull(specialist);

        assertNotNull(contacts);
        assertNotNull(contactResult);

        assertNotNull(videoLink);
        assertNotNull(photoLink);

        assertEquals(1, specialists.size());
        assertEquals(true, result);

        assertEquals(Constants.CODE, specialist.getCode());
        assertEquals(Constants.NAME, specialist.getName());
        assertEquals(Constants.DESCRIPTION, specialist.getDescription());
        assertEquals(Constants.CATEGORY_CODE, specialist.getCategory().getCode());

        assertEquals(Constants.TYPE, contact.getType());
        assertEquals(Constants.DESCRIPTION, contact.getDescription());
        assertEquals(Constants.ICON_LINK, contact.getIconLink());

        assertEquals(Constants.VIDEO_LINK, videoLink);
        assertEquals(Constants.PHOTO_LINK, photoLink);

    }

}

package wedding_secretary.temp.dao.impl;

import com.temp.wedding_secretary.dao.OrderDao;
import com.temp.wedding_secretary.models.dictionaries.City;
import com.temp.wedding_secretary.models.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import wedding_secretary.temp.wedding_secretary.PropertiesConfig;
import wedding_secretary.temp.wedding_secretary.constants.Constants;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class OrderDaoImplTest extends PropertiesConfig.CommonContextConfigurationTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    @Sql({"orders_clear.sql", "orders_insert.sql"})
    @Sql(scripts = "orders_clear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void getOrdersTest() throws Exception {

        List<Order> orders = orderDao.getOrders();
        Order order = orders.get(0);
        City city = order.getCity();

        assertNotNull(orders);
        assertEquals(1, orders.size());
        assertEquals(Constants.CODE, order.getCode());
        assertEquals(Constants.NAME, order.getName());
        assertEquals(Constants.PHONE, order.getPhone());
        assertEquals(Constants.EMAIL, order.getEmail());
        assertEquals(Constants.PARTITION, order.getPartition());

        assertNotNull(city);
        assertEquals(Constants.CODE, city.getCode());
        assertEquals(Constants.NAME, city.getName());
        assertEquals(Constants.TIME_ZONE_OFFSET, city.getTimeZoneOffset());

    }
}

package wedding_secretary.temp.wedding_secretary.configiration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean(name = "dataSource")
    @Primary
    public BasicDataSource getDataSource(@Value("${jdbc.local.url}") String url) {
        return getBasicDataSource(url, false);
    }

    private BasicDataSource getBasicDataSource(String url, boolean isReadOnly) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDefaultAutoCommit(false);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setValidationQuery("SELECT 1;");
        dataSource.setDefaultReadOnly(isReadOnly);
        return dataSource;
    }

    @Bean(name = "txManager")
    @Primary
    public DataSourceTransactionManager getTransactionManager(@Qualifier("dataSource") BasicDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "jdbcTemplateLocal")
    @Primary
    public JdbcTemplate getJdbcTemplateLocal(@Qualifier("dataSource") BasicDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Primary
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(@Qualifier("dataSource") BasicDataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
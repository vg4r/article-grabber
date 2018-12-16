package net.sf.vgrs.gamesys.config;

import net.sf.vgrs.gamesys.dao.ArticlesDao;
import net.sf.vgrs.gamesys.service.Deserializer;
import net.sf.vgrs.gamesys.service.Fetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    private ApplicationContext context;

    /**
     * User can define which db implementation (for now we have only 1 working one jdbc) to choose from property file.
     * Bean is created to be able to get qualifier names from application.property file.
     *
     * @param provider The name of bean that gets from property file
     * @return Creates new instance of bean with the provider and return
     */
    @Bean
    public ArticlesDao dbProvider(@Value("${app.provider.db}") String provider) {
        return (ArticlesDao) context.getBean(provider);
    }

    /**
     * User can define which deserialization implementation (json or xml) to choose from property file.
     * Bean is created to be able to get qualifier names from application.property file.
     *
     * @param provider The name of bean that gets from property file
     * @return Creates new instance of bean with the provider and return
     */
    @Bean
    public Deserializer deserializerProvider(@Value("${app.provider.deserializer}") String provider) {
        return (Deserializer) context.getBean(provider);
    }

    /**
     * User can define which fetching implementation (for now we have only http) to choose from property file.
     * Bean is created to be able to get qualifier names from application.property file.
     *
     * @param provider The name of bean that gets from property file
     * @return Creates new instance of bean with the provider and return
     */
    @Bean
    public Fetcher fetcherProvider(@Value("${app.provider.fetcher}") String provider) {
        return (Fetcher) context.getBean(provider);
    }
}

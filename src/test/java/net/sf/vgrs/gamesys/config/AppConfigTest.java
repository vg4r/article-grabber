package net.sf.vgrs.gamesys.config;

import net.sf.vgrs.gamesys.service.ArticlesService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;


@Configuration
public class AppConfigTest {


    @Bean
    @Primary
    @Profile("test")
    public ArticlesService articlesService() {
        return Mockito.mock(ArticlesService.class);
    }

}

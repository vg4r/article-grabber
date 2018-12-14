package net.sf.vgrs.gamesys.service;

import net.sf.vgrs.gamesys.dao.ArticlesDao;
import net.sf.vgrs.gamesys.domain.Response;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService implements ApplicationContextAware {

    private ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.appContext = applicationContext;
    }

    @Autowired
    private FetcherService service;

    @Autowired
    @Qualifier("dbProvider")
    private ArticlesDao articlesDao;


    @Scheduled(fixedDelayString="${app.scheduler.fixed-delay}")
    public void getArticles() {
        System.out.println("Started fetching...");
        try {
            Response response = service.fetch();
            articlesDao.add(response.getArticles());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

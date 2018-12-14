package net.sf.vgrs.gamesys.service;

import net.sf.vgrs.gamesys.dao.ArticlesDao;
import net.sf.vgrs.gamesys.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    @Autowired
    private FetcherService service;

    @Autowired
    @Qualifier("dao-jdbc")
    private ArticlesDao articlesDao;


    @Scheduled(fixedDelay=5000)
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

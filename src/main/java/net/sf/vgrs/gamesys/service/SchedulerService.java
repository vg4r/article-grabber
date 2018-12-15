package net.sf.vgrs.gamesys.service;

import net.sf.vgrs.gamesys.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService{

    private FetcherService service;

    private ArticlesService articlesService;

    @Autowired
    public SchedulerService(FetcherService service, ArticlesService articlesService){
        this.service = service;
        this.articlesService = articlesService;
    }

    @Scheduled(fixedDelayString = "${app.scheduler.fixed-delay}")
    public void getArticles() {
        try {
            Response response = service.fetch();

            articlesService.add(response.getArticles());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

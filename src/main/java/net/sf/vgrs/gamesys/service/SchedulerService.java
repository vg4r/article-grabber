package net.sf.vgrs.gamesys.service;

import net.sf.vgrs.gamesys.domain.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    Logger logger = LoggerFactory.getLogger(SchedulerService.class);

    private FetcherService service;

    private ArticlesService articlesService;

    @Autowired
    public SchedulerService(FetcherService service, ArticlesService articlesService) {
        this.service = service;
        this.articlesService = articlesService;
    }

    @Scheduled(fixedDelayString = "${app.scheduler.fixed-delay}")
    public void getArticles() {
        logger.trace("Scheduled call getArticles");
        try {
            Response response = service.fetch();

            logger.trace("Got " + response.getArticles().size() + " articles");
            articlesService.add(response.getArticles());
        } catch (Exception e) {
            logger.error("Exception occurred during scheduled method", e);
        }
    }
}

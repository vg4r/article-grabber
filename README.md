# article-grabber
> Program gets list of aticles from https://newsapi.org api, filter them depending author is provided or not, writes it to the h2 in memory database

> ### Build and run 
```
git clone 
cd ~/path/to/project/directory
mvn clean test package
```


> ### Option configuration instructions

 Place src/main/resources/config/application.properties to the same directory, and configure application properties as : 
 ```
 app.data.source.url - The url for http source
 app.scheduler.fixed-delay - Delay in milliseconds that sheduler should run
 app.provider.deserializer - The data type that provide url. Possible values : deserializer-jsonmapper and deserializer-xmlmapper
 ```
 ```properties
 spring.datasource.driver-class-name=org.h2.Driver
 spring.datasource.url=jdbc:h2:mem:db;DB_CLOSE_ON_EXIT=FALSE
 spring.datasource.username=h2
 spring.datasource.password=h2
 logging.level.net.sf.vgrs.gamesys=TRACE
 #spring.h2.console.enabled=true
 #spring.h2.console.path=/h2-console
 app.data.source.url=https://newsapi.org/v2/top-headlines?country=us&apiKey=05aab06ca65746529dd129d84a4fd334
 app.scheduler.fixed-delay=10000
 app.provider.db=dao-h2-jdbc
 app.provider.deserializer=deserializer-jsonmapper
 app.provider.fetcher=fetcher-http
```properties

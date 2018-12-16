package net.sf.vgrs.gamesys.utils;

import net.sf.vgrs.gamesys.domain.Article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestConstants {
    public static final String TEST_ARTICLES_URL_JSON_RESPONSE = "{     \"status\": \"ok\",     \"totalResults\": 36,     \"articles\": [         {             \"source\": {                 \"id\": null,                 \"name\": \"Heroichollywood.com\"             },             \"author\": \"Mike Annerino\",             \"title\": \"'Spider-Man: Far From Home' Reportedly Foiled Marvel's 'Avengers: Endgame' Plans - Heroic Hollywood\",             \"description\": \"Sony's plan to release a 2019 Spider-Man film reportedly spoiled Marvel's plan of secrecy surrounding the web-slinger's return in Avengers: Endgame.\",             \"url\": \"https://heroichollywood.com/spider-man-avengers-endgame-marvel-plans/\",             \"urlToImage\": \"https://heroichollywood.com/wp-content/uploads/2018/12/Spider-Man-Homecoming-Avengers-Endgame-Tony-Stark.jpg\",             \"publishedAt\": \"2018-12-16T18:16:04Z\",             \"content\": \"It turns out that the announcement of Spider-Man: Far From Home might have foiled Marvel’s plan to keep the hero’s Avengers: Endgame fate under wraps. It’s a good year to be a Spider-Man fan because there have been three major Spider-Man related films release… [+2522 chars]\"         },         {             \"source\": {                 \"id\": null,                 \"name\": \"Cbssports.com\"             },             \"author\": \"\",             \"title\": \"Liverpool vs. Manchester United score: Reds move back into first as Shaqiri plays the hero off the bench - CBSSports.com\",             \"description\": \"Xherdan Shaqiri delivered with two goals in a dominant second half\",             \"url\": \"https://www.cbssports.com/soccer/news/liverpool-vs-manchester-united-score-reds-move-back-into-first-as-shaqiri-plays-the-hero-off-the-bench/\",             \"urlToImage\": \"https://sportshub.cbsistatic.com/i/r/2018/12/16/616981e8-2e2a-4026-9079-8e5ee538674f/thumbnail/770x433/7d9a11635a05d60ff1db543fff825d5c/shaqiri.jpg\",             \"publishedAt\": \"2018-12-16T18:13:00Z\",             \"content\": \"Liverpool is back into first place in the Premier League after dominating rival Manchester United 3-1 on Sunday at Anfield. The match was level at halftime, but an inspired Xherdan Shaqiri came off the bench and scored twice for the Reds, who continued their … [+2149 chars]\"         }     ] }";
    public static final String TEST_ARTICLES_URL_XML_RESPONSE = "<response> <status>ok</status> <totalResults>36</totalResults>    <articles>       <article>          <author>Mike Annerino</author>          <content>It turns out that the announcement of Spider-Man: Far From Home might have foiled Marvel’s plan to keep the hero’s Avengers: Endgame fate under wraps. It’s a good year to be a Spider-Man fan because there have been three major Spider-Man related films release… [+2522 chars]</content>          <description>Sony's plan to release a 2019 Spider-Man film reportedly spoiled Marvel's plan of secrecy surrounding the web-slinger's return in Avengers: Endgame.</description>          <publishedAt>2018-12-16T18:16:04Z</publishedAt>          <source>             <id null=\"true\" />             <name>Heroichollywood.com</name>          </source>          <title>'Spider-Man: Far From Home' Reportedly Foiled Marvel's 'Avengers: Endgame' Plans - Heroic Hollywood</title>          <url>https://heroichollywood.com/spider-man-avengers-endgame-marvel-plans/</url>          <urlToImage>https://heroichollywood.com/wp-content/uploads/2018/12/Spider-Man-Homecoming-Avengers-Endgame-Tony-Stark.jpg</urlToImage>       </article>       <article>          <author />          <content>Liverpool is back into first place in the Premier League after dominating rival Manchester United 3-1 on Sunday at Anfield. The match was level at halftime, but an inspired Xherdan Shaqiri came off the bench and scored twice for the Reds, who continued their … [+2149 chars]</content>          <description>Xherdan Shaqiri delivered with two goals in a dominant second half</description>          <publishedAt>2018-12-16T18:13:00Z</publishedAt>          <source>             <id null=\"true\" />             <name>Cbssports.com</name>          </source>          <title>Liverpool vs. Manchester United score: Reds move back into first as Shaqiri plays the hero off the bench - CBSSports.com</title>          <url>https://www.cbssports.com/soccer/news/liverpool-vs-manchester-united-score-reds-move-back-into-first-as-shaqiri-plays-the-hero-off-the-bench/</url>          <urlToImage>https://sportshub.cbsistatic.com/i/r/2018/12/16/616981e8-2e2a-4026-9079-8e5ee538674f/thumbnail/770x433/7d9a11635a05d60ff1db543fff825d5c/shaqiri.jpg</urlToImage>       </article>    </articles> </response>";

    public static final List ARTICLE_LIST_1 = new ArrayList(Arrays.asList(
            new Article("example1.com", "Test", "Test", new Date(), "Test", "Test"),
            new Article("example2.com", "Test", "Test", new Date(), "Test", "Test")
    ));

    public static final List ARTICLE_LIST_2 = new ArrayList(Arrays.asList(
            new Article("example1.com", "Test", "Test", new Date(), "Test", "Test"),
            new Article("example2.com", "Test", "Test", new Date(), "Test", "Test"),
            new Article("example3.com", "Test", "Test", new Date(), "Test", "Test")
    ));

    public static final List ARTICLE_LIST_3 = new ArrayList(Arrays.asList(
            new Article("example1.com", "Test", "Test", new Date(), "Test", "Test"),
            new Article("example2.com", "Test", "Test", new Date(), "Test", "Test"),
            new Article("example3.com", null, "Test", new Date(), "Test", "Test"),
            new Article("example3.com", "", "Test", new Date(), "Test", "Test")
    ));


    public static final Integer LIMIT_DEFAULT_VALUE = 10;


}

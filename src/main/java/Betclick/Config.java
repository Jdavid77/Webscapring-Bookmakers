package Betclick;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Config {

    public static List<String> getIDs(String league) throws IOException {
        String url = "https://betclic.pt/futebol-s1/" + Leagues.ITALIA_SERIE_A_C6.getRealname();
        System.out.println(String.format("Conectando ao site: %s", url));

        Document doc = Jsoup.connect(url).get();

        Element titulo = doc.getElementsByClass("groupEvents ng-star-inserted").first();

        List<String> ids = new ArrayList<>();

        if (titulo.select("h2[class=groupEvents_headTitle]").text().equals("Amanhã")) {
            ids = titulo
                    .select("a[class=cardEvent prebootFreeze ng-star-inserted]")
                    .stream()
                    .map(x -> x.attr("href"))
                    .collect(Collectors.toList());

            StringBuilder builder = new StringBuilder();

            for (int j = 0; j < ids.size(); j++) {
                for (int i = ids.get(j).length() - 1; i >= 0; i--) {
                    if (ids.get(j).charAt(i) == '/') {
                        break;
                    } else {
                        builder.append(ids.get(j).charAt(i));
                    }
                }
                ids.set(j, builder.reverse().toString());
                builder.setLength(0);
            }
        }

        return ids;
    }
}

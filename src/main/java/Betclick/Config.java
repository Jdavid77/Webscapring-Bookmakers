package Betclick;

import Model.GameFootball;
import Model.Odds;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Config {

    public static List<String> getIDs(String league) throws IOException {
        String url = "https://betclic.pt/futebol-s1/" + league;
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

    public static List<GameFootball> getGames (List<String> ids,String league) throws IOException{
        List<GameFootball> jogos = new ArrayList<>();
        for(int i = 0; i < ids.size(); i++) {
            String url = "https://betclic.pt/futebol-s1/" + league + "/" + ids.get(i);
            Document jogo = Jsoup.connect(url).get();
            String teams = jogo.getElementsByClass("scoreboard_contestantLabel").text();
            String[] teams_separated = teams.split(" ");
            GameFootball game = new GameFootball(1,teams_separated[0],teams_separated[1]);
            List<Element> tipos = jogo.getElementsByTag("sports-markets-single-market");
            for(int j = 0; j < tipos.size(); j++){
                String type = tipos.get(j).select("div[class=marketBox_head]").select("h2").text();
                if(type.equals("Resultado (Tempo Regulamentar)")) {
                    List<String> odds = tipos.get(j)
                            .select("div[class=marketBox_lineSelection ng-star-inserted]")
                            .select("span[class^=oddValue]")
                            .stream().map(Element::text)
                            .collect(Collectors.toList());
                    String odd_home = odds.get(0);
                    String odd_away = odds.get(2);
                    Odds odd = new Odds(type,odd_home,odd_away);
                    System.out.println(odd);
                }

            }

        }
        return null;
    }
}

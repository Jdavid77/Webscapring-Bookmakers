import Betclick.Config;
import Betclick.Leagues;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(Config.getIDs(Leagues.ITALIA_SERIE_A_C6.getRealname()));


    }
        /*
        List<String> ids = doc.select("a[class=cardEvent prebootFreeze ng-star-inserted]").stream().map(x -> x.attr("href")).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();

        for(int j = 0; j < ids.size(); j++){
            for(int i = ids.get(j).length() - 1; i >= 0; i--){
                if(ids.get(j).charAt(i) == '/'){
                    break;
                }
                else{
                    builder.append(ids.get(j).charAt(i));
                }
            }
            ids.set(j,builder.reverse().toString());
            builder.setLength(0);
        }

        //System.out.println(titulo.text() + " and " + ids);

        Document jogo = Jsoup.connect(url + "/" + ids.get(0)).get();

        String teams = jogo.getElementsByClass("scoreboard_contestantLabel").text();
        String[] teams_separated = teams.split(" ");
        GameFootball game = new GameFootball(1,teams_separated[0],teams_separated[1]);
        System.out.println(game);
        List<Element> fulltime = jogo.getElementsByClass("marketBox_head").select("h2");*/


}


import Betclick.BetClickConfig;
import Betclick.Leagues;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        for(Leagues enu : Leagues.values()){
            List<String> ids = BetClickConfig.getIDs(enu.getRealname());
            System.out.println(BetClickConfig.getGames(ids,enu.getRealname()));
        }




    }



}


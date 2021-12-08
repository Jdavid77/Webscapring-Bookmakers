package Enums;

public enum Leagues {

    ITALIA_SERIE_A_C6("italia-serie-a-c6"),
    INGLATERRA_PREMIER_LEAGUE_C3("inglaterra-premier-league-c3"),
    PORTUGAL_PRIMEIRA_LIGA_C32("portugal-primeira-liga-c32"),
    ALEMANHA_BUNDESLIGA_C5("alemanha-bundesliga-c5"),
    ESPANHA_LA_LIGA_C7("espanha-la-liga-c7"),
    FRANCA_LIGUE_1_C4("franca-ligue-1-c4");


    private final String realname;

    private Leagues(String realname){
        this.realname = realname;
    }

    public String getRealname(){
        return realname;
    }

}

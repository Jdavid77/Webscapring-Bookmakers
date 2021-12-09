package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameFootball {

    public Integer id;
    private String home_team;
    private String away_team;

    private List<Odds> odds = new ArrayList<>();

    public GameFootball(Integer id, String home_team, String away_team) {
        this.id = id;
        this.home_team = home_team;
        this.away_team = away_team;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public String getAway_team() {
        return away_team;
    }

    public void setAway_team(String away_team) {
        this.away_team = away_team;
    }

    public List<Odds> getOdds() {
        return odds;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameFootball game = (GameFootball) o;
        return id.equals(game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(home_team + " vs " + away_team + "\n Odds:");
        for(Odds odd : this.odds){
            result.append("\n" + odd);
        }
        return result.toString();
    }
}
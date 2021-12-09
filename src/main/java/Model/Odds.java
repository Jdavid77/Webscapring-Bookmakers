package Model;

public class Odds {

    private String name;
    private String odd_home;
    private String odd_away;

    public Odds(String name, String odd_home, String odd_away) {
        this.name = name;
        this.odd_home = odd_home;
        this.odd_away = odd_away;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOdd_home() {
        return odd_home;
    }

    public void setOdd_home(String odd_home) {
        this.odd_home = odd_home;
    }

    public String getOdd_away() {
        return odd_away;
    }

    public void setOdd_away(String odd_away) {
        this.odd_away = odd_away;
    }

    @Override
    public String toString() {
        return name + "\n" + odd_home + " - " + odd_away;
    }
}

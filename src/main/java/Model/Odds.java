package Model;

public class Odds {

    private String name;
    private Double odd_home;

    private Double odd_away;

    public Odds(String name, Double odd_home, Double odd_away) {
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

    public Double getOdd_home() {
        return odd_home;
    }

    public void setOdd_home(Double odd_home) {
        this.odd_home = odd_home;
    }

    public Double getOdd_away() {
        return odd_away;
    }

    public void setOdd_away(Double odd_away) {
        this.odd_away = odd_away;
    }
}

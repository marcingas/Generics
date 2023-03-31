
interface Player {
String name();
}

record BaseballPlayer(String name, String position) implements Player { }
record FootballPlayer(String name, String position) implements Player { }
record VolleyballPlayer(String name, String position) implements Player { }


public class Main {
    public static void main(String[] args) {
        BaseballTeam wisla1 = new BaseballTeam("Wisła Kraków");
        BaseballTeam warszawa1 = new BaseballTeam("Legia Warszawa");
        scoreResult(wisla1, 3, warszawa1, 5);

        TeamNotGeneric wisla2 = new TeamNotGeneric("Wisła Kraków");
        TeamNotGeneric warszawa2 = new TeamNotGeneric("Legia Warszawa");
        scoreResult(wisla2, 3, warszawa2, 5);

        Team<BaseballPlayer, Affiliation> wisla = new Team<>("Wisła Kraków");
        Team<BaseballPlayer, Affiliation> warszawa = new Team<BaseballPlayer, Affiliation>("Legia Warszawa");
        scoreResult(wisla, 3, warszawa, 5);

        Team<FootballPlayer, Affiliation> wisla3 = new Team<>("Wisła Kraków");
        Team<FootballPlayer, Affiliation> warszawa3 = new Team<>("Legia Warszawa");
        scoreResult(wisla3, 3, warszawa3, 5);
        var krzynowek = new FootballPlayer("Krzynówek", "emeryt");
        wisla3.addTeamMember(krzynowek);
        wisla3.listTeamMembers();

        var kuba = new BaseballPlayer("Błaszczykowski", "Right Fielder");
        var krzys = new BaseballPlayer("Lewandowski", "Right Fielder");
        wisla.addTeamMember(kuba);
        wisla.addTeamMember(krzys);
        wisla.listTeamMembers();

        TeamNotGeneric koszarawa = new TeamNotGeneric("Koszarawa not generic Żywiec");


        var kosz = new Affiliation("city", "Śląskie, SK","PL");
        Team<FootballPlayer, Affiliation> koszarawa1 = new Team<>("Koszarawa1 generic  Żywiec",kosz);
        var kubaN = new FootballPlayer("Kuba Piłkarz", "Napastink");
        koszarawa.addTeamMember(kubaN);
        koszarawa.addTeamMember(kuba);
        koszarawa.listTeamMembers();
        koszarawa1.addTeamMember(kubaN);
        koszarawa1.listTeamMembers();
        var roy = new FootballPlayer("Rory Laird","Midfield");
        koszarawa1.addTeamMember(roy);

        var chorz = new Affiliation("city","Silesia area, SK", "PL");

        Team<VolleyballPlayer, Affiliation> chorzow = new Team<>("GKS Chorzów",chorz);
        chorzow.addTeamMember(new VolleyballPlayer("Nick Footballer","Second attacker"));
        chorzow.listTeamMembers();
        scoreResult(chorzow,1,koszarawa1,2);

    }

    public static void scoreResult(BaseballTeam t1, int t1_score, BaseballTeam t2, int t2_score) {
        String message = t1.setScore(t1_score, t2_score);
        t2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", t1, message, t2);
    }
    public static void scoreResult(TeamNotGeneric t1, int t1_score, TeamNotGeneric t2, int t2_score) {
        String message = t1.setScore(t1_score, t2_score);
        t2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", t1, message, t2);
    }
    public static void scoreResult(Team t1, int t1_score, Team t2, int t2_score) {
        String message = t1.setScore(t1_score, t2_score);
        t2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", t1, message, t2);
    }
}
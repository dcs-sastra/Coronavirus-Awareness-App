package dsc.sastra.coronavirus_awareness_app.ui.notifications;

public class country {

    private String cname;
    private String cdeath;
    private String caffected;
    private String crecover;

    public country(String name, String death, String affect,String recover) {
        cname=name;
        cdeath=death;
        caffected=affect;
        crecover=recover;
    }

    public String getCname()
    {
        return cname;
    }
    public String getCdeath()
    {
        return cdeath;
    }

    public String getCaffected() {
        return caffected;
    }
    public  String getCrecover()
    {
        return crecover;
    }
}

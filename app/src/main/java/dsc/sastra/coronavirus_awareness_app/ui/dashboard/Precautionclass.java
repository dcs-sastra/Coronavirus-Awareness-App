package dsc.sastra.coronavirus_awareness_app.ui.dashboard;

public class Precautionclass {

    private String text;

    private int id;

    public Precautionclass()
    {}
    public Precautionclass(String t,int i)
    {
        text=t;
        id=i;
    }


    public String getttext()
    {
        return text;
    }

    public int getid()
    {
        return id;
    }
}

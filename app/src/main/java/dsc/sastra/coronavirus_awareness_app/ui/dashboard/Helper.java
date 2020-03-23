package dsc.sastra.coronavirus_awareness_app.ui.dashboard;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Helper {

    public static void getListViewSize(ListView lview)
    {
        ListAdapter ladapter=lview.getAdapter();
        int height=0;
        for(int size=0;size<ladapter.getCount();size++)
        {
            View listiem=ladapter.getView(size,null,lview);
            listiem.measure(0,0);
            height+=listiem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params=lview.getLayoutParams();
        params.height=height+(lview.getDividerHeight()*(ladapter.getCount()-1));

    }
}

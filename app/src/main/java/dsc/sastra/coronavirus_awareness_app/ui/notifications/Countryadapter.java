package dsc.sastra.coronavirus_awareness_app.ui.notifications;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dsc.sastra.coronavirus_awareness_app.R;

public class Countryadapter extends ArrayAdapter<country> {
    public Countryadapter(Activity context, ArrayList<country> con)

    {
        super(context,0,con);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview=convertView;
        if(listitemview==null)
        {
            listitemview= LayoutInflater.from(getContext()).inflate(R.layout.countrylistlayout,parent,false);
        }
        final country c=getItem(position);
       // Log.i(LOG_TAG, "Item position: " + position);
      //  listitemivew.setBackgroundColor(colors[colorPos]);
        TextView t1=(TextView)listitemview.findViewById(R.id.name);
        t1.setText(c.getCname());
        TextView t2=(TextView)listitemview.findViewById(R.id.affected);
        t2.setText(c.getCaffected());

        TextView t3=(TextView)listitemview.findViewById(R.id.death);
        t3.setText(c.getCdeath());
        TextView t4=(TextView)listitemview.findViewById(R.id.recover);
        t4.setText(c.getCrecover());

        return listitemview;
    }
}

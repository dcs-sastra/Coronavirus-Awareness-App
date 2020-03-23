package dsc.sastra.coronavirus_awareness_app.ui.dashboard;

import android.app.Activity;
import android.graphics.Color;
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
import dsc.sastra.coronavirus_awareness_app.ui.dashboard.DashboardFragment;
import dsc.sastra.coronavirus_awareness_app.ui.dashboard.Precautionclass;

public class PrecautionAdapter extends ArrayAdapter<Precautionclass> {


    int white = Color.parseColor("#ffffff");
    int blue=Color.parseColor("#E3F2FD");

    int[] colors = new int[] { blue,white };
    public PrecautionAdapter(Activity context, ArrayList<Precautionclass> pre)
    {
        super(context, 0, pre);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View listitemivew = convertView;
        if(listitemivew==null)
        {
            listitemivew= LayoutInflater.from(getContext()).inflate(R.layout.listlayout,parent,false);
        }
        Precautionclass pclass=getItem(position);
        int colorPos = position % colors.length;
        listitemivew.setBackgroundColor(colors[colorPos]);
        TextView textView=(TextView)listitemivew.findViewById(R.id.text);
        textView.setText(pclass.getttext());
        ImageView i=(ImageView)listitemivew.findViewById(R.id.image);
        i.setImageResource(pclass.getid());
        return listitemivew;
    }
}

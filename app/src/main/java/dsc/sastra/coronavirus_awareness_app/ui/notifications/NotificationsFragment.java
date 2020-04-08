package dsc.sastra.coronavirus_awareness_app.ui.notifications;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import dsc.sastra.coronavirus_awareness_app.R;

public class NotificationsFragment extends Fragment {

    private static final int id=1;
    Countryadapter cadapter;
    private String requrl="";
    ListView lview;
    ProgressDialog pd;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        pd  = new ProgressDialog(root.getContext());
        pd.setCancelable(false);
        pd.setMessage("Loading Please Wait");
       lview=(ListView) root.findViewById(R.id.countrylistview);
       cadapter=new Countryadapter(this.getActivity(),new ArrayList<country>());
       lview.setAdapter(cadapter);
       StringBuilder sb=new StringBuilder();
       sb.append("https://covid2019-api.herokuapp.com/current_list");
       requrl=sb.toString();
       ConAsyncTAsk task=new ConAsyncTAsk();
       task.execute(requrl);
        return root;
    }

    private class ConAsyncTAsk extends AsyncTask<String, Void, List<country>>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.show();
        }

        @Override
        protected List<country> doInBackground(String... strings) {
            if(strings.length<1|| strings[0]==null)
            {
                return null;
            }
            List<country> result=queryutil.fetchdata(strings[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<country> countries) {
            cadapter.clear();
            pd.dismiss();
            if(countries!=null && !countries.isEmpty())
            {
                cadapter.addAll(countries);
            }

        }
    }
}

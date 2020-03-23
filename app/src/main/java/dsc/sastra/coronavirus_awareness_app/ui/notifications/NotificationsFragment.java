package dsc.sastra.coronavirus_awareness_app.ui.notifications;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import androidx.recyclerview.widget.RecyclerView;
import dsc.sastra.coronavirus_awareness_app.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private static final int id=1;
    Countryadapter cadapter;
    private String requrl="";
    ListView lview;
    ProgressDialog pbar;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
      //  pbar=new ProgressDialog(this.getActivity());
       /* final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

    /*   pbar.setMessage("Please wait while we are loading...");
       pbar.setCanceledOnTouchOutside(false);
       pbar.show();*/
       lview=(ListView) root.findViewById(R.id.countrylistview);
       cadapter=new Countryadapter(this.getActivity(),new ArrayList<country>());
       lview.setAdapter(cadapter);
       StringBuilder sb=new StringBuilder();
       sb.append("https://covid2019-api.herokuapp.com/current_list");
       requrl=sb.toString();
       ConAsyncTAsk task=new ConAsyncTAsk();
       task.execute(requrl);

   //   pbar.cancel();
        return root;
    }

    private class ConAsyncTAsk extends AsyncTask<String, Void, List<country>>
    {
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
            if(countries!=null && !countries.isEmpty())
            {
                cadapter.addAll(countries);
            }

        }
    }
}

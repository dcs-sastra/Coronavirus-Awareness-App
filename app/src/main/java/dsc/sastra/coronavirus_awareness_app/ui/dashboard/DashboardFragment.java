package dsc.sastra.coronavirus_awareness_app.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import dsc.sastra.coronavirus_awareness_app.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
      //  dashboardViewModel =
               // ViewModelProviders.of(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
       /* final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });*/

        ArrayList<Precautionclass> parray=new ArrayList<Precautionclass>();

        Precautionclass pclass=new Precautionclass("Wash hands with soap and water or alcohol based handrub frequently",R.drawable.handd);
        parray.add(pclass);
        parray.add( new Precautionclass("Cover your nose and mouth with Handkerchief/tissue while sneezing, coughing",R.drawable.sneeze));
        parray.add(new Precautionclass("Throw used tissues into bins after use",R.drawable.trash));
        parray.add(new Precautionclass("Cover mouth, nose with mask/cloth while travelling",R.drawable.sick));
        parray.add(new Precautionclass("See a doctor if you have symptoms like fever, cough, difficult in breathing",R.drawable.doctor));
        parray.add(new Precautionclass("Avoid participating in large gatherings",R.drawable.group));

        PrecautionAdapter padapter=new PrecautionAdapter(this.getActivity(),parray);
        ListView lview=root.findViewById(R.id.preclistview);
        lview.setAdapter(padapter);
        Helper.getListViewSize(lview);

        ArrayList<Precautionclass> parray2=new ArrayList<Precautionclass>();
        Precautionclass pclass2=new Precautionclass("Have a close contact with anyone, if you  are experiencing cough and fever",R.drawable.agreement );
        parray2.add(pclass2);
        parray2.add(new Precautionclass("Touch your eyes,nose and mouth",R.drawable.touch));
        parray2.add(new Precautionclass("Spit in public",R.drawable.spit));

        PrecautionAdapter padapter2=new PrecautionAdapter(this.getActivity(),parray2);
        ListView lview2=root.findViewById(R.id.preclistview2);
        lview2.setAdapter(padapter2);
        Helper.getListViewSize(lview2);
        return root;
    }
}

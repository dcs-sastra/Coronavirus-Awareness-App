package dsc.sastra.coronavirus_awareness_app.ui.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import dsc.sastra.coronavirus_awareness_app.R;
import dsc.sastra.coronavirus_awareness_app.newsdata.News;

public class HomeFragment extends Fragment  {
    private View root;
    DatabaseReference reference;
    NewsAdapter adapter;
    ArrayList<News> list;
    RecyclerView recyclerView;
    private ProgressDialog pd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);
        pd = new ProgressDialog(root.getContext());
        pd.setCancelable(false);
        pd.setMessage("Loading Please Wait");
        recyclerView = root.findViewById(R.id.news);
        pd.show();
        recyclerView.setLayoutManager( new LinearLayoutManager(root.getContext()));
        reference = FirebaseDatabase.getInstance().getReference().child("News");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<News>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    News p = dataSnapshot1.getValue(News.class);
                    list.add(p);
                }
                adapter = new NewsAdapter(root.getContext(),list);
                recyclerView.setAdapter(adapter);
                pd.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(root.getContext(), "Opsss.... Something is wrong ", Toast.LENGTH_SHORT).show();
                pd.dismiss();
            }
        });
        return root;
    }
}

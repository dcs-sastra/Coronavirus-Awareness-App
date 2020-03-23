package dsc.sastra.coronavirus_awareness_app.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import dsc.sastra.coronavirus_awareness_app.R;
import dsc.sastra.coronavirus_awareness_app.newsdata.News;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    Context context;
    ArrayList<News> news_r;

    public NewsAdapter(Context c , ArrayList<News> p)
    {
        context = c;
        news_r = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.news_listitem,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Title.setText(news_r.get(position).getTitle());
        holder.Content.setText(news_r.get(position).getContent());
        Picasso.get().load(news_r.get(position).getImage()).into(holder.NewsPic);
    }

    @Override
    public int getItemCount() {
        return news_r.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView Title,Content;
        ImageView NewsPic;
        Button btn;
        public MyViewHolder(View itemView) {
            super(itemView);
            Title = (TextView) itemView.findViewById(R.id.newsTitle);
            Content = (TextView) itemView.findViewById(R.id.newsContent);
            NewsPic = (ImageView) itemView.findViewById(R.id.newsimage);
        }
        public void onClick(final int position)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, position+" is clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

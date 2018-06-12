package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anushka.androidarchiechture.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import pojo.Datum;
import pojo.FeaturedApp;

/**
 * Created by Anushka on 13-04-2018.
 */

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.Holder> {

    private Context context;
    private List<Datum>featuredAppList;
    private LayoutInflater layoutInflater;
    public AppListAdapter(Context context, List<Datum> featuredAppList)
    {
        this.context=context;
        this.featuredAppList=featuredAppList;
        this.layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        Holder holder=new Holder(layoutInflater.inflate(R.layout.app_list_item,parent,false));

        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {


        String url=featuredAppList.get(position).getAvatar();
        String appName=featuredAppList.get(position).getFirstName()+" "+featuredAppList.get(position).getLastName();
        if(url!=null)
        Picasso.with(context).load(url).into(holder.imageView);
        holder.textView.setText(appName);
    }

    @Override
    public int getItemCount() {
        return featuredAppList.size();
    }

    class Holder extends RecyclerView.ViewHolder
    {

        public ImageView imageView;
        public TextView textView;
        public Holder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}

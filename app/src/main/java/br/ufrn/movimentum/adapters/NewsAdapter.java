package br.ufrn.movimentum.adapters;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.ufrn.movimentum.R;
import br.ufrn.movimentum.fragments.ItemNews;


public class NewsAdapter extends BaseAdapter {

    private final List<ItemNews> list_itens;
    private final Activity activity;

    public NewsAdapter(List<ItemNews> list_itens, Activity activity) {
        this.list_itens = list_itens;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list_itens.size();
    }

    @Override
    public Object getItem(int position) {
        return list_itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list_itens.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = activity.getLayoutInflater().inflate(R.layout.list_news, parent, false);
        ItemNews item_list = list_itens.get(position);

        TextView tv_title_news_group = (TextView) view.findViewById(R.id.tv_title_news_group);
        TextView tv_schedule_news_group = (TextView) view.findViewById(R.id.tv_schedule_news_group);
        TextView tv_time_news_group = (TextView) view.findViewById(R.id.tv_time_news_group);

        tv_title_news_group.setText(item_list.getTitle());
        tv_schedule_news_group.setText(item_list.getData());
        tv_time_news_group.setText(item_list.getHora());
        return view;
    }

}

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
import br.ufrn.movimentum.model.GlobalNews;
import br.ufrn.movimentum.model.Group;
import br.ufrn.movimentum.model.News;


public class GlobalNewsAdapter extends NewsAdapter {

    public GlobalNewsAdapter(List<News> list_itens, Activity activity) {
        super(list_itens, activity);
    }

    @Override
    public int getCount() {
        return getList_itens().size();
    }

    @Override
    public Object getItem(int position) {
        return  getList_itens().get(position);
    }

    @Override
    public long getItemId(int position) {
        return  getList_itens().get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        GlobalNews item_News = (GlobalNews) getList_itens().get(position);
        ImageView newsPicture = view.findViewById(R.id.iv_group_img);
        newsPicture.setImageURI(Uri.parse(item_News.getGroupPicturePath()));
        return view;
    }

}

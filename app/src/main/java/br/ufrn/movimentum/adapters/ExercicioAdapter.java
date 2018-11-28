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

/**
 * Created by Barreto on 22/11/2017.
 */

public class ExercicioAdapter extends BaseAdapter {

    private final List<ItemList> list_itens;
    private final Activity activity;

    public ExercicioAdapter(List<ItemList> list_itens, Activity activity) {
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

        View view = activity.getLayoutInflater().inflate(R.layout.list_item, parent, false);
        ItemList item_list = list_itens.get(position);
//
        TextView groupName = (TextView) view.findViewById(R.id.tv_group_name);
        TextView groupLocal = (TextView) view.findViewById(R.id.tv_group_local);
        TextView groupSchedule = (TextView) view.findViewById(R.id.tv_group_schedule);
        TextView groupTime = (TextView) view.findViewById(R.id.tv_group_time);
        ImageView groupPicture = (ImageView) view.findViewById(R.id.iv_group_img);

        groupName.setText(item_list.getGroupName());
        groupLocal.setText(item_list.getGroupLocal());
        groupSchedule.setText(item_list.getGroupSchedule());
        groupTime.setText(item_list.getGroupTime());
        groupPicture.setImageURI(Uri.parse(item_list.getGroupPicturePath()));
        return view;
    }

}

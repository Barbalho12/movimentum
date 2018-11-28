package br.ufrn.movimentum.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
        TextView nome = (TextView) view.findViewById(R.id.exercicio_nome);
        TextView pts = (TextView) view.findViewById(R.id.exercicio_pts);
        TextView qtd = (TextView) view.findViewById(R.id.exercicio_qtd);

        nome.setText(item_list.getNomeExercicio());
        qtd.setText(item_list.getQuantidade_realizada()+"/"+item_list.getQuantidade_total());
        pts.setText(item_list.getPontuacao());
        return view;
//        return null;
    }

}

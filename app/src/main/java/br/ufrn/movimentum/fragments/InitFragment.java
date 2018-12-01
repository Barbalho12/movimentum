package br.ufrn.movimentum.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.movimentum.InicialAllActivity;
import br.ufrn.movimentum.MainActivity;
import br.ufrn.movimentum.NewGroupActivity;
import br.ufrn.movimentum.R;
import br.ufrn.movimentum.ViewGroupActivity;
import br.ufrn.movimentum.adapters.GroupAdapter;
import br.ufrn.movimentum.adapters.ItemList;


public class InitFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
//
//    /**
//     * Returns a new instance of this fragment for the given section
//     * number.
//     */
    public static InitFragment newInstance(int sectionNumber) {
        InitFragment fragment = new InitFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_init, container, false);

        ListView listview = (ListView) rootView.findViewById(R.id.listview);

        List<ItemList> list_itens = new ArrayList<>();
        String pathName = "android.resource://"+getActivity().getPackageName()+"/";

        list_itens.add(new ItemList(1, "Corrida Livre", "Em torno da UFRN", "qui,sex", "18h00-19h00", pathName+R.drawable.running_group));
        list_itens.add(new ItemList(2, "Natação 2", "UFRN - Piscina 2", "seg,qua", "08h00-09h00", pathName+R.drawable.swimming_group));

        GroupAdapter groupAdapter = new GroupAdapter(list_itens, getActivity());
        listview.setAdapter(groupAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),
//                        "Clicou no item " + position, Toast.LENGTH_LONG).show();
                if(position==0){
                    Snackbar.make(view, "Não implementado", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
//                    Intent intent = new Intent(getActivity(), ViewGroupActivity.class);
//                    startActivity(intent);

                }else{
                    Snackbar.make(view, "Não implementado", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
//                    AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
//                    alertDialog.setTitle("Alerta");
//                    alertDialog.setMessage("Não implementado");
//                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                    dialog.dismiss();
//                                }
//                            });
//                    alertDialog.show();
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NewGroupActivity.class);
                startActivity(intent);
//                finish();

//                Snackbar.make(view, "Ação em Início", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        return rootView;
    }

}

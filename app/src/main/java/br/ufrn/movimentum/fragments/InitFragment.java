package br.ufrn.movimentum.fragments;

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
import br.ufrn.movimentum.NewGroupActivity;
import br.ufrn.movimentum.R;
import br.ufrn.movimentum.ViewMyGroupActivity;
import br.ufrn.movimentum.adapters.GroupAdapter;
import br.ufrn.movimentum.model.Group;
import br.ufrn.movimentum.model.User;


public class InitFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static InitFragment newInstance(int sectionNumber) {
        InitFragment fragment = new InitFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_init, container, false);

        ListView listview = (ListView) rootView.findViewById(R.id.listview);

        List<Group> list_itens = new ArrayList<>();
        String pathName = "android.resource://"+getActivity().getPackageName()+"/";

        User user = InicialAllActivity.userManager.getActiveUser();
        List<Group> groups = user.getGroups();
        list_itens.addAll(groups);
//        list_itens.add(new Group(1, "Corrida Livre", "Em torno da UFRN", "qui,sex", "18h00-19h00", pathName+R.drawable.running_group));
//        list_itens.add(new Group(2, "Natação 2", "UFRN - Piscina 2", "seg,qua", "08h00-09h00", pathName+R.drawable.swimming_group));

        GroupAdapter groupAdapter = new GroupAdapter(list_itens, getActivity());
        listview.setAdapter(groupAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),
//                        "Clicou no item " + position, Toast.LENGTH_LONG).show();
//                if(position==0){
//
//                }
//                    InicialAllActivity.userManager.setActiveGroup((Group)parent.getItemAtPosition(position));
                    InicialAllActivity.userManager.setActiveGroup((Group)parent.getItemAtPosition(position));
                    Intent intent = new Intent(getActivity(), ViewMyGroupActivity.class);
                    startActivity(intent);

//                }else{
//                    Snackbar.make(view, "Não implementado", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
//                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NewGroupActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}

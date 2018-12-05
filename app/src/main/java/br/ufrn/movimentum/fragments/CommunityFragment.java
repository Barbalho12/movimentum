package br.ufrn.movimentum.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.movimentum.HomeActivity;
import br.ufrn.movimentum.R;
import br.ufrn.movimentum.SearchGroupActivity;
import br.ufrn.movimentum.ViewGroupActivity;
import br.ufrn.movimentum.ViewMyGroupActivity;
import br.ufrn.movimentum.adapters.GroupAdapter;
import br.ufrn.movimentum.model.Group;


public class CommunityFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
//
//    /**
//     * Returns a new instance of this fragment for the given section
//     * number.
//     */
    public static CommunityFragment newInstance(int sectionNumber) {
        CommunityFragment fragment = new CommunityFragment();
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

    List<Group> list_itens;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_init, container, false);

        ListView listview = (ListView) rootView.findViewById(R.id.listview);

        list_itens = new ArrayList<>();
        String pathName = "android.resource://"+getActivity().getPackageName()+"/";


        List<Group> groups = HomeActivity.userManager.getGroups();
        list_itens.addAll(groups);

//        list_itens.add(new Group(1, "Corrida Livre", "Em torno da UFRN", "qui,sex", "18h00-19h00", pathName+R.drawable.running_group));
//        list_itens.add(new Group(2, "Natação 2", "UFRN - Piscina 2", "seg,qua", "08h00-09h00", pathName+R.drawable.swimming_group));
//        list_itens.add(new Group(3, "Time de Atletismo", "UFRN - Pista de Atletismo", "seg,qua,sex", "17h00-18h30", pathName+R.drawable.atletism_group));
//        list_itens.add(new Group(6, "Futsal C&T", "UFRN - Ginásio 2", "ter", "08h00-10h00", pathName+R.drawable.group_futsal_cet));
//        list_itens.add(new Group(4, "Hidroginástica 3° Idade", "UFRN - Piscina 2", "seg,qua", "16h00-17h00", pathName+R.drawable.group_hidro));
//        list_itens.add(new Group(5, "Time Futsal UFRN", "UFRN - Ginásio 1", "seg,qua,sex", "18h00-19h30", pathName+R.drawable.group_futsal));
//
//        list_itens.add(new Group(7, "Treino Karate", "UFRN - Ginásio 1", "qua,sex", "20h00-21h00", pathName+R.drawable.group_karate));
//        list_itens.add(new Group(8, "Preparatório Maratona", "Em torno da UFRN", "seg,qua,sex", "07h00-08h30", pathName+R.drawable.group_maratona));

        GroupAdapter groupAdapter = new GroupAdapter(list_itens, getActivity());
        listview.setAdapter(groupAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                Toast.makeText(getApplicationContext(),
//                        "Clicou no item " + position, Toast.LENGTH_LONG).show();

                HomeActivity.userManager.setActiveGroup(list_itens.get(position));


                if(HomeActivity.userManager.getActiveUser().getGroups().contains(list_itens.get(position))){
                    Intent intent = new Intent(getActivity(), ViewMyGroupActivity.class);
                    intent.putExtra("group",list_itens.get(position));
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(), ViewGroupActivity.class);
                    intent.putExtra("group",list_itens.get(position));
                    startActivity(intent);
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setImageURI(Uri.parse(pathName+R.drawable.search));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchGroupActivity.class);
                startActivity(intent);
//                Snackbar.make(view, "Ação em comunidade", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        return rootView;
    }

}

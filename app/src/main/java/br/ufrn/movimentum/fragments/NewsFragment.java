package br.ufrn.movimentum.fragments;

import android.content.Intent;
import android.net.Uri;
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
import br.ufrn.movimentum.R;
import br.ufrn.movimentum.SearchNewsActivity;
import br.ufrn.movimentum.adapters.GlobalNewsAdapter;
import br.ufrn.movimentum.adapters.GroupAdapter;
import br.ufrn.movimentum.adapters.NewsAdapter;
import br.ufrn.movimentum.model.GlobalNews;
import br.ufrn.movimentum.model.Group;
import br.ufrn.movimentum.model.News;


public class NewsFragment extends Fragment {

    public static NewsFragment newInstance(int sectionNumber) {
        NewsFragment fragment = new NewsFragment();
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

        List<GlobalNews> list_itens = new ArrayList<>();
        String pathName = "android.resource://"+getActivity().getPackageName()+"/";

        List<GlobalNews> globalNews = InicialAllActivity.userManager.getGlobalNews();
        list_itens.addAll(globalNews);
//        list_itens.add
//        list_itens.add(new Group(1, "Maratona Meia do Sol", "Arena das Dunas (Largada)", "dom", "08h00", pathName+R.drawable.news_maratona));

        List<News> list_itens_converted = new ArrayList<>();
        list_itens_converted.addAll(list_itens);
        GlobalNewsAdapter newsAdapter = new GlobalNewsAdapter(list_itens_converted, getActivity());
        listview.setAdapter(newsAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                Toast.makeText(getApplicationContext(),
//                        "Clicou no item " + position, Toast.LENGTH_LONG).show();
                if(position==0){
                    Snackbar.make(view, "Não implementado", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
//                    Intent intent = new Intent(getActivity(), SearchNewsActivity.class);
//                    startActivity(intent);
////                    finish();
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
        fab.setImageURI(Uri.parse(pathName+R.drawable.search));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Ação em Notícias", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                Intent intent = new Intent(getActivity(), SearchNewsActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}

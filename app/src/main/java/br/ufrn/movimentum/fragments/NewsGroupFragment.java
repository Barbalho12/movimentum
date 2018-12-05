package br.ufrn.movimentum.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import br.ufrn.movimentum.HomeActivity;
import br.ufrn.movimentum.R;
import br.ufrn.movimentum.adapters.NewsAdapter;
import br.ufrn.movimentum.model.Group;
import br.ufrn.movimentum.model.News;


public class NewsGroupFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    static Group group;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static NewsGroupFragment newInstance(int sectionNumber, Group group_) {
        group = group_;
        NewsGroupFragment fragment = new NewsGroupFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_news_group, container, false);

        ListView listview = (ListView) rootView.findViewById(R.id.listview_news_group);

        List<News> news = HomeActivity.userManager.getActiveGroup().getListNews();
//        List<News> list_itens = new ArrayList<>();
//        list_itens.add(new ItemNews(1, "Cancelamento do treino de hoje", "28/10/2018", "16h40"));

        NewsAdapter newsAdapter = new NewsAdapter(news, getActivity());
        listview.setAdapter(newsAdapter);
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
////                Toast.makeText(getApplicationContext(),
////                        "Clicou no item " + position, Toast.LENGTH_LONG).show();
//                if(position==0){
//                    Snackbar.make(view, "Não implementado", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
////                    Intent intent = new Intent(getActivity(), SearchNewsActivity.class);
////                    startActivity(intent);
//////                    finish();
//                }else{
//                    Snackbar.make(view, "Não implementado", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
//                }
//            }
//        });

        FloatingActionButton fab = rootView.findViewById(R.id.fab_news_group);
        String pathName = "android.resource://"+getActivity().getPackageName()+"/";
        fab.setImageURI(Uri.parse(pathName+R.drawable.add));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Não Implementado", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

//                Intent intent = new Intent(getActivity(), SearchNewsActivity.class);
//                startActivity(intent);
            }
        });

        return rootView;
    }
}

package br.ufrn.movimentum.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.ufrn.movimentum.R;
import br.ufrn.movimentum.utils.RoundImage;


public class DetailsGroupFragment extends Fragment {


    private ImageView iv_image_view_my_group;
    private TextView tv_title_view_my_group;
    private TextView tv_capacity_view_my_group;
    private TextView tv_local_view_my_group;
    private TextView tv_interval_my_group;
    private TextView tv_days_my_group;
    private GridLayout grid_users_group;
    private Button bt_request_participate_my_group;
    private Button bt_view_local_my_group;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static DetailsGroupFragment newInstance(int sectionNumber) {
        DetailsGroupFragment fragment = new DetailsGroupFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_details_group, container, false);

        initViewWidgets(rootView);
        setValuesDefault(rootView);

        return rootView;
    }


    private void setValuesDefault(View rootView) {
        String desc = "Este grupo é destinado para pessoas que curtem praticar corrida regulamente, " +
                "com a finalidade principal de buscar saúde e qualidade de vida. Para auxiliar cada " +
                "membro, um profissinal de educação física tem disponibilidade para retirar dúvidas.";
        WebView wv_view_my_group = rootView.findViewById(R.id.wv_view_my_group);
        wv_view_my_group.setVerticalScrollBarEnabled(false);
        String descHTML =  "<html><body style='text-align:justify;color:gray;'>  "+desc+" </body></html>";
        wv_view_my_group.loadData(descHTML,"text/html","utf-8");
        wv_view_my_group.setBackgroundColor(Color.TRANSPARENT);
        wv_view_my_group.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);

        String pathName = "android.resource://"+rootView.getContext().getPackageName()+"/";
        Uri uri = Uri.parse(pathName+R.drawable.running_group);
        iv_image_view_my_group.setImageURI(uri);
        tv_title_view_my_group.setText("Corrida Livre");
        tv_local_view_my_group.setText("Em torno da UFRN");
        tv_interval_my_group.setText("18h00 - 19h00");
        tv_days_my_group.setText("qui,sex");
        tv_capacity_view_my_group.setText("17/30");
        tv_capacity_view_my_group.setTextColor(Color.rgb(80,170,80));


//        grid_users_group.removeAllViews();
//
//        int total = 10;
//        int column = 3;
//        int row = total / column;
//        grid_users_group.setColumnCount(column);
//        grid_users_group.setRowCount(row + 1);
//        for (int i = 0, c = 0, r = 0; i < total; i++, c++) {
//            if (c == column) {
//                c = 0;
//                r++;
//            }
//            ImageView oImageView = new ImageView(rootView.getContext());
//            oImageView.setImageResource(R.drawable.boy);
//
//            oImageView.setLayoutParams(new ViewGroup.LayoutParams(20, 20));
//
//            GridLayout.Spec rowSpan = GridLayout.spec(GridLayout.UNDEFINED, 1);
//            GridLayout.Spec colspan = GridLayout.spec(GridLayout.UNDEFINED, 1);
//            if (r == 0 && c == 0) {
//                Log.e("", "spec");
//                colspan = GridLayout.spec(GridLayout.UNDEFINED, 2);
//                rowSpan = GridLayout.spec(GridLayout.UNDEFINED, 2);
//            }
//            GridLayout.LayoutParams gridParam = new GridLayout.LayoutParams(rowSpan, colspan);
//            grid_users_group.addView(oImageView, gridParam);
//
//
//        }

        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));
        grid_users_group.addView(createImageView(R.drawable.boy));

    }

    private void initViewWidgets(View rootView) {
        iv_image_view_my_group = rootView.findViewById(R.id.iv_image_view_my_group);
        tv_title_view_my_group = rootView.findViewById(R.id.tv_title_view_my_group);
        tv_capacity_view_my_group = rootView.findViewById(R.id.tv_capacity_view_my_group);
        tv_local_view_my_group = rootView.findViewById(R.id.tv_local_view_my_group);
        tv_interval_my_group = rootView.findViewById(R.id.tv_interval_my_group);
        tv_days_my_group = rootView.findViewById(R.id.tv_days_my_group);
        bt_view_local_my_group = rootView.findViewById(R.id.bt_view_local_my_group);
        grid_users_group = rootView.findViewById(R.id.grid_users_group);
    }

    private ImageView createImageView(int resId){
        GridLayout.LayoutParams lp = new GridLayout.LayoutParams();
        lp.setMargins(15,15,15,15);
        lp.height = 120;
        lp.width = 120;
        ImageView imageView1 = new ImageView(getActivity());
        RoundImage roundedImage;
        Bitmap bm = BitmapFactory.decodeResource(getResources(),  R.drawable.boy);
        roundedImage = new RoundImage(bm);
        imageView1.setImageDrawable(roundedImage);
        imageView1.setLayoutParams(lp);
        return imageView1;
    }

}

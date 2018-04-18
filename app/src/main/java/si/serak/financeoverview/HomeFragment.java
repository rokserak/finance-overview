package si.serak.financeoverview;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button bnAddStrosek, bnViewStrosek;
    private ListView dons;
    private TextView limit, seOstalLimit;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        bnAddStrosek = view.findViewById(R.id.bn_add_strosek);
        bnAddStrosek.setOnClickListener(this);

        bnViewStrosek = view.findViewById(R.id.bn_view_strosek);
        bnViewStrosek.setOnClickListener(this);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(view.getContext());





        dons = view.findViewById(R.id.dons);


        float vseSkupi = 0;

        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        List<Strosek> stroski = MainActivity.appDatabase.stroskiDao().getDanasnje(df.format(d));
        String[] ds = new String[stroski.size()];

        for (int i = 0; i < stroski.size(); i++) {
            int id = stroski.get(i).getSid();
            String vrsta = stroski.get(i).getVrstaStroska();
            float cena = stroski.get(i).getCena();

            vseSkupi += cena; //za kuk se ustane

            String datum = stroski.get(i).getDatum();
            ds[i] = " id: " + id + "\n vrsta: " + vrsta + "\n Cena: " + cena + "\n datum: " + datum;
        }


        ArrayAdapter adapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, ds);
        dons.setAdapter(adapter);

        List<Prihodek> prihodki = MainActivity.appDatabase.prihodekDao().getDanasnje(df.format(d));
        float skupajPlus = 0;

        for (int j = 0; j < prihodki.size(); j++) {
            skupajPlus += prihodki.get(j).getCena();
        }

        limit = view.findViewById(R.id.limit);

        float zelenLimit = Float.parseFloat(prefs.getString("limit", "0"));
        zelenLimit += skupajPlus;

        limit.setText("Dnevni limit: " + zelenLimit);

        seOstalLimit = view.findViewById(R.id.seOstalLimit);

        vseSkupi = Float.parseFloat(prefs.getString("limit", "0")) - vseSkupi + skupajPlus;

        seOstalLimit.setText("Do limita je še: " + vseSkupi);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bn_add_strosek:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmet_container, new AddStrosekFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.bn_view_strosek:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmet_container, new PregledFragment())
                        .addToBackStack(null).commit();
                break;
        }


    }
}

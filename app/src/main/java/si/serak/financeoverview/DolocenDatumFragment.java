package si.serak.financeoverview;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DolocenDatumFragment extends Fragment {

    private TextView zaDatum, prihranekZaDan;
    private ListView listZaDan;
    private PieChart graf;


    public DolocenDatumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_dolocen_datum, container, false);

        Bundle bundle = this.getArguments();

        String izbranDatum = bundle.getString("datum", "");

        zaDatum = view.findViewById(R.id.zaDatum);
        zaDatum.setText("Pregled za dan: " + izbranDatum);


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(view.getContext());

        listZaDan = view.findViewById(R.id.ListZaDan);

        List<Strosek> stroski = MainActivity.appDatabase.stroskiDao().getDanasnje(izbranDatum);

        String[] vs = new String[stroski.size()];

        float skupiCena = 0;

        List<PieEntry> pieEntries = new ArrayList<>();


        for (int i = 0; i < stroski.size(); i++) {
            int id = stroski.get(i).getSid();
            String vrsta = stroski.get(i).getVrstaStroska();
            float cena = stroski.get(i).getCena();

            skupiCena += cena;

            String datum = stroski.get(i).getDatum();
            vs[i] = " id: " + id + "\n vrsta: " + vrsta + "\n Cena: " + cena + "\n datum: " + datum;

            pieEntries.add(new PieEntry(cena, vrsta));

        }

        ArrayAdapter adapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, vs);
        listZaDan.setAdapter(adapter);


        List<Prihodek> prihodki = MainActivity.appDatabase.prihodekDao().getDanasnje(izbranDatum);
        float skupajPlus = 0;

        for (int j = 0; j < prihodki.size(); j++) {
            skupajPlus += prihodki.get(j).getCena();
        }

        prihranekZaDan = view.findViewById(R.id.prihranekZaDan);

        skupiCena = Float.parseFloat(prefs.getString("limit", "0")) - skupiCena + skupajPlus;

        prihranekZaDan.setText("Prihranek: " + skupiCena);


        PieDataSet dataSet = new PieDataSet(pieEntries, "pregled");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        PieData data = new PieData(dataSet);

        graf = view.findViewById(R.id.graf);
        graf.setData(data);
        graf.animate();
        graf.invalidate();




        return view;
    }


}

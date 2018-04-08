package si.serak.financeoverview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PregledFragment extends Fragment implements View.OnClickListener {

    private ListView vse;
    private Spinner izberiDatum;
    private Button pojdiNaDatum;


    public PregledFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregled, container, false);
        vse = view.findViewById(R.id.vse);

        List<Strosek> stroski = MainActivity.appDatabase.stroskiDao().getAll();

        String info = "";

        String[] vs = new String[stroski.size()];

        for (int i = 0; i < stroski.size(); i++) {
            int id = stroski.get(i).getSid();
            String vrsta = stroski.get(i).getVrstaStroska();
            float cena = stroski.get(i).getCena();
            String datum = stroski.get(i).getDatum();
            vs[i] = " id: " + id + "\n vrsta: " + vrsta + "\n Cena: " + cena + "\n datum: " + datum;
        }

        ArrayAdapter adapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, vs);
        vse.setAdapter(adapter);


        izberiDatum = view.findViewById(R.id.izberiDatum);
        List<Strosek> vsiDatumi = MainActivity.appDatabase.stroskiDao().getVseDatume();
        List<String> dat = new ArrayList<String>();

        for (Strosek str : vsiDatumi) {
            dat.add(str.getDatum());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_spinner_item, dat);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        izberiDatum.setAdapter(dataAdapter);

        pojdiNaDatum = view.findViewById(R.id.pojdiNaDatum);
        pojdiNaDatum.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pojdiNaDatum:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmet_container, new DolocenDatumFragment())
                        .addToBackStack(null).commit();
                break;

        }


    }





}

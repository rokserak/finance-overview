package si.serak.financeoverview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PregledFragment extends Fragment {

    private TextView txtInfo;


    public PregledFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregled, container, false);
        txtInfo = view.findViewById(R.id.display);

        List<Strosek> stroski = MainActivity.appDatabase.stroskiDao().getAll();

        String info = "";

        for (Strosek str : stroski) {
            int id = str.getSid();
            String vrsta = str.getVrstaStroska();
            float cena = str.getCena();
            info = info + "\n\n" + " id: " + id + "\n vrsta: " + vrsta + "\n Cena: " + cena;
        }

        txtInfo.setText(info);

        return view;
    }

}

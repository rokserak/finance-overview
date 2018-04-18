package si.serak.financeoverview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddPrihodek extends Fragment {

    private EditText vrsta, cena;
    private Button bnSave;


    public AddPrihodek() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_prihodek, container, false);
        vrsta = view.findViewById(R.id.vrsta);
        cena = view.findViewById(R.id.cena);
        bnSave = view.findViewById(R.id.dodajP);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v = vrsta.getText().toString();
                float c = Float.parseFloat(cena.getText().toString());

                Prihodek prihodek = new Prihodek();
                prihodek.setVrstaPrihodka(v);
                prihodek.setCena(c);

                Date d = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");


                prihodek.setDatum(df.format(d));

                MainActivity.appDatabase.prihodekDao().insertAll(prihodek);
                Toast.makeText(getActivity(), "prihodek uspesno dodan", Toast.LENGTH_SHORT).show();

                vrsta.setText("");
                cena.setText("");
            }
        });


        return view;
    }

}

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
public class AddStrosekFragment extends Fragment {

    private EditText vrsta, cena;
    private Button bnSave;


    public AddStrosekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_strosek, container, false);
        vrsta = view.findViewById(R.id.vrsta);
        cena = view.findViewById(R.id.cena);
        bnSave = view.findViewById(R.id.dodajS);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v = vrsta.getText().toString();
                float c = Float.parseFloat(cena.getText().toString());

                Strosek strosek = new Strosek();
                strosek.setVrstaStroska(v);
                strosek.setCena(c);

                Date d = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");


                strosek.setDatum(df.format(d));


                MainActivity.appDatabase.stroskiDao().insertAll(strosek);
                Toast.makeText(getActivity(), "strosek uspesno dodan", Toast.LENGTH_SHORT).show();

                vrsta.setText("");
                cena.setText("");
            }
        });


        return view;
    }

}

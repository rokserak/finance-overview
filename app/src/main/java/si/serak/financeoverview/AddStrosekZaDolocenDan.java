package si.serak.financeoverview;


import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddStrosekZaDolocenDan extends Fragment {

    private TextView datumPoIzbiri;
    private EditText vrsta, cena;
    private Button bnSave;

    private DatePickerDialog.OnDateSetListener dateSetListener;


    public AddStrosekZaDolocenDan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_strosek_za_dolocen_dan, container, false);


        vrsta = view.findViewById(R.id.vrsta);
        cena = view.findViewById(R.id.cena);
        bnSave = view.findViewById(R.id.dodajS);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v = vrsta.getText().toString();
                float c = Float.parseFloat(cena.getText().toString());
                String d = datumPoIzbiri.getText().toString();

                Strosek strosek = new Strosek();
                strosek.setVrstaStroska(v);
                strosek.setCena(c);
                strosek.setDatum(d);

                MainActivity.appDatabase.stroskiDao().insertAll(strosek);
                Toast.makeText(getActivity(), "strosek uspesno dodan", Toast.LENGTH_SHORT).show();

                vrsta.setText("");
                cena.setText("");
                datumPoIzbiri.setText("izberi datum");
            }
        });

        datumPoIzbiri = view.findViewById(R.id.datumPoIzbiri);


        datumPoIzbiri.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        view.getContext(),
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        dateSetListener,
                        year, month, day

                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.MAGENTA));
                dialog.show();

            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String s = day + "-" + month + "-" + year;
                datumPoIzbiri.setText(s);
            }
        };

        return view;
    }

}

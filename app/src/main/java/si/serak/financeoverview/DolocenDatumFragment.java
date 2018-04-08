package si.serak.financeoverview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DolocenDatumFragment extends Fragment {

    private TextView zaDatum, prihranekZaDan;
    private ListView listZaDan;


    public DolocenDatumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_dolocen_datum, container, false);

        zaDatum = view.findViewById(R.id.zaDatum);
        zaDatum.setText("Pregled za dan: ");


        prihranekZaDan = view.findViewById(R.id.prihranekZaDan);

        listZaDan = view.findViewById(R.id.ListZaDan);


        return view;
    }

}

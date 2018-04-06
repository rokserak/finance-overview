package si.serak.financeoverview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button bnAddStrosek, bnViewStrosek;

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

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bn_add_strosek:
                VnosActivity.fragmentManager.beginTransaction().replace(R.id.fragmet_container, new AddStrosekFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.bn_view_strosek:
                VnosActivity.fragmentManager.beginTransaction().replace(R.id.fragmet_container, new PregledFragment())
                        .addToBackStack(null).commit();
                break;
        }


    }
}

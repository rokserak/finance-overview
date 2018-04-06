package si.serak.financeoverview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class VnosActivity extends AppCompatActivity {

    public static android.support.v4.app.FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vnos);

        fragmentManager = getSupportFragmentManager();


        if (findViewById(R.id.fragmet_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            fragmentManager.beginTransaction().add(R.id.fragmet_container, new HomeFragment()).commit();
        }
    }
}

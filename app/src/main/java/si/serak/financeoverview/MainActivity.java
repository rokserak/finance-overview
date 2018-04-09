package si.serak.financeoverview;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static AppDatabase appDatabase;
    public static android.support.v4.app.FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "baza").allowMainThreadQueries().build();


        fragmentManager = getSupportFragmentManager();


        if (findViewById(R.id.fragmet_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            fragmentManager.beginTransaction().add(R.id.fragmet_container, new HomeFragment()).commit();
        }


    }

    public void goVnos(View view) {
        Intent intent = new Intent(this, VnosActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent s = new Intent(this, SettingsActivity.class);
            startActivity(s);
            return true;
        }

        return super.onOptionsItemSelected(item);


    }


}

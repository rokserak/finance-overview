package si.serak.financeoverview;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Rok Šerak on 02/04/2018.
 */


@Database(entities = {Strosek.class, Prihodek.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public abstract StroskiDao stroskiDao();

    public abstract PrihodekDao prihodekDao();
}

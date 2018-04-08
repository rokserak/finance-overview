package si.serak.financeoverview;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Rok Šerak on 02/04/2018.
 */

@Dao
public interface StroskiDao {
    @Query("SELECT * FROM stroski")
    List<Strosek> getAll();

    @Query("SELECT * FROM stroski WHERE datum = (:danasnjiDatum)")
    List<Strosek> getDanasnje(String danasnjiDatum);

    @Query("SELECT datum FROM stroski GROUP BY datum")
    List<Strosek> getVseDatume();

    @Update
    void update(Strosek strosek);

    @Insert
    void insertAll(Strosek... strosek);

    @Delete
    void delete(Strosek strosek);
}


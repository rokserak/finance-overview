package si.serak.financeoverview;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Rok Šerak on 18/04/2018.
 */

@Dao
public interface PrihodekDao {
    @Query("SELECT * FROM prihodki")
    List<Prihodek> getAll();

    @Query("SELECT * FROM prihodki WHERE datum = (:danasnjiDatum)")
    List<Prihodek> getDanasnje(String danasnjiDatum);

    @Query("SELECT datum FROM prihodki GROUP BY datum")
    List<Prihodek> getVseDatume();

    @Update
    void update(Prihodek prihodek);

    @Insert
    void insertAll(Prihodek... prihodek);

    @Delete
    void delete(Prihodek prihodek);
}
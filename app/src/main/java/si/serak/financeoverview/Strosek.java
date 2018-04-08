package si.serak.financeoverview;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rok Šerak on 02/04/2018.
 */

@Entity(tableName = "stroski")
public class Strosek {
    @PrimaryKey
    private Integer sid;

    @ColumnInfo(name = "vrstaStroska")
    private String vrstaStroska;


    @ColumnInfo(name = "cena")
    private Float cena;

    @ColumnInfo(name = "datum")
    private String datum;




    public Strosek() {
        this.sid = sid;
        this.vrstaStroska = vrstaStroska;
        this.datum = datum;

        this.cena = cena;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getVrstaStroska() {
        return vrstaStroska;
    }

    public void setVrstaStroska(String vrstaStroska) {
        this.vrstaStroska = vrstaStroska;
    }


    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }
}

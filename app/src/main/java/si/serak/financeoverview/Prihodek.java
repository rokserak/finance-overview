package si.serak.financeoverview;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rok Šerak on 18/04/2018.
 */

@Entity(tableName = "prihodki")
public class Prihodek {
    @PrimaryKey
    private Integer pid;

    @ColumnInfo(name = "vrstaPrihodka")
    private String vrstaPrihodka;


    @ColumnInfo(name = "cena")
    private Float cena;

    @ColumnInfo(name = "datum")
    private String datum;


    public Prihodek() {

        this.pid = pid;
        this.vrstaPrihodka = vrstaPrihodka;
        this.cena = cena;
        this.datum = datum;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getVrstaPrihodka() {
        return vrstaPrihodka;
    }

    public void setVrstaPrihodka(String vrstaPrihodka) {
        this.vrstaPrihodka = vrstaPrihodka;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }


}
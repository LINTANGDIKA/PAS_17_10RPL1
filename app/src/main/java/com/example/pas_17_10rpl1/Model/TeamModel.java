package com.example.pas_17_10rpl1.Model;

import java.io.Serializable;

public class TeamModel implements Serializable {
    public TeamModel(String nama, String notelp, String identitas, String gambar) {
        this.nama = nama;
        this.notelp = notelp;
        this.identitas = identitas;
        this.gambar = gambar;
    }

    private String nama, notelp, identitas, gambar;



    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getIdentitas() {
        return identitas;
    }

    public void setIdentitas(String identitas) {
        this.identitas = identitas;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}

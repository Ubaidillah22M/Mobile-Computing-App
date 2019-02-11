package com.juniansyah.json.Model;

/**
 * Created by asus on 2/10/2019.
 */

public class ModelData {
    String nim,nama,prodi,fakultas;
    public ModelData() {

    }

    public ModelData(String nim, String nama, String prodi, String fakultas) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.fakultas = fakultas;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
}

package tech.ezapp.ezadmin.Model;

import com.google.firebase.Timestamp;

public class Post {
    private String judul,deskripsi,requirement,status,poster;
    private long harga;
    private Timestamp timestamp;

    public Post(){

    }

    public Post(Timestamp timestamp,String judul, String deskripsi, String requirement, String status, String poster, long harga) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.requirement = requirement;
        this.status = status;
        this.poster = poster;
        this.harga = harga;
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }
}

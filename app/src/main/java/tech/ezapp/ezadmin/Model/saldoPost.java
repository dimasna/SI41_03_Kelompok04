package tech.ezapp.ezadmin.Model;

import com.google.firebase.Timestamp;

public class saldoPost {
    private String posting_title, posting_user;
    private long posting_coins;
    private Timestamp posting_date;

    public saldoPost(){ }

    public saldoPost(String posting_title, String posting_user, long posting_coins, Timestamp posting_date) {
        this.posting_title = posting_title;
        this.posting_user = posting_user;
        this.posting_coins = posting_coins;
        this.posting_date = posting_date;
    }

    public String getPosting_title() {
        return posting_title;
    }

    public void setPosting_title(String posting_title) {
        this.posting_title = posting_title;
    }

    public String getPosting_user() {
        return posting_user;
    }

    public void setPosting_user(String posting_user) {
        this.posting_user = posting_user;
    }

    public long getPosting_coins() {
        return posting_coins;
    }

    public void setPosting_coins(long posting_coins) {
        this.posting_coins = posting_coins;
    }

    public Timestamp getPosting_date() {
        return posting_date;
    }

    public void setPosting_date(Timestamp posting_date) {
        this.posting_date = posting_date;
    }
}

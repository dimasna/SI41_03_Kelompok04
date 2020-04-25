package tech.ezapp.ezadmin;


public class Model {

    private String description, waktu, title;

    public Model(String title, String description) {
        this.title = title;
        this.description = description;

    }


    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

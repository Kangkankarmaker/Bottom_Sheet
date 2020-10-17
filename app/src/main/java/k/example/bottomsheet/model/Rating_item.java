package k.example.bottomsheet.model;

public class Rating_item {

    float rating;
    String des,date;

    public Rating_item(float rating, String des, String date) {
        this.rating = rating;
        this.des = des;
        this.date = date;
    }

    public Rating_item() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}

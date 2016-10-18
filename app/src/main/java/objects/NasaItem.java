package objects;

/**
 * Created by juanlucena on 18/10/16.
 */
public class NasaItem {

    private String name;
    private String earthDate;

    public NasaItem(String earthDate, String imageURL, String name) {
        this.earthDate = earthDate;
        this.imageURL = imageURL;
        this.name = name;
    }

    private String imageURL;



    public String getEarthDate() {
        return earthDate;
    }

    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

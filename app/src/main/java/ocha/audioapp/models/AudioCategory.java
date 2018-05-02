package ocha.audioapp.models;

import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Muhammed Rasheed on 5/2/2018.
 */

@IgnoreExtraProperties
public class AudioCategory {

    public  String ID;
    public  String imgURL;
    public  String name;
    public  boolean published;


    public AudioCategory(String ID, String imgURL, String name, boolean published) {
        this.ID = ID;
        this.imgURL = imgURL;
        this.name = name;
        this.published = published;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("imageURL", imgURL);
        result.put("name", imgURL);
        result.put("published", imgURL);
        return result;
    }
}



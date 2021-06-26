package io.nextlevel.frontend.common;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Data //constructs getter/setter/constructor
@NoArgsConstructor
public class Card {
    private int id;
    String set;
    String german;
    String english;
    String turkish;
    String spanish;

    public Card(int id, String set, String german, String english, String turkish, String spanish){
        this.id = id;
        this.set = set.trim();
        this.german = german.trim();
        this.english = english.trim();
        this.turkish = turkish.trim();
        this.spanish = spanish.trim();
    }

    @Override
    public String toString() {
        return "ID: " + getId() +
                "\nGerman: " + getGerman() +
                "\nEnglish: " + getEnglish() +
                "\nTurkish: " + getTurkish() +
                "\nSpanish: " + getSpanish();
    }
    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("id", this.getId());
        json.put("set", this.getSet());
        json.put("german", this.getGerman());
        json.put("english", this.getEnglish());
        json.put("turkish", this.getTurkish());
        json.put("spanish", this.getSpanish());

        return json;
    }
}

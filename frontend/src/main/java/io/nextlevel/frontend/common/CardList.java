package io.nextlevel.frontend.common;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CardList {
    private List<Card> cards;

    public CardList() {
        cards = new ArrayList<>();
    }
    public JSONArray toJSON() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for(Card c : this.cards){
            JSONObject json = new JSONObject();
            json.put("id", c.getId());
            json.put("set", c.getSet());
            json.put("german", c.getGerman());
            json.put("english", c.getEnglish());
            json.put("turkish", c.getTurkish());
            json.put("spanish", c.getSpanish());
            jsonArray.put(json);
        }

        return jsonArray;
    }
}

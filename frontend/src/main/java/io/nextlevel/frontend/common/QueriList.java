package io.nextlevel.frontend.common;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QueriList {
    private List<Queri> queris;

    public QueriList() {
        queris = new ArrayList<>();
    }
    public JSONArray toJSON() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for(Queri q : this.queris){
            JSONObject json = new JSONObject();
            json.put("id", q.getId());
            json.put("ausgangLanguage", q.getAusgangLanguage());
            json.put("zielLanguage", q.getZielLanguage());
            json.put("ausgangWord", q.getAusgangWord());
            json.put("zielWord", q.getZielWord());
            json.put("difficulty", q.getDifficulty());
            jsonArray.put(json);
        }

        return jsonArray;
    }
}
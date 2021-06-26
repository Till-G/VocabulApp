package io.nextlevel.query.common;

import io.nextlevel.query.Entity.Queri;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Data
@NoArgsConstructor
public class QueriList {
    private Iterable<Queri> queris;

    public QueriList(Iterable<Queri> q) {
        this.queris = q;
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
package io.nextlevel.frontend.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Translate {
    private int id;
    private String ausgangLanguage;
    private String zielLanguage;
    private String ausgangWord;
    private String zielWord;

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("id", this.getId());
        json.put("ausgangLanguage", this.getAusgangLanguage());
        json.put("zielLanguage", this.getZielLanguage());
        json.put("ausgangWord", this.getAusgangWord());
        json.put("zielWord", this.getZielWord());

        return json;
    }
}

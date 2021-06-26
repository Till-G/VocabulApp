package io.nextlevel.frontend.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@NoArgsConstructor
@Data
public class Queri {
    private int id;
    private String ausgangLanguage;
    private String zielLanguage;
    private String ausgangWord;
    private String zielWord;
    private int difficulty;

    private static final int EASY = 4;
    private static final int MEDIUM = 6;
    private static final int HARD = 7;

    public Queri(int id, String ausgangLanguage, String zielLanguage, String ausgangWord, String zielWord, int difficulty){
        this.id = id;
        this.ausgangLanguage = ausgangLanguage;
        this.zielLanguage = zielLanguage;
        this.ausgangWord = ausgangWord;
        this.zielWord = zielWord;
        int wordLength;
        if(ausgangWord.length() > zielWord.length())
            wordLength = ausgangWord.length();
        else
            wordLength = zielWord.length();
        if(wordLength <= EASY)
            this.difficulty = EASY;
        else if(wordLength <= MEDIUM)
            this.difficulty = MEDIUM;
        else
            this.difficulty = HARD;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("id", this.getId());
        json.put("ausgangLanguage", this.getAusgangLanguage());
        json.put("zielLanguage", this.getZielLanguage());
        json.put("ausgangWord", this.getAusgangWord());
        json.put("zielWord", this.getZielWord());
        json.put("difficulty", this.getDifficulty());

        return json;
    }
    public JSONArray toJSONArray(Iterable<Queri> qList) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for(Queri q : qList){
            jsonArray.put(q.toJSON());
        }
        return jsonArray;
    }

}

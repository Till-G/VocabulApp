package io.nextlevel.frontend.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Translate {
    private int id;
    private String ausgangLanguage;
    private String zielLanguage;
    private String ausgangWord;
    private String zielWord;
}

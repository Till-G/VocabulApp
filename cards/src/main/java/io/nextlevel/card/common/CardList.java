package io.nextlevel.card.common;

import io.nextlevel.card.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CardList {
    private Iterable<Card> cards;

    public CardList(Iterable<Card> c) {
        cards = c;
    }
}

package io.nextlevel.card.common;

import io.nextlevel.card.entity.Card;

public class CardList {
    private Iterable<Card> cards;

    public CardList(Iterable<Card> c) {
        cards = c;
    }
}

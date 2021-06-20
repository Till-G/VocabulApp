package io.nextlevel.card.repository;

import io.nextlevel.card.entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {

    public Iterable<Card> findAllByGermanIsNotNull();
    public Iterable<Card> findAllByEnglishIsNotNull();
    public Iterable<Card> findAllByTurkishIsNotNull();
    public Iterable<Card> findAllBySpanishIsNotNull();
    public Card findById(int id);
    public Iterable<Card> findAllBySetIsNotNull();
}

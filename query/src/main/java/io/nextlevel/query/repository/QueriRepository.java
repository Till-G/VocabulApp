package io.nextlevel.query.repository;

import io.nextlevel.query.Entity.Queri;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueriRepository extends CrudRepository<Queri, Integer> {
    Queri getQueriByAusgangLanguageAndAusgangWord(String aLanguage, String aWord);
//    Query findByALanguageAndAWord(String aLanguage, String aWord);
//    Iterable<Query> getAllByALanguageAndZLanguageAndDifficulty(String aLanguage, String zLanguage, int difficulty);
}

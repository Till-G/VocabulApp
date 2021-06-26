package io.nextlevel.translate.repository;

import io.nextlevel.translate.entity.Translate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslateRepository extends CrudRepository<Translate, Integer> {
    Translate getTranslateByAusgangLanguageAndZielLanguageAndAusgangWord(String aLanguage, String zLanguage, String aWord);
    List<Translate> findAll();

}

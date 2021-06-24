package io.nextlevel.translate.repository;

import io.nextlevel.translate.entity.Translate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslateRepository extends CrudRepository<Translate, Integer> {
    Translate getTranslateByAusgangLanguageAndZielLanguageAndAusgangWord(String aLanguage, String zLanguage, String aWord);
}

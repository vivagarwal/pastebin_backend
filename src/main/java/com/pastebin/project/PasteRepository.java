package com.pastebin.project;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PasteRepository extends MongoRepository<PasteBin,String> {
    Optional<PasteBin> findByUniqueLink(String uniqueLink);

}

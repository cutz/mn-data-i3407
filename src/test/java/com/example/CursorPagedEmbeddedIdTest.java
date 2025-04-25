package com.example;

import io.micronaut.data.model.CursoredPage;
import io.micronaut.data.model.CursoredPageable;
import io.micronaut.data.model.Sort;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

@MicronautTest(startApplication = false)
class CursorPagedEmbeddedIdTest {

    @Inject
    AssetRepository assetRepository;

    @Test
    void demonstrateCantPage(){
        List<UUID> containers = List.of(UUID.randomUUID(), UUID.randomUUID());
        List<String> titles= List.of("title1", "title2", "title3");
        for(UUID containerId : containers){
            for(int i = 0; i < 10; i++){
                AssetId id = new AssetId(containerId, i);
                assetRepository.save(new Asset(id, titles.get(i% titles.size())));
            }
        }

        CursoredPage<Asset> page = assetRepository.findByIdContainerId(containers.get(0),
                CursoredPageable.from(3, Sort.of()));

        Assertions.assertEquals(page.getContent().size(), 3);
        Assertions.assertTrue(page.hasNext());

    }
}

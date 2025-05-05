package com.example;

import io.micronaut.test.annotation.Sql;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.UUID;

@MicronautTest
@Sql("classpath:create.sql")
class JoinColumnsTest {

    @Inject
    AssetRepository assetRepository;

    @Inject
    AssetManyToManyRepository assetManyToManyRepository;

    @Inject
    AssetMetadataRepository assetMetadataRepository;

    @Test
    void demonstrateOneToOneSaveFailure(Connection connection) {

        AssetId id = new AssetId(UUID.randomUUID(), 1);

        Asset asset = new Asset(id, "title", null);
        assetRepository.save(asset);
    }

    @Test
    void demonstrateOneToOneFetchFailure(Connection connection) {

        AssetId id = new AssetId(UUID.fromString("6f8d3ed4-46e3-4656-9e89-cd61ac1e4cf8"), 1);
        Asset asset = assetRepository.findById(id).orElseThrow();
        assert asset.metadata().author().equals("chris");
    }

    @Test
    void demonstrateJoinIssueWorksManyToMany(Connection connection){

        AssetId id = new AssetId(UUID.randomUUID(), 1);
        assetMetadataRepository.save(new AssetMetadata(id, "huey"));

        AssetManyToMany asset = new AssetManyToMany(id, "title", null);
        assetManyToManyRepository.save(asset);

        AssetManyToMany loadedWithJoin = assetManyToManyRepository.findById(id).orElseThrow();
        assert loadedWithJoin.metadata().getFirst().author().equals("huey");
    }
}

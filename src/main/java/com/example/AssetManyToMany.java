package com.example;

import io.micronaut.data.annotation.EmbeddedId;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import jakarta.annotation.Nullable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@MappedEntity("asset")
public record AssetManyToMany(
        @EmbeddedId
        AssetId id,

        String title,

        @Relation(value = Relation.Kind.ONE_TO_MANY, cascade = Relation.Cascade.NONE)
        @JoinColumn(name="container_id", referencedColumnName = "container_id")
        @JoinColumn(name="asset_id", referencedColumnName = "asset_id")
        List<AssetMetadata> metadata
) { }

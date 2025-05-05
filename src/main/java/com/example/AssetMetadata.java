package com.example;

import io.micronaut.data.annotation.EmbeddedId;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity("assetmetadata")
public record AssetMetadata(
        @EmbeddedId
        AssetId id,

        String author
){}
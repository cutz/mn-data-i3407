package com.example;

import io.micronaut.data.annotation.EmbeddedId;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity
public record Asset (
        @EmbeddedId
        AssetId id,

        String title
) { }

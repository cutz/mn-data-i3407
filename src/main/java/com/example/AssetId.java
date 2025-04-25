package com.example;

import io.micronaut.data.annotation.Embeddable;

import java.util.UUID;

@Embeddable
public record AssetId (UUID containerId, int assetId) { }

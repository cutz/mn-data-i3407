package com.example;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.repository.jpa.JpaSpecificationExecutor;

import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface AssetRepository extends CrudRepository<Asset, AssetId>, JpaSpecificationExecutor<Asset> {
    @Join("metadata")
    Optional<Asset> findById(AssetId id);
}

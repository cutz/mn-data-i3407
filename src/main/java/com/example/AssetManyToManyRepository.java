package com.example;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.repository.jpa.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface AssetManyToManyRepository extends CrudRepository<AssetManyToMany, AssetId>, JpaSpecificationExecutor<Asset> {

    @Join("metadata")
    Optional<AssetManyToMany> findById(AssetId id);
}

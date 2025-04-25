package com.example;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.CursoredPage;
import io.micronaut.data.model.CursoredPageable;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.repository.jpa.JpaSpecificationExecutor;

import java.util.UUID;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface AssetRepository extends CrudRepository<Asset, AssetId>, JpaSpecificationExecutor<Asset> {

    CursoredPage<Asset> findByIdContainerId(UUID id, CursoredPageable pageable);
}

create table asset (
   container_id    UUID         not null,
   asset_id        INTEGER      NOT NULL,
    title text
);

create table assetmetadata (
                       container_id    UUID         not null,
                       asset_id        INTEGER      NOT NULL,
                       author text
);
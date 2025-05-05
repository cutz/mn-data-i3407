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

insert into assetmetadata (container_id, asset_id, author) values ('6f8d3ed4-46e3-4656-9e89-cd61ac1e4cf8'::uuid, 1, 'chris');
insert into asset (container_id, asset_id, title) values ('6f8d3ed4-46e3-4656-9e89-cd61ac1e4cf8'::uuid, 1, 'Llama Llama');
create table intellij_test.user
(
    id       bigint       not null
        primary key,
    name     varchar(255) null,
    human_id bigint       null,
    constraint UK_pc9iwufab3fnairwr4tgnjccu
        unique (human_id),
    constraint FKdlbv9ujapq8mv4w343p91uk2c
        foreign key (human_id) references intellij_test.human (id)
);


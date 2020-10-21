--liquibase formatted sql

--changeset evgen:0010

create table book
(
    id       bigserial,
    title    varchar(255) not null,
    created  timestamp not null,
    modified timestamp not null,
    constraint book_pk
        primary key (id)
);

create table author
(
    id          bigserial,
    first_name  varchar(255) not null,
    second_name varchar(255),
    last_name   varchar(255),
    created     timestamp not null,
    modified    timestamp not null,
    constraint author_pk
        primary key (id)
);

create table tag
(
    id       bigserial,
    name     varchar(255) not null,
    created  timestamp not null,
    modified timestamp not null,
    constraint catalog_pk
        primary key (id)
);

create table books_authors
(
    book_id   bigint not null,
    author_id bigint not null,
    constraint authors_books_pk
        primary key (book_id, author_id),
    constraint authors_books_book_id_fk
        foreign key (book_id) references book,
    constraint authors_books_author_id_fk
        foreign key (author_id) references author
);

create table books_tags
(
    book_id bigint not null,
    tag_id  bigint not null,
    constraint catalogs_books_pk
        primary key (book_id, tag_id),
    constraint catalogs_books_book_id_fk
        foreign key (book_id) references book,
    constraint catalogs_books_catalog_id_fk
        foreign key (tag_id) references tag
);

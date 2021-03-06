drop database storytelling;
create database storytelling;
use storytelling;
create table utente
(
    email    varchar(300) not null
        primary key,
    password varchar(128)  not null,
    username varchar(20)  not null,
    constraint Utente_username_uindex
        unique (username)
);

create table storia
(
    id            int auto_increment
        primary key,
    username      varchar(20)  not null,
    contenuto     varchar(512) not null,
    nReazioni     int          not null,
    nCommenti     int          not null,
    dataCreazione date         not null,

    foreign key (username) references utente(username)
        on delete cascade on update cascade
);

create table commento
(
    id        int auto_increment
        primary key,
    idStoria  int          not null,
    username  varchar(300) not null,
    contenuto varchar(128) not null,
    constraint idStoria
        foreign key (idStoria) references storia (id)
            on update cascade on delete cascade,
    constraint username
        foreign key (username) references utente (username)
            on update cascade on delete cascade
);

create table reazione
(
    idStoria    int          not null,
    emailUtente varchar(300) not null,
    primary key (idStoria, emailUtente),
    constraint reazione_ibfk_1
        foreign key (emailUtente) references utente (email)
            on update cascade on delete cascade,
    constraint reazione_ibfk_2
        foreign key (idStoria) references storia (id)
            on update cascade on delete cascade
);

create index emailUtente
    on reazione (emailUtente);

CREATE TRIGGER aggiorna_nReazioniAdd AFTER INSERT ON reazione
    FOR EACH ROW
    UPDATE storia s SET nReazioni = nReazioni+1  WHERE s.id = NEW.idStoria;

CREATE TRIGGER aggiorna_nCommentiAdd AFTER INSERT ON commento
    FOR EACH ROW
    UPDATE storia s SET nCommenti = nCommenti+1  WHERE s.id = NEW.idStoria;

CREATE TRIGGER aggiorna_nReazioniRem AFTER DELETE ON reazione
    FOR EACH ROW
    UPDATE storia s SET nReazioni = nReazioni-1  WHERE s.id = OLD.idStoria;

CREATE TRIGGER aggiorna_nCommentiRem AFTER DELETE ON commento
    FOR EACH ROW
    UPDATE storia s SET nCommenti = nCommenti-1  WHERE s.id = OLD.idStoria;


create table gerente(
    idGerente number(10) not null,
    descGerente varchar2(50),
    fechaRegistro date,
    primary key(idGerente)
);

create table condicion(
    idCondicion number(10) not null,
    descCondicion varchar2(50),
    fechaRegistro date,
    primary key(idCondicion)
);

create table sede(
    idSede number(10) not null,
    descSede varchar2(50),
    fechaRegistro date,
    primary key(idSede)
);

create table provincia(
    idProvincia number(10) not null,
    descProvincia varchar2(50),
    fechaRegistro date,
    primary key(idProvincia)
);

create table distrito(
    idDistrito number(10) not null,
    idProvincia number(10),
    descDistrito varchar2(50),
    fechaRegistro date,
    primary key(idDistrito)
);

alter table distrito
add constraint FK_distrito_idProvincia
  foreign key (idProvincia)
  references provincia(idProvincia);
  
create table hospital(
    idHospital number(10) not null,
    nombre varchar2(50) not null,
    antiguedad number(10) not null,
    area number(7,2) not null,
    fechaRegistro date not null,
    idDistrito number(10) not null,
    idSede number(10) not null,
    idGerente number(10) not null,
    idCondicion number(10) not null,
    primary key(idHospital)
);

alter table hospital
add constraint FK_hospital_idDistrito
  foreign key (idDistrito)
  references distrito(idDistrito);
  
alter table hospital
add constraint FK_hospital_idSede
  foreign key (idSede)
  references sede(idSede);
  
alter table hospital
add constraint FK_hospital_idGerente
  foreign key (idGerente)
  references gerente(idGerente);
  
alter table hospital
add constraint FK_hospital_idCondicion
  foreign key (idCondicion)
  references condicion(idCondicion);
  
--RELACION DE UNO A UNO
/*
alter table hospital
  add constraint UQ_hospital_idGerenteUnica
  unique (idGerente);
*/
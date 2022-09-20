create table usuarios(
    id number(5) not null,
    username varchar2(45),
    password varchar2(100),
    estatus number(1),
    primary key(id)
);

create table perfiles(
    id number(5) not null,
    perfil varchar2(45),
    primary key(id)
);

create table usuarioperfil(
    idUsuario number(5) not null,
    idPerfil number(5) not null,
    primary key(idUsuario, idPerfil)
);

insert into usuarios(id, username, password, estatus) values(1, 'administradorTS', '$2a$10$xTbp7nC.ePf6u0UlqTmpYODXU0ZpHQrTd5AU/JvkZ9ZuDeNRhRKDa', 1);
insert into usuarios(id, username, password, estatus) values(2, 'supervisorTS', '$2a$10$beYrqkOdBhaBomWazTMdB.oiVBB2M6yf/9rV9BnOjjI43xnZ3TeWi', 1);
select * from usuarios;

insert into perfiles(id, perfil) values(1, 'ADMINISTRADOR');
insert into perfiles(id, perfil) values(2, 'SUPERVISOR');
select * from perfiles;

insert into usuarioperfil(idUsuario, idPerfil) values(1, 1);
insert into usuarioperfil(idUsuario, idPerfil) values(2, 2);
select * from usuarioperfil;
-- TABLA GERENTE: select * from gerente;
insert into gerente(idGerente, descGerente, fechaRegistro) values(1, 'F�lix Garc�a Ahumada', '15/09/2022');
insert into gerente(idGerente, descGerente, fechaRegistro) values(2, 'William Salazar Loconi', '22/06/2020');
insert into gerente(idGerente, descGerente, fechaRegistro) values(3, 'Oscar Saavedra Carrasco', '12/09/2022');
insert into gerente(idGerente, descGerente, fechaRegistro) values(4, 'Pastor Rojas Diaz', '19/11/2021');
insert into gerente(idGerente, descGerente, fechaRegistro) values(5, 'Nelson Ruiz Julca', '23/02/2020');
insert into gerente(idGerente, descGerente, fechaRegistro) values(6, 'Juan Pugliese Salazar', '16/09/2022');
insert into gerente(idGerente, descGerente, fechaRegistro) values(7, 'Rafael Cusma Edilberto', '05/08/2021');
insert into gerente(idGerente, descGerente, fechaRegistro) values(8, 'Julian P�rez Damasco', '17/09/2022');

-- TABLA CONDICION: select * from condicion;
insert into condicion(idCondicion, descCondicion, fechaRegistro) values(1, 'ACTIVO', '15/09/2022');
insert into condicion(idCondicion, descCondicion, fechaRegistro) values(2, 'INHABILITADO', '16/09/2022');
insert into condicion(idCondicion, descCondicion, fechaRegistro) values(3, 'CLAUSURADO', '16/09/2022');

-- TABLA SEDE: select * from sede;
insert into sede(idSede, descSede, fechaRegistro) values(1, 'CENTRAL', '15/09/2022');
insert into sede(idSede, descSede, fechaRegistro) values(2, 'NORTE', '15/09/2022');
insert into sede(idSede, descSede, fechaRegistro) values(3, 'SUR', '15/09/2022');

-- TABLA PROVINCIA: select * from provincia;
insert into provincia(idProvincia, descprovincia, fechaRegistro) values(1, 'Chiclayo', '15/09/2022');
insert into provincia(idProvincia, descprovincia, fechaRegistro) values(2, 'Ferre�afe', '15/09/2022');
insert into provincia(idProvincia, descprovincia, fechaRegistro) values(3, 'Lambayeque', '15/09/2022');

-- TABLA PROVINCIA: select * from distrito;
insert into distrito(idDistrito, idProvincia, descDistrito, fechaRegistro) values(1, 1, 'La Victoria', '16/09/2022');
insert into distrito(idDistrito, idProvincia, descDistrito, fechaRegistro) values(2, 1, 'Pimentel', '16/09/2022');
insert into distrito(idDistrito, idProvincia, descDistrito, fechaRegistro) values(3, 1, 'Jos� Leonardo O.', '16/09/2022');
insert into distrito(idDistrito, idProvincia, descDistrito, fechaRegistro) values(4, 2, 'Ferre�afe', '16/09/2022');
insert into distrito(idDistrito, idProvincia, descDistrito, fechaRegistro) values(5, 2, 'Incahuasi', '16/09/2022');
insert into distrito(idDistrito, idProvincia, descDistrito, fechaRegistro) values(6, 2, 'Ca�aris', '16/09/2022');
insert into distrito(idDistrito, idProvincia, descDistrito, fechaRegistro) values(7, 3, 'Lambayeque', '15/09/2022');
insert into distrito(idDistrito, idProvincia, descDistrito, fechaRegistro) values(8, 3, 'M�rrope', '15/09/2022');
insert into distrito(idDistrito, idProvincia, descDistrito, fechaRegistro) values(9, 3, 'Jayanca', '15/09/2022');

-- TABLA PROVINCIA: select * from hospital;
insert into hospital(idHospital, nombre, antiguedad, area, fechaRegistro, idDistrito, idSede, idGerente, idCondicion) 
        values(1, 'Hospital Belen de Lambayeque', 102, 1400.0, '15/09/2022', 7, 2, 1, 1);
insert into hospital(idHospital, nombre, antiguedad, area, fechaRegistro, idDistrito, idSede, idGerente, idCondicion) 
        values(2, 'Cl�nica Metropolitana', 8, 460.8, '15/09/2022', 1, 1, 2, 1);
insert into hospital(idHospital, nombre, antiguedad, area, fechaRegistro, idDistrito, idSede, idGerente, idCondicion) 
        values(3, 'Servimed Per�', 35, 350.9, '15/09/2022', 3, 1, 3, 3);
insert into hospital(idHospital, nombre, antiguedad, area, fechaRegistro, idDistrito, idSede, idGerente, idCondicion) 
        values(4, 'Cl�nica Nuestra Se�or De La Misericordia', 15, 390.8, '15/09/2022', 4, 2, 4, 1);
insert into hospital(idHospital, nombre, antiguedad, area, fechaRegistro, idDistrito, idSede, idGerente, idCondicion) 
        values(5, 'Clinica Urosalud', 42, 608.0, '15/09/2022', 2, 3, 5, 2);
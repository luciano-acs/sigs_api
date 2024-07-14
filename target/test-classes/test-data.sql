INSERT INTO rol_usuario (rol_usuarioid, descripcion) VALUES (100, 'ROLE_USER');

INSERT INTO grado (gradoid, grado) VALUES (100, 'Grado Inicial');

INSERT INTO comisaria (comisariaid, nombre) VALUES (100, 'Comisaria Central');

INSERT INTO distrito (distritoid, nombre) VALUES (100, 'Distrito 100');

INSERT INTO personal (personalid, ape_ynom, cargo, visible, gradoid, comisariaid, distritoid, rol_usuarioid, username, password)
VALUES ('ABCD1234', 'Prueba Prueba', 1234, 10, 100, 100, 100, 100, 'prueba1234', 'kjdsfnalkjbsd<flajjdblf');

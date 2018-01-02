INSERT INTO GrupoUsuario (idGrupoUsuario, nombreGrupo) VALUES (1, "ADMINISTRADORES");
INSERT INTO GrupoUsuario (idGrupoUsuario, nombreGrupo) VALUES (2, "LIDERES");
INSERT INTO GrupoUsuario (idGrupoUsuario, nombreGrupo) VALUES (3, "DESARROLLADORES");

INSERT INTO Usuario(clave, mail, ID_GRUPO) VALUES ("admin","admin@mail.com",1);
INSERT INTO Usuario(clave, mail, ID_GRUPO) VALUES ("1234", "lider1@mail.com", 2);
INSERT INTO Usuario(clave, mail, ID_GRUPO) VALUES ("1234", "lider2@mail.com", 2);
INSERT INTO Usuario(clave, mail, ID_GRUPO) VALUES ("1234", "desarrollador1@mail.com", 3);
INSERT INTO Usuario(clave, mail, ID_GRUPO) VALUES ("1234", "desarrollador2@mail.com", 3);
INSERT INTO Usuario(clave, mail, ID_GRUPO) VALUES ("1234", "desarrollador3@mail.com", 3);
INSERT INTO Usuario(clave, mail, ID_GRUPO) VALUES ("1234", "desarrollador4@mail.com", 3);
INSERT INTO Usuario(clave, mail, ID_GRUPO) VALUES ("1234", "desarrollador5@mail.com", 3);


INSERT INTO Proyecto (costo, HORAS_PRESUPUESTADAS, ID_USUARIO_LIDER) VALUES (5000, 120, 2);
INSERT INTO Proyecto (costo, HORAS_PRESUPUESTADAS, ID_USUARIO_LIDER) VALUES (3300, 50, 3);
INSERT INTO Proyecto (costo, HORAS_PRESUPUESTADAS, ID_USUARIO_LIDER) VALUES (2000, 35, 3);
INSERT INTO Proyecto (costo, HORAS_PRESUPUESTADAS, ID_USUARIO_LIDER) VALUES (8000, 180, 2);

INSERT INTO Tarea (descripcion, DURACION, FECHA_INICIO, titulo, ID_CATEGORIA, ID_PROYECTO, ID_USUARIO) VALUES ("<p>Tarea </p><p><strong>Hacer algo<u>Paso 1</u><em><u>Paso 2</u></em></strong></p>", 4, NULL, "Tarea 1", NULL, 1, 4);
INSERT INTO Tarea (descripcion, DURACION, FECHA_INICIO, titulo, ID_CATEGORIA, ID_PROYECTO, ID_USUARIO) VALUES ("<p>Tarea </p><p><strong>Hacer algo<u>Paso 1</u><em><u>Paso 2</u></em></strong></p>", 6, NULL, "Tarea 2", NULL, 2, 6);
INSERT INTO Tarea (descripcion, DURACION, FECHA_INICIO, titulo, ID_CATEGORIA, ID_PROYECTO, ID_USUARIO) VALUES ("<p>Tarea </p><p><strong>Hacer algo<u>Paso 1</u><em><u>Paso 2</u></em></strong></p>", 8, NULL, "Tarea 3", NULL, 3, 8);
INSERT INTO Tarea (descripcion, DURACION, FECHA_INICIO, titulo, ID_CATEGORIA, ID_PROYECTO, ID_USUARIO) VALUES ("<p>Tarea </p><p><strong>Hacer algo<u>Paso 1</u><em><u>Paso 2</u></em></strong></p>", 4, NULL, "Tarea 4", NULL, 4, 5);
INSERT INTO Tarea (descripcion, DURACION, FECHA_INICIO, titulo, ID_CATEGORIA, ID_PROYECTO, ID_USUARIO) VALUES ("<p>Tarea </p><p><strong>Hacer algo<u>Paso 1</u><em><u>Paso 2</u></em></strong></p>", 3, NULL, "Tarea 5", NULL, 4, 7);
INSERT INTO Tarea (descripcion, DURACION, FECHA_INICIO, titulo, ID_CATEGORIA, ID_PROYECTO, ID_USUARIO) VALUES ("<p>Tarea </p><p><strong>Hacer algo<u>Paso 1</u><em><u>Paso 2</u></em></strong></p>", 6, NULL, "Tarea 6", NULL, 3, 4);
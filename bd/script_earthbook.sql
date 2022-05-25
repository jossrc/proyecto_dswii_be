 DROP DATABASE IF EXISTS earthbook;
CREATE DATABASE earthbook;
USE earthbook;

CREATE TABLE ROL(
  id     	     TINYINT          PRIMARY KEY AUTO_INCREMENT, 
  nombre    	 VARCHAR(100)     NOT NULL,
  descripcion    VARCHAR(250)     NULL
);

CREATE TABLE PAIS(
  id		SMALLINT			PRIMARY KEY AUTO_INCREMENT,
  nombre    VARCHAR(350)        NOT NULL
);

-- ADMIN, VISOR
CREATE TABLE USUARIO(
  id      		 	  INT         		PRIMARY KEY AUTO_INCREMENT, 
  nombres    	 	  VARCHAR(350)  	NOT NULL,
  apellidos    	 	  VARCHAR(350)		NOT NULL,
  direccion		  	  VARCHAR(150) 		NULL,
  email 		  	  VARCHAR(100)	 	NOT NULL UNIQUE,
  `password`  	  	  VARCHAR(50)  	 	NOT NULL,
  estado  		  	  BOOLEAN    		NOT NULL DEFAULT TRUE,
  imagen 		  	  VARCHAR(1000)	 	NOT NULL DEFAULT "https://res.cloudinary.com/dfuuywyk9/image/upload/v1621437436/l60Hf_megote.png",
  id_rol	 		  TINYINT	 		NOT NULL DEFAULT 2,
  id_pais 			  SMALLINT			NOT NULL,
  fecha_creacion      TIMESTAMP		    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  fecha_actualizacion TIMESTAMP		    NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
  FOREIGN KEY (id_rol) REFERENCES ROL (id),
  FOREIGN KEY (id_pais) REFERENCES PAIS (id)
);

CREATE TABLE CATEGORIA
(
    id          INT           PRIMARY KEY AUTO_INCREMENT,
    nombre      VARCHAR(150)  NOT NULL UNIQUE,
    descripcion VARCHAR(250)  NULL,
    imagen 	    VARCHAR(1000) NOT NULL DEFAULT ""
);

CREATE TABLE AUTOR
(
    id               INT           PRIMARY KEY AUTO_INCREMENT,
    nombre_completo  VARCHAR(30)   NOT NULL,
    biografia        VARCHAR(255)  NULL,
    imagen         	 VARCHAR(1000) NOT NULL DEFAULT "https://res.cloudinary.com/dfuuywyk9/image/upload/v1621437436/l60Hf_megote.png",
    id_pais			 SMALLINT      NULL,
    FOREIGN KEY (id_pais) REFERENCES PAIS (id)
);

CREATE TABLE EDITORIAL
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    nombre      VARCHAR(150)  NOT NULL UNIQUE,
    descripcion VARCHAR(250)  NULL
);

CREATE TABLE LIBRO
(
    id            INT             PRIMARY KEY AUTO_INCREMENT,
    ISBN		  VARCHAR(20)		NOT NULL UNIQUE,
    SKU			  VARCHAR(30)		NOT NULL UNIQUE,
    titulo        VARCHAR(150)    NOT NULL,
    descripcion   VARCHAR(350)    NULL,
    paginas       INT             NOT NULL CHECK (paginas >= 0),
	imagen   	VARCHAR(1000)   NOT NULL DEFAULT "https://res.cloudinary.com/dvkoqncw8/image/upload/v1653154230/istockphoto-949082660-170667a_of7deo.jpg",
    id_autor           INT			NOT NULL,
    id_editorial       INT			NOT NULL,
    id_categoria       INT			NOT NULL,
    FOREIGN KEY (id_autor)     REFERENCES AUTOR (id),
	FOREIGN KEY (id_editorial) REFERENCES EDITORIAL (id),
    FOREIGN KEY (id_categoria) REFERENCES CATEGORIA (id)
);

CREATE TABLE COMENTARIO (
  id 			INT     PRIMARY KEY AUTO_INCREMENT,
  comentario    VARCHAR(255)  NOT NULL,
  id_usuario   INT     NOT NULL,
  id_libro     INT     NOT NULL,
  FOREIGN KEY (id_usuario) REFERENCES USUARIO (id),
  FOREIGN KEY (id_libro) REFERENCES LIBRO (id)
);

CREATE TABLE CALIFICACION (
   id 			INT     PRIMARY KEY AUTO_INCREMENT,
   valor        DECIMAL NOT NULL CHECK (valor >= 0),
   id_usuario   INT     NOT NULL,
   id_libro     INT     NOT NULL,
   FOREIGN KEY (id_usuario) REFERENCES USUARIO (id),
   FOREIGN KEY (id_libro) REFERENCES LIBRO (id)
);

CREATE TABLE FAVORITOS
(
  id 			INT  PRIMARY KEY AUTO_INCREMENT,
  id_usuario    INT  NOT NULL,
  id_libro      INT  NOT NULL,
  FOREIGN KEY (id_usuario) REFERENCES USUARIO (id),
  FOREIGN KEY (id_libro) REFERENCES LIBRO (id)
);

-- ROLES
INSERT INTO ROL (`nombre`, `descripcion`) VALUES ('ADMIN', 'Tiene control total de la información');
INSERT INTO ROL (`nombre`, `descripcion`) VALUES ('USUARIO', 'Puede ver, agregar favoritos, etc.');
select * from rol;
-- CATEGORIA
INSERT INTO CATEGORIA (`id`,`nombre`,`descripcion`,`imagen`) VALUES 
(1,'ARTE',NULL,'https://res.cloudinary.com/dlvfkjwpg/image/upload/v1636814000/samples/ecommerce/EarthBook-Categoria/HistoriadelArte_gcubym.jpg');
INSERT INTO CATEGORIA (`id`,`nombre`,`descripcion`,`imagen`) VALUES 
(2,'CIENCIAS',NULL,'https://res.cloudinary.com/dlvfkjwpg/image/upload/v1636814003/samples/ecommerce/EarthBook-Categoria/mujeres-cientificas_yqbdkg.jpg');
INSERT INTO CATEGORIA (`id`,`nombre`,`descripcion`,`imagen`) VALUES 
(3,'NOVELAS',NULL,'https://res.cloudinary.com/dlvfkjwpg/image/upload/v1636814004/samples/ecommerce/EarthBook-Categoria/Don-Quijote_lbjo7p.jpg');
INSERT INTO CATEGORIA (`id`,`nombre`,`descripcion`,`imagen`) VALUES 
(4,'COMICS',NULL,'https://res.cloudinary.com/dlvfkjwpg/image/upload/v1636814001/samples/ecommerce/EarthBook-Categoria/marvel-comics_bsdr63.jpg');
INSERT INTO CATEGORIA (`id`,`nombre`,`descripcion`,`imagen`) VALUES 
(5,'MANGA',NULL,'https://res.cloudinary.com/dlvfkjwpg/image/upload/v1636814001/samples/ecommerce/EarthBook-Categoria/satan_rsdxrg.jpg');
INSERT INTO CATEGORIA (`id`,`nombre`,`descripcion`,`imagen`) VALUES 
(6,'COCINA',NULL,'https://res.cloudinary.com/dlvfkjwpg/image/upload/v1636814002/samples/ecommerce/EarthBook-Categoria/cocina_vwfkkj.jpg');
INSERT INTO CATEGORIA (`id`,`nombre`,`descripcion`,`imagen`) VALUES 
(7,'TERROR',NULL,'https://res.cloudinary.com/dlvfkjwpg/image/upload/v1636814000/samples/ecommerce/EarthBook-Categoria/IT_srfxtq.jpg');
INSERT INTO CATEGORIA (`id`,`nombre`,`descripcion`,`imagen`) VALUES 
(8,'JUVENIL',NULL,'https://res.cloudinary.com/dlvfkjwpg/image/upload/v1636814002/samples/ecommerce/EarthBook-Categoria/a-dos-metros-de-ti_pcedgs.jpg');
INSERT INTO CATEGORIA (`id`,`nombre`,`descripcion`,`imagen`) VALUES 
(9,'NEGOCIOS',NULL,'https://res.cloudinary.com/dlvfkjwpg/image/upload/v1636814003/samples/ecommerce/EarthBook-Categoria/Business_udkdio.jpg');
INSERT INTO CATEGORIA (`id`,`nombre`,`descripcion`,`imagen`) VALUES 
(10,'PLAN LECTOR',NULL,'https://res.cloudinary.com/dlvfkjwpg/image/upload/v1636814000/samples/ecommerce/EarthBook-Categoria/ElGatoGarabato_jnih5l.jpg');

-- PAIS
INSERT INTO PAIS VALUES (NULL,'Afganistán');
INSERT INTO PAIS VALUES (NULL,'Islas Gland');
INSERT INTO PAIS VALUES (NULL,'Albania');
INSERT INTO PAIS VALUES (NULL,'Alemania');
INSERT INTO PAIS VALUES (NULL,'Andorra');
INSERT INTO PAIS VALUES (NULL,'Angola');
INSERT INTO PAIS VALUES (NULL,'Anguilla');
INSERT INTO PAIS VALUES (NULL,'Antártida');
INSERT INTO PAIS VALUES (NULL,'Antigua y Barbuda');
INSERT INTO PAIS VALUES (NULL,'Antillas Holandesas');
INSERT INTO PAIS VALUES (NULL,'Arabia Saudí');
INSERT INTO PAIS VALUES (NULL,'Argelia');
INSERT INTO PAIS VALUES (NULL,'Argentina');
INSERT INTO PAIS VALUES (NULL,'Armenia');
INSERT INTO PAIS VALUES (NULL,'Aruba');
INSERT INTO PAIS VALUES (NULL,'Australia');
INSERT INTO PAIS VALUES (NULL,'Austria');
INSERT INTO PAIS VALUES (NULL,'Azerbaiyán');
INSERT INTO PAIS VALUES (NULL,'Bahamas');
INSERT INTO PAIS VALUES (NULL,'Bahréin');
INSERT INTO PAIS VALUES (NULL,'Bangladesh');
INSERT INTO PAIS VALUES (NULL,'Barbados');
INSERT INTO PAIS VALUES (NULL,'Bielorrusia');
INSERT INTO PAIS VALUES (NULL,'Bélgica');
INSERT INTO PAIS VALUES (NULL,'Belice');
INSERT INTO PAIS VALUES (NULL,'Benin');
INSERT INTO PAIS VALUES (NULL,'Bermudas');
INSERT INTO PAIS VALUES (NULL,'Bhután');
INSERT INTO PAIS VALUES (NULL,'Bolivia');
INSERT INTO PAIS VALUES (NULL,'Bosnia y Herzegovina');
INSERT INTO PAIS VALUES (NULL,'Botsuana');
INSERT INTO PAIS VALUES (NULL,'Isla Bouvet');
INSERT INTO PAIS VALUES (NULL,'Brasil');
INSERT INTO PAIS VALUES (NULL,'Brunéi');
INSERT INTO PAIS VALUES (NULL,'Bulgaria');
INSERT INTO PAIS VALUES (NULL,'Burkina Faso');
INSERT INTO PAIS VALUES (NULL,'Burundi');
INSERT INTO PAIS VALUES (NULL,'Cabo Verde');
INSERT INTO PAIS VALUES (NULL,'Islas Caimán');
INSERT INTO PAIS VALUES (NULL,'Camboya');
INSERT INTO PAIS VALUES (NULL,'Camerún');
INSERT INTO PAIS VALUES (NULL,'Canadá');
INSERT INTO PAIS VALUES (NULL,'República Centroafricana');
INSERT INTO PAIS VALUES (NULL,'Chad');
INSERT INTO PAIS VALUES (NULL,'República Checa');
INSERT INTO PAIS VALUES (NULL,'Chile');
INSERT INTO PAIS VALUES (NULL,'China');
INSERT INTO PAIS VALUES (NULL,'Chipre');
INSERT INTO PAIS VALUES (NULL,'Isla de Navidad');
INSERT INTO PAIS VALUES (NULL,'Ciudad del Vaticano');
INSERT INTO PAIS VALUES (NULL,'Islas Cocos');
INSERT INTO PAIS VALUES (NULL,'Colombia');
INSERT INTO PAIS VALUES (NULL,'Comoras');
INSERT INTO PAIS VALUES (NULL,'República Democrática del Congo');
INSERT INTO PAIS VALUES (NULL,'Congo');
INSERT INTO PAIS VALUES (NULL,'Islas Cook');
INSERT INTO PAIS VALUES (NULL,'Corea del Norte');
INSERT INTO PAIS VALUES (NULL,'Corea del Sur');
INSERT INTO PAIS VALUES (NULL,'Costa de Marfil');
INSERT INTO PAIS VALUES (NULL,'Costa Rica');
INSERT INTO PAIS VALUES (NULL,'Croacia');
INSERT INTO PAIS VALUES (NULL,'Cuba');
INSERT INTO PAIS VALUES (NULL,'Dinamarca');
INSERT INTO PAIS VALUES (NULL,'Dominica');
INSERT INTO PAIS VALUES (NULL,'República Dominicana');
INSERT INTO PAIS VALUES (NULL,'Ecuador');
INSERT INTO PAIS VALUES (NULL,'Egipto');
INSERT INTO PAIS VALUES (NULL,'El Salvador');
INSERT INTO PAIS VALUES (NULL,'Emiratos Árabes Unidos');
INSERT INTO PAIS VALUES (NULL,'Eritrea');
INSERT INTO PAIS VALUES (NULL,'Eslovaquia');
INSERT INTO PAIS VALUES (NULL,'Eslovenia');
INSERT INTO PAIS VALUES (NULL,'España');
INSERT INTO PAIS VALUES (NULL,'Islas ultramarinas de Estados Unidos');
INSERT INTO PAIS VALUES (NULL,'Estados Unidos');
INSERT INTO PAIS VALUES (NULL,'Estonia');
INSERT INTO PAIS VALUES (NULL,'Etiopía');
INSERT INTO PAIS VALUES (NULL,'Islas Feroe');
INSERT INTO PAIS VALUES (NULL,'Filipinas');
INSERT INTO PAIS VALUES (NULL,'Finlandia');
INSERT INTO PAIS VALUES (NULL,'Fiyi');
INSERT INTO PAIS VALUES (NULL,'Francia');
INSERT INTO PAIS VALUES (NULL,'Gabón');
INSERT INTO PAIS VALUES (NULL,'Gambia');
INSERT INTO PAIS VALUES (NULL,'Georgia');
INSERT INTO PAIS VALUES (NULL,'Islas Georgias del Sur y Sandwich del Sur');
INSERT INTO PAIS VALUES (NULL,'Ghana');
INSERT INTO PAIS VALUES (NULL,'Gibraltar');
INSERT INTO PAIS VALUES (NULL,'Granada');
INSERT INTO PAIS VALUES (NULL,'Grecia');
INSERT INTO PAIS VALUES (NULL,'Groenlandia');
INSERT INTO PAIS VALUES (NULL,'Guadalupe');
INSERT INTO PAIS VALUES (NULL,'Guam');
INSERT INTO PAIS VALUES (NULL,'Guatemala');
INSERT INTO PAIS VALUES (NULL,'Guayana Francesa');
INSERT INTO PAIS VALUES (NULL,'Guinea');
INSERT INTO PAIS VALUES (NULL,'Guinea Ecuatorial');
INSERT INTO PAIS VALUES (NULL,'Guinea-Bissau');
INSERT INTO PAIS VALUES (NULL,'Guyana');
INSERT INTO PAIS VALUES (NULL,'Haití');
INSERT INTO PAIS VALUES (NULL,'Islas Heard y McDonald');
INSERT INTO PAIS VALUES (NULL,'Honduras');
INSERT INTO PAIS VALUES (NULL,'Hong Kong');
INSERT INTO PAIS VALUES (NULL,'Hungría');
INSERT INTO PAIS VALUES (NULL,'India');
INSERT INTO PAIS VALUES (NULL,'Indonesia');
INSERT INTO PAIS VALUES (NULL,'Irán');
INSERT INTO PAIS VALUES (NULL,'Iraq');
INSERT INTO PAIS VALUES (NULL,'Irlanda');
INSERT INTO PAIS VALUES (NULL,'Islandia');
INSERT INTO PAIS VALUES (NULL,'Israel');
INSERT INTO PAIS VALUES (NULL,'Italia');
INSERT INTO PAIS VALUES (NULL,'Jamaica');
INSERT INTO PAIS VALUES (NULL,'Japón');
INSERT INTO PAIS VALUES (NULL,'Jordania');
INSERT INTO PAIS VALUES (NULL,'Kazajstán');
INSERT INTO PAIS VALUES (NULL,'Kenia');
INSERT INTO PAIS VALUES (NULL,'Kirguistán');
INSERT INTO PAIS VALUES (NULL,'Kiribati');
INSERT INTO PAIS VALUES (NULL,'Kuwait');
INSERT INTO PAIS VALUES (NULL,'Laos');
INSERT INTO PAIS VALUES (NULL,'Lesotho');
INSERT INTO PAIS VALUES (NULL,'Letonia');
INSERT INTO PAIS VALUES (NULL,'Líbano');
INSERT INTO PAIS VALUES (NULL,'Liberia');
INSERT INTO PAIS VALUES (NULL,'Libia');
INSERT INTO PAIS VALUES (NULL,'Liechtenstein');
INSERT INTO PAIS VALUES (NULL,'Lituania');
INSERT INTO PAIS VALUES (NULL,'Luxemburgo');
INSERT INTO PAIS VALUES (NULL,'Macao');
INSERT INTO PAIS VALUES (NULL,'ARY Macedonia');
INSERT INTO PAIS VALUES (NULL,'Madagascar');
INSERT INTO PAIS VALUES (NULL,'Malasia');
INSERT INTO PAIS VALUES (NULL,'Malawi');
INSERT INTO PAIS VALUES (NULL,'Maldivas');
INSERT INTO PAIS VALUES (NULL,'Malí');
INSERT INTO PAIS VALUES (NULL,'Malta');
INSERT INTO PAIS VALUES (NULL,'Islas Malvinas');
INSERT INTO PAIS VALUES (NULL,'Islas Marianas del Norte');
INSERT INTO PAIS VALUES (NULL,'Marruecos');
INSERT INTO PAIS VALUES (NULL,'Islas Marshall');
INSERT INTO PAIS VALUES (NULL,'Martinica');
INSERT INTO PAIS VALUES (NULL,'Mauricio');
INSERT INTO PAIS VALUES (NULL,'Mauritania');
INSERT INTO PAIS VALUES (NULL,'Mayotte');
INSERT INTO PAIS VALUES (NULL,'México');
INSERT INTO PAIS VALUES (NULL,'Micronesia');
INSERT INTO PAIS VALUES (NULL,'Moldavia');
INSERT INTO PAIS VALUES (NULL,'Mónaco');
INSERT INTO PAIS VALUES (NULL,'Mongolia');
INSERT INTO PAIS VALUES (NULL,'Montserrat');
INSERT INTO PAIS VALUES (NULL,'Mozambique');
INSERT INTO PAIS VALUES (NULL,'Myanmar');
INSERT INTO PAIS VALUES (NULL,'Namibia');
INSERT INTO PAIS VALUES (NULL,'Nauru');
INSERT INTO PAIS VALUES (NULL,'Nepal');
INSERT INTO PAIS VALUES (NULL,'Nicaragua');
INSERT INTO PAIS VALUES (NULL,'Níger');
INSERT INTO PAIS VALUES (NULL,'Nigeria');
INSERT INTO PAIS VALUES (NULL,'Niue');
INSERT INTO PAIS VALUES (NULL,'Isla Norfolk');
INSERT INTO PAIS VALUES (NULL,'Noruega');
INSERT INTO PAIS VALUES (NULL,'Nueva Caledonia');
INSERT INTO PAIS VALUES (NULL,'Nueva Zelanda');
INSERT INTO PAIS VALUES (NULL,'Omán');
INSERT INTO PAIS VALUES (NULL,'Países Bajos');
INSERT INTO PAIS VALUES (NULL,'Pakistán');
INSERT INTO PAIS VALUES (NULL,'Palau');
INSERT INTO PAIS VALUES (NULL,'Palestina');
INSERT INTO PAIS VALUES (NULL,'Panamá');
INSERT INTO PAIS VALUES (NULL,'Papúa Nueva Guinea');
INSERT INTO PAIS VALUES (NULL,'Paraguay');
INSERT INTO PAIS VALUES (NULL,'Perú');
INSERT INTO PAIS VALUES (NULL,'Islas Pitcairn');
INSERT INTO PAIS VALUES (NULL,'Polinesia Francesa');
INSERT INTO PAIS VALUES (NULL,'Polonia');
INSERT INTO PAIS VALUES (NULL,'Portugal');
INSERT INTO PAIS VALUES (NULL,'Puerto Rico');
INSERT INTO PAIS VALUES (NULL,'Qatar');
INSERT INTO PAIS VALUES (NULL,'Reino Unido');
INSERT INTO PAIS VALUES (NULL,'Reunión');
INSERT INTO PAIS VALUES (NULL,'Ruanda');
INSERT INTO PAIS VALUES (NULL,'Rumania');
INSERT INTO PAIS VALUES (NULL,'Rusia');
INSERT INTO PAIS VALUES (NULL,'Sahara Occidental');
INSERT INTO PAIS VALUES (NULL,'Islas Salomón');
INSERT INTO PAIS VALUES (NULL,'Samoa');
INSERT INTO PAIS VALUES (NULL,'Samoa Americana');
INSERT INTO PAIS VALUES (NULL,'San Cristóbal y Nevis');
INSERT INTO PAIS VALUES (NULL,'San Marino');
INSERT INTO PAIS VALUES (NULL,'San Pedro y Miquelón');
INSERT INTO PAIS VALUES (NULL,'San Vicente y las Granadinas');
INSERT INTO PAIS VALUES (NULL,'Santa Helena');
INSERT INTO PAIS VALUES (NULL,'Santa Lucía');
INSERT INTO PAIS VALUES (NULL,'Santo Tomé y Príncipe');
INSERT INTO PAIS VALUES (NULL,'Senegal');
INSERT INTO PAIS VALUES (NULL,'Serbia y Montenegro');
INSERT INTO PAIS VALUES (NULL,'Seychelles');
INSERT INTO PAIS VALUES (NULL,'Sierra Leona');
INSERT INTO PAIS VALUES (NULL,'Singapur');
INSERT INTO PAIS VALUES (NULL,'Siria');
INSERT INTO PAIS VALUES (NULL,'Somalia');
INSERT INTO PAIS VALUES (NULL,'Sri Lanka');
INSERT INTO PAIS VALUES (NULL,'Suazilandia');
INSERT INTO PAIS VALUES (NULL,'Sudáfrica');
INSERT INTO PAIS VALUES (NULL,'Sudán');
INSERT INTO PAIS VALUES (NULL,'Suecia');
INSERT INTO PAIS VALUES (NULL,'Suiza');
INSERT INTO PAIS VALUES (NULL,'Surinam');
INSERT INTO PAIS VALUES (NULL,'Svalbard y Jan Mayen');
INSERT INTO PAIS VALUES (NULL,'Tailandia');
INSERT INTO PAIS VALUES (NULL,'Taiwán');
INSERT INTO PAIS VALUES (NULL,'Tanzania');
INSERT INTO PAIS VALUES (NULL,'Tayikistán');
INSERT INTO PAIS VALUES (NULL,'Territorio Británico del Océano Índico');
INSERT INTO PAIS VALUES (NULL,'Territorios Australes Franceses');
INSERT INTO PAIS VALUES (NULL,'Timor Oriental');
INSERT INTO PAIS VALUES (NULL,'Togo');
INSERT INTO PAIS VALUES (NULL,'Tokelau');
INSERT INTO PAIS VALUES (NULL,'Tonga');
INSERT INTO PAIS VALUES (NULL,'Trinidad y Tobago');
INSERT INTO PAIS VALUES (NULL,'Túnez');
INSERT INTO PAIS VALUES (NULL,'Islas Turcas y Caicos');
INSERT INTO PAIS VALUES (NULL,'Turkmenistán');
INSERT INTO PAIS VALUES (NULL,'Turquía');
INSERT INTO PAIS VALUES (NULL,'Tuvalu');
INSERT INTO PAIS VALUES (NULL,'Ucrania');
INSERT INTO PAIS VALUES (NULL,'Uganda');
INSERT INTO PAIS VALUES (NULL,'Uruguay');
INSERT INTO PAIS VALUES (NULL,'Uzbekistán');
INSERT INTO PAIS VALUES (NULL,'Vanuatu');
INSERT INTO PAIS VALUES (NULL,'Venezuela');
INSERT INTO PAIS VALUES (NULL,'Vietnam');
INSERT INTO PAIS VALUES (NULL,'Islas Vírgenes Británicas');
INSERT INTO PAIS VALUES (NULL,'Islas Vírgenes de los Estados Unidos');
INSERT INTO PAIS VALUES (NULL,'Wallis y Futuna');
INSERT INTO PAIS VALUES (NULL,'Yemen');
INSERT INTO PAIS VALUES (NULL,'Yibuti');
INSERT INTO PAIS VALUES (NULL,'Zambia');
INSERT INTO PAIS VALUES (NULL,'Zimbabue');

-- USUARIO
INSERT INTO USUARIO VALUES (NULL,'Darly Jack','Góngora Chingay','AV.SAN GERMÁN 969','djackgongora@gmail.com','elpollitopio',DEFAULT,DEFAULT,1,1,DEFAULT,DEFAULT);
INSERT INTO USUARIO VALUES (NULL,'Gerson','Mondragón Tafur','Av. Rosales #333','germonta1525@gmail.com','mondragon322',DEFAULT,DEFAULT,DEFAULT,1,DEFAULT,DEFAULT);

-- AUTORES
INSERT INTO AUTOR (nombre_completo, biografia,id_pais) VALUES ('CAMUS ALBERT', 'Fue un novelista, ensayista, dramaturgo, filósofo y periodista frances nacido en 1913.',1);
INSERT INTO AUTOR (nombre_completo, biografia,id_pais) VALUES ('SEISHI KISHIMOTO', 'Dibujante de manga japonés. Nacio en 1974. Es reconocido por ser el creador de 666 Satan',2);
INSERT INTO AUTOR (nombre_completo, biografia,id_pais) VALUES ('JIE ZHANG', 'Es un novelista y cuentista china. Nació en 1986 en Pekin, China',3);
INSERT INTO AUTOR (nombre_completo, biografia,id_pais) VALUES ('MOLDES DIEGO', 'Es un escritor español, ensayista, novelista, crítico e historiador de cine. Nació en 1977',4);
INSERT INTO AUTOR (nombre_completo, biografia,id_pais) VALUES ('RICARDO PALMA', 'Fue un escritor romantico, costumbrista, tradicionalista, periodista y politico peruano. Nacio en 1833',5);

-- EDITORIALES
INSERT INTO EDITORIAL (nombre,descripcion) VALUES ('Grupo Editorial Caja Negra','libros infantiles');
INSERT INTO EDITORIAL (nombre,descripcion) VALUES ('Editorial Ambar','libros de drama y terror');
INSERT INTO EDITORIAL (nombre,descripcion) VALUES ('Editorial Futura','editorial de libros de ciencia ficcion');
INSERT INTO EDITORIAL (nombre,descripcion) VALUES ('Editorial Macro','editorial mayorista de libros en general');
INSERT INTO EDITORIAL (nombre,descripcion) VALUES ('Editorial María Trinidad','editorial parroquiana');

-- LIBROS
INSERT INTO LIBRO (ISBN,SKU,TITULO,DESCRIPCION,PAGINAS,IMAGEN,ID_AUTOR,ID_EDITORIAL,ID_CATEGORIA)
VALUES ('9786124017032','9786124017032','LIMA CIUDAD DE REYES - CITY OF KING','Hayuna Lima que no cambia. Rica, sobria e impresionante. Una Lima que, a pesar del tiempo, vive como en los valses, olorosa y señorial. Vestigios de una ciudad gobernada por virreyes y señoríos llegan hasta nuestro tiempo para hablarnos de un pasado glorioso que se fue.',120,
'https://res.cloudinary.com/dfuuywyk9/image/upload/v1636815303/DAWI/lima-ciudad-reyes-city-kings-9786124017032-libro-ca01_gifowd.jpg',1,1,1);
INSERT INTO LIBRO (ISBN,SKU,TITULO,DESCRIPCION,PAGINAS,IMAGEN,ID_AUTOR,ID_EDITORIAL,ID_CATEGORIA)
VALUES ('9786124681103','9786124681103','HERNÁN PAZOS. PINTURAS 1980-2007','-',56,
'https://res.cloudinary.com/dfuuywyk9/image/upload/v1636815303/DAWI/hernan-pazos-pinturas-1980-2007-9786124681103-libro-ca01_kekgdl.jpg',2,1,1);
INSERT INTO LIBRO (ISBN,SKU,TITULO,DESCRIPCION,PAGINAS,IMAGEN,ID_AUTOR,ID_EDITORIAL,ID_CATEGORIA)
VALUES ('9788433979810','9788433979810','SON COSAS QUE PASAN','París, 1945. En la iglesia de Saint-Pierre-de-Chaillot, ubicada en uno de los barrios más elegantes de la ciudad, se celebra un funeral. La difunta es la princesa Natalie de Lusignan, duquesa de Sorrente, que ha fallecido demasiado joven.',345,
'https://res.cloudinary.com/dfuuywyk9/image/upload/v1636816084/DAWI/cosas-pasan-9788433979810-libro-ca01_bvtxih.jpg',4,1,3);
INSERT INTO LIBRO (ISBN,SKU,TITULO,DESCRIPCION,PAGINAS,IMAGEN,ID_AUTOR,ID_EDITORIAL,ID_CATEGORIA)
VALUES ('9788417179052','9788417179052','YOUR NAME 1','El encuentro de dos jóvenes desencontrados. Nos situamos en Japón, un mes antes de la llegada de un cometa que pasa una vez cada mil años. Mitsuha, una estudiante de tercer año que vive en un pueblo en lo profundo de las montañas, pasa sus días con melancolía. ',65,
'https://res.cloudinary.com/dfuuywyk9/image/upload/v1636816478/DAWI/your-name-1-9788417179052-libro-ca01_ae7xj2.jpg',4,1,5);
INSERT INTO LIBRO (ISBN,SKU,TITULO,DESCRIPCION,PAGINAS,IMAGEN,ID_AUTOR,ID_EDITORIAL,ID_CATEGORIA)
VALUES ('9786075284545','9786075284545','ATAQUE DE LOS TITANES BEFORE THE FALL 08','Sharle espera en el taller el regreso de Kuklo, quien fue a Shiganshina a probar el nuevo modelo del dispositivo. Sin embargo, aunque llegó el día en que estaba programado su regreso, él no apareció. ',56,
'https://res.cloudinary.com/dfuuywyk9/image/upload/v1636816425/DAWI/ataque-titanes-before-the-fall-08-9786075284545-libro-ca01_bmg3cx.jpg',5,1,5);
INSERT INTO LIBRO (ISBN,SKU,TITULO,DESCRIPCION,PAGINAS,IMAGEN,ID_AUTOR,ID_EDITORIAL,ID_CATEGORIA)
VALUES ('9788497593793','9788497593793','IT','Quién o qué mutila y mata a los niños de un pequeño pueblo norteamericano? ¿Por qué llega cíclicamente el horror a Derry en forma de un payaso siniestro que va sembrando la destrucción a su paso? Esto es lo que se proponen averiguar los protagonistas de esta novela. ',76,
'https://res.cloudinary.com/dfuuywyk9/image/upload/v1636816983/DAWI/it-9788497593793-libro-ca01_blrziy.jpg',2,1,7);
INSERT INTO LIBRO (ISBN,SKU,TITULO,DESCRIPCION,PAGINAS,IMAGEN,ID_AUTOR,ID_EDITORIAL,ID_CATEGORIA)
VALUES ('9788492892884','9788492892884','CUENTOS DE TERROR','No nos cabe la menor duda que, durante la lectura de estas páginas, verá cómo su adrenalina sube por momentos y cómo le invade un inmenso placer después de cada escena terrorífica, porque en el libro que tiene usted en sus manos están contenidas las historias más espeluznantes de los mejores maestros del género de todos los tiempos.',87,
'https://res.cloudinary.com/dfuuywyk9/image/upload/v1636816983/DAWI/cuentos-terror-9788492892884-libro-ca01_l4z9da.jpg',3,1,7);
INSERT INTO LIBRO (ISBN,SKU,TITULO,DESCRIPCION,PAGINAS,IMAGEN,ID_AUTOR,ID_EDITORIAL,ID_CATEGORIA)
VALUES ('9786073142557','9786073142557','JUEGO DE TRONOS PARA LOS NEGOCIOS','Juego de tronos para los negocios retoma cinco estrategias del universo creado por George R. R. Martin que te convertirán en el rey de tu propia empre…',32,
'https://res.cloudinary.com/dfuuywyk9/image/upload/v1636817383/DAWI/juego-tronos-para-negocios-9786073142557-libro-ca01_e3czjw.jpg',2,1,9);
INSERT INTO LIBRO (ISBN,SKU,TITULO,DESCRIPCION,PAGINAS,IMAGEN,ID_AUTOR,ID_EDITORIAL,ID_CATEGORIA)
VALUES ('9786077444008','9786077444008','PLAN ESTRATÉGICO DE NEGOCIOS','En este libro el autor explica el contenido de un plan de negocios estratégico, base para ser tomado en cuenta por todo emprendedor de negocios o para empresas ya en marcha que buscan emprender otras líneas de producto o servicios.',52,
'https://res.cloudinary.com/dfuuywyk9/image/upload/v1636817374/DAWI/plan-estrategico-negocios-9786077444008-libro-ca01_eje7up.jpg',3,1,9);

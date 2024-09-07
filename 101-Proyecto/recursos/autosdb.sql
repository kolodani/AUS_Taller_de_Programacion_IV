CREATE TABLE autos (codigo_auto varchar(255) NOT NULL, marca_id int4 NOT NULL, referencias varchar(255) NOT NULL, precio numeric(19, 0) NOT NULL, modelo numeric(19, 0) NOT NULL, color varchar(255) NOT NULL, caballos_fuerza varchar(255) NOT NULL, cantidad_puestas numeric(19, 0) NOT NULL, cilindraje numeric(19, 0) NOT NULL, automatico varchar(255) NOT NULL, es_diesel varchar(255) NOT NULL, cantidad_asientos numeric(19, 0) NOT NULL, traccion numeric(19, 0) NOT NULL, direccion varchar(255) NOT NULL, categoria varchar(255) NOT NULL, PRIMARY KEY (codigo_auto));
CREATE TABLE autos_compras (autos_codigo_auto varchar(255) NOT NULL, compras_numero_factura int4 NOT NULL, cantidad numeric(19, 0) NOT NULL, total numeric(19, 0) NOT NULL, PRIMARY KEY (autos_codigo_auto, compras_numero_factura));
CREATE TABLE cliente (dni SERIAL NOT NULL, nombre_cliente varchar(255) NOT NULL, email_cliente varchar(255) NOT NULL, celular_cliente numeric(19, 0) NOT NULL, activo int4 NOT NULL, solvencia varchar(255) NOT NULL, PRIMARY KEY (dni));
CREATE TABLE compras (numero_factura SERIAL NOT NULL, clientedni int4 NOT NULL, fecha timestamp NOT NULL, total numeric(19, 0) NOT NULL, medio_pago varchar(255) NOT NULL, PRIMARY KEY (numero_factura));
CREATE TABLE marca_auto (id SERIAL NOT NULL, descripcion varchar(255) NOT NULL, PRIMARY KEY (id));
ALTER TABLE autos ADD CONSTRAINT FKautos695361 FOREIGN KEY (marca_id) REFERENCES marca_auto (id);
ALTER TABLE compras ADD CONSTRAINT FKcompras842161 FOREIGN KEY (clientedni) REFERENCES cliente (dni);
ALTER TABLE autos_compras ADD CONSTRAINT FKautos_comp56147 FOREIGN KEY (autos_codigo_auto) REFERENCES autos (codigo_auto);
ALTER TABLE autos_compras ADD CONSTRAINT FKautos_comp285055 FOREIGN KEY (compras_numero_factura) REFERENCES compras (numero_factura);

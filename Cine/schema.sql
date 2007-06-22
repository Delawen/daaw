alter table cine.butaca drop foreign key butacas_id;
alter table cine.sesion_cine drop foreign key Sala_id;
alter table cine.sesion_cine drop foreign key Pelicula_id;
drop table if exists cine.butaca;
drop table if exists cine.pelicula;
drop table if exists cine.sala;
drop table if exists cine.sesion_cine;
create table cine.butaca (id bigint not null auto_increment, ocupado bit, fila integer, columna integer, butacas_id bigint, butacas_idx integer, primary key (id));
create table cine.pelicula (id bigint not null auto_increment, titulo varchar(255), sinopsis varchar(255), primary key (id));
create table cine.sala (id bigint not null auto_increment, descripcion varchar(255), primary key (id));
create table cine.sesion_cine (id bigint not null auto_increment, time date, precio float, sala_id bigint, pelicula_id bigint, primary key (id));
alter table cine.butaca add index butacas_id (butacas_id), add constraint butacas_id foreign key (butacas_id) references cine.sesion_cine (id);
alter table cine.sesion_cine add index Sala_id (sala_id), add constraint Sala_id foreign key (sala_id) references cine.sala (id);
alter table cine.sesion_cine add index Pelicula_id (pelicula_id), add constraint Pelicula_id foreign key (pelicula_id) references cine.pelicula (id);
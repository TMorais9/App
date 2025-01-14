create table player ( 
pla_id int not null auto_increment, 
pla_name VARCHAR (60) not null, 
pla_bdate date not null,
pla_anos VARCHAR (60) not null, 
pla_num VARCHAR (60) not null,
pla_nac VARCHAR (60) not null,
pla_foto VARCHAR (200), 
primary key (pla_id)  
); 

create table position ( 
pos_id int not null auto_increment, 
pos_name VARCHAR (60) not null, 
primary key (pos_id)  
); 

create table season (
seas_id int not null auto_increment,
seas_name VARCHAR (60) not null,
seas_dt_in date,
seas_dt_out date,
primary key (seas_id)
);

create table chavesplayer (
chpla_id int not null auto_increment,
chpla_seas_id int not null,
chpla_pla_id int not null,
chpla_pos_id int not null,
primary key (chpla_id)
);

create table opponent (
opp_id int not null auto_increment,
opp_name VARCHAR (60) not null,
primary key (opp_id)
);

create table opponentplayer (
oppla_id int not null auto_increment,
oppla_pla_id int not null,
oppla_opp_id int not null,
oppla_pos_id int not null,
oppla_seas_id int not null,
primary key (oppla_id)
);

create table stadium (
sta_id int not null auto_increment,
sta_name VARCHAR (90) not null,
sta_adress VARCHAR (90) not null,
sta_foto VARCHAR (200),
Primary key (sta_id)
);

create table game (
game_id int not null auto_increment,
game_name VARCHAR (60) not null,
game_dt date not null,
game_sta_id int,
game_comp_id int not null,
game_opp_id int,
primary key (game_id)
);

create table competition (
comp_id int not null auto_increment,
comp_name VARCHAR (60) not null,
primary key (comp_id)
);

create table teamsummoned (
teasum_id int not null auto_increment,
teasum_game_id int not null,
teasum_chpla_id int not null,
primary key (teasum_id)
);

create table opponentsummoned (
oppsum_id int not null auto_increment,
oppsum_game_id int not null,
oppsum_oppla_id int not null,
primary key (oppsum_id)
);

create table socio (
socio_id int not null auto_increment,
socio_name VARCHAR (60) not null,
socio_num VARCHAR (60) not null,
socio_email VARCHAR (60) not null,
socio_bdate date not null,
primary key (socio_id)
);

create table votação (
vot_id int not null auto_increment,
vot_grade int,
vot_teasum_id int,
vot_socio_id int,
primary key (vot_id)
);

create table encomenda (
enc_id int not null auto_increment,
enc_socio_id int not null,
enc_date date not null,
enc_adress VARCHAR (90) not null,
primary key (enc_id)
);

create table produto (
prod_id int not null auto_increment,
prod_name VARCHAR (60) not null,
prod_foto VARCHAR (200),
prod_desc VARCHAR (300) not null,
primary key (prod_id)
);

create table encomendaproduto (
encprod_id int not null auto_increment,
encprod_prod_id int not null,
encprod_enc_id int not null,
primary key (encprod_id)
);

create table ocorrencia (
oco_id int not null auto_increment,
oco_name VARCHAR (60) not null,
primary key (oco_id)
);

create table ocorrenciateamsummuned (
octeasum_id int not null auto_increment,
octeasum_oco_id int not null,
octeasum_teasum_id int not null,
octeasum_inst VARCHAR (60) not null,
octeasum_desc VARCHAR (60) not null,
primary key (octeasum_id)
);

create table ocorrenciaopponentsummuned (
ocoppsum_id int not null auto_increment,
ocoppsum_oco_id int not null,
ocoppsum_oppsum_id int not null,
ocoppsum_inst VARCHAR (60) not null,
ocoppsum_desc VARCHAR (60) not null,
primary key (ocoppsum_id)
);


    create table if not exists Formes (id int primary key, x decimal ,y decimal); 
	
	create table if not exists Cercle (nom varchar(50) primary key, x decimal ,y decimal,rayon int); 
	
	create table if not exists Triangle (nom varchar(50) primary key, x decimal ,y decimal,base int,hauteur int); 
	
	create table if not exists Rectangle (nom varchar(50) primary key, x decimal ,y decimal,largeur int, hauteur int); 
	
	create table if not exists Carre (nom varchar(50) primary key, x decimal ,y decimal, largeur int, hauteur int); 
	
	create table if not exists Groupe(id varchar(50) primary key, , x decimal ,y decimal); 
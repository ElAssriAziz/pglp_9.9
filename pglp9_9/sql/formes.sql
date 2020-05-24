	DROP TABLE Cercle IF EXISTS;
	DROP TABLE Triangle IF EXISTS;
	DROP TABLE Rectangle IF EXISTS;
	DROP TABLE Carre IF EXISTS;
	DROP TABLE Composer IF EXISTS;
	DROP TABLE Groupe IF EXISTS;
	
	
	create table Cercle (nom varchar(50) primary key, x int ,y int,rayon int); 
	
	create table Triangle (nom varchar(50) primary key, x int ,y int,base int,hauteur int); 
	
	create table Rectangle (nom varchar(50) primary key, x int ,y int,largeur int, hauteur int); 
	
	create table Carre (nom varchar(50) primary key, x int ,y int, largeur int, hauteur int); 
	
	create table  Groupe(id varchar(50) primary key , x int ,y int); 
	
	create table Composer(idGroupe varchar(50), nomForme varchar(50), primary key(nomForme,idGroupe),
              foreign key(idGroupe) references Groupe); 
	

create database vinyl_collection;

use vinyl_collection;

create table song (
songId int not null auto_increment,
songName varchar (255) not null,
songLength time null,
primary key (songId)
);

create table genre (
genreId int not null auto_increment,
genreName varchar (255) not null,
primary key (genreId)
);

create table instrument (
instrumentId int not null auto_increment,
instrumentName varchar (255) not null,
primary key (instrumentId)
);

create table musician (
musicianId	int not null auto_increment,
firstName varchar (255) not null,
lastName varchar (255) not null,
primary key (musicianId)
);

create table artist (
artistId int not null auto_increment,
artistName varchar (255) not null,
primary key (artistId)
);

create table album (
albumId int not null auto_increment,
albumName varchar (255) not null,
albumYear year not null,
primary key (albumId)
);

create table albumartist (
albumId int not null,
artistId int not null,
primary key (albumId, artistId)
);

alter table albumartist 
add constraint fk_albumartist_album
foreign key (albumId) references album(albumId);

alter table albumartist 
add constraint fk_albumartist_artist
foreign key (artistId) references artist(artistId);

create table albumsong (
albumId int not null,
songId int not null,
primary key (albumId, songId)
);

alter table albumsong
add constraint fk_albumsong_album
foreign key (albumId) references album(albumId);

alter table albumsong
add constraint fk_albumsong_song
foreign key (songId) references song(songId);

create table albumgenre (
albumId int not null,
genreId int not null,
primary key (albumId, genreId)
);

alter table albumgenre
add constraint fk_albumgenre_album
foreign key (albumId) references album(albumId);

alter table albumgenre
add constraint fk_albumgenre_genre
foreign key (genreId) references genre(genreId);

create table albummusician (
albumId int not null,
musicianId int not null,
primary key (albumId, musicianId)
);

alter table albummusician
add constraint fk_albummusician_album
foreign key (albumId) references album(albumId);

alter table albummusician
add constraint fk_albummusician_musician
foreign key (musicianId) references musician(musicianId);

create table artistmusician (
artistId int not null,
musicianId int not null,
primary key (artistId, musicianId)
);

alter table artistmusician
add constraint fk_artistmusician_artist
foreign key (artistId) references artist(artistId);

alter table artistmusician
add constraint fk_artistmusician_musician
foreign key (musicianId) references musician(musicianId);

create table musicianinstrument (
musicianId int not null,
instrumentId int not null,
primary key (musicianId, instrumentId)
);

alter table musicianinstrument 
add constraint fk_musicianinstrument_musician
foreign key (musicianId) references musician(musicianId);

alter table musicianinstrument 
add constraint fk_musicianinstrument_instrument
foreign key (instrumentId) references instrument(instrumentId);


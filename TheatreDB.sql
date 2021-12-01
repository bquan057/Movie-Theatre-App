DROP DATABASE IF EXISTS THEATREDB;
CREATE DATABASE THEATREDB; 
USE THEATREDB;

DROP TABLE IF EXISTS THEATRE;
CREATE TABLE THEATRE (
    TName					varchar(30)	not null,
	primary key (TName)
);

INSERT INTO THEATRE (TName)
VALUES
('Cineplex'),
('LandMark'),
('Galaxy'),
('AMC');


DROP TABLE IF EXISTS MOVIE;
CREATE TABLE MOVIE (
	TName				varchar(30) not null,
    MName				varchar(30)	not null,
    auditorium			integer,
    showtime			datetime,
	primary key (MName),
    foreign key (TName) references THEATRE(TName)
);

INSERT INTO MOVIE (TName, MName, auditorium, showtime)
VALUES
('Cineplex', 'Lethal Weapon', 1, "2021-07-11 10:20:21"),
('LandMark', 'LOTR', 2, "2021-07-11 10:20:21"),
('Galaxy', 'Inception', 3, "2021-07-11 10:20:21"),
('AMC', 'Fight Club', 4, "2021-07-11 10:20:21");

DROP TABLE IF EXISTS SEAT;
CREATE TABLE SEAT (
	seatNumber			integer not null,
    auditorium			integer,
    availability		boolean,
    TName				varchar(30) not null,
	showtime			datetime,
	primary key (seatNumber, auditorium, showtime, TName),
    foreign key (TName, showtime, auditorium) references MOVIE(TName, showtime, auditorium)
);

INSERT INTO SEAT (seatNumber, auditorium, availability, Tname, showtime)
VALUES
(1, 1, true, 'Cineplex', "2021-07-11 10:20:21"),
(2, 2, true, 'LandMark', "2021-07-11 10:20:21"),
(3, 3, true, 'Galaxy', "2021-07-11 10:20:21"),
(4, 4, true, 'AMC', "2021-07-11 10:20:21");

DROP TABLE IF EXISTS SEAT;
CREATE TABLE SEAT (
	seatNumber			integer not null,
    auditorium			integer,
    availability		boolean,
    TName				varchar(30) not null,
	showtime			datetime,
	primary key (seatNumber, auditorium, showtime, TName),
    foreign key (TName, showtime, auditorium) references MOVIE(TName, showtime, auditorium)
);

INSERT INTO SEAT (seatNumber, auditorium, availability, Tname, showtime)
VALUES
(1, 1, true, 'Cineplex', "2021-07-11 10:20:21"),
(2, 2, true, 'LandMark', "2021-07-11 10:20:21"),
(3, 3, true, 'Galaxy', "2021-07-11 10:20:21"),
(3, 4, true, 'AMC', "2021-07-11 10:20:21");

DROP TABLE IF EXISTS TICKET;
CREATE TABLE TICKET (
	ticketId			integer not null auto_increment,
	seatNumber			integer not null,
    auditorium			integer not null,
    movie				varchar(30),
    theatre				varchar(30),
	showtime			datetime,
    email				varchar(30),
    Tstatus				varchar(30),
	primary key (ticketId),
    foreign key (movie, auditorium, showtime) references MOVIE(Mname, auditorium, showtime),
    foreign key (theatre) references Theatre(Tname),
    foreign key (seatNumber) references SEAT(seatNumber)
);

INSERT INTO TICKET(seatNumber, auditorium, movie, theatre, showtime, email, Tstatus)
VALUES
(1, 1, 'Lethal Weapon', 'Cineplex', "2021-07-11 10:20:21", 'rohinesh', 'available'),
(1, 1, 'Lethal Weapon', 'Cineplex', "2021-07-11 10:20:21", 'rohinesh', 'available'),
(1, 1, 'Lethal Weapon', 'Cineplex', "2021-07-11 10:20:21", 'rohinesh', 'available'),
(1, 1, 'Lethal Weapon', 'Cineplex', "2021-07-11 10:20:21", 'rohinesh', 'available');


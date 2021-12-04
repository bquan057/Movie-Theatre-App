DROP DATABASE IF EXISTS THEATREDB;
CREATE DATABASE THEATREDB; 
USE THEATREDB;

DROP TABLE IF EXISTS THEATRE;
CREATE TABLE THEATRE (
	TId						integer auto_increment,
    TName					varchar(30)	not null,
	primary key (TId)
);

INSERT INTO THEATRE (TId, TName)
VALUES
(1, 'Cineplex'),
(2, 'LandMark'),
(3, 'Galaxy'),
(4, 'AMC');

DROP TABLE IF EXISTS AUDITORIUM;
CREATE TABLE AUDITORIUM (
    TId			integer	not null,
    ANumber		integer,
    Capacity	integer,
	primary key (ANumber, TId),
    foreign key (TId) references THEATRE(TId)
);

INSERT INTO AUDITORIUM (TId, ANumber, Capacity)
VALUES
(1, 1, 30),
(2, 2, 30),
(3,3, 30 ),
(4, 4, 30);

DROP TABLE IF EXISTS SEAT;
CREATE TABLE SEAT (
	seatNumber		integer not null,
    auditorium		integer not null,
    availability	boolean,
    TId				integer	not null,
	primary key (seatNumber, auditorium, TId),
    foreign key (auditorium) references AUDITORIUM(ANumber),
    foreign key (TId) references THEATRE(TId)
);

INSERT INTO SEAT (seatNumber, auditorium, availability, TId)
VALUES
(1, 1, true, 1),
(2, 1, true, 2),
(3, 1, true, 3),
(4, 1, true, 4);

DROP TABLE IF EXISTS MOVIE;
CREATE TABLE MOVIE (
	TId					integer	not null,
    MId					integer,
    MName				varchar(30)	not null,
    auditorium			integer,
	primary key (MId),
    foreign key (TId) references THEATRE(TId),
    foreign key (auditorium) references AUDITORIUM(ANumber)
);

INSERT INTO MOVIE (TId, MId,  MName, auditorium)
VALUES
(1, 1, 'Lethal Weapon', 1),
(2, 2, 'LOTR', 2),
(3, 3, 'Inception', 3),
(4, 4, 'Fight Club', 4);

DROP TABLE IF EXISTS SHOWTIME;
CREATE TABLE SHOWTIME (
	MId				integer,
    TId				integer	not null,
	auditorium   	integer,
	showtime    	DateTime,
    primary key (showtime, MId, TId, auditorium),
    foreign key (MId) references MOVIE(MId),
    foreign key (TId) references THEATRE(TId),
    foreign key (auditorium) references AUDITORIUM(ANumber)
);

INSERT INTO SHOWTIME (TId, MId, auditorium, showtime)
VALUES
(1, 1, 1, "2021-07-11 10:20:22"),
(2, 2, 1, "2021-07-11 10:20:23"),
(3, 3, 1, "2021-07-11 10:20:24"),
(4, 4, 1, "2021-07-11 10:20:25");

DROP TABLE IF EXISTS TICKET;
CREATE TABLE TICKET (
	ticketId		integer not null auto_increment,
	seatNumber		integer not null,
    auditorium		integer not null,
    MId				integer,
    TId				integer	not null,
	showtime		datetime,
    email			varchar(30),
    Tstatus			varchar(30),
	primary key (ticketId),
    foreign key (MId) references MOVIE(MId),
    foreign key (auditorium) references AUDITORIUM(ANumber),
    foreign key (showtime) references SHOWTIME(showtime),
    foreign key (TId) references THEATRE(TId),
    foreign key (seatNumber) references SEAT(seatNumber)
);

INSERT INTO TICKET(seatNumber, auditorium, MId, TId, showtime, email, Tstatus)
VALUES
(1, 1, 1, 1, "2021-07-11 10:20:22", 'rohinesh', 'available'),
(1, 1, 2, 2, "2021-07-11 10:20:23", 'rohinesh', 'available'),
(1, 1, 3, 3, "2021-07-11 10:20:24", 'rohinesh', 'available'),
(1, 1, 4, 4, "2021-07-11 10:20:25", 'rohinesh', 'available');

SELECT * FROM THEATRE;
SELECT * FROM AUDITORIUM;
SELECT * FROM SEAT;
SELECT * FROM MOVIE;
SELECT * FROM SHOWTIME;
SELECT * FROM TICKET;
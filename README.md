# CRUD-with-MyBatis

You need to create a database named Schooldb :

--Create DATABASE SchoolDB;

use SchoolDB;

--Create a table Class（id，ClassName，College，Specialty，EnterYear）

CREATE TABLE Class(
  id int PRIMARY KEY,
  className varchar(30) NOT NULL,
  college varchar(30),
  specialty varchar(30),EnterYear int);
  
--Create a table Student（id, Sno，Sname，Sex，Birth，Class_id）

CREATE TABLE Student(
  id int  PRIMARY KEY,
  Sno varchar(20) NOT NULL,
  Sname varchar(10) NOT NULL,
  Sex int,Birth datetime,
  Class_id int ,
  Constraint FK_Student_Class FOREIGN KEY(Class_id) REFERENCES Class(id));
  
--Create a table Course（id，Cname，Credit,ClassHour）

CREATE TABLE Course(
  id int  PRIMARY KEY,
  Cname varchar(30) NOT NULL,
  Credit numeric(4,1) Constraint CK_Credit CHECK(Credit>0),
  ClassHour int Constraint CK_ClassHour CHECK(ClassHour>0));
  
--Create a table Score（Stu_id，Cou_id，Uscore，EndScore）

CREATE TABLE Score(
  Stu_id int ,
  Cou_id int ,
  Uscore numeric(4,1) Constraint CK_Uscore CHECK(Uscore>=0 and Uscore<=100),
  EndScore numeric(4,1) Constraint CK_EndScore CHECK(EndScore>=0 and EndScore<=100),
  Constraint PK_Score PRIMARY KEY(Stu_id, Cou_id),
  Constraint FK_Score_Student FOREIGN KEY(Stu_id) REFERENCES Student(id),
  Constraint FK_Score_Course FOREIGN KEY(Cou_id) REFERENCES Course(id));
  
insert into Class values(1,'Soft191','IT','Software',2019);
insert into Class values(2,'Soft191','IT','Software',2019);
insert into Class values(3,'Soft193','IT','Software',2019);
insert into Class values(4,'Cs191','IT','CS',2019);

insert into student values(1,'2019001001','Ben',1,'2000/9/3 00:00:00',1);
insert into student values(2,'2019001002','John',1,'2001/10/3 00:00:00',1);
insert into student values(3,'2019002001','Josh',1,'2000/6/12 00:00:00',2);

insert into Course values(1,'JavaDev',3.0,48);
insert into Course values(2,'Msql',3.0,56);
insert into Course values(3,'Java Adv',2.0,48);

insert into Score values(1,2,82,80);
insert into Score values(1,1,80,81);
insert into Score values(2,2,78,75);
insert into Score values(2,3,87,86);

Note: Don't forget to set your own Mysql credentials in mybatis-config.xml file

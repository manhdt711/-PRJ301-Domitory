/****** Script for SelectTopNRows command from SSMS  ******/
CREATE DATABASE Test
CREATE TABLE ACCOUNT(
Email NVARCHAR(255) PRIMARY KEY,
Pass NVARCHAR(255)
)
CREATE TABLE STUDENT(
	StudentID VARCHAR(7) PRIMARY KEY NOT NULL,
	[First Name] NVARCHAR(255) NOT NULL,
	Email NVARCHAR(255) FOREIGN KEY REFERENCES dbo.ACCOUNT(Email),
	Gender CHAR(1) DEFAULT 'M' CHECK(Gender IN('F','M')) NOT NULL,
	Balance int
)

drop table REGISTER
CREATE TABLE Report(
	Report_Id NVARCHAR(100) PRIMARY KEY,
	StudentID VARCHAR(7) FOREIGN KEY REFERENCES dbo.STUDENT(StudentID),
	BedID CHAR(25) FOREIGN KEY REFERENCES dbo.ROOM(BedID),
	Ngay DATETIME,
	Title NVARCHAR(255),
	NoiDung NVARCHAR(255),
	HinhAnh VARCHAR(50),
	[Status] bit

)
CREATE TABLE ROOM(
	BedID CHAR(25) PRIMARY KEY,
	RoomID CHAR(5),
	[Name Dom] VARCHAR(6) CHECK([Name Dom] IN ('A','B','C','D','F')),
	[Location] NVARCHAR(5) CHECK(Location IN ('L', 'R')) NOT NULL,
	[Number Bed] INT,
	Price INT,
	Gender CHAR(1) DEFAULT 'M' CHECK(Gender IN('F','M')) NOT NULL,
)
CREATE TABLE REGISTER(
	BedID CHAR(25) FOREIGN KEY REFERENCES dbo.ROOM(BedID),
	StudentID VARCHAR(7) FOREIGN KEY REFERENCES dbo.STUDENT(StudentID),
	[Check-in] DATETIME,
	
)
CREATE TABLE [Power_water](
	StudentID VARCHAR(7) FOREIGN KEY REFERENCES dbo.STUDENT(StudentID),
	BedID CHAR(25) FOREIGN KEY REFERENCES dbo.ROOM(BedID),
	[Type] CHAR(255),
	[date] DATETIME,
	[count] int,
)
CREATE TABLE [History-Res](
	StudentID VARCHAR(7) FOREIGN KEY REFERENCES dbo.STUDENT(StudentID),
	BedID CHAR(25) FOREIGN KEY REFERENCES dbo.ROOM(BedID),
	[Check-in] DATETIME,
	Price INT,
	Semester INT,
	YearOfSemester INT,
	Sta bit
)
INSERT INTO dbo.ACCOUNT(Email, Pass) VALUES('tubase06155@fpt.edu.vn', '01699271212');
INSERT INTO dbo.ACCOUNT(Email, Pass) VALUES('hieubthe13079@fpt.edu.vn', '01643241728');
INSERT INTO dbo.ACCOUNT(Email, Pass) VALUES('hiepdqse05627@fpt.edu.vn', '01649088188');
INSERT INTO dbo.ACCOUNT(Email, Pass) VALUES('tuandvse05339@fpt.edu.vn', '0868455987');
INSERT INTO dbo.ACCOUNT(Email, Pass) VALUES('hoadxse04730@fpt.edu.vn', '01629178625');
INSERT INTO dbo.ACCOUNT(Email, Pass) VALUES('lyhtnlse05285@fpt.edu.vn', '0962806805');
INSERT INTO dbo.ACCOUNT(Email, Pass) VALUES('vuhkse04215@fpt.edu.vn', '01652543111');

INSERT INTO dbo.STUDENT(StudentID,[First Name],Email,Gender,Balance) VALUES('se06155','Nguyễn Anh Tú','tubase06155@fpt.edu.vn','M',30000000);
INSERT INTO dbo.STUDENT(StudentID,[First Name],Email,Gender,Balance) VALUES('he13079','Thế Hoàng Hiếu','hieubthe13079@fpt.edu.vn','M',35000000);
INSERT INTO dbo.STUDENT(StudentID,[First Name],Email,Gender,Balance) VALUES('se05627','Đặng Ngọc Hiếu','hiepdqse05627@fpt.edu.vn','F',30000000);
INSERT INTO dbo.STUDENT(StudentID,[First Name],Email,Gender,Balance) VALUES('se05339','Dương Văn Tuấn','tuandvse05339@fpt.edu.vn','M',50000000);
INSERT INTO dbo.STUDENT(StudentID,[First Name],Email,Gender,Balance) VALUES('se04730','Dương Xuân Hòa','hoadxse04730@fpt.edu.vn','F',32000000);
INSERT INTO dbo.STUDENT(StudentID,[First Name],Email,Gender,Balance) VALUES('se05285','Hồng Linh Ly','lyhtnlse05285@fpt.edu.vn','F',28000000);
INSERT INTO dbo.STUDENT(StudentID,[First Name],Email,Gender,Balance) VALUES('se04215','Hồng Khánh Vũ','vuhkse04215@fpt.edu.vn','F',30000000);

INSERT INTO dbo.REGISTER(BedID, StudentID, [Check-in]) VALUES('A101-1', 'se06155', '2020-11-20')

INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A101-1', 'A101','A', 'R', 6, 650000 ,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A101-2', 'A101','A', 'R', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A101-3', 'A101','A', 'R', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A101-4', 'A101','A', 'R', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A101-5', 'A101','A', 'R', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A101-6', 'A101','A', 'R', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A101-7', 'A101','A', 'L', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A101-8', 'A101','A', 'L', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A101-9', 'A101','A', 'L', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A101-10', 'A101','A', 'L', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A101-11', 'A101','A', 'L', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A101-12', 'A101','A', 'L', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A102-1', 'A102','A', 'R', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A102-2', 'A102','A', 'R', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A102-3', 'A102','A', 'R', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A102-4', 'A102','A', 'R', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A102-5', 'A102','A', 'R', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A102-6', 'A102','A', 'R', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A102-7', 'A102','A', 'L', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A102-8', 'A102','A', 'L', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A102-9', 'A102','A', 'L', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A102-10', 'A102','A', 'L', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A102-11', 'A102','A', 'L', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A102-12', 'A102','A', 'L', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A103-1', 'A103','A', 'R', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A103-2', 'A103','A', 'R', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A103-3', 'A103','A', 'R', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A103-4', 'A103','A', 'R', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A103-5', 'A103','A', 'R', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A103-6', 'A103','A', 'R', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A103-7', 'A103','A', 'L', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A103-8', 'A103','A', 'L', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A103-9', 'A103','A', 'L', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A103-10', 'A103','A', 'L', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A103-11', 'A103','A', 'L', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A103-12', 'A103','A', 'L', 6, 650000,'M');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A104-1', 'A104','A', 'R', 6, 650000 ,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A104-2', 'A104','A', 'R', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A104-3', 'A104','A', 'R', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A104-4', 'A104','A', 'R', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A104-5', 'A104','A', 'R', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A104-6', 'A104','A', 'R', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A104-7', 'A104','A', 'L', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A104-8', 'A104','A', 'L', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A104-9', 'A104','A', 'L', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A104-10', 'A104','A', 'L', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A104-11', 'A104','A', 'L', 6, 650000,'F');
INSERT INTO dbo.ROOM(BedID, RoomID, [Name Dom], [Location], [Number Bed], Price, Gender) VALUES('A104-12', 'A104','A', 'L', 6, 650000,'F');
--chon ra ca phong trong co gioi tinh la female
select *
from dbo.ROOM
where not EXISTS
(select BedID
from dbo.REGISTER
where Room.BedID = REGISTER.BedID)
and Gender = 'F'
--
use master

drop database SWP391

CREATE DATABASE SWP391
--DROP DATABASE SWP391
-- SELECT * FROM Student
-- SELECT * FROM Lecturer
-- SELECT * FROM Semester
-- SELECT * FROM Users
-- SELECT * FROM Category

USE  SWP391

CREATE TABLE Roles (
	RoleId INT PRIMARY KEY,
	RoleName VARCHAR(30),
)

CREATE TABLE Category (
    CategoryId INT PRIMARY KEY,
    CategoryName VARCHAR(30),
)

CREATE TABLE Department (
	DepartmentId INT PRIMARY KEY,
	Name VARCHAR(30),	
)

CREATE TABLE Users (
    UserId INT PRIMARY KEY,
    Name VARCHAR(30),
    Password VARCHAR(30) NOT NULL,
    Status INT,
	DepartmentId INT FOREIGN KEY (DepartmentId) REFERENCES Department(DepartmentId),
    Email VARCHAR(50) UNIQUE,
	RoleId INT,
	FOREIGN KEY (RoleId) REFERENCES Roles(RoleId),
	Cookie VARCHAR(10)	
)

CREATE TABLE Topic(
	TopicId INT PRIMARY KEY,
	Name VARCHAR(30),
	CategoryId INT FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId),
	Description VARCHAR(200),
	BusinessId INT FOREIGN KEY (UsersId) REFERENCES Users(UserId),
	DepartmentId INT FOREIGN KEY (DepartmentId) REFERENCES Department(DepartmentId)
)

CREATE TABLE LecturerTopic (
	ID INT PRIMARY KEY,
	LecturerId INT NOT NULL,
	FOREIGN KEY (LecturerId) REFERENCES Users(UserId),
	TopicId INT NOT NULL,
	FOREIGN KEY (TopicId) REFERENCES Topic(TopicId)
)

CREATE TABLE Semester (
    SemesterId INT PRIMARY KEY,
    Name VARCHAR(30),
    StartDate DATE,
    EndDate DATE,
	TopicId INT FOREIGN KEY (TopicId) REFERENCES Topic(TopicId)
)

CREATE TABLE Groups (
	GroupId INT PRIMARY KEY,
	GroupName VARCHAR(30),
	SemID INT FOREIGN KEY (SemID) REFERENCES Semester(SemesterId)
)

CREATE TABLE StudentGroup (
	Id INT PRIMARY KEY,
	StudentId INT NOT NULL FOREIGN KEY (StudentId) REFERENCES Users(UserId),
	GroupId INT NOT NULL FOREIGN KEY (GroupId) REFERENCES Groups(GroupId),
	LeaderStatus INT,
)

CREATE TABLE Project(
	ProjectId INT PRIMARY KEY,
	Description VARCHAR(200),
	Name VARCHAR(30),
	SourceCode VARCHAR(200),
	TopicId INT FOREIGN KEY(TopicId) REFERENCES Topic(TopicId),
	Status INT,
	GroupId INT NOT NULL FOREIGN KEY(GroupId) REFERENCES Groups(GroupId)
)

CREATE TABLE ProjectLecturer(
	Id INT PRIMARY KEY,
	ProjectId INT NOT NULL FOREIGN KEY (ProjectId) REFERENCES Project(ProjectId),
	LecturerId INT NOT NULL FOREIGN KEY (LecturerId) REFERENCES Users(UserId)
)

insert into Department values(1,'Quan tri kinh doanh')
insert into Department values(2,'Cong nghe thong tin')
insert into Department values(3,'Ngon ngu Anh')
insert into Department values(4,'Ngon ngu Han Quoc')
insert into Department values(5,'Ngon ngu Nhat')

select * from Department

insert into Category values(1,'Digital Marketing')
insert into Category values(2,'Kinh doanh quoc te')
insert into Category values(3,'Quan tri khach san')
insert into Category values(4,'du lich & lu hanh')
insert into Category values(5,'Truyen thong da phuong tien')
insert into Category values(6,'Ky thuat phan mem')
insert into Category values(7,'He thong thong tin')
insert into Category values(8,'Tri tue nhan tao')
insert into Category values(9,'An toan thong tin')
insert into Category values(10,'Thiet ke do hoa')
insert into Category values(11,'Internet of things')
insert into Category values(12,'Phan mem o to')
insert into Category values(13,'Xu li dich vu so')
insert into Category values(14,'Ngon ngu Anh')
insert into Category values(15,'Ngon ngu Nhat')
insert into Category values(16,'Ngon ngu Han Quoc')

select * from Category


insert into Users values(1,'Le Hai Long','12345678',1,2,'lehailong@gmail.com',1)
insert into Users values(2,'Pham Cong Minh','12345678',1,2,'phamcongminh@gmail.com',1)
insert into Users values(3,'Ha Anh Tu','12345678',1,2,'haanhtu@gmail.com',1)
insert into Users values(4,'Pham Nguyen Hung Anh','12345678',1,2,'hunganh@gmail.com',1)
insert into Users values(5,'Pham Hong Quang','12345678',1,2,'phamhongquang@gmail.com',1)

insert into Users values(6,'Lam Huu Khanh Phuong','12345678',1,2,'phuonglhk@fe.edu.vn',2)

insert into Users Values (7, 'FPT','12345678',null,null,'FPT@gmail.com',3)
insert into Users Values (8, 'FPT Software HCM','12345678',null,null,'FPTsotfware@gmail.com',3)
insert into Users Values (9, 'Cty TNHH Job Test','12345678',null,null,'jobtest@gmail.com',3)
insert into Users Values (10, 'Cty SmartPay','12345678',null,null,'smartpay@gmail.com',3)
insert into Users Values (11, 'NashTech Global','12345678',null,null,'nashtech@gmail.com',3)

select * from Users

insert into  Roles Values (1, 'Student')
insert into  Roles Values (2, 'Lecturer')
insert into  Roles Values (3, 'Business')

select * from Roles

insert into Semester values(1,'SU2022','2022-05-29','2022-09-30',1)
insert into Semester values(2,'FA2021','2021-07-10','2021-10-10',2)
insert into Semester values(3,'SU2021','2021-05-28','2021-09-28',3)
insert into Semester values(4,'SP2022','2022-01-10','2022-05-10',4)

select * from Semester

delete from Semester

insert into Topic values(1,'CPManagement-Review',6,'Manage and review on this web',8,2)
insert into Topic values(2,'PetCareSystem',6,'The best solution to manage and service your pet',9,2)
insert into Topic values(3,'PT Tranning app',6,'The way to transform to the monster',11,2)
insert into Topic values(4,'Game Animation',10,'Like a little MCU movie',7,2)

select * from Topic

delete from Topic

insert into Groups values(1,'Beaky Blinders',1)
insert into Groups values(2,'Group 2',1)	
insert into Groups values(3,'Group 3',2)
insert into Groups values(4,'Group 4',4)

select * from Groups

delete from Groups

insert into StudentGroup values(1,1,1,1)
insert into StudentGroup values(2,2,1,0)
insert into StudentGroup values(3,3,1,0)
insert into StudentGroup values(4,4,1,0)
insert into StudentGroup values(5,5,1,0)

select * from StudentGroup

delete from StudentGroup

insert into LecturerTopic values(1,6,1)
insert into LecturerTopic values(2,6,1)

select * from LecturerTopic

delete from LecturerTopic

insert into Project values(1,'Manage and review on this web','CPManagement-Review','https://github.com/phhgquang/SWP391',1,1,1)
insert into Project values(2,'The best solution to manage and service your pet','PetCareSystem','',2,1,2)
insert into Project values(3,'The way to transform to the monster','PT Tranning app','',3,1,3)
insert into Project values(4,'Like a little MCU movie','Game Animation','',4,1,4)

select * from Project

delete from Project

insert into ProjectLecturer values(1,1,6)
insert into ProjectLecturer values(2,2,6)

select * from ProjectLecturer

delete from ProjectLecturer
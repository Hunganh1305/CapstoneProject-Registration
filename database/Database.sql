CREATE DATABASE SWP391
-- SELECT * FROM Student
-- SELECT * FROM Lecturer
-- SELECT * FROM Semester
-- SELECT * FROM Business
-- SELECT * FROM Category


USE  SWP391

CREATE TABLE Lecturer (
    LecturerId INT PRIMARY KEY,
    Name VARCHAR(30),
    Password VARCHAR(30) NOT NULL,
    Status INT,
    Email VARCHAR(50) UNIQUE,	
)

CREATE TABLE LecturerTopic (
	ID INT PRIMARY KEY,
	LecturerId INT NOT NULL FOREIGN KEY  (LecturerId) REFERENCES Lecturer(LecturerId),
	TopicId INT NOT NULL FOREIGN KEY  (TopicId) REFERENCES Topic(TopicId)
)

CREATE TABLE Business (
    BusinessId INT PRIMARY KEY,
    Name VARCHAR(30),
    Password VARCHAR(30) NOT NULL,
    Email VARCHAR(50) UNIQUE
)

CREATE TABLE Category (
    CategoryId INT PRIMARY KEY,
    CategoryName VARCHAR(30),
)

CREATE TABLE Topic(
	TopicId INT PRIMARY KEY,
	Name VARCHAR(30),
	CategoryId INT FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId),
	Description VARCHAR(200),
	BusinessId INT FOREIGN KEY (BusinessId) REFERENCES Business(BusinessId),
	DepartmentId INT FOREIGN KEY (DepartmentId) REFERENCES Department(DepartmentId)
)

CREATE TABLE Semester (
    SemesterId INT PRIMARY KEY,
    Name VARCHAR(30),
    StartDate DATE,
    EndDate DATE,
	TopicId INT FOREIGN KEY (TopicId) REFERENCES Topic(TopicId)
)

 CREATE TABLE Department (
	DepartmentId INT PRIMARY KEY,
	Name VARCHAR(30),
	
 )


 CREATE TABLE Student (
    StudentId INT PRIMARY KEY,
    Name VARCHAR(30),
    Password VARCHAR(30) NOT NULL,
    Status INT,	
    Email VARCHAR(50) UNIQUE,
	DepartmentId INT FOREIGN KEY (DepartmentId) REFERENCES Department(DepartmentId)
)

CREATE TABLE Groups (
	GroupId INT PRIMARY KEY,
	GroupName VARCHAR(30),
	SemID INT FOREIGN KEY (SemID) REFERENCES Semester(SemesterId)
)

CREATE TABLE StudentGroup (
	Id INT PRIMARY KEY,
	StudentId INT NOT NULL FOREIGN KEY (StudentId) REFERENCES Student(StudentId),
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
	LecturerId INT NOT NULL FOREIGN KEY (LecturerId) REFERENCES Lecturer(LecturerId)
)









--insert data
insert into  Business Values (1, 'FPT','12345678','FPT@gmail.com')
insert into  Business Values (2, 'FPT Software HCM','12345678','FPTsotfware@gmail.com')
insert into  Business Values (3, 'Cty TNHH Job Test','12345678','jobtest@gmail.com')
insert into  Business Values (4, 'Cty SmartPay','12345678','smartpay@gmail.com')
insert into  Business Values (5, 'NashTech Global','12345678','nashtech@gmail.com')
select * from Business

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


insert into Student values(1,'Le Hai Long','12345678',1,'lehailong@gmail.com',2)
insert into Student values(2,'Pham Cong Minh','12345678',1,'phamcongminh@gmail.com',2)
insert into Student values(3,'Ha Anh Tu','12345678',1,'haanhtu@gmail.com',2)
insert into Student values(4,'Pham Nguyen Hung Anh','12345678',1,'hunganh@gmail.com',2)
insert into Student values(5,'Pham Hong Quang','12345678',1,'phamhongquang@gmail.com',2)
select * from student


insert into Semester values(1,'SU2022','2022-05-29','2022-09-30',1)
insert into Semester values(2,'FA2021','2021-07-10','2021-10-10',2)
insert into Semester values(3,'SU2021','2021-05-28','2021-09-28',3)
insert into Semester values(4,'SP2022','2022-01-10','2022-05-10',4)
select * from Semester


insert into Topic values(1,'CPManagement-Review',6,'Manage and review on this web',2,2)
insert into Topic values(2,'PetCareSystem',6,'The best solution to manage and service your pet',5,2)
insert into Topic values(3,'PT Tranning app',6,'The way to transform to the monster',3,2)
insert into Topic values(4,'Game Animation',10,'Like a little MCU movie',5,2)
select * from Topic


insert into Groups values(1,'Beaky Blinders',1)
insert into Groups values(2,'Group 2',1)	
insert into Groups values(3,'Group 3',2)
insert into Groups values(4,'Group 4',4)
select * from Groups


insert into StudentGroup values(1,1,1,1)
insert into StudentGroup values(2,2,1,0)
insert into StudentGroup values(3,3,1,0)
insert into StudentGroup values(4,4,1,0)
insert into StudentGroup values(5,5,1,0)
select * from StudentGroup


insert into Lecturer values(1,'Lam Huu Khanh Phuong','12345678',1,'phuonglhk@fe.edu.vn')
select * from Lecturer


insert into LecturerTopic values(1,1,1)
insert into LecturerTopic values(2,1,1)
select * from LecturerTopic


insert into Project values(1,'Manage and review on this web','CPManagement-Review','https://github.com/phhgquang/SWP391',1,1,1)
insert into Project values(2,'The best solution to manage and service your pet','PetCareSystem','',2,1,2)
insert into Project values(3,'The way to transform to the monster','PT Tranning app','',3,1,3)
insert into Project values(4,'Like a little MCU movie','Game Animation','',4,1,4)
select * from Project


insert into ProjectLecturer values(1,1,1)
insert into ProjectLecturer values(2,2,1)
select * from ProjectLecturer


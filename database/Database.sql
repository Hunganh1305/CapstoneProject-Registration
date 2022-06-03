use master

drop database SWP391

CREATE DATABASE SWP391
-- DROP DATABASE SWP391
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

CREATE TABLE Department (
	DepartmentId INT PRIMARY KEY,
	Name VARCHAR(30),	
)

CREATE TABLE Topic(
	TopicId INT PRIMARY KEY,
	Name VARCHAR(30),
	CategoryId INT FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId),
	Description VARCHAR(200),
	BusinessId INT FOREIGN KEY (BusinessId) REFERENCES Business(BusinessId),
	DepartmentId INT FOREIGN KEY (DepartmentId) REFERENCES Department(DepartmentId)
)

CREATE TABLE LectureTopic (
	ID INT PRIMARY KEY,
	LecturerId INT NOT NULL FOREIGN KEY  (LecturerId) REFERENCES Lecturer(LecturerId),
	TopicId INT NOT NULL FOREIGN KEY  (TopicId) REFERENCES Topic(TopicId)
)

CREATE TABLE Semester (
    SemesterId INT PRIMARY KEY,
    Name VARCHAR(30),
    StartDate DATE,
    EndDate DATE,
	TopicId INT FOREIGN KEY (TopicId) REFERENCES Topic(TopicId)
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


CREATE DATABASE SWP391
-- DROP DATABASE SWP391
-- SELECT * FROM Student
-- SELECT * FROM Lecturer
-- SELECT * FROM Semester
-- SELECT * FROM Business
-- SELECT * FROM Category

CREATE TABLE Student (
    StudentId INT PRIMARY KEY,
    Name VARCHAR(30),
    Password VARCHAR(30) NOT NULL,
    Status INT,
    Email VARCHAR(50) UNIQUE
)

CREATE TABLE Lecturer (
    LecturerId INT PRIMARY KEY,
    Name VARCHAR(30),
    Password VARCHAR(30) NOT NULL,
    Status INT,
    Email VARCHAR(50) UNIQUE
)

CREATE TABLE Semester (
    SemesterId INT PRIMARY KEY,
    Name VARCHAR(30),
    StartDate DATE,
    EndDate DATE
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
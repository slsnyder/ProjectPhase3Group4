CREATE TABLE Student (
    studentId INT(7) PRIMARY KEY,
    lastName VARCHAR(25) NOT NULL,
    firstName VARCHAR(25) NOT NULL,
    academicProgram VARCHAR(3) NOT NULL,
    degreeLevel VARCHAR(3) NOT NULL,
    gradTerm VARCHAR(6) NOT NULL,
    gradYear INT(4) NOT NULL,
    gpa DECIMAL(4, 3) NOT NULL,
    uwEmail VARCHAR(15) NOT NULL,
    externalEmail VARCHAR(254) NOT NULL
);

CREATE TABLE CollegeTransfer (
    studentId INT(7) references Student(studentId),
    schoolName VARCHAR(50) NOT NULL,
    transferGpa DECIMAL(4,3) NOT NULL,
    transferYear INT(4) NOT NULL
);

CREATE TABLE Company (
    companyName VARCHAR(50) PRIMARY KEY
);

CREATE TABLE Employment (
	employmentId INT(11) auto_increment PRIMARY KEY,
    studentId INT(7) references Student(studentId),
	companyName VARCHAR(50) references Company(companyName),
	current TINYINT(1) NOT NULL,
	positionDescription VARCHAR(200),
	salary INT(11),
	internship TINYINT(1) NOT NULL
);

CREATE TABLE Skill (
    skill VARCHAR(25) PRIMARY KEY
);

CREATE TABLE EmploymentSkill (
    employmentId INT(7) references Employment(employmentId),
    skill VARCHAR(25) references Skill(skill),
    PRIMARY KEY (employmentId, skill)
);

CREATE TABLE UserRole (
    role VARCHAR(13) PRIMARY KEY
);

CREATE TABLE User (
    uwEmail VARCHAR(15) NOT NULL,
    password VARCHAR(20) NOT NULL,
    role VARCHAR(13) references UserRole(role)
);

INSERT INTO UserRole VALUES
('Advisor'),
('Faculty'),
('Administrator');
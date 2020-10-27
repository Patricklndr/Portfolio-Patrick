CREATE DATABASE RamenShop

USE RamenShop

CREATE TABLE Customer (
	CustomerId VARCHAR(5) PRIMARY KEY,
	CustomerName VARCHAR(50),
	CustomerDOB DATE,
	CustomerGender VARCHAR(6),
	CustomerAddress VARCHAR(100),
	CustomerPhone VARCHAR(15),

	CONSTRAINT CustomerIdCheck CHECK (CustomerId LIKE 'CU[0-9][0-9][0-9]'),
	CONSTRAINT CustomerGenderCheck CHECK (CustomerGender LIKE 'Female' OR CustomerGender LIKE 'Male'),
	CONSTRAINT CustomerAddressCheck CHECK (CustomerAddress LIKE '% Street')
	)

CREATE TABLE Staff(
	StaffId VARCHAR(5) PRIMARY KEY,
	StaffName VARCHAR(50),
	StaffGender VARCHAR(6),
	StaffDOB DATE,
	StaffAddress VARCHAR(100),
	StaffPhone VARCHAR(15),
	StaffSalary INT,

	CONSTRAINT StaffIdCheck CHECK (StaffId LIKE 'ST[0-9][0-9][0-9]'),
	CONSTRAINT StaffGenderCheck CHECK (StaffGender LIKE 'Female' OR StaffGender LIKE 'Male'),
	CONSTRAINT StaffAddressCheck CHECK (StaffAddress LIKE '% Street'),
	CONSTRAINT StaffSalaryCheck CHECK (StaffSalary BETWEEN 1500000 AND 3500000) 
	)

CREATE TABLE Supplier(
	SupplierId VARCHAR(5) PRIMARY KEY,
	SupplierName VARCHAR(20),
	SupplierAddress VARCHAR(100),
	SupplierPhone VARCHAR(15),

	CONSTRAINT SupplierIdCheck CHECK (SupplierId LIKE 'SP[0-9][0-9][0-9]'),
	CONSTRAINT SupplierAddressCheck CHECK (SupplierAddress LIKE '% Street')
)


CREATE TABLE Ingredient(
	IngredientId VARCHAR(5) PRIMARY KEY,
	IngredientName VARCHAR(20),
	IngredientStock NUMERIC,

	CONSTRAINT IngredientIdCheck CHECK (IngredientId LIKE 'RI[0-9][0-9][0-9]')
)

CREATE TABLE Ramen(
	RamenId VARCHAR(5) PRIMARY KEY,
	RamenName VARCHAR(20),
	RamenPrice NUMERIC,

	CONSTRAINT RamenIdCheck CHECK (RamenId LIKE 'RA[0-9][0-9][0-9]'),
	CONSTRAINT RameNameCheck CHECK (RamenName LIKE '% %')
)

CREATE TABLE Recipe(
	RamenId VARCHAR(5) FOREIGN KEY(RamenId) REFERENCES Ramen(RamenId) ON UPDATE CASCADE ON DELETE CASCADE,
	IngredientId VARCHAR(5) FOREIGN KEY(IngredientId) REFERENCES Ingredient(IngredientId) ON UPDATE CASCADE ON DELETE CASCADE,
	IngredientQuantity NUMERIC(3),
	PRIMARY KEY(RamenId, IngredientId)
)

CREATE TABLE SalesTransaction(
	SalesId VARCHAR(5) PRIMARY KEY,
	StaffId VARCHAR(5) FOREIGN KEY(StaffId) REFERENCES Staff(StaffId) ON UPDATE CASCADE ON DELETE CASCADE,
	CustomerId VARCHAR(5) FOREIGN KEY(CustomerId) REFERENCES Customer(CustomerId) ON UPDATE CASCADE ON DELETE CASCADE,
	SalesDate DATE,

	CONSTRAINT SalesIdCheck CHECK (SalesId LIKE 'SL[0-9][0-9][0-9]')
)

CREATE TABLE SalesTransactionDetail(
	SalesId VARCHAR(5) FOREIGN KEY(SalesId) REFERENCES SalesTransaction(SalesId) ON UPDATE CASCADE ON DELETE CASCADE,
	RamenId VARCHAR(5) FOREIGN KEY(RamenId) REFERENCES Ramen(RamenId) ON UPDATE CASCADE ON DELETE CASCADE,
	Quantity NUMERIC(3),
	PRIMARY KEY(SalesId, RamenId)
)

CREATE TABLE PurchaseTransaction(
	PurchaseId VARCHAR(5) PRIMARY KEY,
	StaffId VARCHAR(5) FOREIGN KEY(StaffId) REFERENCES Staff(StaffId) ON UPDATE CASCADE ON DELETE CASCADE,
	SupplierId VARCHAR(5) FOREIGN KEY(SupplierId) REFERENCES Supplier(SupplierId) ON UPDATE CASCADE ON DELETE CASCADE,
	PurchaseDate DATE,

	CONSTRAINT PurchaseIdCheck CHECK (PurchaseId LIKE 'PU[0-9][0-9][0-9]')
)

CREATE TABLE PurchaseTransactionDetail(
	PurchaseId VARCHAR(5) FOREIGN KEY(PurchaseId) REFERENCES PurchaseTransaction(PurchaseId) ON UPDATE CASCADE ON DELETE CASCADE,
	IngredientId VARCHAR(5) FOREIGN KEY(IngredientId) REFERENCES Ingredient(IngredientId) ON UPDATE CASCADE ON DELETE CASCADE,
	PurchaseQuantity NUMERIC(3),

	PRIMARY KEY(PurchaseId, IngredientId)
)


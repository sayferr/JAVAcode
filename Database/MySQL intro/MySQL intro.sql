#CREATE DATABASE Intro 
#use Intro

#drop table Persons
#drop table students

/* CREATE TABLE Persons(
id INT, 
name NVARCHAR(50),
surname NVARCHAR(50),
age INT NOT NULL
) */
#SELECT * FROM Persons

-- 1 students
CREATE TABLE students(
id INT, 
name NVARCHAR(50),
surname NVARCHAR(50),
age INT NOT NULL
);

-- 2. Books 
DROP TABLE IF EXISTS Books;
CREATE TABLE Books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    year INT
);

-- 3. Cities 
DROP TABLE IF EXISTS Cities;
CREATE TABLE Cities (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50)
);

-- 4. Products 
DROP TABLE IF EXISTS Products;
CREATE TABLE Products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    price DECIMAL(10,2)
);

-- 5. Employees 
DROP TABLE IF EXISTS Employees;
CREATE TABLE Employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    salary DECIMAL(10,2)
);

-- 6. Categories 
DROP TABLE IF EXISTS Categories;
CREATE TABLE Categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    description VARCHAR(255)
);

-- 7. Orders 
DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    total DECIMAL(10,2)
);

-- 8. Customers
DROP TABLE IF EXISTS Customers;
CREATE TABLE Customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    lastname VARCHAR(50),
    firstname VARCHAR(50)
);

-- 9. Product
DROP TABLE IF EXISTS Product;
CREATE TABLE Product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    price DECIMAL(10,2)
);

-- 10 Product 
DROP TABLE IF EXISTS Products;
CREATE TABLE Products (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50),
price DECIMAL(10,2)
)
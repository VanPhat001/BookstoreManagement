CREATE DATABASE BookStoreManagement;
USE BookStoreManagement;

CREATE TABLE customer (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    avatar VARCHAR(1000) NOT NULL,
    name VARCHAR(256),
    gender ENUM('male', 'female', 'other') NOT NULL DEFAULT 'male',
    phone VARCHAR(15) DEFAULT NULL,
    address VARCHAR(1000) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE admin (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    avatar VARCHAR(1000) NOT NULL,
    name VARCHAR(256),
    gender ENUM('male', 'female', 'other') NOT NULL DEFAULT 'male',
    phone VARCHAR(15) DEFAULT NULL,
    address VARCHAR(1000) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE order_detail (
    id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT now(),
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id)
        REFERENCES customer (id)
);

CREATE TABLE publisher (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(256),
    address VARCHAR(100) DEFAULT NULL,
    hotline VARCHAR(15) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE author (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(256),
    pseudonym VARCHAR(256),
    PRIMARY KEY (id)
);

CREATE TABLE book (
    id INT NOT NULL AUTO_INCREMENT,
    publisher_id INT NOT NULL,
    author_id INT NOT NULL,
    name VARCHAR(256) NOT NULL,
    book_cover VARCHAR(1000) NOT NULL,
    price DECIMAL(10 , 2 ) NOT NULL,
    CHECK (price >= 0),
    PRIMARY KEY (id),
    FOREIGN KEY (publisher_id)
        REFERENCES publisher (id),
    FOREIGN KEY (author_id)
        REFERENCES author (id)
);

CREATE TABLE order_item (
    order_detail_id INT NOT NULL,
    book_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10 , 2 ) NOT NULL,
    CHECK (quantity > 0),
    CHECK (price >= 0),
    PRIMARY KEY (order_detail_id , book_id),
    FOREIGN KEY (order_detail_id)
        REFERENCES order_detail (id),
    FOREIGN KEY (book_id)
        REFERENCES book (id)
);

CREATE TABLE category (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(256) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE book_category (
    book_id INT NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (book_id , category_id),
    FOREIGN KEY (book_id)
        REFERENCES book (id),
    FOREIGN KEY (category_id)
        REFERENCES category (id)
);

CREATE TABLE cart_item (
    customer_id INT NOT NULL,
    book_id INT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (customer_id , book_id),
    FOREIGN KEY (customer_id) REFERENCES customer (id),
    FOREIGN KEY (book_id) REFERENCES book (id)
);

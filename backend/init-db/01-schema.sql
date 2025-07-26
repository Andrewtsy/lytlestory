CREATE DATABASE IF NOT EXISTS lytlestory;

USE lytlestory;

CREATE TABLE stories (
    id BINARY(16) NOT NULL PRIMARY KEY,
    title VARCHAR(256),
    author VARCHAR(256),
    genre VARCHAR(256),
    file_name VARCHAR(256),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
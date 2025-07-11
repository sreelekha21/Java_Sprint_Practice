
-- Movie Streaming Platform Database Setup (MySQL)
-- ===============================================

-- Drop existing tables if they exist (for re-run safety)
DROP TABLE IF EXISTS UserRoles, Ratings, WatchHistory, Payments, Subscriptions, MovieGenres, Genres, Movies, Roles, Users;

-- Users Table
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    date_of_birth DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Roles Table
CREATE TABLE Roles (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(50) UNIQUE NOT NULL
);

-- UserRoles Mapping Table
CREATE TABLE UserRoles (
    user_id INT,
    role_id INT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (role_id) REFERENCES Roles(role_id)
);

-- Movies Table
CREATE TABLE Movies (
    movie_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    release_year YEAR,
    duration INT,
    language VARCHAR(50),
    rating DECIMAL(2,1),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Genres Table
CREATE TABLE Genres (
    genre_id INT AUTO_INCREMENT PRIMARY KEY,
    genre_name VARCHAR(100) NOT NULL UNIQUE
);

-- MovieGenres Table
CREATE TABLE MovieGenres (
    movie_id INT,
    genre_id INT,
    PRIMARY KEY (movie_id, genre_id),
    FOREIGN KEY (movie_id) REFERENCES Movies(movie_id),
    FOREIGN KEY (genre_id) REFERENCES Genres(genre_id)
);

-- Subscriptions Table
CREATE TABLE Subscriptions (
    subscription_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    plan_name VARCHAR(100),
    price DECIMAL(6,2),
    start_date DATE,
    end_date DATE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- WatchHistory Table
CREATE TABLE WatchHistory (
    history_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    movie_id INT,
    watched_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (movie_id) REFERENCES Movies(movie_id)
);

-- Ratings Table
CREATE TABLE Ratings (
    rating_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    movie_id INT,
    rating_value INT CHECK (rating_value >= 1 AND rating_value <= 5),
    rated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (movie_id) REFERENCES Movies(movie_id)
);

-- Payments Table
CREATE TABLE Payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    amount DECIMAL(10,2),
    payment_date DATETIME,
    payment_method VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Sample Data Insertion (Wrapped in Transaction with ROLLBACK Demo)
START TRANSACTION;

-- Try Block Simulation (MySQL doesn't have TRY/CATCH, we simulate rollback manually)
-- Insert Roles
INSERT INTO Roles (role_name) VALUES ('Admin'), ('Subscriber');

-- Insert Users
INSERT INTO Users (full_name, email, password, date_of_birth) 
VALUES ('Sreelekha Peram', 'sree@example.com', 'pass123', '2000-01-01'),
       ('Rahul Sharma', 'rahul@example.com', 'rahul123', '1999-07-15');

-- Insert UserRoles
INSERT INTO UserRoles (user_id, role_id) VALUES (1, 2), (2, 2);

-- Insert Genres
INSERT INTO Genres (genre_name) VALUES ('Drama'), ('Action'), ('Comedy');

-- Insert Movies
INSERT INTO Movies (title, description, release_year, duration, language, rating)
VALUES ('Inception', 'A dream within a dream', 2010, 148, 'English', 8.8),
       ('3 Idiots', 'A journey of 3 engineering students', 2009, 171, 'Hindi', 9.1);

-- Insert MovieGenres
INSERT INTO MovieGenres (movie_id, genre_id) VALUES (1, 2), (2, 1);

-- Insert Subscriptions
INSERT INTO Subscriptions (user_id, plan_name, price, start_date, end_date)
VALUES (1, 'Premium', 299.99, '2025-06-01', '2025-07-01'),
       (2, 'Basic', 149.99, '2025-06-05', '2025-07-05');

-- Insert WatchHistory
INSERT INTO WatchHistory (user_id, movie_id) VALUES (1, 1), (2, 2);

-- Insert Ratings
INSERT INTO Ratings (user_id, movie_id, rating_value) VALUES (1, 1, 5), (2, 2, 4);

-- Insert Payments
INSERT INTO Payments (user_id, amount, payment_date, payment_method)
VALUES (1, 299.99, NOW(), 'Credit Card'),
       (2, 149.99, NOW(), 'Net Banking');

-- Simulating a failed insert to demonstrate ROLLBACK (duplicate email)
-- Uncomment to test ROLLBACK
-- INSERT INTO Users (full_name, email, password, date_of_birth) VALUES ('Test User', 'sree@example.com', 'test123', '1995-10-10');

-- If everything is fine
COMMIT;

-- Otherwise, you could ROLLBACK manually
-- ROLLBACK;

-- Phase 1 & 2: SQL Schema for Movie Streaming Platform

-- [Schema code, sample data, queries, and indexes from earlier remain unchanged above]

-- Phase 5: Automation & Security

-- 1. Trigger: Automatically deactivate users after subscription expires
DELIMITER //
CREATE TRIGGER deactivate_user_after_subscription
AFTER UPDATE ON subscription
FOR EACH ROW
BEGIN
    IF NEW.end_date < CURDATE() THEN
        UPDATE user_account SET is_active = FALSE WHERE user_id = NEW.user_id;
    END IF;
END;//
DELIMITER ;

-- 2. Stored Procedure: Safely insert a new rating with validation
DELIMITER //
CREATE PROCEDURE insert_rating (
    IN p_user_id INT,
    IN p_movie_id INT,
    IN p_rating INT,
    IN p_review TEXT
)
BEGIN
    DECLARE rating_exists INT;

    SELECT COUNT(*) INTO rating_exists
    FROM rating
    WHERE user_id = p_user_id AND movie_id = p_movie_id;

    IF rating_exists = 0 THEN
        INSERT INTO rating (user_id, movie_id, rating, review_text)
        VALUES (p_user_id, p_movie_id, p_rating, p_review);
    ELSE
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'User has already rated this movie.';
    END IF;
END;//
DELIMITER ;

-- 3. Transaction Example: Updating subscription with rollback on error
START TRANSACTION;

UPDATE subscription
SET total_amount = total_amount + 100.00
WHERE user_id = 1;

-- Simulate error
-- ROLLBACK; -- Uncomment to cancel

COMMIT;

-- 4. JSON Example: Storing user preferences (optional column)
ALTER TABLE user_account
ADD preferences JSON;

-- Example insert with JSON data
UPDATE user_account
SET preferences = '{"theme": "dark", "language": "English", "autoplay": true}'
WHERE user_id = 1;

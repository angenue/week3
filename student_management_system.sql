USE student_management_system;

CREATE TABLE IF NOT EXISTS `students` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50),
`age` INT,
`grade` VARCHAR(50)
);

INSERT INTO `students` (`name`, `age`, `grade`) VALUES
    ('Johnny Depp', 60, 'A'),
    ('Brad Pitt', 60, 'C'),
    ('Ryan Reynolds', 47, 'C'),
    ('Ryan Gosling', 43, 'A'),
    ('Ben Affleck', 51, 'B');
    
SELECT * FROM `students`;

SELECT * FROM `students` 
WHERE `age` > 18;

SELECT * FROM `students` 
WHERE `grade` = 'A';

UPDATE `students`
SET `age` = 17
WHERE `id` = 4;

DELETE FROM `students`
WHERE `id` = 5;



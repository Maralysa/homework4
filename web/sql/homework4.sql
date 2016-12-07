DROP DATABASE IF EXISTS livelaughlove;
CREATE DATABASE livelaughlove;

USE livelaughlove;

CREATE TABLE users(firstName VARCHAR(40), 
					lastName VARCHAR(40), 
					email VARCHAR(40) NOT NULL PRIMARY KEY, 
                    bookTitle VARCHAR(100), dueDate DATE);

INSERT INTO users VALUES('Dave', 'Powell', 'dpowell2@elon.edu', 'JavaServlets and JSP', '2016-12-02'),
						('Lane', 'Peeler', 'epeeler@elon.edu', 'Mercy of Thin Air', '2016-11-30');
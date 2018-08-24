
--
-- Database: `springbootemployee`
--

-- --------------------------------------------------------

--
CREATE DATABASE `springbootemployee`;
use `springbootemployee`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `notes`;
 create table users (
        user_id int(10) NOT NULL,
        username varchar(50),
        country varchar(30),
        enabled varchar(30),
        full_name varchar(100),
        email VARCHAR(255) NOT NULL,
        password varchar(800) not null,
        role varchar(50)
       );
INSERT INTO users(user_id,username,country,enabled,full_name,email,password, role) VALUES
 (3,'chandan','Ind','1','chandan singh','chandan1@gmail.com','chandan','ADMIN');
 
 select * from users;
 
 create table notes (
        notes_id int(10) NOT NULL,
        title varchar(100) not null,
        description varchar(100) not null,        
        creation_date DATE,
        update_date DATE,
         primary key (notes_id)
            );
            
 
  INSERT INTO notes(notes_id,title,description,creation_date,update_date) VALUES
    (3,'Master12','Degree of post graduate12','2018-08-15','2018-08-15');

select * from notes;



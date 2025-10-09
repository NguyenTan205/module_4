create database member_security_jwt;

use member_security_jwt;

CREATE TABLE user (
 id int(11) NOT NULL AUTO_INCREMENT,
 username varchar(255) NOT NULL,
 password varchar(60) NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE role (
 id int(11) NOT NULL AUTO_INCREMENT,
 name varchar(255) NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE user_role (
 user_id int(11) NOT NULL,
 role_id int(11) NOT NULL,
 PRIMARY KEY (user_id,role_id)
);


-- Tạo role
insert into role(name) values ('ROLE_MEMBER'), ('ROLE_ADMIN');

-- Tạo user
insert into user(username, password) 
values ('member', '$2a$12$YjdrZ3uWzBpCPMgjybj9iOBGiTkxyx1L7M69XEVK8W5NjUV2eTsjS'),
       ('admin',  '$2a$12$YjdrZ3uWzBpCPMgjybj9iOBGiTkxyx1L7M69XEVK8W5NjUV2eTsjS'); 

-- Gán quyền
insert into user_role(user_id, role_id) values (1, 1); 
insert into user_role(user_id, role_id) values (2, 1), (2, 2); 

select username, length(password) from user;
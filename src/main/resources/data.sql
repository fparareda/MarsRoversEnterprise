/**
 * CREATE Script for init of DB
 */

-- Create users

insert into user (id, password, username) values (1, 'pwd1', 'user1');
insert into user (id, password, username) values (2, 'pwd2', 'user2');
insert into user (id, password, username) values (3, 'pwd3', 'user3');
insert into user (id, password, username) values (4, 'pwd4', 'user4');

-- Create Roles

INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);
INSERT INTO user_role(user_id, role_id) VALUES(3,1);

-- Create Positions

insert into position (id, latitude, longitude) values (1, 123.12, 3.56);
insert into position (id, latitude, longitude) values (2, 343.78, 23.89);
insert into position (id, latitude, longitude) values (3, 789.43, 68.15);


-- Create Mars Rovers
insert into mars_rover (id, position_id, charging) values (1, 1, false);
insert into mars_rover (id, position_id, charging) values (2, 2, false);
insert into mars_rover (id, position_id, charging) values (3, 3, false);
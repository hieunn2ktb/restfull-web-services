insert into user_details (id, name, birth_Date)
    values ('1', 'admin', current_date()),
    ('2', 'user', current_date()),
    ('3', 'guest', current_date()),
    ('4', 'test', current_date());

insert into post (id, description, user_id) values
('1', 'First Post', '1'),
('2', 'Second Post', '1'),
('3', 'Third Post', '2');
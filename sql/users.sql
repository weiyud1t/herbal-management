CREATE TABLE `users` (
                         `username` VARCHAR(50) NOT NULL,
                         `password` VARCHAR(50) NOT NULL,
                         PRIMARY KEY (`username`)
);
INSERT INTO `users` (username, password) VALUES
                                             ('admin', '123'),
                                             ('asd', '123'),
                                             ('Charlie', 'dT9AjdfuVz'),
                                             ('Diana', 'bF8kppYANvpq'),
                                             ('Evan', '91zseCs');

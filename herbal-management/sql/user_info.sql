CREATE TABLE `user_info` (
                             `id` INT AUTO_INCREMENT,
                             `username` VARCHAR(50) NOT NULL,
                             `age` INT,
                             `email` VARCHAR(100),
                             `phone_number` VARCHAR(20) UNIQUE,
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `username` (`username`)
);
INSERT INTO `user_info` (username, age, email, phone_number) VALUES
                                                                 ('admin', 30, 'oir5t_eag@foxmail.com', '11813990967'),
                                                                 ('asd', 25, 'heogsdvhjg@gmail.com', '12595188584'),
                                                                 ('Charlie', 28, 'r48_54iot@gmail.com', '11354679488'),
                                                                 ('Diana', 32, '295hes6z@foxmail.com', '17750667983'),
                                                                 ('Evan', 27, 'vhtrap0q@outlook.com', '13072297528');

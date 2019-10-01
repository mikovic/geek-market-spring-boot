CREATE TABLE students (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  examgrade int(4) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `students`
(`username`,`examgrade`) VALUES
('Тарас',4),
('Евгений',3),
('Алена',2),
('Владимир',4),
('Антон',5),
('Иван',4),
('Петр',3),
('Константин',5),
('Василий',4),
('Артем',5),
('Дмитрий',4),
('Данил',5),
('Наташа',5),
('Марина',5),
('Ольга',5),
('Денис',5),
('Андрей',4),
('Мария',3),
('Катерина',4),
('Людмила',4);

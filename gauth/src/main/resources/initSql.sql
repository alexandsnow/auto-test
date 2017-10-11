CREATE TABLE `auto_test_user` (
  `USER_ID` bigint(20) NOT NULL,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `ADMIN` char(3) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


insert into auto_test_user (user_id, username, password, first_name,last_name, admin) values (4, 'daisy','$2a$10$aNoR88g5b5TzSKb7mQ1nQOkyEwfHVQOxHY0HX7irI8qWINvLDWRyS','Daisy', 'Duck', 'no');
insert into auto_test_user (user_id, username, password, first_name,last_name, admin) values (5, 'clarabelle','$2a$10$cuTJd2ayEwXfsPdoF5/hde6gzsPx/gEiv8LZsjPN9VPoN5XVR8cKW','Clarabelle', 'Cow', 'no');
insert into auto_test_user (user_id, username, password, first_name,last_name, admin) values (6, 'admin','$2a$10$JQOfG5Tqnf97SbGcKsalz.XpDQbXi1APOf2SHPVW27bWNioi9nI8y','Super', 'Admin', 'yes');
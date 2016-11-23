DROP TABLE `book_table` if exists;
CREATE TABLE `book_table` (
  `isbn` varchar(20) NOT NULL,
  `book_name` varchar(100) NOT NULL,
  `complete_date` datetime NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_on` datetime DEFAULT NULL,
  `revision` bit(1) DEFAULT NULL,
  `start_date` datetime NOT NULL,
  `type` varchar(90) NOT NULL,
  PRIMARY KEY (`isbn`)
);
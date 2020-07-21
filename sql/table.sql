CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iwylx6fb2dqdw8kfc31vaiiyp` (`code`),
  UNIQUE KEY `UK_t8o6pivur7nn124jehx7cygw5` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `books` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `info` longtext,
  `name` varchar(200) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_eh6bfj824qyn40pii29i90bll` (`name`),
  KEY `FK_lna470nsjh6u843tbpi35mnba` (`category_id`),
  CONSTRAINT `FK_lna470nsjh6u843tbpi35mnba` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
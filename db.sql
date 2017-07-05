CREATE TABLE `food` (
  `id`         INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `goodsName`      VARCHAR(25)      NOT NULL,
  `price`   VARCHAR(25)      NOT NULL,
  `originPrice`   VARCHAR(25)      NOT NULL,
  `cover`   VARCHAR(25)      NOT NULL,
  `count`   VARCHAR(25)      NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;


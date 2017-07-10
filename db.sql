-- auto Generated on 2017-07-06 12:53:29
-- DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `content`     VARCHAR(50) NOT NULL,
  `goods_id`    BIGINT(15)  NOT NULL,
  `user_id`     BIGINT(15)  NOT NULL,
  `id`          BIGINT(15)  NOT NULL AUTO_INCREMENT,
  `create_time` BIGINT(15)  NOT NULL,
  `update_time` BIGINT(15)  NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;

-- auto Generated on 2017-07-06 12:52:27
-- DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `goods_name`   VARCHAR(50)   NOT NULL,
  `price`        DOUBLE(16, 4) NOT NULL,
  `count`        INT(11)       NOT NULL,
  `cover`        VARCHAR(50)   NOT NULL,
  `origin_price` DOUBLE(16, 4) NOT NULL,
  `shop_id`      BIGINT(15)    NOT NULL,
  `sell_num`     INT(11)       NOT NULL DEFAULT 0,
  `good_comment` INT(11) ,
  `bad_comment`  INT(11),
  `click_num`    INT(11)       NOT NULL DEFAULT 0,
  `type`         VARCHAR(50)   NOT NULL,
  `description`  VARCHAR(50)   NOT NULL,
  `flag`         VARCHAR(50),
  `id`           BIGINT(15)    NOT NULL AUTO_INCREMENT,
  `create_time`  BIGINT(15)    NOT NULL,
  `update_time`  BIGINT(15)    NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;

-- auto Generated on 2017-07-06 12:53:06
-- DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shop_name`   VARCHAR(50) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  `cover`       VARCHAR(50) NOT NULL,
  `boss_id`     BIGINT(15)  NOT NULL,
  `id`          BIGINT(15)  NOT NULL AUTO_INCREMENT,
  `create_time` BIGINT(15)  NOT NULL,
  `update_time` BIGINT(15)  NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT '`shop`';

-- auto Generated on 2017-07-06 12:53:17
-- DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `email`       VARCHAR(50) NOT NULL,
  `password`    VARCHAR(50) NOT NULL,
  `type`        INT(11)     NOT NULL DEFAULT 1,
  `goods_ids`   VARCHAR(50),
  `id`          BIGINT(15)  NOT NULL AUTO_INCREMENT,
  `create_time` BIGINT(15)  NOT NULL,
  `update_time` BIGINT(15)  NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT '`user`';

-- auto Generated on 2017-07-10 10:50:21
-- DROP TABLE IF EXISTS `sales_volume`;
CREATE TABLE `sales_volume`(
  `goods_id` BIGINT (15) NOT NULL,
  `price` DOUBLE (16,4) NOT NULL,
  `id` BIGINT (15) NOT NULL AUTO_INCREMENT,
  `create_time` BIGINT (15) NOT NULL,
  `update_time` BIGINT (15) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`sales_volume`';

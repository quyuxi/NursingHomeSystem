
SET foreign_key_checks = 0;
/*
  老人
*/

-- ----------------------------
-- Table structure for Elder
-- ----------------------------
DROP TABLE IF EXISTS `Elder`;
CREATE TABLE `Elder` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT "姓名",
  `sex` varchar(255) NOT NULL COMMENT "性别",
  `birthday` date  NOT NULL COMMENT "出生日期",
  `phone` varchar(255) NOT NULL COMMENT "手机号",
  `Id_card` varchar(255) NOT NULL COMMENT "身份证号",
  `start_time` varchar(255) NOT NULL COMMENT "入院时间",
  `address` varchar(255) NOT NULL COMMENT "家庭住址",
  `n_id` int(10) NOT NULL  COMMENT '所属养老院id',
  `ring_id` int(255) NOT NULL  COMMENT '手环识别码',
  PRIMARY KEY (`id`,`ring_id`),
  KEY `n_id` (`n_id`),
  KEY `id` (`id`),
  KEY `r_id` (`ring_id`),
  CONSTRAINT `n_id` FOREIGN KEY (`n_id`) REFERENCES `NursingHome` (`id`),
  CONSTRAINT `r_id` FOREIGN KEY (`ring_id`) REFERENCES `Ring` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;






SET foreign_key_checks = 0;
/*

Ring
*/
-- ----------------------------
-- Table structure for Ring
-- ----------------------------
DROP TABLE IF EXISTS `Ring`;
CREATE TABLE `Ring` (
  `id` int(100) NOT NULL,
  `heart_rate` varchar(255) NOT NULL COMMENT '心率',
  `blood_pressure` int(5) NOT NULL COMMENT '血压',
  `triaxial_acceleration` varchar(50) NOT NULL COMMENT '三轴加速度',
  `triaxial_angular_velocity` varchar(50) NOT NULL COMMENT '三轴角速度',
  `temperature` double(10,0) NOT NULL COMMENT '体温',
  `latitude` varchar(50) NOT NULL COMMENT '纬度',
  `longitude` varchar(50) NOT NULL COMMENT '经度',
  `power` int(3) NOT NULL COMMENT '电池',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;







SET foreign_key_checks = 0;

/*
 养老院
*/

-- ----------------------------
-- Table structure for NursingHome
-- ----------------------------
DROP TABLE IF EXISTS `NursingHome`;
CREATE TABLE `NursingHome` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `NursingHomeName` varchar(255) NOT NULL COMMENT '养老院名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





SET foreign_key_checks = 0;

/*
亲属
*/

-- ----------------------------
-- Table structure for Relatives
-- ----------------------------
DROP TABLE IF EXISTS `Relatives`;
CREATE TABLE `Relatives` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `sex` varchar(255) NOT NULL COMMENT "性别",
  `birthday` date  NOT NULL COMMENT "出生日期",
  `phone` varchar(255) NOT NULL COMMENT "手机号",
  `Id_card` varchar(255) NOT NULL COMMENT "身份证号",
  `address` varchar(255) NOT NULL COMMENT "家庭住址",
  `elder_id` int(50) NOT NULL COMMENT '老人',
  PRIMARY KEY (`id`),
  KEY `elder_id` (`elder_id`),
  CONSTRAINT `elder_id` FOREIGN KEY (`elder_id`) REFERENCES `Elder` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



SET foreign_key_checks = 0;
/*
系统用户
*/

-- ----------------------------
-- Table structure for SystemUser
-- ----------------------------
DROP TABLE IF EXISTS `SystemUser`;
CREATE TABLE `SystemUser` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `n_id` int(50) NOT NULL COMMENT '所属养老院',
  `role` enum('admin','member') NOT NULL DEFAULT 'member' COMMENT '角色：包括管理员和普通用户',
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL COMMENT "手机号",
  PRIMARY KEY (`id`),
  KEY `system_user_to_n_id` (`n_id`),
  CONSTRAINT `system_user_to_n_id` FOREIGN KEY (`n_id`) REFERENCES `NursingHome` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




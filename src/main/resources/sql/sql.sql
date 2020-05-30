



SET foreign_key_checks = 0;
/*
  老人
*/
-- ----------------------------
-- Table structure for Elder
-- ----------------------------

DROP TABLE IF EXISTS `Elder`;
CREATE TABLE `Elder` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT "姓名",
  `sex` varchar(255) NOT NULL COMMENT "性别",
  `birthday` date  NOT NULL COMMENT "出生日期",
  `phone` varchar(255) NOT NULL COMMENT "手机号",
  `id_card` varchar(255) NOT NULL COMMENT "身份证号",
  `start_time` datetime NOT NULL COMMENT "入院时间",
  `address` varchar(255) NOT NULL COMMENT "家庭住址",
  `n_id` varchar(50) NOT NULL  COMMENT '所属养老院id',
  `area` varchar(255) NOT NULL  COMMENT '活动范围',

  PRIMARY KEY (`id`),
  KEY `n_id` (`n_id`),
  CONSTRAINT `n_id` FOREIGN KEY (`n_id`) REFERENCES `NursingHome` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



SET foreign_key_checks = 0;

/*
手环基本信息
Ring
*/
-- ----------------------------
-- Table structure for RingInfo
-- ----------------------------
DROP TABLE IF EXISTS `RingInfo`;
CREATE TABLE `RingInfo` (
         `id` int(100) NOT NULL AUTO_INCREMENT,
       `ring_id` varchar(100) NOT NULL COMMENT '手环唯一识别码',
       `power` int(3) NOT NULL COMMENT '电池电量',
       `elder_id` varchar(50) NOT NULL COMMENT '老人',
       `date_time` datetime NOT NULL COMMENT '最后更新时间',
       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





SET foreign_key_checks = 0;
/*

RingKeyInfo  手环按键信息
字段待补充
*/
-- ----------------------------
-- Table structure for RingKeyInfo
-- ----------------------------
DROP TABLE IF EXISTS `RingKeyInfo`;
CREATE TABLE `RingKeyInfo` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `elder_id` varchar(50) NOT NULL COMMENT '老人',
  `date_time` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `RingKeyInfo_elder_id` (`elder_id`),
  CONSTRAINT `RingKeyInfo_elder_id` FOREIGN KEY (`elder_id`) REFERENCES `Elder` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*
  生理数据
 */

SET foreign_key_checks = 0;

-- ----------------------------
-- Table structure for Physiological
-- ----------------------------
DROP TABLE IF EXISTS `Physiological`;
CREATE TABLE `Physiological` (
        `id` int(100) NOT NULL AUTO_INCREMENT ,
        `heart_rate` varchar(255) NOT NULL COMMENT '心率',
        `blood_pressure` int(5) NOT NULL COMMENT '血压',
        `temperature` double(10,0) NOT NULL COMMENT '体温',
        `elder_id` varchar(50) NOT NULL COMMENT '老人',
        `date_time` datetime NOT NULL COMMENT '最后更新时间',
        PRIMARY KEY (`id`),
        KEY `Physiological_elder_id` (`elder_id`),
        CONSTRAINT `Physiological_elder_id` FOREIGN KEY (`elder_id`) REFERENCES `Elder` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



/*
  位置
 */

SET foreign_key_checks = 0;

-- ----------------------------
-- Table structure for Position
-- ----------------------------
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position` (
         `id` int(100) NOT NULL AUTO_INCREMENT ,
         `latitude` varchar(50) NOT NULL COMMENT '纬度',
         `longitude` varchar(50) NOT NULL COMMENT '经度',
         `elder_id` varchar(50) NOT NULL COMMENT '老人',
         `date_time` datetime NOT NULL COMMENT '最后更新时间',
         PRIMARY KEY (`id`),
         KEY `Position_elder_id` (`elder_id`),
         CONSTRAINT `Position_elder_id` FOREIGN KEY (`elder_id`) REFERENCES `Elder` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*
  姿势
 */

SET foreign_key_checks = 0;

-- ----------------------------
-- Table structure for Posture
-- ----------------------------
DROP TABLE IF EXISTS `Posture`;
CREATE TABLE `Posture` (
       `id` int(100) NOT NULL AUTO_INCREMENT ,
       `triaxial_acceleration` varchar(50) NOT NULL COMMENT '三轴加速度',
       `triaxial_angular_velocity` varchar(50) NOT NULL COMMENT '三轴角速度',
       `elder_id` varchar(50) NOT NULL COMMENT '老人',
       `date_time` datetime NOT NULL COMMENT '最后更新时间',
       PRIMARY KEY (`id`),
       KEY `Posture_elder_id` (`elder_id`),
       CONSTRAINT `Posture_elder_id` FOREIGN KEY (`elder_id`) REFERENCES `Elder` (`id`)
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
  `id` varchar(50) NOT NULL,
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
  `elder_id` varchar(50) NOT NULL COMMENT '老人',
  PRIMARY KEY (`id`),
  KEY `Relatives_elder_id` (`elder_id`),
  CONSTRAINT `Relatives_elder_id` FOREIGN KEY (`elder_id`) REFERENCES `Elder` (`id`)
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
  `n_id` varchar(50) NOT NULL COMMENT '所属养老院',
  `role` enum('admin','member') NOT NULL DEFAULT 'member' COMMENT '角色：包括管理员和普通用户',
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL COMMENT "手机号",
  PRIMARY KEY (`id`),
  KEY `system_user_to_n_id` (`n_id`),
  CONSTRAINT `system_user_to_n_id` FOREIGN KEY (`n_id`) REFERENCES `NursingHome` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




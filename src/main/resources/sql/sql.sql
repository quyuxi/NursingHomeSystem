# CREATE DATABASE IF NOT EXISTS NursingHomeSystem DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

SET foreign_key_checks = 0;
/*
  老人
*/
-- ----------------------------
-- Table structure for Elder
-- ----------------------------

DROP TABLE IF EXISTS `Elder`;
CREATE TABLE `Elder`
(
    `id` int(50)  NOT NULL,
    `name`     varchar(255) NOT NULL COMMENT "姓名",
    `sex`      varchar(255) NOT NULL COMMENT "性别",
    `birthday` date         NOT NULL COMMENT "出生日期",
    `phone`    varchar(255) NOT NULL COMMENT "手机号",
    `idCard`  varchar(255) NOT NULL COMMENT "身份证号",
    `joinTime`     date         NOT NULL COMMENT "入院时间",
    `address`  varchar(255)          COMMENT "家庭住址",
    `area`     varchar(255) NOT NULL COMMENT '活动范围',
     PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



SET foreign_key_checks = 0;

/*
手环基本信息
Ring
*/
-- ----------------------------
-- Table structure for RingInfo
-- ----------------------------
DROP TABLE IF EXISTS `RingInfo`;
CREATE TABLE `RingInfo`
(
    `ring_id`   int(50) NOT NULL COMMENT '手环id',
    `battery`   int(3)      NOT NULL COMMENT '电池电量',
    `date_time` datetime    NOT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`ring_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



SET foreign_key_checks = 0;
/*

RingKeyInfo  手环按键信息
字段待补充
*/
-- ----------------------------
-- Table structure for RingKeyInfo
-- ----------------------------
DROP TABLE IF EXISTS `RingKeyInfo`;
CREATE TABLE `RingKeyInfo`
(
    `id`        int(100)    NOT NULL AUTO_INCREMENT,
    `ring_id`   int(50) NOT NULL COMMENT '手环id',
    `date_time` datetime    NOT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`id`),
    KEY `ringKeyInfo_ring_id` (`ring_id`),
    CONSTRAINT `ringKeyInfo_ring_id` FOREIGN KEY (`ring_id`) REFERENCES `RingInfo` (`ring_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


/*
  生理数据
 */

SET foreign_key_checks = 0;

-- ----------------------------
-- Table structure for PhysicalData
-- ----------------------------
DROP TABLE IF EXISTS `PhysicalData`;
CREATE TABLE `PhysicalData`
(
    `id`        int(100)   PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `heartRate`     varchar(255)  NOT NULL COMMENT '心率',
    `bloodPressuer` int(5)        NOT NULL COMMENT '血压',
    `temperature`    double(10, 0) NOT NULL COMMENT '体温',
    `ring_id`        int(50)   NOT NULL COMMENT '手环id',
    `date_time`      datetime      NOT NULL COMMENT '最后更新时间',

    KEY `p_r_id` (`ring_id`),
    CONSTRAINT `p_r_id` FOREIGN KEY (`ring_id`) REFERENCES `RingInfo` (`ring_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


/*
  位置
 */

SET foreign_key_checks = 0;

-- ----------------------------
-- Table structure for Position
-- ----------------------------
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`
(
    `id`        int(100)   PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `lat`  varchar(50) NOT NULL COMMENT '纬度',
    `lng` varchar(50) NOT NULL COMMENT '经度',
    `ring_id`   int(50) NOT NULL COMMENT '手环id',
    `date_time` datetime    NOT NULL COMMENT '最后更新时间',
    KEY `Position_ring_id` (`ring_id`),
    CONSTRAINT `Position_ring_id` FOREIGN KEY (`ring_id`) REFERENCES `RingInfo` (`ring_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


/*
  姿势
 */

SET foreign_key_checks = 0;

-- ----------------------------
-- Table structure for Posture
-- ----------------------------
DROP TABLE IF EXISTS `Posture`;
CREATE TABLE `Posture`
(
    `id`                        int(100)    NOT NULL AUTO_INCREMENT,
    `acceleration`     varchar(50) NOT NULL COMMENT '三轴加速度',
    `palstance` varchar(50) NOT NULL COMMENT '三轴角速度',
    `ring_id`                   int(50) NOT NULL COMMENT '手环id',
    `date_time`                 datetime    NOT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`id`),
    KEY `Posture_ring_id` (`ring_id`),
    CONSTRAINT `Posture_ring_id` FOREIGN KEY (`ring_id`) REFERENCES `RingInfo` (`ring_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


SET foreign_key_checks = 0;

/*
 养老院
*/

-- ----------------------------
-- Table structure for NursingHome
-- ----------------------------
DROP TABLE IF EXISTS `NursingHome`;
CREATE TABLE `NursingHome`
(
    `id`              int(50)  NOT NULL,
    `NursingHomeName` varchar(255) NOT NULL COMMENT '养老院名',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



SET foreign_key_checks = 0;

/*
亲属
*/

-- ----------------------------
-- Table structure for Relatives
-- ----------------------------
DROP TABLE IF EXISTS `Relative`;
CREATE TABLE `Relative`
(
    `id`       int(50)      NOT NULL AUTO_INCREMENT,
    `name`     varchar(50)  NOT NULL,
    `sex`      varchar(255) NOT NULL COMMENT "性别",
    `birthday` date         NOT NULL COMMENT "出生日期",
    `phone`    varchar(255) NOT NULL COMMENT "手机号",
    `idCard`  varchar(255) NOT NULL COMMENT "身份证号",
    `address`  varchar(255) NOT NULL COMMENT "家庭住址",
    `elderId` int(50)  NOT NULL COMMENT '老人',
    PRIMARY KEY (`id`),
    KEY `Relatives_elder_id` (`elderId`),
    CONSTRAINT `Relatives_elder_id` FOREIGN KEY (`elderId`) REFERENCES `Elder` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



SET foreign_key_checks = 0;
/*
系统用户
*/

-- ----------------------------
-- Table structure for SystemUser
-- ----------------------------
DROP TABLE IF EXISTS `SystemUser`;
CREATE TABLE `SystemUser`
(
    `id`         varchar(50)                 NOT NULL ,
    `nursHomeId` int(50)             NOT NULL COMMENT '所属养老院',
    `role`       enum ('admin','member') NOT NULL DEFAULT 'member' COMMENT '角色：包括管理员和普通用户',
    `password`   varchar(255)            NOT NULL,
    `realName`   varchar(10)             NOT NULL,
    `sex`        varchar(10)             NOT NULL,
    `birthday`   date                    NOT NULL,
    `phone`      varchar(255)            NOT NULL COMMENT "手机号",

    PRIMARY KEY (`id`),
    KEY `system_user_to_n_id` (`nursHomeId`),
    CONSTRAINT `system_user_to_n_id` FOREIGN KEY (`nursHomeId`) REFERENCES `NursingHome` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;




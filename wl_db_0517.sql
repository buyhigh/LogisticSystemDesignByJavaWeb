/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : wl_db

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-16 01:39:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_cartime
-- ----------------------------
DROP TABLE IF EXISTS `tbl_cartime`;
CREATE TABLE `tbl_cartime` (
  `driver` int(11) NOT NULL,
  `transfertool` int(11) NOT NULL,
  KEY `tbl_driver_tbl_cartime_fk` (`driver`),
  KEY `tbl_transfertool_tbl_cartime_fk` (`transfertool`),
  CONSTRAINT `tbl_driver_tbl_cartime_fk` FOREIGN KEY (`driver`) REFERENCES `tbl_drivers` (`driver`) ON DELETE CASCADE,
  CONSTRAINT `tbl_transfertool_tbl_cartime_fk` FOREIGN KEY (`transfertool`) REFERENCES `tbl_transfertool` (`transfertool`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_cartime
-- ----------------------------
INSERT INTO `tbl_cartime` VALUES ('2', '1');

-- ----------------------------
-- Table structure for tbl_dispatch
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dispatch`;
CREATE TABLE `tbl_dispatch` (
  `creater` varchar(100) NOT NULL,
  `dispatch` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` varchar(100) NOT NULL,
  `goodname` varchar(100) NOT NULL,
  `goodquantity` int(11) NOT NULL,
  `transfertool` int(11) NOT NULL,
  `orderdate` datetime NOT NULL,
  `sendname` varchar(20) NOT NULL,
  `sendtel` char(11) NOT NULL,
  `receivername` varchar(20) NOT NULL,
  `receivertel` char(11) NOT NULL,
  `receiverprovince` varchar(10) NOT NULL,
  `receivercity` varchar(20) NOT NULL,
  `receiverstreet` varchar(100) NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`dispatch`),
  KEY `tbl_state_tbl_dispatch_fk` (`state`),
  CONSTRAINT `tbl_state_tbl_dispatch_fk` FOREIGN KEY (`state`) REFERENCES `tbl_state` (`state`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_dispatch
-- ----------------------------
INSERT INTO `tbl_dispatch` VALUES ('管理员', '13', '12345678904', '苹果', '2', '22', '2018-05-01 10:08:34', '蒋杨俊', '13590466093', '蒋杨俊', '13590466093', '广东省', '深圳市', 'test', '2');
INSERT INTO `tbl_dispatch` VALUES ('管理员', '14', '12345678903', '火龙果', '2', '1', '2018-05-01 14:01:27', '蒋杨俊', '13590466093', '张生', '13590466093', '广西壮族自治区', '桂林市', 'test', '2');
INSERT INTO `tbl_dispatch` VALUES ('管理员', '15', '12345678977', '苹果', '2', '1', '2018-05-15 11:46:58', '蒋杨俊', '13590466093', '蒋杨俊', '13590466093', '广东省', '深圳市', '测试', '2');

-- ----------------------------
-- Table structure for tbl_dispuser
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dispuser`;
CREATE TABLE `tbl_dispuser` (
  `dispuser` int(11) NOT NULL AUTO_INCREMENT,
  `dispname` varchar(50) NOT NULL,
  `dispnum` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`dispuser`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_dispuser
-- ----------------------------
INSERT INTO `tbl_dispuser` VALUES ('1', '配送员1', '-4');
INSERT INTO `tbl_dispuser` VALUES ('2', '配送员2', '0');
INSERT INTO `tbl_dispuser` VALUES ('3', '配送员3', '0');
INSERT INTO `tbl_dispuser` VALUES ('4', '配送员4', '0');
INSERT INTO `tbl_dispuser` VALUES ('5', '配送员5', '0');
INSERT INTO `tbl_dispuser` VALUES ('6', '配送员6', '0');
INSERT INTO `tbl_dispuser` VALUES ('7', '配送员7', '0');
INSERT INTO `tbl_dispuser` VALUES ('8', '配送员8', '0');
INSERT INTO `tbl_dispuser` VALUES ('9', '配送员9', '0');
INSERT INTO `tbl_dispuser` VALUES ('10', '配送员10', '0');
INSERT INTO `tbl_dispuser` VALUES ('11', '配送员11', '0');
INSERT INTO `tbl_dispuser` VALUES ('12', '配送员12', '0');
INSERT INTO `tbl_dispuser` VALUES ('13', '配送员13', '0');
INSERT INTO `tbl_dispuser` VALUES ('14', '配送员14', '0');
INSERT INTO `tbl_dispuser` VALUES ('15', '配送员15', '0');

-- ----------------------------
-- Table structure for tbl_dristate
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dristate`;
CREATE TABLE `tbl_dristate` (
  `state` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(50) NOT NULL,
  PRIMARY KEY (`state`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_dristate
-- ----------------------------
INSERT INTO `tbl_dristate` VALUES ('1', '空闲');
INSERT INTO `tbl_dristate` VALUES ('2', '在途');
INSERT INTO `tbl_dristate` VALUES ('3', '请假');

-- ----------------------------
-- Table structure for tbl_drivers
-- ----------------------------
DROP TABLE IF EXISTS `tbl_drivers`;
CREATE TABLE `tbl_drivers` (
  `driver` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `age` int(11) NOT NULL,
  `sex` int(11) NOT NULL,
  `photo` varchar(1000) NOT NULL,
  `driverstate` int(11) NOT NULL,
  PRIMARY KEY (`driver`),
  KEY `tbl_dristate_tbl_drivers_fk` (`driverstate`),
  CONSTRAINT `tbl_dristate_tbl_drivers_fk` FOREIGN KEY (`driverstate`) REFERENCES `tbl_dristate` (`state`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_drivers
-- ----------------------------
INSERT INTO `tbl_drivers` VALUES ('1', '司机1', '35', '1', '1.gif', '2');
INSERT INTO `tbl_drivers` VALUES ('2', '司机2', '35', '1', '1.gif', '2');
INSERT INTO `tbl_drivers` VALUES ('3', '司机3', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('4', '司机4', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('5', '司机5', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('6', '司机6', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('7', '司机7', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('8', '司机8', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('9', '司机9', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('10', '司机10', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('11', '司机11', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('12', '司机12', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('13', '司机13', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('14', '司机14', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('15', '司机15', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('16', '司机16', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('17', '司机17', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('18', '司机18', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('19', '司机19', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('20', '司机20', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('21', '司机21', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('22', '司机22', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('23', '司机23', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('24', '司机24', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('25', '司机25', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('26', '司机26', '35', '1', '1.gif', '1');
INSERT INTO `tbl_drivers` VALUES ('27', '司机27', '35', '1', '1.gif', '1');

-- ----------------------------
-- Table structure for tbl_finconfirm
-- ----------------------------
DROP TABLE IF EXISTS `tbl_finconfirm`;
CREATE TABLE `tbl_finconfirm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dispatchid` int(11) DEFAULT NULL,
  `trataskid` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `consumer` varchar(100) DEFAULT NULL,
  `staff` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_finconfirm
-- ----------------------------
INSERT INTO `tbl_finconfirm` VALUES ('1', '1', '1', '2', '客户1', '运调员1');
INSERT INTO `tbl_finconfirm` VALUES ('2', '2', '2', '1', '客户1', '运调员2');
INSERT INTO `tbl_finconfirm` VALUES ('3', '3', '3', '1', '客户1', '运调员1');
INSERT INTO `tbl_finconfirm` VALUES ('4', '15', '11', '1', '管理员', '管理员');

-- ----------------------------
-- Table structure for tbl_goods
-- ----------------------------
DROP TABLE IF EXISTS `tbl_goods`;
CREATE TABLE `tbl_goods` (
  `goods` int(11) NOT NULL AUTO_INCREMENT,
  `goodsname` varchar(100) NOT NULL,
  `goodsweight` varchar(100) NOT NULL,
  `goodsbulk` varchar(100) NOT NULL,
  `goodsunit` varchar(100) NOT NULL,
  `goodsprice` varchar(100) NOT NULL,
  `indate` datetime DEFAULT NULL,
  PRIMARY KEY (`goods`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_goods
-- ----------------------------
INSERT INTO `tbl_goods` VALUES ('1', '苹果', '1', '3', '千克', '12', '2013-12-02 00:00:00');
INSERT INTO `tbl_goods` VALUES ('2', '梨子', '1', '3', '千克', '15', '2013-12-02 00:00:00');
INSERT INTO `tbl_goods` VALUES ('3', '菠萝', '1', '3', '千克', '30', '2013-12-02 00:00:00');
INSERT INTO `tbl_goods` VALUES ('4', '哈密瓜', '1', '3', '千克', '35', '2013-12-02 00:00:00');
INSERT INTO `tbl_goods` VALUES ('5', '火龙果', '1', '3', '千克', '30', '2013-12-02 00:00:00');
INSERT INTO `tbl_goods` VALUES ('6', '西瓜', '1', '4', '千克', '20', '2013-12-02 00:00:00');
INSERT INTO `tbl_goods` VALUES ('7', '樱桃', '1', '4', '千克', '50', '2013-12-02 00:00:00');
INSERT INTO `tbl_goods` VALUES ('8', '猪肉', '1', '4', '千克', '25', '2013-12-02 00:00:00');
INSERT INTO `tbl_goods` VALUES ('9', '牛肉', '1', '4', '千克', '35', '2013-12-02 00:00:00');
INSERT INTO `tbl_goods` VALUES ('10', '鸡肉', '1', '4', '千克', '15', '2013-12-02 00:00:00');
INSERT INTO `tbl_goods` VALUES ('11', '牡丹花', '1', '4', '千克', '95', '2013-12-02 00:00:00');
INSERT INTO `tbl_goods` VALUES ('15', '玫瑰花', '1', '5', '千克', '90', '2013-12-02 00:00:00');
INSERT INTO `tbl_goods` VALUES ('16', '紫罗兰', '1', '5', '千克', '98', '2013-12-02 00:00:00');
INSERT INTO `tbl_goods` VALUES ('17', '水蜜桃', '100', '100', '千克', '50', '2018-05-14 23:31:46');

-- ----------------------------
-- Table structure for tbl_instorerequest
-- ----------------------------
DROP TABLE IF EXISTS `tbl_instorerequest`;
CREATE TABLE `tbl_instorerequest` (
  `instorerequest` int(11) NOT NULL AUTO_INCREMENT,
  `goods` int(11) NOT NULL,
  `indate` datetime NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '10',
  `store` int(11) NOT NULL DEFAULT '1',
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`instorerequest`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_instorerequest
-- ----------------------------
INSERT INTO `tbl_instorerequest` VALUES ('1', '1', '2013-12-05 13:28:00', '100', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('2', '2', '2013-12-05 13:28:00', '200', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('3', '3', '2013-12-05 13:28:00', '150', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('4', '4', '2013-12-05 13:28:00', '200', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('5', '5', '2013-12-05 13:28:00', '360', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('6', '6', '2013-12-05 13:28:00', '300', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('7', '7', '2013-12-05 13:28:00', '250', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('8', '8', '2013-12-05 13:28:00', '237', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('9', '9', '2013-12-05 13:28:00', '100', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('10', '10', '2013-12-05 13:28:00', '190', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('11', '11', '2013-12-05 13:28:00', '200', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('13', '1', '2013-12-05 13:28:00', '5', '6', '5');
INSERT INTO `tbl_instorerequest` VALUES ('14', '1', '2013-12-05 13:28:00', '1', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('15', '1', '2013-12-05 13:28:00', '10', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('16', '1', '2013-12-05 13:28:00', '100', '5', '5');
INSERT INTO `tbl_instorerequest` VALUES ('17', '1', '2013-12-05 13:28:00', '500', '5', '5');
INSERT INTO `tbl_instorerequest` VALUES ('18', '15', '2013-12-05 13:28:00', '500', '5', '5');
INSERT INTO `tbl_instorerequest` VALUES ('20', '15', '2013-12-05 13:28:00', '50', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('22', '15', '2013-12-05 13:28:00', '1', '6', '5');
INSERT INTO `tbl_instorerequest` VALUES ('23', '16', '2013-12-05 13:28:00', '10', '1', '5');
INSERT INTO `tbl_instorerequest` VALUES ('24', '17', '2018-05-14 23:31:46', '100', '1', '5');

-- ----------------------------
-- Table structure for tbl_outstorerequest
-- ----------------------------
DROP TABLE IF EXISTS `tbl_outstorerequest`;
CREATE TABLE `tbl_outstorerequest` (
  `outstorerequest` int(11) NOT NULL AUTO_INCREMENT,
  `dispatch` int(11) NOT NULL,
  `store` int(11) DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`outstorerequest`),
  UNIQUE KEY `dispatch` (`dispatch`),
  KEY `tbl_state_tbl_outstorerequest_fk` (`state`),
  CONSTRAINT `tbl_state_tbl_outstorerequest_fk` FOREIGN KEY (`state`) REFERENCES `tbl_state` (`state`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_outstorerequest
-- ----------------------------
INSERT INTO `tbl_outstorerequest` VALUES ('10', '13', '1', '5');
INSERT INTO `tbl_outstorerequest` VALUES ('11', '14', '1', '5');
INSERT INTO `tbl_outstorerequest` VALUES ('12', '15', '1', '5');

-- ----------------------------
-- Table structure for tbl_outstoretask
-- ----------------------------
DROP TABLE IF EXISTS `tbl_outstoretask`;
CREATE TABLE `tbl_outstoretask` (
  `outstoretask` int(11) NOT NULL AUTO_INCREMENT,
  `outstorerequest` int(11) NOT NULL,
  `store` int(11) DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`outstoretask`),
  UNIQUE KEY `outstorerequest` (`outstorerequest`),
  KEY `tbl_state_tbl_outstoretask_fk` (`state`),
  CONSTRAINT `tbl_state_tbl_outstoretask_fk` FOREIGN KEY (`state`) REFERENCES `tbl_state` (`state`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_outstoretask
-- ----------------------------
INSERT INTO `tbl_outstoretask` VALUES ('10', '10', '1', '5');
INSERT INTO `tbl_outstoretask` VALUES ('11', '11', '1', '5');
INSERT INTO `tbl_outstoretask` VALUES ('12', '12', '1', '5');

-- ----------------------------
-- Table structure for tbl_profile
-- ----------------------------
DROP TABLE IF EXISTS `tbl_profile`;
CREATE TABLE `tbl_profile` (
  `realname` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `telphone` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_profile
-- ----------------------------
INSERT INTO `tbl_profile` VALUES ('蒋生', '深圳test街道', '1359046609', '客户1', '1');
INSERT INTO `tbl_profile` VALUES ('张生', '深圳test街道', '1359046093', '客户2', '2');
INSERT INTO `tbl_profile` VALUES ('张生', '桂林test街道', '1', '管理员', '3');
INSERT INTO `tbl_profile` VALUES ('黄生', '广西桂林', '13590466093', '客户3', '4');
INSERT INTO `tbl_profile` VALUES ('张生', '桂林', '13590466093', '客户4', '5');

-- ----------------------------
-- Table structure for tbl_savedivstore
-- ----------------------------
DROP TABLE IF EXISTS `tbl_savedivstore`;
CREATE TABLE `tbl_savedivstore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dispatchid` varchar(100) NOT NULL,
  `goodsname` varchar(20) NOT NULL,
  `goodsquantity` int(11) NOT NULL,
  `creater` varchar(20) NOT NULL,
  `state` int(11) NOT NULL,
  `sendtime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_savedivstore
-- ----------------------------
INSERT INTO `tbl_savedivstore` VALUES ('1', '1234567890', '苹果', '1', '管理员', '2', '2018-05-15 14:25:45');
INSERT INTO `tbl_savedivstore` VALUES ('2', '12345678977', '苹果', '2', '管理员', '5', '2018-05-15 16:55:11');

-- ----------------------------
-- Table structure for tbl_sendcar
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sendcar`;
CREATE TABLE `tbl_sendcar` (
  `sendCarId` int(11) NOT NULL AUTO_INCREMENT,
  `driverName` varchar(100) NOT NULL,
  `transferName` varchar(100) NOT NULL,
  `sendTraId` int(11) NOT NULL,
  `driverId` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`sendCarId`),
  KEY `tbl_sendtra_tbl_sendcar_fk` (`sendTraId`),
  CONSTRAINT `tbl_sendtra_tbl_sendcar_fk` FOREIGN KEY (`sendTraId`) REFERENCES `tbl_sendtra` (`sendTraId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_sendcar
-- ----------------------------
INSERT INTO `tbl_sendcar` VALUES ('7', '司机3', '东风冷冻车1', '9', '3', '6');
INSERT INTO `tbl_sendcar` VALUES ('8', '司机3', '东风冷藏车1', '10', '3', '6');
INSERT INTO `tbl_sendcar` VALUES ('9', '司机3', '东风冷藏车1', '11', '3', '6');

-- ----------------------------
-- Table structure for tbl_sendtra
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sendtra`;
CREATE TABLE `tbl_sendtra` (
  `sendTraId` int(11) NOT NULL AUTO_INCREMENT,
  `transferrequest` int(11) DEFAULT NULL,
  `transferplace` int(11) NOT NULL,
  `transfermodel` int(11) NOT NULL,
  `transfertool` int(11) NOT NULL,
  `requestnum` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`sendTraId`),
  UNIQUE KEY `transferrequest` (`transferrequest`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_sendtra
-- ----------------------------
INSERT INTO `tbl_sendtra` VALUES ('9', '9', '2', '1', '22', '1', '6');
INSERT INTO `tbl_sendtra` VALUES ('10', '10', '1', '1', '1', '1', '6');
INSERT INTO `tbl_sendtra` VALUES ('11', '11', '1', '1', '1', '1', '6');

-- ----------------------------
-- Table structure for tbl_state
-- ----------------------------
DROP TABLE IF EXISTS `tbl_state`;
CREATE TABLE `tbl_state` (
  `state` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(50) NOT NULL,
  `descp` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`state`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_state
-- ----------------------------
INSERT INTO `tbl_state` VALUES ('1', '未审核', '单据生成时的默认状态');
INSERT INTO `tbl_state` VALUES ('2', '已审核未执行', '已经审核过的单据但还没有执行');
INSERT INTO `tbl_state` VALUES ('3', '未满足条件', '审核未通过后的状态');
INSERT INTO `tbl_state` VALUES ('4', '已取消', '作废后的单据状态');
INSERT INTO `tbl_state` VALUES ('5', '已执行', '单据成功执行后的状态');
INSERT INTO `tbl_state` VALUES ('6', '执行完成', '交接时改变单据的状态为此状态');

-- ----------------------------
-- Table structure for tbl_store
-- ----------------------------
DROP TABLE IF EXISTS `tbl_store`;
CREATE TABLE `tbl_store` (
  `store` int(11) NOT NULL AUTO_INCREMENT,
  `storename` varchar(100) NOT NULL,
  `address` varchar(500) NOT NULL,
  PRIMARY KEY (`store`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_store
-- ----------------------------
INSERT INTO `tbl_store` VALUES ('1', '仓库1', '广西南宁');
INSERT INTO `tbl_store` VALUES ('2', '仓库2', '广西桂林');
INSERT INTO `tbl_store` VALUES ('3', '仓库3', '广西梧州');
INSERT INTO `tbl_store` VALUES ('4', '仓库4', '广西柳州');
INSERT INTO `tbl_store` VALUES ('5', '仓库5', '广西玉林');
INSERT INTO `tbl_store` VALUES ('6', '退货仓库', '广西南宁');

-- ----------------------------
-- Table structure for tbl_storerefgoods
-- ----------------------------
DROP TABLE IF EXISTS `tbl_storerefgoods`;
CREATE TABLE `tbl_storerefgoods` (
  `store` int(11) NOT NULL,
  `goods` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  KEY `tbl_store_tbl_storerefgoods_fk` (`store`),
  KEY `tbl_goods_tbl_storerefgoods_fk` (`goods`),
  CONSTRAINT `tbl_goods_tbl_storerefgoods_fk` FOREIGN KEY (`goods`) REFERENCES `tbl_goods` (`goods`) ON DELETE CASCADE,
  CONSTRAINT `tbl_store_tbl_storerefgoods_fk` FOREIGN KEY (`store`) REFERENCES `tbl_store` (`store`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_storerefgoods
-- ----------------------------
INSERT INTO `tbl_storerefgoods` VALUES ('1', '1', '191');
INSERT INTO `tbl_storerefgoods` VALUES ('1', '2', '200');
INSERT INTO `tbl_storerefgoods` VALUES ('1', '3', '96');
INSERT INTO `tbl_storerefgoods` VALUES ('1', '4', '194');
INSERT INTO `tbl_storerefgoods` VALUES ('1', '5', '356');
INSERT INTO `tbl_storerefgoods` VALUES ('1', '6', '180');
INSERT INTO `tbl_storerefgoods` VALUES ('1', '7', '250');
INSERT INTO `tbl_storerefgoods` VALUES ('1', '8', '234');
INSERT INTO `tbl_storerefgoods` VALUES ('1', '9', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('1', '10', '190');
INSERT INTO `tbl_storerefgoods` VALUES ('1', '11', '19');
INSERT INTO `tbl_storerefgoods` VALUES ('2', '1', '15');
INSERT INTO `tbl_storerefgoods` VALUES ('2', '2', '20');
INSERT INTO `tbl_storerefgoods` VALUES ('2', '3', '15');
INSERT INTO `tbl_storerefgoods` VALUES ('2', '4', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('2', '5', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('2', '6', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('2', '7', '25');
INSERT INTO `tbl_storerefgoods` VALUES ('2', '8', '25');
INSERT INTO `tbl_storerefgoods` VALUES ('2', '9', '7');
INSERT INTO `tbl_storerefgoods` VALUES ('2', '10', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('2', '11', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('3', '1', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('3', '2', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('3', '3', '15');
INSERT INTO `tbl_storerefgoods` VALUES ('3', '4', '25');
INSERT INTO `tbl_storerefgoods` VALUES ('3', '5', '19');
INSERT INTO `tbl_storerefgoods` VALUES ('3', '6', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('3', '7', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('3', '8', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('3', '9', '17');
INSERT INTO `tbl_storerefgoods` VALUES ('3', '10', '30');
INSERT INTO `tbl_storerefgoods` VALUES ('3', '11', '40');
INSERT INTO `tbl_storerefgoods` VALUES ('4', '1', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('4', '2', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('4', '3', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('4', '4', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('4', '5', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('4', '6', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('4', '7', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('4', '8', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('4', '9', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('4', '10', '640');
INSERT INTO `tbl_storerefgoods` VALUES ('4', '11', '230');
INSERT INTO `tbl_storerefgoods` VALUES ('5', '2', '650');
INSERT INTO `tbl_storerefgoods` VALUES ('5', '3', '450');
INSERT INTO `tbl_storerefgoods` VALUES ('5', '4', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('5', '5', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('5', '6', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('5', '7', '44');
INSERT INTO `tbl_storerefgoods` VALUES ('5', '8', '85');
INSERT INTO `tbl_storerefgoods` VALUES ('5', '9', '160');
INSERT INTO `tbl_storerefgoods` VALUES ('5', '10', '64');
INSERT INTO `tbl_storerefgoods` VALUES ('5', '11', '230');
INSERT INTO `tbl_storerefgoods` VALUES ('6', '1', '5');
INSERT INTO `tbl_storerefgoods` VALUES ('6', '2', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('6', '3', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('6', '4', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('6', '5', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('6', '6', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('6', '7', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('6', '8', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('6', '9', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('6', '10', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('6', '11', '0');
INSERT INTO `tbl_storerefgoods` VALUES ('5', '15', '501');
INSERT INTO `tbl_storerefgoods` VALUES ('1', '15', '50');
INSERT INTO `tbl_storerefgoods` VALUES ('6', '15', '2');
INSERT INTO `tbl_storerefgoods` VALUES ('1', '16', '10');
INSERT INTO `tbl_storerefgoods` VALUES ('1', '17', '100');

-- ----------------------------
-- Table structure for tbl_subtrasfer
-- ----------------------------
DROP TABLE IF EXISTS `tbl_subtrasfer`;
CREATE TABLE `tbl_subtrasfer` (
  `dispatch` int(11) NOT NULL AUTO_INCREMENT,
  `orderdate` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `transfertool` int(11) NOT NULL,
  `goodname` varchar(100) NOT NULL,
  `goodquantity` int(11) NOT NULL,
  `orderid` varchar(100) NOT NULL,
  `creater` varchar(100) NOT NULL,
  `sendname` varchar(20) NOT NULL,
  `sendtel` char(11) NOT NULL,
  `receivername` varchar(20) NOT NULL,
  `receivertel` char(11) NOT NULL,
  `receiverprovince` varchar(20) NOT NULL,
  `state` int(11) NOT NULL,
  `receivercity` varchar(20) NOT NULL,
  `receiverstreet` varchar(100) NOT NULL,
  `sendtime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `savestorebillid` int(11) NOT NULL,
  PRIMARY KEY (`dispatch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_subtrasfer
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_tra
-- ----------------------------
DROP TABLE IF EXISTS `tbl_tra`;
CREATE TABLE `tbl_tra` (
  `traId` int(11) NOT NULL AUTO_INCREMENT,
  `goodName` varchar(100) NOT NULL,
  `goodQuantity` int(11) NOT NULL,
  `receName` varchar(20) DEFAULT NULL,
  `receTel` char(11) DEFAULT NULL,
  `receProvince` varchar(10) DEFAULT NULL,
  `receCity` varchar(20) DEFAULT NULL,
  `receStreet` varchar(100) DEFAULT NULL,
  `transfertask` int(11) DEFAULT NULL,
  `dispuser` int(11) NOT NULL,
  PRIMARY KEY (`traId`),
  UNIQUE KEY `transfertask` (`transfertask`),
  KEY `tbl_dispuser_tbl_tra_fk` (`dispuser`),
  CONSTRAINT `tbl_dispuser_tbl_tra_fk` FOREIGN KEY (`dispuser`) REFERENCES `tbl_dispuser` (`dispuser`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_tra
-- ----------------------------
INSERT INTO `tbl_tra` VALUES ('6', '苹果', '2', '蒋杨俊', '13590466093', '广东省', '深圳市', 'test', '9', '1');
INSERT INTO `tbl_tra` VALUES ('7', '火龙果', '2', '张生', '13590466093', '广西壮族自治区', '桂林市', 'test', '10', '1');
INSERT INTO `tbl_tra` VALUES ('8', '苹果', '2', '蒋杨俊', '13590466093', '广东省', '深圳市', '测试', '11', '1');

-- ----------------------------
-- Table structure for tbl_transfermodel
-- ----------------------------
DROP TABLE IF EXISTS `tbl_transfermodel`;
CREATE TABLE `tbl_transfermodel` (
  `transfermodel` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `weight` varchar(100) NOT NULL,
  `mulk` varchar(100) NOT NULL,
  PRIMARY KEY (`transfermodel`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_transfermodel
-- ----------------------------
INSERT INTO `tbl_transfermodel` VALUES ('1', '东风(厢式/板车)', '2.5', '12');
INSERT INTO `tbl_transfermodel` VALUES ('2', '解放(厢式/板车)', '35', '110');
INSERT INTO `tbl_transfermodel` VALUES ('3', '威铃(厢式/板车)', '3.5', '30');
INSERT INTO `tbl_transfermodel` VALUES ('4', '解放(板车)', '35', '80');
INSERT INTO `tbl_transfermodel` VALUES ('5', '解放(冷藏车)', '8', '45');
INSERT INTO `tbl_transfermodel` VALUES ('6', '斯太尔(板车)', '40', '96');
INSERT INTO `tbl_transfermodel` VALUES ('7', '解放(集装箱)', '25', '85');

-- ----------------------------
-- Table structure for tbl_transferplace
-- ----------------------------
DROP TABLE IF EXISTS `tbl_transferplace`;
CREATE TABLE `tbl_transferplace` (
  `transferplace` int(11) NOT NULL AUTO_INCREMENT,
  `transfername` varchar(100) NOT NULL,
  PRIMARY KEY (`transferplace`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_transferplace
-- ----------------------------
INSERT INTO `tbl_transferplace` VALUES ('1', '运输点1');
INSERT INTO `tbl_transferplace` VALUES ('2', '运输点2');
INSERT INTO `tbl_transferplace` VALUES ('3', '运输点3');
INSERT INTO `tbl_transferplace` VALUES ('4', '运输点4');
INSERT INTO `tbl_transferplace` VALUES ('5', '运输点5');
INSERT INTO `tbl_transferplace` VALUES ('6', '运输点6');

-- ----------------------------
-- Table structure for tbl_transferrequest
-- ----------------------------
DROP TABLE IF EXISTS `tbl_transferrequest`;
CREATE TABLE `tbl_transferrequest` (
  `transferrequest` int(11) NOT NULL AUTO_INCREMENT,
  `dispatch` int(11) NOT NULL,
  `transfertool` int(11) DEFAULT NULL,
  `state` int(11) NOT NULL,
  `requestnum` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`transferrequest`),
  UNIQUE KEY `dispatch` (`dispatch`),
  KEY `tbl_state_tbl_transferrequest_fk` (`state`),
  CONSTRAINT `tbl_state_tbl_transferrequest_fk` FOREIGN KEY (`state`) REFERENCES `tbl_state` (`state`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_transferrequest
-- ----------------------------
INSERT INTO `tbl_transferrequest` VALUES ('9', '13', '22', '5', '1');
INSERT INTO `tbl_transferrequest` VALUES ('10', '14', '1', '5', '1');
INSERT INTO `tbl_transferrequest` VALUES ('11', '15', '1', '5', '1');

-- ----------------------------
-- Table structure for tbl_transfertask
-- ----------------------------
DROP TABLE IF EXISTS `tbl_transfertask`;
CREATE TABLE `tbl_transfertask` (
  `transfertask` int(11) NOT NULL AUTO_INCREMENT,
  `transferrequest` int(11) NOT NULL,
  `transfertool` int(11) DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`transfertask`),
  UNIQUE KEY `transferrequest` (`transferrequest`),
  KEY `tbl_state_tbl_transfertask_fk` (`state`),
  CONSTRAINT `tbl_state_tbl_transfertask_fk` FOREIGN KEY (`state`) REFERENCES `tbl_state` (`state`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_transfertask
-- ----------------------------
INSERT INTO `tbl_transfertask` VALUES ('9', '9', '22', '6');
INSERT INTO `tbl_transfertask` VALUES ('10', '10', '1', '6');
INSERT INTO `tbl_transfertask` VALUES ('11', '11', '1', '6');

-- ----------------------------
-- Table structure for tbl_transfertool
-- ----------------------------
DROP TABLE IF EXISTS `tbl_transfertool`;
CREATE TABLE `tbl_transfertool` (
  `transfertool` int(11) NOT NULL AUTO_INCREMENT,
  `transfernum` varchar(100) NOT NULL,
  `transfername` varchar(100) NOT NULL,
  `transferstate` int(11) NOT NULL,
  `transfermodel` int(11) NOT NULL,
  `transferplace` int(11) NOT NULL,
  `transferqueantity` int(11) NOT NULL DEFAULT '10',
  PRIMARY KEY (`transfertool`),
  UNIQUE KEY `transfernum` (`transfernum`),
  KEY `tbl_trastate_tbl_transfertool_fk` (`transferstate`),
  KEY `tbl_transfermodel_tbl_transfertool_fk` (`transfermodel`),
  KEY `tbl_transferplace_tbl_transfertool_fk` (`transferplace`),
  CONSTRAINT `tbl_transfermodel_tbl_transfertool_fk` FOREIGN KEY (`transfermodel`) REFERENCES `tbl_transfermodel` (`transfermodel`) ON DELETE CASCADE,
  CONSTRAINT `tbl_transferplace_tbl_transfertool_fk` FOREIGN KEY (`transferplace`) REFERENCES `tbl_transferplace` (`transferplace`) ON DELETE CASCADE,
  CONSTRAINT `tbl_trastate_tbl_transfertool_fk` FOREIGN KEY (`transferstate`) REFERENCES `tbl_trastate` (`state`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_transfertool
-- ----------------------------
INSERT INTO `tbl_transfertool` VALUES ('1', '桂D1234', '东风冷藏车1', '1', '1', '1', '9');
INSERT INTO `tbl_transfertool` VALUES ('2', '桂D1235', '东风冷藏车2', '1', '1', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('3', '桂D1236', '东风冷藏车3', '1', '1', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('4', '桂A1234', '解放冷藏车1', '1', '2', '1', '9');
INSERT INTO `tbl_transfertool` VALUES ('5', '桂A1235', '解放冷藏车2', '1', '2', '1', '9');
INSERT INTO `tbl_transfertool` VALUES ('6', '桂A1236', '解放冷藏车3', '1', '2', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('7', '桂B1234', '威铃冷藏车1', '1', '3', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('8', '桂B1235', '威铃冷藏车2', '1', '3', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('9', '桂B1236', '威铃冷藏车3', '1', '3', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('10', '桂C1234', '解放冷藏车1', '1', '4', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('11', '桂C1235', '解放冷藏车2', '1', '4', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('12', '桂C1236', '解放冷藏车3', '1', '4', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('13', '桂E1234', '解放冷藏车1', '1', '5', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('14', '桂E1235', '解放冷藏车2', '1', '5', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('15', '桂E1236', '解放冷藏车3', '1', '5', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('16', '桂F1234', '斯太尔冷藏车1', '1', '6', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('17', '桂F1235', '斯太尔冷藏车2', '1', '6', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('18', '桂F1236', '斯太尔冷藏车3', '1', '6', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('19', '桂G1234', '解放集冷冻车1', '1', '7', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('20', '桂G1235', '解放集冷冻车2', '1', '7', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('21', '桂G1236', '解放集冷冻车3', '1', '7', '1', '10');
INSERT INTO `tbl_transfertool` VALUES ('22', '桂H1234', '东风冷冻车1', '1', '1', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('23', '桂H1235', '东风冷冻车2', '1', '1', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('24', '桂H1236', '东风冷冻车3', '1', '1', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('25', '桂I1234', '解放冷冻车1', '1', '2', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('26', '桂I1235', '解放冷冻车2', '1', '2', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('27', '桂I1236', '解放冷冻车3', '1', '2', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('28', '桂A1334', '威铃冷冻车1', '1', '3', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('29', '桂A1335', '威铃冷冻车2', '1', '3', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('30', '桂A1336', '威铃冷冻车3', '1', '3', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('31', '桂B1334', '解放冷冻车1', '1', '4', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('32', '桂B1335', '解放冷冻车2', '1', '4', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('33', '桂B1336', '解放冷冻车3', '1', '4', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('34', '桂C1334', '解放冷冻车1', '1', '5', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('35', '桂C1335', '解放冷冻车2', '1', '5', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('36', '桂C1336', '解放冷冻车3', '1', '5', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('37', '桂D1334', '斯太尔冷冻车1', '1', '6', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('38', '桂D1335', '斯太尔冷冻车2', '1', '6', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('39', '桂D1336', '斯太尔冷冻车3', '1', '6', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('40', '桂E1334', '解放集装箱车1', '1', '7', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('41', '桂E1335', '解放集装箱车2', '1', '7', '2', '10');
INSERT INTO `tbl_transfertool` VALUES ('42', '桂E1336', '解放集装箱车3', '1', '7', '2', '10');

-- ----------------------------
-- Table structure for tbl_trastate
-- ----------------------------
DROP TABLE IF EXISTS `tbl_trastate`;
CREATE TABLE `tbl_trastate` (
  `state` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(50) NOT NULL,
  PRIMARY KEY (`state`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_trastate
-- ----------------------------
INSERT INTO `tbl_trastate` VALUES ('1', '空闲');
INSERT INTO `tbl_trastate` VALUES ('2', '在途');
INSERT INTO `tbl_trastate` VALUES ('3', '维修');

-- ----------------------------
-- Table structure for tbl_users
-- ----------------------------
DROP TABLE IF EXISTS `tbl_users`;
CREATE TABLE `tbl_users` (
  `users` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `usertype` int(11) NOT NULL,
  PRIMARY KEY (`users`),
  KEY `tbl_usertype_tbl_users_fk` (`usertype`),
  CONSTRAINT `tbl_usertype_tbl_users_fk` FOREIGN KEY (`usertype`) REFERENCES `tbl_usertype` (`usertype`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_users
-- ----------------------------
INSERT INTO `tbl_users` VALUES ('1', '客户1', '1234', '1');
INSERT INTO `tbl_users` VALUES ('2', '市场专员1', '1234', '2');
INSERT INTO `tbl_users` VALUES ('3', '调度员1', '1234', '3');
INSERT INTO `tbl_users` VALUES ('4', '仓管员1', '1234', '4');
INSERT INTO `tbl_users` VALUES ('5', '运调员1', '1234', '7');
INSERT INTO `tbl_users` VALUES ('6', '客户2', '1234', '1');
INSERT INTO `tbl_users` VALUES ('7', '市场专员2', '1234', '2');
INSERT INTO `tbl_users` VALUES ('13', '管理员', '1234', '8');
INSERT INTO `tbl_users` VALUES ('15', '客户3', '1234', '1');
INSERT INTO `tbl_users` VALUES ('16', '客户4', '1234', '1');

-- ----------------------------
-- Table structure for tbl_usertype
-- ----------------------------
DROP TABLE IF EXISTS `tbl_usertype`;
CREATE TABLE `tbl_usertype` (
  `usertype` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(100) NOT NULL,
  PRIMARY KEY (`usertype`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_usertype
-- ----------------------------
INSERT INTO `tbl_usertype` VALUES ('1', '客户');
INSERT INTO `tbl_usertype` VALUES ('2', '市场专员');
INSERT INTO `tbl_usertype` VALUES ('3', '调度员');
INSERT INTO `tbl_usertype` VALUES ('4', '仓管员');
INSERT INTO `tbl_usertype` VALUES ('5', '盘点员');
INSERT INTO `tbl_usertype` VALUES ('6', '结算员');
INSERT INTO `tbl_usertype` VALUES ('7', '运输调度员');
INSERT INTO `tbl_usertype` VALUES ('8', '管理员');

-- ----------------------------
-- Procedure structure for proc_addCarTime
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_addCarTime`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_addCarTime`(in in_driverId int,in in_transferToolId int)
begin
insert into tbl_cartime(driver,transfertool)values(in_driverId,in_transferToolId);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_addDispatch
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_addDispatch`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_addDispatch`(in in_orderid varchar(100),in in_goodname varchar(100),in in_goodquantity int,
in in_transfertool int,in in_orderdate datetime,in in_sendname varchar(20),
in in_sendtel char(11),in in_receivername varchar(20),in in_receivertel char(11),
in in_receiverprovince varchar(10),in in_receivercity varchar(20),in in_receiverstreet varchar(100),in in_state int,in in_Creater varchar(100))
begin
insert into tbl_dispatch
(orderid,goodname,goodquantity,transfertool,orderdate,sendname,sendtel,receivername,receivertel,receiverprovince,receivercity,receiverstreet,state,creater)
values(in_orderid,in_goodname,in_goodquantity,in_transfertool,in_orderdate,in_sendname,in_sendtel,in_receivername,in_receivertel,in_receiverprovince,in_receivercity,in_receiverstreet,in_state,in_Creater);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_addInStoreRequest
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_addInStoreRequest`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_addInStoreRequest`(in in_goods int,in in_indate datetime,in in_quantity int,in in_store int,in in_state int)
begin 
insert into tbl_instorerequest(goods,indate,quantity,store,state)values(in_goods,in_indate,in_quantity,in_store,in_state);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_addOutStoreRequest
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_addOutStoreRequest`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_addOutStoreRequest`(in in_dispatch int,in in_store int,in in_state int)
begin
insert into tbl_outstorerequest(dispatch,store,state)
values(in_dispatch,in_store,in_state);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_addOutStoreTask
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_addOutStoreTask`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_addOutStoreTask`(in in_outstorerequest int,in in_store int,in in_state int)
begin
insert into tbl_outstoretask(outstorerequest,store,state)
values(in_outstorerequest,in_store,in_state);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_addSendCar
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_addSendCar`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_addSendCar`(in in_driverId int,in in_driverName varchar(100),in in_transferName varchar(100),in in_sendTraId int,in in_state int)
begin
insert into tbl_sendcar(driverId,driverName,transferName,sendTraId,state)
values(in_driverId,in_driverName,in_transferName,in_sendTraId,in_state);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_addSendTraTask
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_addSendTraTask`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_addSendTraTask`(in in_transferrequest int,in in_transferplace int,in in_transfermodel int,in in_transfertool int,in in_requestnum int,in in_state int)
begin
insert into tbl_sendtra
(transferrequest,transferplace,transfermodel,transfertool,requestnum,state)values
(in_transferrequest,in_transferplace,in_transfermodel,in_transfertool,in_requestnum,in_state);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_addStoreGood
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_addStoreGood`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_addStoreGood`(in in_store int,in in_goods int,in in_num int)
begin
insert into tbl_storerefgoods(store,goods,num)values(in_store,in_goods,in_num);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_addTra
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_addTra`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_addTra`(in in_goodName varchar(100),
 in in_goodQuantity int,
 in in_receName varchar(20),
 in in_receTel char(11),
 in in_receProvince varchar(10),
 in in_receCity varchar(20),
 in in_receStreet varchar(100),
 in in_transfertask int,
 in in_dispuser int)
begin
insert into tbl_tra(goodName,goodQuantity,receName,receTel,receProvince,receCity,receStreet,transfertask,dispuser)
values(in_goodName,in_goodQuantity,in_receName,in_receTel,in_receProvince,in_receCity,in_receStreet,in_transfertask,in_dispuser);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_addTransferRequest
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_addTransferRequest`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_addTransferRequest`(in in_dispatch int,in in_transfertool int,in_requestnum int,in in_state int)
begin
insert into tbl_transferrequest(dispatch,transfertool,requestnum,state)values
(in_dispatch,in_transfertool,in_requestnum,in_state);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_addTransferTask
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_addTransferTask`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_addTransferTask`(in in_transferrequest int,in in_transfertool int,in in_state int)
begin
insert into tbl_transfertask(transferrequest,transfertool,state)
values(in_transferrequest,in_transfertool,in_state);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_deleteCarTime
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_deleteCarTime`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_deleteCarTime`(in in_driver int,in in_transfertool int)
begin
delete from tbl_cartime where driver = in_driver and transfertool = in_transfertool;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_examineDispatch
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_examineDispatch`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_examineDispatch`(in in_goodname varchar(100),in in_goodquantity int)
begin
select * from tbl_storerefgoods where goods in(
select goods from tbl_goods where goodsname = in_goodname) and num >= in_goodquantity limit 1;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_examineOutStoreRequest
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_examineOutStoreRequest`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_examineOutStoreRequest`(in in_store int,in in_goodname varchar(100),in in_goodquantity int)
begin
select * from tbl_storerefgoods where goods in(
select goods from tbl_goods where goodsname = in_goodname) and num >= in_goodquantity and store = in_store limit 1;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getAllDispatch
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getAllDispatch`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getAllDispatch`()
begin
select a.*,b.sname statename from tbl_dispatch a,tbl_state b where a.state = b.state order by orderdate desc;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getAllDispatchPage
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getAllDispatchPage`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getAllDispatchPage`(in in_pageNum int)
begin
set @a = in_pageNum;
prepare stmt from 'select a.*,b.sname statename from tbl_dispatch a,tbl_state b where a.state = b.state and a.creater = in_creater order by orderdate desc limit ?,10';
execute stmt using @a;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getAllTransferPlace
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getAllTransferPlace`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getAllTransferPlace`()
begin
select * from tbl_transferplace;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getDispatchById
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getDispatchById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getDispatchById`(in in_dispatch int)
begin
select a.*,b.sname statename from tbl_dispatch a,tbl_state b where a.state = b.state and a.dispatch = in_dispatch;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getDispatchByState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getDispatchByState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getDispatchByState`(in in_state int)
begin
select a.*,b.sname statename from tbl_dispatch a,tbl_state b where a.state = b.state and b.state = in_state order by orderdate desc;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getDispatchByStatePage
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getDispatchByStatePage`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getDispatchByStatePage`(in in_state int,in in_pageNum int)
begin
set @a = in_state;
set @b = in_pageNum;
prepare stmt from 'select a.*,b.sname statename from tbl_dispatch a,tbl_state b where a.state = b.state and b.state = ? order by orderdate desc limit ?,10';
execute stmt using @a,@b;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getDispUserByCon
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getDispUserByCon`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getDispUserByCon`()
begin
select * from tbl_dispuser where dispnum < 10;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getDispUserById
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getDispUserById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getDispUserById`(in in_dispuser int)
begin
select * from tbl_dispuser where dispuser = in_dispuser;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getDriverById
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getDriverById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getDriverById`(in in_driver int)
begin
select * from tbl_drivers where driver = in_driver;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getDriverByState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getDriverByState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getDriverByState`(in in_driverState int)
begin
select * from tbl_drivers where driverstate = in_driverState;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getgetOutStoreRequestById
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getgetOutStoreRequestById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getgetOutStoreRequestById`(in in_outstorerequest int)
begin
select d.*,c.storename,a.goodname,a.goodquantity,b.sname,a.orderdate from tbl_dispatch a,tbl_state b,tbl_store c,tbl_outstorerequest d
where a.dispatch = d.dispatch and b.state = d.state and c.store = d.store and d.outstorerequest = in_outstorerequest;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getgetTransferToolByPlaceCount
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getgetTransferToolByPlaceCount`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getgetTransferToolByPlaceCount`(in in_transferPlace int)
begin
select count(*) count from tbl_transfertool a,tbl_transfermodel b,tbl_transferplace c,tbl_trastate d 
where a.transferstate = d.state and a.transfermodel = b.transfermodel and a.transferplace = c.transferplace and a.transferplace = in_transferPlace;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getInStoreRequestById
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getInStoreRequestById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getInStoreRequestById`(in in_instorerequest int)
begin
select a.*,d.sname,c.storename,b.goodsname
from tbl_instorerequest a,
tbl_goods b,
tbl_store c,
tbl_state d
where a.goods = b.goods and a.store = c.store and a.state = d.state and a.instorerequest = in_instorerequest;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getInStoreRequestByState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getInStoreRequestByState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getInStoreRequestByState`(in in_state int)
begin
select a.*,d.sname,c.storename,b.goodsname
from tbl_instorerequest a,
tbl_goods b,
tbl_store c,
tbl_state d
where a.goods = b.goods and a.store = c.store and a.state = d.state and a.state = in_state;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getInStoreRequestByStateCount
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getInStoreRequestByStateCount`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getInStoreRequestByStateCount`(in in_state int)
begin
select count(*) count
from tbl_instorerequest a,
tbl_goods b,
tbl_store c,
tbl_state d
where a.goods = b.goods and a.store = c.store and a.state = d.state and a.state = in_state;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getInStoreRequestByStatePage
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getInStoreRequestByStatePage`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getInStoreRequestByStatePage`(in in_state int,in in_pageNum int)
begin
set @a = in_state;
set @b = in_pageNum;
prepare stmt from 'select a.*,d.sname,c.storename,b.goodsname
from tbl_instorerequest a,
tbl_goods b,
tbl_store c,
tbl_state d
where a.goods = b.goods and a.store = c.store and a.state = d.state and a.state = ? order by indate desc limit ?,10';
execute stmt using @a,@b;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getOutStoreRequestByState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getOutStoreRequestByState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getOutStoreRequestByState`(in in_state int)
begin
select d.*,c.storename,a.goodname,a.goodquantity,b.sname,a.orderdate from tbl_dispatch a,tbl_state b,tbl_store c,tbl_outstorerequest d
where a.dispatch = d.dispatch and b.state = d.state and c.store = d.store and d.state = in_state;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getOutStoreRequestByStateCount
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getOutStoreRequestByStateCount`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getOutStoreRequestByStateCount`(in in_state int)
begin 
select count(*) count from tbl_dispatch a,tbl_state b,tbl_store c,tbl_outstorerequest d
where a.dispatch = d.dispatch and b.state = d.state and c.store = d.store and d.state = in_state;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getOutStoreRequestByStatePage
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getOutStoreRequestByStatePage`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getOutStoreRequestByStatePage`(in in_state int,in in_pageNum int)
begin
set @a = in_state;
set @b = in_pageNum;
prepare stmt from 'select d.*,c.storename,a.goodname,a.goodquantity,b.sname,a.orderdate from tbl_dispatch a,tbl_state b,tbl_store c,tbl_outstorerequest d
where a.dispatch = d.dispatch and b.state = d.state and c.store = d.store and d.state = ? order by a.orderdate desc limit ?,10';
execute stmt using @a,@b;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getOutStoreTaskDtoById
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getOutStoreTaskDtoById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getOutStoreTaskDtoById`(in in_outstoretask int)
begin
select f.*,c.storename,a.goodname,a.goodquantity,b.sname,a.orderdate 
from tbl_dispatch a,tbl_state b,tbl_store c,tbl_outstorerequest d,tbl_outstoretask f
where a.dispatch = d.dispatch and b.state = f.state and c.store = d.store and d.outstorerequest = f.outstorerequest
and f.outstoretask = in_outstoretask;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getOutStoreTaskDtoByState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getOutStoreTaskDtoByState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getOutStoreTaskDtoByState`(in in_state int)
begin
select f.*,c.storename,a.goodname,a.goodquantity,b.sname,a.orderdate 
from tbl_dispatch a,tbl_state b,tbl_store c,tbl_outstorerequest d,tbl_outstoretask f
where a.dispatch = d.dispatch and b.state = f.state and c.store = d.store and d.outstorerequest = f.outstorerequest
and f.state = in_state;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getOutStoreTaskDtoByStateCount
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getOutStoreTaskDtoByStateCount`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getOutStoreTaskDtoByStateCount`(in in_state int)
begin
select count(*) count 
from tbl_dispatch a,tbl_state b,tbl_store c,tbl_outstorerequest d,tbl_outstoretask f
where a.dispatch = d.dispatch and b.state = f.state and c.store = d.store and d.outstorerequest = f.outstorerequest
and f.state = in_state;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getOutStoreTaskDtoByStatePage
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getOutStoreTaskDtoByStatePage`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getOutStoreTaskDtoByStatePage`(in in_state int,in in_pageNum int)
begin
set @a = in_state;
set @b = in_pageNum;
prepare stmt from 'select f.*,c.storename,a.goodname,a.goodquantity,b.sname,a.orderdate 
from tbl_dispatch a,tbl_state b,tbl_store c,tbl_outstorerequest d,tbl_outstoretask f
where a.dispatch = d.dispatch and b.state = f.state and c.store = d.store and d.outstorerequest = f.outstorerequest
and f.state = ? order by a.orderdate desc limit ?,10';
execute stmt using @a,@b;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getSendCar
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getSendCar`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getSendCar`(in in_pageNum int)
begin
set @a = in_pageNum;
prepare stmt from 'select a.*,b.sname from tbl_sendcar a,tbl_state b where a.state = b.state limit ?,10';
execute stmt using @a;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getSendCarByDriverId
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getSendCarByDriverId`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getSendCarByDriverId`(in in_driverId int)
begin
select a.*,b.sname from tbl_sendcar a,tbl_state b where a.state = b.state and a.driverId = in_driverId and a.state = 2;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getSendCarBySendTraId
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getSendCarBySendTraId`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getSendCarBySendTraId`(in in_sendTraId int)
begin
select a.*,b.sname from tbl_sendcar a,tbl_state b where a.state = b.state and a.sendTraId = in_sendTraId;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getSendCarCount
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getSendCarCount`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getSendCarCount`()
begin
select count(*) count from tbl_sendcar;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getSendTraTaskByTfq
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getSendTraTaskByTfq`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getSendTraTaskByTfq`(in in_transferrequest int)
begin
select a.*,b.transfername transferplacename,c.name transfermodelname,d.transfername transfertoolname,f.sname from
tbl_sendtra a,
tbl_transferplace b,
tbl_transfermodel c,
tbl_transfertool d,
tbl_state f
where a.transferplace = b.transferplace 
and a.transfermodel = c.transfermodel 
and a.transfertool = d.transfertool 
and  a.state = f.state and a.transferrequest = in_transferrequest;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getSendTraTaskCountByState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getSendTraTaskCountByState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getSendTraTaskCountByState`(in in_state int)
begin
select count(*) count from
tbl_sendtra a,
tbl_transferplace b,
tbl_transfermodel c,
tbl_transfertool d,
tbl_state f
where a.transferplace = b.transferplace 
and a.transfermodel = c.transfermodel 
and a.transfertool = d.transfertool 
and  a.state = f.state and a.state = in_state;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getSendTraTaskDtoById
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getSendTraTaskDtoById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getSendTraTaskDtoById`(in in_sendTraId int)
begin
select a.*,b.transfername transferplacename,c.name transfermodelname,d.transfername transfertoolname,f.sname from
tbl_sendtra a,
tbl_transferplace b,
tbl_transfermodel c,
tbl_transfertool d,
tbl_state f
where a.transferplace = b.transferplace 
and a.transfermodel = c.transfermodel 
and a.transfertool = d.transfertool 
and  a.state = f.state and a.sendTraId = in_sendTraId;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getSendTraTaskDtoByState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getSendTraTaskDtoByState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getSendTraTaskDtoByState`(in in_state int)
begin
select a.*,b.transfername transferplacename,c.name transfermodelname,d.transfername transfertoolname,f.sname from
tbl_sendtra a,
tbl_transferplace b,
tbl_transfermodel c,
tbl_transfertool d,
tbl_state f
where a.transferplace = b.transferplace 
and a.transfermodel = c.transfermodel 
and a.transfertool = d.transfertool 
and  a.state = f.state and a.state = in_state;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getSendTraTaskDtoByStatePage
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getSendTraTaskDtoByStatePage`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getSendTraTaskDtoByStatePage`(in in_state int,in in_pageNum int)
begin
set @a = in_state;
set @b = in_pageNum;
prepare stmt from 'select a.*,b.transfername transferplacename,c.name transfermodelname,d.transfername transfertoolname,f.sname from
tbl_sendtra a,
tbl_transferplace b,
tbl_transfermodel c,
tbl_transfertool d,
tbl_state f
where a.transferplace = b.transferplace 
and a.transfermodel = c.transfermodel 
and a.transfertool = d.transfertool 
and  a.state = f.state and a.state = ? limit ?,10';
execute stmt using @a,@b;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTraByDispUserCount
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTraByDispUserCount`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTraByDispUserCount`()
begin
select count(*) count from tbl_tra;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTraByDispUserId
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTraByDispUserId`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTraByDispUserId`(in in_dispuser int)
begin
select a.*,b.dispname,b.dispnum from tbl_tra a,tbl_dispuser b where a.dispuser = b.dispuser and a.dispuser =  in_dispuser;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTraByDispUserIdPage
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTraByDispUserIdPage`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTraByDispUserIdPage`(in in_pageNum int)
begin
set @a = in_pageNum;
prepare stmt from 'select a.*,b.dispname,b.dispnum from tbl_tra a left outer join tbl_dispuser b on a.dispuser = b.dispuser limit ?,10';
execute stmt using @a;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTraById
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTraById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTraById`(in in_traId int)
begin
select a.*,b.dispname,b.dispnum from tbl_tra a,tbl_dispuser b where a.dispuser = b.dispuser and a.traId = in_traId;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTraByTransferTaskId
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTraByTransferTaskId`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTraByTransferTaskId`(in in_transfertask int)
begin
select a.*,b.dispname,b.dispnum from tbl_tra a,tbl_dispuser b where a.dispuser = b.dispuser and a.transfertask = in_transfertask;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferRequestByDispatch
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferRequestByDispatch`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferRequestByDispatch`(in in_dispatch int)
begin
select a.*,d.transfername,e.name transfermodel,c.transfername tranm,c.transferqueantity transferquantity,
b.orderdate,f.sname
 from tbl_transferrequest a,tbl_dispatch b,tbl_transfertool c,tbl_transferplace d,tbl_transfermodel e,tbl_state f
where a.dispatch = b.dispatch and a.transfertool = c.transfertool and c.transferplace = d.transferplace and c.transfermodel = e.transfermodel
and a.state = f.state and a.dispatch = in_dispatch;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferRequestById
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferRequestById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferRequestById`(in in_transferrequest int)
begin
select a.*,d.transfername,e.name transfermodel,c.transfername tranm,c.transferqueantity transferquantity,
b.orderdate,f.sname
 from tbl_transferrequest a,tbl_dispatch b,tbl_transfertool c,tbl_transferplace d,tbl_transfermodel e,tbl_state f
where a.dispatch = b.dispatch and a.transfertool = c.transfertool and c.transferplace = d.transferplace and c.transfermodel = e.transfermodel
and a.state = f.state and a.transferrequest = in_transferrequest;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferRequestByState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferRequestByState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferRequestByState`(in in_state int)
begin
select a.*,d.transfername,e.name transfermodel,c.transfername tranm,c.transferqueantity transferquantity,
b.orderdate,f.sname
 from tbl_transferrequest a,tbl_dispatch b,tbl_transfertool c,tbl_transferplace d,tbl_transfermodel e,tbl_state f
where a.dispatch = b.dispatch and a.transfertool = c.transfertool and c.transferplace = d.transferplace and c.transfermodel = e.transfermodel
and a.state = f.state and a.state = in_state;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferRequestByStateCount
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferRequestByStateCount`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferRequestByStateCount`(in in_state int)
begin
select count(*) count from tbl_transferrequest a,tbl_dispatch b,tbl_transfertool c,tbl_transferplace d,tbl_transfermodel e,tbl_state f
where a.dispatch = b.dispatch and a.transfertool = c.transfertool and c.transferplace = d.transferplace and c.transfermodel = e.transfermodel
and a.state = f.state and a.state = in_state;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferRequestByStatePage
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferRequestByStatePage`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferRequestByStatePage`(in in_state int,in in_pageNum int)
begin
set @a = in_state;
set @b = in_pageNum;
prepare stmt from 'select a.*,d.transfername,e.name transfermodel,c.transfername tranm,c.transferqueantity transferquantity,
b.orderdate,f.sname
 from tbl_transferrequest a,tbl_dispatch b,tbl_transfertool c,tbl_transferplace d,tbl_transfermodel e,tbl_state f
where a.dispatch = b.dispatch and a.transfertool = c.transfertool and c.transferplace = d.transferplace and c.transfermodel = e.transfermodel
and a.state = f.state and a.state = ? order by b.orderdate desc limit ?,10';
execute stmt using @a,@b;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferTaskDtoById
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferTaskDtoById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferTaskDtoById`(in in_transfertask int)
begin
select g.*,a.requestnum,d.transfername,e.name transfermodel,c.transfername tranm,c.transferqueantity transferquantity,
b.orderdate,f.sname
 from 
 tbl_transferrequest a,
 tbl_dispatch b,
 tbl_transfertool c,
 tbl_transferplace d,
 tbl_transfermodel e,
 tbl_state f,
 tbl_transfertask g
where a.dispatch = b.dispatch and a.transfertool = c.transfertool and c.transferplace = d.transferplace and c.transfermodel = e.transfermodel
and g.state = f.state and a.transferrequest = g.transferrequest and g.transfertask = in_transfertask;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferTaskDtoByState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferTaskDtoByState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferTaskDtoByState`(in in_state int)
begin
select g.*,a.requestnum,d.transfername,e.name transfermodel,c.transfername tranm,c.transferqueantity transferquantity,
b.orderdate,f.sname
 from 
 tbl_transferrequest a,
 tbl_dispatch b,
 tbl_transfertool c,
 tbl_transferplace d,
 tbl_transfermodel e,
 tbl_state f,
 tbl_transfertask g
where a.dispatch = b.dispatch and a.transfertool = c.transfertool and c.transferplace = d.transferplace and c.transfermodel = e.transfermodel
and g.state = f.state and a.transferrequest = g.transferrequest and g.state = in_state;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferTaskDtoByStateCount
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferTaskDtoByStateCount`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferTaskDtoByStateCount`(in in_state int)
begin
select count(*) count
 from 
 tbl_transferrequest a,
 tbl_dispatch b,
 tbl_transfertool c,
 tbl_transferplace d,
 tbl_transfermodel e,
 tbl_state f,
 tbl_transfertask g
where a.dispatch = b.dispatch and a.transfertool = c.transfertool and c.transferplace = d.transferplace and c.transfermodel = e.transfermodel
and a.state = f.state and a.transferrequest = g.transferrequest and g.state = in_state;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferTaskDtoByStatePage
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferTaskDtoByStatePage`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferTaskDtoByStatePage`(in in_state int,in in_pageNum int)
begin
set @a = in_state;
set @b = in_pageNum;
prepare stmt from 'select g.*,a.requestnum,d.transfername,e.name transfermodel,c.transfername tranm,c.transferqueantity transferquantity,
b.orderdate,f.sname
 from 
 tbl_transferrequest a,
 tbl_dispatch b,
 tbl_transfertool c,
 tbl_transferplace d,
 tbl_transfermodel e,
 tbl_state f,
 tbl_transfertask g
where a.dispatch = b.dispatch and a.transfertool = c.transfertool and c.transferplace = d.transferplace and c.transfermodel = e.transfermodel
and g.state = f.state and a.transferrequest = g.transferrequest and g.state = ? order by b.orderdate desc limit ?,10';
execute stmt using @a,@b;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferTool
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferTool`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferTool`(in in_transferPlace int,in in_transferModel int)
begin
select a.*,b.name,c.transfername placename,d.sname from tbl_transfertool a,tbl_transfermodel b,tbl_transferplace c,tbl_trastate d 
where a.transferstate = d.state and a.transfermodel = b.transfermodel and a.transferplace = c.transferplace and a.transferplace = in_transferPlace and a.transfermodel = in_transferModel;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferToolById
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferToolById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferToolById`(in in_transferTool int)
begin
select a.*,b.name,c.transfername placename,d.sname from tbl_transfertool a,tbl_transfermodel b,tbl_transferplace c,tbl_trastate d 
where a.transferstate = d.state and a.transfermodel = b.transfermodel and a.transferplace = c.transferplace and a.transfertool = in_transferTool;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferToolByModel
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferToolByModel`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferToolByModel`(in in_transferModel int)
begin
select a.*,b.name,c.transfername placename,d.sname from tbl_transfertool a,tbl_transfermodel b,tbl_transferplace c,tbl_trastate d 
where a.transferstate = d.state and a.transfermodel = b.transfermodel and a.transferplace = c.transferplace and b.transfermodel = in_transferModel;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferToolByModelPage
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferToolByModelPage`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferToolByModelPage`(in in_transferModel int,in in_pageNum int)
begin
set @a = in_transferModel;
set @b = in_pageNum;
prepare stmt from 'select a.*,b.name,c.transfername placename,d.sname from tbl_transfertool a,tbl_transfermodel b,tbl_transferplace c,tbl_trastate d 
where a.transferstate = d.state and a.transfermodel = b.transfermodel and a.transferplace = c.transferplace and b.transfermodel = ? limit ?,10';
execute stmt using @a,@b;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferToolByPlace
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferToolByPlace`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferToolByPlace`(in in_transferPlace int)
begin
select a.*,b.name,c.transfername placename,d.sname from tbl_transfertool a,tbl_transfermodel b,tbl_transferplace c,tbl_trastate d 
where a.transferstate = d.state and a.transfermodel = b.transfermodel and a.transferplace = c.transferplace and a.transferplace = in_transferPlace;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferToolByPlacePage
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferToolByPlacePage`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferToolByPlacePage`(in in_transferPlace int,in in_pageNum int)
begin
set @a = in_transferPlace;
set @b = in_pageNum;
prepare stmt from 'select a.*,b.name,c.transfername placename,d.sname from tbl_transfertool a,tbl_transfermodel b,tbl_transferplace c,tbl_trastate d 
where a.transferstate = d.state and a.transfermodel = b.transfermodel and a.transferplace = c.transferplace and a.transferplace = ? limit ?,10';
execute stmt using @a,@b;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferToolCount
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferToolCount`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferToolCount`(in in_transferPlace int,in in_transferModel int)
begin
select count(*) count from tbl_transfertool a,tbl_transfermodel b,tbl_transferplace c,tbl_trastate d 
where a.transferstate = d.state and a.transfermodel = b.transfermodel and a.transferplace = c.transferplace and a.transferplace = in_transferPlace and a.transfermodel = in_transferModel;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_getTransferToolPage
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getTransferToolPage`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_getTransferToolPage`(in in_transferPlace int,in in_transferModel int,in in_pageNum int)
begin
set @a = in_transferPlace;
set @b = in_transferModel;
set @c = in_pageNum;
prepare stmt from 'select a.*,b.name,c.transfername placename,d.sname from tbl_transfertool a,tbl_transfermodel b,tbl_transferplace c,tbl_trastate d 
where a.transferstate = d.state and a.transfermodel = b.transfermodel and a.transferplace = c.transferplace and a.transferplace = ? and a.transfermodel = ? limit ?,10';
execute stmt using @a,@b,@c;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_updateDispatch
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_updateDispatch`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_updateDispatch`(in in_orderid varchar(100),in in_goodname varchar(100),in in_goodquantity int,
in in_transfertool int,in in_sendname varchar(20),in in_sendtel char(11),in in_receivername varchar(20),in in_receivertel char(11),
in in_receiverprovince varchar(10),in in_receivercity varchar(20),in in_receiverstreet varchar(100),in in_dispatch int)
begin
update tbl_dispatch set 
orderid = in_orderid,
goodname = in_goodname,
goodquantity = in_goodquantity,
transfertool = in_transfertool,
sendname = in_sendname,
sendtel = in_sendtel,
receivername = in_receivername,
receivertel = in_receivertel,
receiverprovince = in_receiverprovince,
receivercity = in_receivercity,
receiverstreet = in_receiverstreet 
where dispatch = in_dispatch;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_updateDispatchState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_updateDispatchState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_updateDispatchState`(in in_dispatch int,in in_state int)
begin
update tbl_dispatch set state = in_state where dispatch = in_dispatch;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_updateDispUserNum
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_updateDispUserNum`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_updateDispUserNum`(in in_dispuser int,in in_dispnum int)
begin
update tbl_dispuser set dispnum = in_dispnum where dispuser = in_dispuser;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_updateDriverState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_updateDriverState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_updateDriverState`(in in_driverId int,in in_driverState int)
begin
update tbl_drivers set driverstate = in_driverState where driver = in_driverId;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_updateOutStoreTaskState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_updateOutStoreTaskState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_updateOutStoreTaskState`(in in_outstoretask int,in in_state int)
begin
update tbl_outstoretask set state = in_state where outstoretask = in_outstoretask;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_updateSendCarState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_updateSendCarState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_updateSendCarState`(in in_driverId int,in in_state int)
begin
update tbl_sendcar set state = in_state where driverId = in_driverId;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_updateSendTraTaskState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_updateSendTraTaskState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_updateSendTraTaskState`(in in_sendTraId int,in in_state int)
begin 
update tbl_sendtra set state = in_state where sendTraId = in_sendTraId;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_updateStoreGood
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_updateStoreGood`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_updateStoreGood`(in in_store int,in in_goodname varchar(100),in in_goodquantity int)
begin
update tbl_storerefgoods set num = num - in_goodquantity  where store = in_store and 
goods in(select goods from tbl_goods where goodsname = in_goodname);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_updateTransferRequestDto
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_updateTransferRequestDto`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_updateTransferRequestDto`(in in_transferrequest int,in in_state int)
begin
update tbl_transferrequest set state = in_state where transferrequest = in_transferrequest;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_updateTransferTaskState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_updateTransferTaskState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_updateTransferTaskState`(in in_transfertask int,in in_state int)
begin
update tbl_transfertask set state = in_state where transfertask = in_transfertask;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_updateTransferToolQuantity
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_updateTransferToolQuantity`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_updateTransferToolQuantity`(in in_transfertool int,in in_transferquantity int)
begin
update tbl_transfertool set transferqueantity = transferqueantity - in_transferquantity 
where transfertool = in_transfertool;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_updateTransferToolState
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_updateTransferToolState`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_updateTransferToolState`(in in_transfertool int,in in_transferstate int)
begin
update tbl_transfertool set transferstate = in_transferstate where transfertool = in_transfertool;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tbl_dispatch_trigger`;
DELIMITER ;;
CREATE TRIGGER `tbl_dispatch_trigger` BEFORE DELETE ON `tbl_dispatch` FOR EACH ROW begin
delete from tbl_transferrequest where dispatch = OLD.dispatch;
delete from tbl_outstorerequest where dispatch = OLD.dispatch;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tbl_outstorerequest_trigger`;
DELIMITER ;;
CREATE TRIGGER `tbl_outstorerequest_trigger` BEFORE DELETE ON `tbl_outstorerequest` FOR EACH ROW begin
delete from tbl_outstoretask where outstorerequest = OLD.outstorerequest; 
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tbl_transferrequest_trigger`;
DELIMITER ;;
CREATE TRIGGER `tbl_transferrequest_trigger` BEFORE DELETE ON `tbl_transferrequest` FOR EACH ROW begin
delete from tbl_transfertask where transferrequest = OLD.transferrequest;
delete from tbl_sendtra where transferrequest = OLD.transferrequest;
update tbl_transfertool set transferstate = 1 where transfertool = OLD.transfertool;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tbl_transfertask_trigger`;
DELIMITER ;;
CREATE TRIGGER `tbl_transfertask_trigger` BEFORE DELETE ON `tbl_transfertask` FOR EACH ROW begin
delete from tbl_tra where transfertask = OLD.transfertask;
end
;;
DELIMITER ;

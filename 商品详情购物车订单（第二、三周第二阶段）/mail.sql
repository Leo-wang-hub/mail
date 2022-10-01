/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : mail

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2022-07-29 18:25:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address_user` int(11) DEFAULT NULL,
  `address_phone` varchar(11) DEFAULT NULL,
  `address_detail` varchar(255) DEFAULT NULL,
  `address_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('2', '1', '155XXXX2110', '北京市朝阳区XXX小区', '小王');
INSERT INTO `address` VALUES ('4', '1', '155XXXX2111', '北京市怀柔区XXX小区', '小张');

-- ----------------------------
-- Table structure for `car`
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_num` int(11) DEFAULT NULL,
  `product_count` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('48', '1', '2', '1', '2999.00');

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `product_id` int(11) DEFAULT NULL,
  `product_num` int(11) DEFAULT NULL,
  `product_count` decimal(10,2) DEFAULT NULL,
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('2', '1', '2999.00', '23', '20220729142425831');
INSERT INTO `item` VALUES ('3', '1', '5999.00', '24', '20220729142425831');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `order_total` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('20220729101929350', '1', '2', '2022-07-29', '0');
INSERT INTO `order` VALUES ('20220729102115139', '1', '2', '2022-07-29', '0');
INSERT INTO `order` VALUES ('20220729102143251', '1', '2', '2022-07-29', '0');
INSERT INTO `order` VALUES ('20220729102253783', '1', '4', '2022-07-29', '2999');
INSERT INTO `order` VALUES ('20220729102520278', '1', '4', '2022-07-29', '0');
INSERT INTO `order` VALUES ('20220729102552478', '1', '2', '2022-07-29', '5999');
INSERT INTO `order` VALUES ('20220729102802584', '1', '2', '2022-07-29', '0');
INSERT INTO `order` VALUES ('20220729102829987', '1', '4', '2022-07-29', '2999');
INSERT INTO `order` VALUES ('20220729103017786', '1', '4', '2022-07-29', '0');
INSERT INTO `order` VALUES ('20220729103044528', '1', '2', '2022-07-29', '9999');
INSERT INTO `order` VALUES ('20220729103818598', '1', '2', '2022-07-29', '0');
INSERT INTO `order` VALUES ('20220729103855628', '1', '2', '2022-07-29', '9999');
INSERT INTO `order` VALUES ('20220729104130921', '1', '2', '2022-07-29', '0');
INSERT INTO `order` VALUES ('20220729104148586', '1', '2', '2022-07-29', '0');
INSERT INTO `order` VALUES ('20220729104919042', '1', '2', '2022-07-29', '2999');
INSERT INTO `order` VALUES ('20220729105054632', '1', '2', '2022-07-29', '5999');
INSERT INTO `order` VALUES ('20220729105903068', '1', '2', '2022-07-29', '5999');
INSERT INTO `order` VALUES ('20220729110041606', '1', '4', '2022-07-29', '5999');
INSERT INTO `order` VALUES ('20220729110325833', '1', '2', '2022-07-29', '2999');
INSERT INTO `order` VALUES ('20220729110554017', '1', '2', '2022-07-29', '9999');
INSERT INTO `order` VALUES ('20220729140215057', '1', '4', '2022-07-29', '9499');
INSERT INTO `order` VALUES ('20220729140557696', '1', '4', '2022-07-29', '9499');
INSERT INTO `order` VALUES ('20220729141530953', '1', '2', '2022-07-29', '5999');
INSERT INTO `order` VALUES ('20220729142425831', '1', '2', '2022-07-29', '8998');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '鍟嗗搧id',
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '鍟嗗搧鍚?',
  `type_id` int(11) DEFAULT NULL COMMENT '绫诲埆',
  `product_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '鍟嗗搧鎻忚堪',
  `product_price` int(11) DEFAULT NULL COMMENT '鍟嗗搧浠锋牸',
  `product_image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '鍟嗗搧鍥剧墖璺緞',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '苹果iPhone13ProMax', '1', 'A15仿生芯片，超视网膜XDR显示屏，Pro级摄像头系统，ProMotion自适应刷新率技术', '8999', '/img/phone01.jpg');
INSERT INTO `product` VALUES ('2', '华为nava7', '1', 'OLED极点全面屏，全网通5G，麒麟985', '2999', '/img/phone02.jpg');
INSERT INTO `product` VALUES ('3', '苹果iPhone13', '1', '解锁超能力，超先进双摄系统，A15仿生芯片', '5999', '/img/phone03.jpg');
INSERT INTO `product` VALUES ('4', '华为P50Pro', '1', '万象双环设计，120Hz OLED显示屏，IP68防尘防水，鸿蒙2.0系统', '6488', '/img/phone04.jpg');
INSERT INTO `product` VALUES ('5', '惠普暗影精灵6', '2', '惠普暗影精灵6第十代英特尔酷睿i5，发烧级4G独显，IPS显示屏，背光键盘', '6799', '/img/goods/computer01.jpg');
INSERT INTO `product` VALUES ('6', '苹果Macbook Pro 13 M2', '2', 'Apple M2芯片｜视网膜显示屏｜背光妙控键盘', '9999', '/img/goods/computer02.jpg');
INSERT INTO `product` VALUES ('7', '苹果MacBook Air M2', '2', '苹果MacBook Air M2(8GB/256GB/8核)苹果M2芯片，刘海式显示屏，1080p摄像头', '9499', '/img/goods/computer03.jpg');
INSERT INTO `product` VALUES ('8', '苹果Macbook Pro14', '2', '苹果Macbook Pro 14 2021(10核M1 PRO/16GB/1TB/16核集显)', '18999', '/img/goods/computer04.jpg');

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `type_id` int(11) NOT NULL,
  `type_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('0', '搜索结果');
INSERT INTO `type` VALUES ('1', '手机');
INSERT INTO `type` VALUES ('2', '电脑');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) DEFAULT NULL,
  `password` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin01', '123456', '1');
INSERT INTO `user` VALUES ('admin0', '123456', '2');
INSERT INTO `user` VALUES ('admin02', '123456', '3');

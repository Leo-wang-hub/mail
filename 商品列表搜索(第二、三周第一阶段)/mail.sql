/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : mail

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2022-07-15 14:21:51
*/

SET FOREIGN_KEY_CHECKS=0;

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

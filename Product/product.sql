/*
Navicat MySQL Data Transfer

Source Server         : Thri
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : product

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-09-21 10:59:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for buy_bill
-- ----------------------------
DROP TABLE IF EXISTS `buy_bill`;
CREATE TABLE `buy_bill` (
  `Buy_Id` int(64) NOT NULL AUTO_INCREMENT,
  `Define_Id` varchar(255) NOT NULL,
  `Buy_Name` varchar(255) NOT NULL,
  `Goods_Type` varchar(255) NOT NULL,
  `Advice_Buy_Price` varchar(255) NOT NULL,
  `Buy_Num` varchar(255) NOT NULL,
  `Buy_Price` varchar(255) NOT NULL,
  `Supplier` varchar(255) NOT NULL,
  `Buy_Time` date NOT NULL,
  `Customer_Id` int(64) NOT NULL,
  PRIMARY KEY (`Buy_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buy_bill
-- ----------------------------
INSERT INTO `buy_bill` VALUES ('5', '3', '猪头肉', '大就完了', '10', '30', '10', '1', '2018-07-04', '1');
INSERT INTO `buy_bill` VALUES ('6', '4', '猪口条', '恶心的一批', '50', '40', '50', '1', '2018-07-04', '1');
INSERT INTO `buy_bill` VALUES ('7', '2', '猪肝', '公猪猪肝', '1', '30', '1', '1', '2018-07-04', '1');
INSERT INTO `buy_bill` VALUES ('8', '1', '猪肉', '肥的流油', '10', '19', '10', '1', '2018-07-04', '1');

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `Id` int(64) NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(255) DEFAULT NULL,
  `Client_Id` varchar(255) NOT NULL,
  `Client_Name` varchar(255) NOT NULL,
  `TaoBao_Id` varchar(255) NOT NULL,
  `Phone` varchar(255) NOT NULL,
  `Mobile_Phone` varchar(255) NOT NULL,
  `Delivery_Address` varchar(255) NOT NULL,
  `Post` varchar(255) NOT NULL,
  `Buy_Time` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('1', null, '1', '急疯贱豪', 'jifengjianhao', '178654987', '178654987', '昆山市安博路1号', '255000', null);
INSERT INTO `client` VALUES ('2', null, '2', '李日天', '这头猪是真的骚123', '17864308078', '17864308078', '昆山市安博路1号', '255000', '2018-07-04');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `Id` int(64) NOT NULL AUTO_INCREMENT,
  `Define_Id` varchar(255) NOT NULL,
  `Goods_Name` varchar(255) NOT NULL,
  `Goods_Type` varchar(255) DEFAULT NULL,
  `Safe_Num` varchar(255) NOT NULL,
  `Advice_Buy_Price` varchar(255) DEFAULT NULL,
  `Advice_Sale_Price` varchar(255) DEFAULT NULL,
  `Present_Number` varchar(255) DEFAULT NULL,
  `In_Time` date DEFAULT NULL,
  `Out_Time` date DEFAULT NULL,
  `Owner_Id` int(64) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Owner_Id` (`Owner_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '1', '猪肉', '肥的流油', '1', '10', '15', '998', '2018-07-04', '2018-07-04', '1');
INSERT INTO `goods` VALUES ('2', '2', '猪肝', '公猪猪肝', '10', '1', '2', '998', '2018-07-04', '2018-07-04', '1');
INSERT INTO `goods` VALUES ('3', '3', '猪头肉', '大就完了', '10', '10', '20', '998', '2018-07-04', '2018-07-04', '1');
INSERT INTO `goods` VALUES ('4', '4', '猪口条', '恶心的一批', '10', '50', '60', '939', '2018-07-04', '2018-07-04', '1');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `Id` int(64) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Power` int(2) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('1', 'cuizhize', '123', '7');
INSERT INTO `login` VALUES ('2', '123', '123', '7');

-- ----------------------------
-- Table structure for sale_bill
-- ----------------------------
DROP TABLE IF EXISTS `sale_bill`;
CREATE TABLE `sale_bill` (
  `Id` int(64) NOT NULL AUTO_INCREMENT,
  `Sale_Id` varchar(255) NOT NULL,
  `Goods_Id` varchar(255) NOT NULL,
  `Goods_Name` varchar(255) NOT NULL,
  `Count` varchar(255) NOT NULL,
  `Sale_Number` varchar(255) NOT NULL,
  `Sale_Price` varchar(255) NOT NULL,
  `Client_Id` int(64) NOT NULL,
  `Client_Name` varchar(255) NOT NULL,
  `Sale_Time` date NOT NULL,
  `Supplier_Id` int(64) NOT NULL,
  `Simple_Name` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale_bill
-- ----------------------------
INSERT INTO `sale_bill` VALUES ('1', '100', '1', '猪肉', '998', '100', '15', '1', '急疯贱豪', '2018-07-04', '1', '骚猪肉铺');
INSERT INTO `sale_bill` VALUES ('2', '101', '2', '猪肝', '998', '100', '2', '2', '李日天', '2018-07-04', '1', '骚猪肉铺');
INSERT INTO `sale_bill` VALUES ('3', '102', '3', '猪头肉', '998', '100', '20', '1', '急疯贱豪', '2018-07-04', '1', '骚猪肉铺');
INSERT INTO `sale_bill` VALUES ('4', '103', '4', '猪口条', '998', '100', '60', '2', '李日天', '2018-07-04', '1', '骚猪肉铺');
INSERT INTO `sale_bill` VALUES ('5', '104', '4', '猪口条', '997', '100', '60', '1', '急疯贱豪', '2018-07-04', '1', '骚猪肉铺');
INSERT INTO `sale_bill` VALUES ('6', '105', '4', '猪口条', '987', '99', '600', '1', '急疯贱豪', '2018-07-04', '1', '骚猪肉铺');
INSERT INTO `sale_bill` VALUES ('7', '106', '4', '猪口条', '937', '32', '3000', '1', '急疯贱豪', '2018-07-04', '1', '骚猪肉铺');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `Id` int(64) NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(255) NOT NULL,
  `Staff_Id` varchar(255) NOT NULL,
  `Sex` varchar(5) DEFAULT NULL,
  `Native_Place` varchar(255) DEFAULT NULL,
  `Present_Address` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `QQ` varchar(255) DEFAULT NULL,
  `WeChat` varchar(255) DEFAULT NULL,
  `Work_Type` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', '黄工头', '1', '男', '菏泽巨野大黄庄', '昆山', '178654321', '178654321', '178654321', '超级管理员');
INSERT INTO `staff` VALUES ('2', '六爷', '2', '男', '山东潍坊', '昆山市市政府', '178456123', '178456123', '178456123', '销售员');
INSERT INTO `staff` VALUES ('3', '王鸽', '3', '男', '山东青岛', '在你隔壁', '178123456', '178123456', '178123456', '员工');
INSERT INTO `staff` VALUES ('4', '李日天', '4', '女', '山东青岛市', '昆山立交下', '17864308078', '17949646', 'saozhu@qq.com', '员工');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `Id` int(64) NOT NULL AUTO_INCREMENT,
  `Supplier_Id` varchar(255) NOT NULL,
  `Simple_Name` varchar(255) NOT NULL,
  `Complete_Name` varchar(255) DEFAULT NULL,
  `Agent` varchar(255) DEFAULT NULL,
  `Appellation` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Mobile_Phone` varchar(255) DEFAULT NULL,
  `Fax` varchar(255) DEFAULT NULL,
  `Company_Address` varchar(255) DEFAULT NULL,
  `Factory_Address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', '1', '骚猪肉铺', '昆山市骚猪肉铺有限公司', '木子日天', '总裁', '昆山市花桥镇安博路1号 B座612房', '17864308078', '17864308078', '17864308078', '青岛市中山公园往东都是！！！');
INSERT INTO `supplier` VALUES ('2', '2', '崔氏工业', '崔氏工业有限公司', 'Thri', '总裁', '华尔街最高的那个楼就是！', '176528965256', '85251651', '1465163516988', '华尔街最矮的楼就是！');

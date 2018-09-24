/*
Navicat MySQL Data Transfer

Source Server         : MYSQL
Source Server Version : 50555
Source Host           : localhost:3306
Source Database       : erp

Target Server Type    : MYSQL
Target Server Version : 50555
File Encoding         : 65001

Date: 2018-09-04 12:14:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dept_id` int(10) NOT NULL,
  `dept_name` varchar(30) DEFAULT NULL,
  `dept_manager` varchar(30) NOT NULL,
  PRIMARY KEY (`dept_id`),
  UNIQUE KEY `dept_name` (`dept_name`),
  KEY `dept_id` (`dept_id`,`dept_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '开发部', '孙立绕');
INSERT INTO `department` VALUES ('2', '测试部', '孙志超');
INSERT INTO `department` VALUES ('3', '财务部', '孙国豪');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `emp_id` int(15) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(30) DEFAULT NULL,
  `emp_sex` int(2) DEFAULT NULL,
  `dept_name` varchar(30) DEFAULT NULL,
  `dept_id` int(10) NOT NULL,
  `emp_card` varchar(30) DEFAULT NULL,
  `emp_job` varchar(30) DEFAULT NULL,
  `emp_address` varchar(30) DEFAULT NULL,
  `emp_telnumber` varchar(11) DEFAULT NULL,
  `emp_date` varchar(20) DEFAULT NULL,
  `emp_money` int(15) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `dept_id` (`dept_id`),
  KEY `dept_name` (`dept_name`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`),
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`dept_name`) REFERENCES `department` (`dept_name`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('25', '孙志', '1', '开发部', '1', '371121199609023331', '测试部经理', '山东省', '17864308101', '2017-1-1', '10000');
INSERT INTO `employee` VALUES ('26', '孙莉', '0', '财务部', '3', '371121199609023332', '财务部经理', '山东省', '17864308102', '2017-1-1', '10000');
INSERT INTO `employee` VALUES ('27', '张三', '1', '开发部', '1', '371121199609023333', '员工', '山东省', '17864308103', '2017-1-1', '8000');
INSERT INTO `employee` VALUES ('28', '张四', '1', '测试部', '2', '371121199609023334', '员工', '山东省', '17864308104', '2017-1-1', '8000');
INSERT INTO `employee` VALUES ('29', '张五', '1', '测试部', '2', '371121199609023335', '员工', '山东省', '17864308105', '2017-1-1', '8000');
INSERT INTO `employee` VALUES ('30', '张柳', '0', '开发部', '1', '371121199609023336', '员工', '山东省', '17864308196', '2017-1-2', '8000');
INSERT INTO `employee` VALUES ('34', 'rerere', '1', '测试部', '2', '2', '1', '1', '3', '1', '1');
INSERT INTO `employee` VALUES ('35', 'wqwq11', '1', '开发部', '1', '1', '222', '1', '1', '1', '1');
INSERT INTO `employee` VALUES ('36', 'rererer', '0', '测试部', '2', '1', '1', '1', '1', '1', '1');
INSERT INTO `employee` VALUES ('37', '孙泽浩', '1', '开发部', '1', '37112119960902338x', '管理员', '山东省', '17864308198', '2017-1-1', '10000');

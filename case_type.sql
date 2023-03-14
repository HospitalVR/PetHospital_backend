/*
 Navicat Premium Data Transfer

 Source Server         : hospital
 Source Server Type    : MySQL
 Source Server Version : 50515
 Source Host           : localhost:3306
 Source Schema         : hospital

 Target Server Type    : MySQL
 Target Server Version : 50515
 File Encoding         : 65001

 Date: 14/03/2023 16:29:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for case_type
-- ----------------------------
DROP TABLE IF EXISTS `case_type`;
CREATE TABLE `case_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `type`(`type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of case_type
-- ----------------------------
INSERT INTO `case_type` VALUES (5, '传染病');
INSERT INTO `case_type` VALUES (3, '免疫系统疾病');
INSERT INTO `case_type` VALUES (8, '其他');
INSERT INTO `case_type` VALUES (6, '口腔疾病');
INSERT INTO `case_type` VALUES (2, '消化系统疾病');
INSERT INTO `case_type` VALUES (14, '犬传染病');
INSERT INTO `case_type` VALUES (15, '犬内分泌疾病');
INSERT INTO `case_type` VALUES (12, '犬口腔疾病');
INSERT INTO `case_type` VALUES (9, '犬外伤');
INSERT INTO `case_type` VALUES (17, '犬心血管疾病');
INSERT INTO `case_type` VALUES (10, '犬消化系统疾病');
INSERT INTO `case_type` VALUES (16, '猫传染病');
INSERT INTO `case_type` VALUES (11, '猫内分泌疾病');
INSERT INTO `case_type` VALUES (13, '猫呼吸道疾病');
INSERT INTO `case_type` VALUES (1, '神经系统疾病');
INSERT INTO `case_type` VALUES (4, '肝脏疾病');

SET FOREIGN_KEY_CHECKS = 1;

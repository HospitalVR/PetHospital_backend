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

 Date: 22/03/2023 17:07:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for case_management
-- ----------------------------
DROP TABLE IF EXISTS `case_management`;
CREATE TABLE `case_management`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '疾病名称',
  `name2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `treat1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接诊文本',
  `treat2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `treat3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `check1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病例检查',
  `check2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `check3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '诊断结果',
  `result2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `plan1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '治疗方案',
  `plan2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `plan3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of case_management
-- ----------------------------
INSERT INTO `case_management` VALUES (5, '免疫系统疾病', '猫白血病', 'case-猫白血病-1.jpg', 'case-猫白血病-1.mp4', '一只4岁的英国短毛猫，主人反映最近食欲不振、体重下降，体温升高。', NULL, NULL, '血液检查发现白细胞计数异常，猫白血病病毒检测呈阳性。', NULL, NULL, '猫白血病。', NULL, NULL, '给予免疫抑制剂、抗病毒药物等治疗。', NULL, NULL);
INSERT INTO `case_management` VALUES (6, '神经系统疾病', '犬癫痫', NULL, NULL, '一只3岁的贵宾犬，主人反映最近出现意识丧失、抽搐等症状。', NULL, NULL, '宠物CT检查发现大脑部分区域异常，脑电图检查发现脑电波异常。', NULL, NULL, '犬癫痫。', NULL, NULL, '给予抗癫痫药物等治疗。', NULL, NULL);
INSERT INTO `case_management` VALUES (7, '消化系统疾病', '猫饮食障碍', NULL, NULL, '一只6岁的美国短毛猫，主人反映最近食欲减退、腹胀等症状。', NULL, NULL, '腹部X光检查发现肠道积气、消化不良。', NULL, NULL, '猫饮食障碍。', NULL, NULL, '给予肠道促动剂、饮食调节等治疗。', NULL, NULL);
INSERT INTO `case_management` VALUES (8, '肝脏疾病', '犬肝病', NULL, NULL, '一只5岁的德国牧羊犬，主人反映最近食欲不振、体重下降，口腔出血。', NULL, NULL, '血液检查发现肝功能异常，肝脏超声检查发现肝脏受损。', NULL, NULL, '犬肝病。', NULL, NULL, '给予肝脏保护剂、营养支持等治疗。', NULL, NULL);
INSERT INTO `case_management` VALUES (9, '传染病', '犬瘟', NULL, NULL, '一只2岁的贵宾犬，主人反映犬只精神不振，食欲不佳，眼睛发红。', NULL, NULL, '犬只体温升高，呼吸急促，喉部有干咳声，眼结膜充血。血液检查发现白细胞和淋巴细胞明显下降。', NULL, NULL, '犬瘟', NULL, NULL, '给予营养支持和抗病毒治疗。', NULL, NULL);
INSERT INTO `case_management` VALUES (10, '口腔疾病', '犬口炎', NULL, NULL, '一只3岁的比熊犬，主人反映犬只最近不愿意进食，口臭严重。', NULL, NULL, '口腔检查发现口腔黏膜充血、溃疡，并有牙龈出血。', NULL, NULL, '犬口炎', NULL, NULL, '给予口腔抗生素、止痛药等治疗。', NULL, NULL);
INSERT INTO `case_management` VALUES (11, '传染病', '猫传染性腹膜炎', NULL, NULL, '一只4岁的短毛猫，主人反映猫只最近食欲下降，呕吐。', NULL, NULL, '猫只腹部触诊明显有液体积聚，腹部X光检查发现腹膜间隙明显增宽。', NULL, NULL, '猫传染性腹膜炎', NULL, NULL, '给予抗生素、营养支持等治疗。', NULL, NULL);
INSERT INTO `case_management` VALUES (12, '其他', '猫脱水症', NULL, NULL, '一只1岁的美国短毛猫，主人反映猫只最近排尿减少，食欲下降，精神萎靡。', NULL, NULL, '猫只脱水，口腔粘膜干燥，皮肤弹性差。', NULL, NULL, '猫脱水症', NULL, NULL, '给予补液治疗，并寻找病因。', NULL, NULL);
INSERT INTO `case_management` VALUES (13, '犬外伤', '犬骨折', NULL, NULL, '一只2岁的金毛犬，左后腿跛行，主人反映曾有重物压到其身上', NULL, NULL, 'X光检查显示左腿骨折', NULL, NULL, '犬骨折', NULL, NULL, '给予固定支架固定，定期更换', NULL, NULL);
INSERT INTO `case_management` VALUES (14, '犬消化系统疾病', '犬急性胰腺炎', NULL, NULL, '一只5岁的贵宾犬，主人反映犬只最近食欲不振、呕吐、腹泻', NULL, NULL, '血液检查显示胰腺酶升高', NULL, NULL, '犬急性胰腺炎', NULL, NULL, '禁食，给予营养支持、抗生素、胰酶抑制剂等治疗', NULL, NULL);
INSERT INTO `case_management` VALUES (15, '猫内分泌疾病', '猫糖尿病', NULL, NULL, '一只7岁的橘猫，主人反映猫只最近饮水量增加、食欲不振', NULL, NULL, '血液检查显示血糖升高', NULL, NULL, '猫糖尿病', NULL, NULL, '控制饮食，给予胰岛素注射治疗', NULL, NULL);
INSERT INTO `case_management` VALUES (16, '犬口腔疾病', '犬口腔溃疡', NULL, NULL, '一只3岁的比熊犬，主人反映犬只口腔内有明显溃疡', NULL, NULL, '口腔检查显示口腔黏膜溃疡', NULL, NULL, '犬口腔溃疡', NULL, NULL, '给予口腔抗炎药、口腔清洁液等治疗', NULL, NULL);
INSERT INTO `case_management` VALUES (17, '猫呼吸道疾病', '猫感冒', NULL, NULL, '一只1岁的蓝猫，主人反映猫只最近打喷嚏、流涕、食欲不振', NULL, NULL, '呼吸道检查发现鼻腔充血', NULL, NULL, '猫感冒', NULL, NULL, '给予抗生素、退热药等治疗，避免着凉', NULL, NULL);
INSERT INTO `case_management` VALUES (18, '犬传染病', '犬瘟热', NULL, NULL, '一只3个月大的哈士奇犬，主人反映犬只出现发热、咳嗽、流涕等症状。', NULL, NULL, '血液检查发现白细胞和血小板减少，病毒核酸检测呈阳性。', NULL, NULL, '犬瘟热。', NULL, NULL, '给予抗生素、输液、营养支持等治疗，隔离并严密观察。', NULL, NULL);
INSERT INTO `case_management` VALUES (19, '犬内分泌疾病', '犬糖尿病', NULL, NULL, '一只7岁的贵宾犬，主人反映犬只最近出现口渴、多尿、食欲减退等症状。', NULL, NULL, '血液检查发现血糖和尿糖升高。', NULL, NULL, '犬糖尿病。', NULL, NULL, '限制饮食、口服降糖药、定期测量血糖并调整治疗。', NULL, NULL);
INSERT INTO `case_management` VALUES (20, '猫传染病', '猫病毒性鼻气管炎', NULL, NULL, '一只4岁的波斯猫，主人反映猫只出现喷嚏、流涕、食欲减退等症状。', NULL, NULL, '病理检查发现鼻腔有炎症和浆液性分泌物。', NULL, NULL, '猫病毒性鼻气管炎。', NULL, NULL, '给予抗生素、营养支持、保持环境清洁卫生等治疗。', NULL, NULL);
INSERT INTO `case_management` VALUES (21, '犬心血管疾病', '犬心包积液', NULL, NULL, '一只6岁的金毛犬，主人反映犬只最近出现咳嗽、气促等症状。', NULL, NULL, '心脏超声检查发现心包积液。', NULL, NULL, '犬心包积液。', NULL, NULL, '给予穿刺抽液、口服利尿剂、心脏营养药等治疗。', NULL, NULL);
INSERT INTO `case_management` VALUES (22, '其他', '糖尿病', NULL, 'case-糖尿病-1.mp4', '1', 'case-糖尿病-2.jpg', 'case-糖尿病-2.mp4', '2', NULL, NULL, '3', NULL, NULL, '4', NULL, NULL);

-- ----------------------------
-- Table structure for case_type
-- ----------------------------
DROP TABLE IF EXISTS `case_type`;
CREATE TABLE `case_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `type`(`type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (1, '前台');
INSERT INTO `position` VALUES (2, '医助');
INSERT INTO `position` VALUES (3, '兽医');

-- ----------------------------
-- Table structure for position_job
-- ----------------------------
DROP TABLE IF EXISTS `position_job`;
CREATE TABLE `position_job`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `video` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of position_job
-- ----------------------------
INSERT INTO `position_job` VALUES (1, '前台', '招待', NULL, NULL, NULL);
INSERT INTO `position_job` VALUES (2, '医助', '静脉注射', NULL, NULL, NULL);
INSERT INTO `position_job` VALUES (3, '医助', '皮下注射', NULL, NULL, NULL);
INSERT INTO `position_job` VALUES (4, '医助', '肌肉注射', NULL, NULL, NULL);
INSERT INTO `position_job` VALUES (5, '医助', '局部封闭注射', NULL, NULL, NULL);
INSERT INTO `position_job` VALUES (6, '兽医', '手术无菌要求', NULL, NULL, NULL);
INSERT INTO `position_job` VALUES (7, '兽医', '常规手术', NULL, NULL, NULL);
INSERT INTO `position_job` VALUES (8, '兽医', '特殊手术', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NULL' COMMENT '用户名',
  `nick_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NULL' COMMENT '昵称',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NULL' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '账号状态（0正常 1停用）',
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phonenumber` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户性别（0男，1女，2未知）',
  `avatar` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `user_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '1' COMMENT '用户类型（0管理员，1普通用户）',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建人的用户id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(11) NULL DEFAULT 0 COMMENT '删除标志（0代表未删除，1代表已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '账号',
  `user_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户密码',
  `last_login_time` datetime NULL DEFAULT NULL COMMENT '上一次登录时间',
  `enabled` tinyint(4) NULL DEFAULT NULL COMMENT '账号是否可用',
  `not_expired` tinyint(4) NULL DEFAULT NULL COMMENT '是否过期',
  `account_not_locked` tinyint(4) NULL DEFAULT NULL COMMENT '账号是否锁定',
  `credentials_not_expired` tinyint(4) NULL DEFAULT NULL COMMENT '证书（密码）是否过期',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_user` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `update_user` int(11) NULL DEFAULT NULL COMMENT '修改人',
  `type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'user1', 'user1', '$2a$10$5.oYd3mmC7VclR7nfUzqOeo8Bhkr0XKuSiw1dyzA9j.4sz0g.S0fu', '2019-09-04 20:25:36', 1, 1, 1, 1, '2019-08-29 06:28:36', '2019-09-04 20:25:36', 1, 1, 'admin');
INSERT INTO `user_info` VALUES (2, 'user2', 'user2', '123456', '2023-03-22 14:27:25', NULL, NULL, NULL, NULL, '2023-03-22 14:27:10', '2023-03-22 14:27:14', 1, 1, 'user');

SET FOREIGN_KEY_CHECKS = 1;

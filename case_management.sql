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

 Date: 14/03/2023 16:28:47
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
INSERT INTO `case_management` VALUES (22, '其他', '糖尿病', 'case-糖尿病-1.jpg', 'case-糖尿病-1.mp4', '1', 'case-糖尿病-2.jpg', 'case-糖尿病-2.mp4', '2', NULL, NULL, '3', NULL, NULL, '4', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

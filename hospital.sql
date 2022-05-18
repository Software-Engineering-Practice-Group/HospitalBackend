/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : hospital

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 18/05/2022 23:53:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `dep_id` int NOT NULL AUTO_INCREMENT COMMENT '科室ID',
  `name` varchar(254) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL COMMENT '科室名称',
  `telephone` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '科室联系电话',
  `introduction` varchar(254) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '科室介绍',
  `capacity` int NULL DEFAULT NULL COMMENT '科室开放预约容量',
  `process1` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '就诊流程1,由管理员设置',
  `process2` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '就诊流程1',
  `process3` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `process4` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `process5` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `process6` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dep_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '儿童口腔科', '021-60496854', '专业知识强，给孩子很细心的检查，治疗，针对龋齿有很好的解决方案', 10, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `department` VALUES (2, '口腔全科门诊', '021-60496866', '蛀牙、龋齿、拔牙、拔智齿、阻生齿、阻生牙、埋伏牙、多生牙、智齿冠周炎、牙痛、牙疼、牙齿疼痛、坏牙、镶牙、假牙、儿童龋齿', 10, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '医生id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医生姓名',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属科室',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生简介',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生图片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES (1, '邱伟华', '口腔全科门诊', '普通', '邱伟华，主任医师，医学博士，博士生导师，博士后导师            上海交通大学医学院教授，博士生导师，瑞金医院普外科主任医师，中华医学会外科学分会实验外科学组委员，上海市医学会普外科专科分会甲状腺外科学组组员，中日医学科技交流协会医药发展与健康促进分会常委，上海市生物医药行业协会精准医疗专家委员会常务委员。', 'https://kano.guahao.cn/RZt298778996_image140.jpg?timestamp=1590279574774');
INSERT INTO `doctor` VALUES (2, '张锋', '儿童口腔科', '专家', '张峰，主任医师，博士生导师，中国医师协会心血管病分会青年委员会副主任委员，中华心血管病学会腔内影像和生理学组全国委员。上海市卫生系统青年人才的最高荣誉奖——银蛇奖获得者，上海市明治生命科学奖获得者，上海市杰出青年优秀人才，上海市青年科技启明星，上海市卫生系统优秀青年人才，复旦大学首批卓学计划人才。长期从事心血管病临床诊治工作，擅长冠心病、高血压、高血脂、心律失常、心功能不全等心血管疾病的诊治；作为第一术者每年实施冠脉介入诊疗术1500余例。', 'https://kano.guahao.cn/gTB17724263_image140.jpg?timestamp=1624346742720');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int NOT NULL COMMENT '订单号',
  `date` int NULL DEFAULT NULL COMMENT '预约挂号时间',
  `user_id` int NOT NULL COMMENT '挂号所属用户',
  `doctor_id` int NOT NULL COMMENT '订单挂号医生',
  `state` int NOT NULL DEFAULT 1 COMMENT '预约状态：1、待就诊2、已就诊3、取消,',
  `info` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '病历',
  `process` int NOT NULL DEFAULT 1 COMMENT '标记患者就诊步骤',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  INDEX `doctor_id`(`doctor_id` ASC) USING BTREE,
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, NULL, 1, 1, 1, '无备注信息', 0);

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL COMMENT '排班日期',
  `doctor_id` varchar(8) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL COMMENT '医生id',
  `doctor_name` varchar(5) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL COMMENT '医生姓名',
  `doctor_capacity` int NULL DEFAULT NULL COMMENT '医生开放预约容量',
  `DoctorState` int NOT NULL COMMENT '医生预约状态 1可预约 2不可预约',
  `time1` int NULL DEFAULT NULL COMMENT '排班时间段1',
  `time2` int NULL DEFAULT NULL COMMENT '排班时间段2',
  `time3` int NULL DEFAULT NULL COMMENT '排班时间段3\r\n',
  `time4` int NULL DEFAULT NULL COMMENT '排班时间段4',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES (1, '2022-04-19', '1', '张峰', 10, 1, NULL, NULL, NULL, NULL);
INSERT INTO `schedule` VALUES (2, '2022-04-26', '2', '邱伟华', 10, 1, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '登录账号id（8位）',
  `username` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名（6位）',
  `password` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码(不超过10位)',
  `identity` int NOT NULL COMMENT '用户身份 1、患者2医生3、管理员',
  `
gender` int NULL DEFAULT NULL COMMENT '性别：1 男 2 女',
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张义', '123456', 2, 1, '17605116678', '133656499@gmail');
INSERT INTO `user` VALUES (2, '仇玲', '123456', 1, 1, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

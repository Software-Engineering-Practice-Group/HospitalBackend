/*
 Navicat Premium Data Transfer

 Source Server         : Kiddo
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : hospital_

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 23/05/2022 16:11:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
                               `dep_id`       int NOT NULL AUTO_INCREMENT COMMENT '科室ID',
                               `name`         varchar(254) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL COMMENT '科室名称',
                               `telephone`    varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '科室联系电话',
                               `introduction` varchar(254) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '科室介绍',
                               `process1`     varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '就诊流程1,由管理员设置',
                               `process2`     varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '就诊流程2',
                               `process3`     varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
                               `process4`     varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
                               `process5`     varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
                               `process6`     varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
                               `capacity`     int NULL DEFAULT NULL,
                               PRIMARY KEY (`dep_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department`
VALUES (1, '儿童口腔科', '021-60496854', '专业知识强，给孩子很细心的检查，治疗，针对龋齿有很好的解决方案', '第一步', '第二步', '第三步', '第四步', '第五步', '第六步', NULL);
INSERT INTO `department`
VALUES (2, '口腔全科门诊', '021-60496866', '蛀牙、龋齿、拔牙、拔智齿、阻生齿、阻生牙、埋伏牙、多生牙、智齿冠周炎、牙痛、牙疼、牙齿疼痛、坏牙、镶牙、假牙、儿童龋齿', '第一步', '第二步', '第三步',
        '第四步', '第五步', '第六步', NULL);

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`
(
    `id`         int                                                     NOT NULL AUTO_INCREMENT COMMENT '医生id',
    `name`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医生姓名',
    `password`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医生密码',
    `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属科室',
    `title`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称',
    `info`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生简介',
    `image`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生图片',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor`
VALUES (1, '邱伟华', '123456', '口腔全科门诊', '普通',
        '邱伟华，主任医师，医学博士，博士生导师，博士后导师            上海交通大学医学院教授，博士生导师，瑞金医院普外科主任医师，中华医学会外科学分会实验外科学组委员，上海市医学会普外科专科分会甲状腺外科学组组员，中日医学科技交流协会医药发展与健康促进分会常委，上海市生物医药行业协会精准医疗专家委员会常务委员。',
        'https://kano.guahao.cn/RZt298778996_image140.jpg?timestamp=1590279574774');
INSERT INTO `doctor`
VALUES (2, '张锋', '123456', '儿童口腔科', '专家',
        '张峰，主任医师，博士生导师，中国医师协会心血管病分会青年委员会副主任委员，中华心血管病学会腔内影像和生理学组全国委员。上海市卫生系统青年人才的最高荣誉奖——银蛇奖获得者，上海市明治生命科学奖获得者，上海市杰出青年优秀人才，上海市青年科技启明星，上海市卫生系统优秀青年人才，复旦大学首批卓学计划人才。长期从事心血管病临床诊治工作，擅长冠心病、高血压、高血脂、心律失常、心功能不全等心血管疾病的诊治；作为第一术者每年实施冠脉介入诊疗术1500余例。',
        'https://kano.guahao.cn/gTB17724263_image140.jpg?timestamp=1624346742720');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
                           `id`        int NOT NULL COMMENT '订单号',
                           `date`      date NULL DEFAULT NULL COMMENT '预约挂号日期',
                           `user_id`   int NOT NULL COMMENT '挂号所属用户',
                           `doctor_id` int NOT NULL COMMENT '订单挂号医生',
                           `state`     int NOT NULL DEFAULT 1 COMMENT '预约状态：1、待就诊2、已就诊3、取消,4、未到违约',
                           `info`      varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '病历（医生每次结束某一流程都要覆盖写病历）',
                           `process`   int NOT NULL DEFAULT 1 COMMENT '标记患者处在六个就诊步骤中的哪一个',
                           `time`      int NOT NULL COMMENT '预约具体时间段（1，2，3，4）',
                           PRIMARY KEY (`id`) USING BTREE,
                           INDEX       `user_id`(`user_id` ASC) USING BTREE,
                           INDEX       `doctor_id`(`doctor_id` ASC) USING BTREE,
                           CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                           CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '2022-05-12', 1, 1, 1, '病历，医生可修改', 1, 1);

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL COMMENT '排班日期',
  `doctor_id` varchar(8) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL COMMENT '医生id',
  `doctor_name` varchar(5) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL COMMENT '医生姓名',
  `time1` int NULL DEFAULT NULL COMMENT '排班时间段1',
  `time2` int NULL DEFAULT NULL COMMENT '排班时间段2',
  `time3` int NULL DEFAULT NULL COMMENT '排班时间段3\r\n',
  `time4` int NULL DEFAULT NULL COMMENT '排班时间段4',
  `doctor_state` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule`
VALUES (1, '2022-04-19', '1', '张峰', 3, 5, 7, 8, 0);
INSERT INTO `schedule`
VALUES (2, '2022-04-26', '2', '邱伟华', 1, 2, 5, 0, 0);
INSERT INTO `schedule`
VALUES (3, '2022-04-19', '2', '邱伟华', 4, 12, 14, 8, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int                                                     NOT NULL AUTO_INCREMENT COMMENT '登录账号id',
    `username` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci   NOT NULL COMMENT '账户名（最高6位）',
    `password` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '登录密码(不超过10位)',
    `identity` int                                                     NOT NULL COMMENT '用户身份 1、患者2管理员',
    `
  gender`    int                                                     NOT NULL COMMENT '性别：1 男 2 女',
    `tel`      varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '电话号码',
    `mail`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
    `weiyue`   int NULL DEFAULT NULL COMMENT '违约次数',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (1, '张义', '123456', 2, 1, '17605116678', '133656499@gmail', NULL);
INSERT INTO `user`
VALUES (2, '仇玲', '123456', 1, 1, '13365487596', '133562459@gmail', 0);

SET
FOREIGN_KEY_CHECKS = 1;

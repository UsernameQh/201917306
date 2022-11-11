/*
 Navicat Premium Data Transfer

 Source Server         : JavaMySQL
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : tushu

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 30/12/2021 16:05:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `booksID` int NOT NULL AUTO_INCREMENT,
  `bookname` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `zuozhe` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `zuozhexb` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `jiage` float NULL DEFAULT NULL,
  `bookID` int NULL DEFAULT NULL,
  `bookdesc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`booksID`) USING BTREE,
  INDEX `waijian`(`bookID`) USING BTREE,
  CONSTRAINT `waijian` FOREIGN KEY (`bookID`) REFERENCES `typebook` (`bookID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES (7, '钢铁是这样炼成的', '熊大', '女', 23, 2, '励志');
INSERT INTO `books` VALUES (8, '人与自然', '大自然', '女', 29, 3, '讲述人与自然的关系');
INSERT INTO `books` VALUES (10, '人与自然', '大自然', '女', 29.9, 3, '讲述人与自然的关系');
INSERT INTO `books` VALUES (12, '人与自然', '大自然', '女', 29.9, 3, '讲述人与自然的关系');
INSERT INTO `books` VALUES (13, '人与自然', '大自然', '女', 29.9, 3, '讲述人与自然的关系');
INSERT INTO `books` VALUES (14, '人与自然', '大自然', '女', 29.9, 3, '讲述人与自然的关系');
INSERT INTO `books` VALUES (18, '钢铁是这样炼成的', '熊大', '女', 23.9, 2, '励志');
INSERT INTO `books` VALUES (19, '人与自然', '大自然', '女', 29.9, 3, '讲述人与自然的关系');
INSERT INTO `books` VALUES (20, '人与自然', '大自然', '女', 29.9, 3, '讲述人与自然的关系');
INSERT INTO `books` VALUES (29, '喜羊羊与灰太狼', '韦奉陪', '男', 45, 7, '动漫，类小说');
INSERT INTO `books` VALUES (36, '人与自然', '大自然', '女', 29, 3, '讲述人与自然的关系');
INSERT INTO `books` VALUES (39, '喜羊羊与灰太狼', '韦奉陪', '男', 45, 7, '动漫，类小说');
INSERT INTO `books` VALUES (41, '喜羊羊与灰太狼', '韦奉陪', '男', 45, 7, '动漫，类小说');
INSERT INTO `books` VALUES (42, 'C语言', '郝斌', '男', 49.8, 1, '基础编程语言');
INSERT INTO `books` VALUES (44, 'C语言程序设计', '66', '男', 59.9, 1, 'C语言基础');
INSERT INTO `books` VALUES (45, '平凡的世界', '路遥', '男', 39.9, 9, '在这个世界上，不是所有合理的和美好的都能按照自己的愿望或现实');

-- ----------------------------
-- Table structure for jieshuzhuangtaibiao
-- ----------------------------
DROP TABLE IF EXISTS `jieshuzhuangtaibiao`;
CREATE TABLE `jieshuzhuangtaibiao`  (
  `Loan_formid` int NOT NULL AUTO_INCREMENT,
  `zhuangtai` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `userID` int NULL DEFAULT NULL,
  `userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `booksname` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `zuozhe` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `zuozhexb` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `jiege` float NULL DEFAULT NULL,
  `bookid` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `typebook` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `bookdesc` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Loan_formid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jieshuzhuangtaibiao
-- ----------------------------
INSERT INTO `jieshuzhuangtaibiao` VALUES (1, '已还', 2, '阿华', '人与自然', '大自然', '女', 29, '3', '自然科学类', '讲述人与自然的关系');
INSERT INTO `jieshuzhuangtaibiao` VALUES (2, '审核不通过', 2, '阿华', '钢铁是这样炼成的', '熊大', '女', 23, '2', '建筑类', '励志');
INSERT INTO `jieshuzhuangtaibiao` VALUES (3, '审核不通过', 2, '阿华', '人与自然', '大自然', '女', 29, '3', '自然科学类', '讲述人与自然的关系');
INSERT INTO `jieshuzhuangtaibiao` VALUES (4, '已还', 2, '阿华', 'C语言', '郝斌', '男', 49.8, '1', '计算机类', '基础编程语言');
INSERT INTO `jieshuzhuangtaibiao` VALUES (5, '审核不通过', 2, '阿华', '人与自然', '大自然', '女', 29.9, '3', '自然科学类', '讲述人与自然的关系');
INSERT INTO `jieshuzhuangtaibiao` VALUES (6, '审核不通过', 2, '阿华', 'C语言', '郝斌', '男', 49.8, '1', '计算机类', '基础编程语言');
INSERT INTO `jieshuzhuangtaibiao` VALUES (7, '审核不通过', 2, '阿华', '喜羊羊与灰太狼', '韦奉陪', '男', 45, '7', '科幻类', '动漫，类小说');
INSERT INTO `jieshuzhuangtaibiao` VALUES (8, '审核不通过', 2, '阿华', '钢铁是这样炼成的', '熊大', '女', 23.9, '2', '建筑类', '励志');
INSERT INTO `jieshuzhuangtaibiao` VALUES (9, '审核不通过', 2, '阿华', '人与自然', '大自然', '女', 29.9, '3', '自然科学类', '讲述人与自然的关系');
INSERT INTO `jieshuzhuangtaibiao` VALUES (10, '审核不通过', 2, '阿华', '喜羊羊与灰太狼', '韦奉陪', '男', 45, '7', '科幻类', '动漫，类小说');
INSERT INTO `jieshuzhuangtaibiao` VALUES (11, '已审核', 2, '阿华', '人与自然', '大自然', '女', 29.9, '3', '自然科学类', '讲述人与自然的关系');
INSERT INTO `jieshuzhuangtaibiao` VALUES (12, '审核不通过', 2, '阿华', '小鱼儿', '五六七', '女', 28.8, '1', '计算机类', '动漫');
INSERT INTO `jieshuzhuangtaibiao` VALUES (13, '已审核', 2, '阿华', 'C语言', '郝斌', '男', 49.8, '1', '计算机类', '基础编程语言');
INSERT INTO `jieshuzhuangtaibiao` VALUES (14, '审核不通过', 2, '阿华', '小鱼儿', '五六七', '女', 28.8, '1', '计算机类', '动漫');
INSERT INTO `jieshuzhuangtaibiao` VALUES (15, '已还', 2, '阿华', 'C语言', '郝斌', '男', 49.8, '1', '计算机类', '基础编程语言');
INSERT INTO `jieshuzhuangtaibiao` VALUES (16, '已审核', 2, '阿华', '小鱼儿', '五六七', '女', 28.8, '1', '计算机类', '动漫');
INSERT INTO `jieshuzhuangtaibiao` VALUES (17, '审核不通过', 2, '阿华', 'C语言', '郝斌', '男', 49.8, '1', '计算机类', '基础编程语言');
INSERT INTO `jieshuzhuangtaibiao` VALUES (18, '审核不通过', 2, '阿华', '人与自然', '大自然', '女', 29.9, '3', '自然科学类', '讲述人与自然的关系');
INSERT INTO `jieshuzhuangtaibiao` VALUES (20, '已还', 2, '阿华', '喜羊羊与灰太狼', '韦奉陪', '男', 45, '7', '科幻类', '动漫，类小说');
INSERT INTO `jieshuzhuangtaibiao` VALUES (23, '已还', 2, '阿华', '喜羊羊与灰太狼', '韦奉陪', '男', 45, '7', '科幻类', '动漫，类小说');
INSERT INTO `jieshuzhuangtaibiao` VALUES (24, '审核不通过', 2, '阿华', '喜羊羊与灰太狼', '韦奉陪', '男', 45, '7', '科幻类', '动漫，类小说');
INSERT INTO `jieshuzhuangtaibiao` VALUES (25, '审核不通过', 2, '阿华', '喜羊羊与灰太狼', '韦奉陪', '男', 45, '7', '科幻类', '动漫，类小说');
INSERT INTO `jieshuzhuangtaibiao` VALUES (26, '审核不通过', 2, '阿华', '喜羊羊与灰太狼', '韦奉陪', '男', 45, '7', '科幻类', '动漫，类小说');
INSERT INTO `jieshuzhuangtaibiao` VALUES (27, '审核不通过', 2, '阿华', '喜羊羊与灰太狼', '韦奉陪', '男', 45, '7', '科幻类', '动漫，类小说');
INSERT INTO `jieshuzhuangtaibiao` VALUES (28, '审核不通过', 2, '阿华', 'C语言', '郝斌', '男', 49.8, '1', '计算机类', '基础编程语言');
INSERT INTO `jieshuzhuangtaibiao` VALUES (29, '已审核', 2, '阿华', 'C语言', '郝斌', '男', 49.8, '1', '计算机类', '基础编程语言');
INSERT INTO `jieshuzhuangtaibiao` VALUES (30, '已审核', 2, '阿华', '小鱼儿', '五六七', '女', 28.8, '1', '计算机类', '动漫');
INSERT INTO `jieshuzhuangtaibiao` VALUES (31, '已还', 1, '沈剑心', '昆虫记', '123', '男', 29.9, '3', '自然科学类', '2222');
INSERT INTO `jieshuzhuangtaibiao` VALUES (32, '已审核', 1, '沈剑心', '喜羊羊与灰太狼', '韦奉陪', '男', 45, '7', '科幻类', '动漫，类小说');
INSERT INTO `jieshuzhuangtaibiao` VALUES (33, '已还', 6, '伍天宽', '喜羊羊与灰太狼', '韦奉陪', '男', 45, '7', '科幻类', '动漫，类小说');
INSERT INTO `jieshuzhuangtaibiao` VALUES (34, '审核不通过', 6, '伍天宽', '小鱼儿', '五六七', '女', 28.8, '1', '计算机类', '动漫');
INSERT INTO `jieshuzhuangtaibiao` VALUES (35, '已审核', 3, '卢信', '小鱼儿', '五六七', '女', 28.8, '1', '计算机类', '动漫');
INSERT INTO `jieshuzhuangtaibiao` VALUES (36, '审核不通过', 2, '阿华', '小鱼儿', '五六七', '女', 28.8, '1', '计算机类', '动漫');
INSERT INTO `jieshuzhuangtaibiao` VALUES (37, '已审核', 2, '阿华', '小鱼儿', '五六七', '女', 28.8, '1', '计算机类', '动漫');
INSERT INTO `jieshuzhuangtaibiao` VALUES (38, '已还', 7, '韦奉陪', '喜羊羊与灰太狼', '韦奉陪', '男', 45, '7', '科幻类', '动漫，类小说');
INSERT INTO `jieshuzhuangtaibiao` VALUES (39, '已还', 7, '韦奉陪', 'C语言', '郝斌', '男', 49.8, '1', '计算机类', '基础编程语言');
INSERT INTO `jieshuzhuangtaibiao` VALUES (40, '已审核', 2, '阿华', '昆虫记', '123', '男', 29.9, '3', '自然科学类', '2222');
INSERT INTO `jieshuzhuangtaibiao` VALUES (41, '已审核', 2, '阿华', '小鱼儿', '五六七', '女', 28.8, '1', '计算机类', '动漫');
INSERT INTO `jieshuzhuangtaibiao` VALUES (42, '已审核', 2, '阿华', 'C语言', '郝斌', '男', 49.8, '1', '计算机类', '基础编程语言');
INSERT INTO `jieshuzhuangtaibiao` VALUES (43, '已审核', 1, '沈剑心', '消愁', '毛不易', '男', 12.9, '9', '文学类', '唱歌');
INSERT INTO `jieshuzhuangtaibiao` VALUES (44, '已审核', 1, '沈剑心', 'C语言', '郝斌', '男', 49.8, '1', '计算机类', '基础编程语言');
INSERT INTO `jieshuzhuangtaibiao` VALUES (45, '已审核', 9, 'user', '雪花的快乐', '徐志摩', '男', 29.9, '9', '文学类', '666');
INSERT INTO `jieshuzhuangtaibiao` VALUES (46, '已审核', 9, 'user', '小鱼儿', '五六七', '女', 28.8, '1', '计算机类', '动漫');

-- ----------------------------
-- Table structure for o_user
-- ----------------------------
DROP TABLE IF EXISTS `o_user`;
CREATE TABLE `o_user`  (
  `o_usersid` int NOT NULL AUTO_INCREMENT,
  `o_user` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `o_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`o_usersid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of o_user
-- ----------------------------
INSERT INTO `o_user` VALUES (1, '沈剑心', '123');
INSERT INTO `o_user` VALUES (3, '卢信', 'luxin');
INSERT INTO `o_user` VALUES (6, '伍天宽', '56');
INSERT INTO `o_user` VALUES (7, '韦奉陪', '123');
INSERT INTO `o_user` VALUES (9, 'user', '123');
INSERT INTO `o_user` VALUES (10, '吴莹辉', 'WYH');
INSERT INTO `o_user` VALUES (11, '刘青海', '201917306');

-- ----------------------------
-- Table structure for typebook
-- ----------------------------
DROP TABLE IF EXISTS `typebook`;
CREATE TABLE `typebook`  (
  `bookID` int NOT NULL AUTO_INCREMENT,
  `typebook` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `descw` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bookID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of typebook
-- ----------------------------
INSERT INTO `typebook` VALUES (1, '计算机类', '计算机相关图书');
INSERT INTO `typebook` VALUES (2, '建筑类', '建筑相关图书');
INSERT INTO `typebook` VALUES (3, '自然科学类', '自然科学相关');
INSERT INTO `typebook` VALUES (4, '舞蹈类', '关于唱跳rap篮球的');
INSERT INTO `typebook` VALUES (5, '数学类', '关于数学以及自然物理');
INSERT INTO `typebook` VALUES (7, '科幻类', '关于高科技的，黑科技的');
INSERT INTO `typebook` VALUES (8, '都市小说', '高富帅、撩妹。');
INSERT INTO `typebook` VALUES (9, '文学类', '文艺');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `UserName` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `PassWord` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, '韦奉陪', '123');
INSERT INTO `user` VALUES (3, '刘青海', '201917306');
INSERT INTO `user` VALUES (4, '管理员', '123');

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : layuissm

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 24/12/2020 12:43:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `classid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `classclass` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`classid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1801', 'java1');
INSERT INTO `class` VALUES ('1802', 'java2');
INSERT INTO `class` VALUES ('1803', 'java3');
INSERT INTO `class` VALUES ('1804', 'java4');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cid` int(10) NOT NULL AUTO_INCREMENT,
  `cname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ctime` int(20) NULL DEFAULT NULL,
  `cscore` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  INDEX `cname`(`cname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'JavaEE', 60, 4);
INSERT INTO `course` VALUES (2, 'Oracle', 55, 3);
INSERT INTO `course` VALUES (3, '企业项目实战', 60, 4);
INSERT INTO `course` VALUES (4, '软件工程导论', 50, 3);
INSERT INTO `course` VALUES (5, '计算机网络', 60, 4);
INSERT INTO `course` VALUES (6, '软件前沿技术', 60, 4);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `scoreid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scoresname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scorecname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scoreu` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scoref` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scoregrade` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`scorecname`, `scoresname`, `scoreid`) USING BTREE,
  INDEX `sname`(`scoresname`) USING BTREE,
  INDEX `cname`(`scorecname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('184804003', '王五', 'JavaEE', '30', '30', '30');
INSERT INTO `score` VALUES ('184804004', '李一', 'Oracle', '30', '80', '60');
INSERT INTO `score` VALUES ('184804005', '小明', '企业项目实战', '79', '68', '67');
INSERT INTO `score` VALUES ('184804002', '李四', '企业项目实战', '70', '80', '75');
INSERT INTO `score` VALUES ('184804005', '小明', '计算机网络', '90', '90', '90');
INSERT INTO `score` VALUES ('184804001', '张三', '计算机网络', '20', '80', '50');
INSERT INTO `score` VALUES ('184804004', '李一', '计算机网络', '30', '30', '30');
INSERT INTO `score` VALUES ('184804002', '李四', '计算机网络', '20', '40', '30');
INSERT INTO `score` VALUES ('184804003', '王五', '软件前沿技术', '80', '80', '80');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sid` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `school` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sclass` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE,
  INDEX `sname`(`sname`) USING BTREE,
  INDEX `sex`(`sex`) USING BTREE,
  INDEX `sclass`(`sclass`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('184804001', '张三', '男', '软件学院', 'java1', '18317675777');
INSERT INTO `student` VALUES ('184804002', '李四', '女', '软件学院', 'java2', '18317675778');
INSERT INTO `student` VALUES ('184804003', '王五', '女', '软件学院', 'java1', '18317675779');
INSERT INTO `student` VALUES ('184804004', '李一', '男', '软件学院', 'java3', '18317675710');
INSERT INTO `student` VALUES ('184804005', '小明', '男', '软件学院', 'java2', '12893718931');
INSERT INTO `student` VALUES ('184804006', '小红', '女', '软件学院', 'java1', '17289371892');
INSERT INTO `student` VALUES ('184804007', '肯定', '男', '软件学院', 'java3', '18237819273');
INSERT INTO `student` VALUES ('184804008', '喀什', '女', '软件学院', 'java2', '78192738912');
INSERT INTO `student` VALUES ('184804009', '艾酷', '女', '软件学院', 'java1', '17829371729');
INSERT INTO `student` VALUES ('184804010', '就是', '男', '软件学院', 'java1', '71829371712');
INSERT INTO `student` VALUES ('184804011', '沙克', '男', '软件学院', 'java1', '17893791189');
INSERT INTO `student` VALUES ('184804012', '数据', '男', '软件学院', 'java1', '17289371892');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10000', '123456', 'teacher', '刘老师');
INSERT INTO `user` VALUES ('184804001', '123456', 'student', '张三');
INSERT INTO `user` VALUES ('184804002', '123456', 'student', '李四');
INSERT INTO `user` VALUES ('184804003', '123456', 'student', '王五');
INSERT INTO `user` VALUES ('184804004', '123456', 'student', '李一');

-- ----------------------------
-- View structure for info
-- ----------------------------
DROP VIEW IF EXISTS `info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `info` AS select `class`.`classid` AS `infoclass`,`student`.`sclass` AS `inforoom`,sum(`score`.`scoreu`) AS `infouscore`,cast(avg(`score`.`scoreu`) as decimal(10,0)) AS `infouavg`,sum(`score`.`scoref`) AS `infofscore`,cast(avg(`score`.`scoref`) as decimal(10,0)) AS `infofavg`,sum(`score`.`scoregrade`) AS `infozscore`,cast(avg(`score`.`scoregrade`) as decimal(10,0)) AS `infozavg` from ((`student` join `score`) join `class`) where ((`student`.`sid` = `score`.`scoreid`) and (`student`.`sclass` = `class`.`classclass`)) group by `student`.`sclass`;

SET FOREIGN_KEY_CHECKS = 1;

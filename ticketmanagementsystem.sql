/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : ticketmanagementsystem

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 14/11/2023 21:34:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `adminId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `adminPassword` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `adminName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `adminSex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `adminPhone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `adminIdNum` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `adminAvatar` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`adminId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('202200406217', '666666', '潘勇强', '男', '18775556324', '450921200410064877', '1');
INSERT INTO `tb_admin` VALUES ('202200406236', '666666', '梁兆权', '男', '11111111111', '111111111111111111', '2');
INSERT INTO `tb_admin` VALUES ('666666', '666666', '蔡徐坤', '男', '11111111111', '111111111111111111', '1');

-- ----------------------------
-- Table structure for tb_buyticket
-- ----------------------------
DROP TABLE IF EXISTS `tb_buyticket`;
CREATE TABLE `tb_buyticket`  (
  `userId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `data` date NOT NULL,
  `shift` int NOT NULL,
  `purchaseQuantity` int NOT NULL,
  INDEX `userId`(`userId` ASC) USING BTREE,
  INDEX `data`(`data` ASC) USING BTREE,
  INDEX `shift`(`shift` ASC) USING BTREE,
  CONSTRAINT `data` FOREIGN KEY (`data`) REFERENCES `tb_shift_info` (`data`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shift` FOREIGN KEY (`shift`) REFERENCES `tb_shift_info` (`shift`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_buyticket
-- ----------------------------
INSERT INTO `tb_buyticket` VALUES ('202200406217', '2023-06-16', 3, 5);

-- ----------------------------
-- Table structure for tb_shift_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_shift_info`;
CREATE TABLE `tb_shift_info`  (
  `data` date NOT NULL,
  `shift` int NOT NULL,
  `time` time NOT NULL,
  `startPosition` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `endPosition` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `duration` int NOT NULL,
  `ratedCapacity` int NOT NULL,
  PRIMARY KEY (`data`, `shift`) USING BTREE,
  INDEX `data`(`data` ASC) USING BTREE,
  INDEX `shift`(`shift` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shift_info
-- ----------------------------
INSERT INTO `tb_shift_info` VALUES ('2023-06-03', 5, '10:54:48', '北京市', '中山', 517, 9);
INSERT INTO `tb_shift_info` VALUES ('2023-06-04', 10, '12:49:07', '东莞', '深圳', 234, 3);
INSERT INTO `tb_shift_info` VALUES ('2023-06-06', 3, '11:45:17', '成都市', '成都市', 52, 6);
INSERT INTO `tb_shift_info` VALUES ('2023-06-07', 3, '12:47:35', '容县', '玉林', 1, 30);
INSERT INTO `tb_shift_info` VALUES ('2023-06-14', 10, '17:00:00', '中山', '中山', 457, 10);
INSERT INTO `tb_shift_info` VALUES ('2023-06-15', 2, '16:42:13', '中山', '广州市', 899, 6);
INSERT INTO `tb_shift_info` VALUES ('2023-06-16', 2, '08:00:00', '柳州', '南宁', 2, 50);
INSERT INTO `tb_shift_info` VALUES ('2023-06-16', 3, '08:00:00', '柳州', '玉林', 5, 5);
INSERT INTO `tb_shift_info` VALUES ('2023-06-16', 4, '08:00:00', '柳州', '南宁', 2, 55);
INSERT INTO `tb_shift_info` VALUES ('2023-06-17', 2, '08:00:00', '柳州南站', '广州站', 4, 55);
INSERT INTO `tb_shift_info` VALUES ('2023-06-17', 3, '08:00:00', '柳州总站', '深圳南站', 5, 60);
INSERT INTO `tb_shift_info` VALUES ('2023-06-17', 4, '08:00:00', '柳州南站', '容县总站', 6, 60);
INSERT INTO `tb_shift_info` VALUES ('2023-06-17', 5, '10:00:00', '柳州站', '白色站', 5, 100);
INSERT INTO `tb_shift_info` VALUES ('2023-06-17', 6, '12:00:00', '柳州站', '钦州站', 6, 66);
INSERT INTO `tb_shift_info` VALUES ('2023-06-18', 1, '08:00:00', '6', '6', 6, 6);
INSERT INTO `tb_shift_info` VALUES ('2023-06-18', 4, '09:10:00', '中山', '北京市', 371, 2);
INSERT INTO `tb_shift_info` VALUES ('2023-06-25', 8, '12:15:14', '北京市', '中山', 131, 2);
INSERT INTO `tb_shift_info` VALUES ('2023-06-30', 1, '08:00:00', '柳州', '南宁', 2, 50);
INSERT INTO `tb_shift_info` VALUES ('2023-06-30', 2, '09:00:00', '柳州', '广东', 2, 60);
INSERT INTO `tb_shift_info` VALUES ('2023-06-30', 3, '10:00:00', '柳州', '玉林', 3, 40);
INSERT INTO `tb_shift_info` VALUES ('2023-06-30', 4, '11:00:00', '柳州', '钦州', 4, 30);
INSERT INTO `tb_shift_info` VALUES ('2023-06-30', 5, '14:00:00', '柳州', '广州', 3, 50);
INSERT INTO `tb_shift_info` VALUES ('2023-06-30', 6, '12:00:00', '南宁站', '玉林站', 3, 50);
INSERT INTO `tb_shift_info` VALUES ('2023-06-30', 7, '12:00:00', '南宁', '柳州', 4, 50);
INSERT INTO `tb_shift_info` VALUES ('2023-06-30', 8, '14:00:00', '柳州', '钦州', 5, 60);
INSERT INTO `tb_shift_info` VALUES ('2023-06-30', 9, '15:00:00', '柳州', '云南', 4, 60);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `userId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userPassword` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `userPhone` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `userIdNum` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `userSex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '1', '1', '1', '1', '1');
INSERT INTO `tb_user` VALUES ('111111111111', '111111', '111', '111', '111', '男');
INSERT INTO `tb_user` VALUES ('202200406217', '666666', '潘勇强', '18775556324', '450921200410064877', '男');
INSERT INTO `tb_user` VALUES ('202200406218', '666666', '潘勇强', '11111111111', '111111111111111111', '男');
INSERT INTO `tb_user` VALUES ('222222222222', '666666', '666', '666666', '666666', '男');

-- ----------------------------
-- Procedure structure for GetTicketInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `GetTicketInfo`;
delimiter ;;
CREATE PROCEDURE `GetTicketInfo`(IN date_param DATE, IN start_station VARCHAR(255), IN end_station VARCHAR(255))
BEGIN
  SELECT
    tb_shift_info.shift AS '班次',
    tb_shift_info.`data` AS '发车日期',
    tb_shift_info.time AS '发车时间',
    tb_shift_info.startPosition AS '起点站',
    tb_shift_info.endPosition AS '终点站',
    tb_shift_info.duration AS '行车时间',
    tb_shift_info.ratedCapacity AS '额定数量',
    COALESCE(
      (
        SELECT SUM(tb_buyticket.purchaseQuantity)
        FROM tb_buyticket
        WHERE tb_buyticket.shift = tb_shift_info.shift
          AND tb_buyticket.data = date_param
      ), 0
    ) AS '已售数量'
  FROM
    tb_shift_info
  WHERE
    tb_shift_info.data = date_param
    AND tb_shift_info.startPosition LIKE CONCAT('%', start_station, '%')
    AND tb_shift_info.endPosition LIKE CONCAT('%', end_station, '%');
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for GetTicketInfoByDate
-- ----------------------------
DROP PROCEDURE IF EXISTS `GetTicketInfoByDate`;
delimiter ;;
CREATE PROCEDURE `GetTicketInfoByDate`(IN date_param DATE)
BEGIN
  SELECT
    tb_shift_info.shift AS '班次',
		tb_shift_info.`data` AS '发车日期',
    tb_shift_info.time AS '发车时间',
    tb_shift_info.startPosition AS '起点站',
    tb_shift_info.endPosition AS '终点站',
    tb_shift_info.duration AS '行车时间',
    tb_shift_info.ratedCapacity AS '额定数量',
    (tb_shift_info.ratedCapacity - COALESCE(
      (
        SELECT SUM(tb_buyticket.purchaseQuantity)
        FROM tb_buyticket
        WHERE tb_buyticket.shift = tb_shift_info.shift
          AND tb_buyticket.data = date_param
      ), 0)
    ) AS '剩余票数'
  FROM
    tb_shift_info
  WHERE
    tb_shift_info.data = date_param;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for GetTicketInfoByDateAndStations
-- ----------------------------
DROP PROCEDURE IF EXISTS `GetTicketInfoByDateAndStations`;
delimiter ;;
CREATE PROCEDURE `GetTicketInfoByDateAndStations`(IN date_param DATE, IN start_station VARCHAR(255), IN end_station VARCHAR(255))
BEGIN
  SELECT
    tb_shift_info.shift AS '班次',
		tb_shift_info.`data` AS '发车日期',
    tb_shift_info.time AS '发车时间',
    tb_shift_info.startPosition AS '起点站',
    tb_shift_info.endPosition AS '终点站',
    tb_shift_info.duration AS '行车时间',
    tb_shift_info.ratedCapacity AS '额定数量',
    (tb_shift_info.ratedCapacity - COALESCE(
      (
        SELECT SUM(tb_buyticket.purchaseQuantity)
        FROM tb_buyticket
        WHERE tb_buyticket.shift = tb_shift_info.shift
          AND tb_buyticket.data = date_param
      ), 0)
    ) AS '剩余票数'
  FROM
    tb_shift_info
  WHERE
    tb_shift_info.data = date_param
    AND tb_shift_info.startPosition LIKE CONCAT('%', start_station, '%')
    AND tb_shift_info.endPosition LIKE CONCAT('%', end_station, '%');
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for GetTicketInfoByStartStation
-- ----------------------------
DROP PROCEDURE IF EXISTS `GetTicketInfoByStartStation`;
delimiter ;;
CREATE PROCEDURE `GetTicketInfoByStartStation`(IN start_station VARCHAR(255))
BEGIN
  SELECT
    tb_shift_info.shift AS '班次',
    tb_shift_info.`data` AS '发车日期',
    tb_shift_info.time AS '发车时间',
    tb_shift_info.startPosition AS '起点站',
    tb_shift_info.endPosition AS '终点站',
    tb_shift_info.duration AS '行车时间',
    tb_shift_info.ratedCapacity AS '额定数量',
    (tb_shift_info.ratedCapacity - COALESCE(
      (
        SELECT SUM(tb_buyticket.purchaseQuantity)
        FROM tb_buyticket
        WHERE tb_buyticket.shift = tb_shift_info.shift
          AND tb_buyticket.data = tb_shift_info.data
      ), 0)
    ) AS '剩余票数'
  FROM
    tb_shift_info
  WHERE
    tb_shift_info.startPosition LIKE CONCAT('%', start_station, '%');
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for GetUserTicketInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `GetUserTicketInfo`;
delimiter ;;
CREATE PROCEDURE `GetUserTicketInfo`(IN userId VARCHAR(255))
BEGIN
  SELECT s.data AS '日期', s.shift AS '班次', s.time AS '发车时间', s.startPosition AS '起点站', s.endPosition AS '终点站', s.duration AS '行车时间', t.已购票数
  FROM tb_shift_info s
  JOIN (
    SELECT data, shift, SUM(purchaseQuantity) AS '已购票数'
    FROM tb_buyticket
    WHERE userId = userId
    GROUP BY data, shift
  ) t ON s.data = t.data AND s.shift = t.shift;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for get_shift_info
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_shift_info`;
delimiter ;;
CREATE PROCEDURE `get_shift_info`(IN InputDate DATE)
BEGIN
  SELECT
    shift AS '班次',
    time AS '发车时间',
    startPosition AS '起点站',
    endPosition AS '终点站',
    duration AS '行车时间',
    ratedCapacity AS '额定载量',
    COALESCE(
      (
        SELECT SUM(purchaseQuantity)
        FROM tb_buyticket
        WHERE tb_buyticket.shift = tb_shift_info.shift
          AND tb_buyticket.data = InputDate
      ), 0
    ) AS '已订票数量'
  FROM
    tb_shift_info
  WHERE
    data = InputDate;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;

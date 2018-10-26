-- /*
--  Navicat Premium Data Transfer
--
--  Source Server         : 本地连接
--  Source Server Type    : MySQL
--  Source Server Version : 50722
--  Source Host           : localhost:3306
--  Source Schema         : yidu
--
--  Target Server Type    : MySQL
--  Target Server Version : 50722
--  File Encoding         : 65001
--
--  Date: 31/07/2018 15:03:00
-- */
--
-- SET NAMES utf8mb4;
-- SET FOREIGN_KEY_CHECKS = 0;
--
-- -- ----------------------------
-- -- Table structure for exam
-- -- ----------------------------
-- CREATE TABLE `exam`  (
--   `id` bigint(20) NOT NULL AUTO_INCREMENT,
--   `exam_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
--   `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
--   `quest_num` int(11) NOT NULL,
--   `quest_groups` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
--   PRIMARY KEY (`id`) USING BTREE
-- ) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci;
--
-- SET FOREIGN_KEY_CHECKS = 1;
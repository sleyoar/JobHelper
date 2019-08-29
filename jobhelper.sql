/*
 Navicat MySQL Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : jobhelper

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 29/08/2019 16:34:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for jh_admin
-- ----------------------------
DROP TABLE IF EXISTS `jh_admin`;
CREATE TABLE `jh_admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `admin_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员名字',
  `admin_password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `admin_phone` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员联系电话',
  `admin_Email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员邮箱',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for jh_blog
-- ----------------------------
DROP TABLE IF EXISTS `jh_blog`;
CREATE TABLE `jh_blog`  (
  `blog_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客id',
  `blog_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客用户',
  `blog_category` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客类别',
  `blog_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客标题',
  `blog_context` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '博客正文',
  `blog_date` date NULL DEFAULT NULL COMMENT '发文时间',
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for jh_contact
-- ----------------------------
DROP TABLE IF EXISTS `jh_contact`;
CREATE TABLE `jh_contact`  (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '联系我们id',
  `contact_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名字',
  `contact_email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `context_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细信息',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`contact_id`) USING BTREE,
  INDEX `contact`(`user_id`) USING BTREE,
  CONSTRAINT `contact` FOREIGN KEY (`user_id`) REFERENCES `jh_user` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for jh_job
-- ----------------------------
DROP TABLE IF EXISTS `jh_job`;
CREATE TABLE `jh_job`  (
  `job_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职位id',
  `job_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位名称',
  `job_salary` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位薪资',
  `job_category` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位类别',
  `job_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位描述',
  `job_buff` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位诱惑',
  `job_need` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '职位要求',
  `job_quality` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位性质',
  `job_date` date NULL DEFAULT NULL COMMENT '职位发布时间',
  `job_address` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就职地点',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for jh_resume
-- ----------------------------
DROP TABLE IF EXISTS `jh_resume`;
CREATE TABLE `jh_resume`  (
  `resume_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '简历id',
  `resume_pic` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简历照片',
  `resume_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简历名称',
  `resume_address` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简历地址',
  `resume_phone` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简历电话',
  `resume_email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简历邮箱',
  `resume_page` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简历社交主页',
  `resume_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自我描述',
  `resume_school` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业学校名称',
  `resume_degree` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `resume_honour` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '荣誉奖项',
  `project_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名',
  `project_time` int(11) NULL DEFAULT NULL COMMENT '项目时长',
  `project_describe` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '项目描述',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`resume_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `jh_user` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for jh_user
-- ----------------------------
DROP TABLE IF EXISTS `jh_user`;
CREATE TABLE `jh_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

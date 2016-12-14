-- ----------------------------
-- Table structure for `m_menu`
-- ----------------------------
DROP TABLE IF EXISTS `m_menu`;
CREATE TABLE `m_menu` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `style` varchar(50) NOT NULL,
  `status` int(1) DEFAULT '1',
  `sort` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_menu
-- ----------------------------
INSERT INTO `m_menu` VALUES ('51b68d781caf43a3831a86bc710c5d45', '报表系统', 'fa fa-bar-chart-o', '1', '3');
INSERT INTO `m_menu` VALUES ('83386c802bfb40cf841f4ee58a81a56a', '菜品管理', 'fa fa-cutlery', '1', '2');
INSERT INTO `m_menu` VALUES ('98b24fc757c44faf92061d864a918c87', '用户管理', 'fa fa-user', '1', '4');
INSERT INTO `m_menu` VALUES ('af69c8b3cb0f4ece9ee1740651a0fc96', '订单管理', 'fa fa-list-alt', '1', '1');

DROP TABLE IF EXISTS `m_sub_menu`;
CREATE TABLE `m_sub_menu` (
  `id` varchar(32) NOT NULL,
  `menu_id` varchar(32) NOT NULL,
  `url` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `disabled` int(1) DEFAULT '0',
  `sort` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_sub_menu
-- ----------------------------
INSERT INTO `m_sub_menu` VALUES ('4998075bb9c043f8b9844e32d415c970', '51b68d781caf43a3831a86bc710c5d45', '/user', '客户统计', '0', '2');
INSERT INTO `m_sub_menu` VALUES ('4a5684e0ac0b41baa2f79c10939572d7', '83386c802bfb40cf841f4ee58a81a56a', '/userInfo/list4', '分类管理', '0', '2');
INSERT INTO `m_sub_menu` VALUES ('62dc7eb76dda4c679d778254fdc4fabb', '83386c802bfb40cf841f4ee58a81a56a', '/userInfo/list3', '菜品列表', '0', '1');
INSERT INTO `m_sub_menu` VALUES ('a3aeeb51df314121a1bb21ac4e4334fa', '98b24fc757c44faf92061d864a918c87', '/user', '客户管理', '0', '1');
INSERT INTO `m_sub_menu` VALUES ('aa842007d5d04012b171058e5621a0d2', '51b68d781caf43a3831a86bc710c5d45', '/userInfo/list1', '菜品统计', '0', '1');
INSERT INTO `m_sub_menu` VALUES ('d0eda18d501040f68dab3709abb7666f', '98b24fc757c44faf92061d864a918c87', '/user', '账户管理', '0', '2');
INSERT INTO `m_sub_menu` VALUES ('f85cdb7800cd40a2a7a1ac5c5618076f', 'af69c8b3cb0f4ece9ee1740651a0fc96', '/userInfo/list1', '订单列表', '0', '1');

-- ----------------------------
-- Table structure for `k_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `k_user_info`;
CREATE TABLE `k_user_info` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `state` int(1) DEFAULT '1',
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `k_system_setting`
-- ----------------------------
DROP TABLE IF EXISTS `k_system_setting`;
CREATE TABLE `k_system_setting` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `business_start` int(2) DEFAULT NULL COMMENT '营业开始时间',
  `business_end` int(2) DEFAULT NULL COMMENT '营业结束时间',
  `delivery_start` int(2) DEFAULT NULL COMMENT '配送开始时间',
  `delivery_end` int(2) DEFAULT NULL COMMENT '配送结束时间',
  `state` int(1) DEFAULT '1' COMMENT '1-营业，2-歇业',
  `agreement` text COMMENT '用户协议',
  `time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of k_system_setting
-- ----------------------------
INSERT INTO `k_system_setting` VALUES ('edcb78dd3fff46228682f0493c87dfd8', '0', '24', '0', '24', '1', '此处编辑用户协议内容', '2016-12-14 18:28:12');
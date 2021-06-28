/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : 127.0.0.1:3306
 Source Schema         : apeces

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 07/04/2021 19:02:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `user_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, '13515013510', 'kris_wu', '潮汕普揭', 0);
INSERT INTO `address` VALUES (5, '13515013510', 'kris', '潮汕普揭', 1);
INSERT INTO `address` VALUES (3, '13515013510', 'kris', '潮汕普揭', 0);
INSERT INTO `address` VALUES (4, '13515013510', 'kris', '潮汕普揭', 1);
INSERT INTO `address` VALUES (9, '846784', '太偏激了', '天津哈哈哈', 2);
INSERT INTO `address` VALUES (8, '548756794', '姑凉', '提囧膜', 2);
INSERT INTO `address` VALUES (11, '8556665', 'fcc', 'chghjh', 8);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '红薯');
INSERT INTO `category` VALUES (2, '白薯');
INSERT INTO `category` VALUES (3, '马铃薯');
INSERT INTO `category` VALUES (4, '山药');
INSERT INTO `category` VALUES (5, '芋');
INSERT INTO `category` VALUES (6, '木薯');
INSERT INTO `category` VALUES (7, '水稻');
INSERT INTO `category` VALUES (8, '玉米');
INSERT INTO `category` VALUES (9, '小麦');
INSERT INTO `category` VALUES (10, '大麦');
INSERT INTO `category` VALUES (11, '燕麦');
INSERT INTO `category` VALUES (12, '高粱');
INSERT INTO `category` VALUES (13, '栗');
INSERT INTO `category` VALUES (14, '黍');
INSERT INTO `category` VALUES (15, '荞麦');
INSERT INTO `category` VALUES (16, '大豆');
INSERT INTO `category` VALUES (17, '蚕豆');
INSERT INTO `category` VALUES (18, '豌豆');
INSERT INTO `category` VALUES (19, '绿豆');
INSERT INTO `category` VALUES (20, '红小豆');
INSERT INTO `category` VALUES (21, '芸豆');
INSERT INTO `category` VALUES (22, '叶菜类');
INSERT INTO `category` VALUES (23, '根茎类');
INSERT INTO `category` VALUES (24, '芽苗类');
INSERT INTO `category` VALUES (26, '花菜类');
INSERT INTO `category` VALUES (27, '果菜类');
INSERT INTO `category` VALUES (28, '菌类');
INSERT INTO `category` VALUES (29, '瓜类');
INSERT INTO `category` VALUES (30, 'test');
INSERT INTO `category` VALUES (31, '粮食');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `score` tinyint(4) NOT NULL DEFAULT 5,
  `user_id` int(11) NOT NULL DEFAULT 0,
  `product_id` int(11) NOT NULL DEFAULT 0,
  `shop_id` int(11) NOT NULL DEFAULT 0,
  `order_id` int(11) NOT NULL DEFAULT 0,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 'test', 5, 1, 1, 1, 1, '2021-02-04 18:54:53');
INSERT INTO `comment` VALUES (2, 'test', 5, 1, 1, 1, 1, '2021-03-01 23:09:48');
INSERT INTO `comment` VALUES (3, 'ggg', 3, 2, 1, 1, 13, '2021-03-02 00:17:25');
INSERT INTO `comment` VALUES (4, '', 0, 2, 1, 1, 14, '2021-03-02 00:20:25');
INSERT INTO `comment` VALUES (5, '', 0, 2, 1, 1, 9, '2021-03-02 00:23:03');

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `create_time` timestamp(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logistics
-- ----------------------------
INSERT INTO `logistics` VALUES (5, 7, '您已提交订单，请等待系统确认', '2021-02-28 23:16:08');
INSERT INTO `logistics` VALUES (3, 7, '您已提交订单，请等待系统确认', '2021-02-04 16:26:56');
INSERT INTO `logistics` VALUES (4, 7, '订单确认，已通知商家配货', '2021-02-04 16:26:56');
INSERT INTO `logistics` VALUES (6, 7, '订单确认，已通知商家配货', '2021-02-28 23:16:08');
INSERT INTO `logistics` VALUES (7, 12, '您已提交订单，请等待系统确认', '2021-02-28 23:16:29');
INSERT INTO `logistics` VALUES (8, 12, '订单确认，已通知商家配货', '2021-02-28 23:16:29');
INSERT INTO `logistics` VALUES (9, 13, '您已提交订单，请等待系统确认', '2021-02-28 23:19:57');
INSERT INTO `logistics` VALUES (10, 13, '订单确认，已通知商家配货', '2021-02-28 23:19:57');
INSERT INTO `logistics` VALUES (11, 14, '您已提交订单，请等待系统确认', '2021-02-28 23:20:41');
INSERT INTO `logistics` VALUES (12, 14, '订单确认，已通知商家配货', '2021-02-28 23:20:41');
INSERT INTO `logistics` VALUES (13, 15, '您已提交订单，请等待系统确认', '2021-02-28 23:21:45');
INSERT INTO `logistics` VALUES (14, 15, '订单确认，已通知商家配货', '2021-02-28 23:21:45');
INSERT INTO `logistics` VALUES (15, 16, '您已提交订单，请等待系统确认', '2021-02-28 23:22:59');
INSERT INTO `logistics` VALUES (16, 16, '订单确认，已通知商家配货', '2021-02-28 23:22:59');
INSERT INTO `logistics` VALUES (17, 17, '您已提交订单，请等待系统确认', '2021-02-28 23:23:36');
INSERT INTO `logistics` VALUES (18, 17, '订单确认，已通知商家配货', '2021-02-28 23:23:36');
INSERT INTO `logistics` VALUES (19, 18, '您已提交订单，请等待系统确认', '2021-03-01 23:44:04');
INSERT INTO `logistics` VALUES (20, 18, '订单确认，已通知商家配货', '2021-03-01 23:44:04');
INSERT INTO `logistics` VALUES (21, 19, '您已提交订单，请等待系统确认', '2021-03-02 21:56:29');
INSERT INTO `logistics` VALUES (22, 19, '订单确认，已通知商家配货', '2021-03-02 21:56:29');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `shop_id` int(11) NULL DEFAULT NULL COMMENT 'shop.id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, '13515013510', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `manager` VALUES (2, '17718819910', 'e10adc3949ba59abbe56e057f20f883e', 1);
INSERT INTO `manager` VALUES (3, '14415516610', 'e10adc3949ba59abbe56e057f20f883e', 2);
INSERT INTO `manager` VALUES (4, '12213312310', 'e10adc3949ba59abbe56e057f20f883e', 3);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `cover_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '封面',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '内容',
  `create_time` timestamp(0) NOT NULL,
  `product_id` int(11) NOT NULL DEFAULT 0,
  `shop_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '农产品量多质优、知名度不够，达州如何擦亮品牌？', '/upload/20210222/6750b363-0547-4562-8480-f21441654abe_NEWS_7A71523670BC6BEF838578095B3AE6F0.JPG', '达州农业大市并非徒有虚名，数据佐证：去年，全市第一产业增加值394亿元，位列全省第三。\r\n\r\n“民以食为天，猪粮安天下”。去年，达州粮食总产量319.37万吨，实现“十四连增”，稳居全省第一位；生猪出栏370.17万头，增长15%。\r\n\r\n不止是总量大，达州特色农产品丰富。富硒茶叶、苎麻、中药材、脆李、香椿等特色产业基地总规模达到270万亩，“四乡三都两基地”即中国苎麻之乡、中国黄花之乡、中国糯稻之乡、中国乌梅之乡，中国油橄榄之都、中国富硒茶之都、中国醪糟之都，国家商品粮、优质商品猪保障基地和中国香椿第一县。', '2021-01-30 10:19:48', 0, 0);
INSERT INTO `news` VALUES (2, '从田头到餐桌可视化-惠农网持续推进农特产品质量安全追溯体系建设工作', '/upload/20210222/0f45eecc-c935-4e53-af27-f992f9d6435f_1548a51ed570444c9c762d9b38f7abef.png', '当吃喝不愁的时候，人们便开始讲究了，讲品牌、讲品质，品质是产品的核心，是产业可持续发展的动力。\r\n\r\n我县高度重视农产品的品质保障，为解决当前食品安全和产品质量方面存在的突出问题，依托沅陵县电子商务进农村综合示范项目联合惠农网开展沅陵县农特产品质量安全追溯体系建设工作，利用一物一码技术、物联网技术对我县特色农产品进行从田间到市场的全程管控，及时掌握农特产品质量安全运行态势，推促全面提升农特产品质量安全水平，维护沅陵农特产品良好的生产与市场秩序。', '2021-02-22 14:21:10', 0, 0);
INSERT INTO `news` VALUES (5, '惠农网品牌市场化助力“新邵资味·腊之乡”年销售同比增加500万元', '/upload/20210222/a3c3cdf7-3f6b-497f-92af-8241c34714f8_3d3de08769ea499e908e11a41c047b48.jpg', '干锅香肠、香肠煲仔、秘蒸香肠、爆炒香肠在餐桌上一一排开，主持人频频下筷赞不绝口，热线电话络绎不绝。“新邵资味·腊之乡”香肠摇身变成新年餐桌必备，从200组的备货入库逐步提升到400组、600组、800组……来自湖南新邵县的好农货，走进了千家万户，成为了独具湘派滋味的“新年爆品”。\r\n\r\n', '2021-02-22 14:37:41', 1, 1);
INSERT INTO `news` VALUES (4, '湖南柑橘品牌占据领先位置，“四个创新”助推柑橘产业发展', '/upload/20210222/fde27ab1-1919-4dab-8f0a-ff3994061511_c5b88b528d85470c855230a2f9c15b2f.jpg', '湖南柑橘品牌创新发展峰会由湖南省扶贫开发办公室、中国社会扶贫网、湖南省农业农村厅指导，惠农网主办，腾讯微视、滴滴旗下社区电商橙心优选协办。湖南省农业农村厅市场与信息化处副处长武兰，湖南省扶贫基金会办公室主任付军明，中国社会扶贫网综合创新办公室主任张攀，惠农网创始人、CEO申斌，滴滴旗下社区电商橙心优选湖南总负责人文开茗，惠农网联合创始人邓武杰等领导嘉宾以及来自全国的柑橘渠道商代表出席。', '2021-02-22 14:21:58', 0, 0);
INSERT INTO `news` VALUES (7, '2020年柑橘区域公用品牌“年终大选”来袭！', '/upload/20210222/8d4c3572-509c-406a-85f1-9cd2f877f8a0_b0552b7964b64f2fa17acb8027447653.jpg', '由惠农网主办、微博县域协办、微博独家支持的中国好农货2020年农产品区域公用品牌评选（柑橘季）在惠农网APP正式启动，全国上百个柑桔、橙子、柚子等柑橘类区域公用品牌应声参选，来自各柑橘主产区的果农纷纷为本地柑橘“代言”，一场柑橘品牌的“年终大选”正在火热进行。', '2021-02-22 14:39:20', 2, 2);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '订单号',
  `user_id` int(11) NOT NULL DEFAULT 0,
  `product_id` int(11) NOT NULL DEFAULT 0,
  `shop_id` int(11) NOT NULL DEFAULT 0,
  `address_id` int(11) NOT NULL DEFAULT 0,
  `nums` int(11) NOT NULL DEFAULT 1 COMMENT '成交数量',
  `amount` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '成交金额',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '1未支付 2已支付 3已发货 4申请退款 5已退款',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '1950260', 1, 1, 1, 1, 5, 194.40, 1, '2021-02-22 14:54:58', NULL);
INSERT INTO `orders` VALUES (2, '1950260', 1, 1, 1, 1, 9, 50000.00, 1, '2020-11-01 22:28:59', NULL);
INSERT INTO `orders` VALUES (3, '1950260', 1, 1, 1, 1, 5, 6666.00, 1, '2020-09-01 14:54:58', NULL);
INSERT INTO `orders` VALUES (4, '1950260', 1, 1, 1, 1, 5, 8888.00, 1, '2020-07-01 14:54:58', NULL);
INSERT INTO `orders` VALUES (5, '1950260', 1, 1, 1, 1, 5, 7777.88, 1, '2020-05-01 14:54:58', NULL);
INSERT INTO `orders` VALUES (6, '1950260', 1, 1, 1, 1, 5, 9874.88, 1, '2020-03-01 14:54:58', NULL);
INSERT INTO `orders` VALUES (7, '1950260', 1, 1, 1, 1, 5, 12000.35, 2, '2020-01-01 14:54:58', NULL);
INSERT INTO `orders` VALUES (8, '8531883', 2, 1, 1, 9, 1, 38.88, 1, '2021-02-28 22:54:32', NULL);
INSERT INTO `orders` VALUES (9, '5838257', 2, 1, 1, 9, 1, 38.88, 1, '2021-02-28 22:55:31', NULL);
INSERT INTO `orders` VALUES (10, '5262374', 1, 1, 1, 1, 5, 194.40, 1, '2021-02-28 23:02:59', NULL);
INSERT INTO `orders` VALUES (11, '8185920', 1, 1, 1, 1, 5, 194.40, 1, '2021-02-28 23:04:34', NULL);
INSERT INTO `orders` VALUES (12, '5664261', 2, 1, 1, 9, 5, 194.40, 5, '2021-02-28 23:11:13', '客户已催单');
INSERT INTO `orders` VALUES (13, '9333516', 2, 1, 1, 8, 7, 272.16, 2, '2021-02-28 23:19:45', '客户已催单');
INSERT INTO `orders` VALUES (14, '8808847', 2, 1, 1, 8, 7, 272.16, 2, '2021-02-28 23:20:38', NULL);
INSERT INTO `orders` VALUES (15, '4062755', 2, 1, 1, 8, 7, 272.16, 2, '2021-02-28 23:21:43', NULL);
INSERT INTO `orders` VALUES (16, '9894646', 2, 2, 2, 9, 3, 20.64, 2, '2021-02-28 23:22:55', '客户已催单');
INSERT INTO `orders` VALUES (17, '9899939', 2, 2, 2, 9, 2, 13.76, 2, '2021-02-28 23:23:35', '客户已催单');
INSERT INTO `orders` VALUES (18, '2735879', 2, 2, 2, 9, 3, 20.64, 2, '2021-03-01 23:44:01', '客户已催单');
INSERT INTO `orders` VALUES (19, '6862146', 8, 2, 2, 11, 7, 48.16, 5, '2021-03-02 21:56:24', '客户已催单');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `price` decimal(10, 2) NOT NULL DEFAULT 0.00,
  `unit` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '斤' COMMENT '单位',
  `category_id` int(11) NOT NULL DEFAULT 0,
  `cover_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '封面',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '简介',
  `detail_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `shop_id` int(11) NOT NULL DEFAULT 0,
  `nums` int(11) NULL DEFAULT NULL COMMENT '产品库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '腊味买一送一', 38.88, '袋', 7, '/upload/20210222/4049297c-3da0-4ca1-b836-d292442fc351_u=2003500613,2598412126&fm=26&gp=0.png', '腊味买一送一', '/upload/20210222/4049297c-3da0-4ca1-b836-d292442fc351_u=2003500613,2598412126&fm=26&gp=0.png', 1, 469);
INSERT INTO `product` VALUES (2, '柑橘', 6.88, '斤', 27, '/upload/20210222/1bc94276-05a1-43c5-917b-4b09c21d4c5c_u=544274064,3506027637&fm=26&gp=0.jpg', '柑橘包甜', '/upload/20210222/1bc94276-05a1-43c5-917b-4b09c21d4c5c_u=544274064,3506027637&fm=26&gp=0.jpg', 2, 85);

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `logo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '简介',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES (1, '绿之谣', '17718819910', '/upload/20210222/b787ad74-7011-4347-994a-faa70af55c74_u=129495110,4087291678&fm=26&gp=0.jpg', '“绿”是草和树叶壮盛时的颜色，表现农产品富有生机，绿色健康。“谣”指民谣，农产品就像一首歌谣令人感受到绿色健康，既赞扬农民的辛苦，又寓意着农产品品质优良。寓意明确，简单富有韵味，也不失创意。');
INSERT INTO `shop` VALUES (2, '东篱园', '14415516610', '/upload/20210222/e0781f22-cf86-446c-a5fd-621424c9b1ff_u=930890934,2554631746&fm=26&gp=0.jpg', '取自陶渊明的“采菊东篱下”，“东篱”指种菊花的地方，表现一种静穆，淡然悠远的状态，“园”指中蔬菜、花果、树木的地方，用在此处合适贴切。既突出农产品的特点，又带给人一种纯然平和的美感，看似简单明了却很有想法。');
INSERT INTO `shop` VALUES (3, '山野人家', '12213312310', '/upload/20210222/4cd51a4e-494d-45be-92e6-bcc026403933_u=3941223255,4002032206&fm=26&gp=0.jpg', '“山野人家”是指山村僻野中居住的人家。这个名字贴近自然，让人感受到山和原野中流露的绿色清新韵味。而农产品就来自这样的地方，吃着放心，吃着健康，虽然朴实简单，但正是这种朴素中最见真章，意味连连创意满满。');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '19552855285', 'e10adc3949ba59abbe56e057f20f883e', '大佬', '');
INSERT INTO `user` VALUES (2, '123', '202cb962ac59075b964b07152d234b70', '大佬', '');
INSERT INTO `user` VALUES (3, '1234', '202cb962ac59075b964b07152d234b70', 'gg', '');
INSERT INTO `user` VALUES (4, '1235', '202cb962ac59075b964b07152d234b70', '大佬', '');
INSERT INTO `user` VALUES (5, '12345', '202cb962ac59075b964b07152d234b70', 'gg', '');
INSERT INTO `user` VALUES (6, '17612069898', 'test123456789', 'test', '');
INSERT INTO `user` VALUES (7, '19552855281', 'e10adc3949ba59abbe56e057f20f883e', '大佬', '');
INSERT INTO `user` VALUES (8, '12306', '202cb962ac59075b964b07152d234b70', '具体', '');

SET FOREIGN_KEY_CHECKS = 1;

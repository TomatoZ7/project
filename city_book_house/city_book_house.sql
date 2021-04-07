/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : 127.0.0.1:3306
 Source Schema         : city_book_house

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 24/02/2021 11:00:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cb_books
-- ----------------------------
DROP TABLE IF EXISTS `cb_books`;
CREATE TABLE `cb_books`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '书名',
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '作者',
  `first_category_id` int(11) NOT NULL DEFAULT 0 COMMENT '一级分类ID',
  `second_category_id` int(11) NOT NULL DEFAULT 0 COMMENT '二级分类ID',
  `total` int(11) NULL DEFAULT 0 COMMENT '总数',
  `stock` int(11) NOT NULL DEFAULT 0 COMMENT '库存/馆藏量',
  `book_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '编码',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '1正常 2下架',
  `place` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '位置',
  `introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '简介',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图片',
  `create_time` timestamp(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `first_category_id`(`first_category_id`) USING BTREE,
  INDEX `second_category_id`(`second_category_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cb_books
-- ----------------------------
INSERT INTO `cb_books` VALUES (1, '墙上的集体记忆', '吴志菲', 357, 359, 10, 8, '9787512620353', 1, '1F A101', '一条标语，一段历史。在故乡一处显眼地方的同一堵墙壁上，就曾被写了又刷、刷了又写，年复一年，不知曾被写了多少条标语，其中每条标语对应的是一项历史，五味杂陈。让我们通过本书一起开始阅读标语，回到当年的历史现场，再从历史中感知今天、启迪未来吧！', '/upload/20210202/5bd26f10-4b4a-472e-879d-02da10dd2357_s6456960.jpg', '2021-02-02 17:03:35');
INSERT INTO `cb_books` VALUES (2, '谁统治世界?', '[美]诺姆·乔姆斯基 著，钱镇/秘春茜 译', 357, 359, 20, 18, '9787569925203', 1, '', '自二战以来，美国就成为我们所在星球的老大，在很大程度上确定了全球性议题的条款。然而，美国的力量正在衰减，那么，未来的世界又如何变化呢？\r\n《谁统治世界？》以知识分子的视角对二战以来的国际形势进行了回顾与分析，指出自二战以来，虽然欧洲和亚洲在崛起，但美国仍旧设定着全球议程，从干涉古巴到近来干涉中国的发展，从酷刑纪录到对伊朗的制裁，详尽解说了美国的自由和人权的漂亮言辞经常与其实际行动相脱节。\r\n全书旁征博引，出色地分析了美国精英的行为如何越来越不受任何民主的限制，推行军事优先政策，深入分析了发生在伊拉克、阿富汗和巴勒斯坦与以色列的冲突，解读了美国是如何在这个日益混乱的星球上行使权力的，见解既出人意料、又鞭辟入里。', '/upload/20210202/f26fb5ba-c898-4b48-a6f0-6be56597273c_B8016523.jpg', '2021-02-02 17:11:32');
INSERT INTO `cb_books` VALUES (3, '五代状元奇谈·五代状元谱', '周腊生', 357, 359, 10, 9, '9787800474330', 1, '', '这套书每书皆分上下两编。上编为状元的趣事轶闻，大体上都是对状元们的求学生涯、夺魁情状、宦海浮沉、秉性风范、奇遇怪癖、成败得失等诸多方面所作的生动描绘，同时还涉及当时社会生活的方方面面，构成了一幅幅封建时代不同时期的社会生活风情图，读来颇感有厚度，亦颇有兴趣。其描述不索隐行怪，不宣扬文人无行的东西，虽日“奇谈”，实很健康，品味甚高，潜移默化，寓教于乐，很有意义。\r\n下编为状元名录小传，既可了解每个状元的生平事迹，又可统观各代状元全貌，可以作工具书用，查阅起来十分方便，有极高的使用价值。', '/upload/20210202/5f2039e8-aec1-432a-afd7-832cc782167c_s803899.jpg', '2021-02-02 17:15:20');
INSERT INTO `cb_books` VALUES (4, '冷战的静谧边界', '[美]尤利娅·科姆斯卡 著，宋世锋 译', 357, 358, 5, 4, '9787547418017', 1, '', '尤利娅·科姆斯卡带领读者去往波西米亚森林的西缘，这是欧洲*古老的分界线之一，20世纪50年代，民众开始在这里构建所谓的祈祷墙。祈祷墙是一系列新建的、目的明确的朝圣地点、瞭望塔和纪念碑，将长久以来即属于德国的森林和边界置于20世纪*旷日持久的冲突之中。科姆斯卡说明了民众是如何通过祈祷墙投身于新的政治和宗教版图的构建之中，并有所成就的。在这一过程中，她将西德静谧的森林边缘与铁幕沿线弥漫的悲剧氛围联系在了一起。', '/upload/20210202/d11a3c80-4222-4559-9627-e466c0c96933_s7825158.jpg', '2021-02-02 17:18:33');
INSERT INTO `cb_books` VALUES (5, '中国古代火药火器史', '刘旭', 357, 358, 10, 8, '9787534730283', 1, '', '火药是中国古代的四大发明之一，把火药制成兵器用于军事，中国也走在世界各国前面。中国火药火器技术的西传，影响和推动了其他国家军事科技的发展。但明清以后，中国火药火器技术的研制和发展却陷入停滞，反而大大落后于欧美各国。\r\n本书作者在广泛查证史料、吸取国内外大量研究成果的基础上，以中国古代火药火器技术的发展为线索，探讨了各类火药、火器的产生时间、研制工艺、使用状况、理论著述，以及火药火器技术的西传东渐和兴盛衰落等重大问题，对有争论的学术论题提出了自己的观点，弥补了在我国相对薄弱的古代科学技术史、尤其是火药火器史研究上的不足。', '/upload/20210202/6b59df3d-6f61-4638-b464-a6da0499beee_s1589719.jpg', '2021-02-02 17:20:35');
INSERT INTO `cb_books` VALUES (6, '1927-1945-海因里希.希姆莱与妻书信集', '[德]米卡尔·维尔特/卡特琳·希姆莱 著，陈伟 译', 357, 358, 10, 10, '9787532151585', 1, '', '2015年是是世界反法西斯战争胜利70年，也是中国人民抗日战争胜利70周年，《海因里希·希姆莱与妻书信集（1927—1945年）》是恰逢此时出版的一本具有重要意义的二战题材读物。　　海因里希·希姆莱外表斯文，内心极度变态，狂躁、凶残、邪恶、偏执，是德国二战纳粹阵营中仅次于希特勒的二号人物，在整个二战中起着举足轻重的作用。《海因里希·希姆莱与妻书信集（1927—1945年）》第1次将希姆莱人生中重要的19年间与妻子的玛佳的来往书信公诸于世，同时根据来往书信时间顺序，穿插着史料，严谨叙述了同时期德国法西斯阵营所处的政治社会环境和整个二战期间纳粹德军的发展演变过程。《海因里希·希姆莱与妻书信集（1927-1945）》由两部分构成，海因里希·希姆莱与妻书信往来，及史料叙述纳粹在欧洲犯下的滔天罪行。　　《海因里希·希姆莱与妻书信集（1927-1945）》有着非常多首次公布的史料，具有极高的学术价值。　　2014年一出版就在整个欧洲评论界引起极大反响，被认为是具有特别重要的历史价值。', '/upload/20210202/e9dcc6d1-10b9-4665-a802-097da775ffba_s6888165.jpg', '2021-02-02 17:21:56');
INSERT INTO `cb_books` VALUES (7, '三国时期军事情报问题研究', '丰建泉', 357, 358, 16, 11, '9787564903756', 1, '', '《三国时期军事情报问题研究》以三国时期的斗争历史为背景，以军事情报问题为主线，从情报人物和情报战例两方面入手研究三国情报史，抓住了这一历史时期军事情报问题的精髓和要旨——即战略情报分析与研究。', '/upload/20210202/018f46dd-fdec-445a-9c96-cca59aaf7769_s5181575.jpg', '2021-02-02 17:23:31');
INSERT INTO `cb_books` VALUES (8, '海上大征服', '白海军', 357, 358, 10, 10, '9787801868961', 1, '', '海权论之父阿尔弗雷德·塞耶。马汉的思想主旨是：任何大国，无论是维护国家利益还是称霸世界，首先必须要有一支强大的海上力量，只有拥有了制海权，才能实现国家战略。\r\n实际上，早在马汉的海权论确立之前，人类就已经在海上进行了数千年的争霸与征服，从古埃及到雅典，从罗马到美国，海上的争霸战与征服战从来没有停止过。\r\n一个事实是，在希波战争中，如果雅典没能赢得萨拉米海战，那么欧洲文明必将改写；\r\n第二个事实是，两次世界大战说明，英美如果未能控制海洋就无法打败德国；\r\n第三个事实是，每当世界发生危机，美国总统总是要问，“我们的航母在哪儿?”', '/upload/20210202/1c4df927-b38a-425f-98d6-004679c426cc_s3193687.jpg', '2021-02-02 17:24:45');
INSERT INTO `cb_books` VALUES (9, '希特勒.永不消散的阴云?-德国历史学家之争', '哈贝马斯', 357, 358, 10, 9, '9787108036889', 1, '', '1980年代，在当时的联邦德国发生了一场著名的争论，后来被称为“德国历史学家之争”。争论围绕纳粹罪行的独特性、如何评价第三帝国在德国历史中的地位和作用、如何评价和书写历史等问题展开。参加争论的有著名哲学家哈贝马斯和德国一大批著名的历史学家，如恩斯特诺尔特等人。争论并不局限于学术圈和思想界，而是在德国的报纸、期刊等公共媒体上展开，因而在公众中产生了广泛的影响，并且在西方世界引起重视。参与论战的各方，虽然也有言辞激烈之处，但总体上而言，较好地遵守了学术讨论或者思想论争的基本规则，力争以逻辑力量阐明自己的观点，取得上风。 　　虽然这场争论没有明确的*终结论，但提出的问题是整个德国社会二战以后虽未明言却普遍关心的，参与争论的学者从历史和现实的多个角度进入，没有使用过多的学术语言，公众理解起来没有障碍，各方的观点也得到了充分的展开，各自的逻辑非常清晰，因此，对整个社会开放数十年以来的思想禁区，加深关于德意志第三帝国历史的思考，确认德国在历史和世界中的位置，有很大的推进作用。了解这场争论，中国的读者解读东亚的历史和自己的当代史，都很有借鉴作用。', '/upload/20210202/20e418d2-a267-48c4-a674-05152be16cee_s6687892.jpg', '2021-02-02 17:26:06');
INSERT INTO `cb_books` VALUES (10, '庄子选译', '王寅生', 354, 355, 50, 50, '9787500068648', 1, '', '《逍遥游》是《庄子·内篇》的首篇，是庄子的代表作，比较集中地反映了庄子追求绝对自由的人生观。《逍遥游》书全书分两大部分。**部分是总论，论证世间万物都是“有所待”而不自由的，自己追求的是“无所待”*高境界。第二部分通过一系列寓言故事，论证**部分提出的“至人无己”“神人无功”“圣人无名”的境界，以及通过“无为”达到这一境界的主张。全篇集中表现了庄子哲学思想的一个重要方面，即绝对自由。', '/upload/20210202/b6a59b81-785a-4a79-b669-db7c47ec871a_s1104563.jpg', '2021-02-02 17:28:08');
INSERT INTO `cb_books` VALUES (11, '周易古礼研究', '兰甲云', 354, 355, 10, 10, '9787811133608', 1, '', '部对《周易》经传及易学史上有关古礼问题进行专门探讨的专著。考察了易学史上以礼释易的学术源流，研究了相关的以礼释易著作，对《周易》经传中蕴含的商周古礼进行了挖掘、分析和考证，阐述了《周易》所反映的当时社会的礼制情况，解决了许多卦爻辞阐释中存在的疑难问题。', '/upload/20210202/6ea46f04-b513-4522-9bf7-f2ecb42c386f_s3098604.jpg', '2021-02-02 17:29:31');
INSERT INTO `cb_books` VALUES (12, '亚瑟·叔本华的经典传世之作:人生的智慧(全译本)', '［德］亚瑟·叔本华 著，余荃 ', 354, 355, 10, 10, '9787513926690', 1, '', '本书中“人生的智慧”完全是意识领域里的概念：所谓“人生的智慧”，指的是能够让我们幸福愉快地度过一生的一门艺术。在哲学上也可称之为“幸福论”。本书为人们如何才能拥有“幸福的存在”提供了指导和启发。', '/upload/20210202/50368145-0cc9-4247-aeac-afb8c2cd1f92_s8274374.jpg', '2021-02-02 17:31:17');
INSERT INTO `cb_books` VALUES (13, '我的第一本逻辑思考入门', '[日]西村克己 著，赵海涛 译', 354, 355, 11, 11, '9787218133515', 1, '', '本书首先简单介绍了逻辑思考的意义，让读者有一个初步的了解;接着以渐进的方式，详述如何学习逻辑思考及其重要性;*后介绍了如何在职场和生活中，实践逻辑性的思考模式。\r\n从全书来看，逻辑思考的关键点，简单来说，其实就是“有条理地思考”。一旦掌握逻辑思考的窍门，对于他人而言，就会起到“更能准确地表达自己的想法”“话语更有说服力”的效果;同时对自己而言，也能起到“快速做出决定”“ 提高解决问题能力”“提升工作精度 ”等多方面的效果，从而领悟逻辑思考的本质，并能实际应用。', '/upload/20210202/749773d4-5879-4d52-b81d-e0e18a421772_s8041875.jpg', '2021-02-02 17:32:29');
INSERT INTO `cb_books` VALUES (14, '生活中的理财智慧', '黄珺/朱国玮 著', 320, 321, 10, 10, '9787811133721', 1, '', '', '/upload/20210202/488f1a39-41ed-49c6-a6df-0d74bbba5ab5_s3055693.jpg', '2021-02-02 17:34:46');
INSERT INTO `cb_books` VALUES (15, '世界上最伟大的推销员', '(美)奥格·曼狄诺著', 320, 321, 10, 10, '9787513916325', 1, '', '本书主要内容包括: 推销是一项伟大的工作、心态是成功推销的**步、给客户留下良好的**形象、掌握推销的语言技巧、真正的推销从拒绝开始等。', '/upload/20210202/7591610a-807d-4f64-a64b-ab8ffce202f1_s7561194.jpg', '2021-02-02 17:35:53');
INSERT INTO `cb_books` VALUES (16, '远离迷茫,从学会赚钱开始', '曾鹏宇', 320, 321, 12, 12, '9787505745513', 1, '', '★新浪微博百万付费阅读作家 曾鹏宇 给年轻人的不迷茫实用建议；\r\n★这不仅是一本理财书，更是照射现代年轻人生存现状的金钱万花筒；\r\n★为什么要理财？为什么你理财了却没有赚到钱？如何从低薪走向自由？这本书曾鹏宇会告诉你比起盲目地进行财富积累，转变对金钱的格局观，有技巧的理财更重要；\r\n★主持人朱丹、演员严屹宽倾情推荐。', '/upload/20210202/2cee63e5-460d-4622-9c1f-920c0a1d622e_s8044213.jpg', '2021-02-02 17:36:59');
INSERT INTO `cb_books` VALUES (17, '好看的外表千篇一律,有趣的灵魂万里挑一\r\n', '魏素宣 著', 320, 322, 10, 10, '9787518063512', 1, '', '一辈子很短，灿如烟火，而我们都想做“不一样的烟火”，都想让有限的人生充实而有意义，*的途径就是成为一个有着丰富且有趣灵魂之人。\r\n一辈子的才情，并且引导我们如何塑造有趣的灵魂，相信在阅读本书后，你会有所启发，也能发现自我，快乐一生。', '/upload/20210202/4eadfdef-c1c2-483a-80bf-f9649506cd9f_s8187392.jpg', '2021-02-02 17:39:01');
INSERT INTO `cb_books` VALUES (18, '温暖的荆棘:中英双语版', '毕淑敏[著]', 320, 322, 10, 10, '9787545530636', 1, '', '1、百万畅销书作家、心灵导师毕淑敏联手翻译大家朱虹，为年轻人奉上一次触动心灵的成长之旅！ 2、人生路上不会总铺满鲜花，偶尔也会荆棘密布。20则温暖心灵的故事 20剂治愈心灵的处方，献给所有在不安中眺望未来的年轻人。 3、故事里有你，也有我，作者以细腻而不失力度的笔触，讲述人生的孤独与困惑，迷惘与思考、痛楚与撕裂、沉沦与挣扎、无边的阴郁与微弱的光明……让年轻读者将心理垃圾转化为积极的能量，温暖心底冰冷的地方。愿你能在阅读中受到启迪和鼓舞，心中多一分安定和从容，勇敢面对困难，原谅生活所有的刁难。 4、全书四色精美装帧，内含专属定制主题插图，带来非凡的阅读享受。读真实故事，品纯正英语，解成长谜题。', '/upload/20210202/8474f55c-ee0d-4f04-acf9-4ae96b59ad80_s7671312.jpg', '2021-02-02 17:40:10');
INSERT INTO `cb_books` VALUES (19, '网络困境与商务新规则', '[美]劳利·温厄姆[LaurieWindham', 290, 294, 22, 22, '9787508023168', 1, '', '本书阐述了网络商务的六个新规则，并详细论述了各种*佳战略与方法，其中包括：如何了解并满足顾客的电子商务要求、如何解决与现有商务战略的冲突、如何投资于适当技术、如何实现网络战略和网络运作的国际化等。', '/upload/20210202/df991fa8-074b-4e45-bd08-8f4eee5827f1_2031366.jpg', '2021-02-02 17:42:27');
INSERT INTO `cb_books` VALUES (20, '唐诗现场', '章雪峰 著', 103, 106, 10, 9, '9787532955879', 1, '', '★一场发自唐朝的现场报道。每首唐诗都是一个案发现场，本书带你穿越回唐朝，亲历每个重大历史事件的关键节点\r\n★一部别样的欢乐唐史。发掘那些不为人知却又新奇有趣的历史细节，嬉笑怒骂间读懂历史沉浮、人生百味\r\n★一本严肃靠谱的历史著作。秉承“诗史互证”的史学研究方法，以诗证史，以史解诗。史料是严肃权威的，考据是严谨扎实的\r\n★搜狐、今日头条、简书、微信等自媒体百万读者共同推荐；《出版人》杂志、《中外书摘》杂志、中国新闻出版报、中国图书商报、中华读书报、长江日报、湖北日报、湖北经视等地面媒体大力推荐', '/upload/20210202/a0800b04-fe9d-4af8-8b9c-43740938201c_s7651264.jpg', '2021-02-02 17:44:07');

-- ----------------------------
-- Table structure for cb_borrow_car
-- ----------------------------
DROP TABLE IF EXISTS `cb_borrow_car`;
CREATE TABLE `cb_borrow_car`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `book_id` int(11) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of cb_borrow_car
-- ----------------------------
INSERT INTO `cb_borrow_car` VALUES (19, 4, 5, '2021-02-19 06:33:58');
INSERT INTO `cb_borrow_car` VALUES (18, 3, 20, '2021-02-15 20:40:23');
INSERT INTO `cb_borrow_car` VALUES (17, 3, 5, '2021-02-15 17:40:44');
INSERT INTO `cb_borrow_car` VALUES (14, 1, 4, NULL);
INSERT INTO `cb_borrow_car` VALUES (13, 1, 3, NULL);
INSERT INTO `cb_borrow_car` VALUES (8, 3, 2, '2021-02-15 01:58:53');
INSERT INTO `cb_borrow_car` VALUES (15, 3, 3, '2021-02-15 17:40:29');
INSERT INTO `cb_borrow_car` VALUES (16, 3, 4, '2021-02-15 17:40:36');
INSERT INTO `cb_borrow_car` VALUES (20, 4, 9, '2021-02-19 06:34:27');
INSERT INTO `cb_borrow_car` VALUES (22, 3, 2, '2021-02-20 03:36:46');

-- ----------------------------
-- Table structure for cb_borrow_record
-- ----------------------------
DROP TABLE IF EXISTS `cb_borrow_record`;
CREATE TABLE `cb_borrow_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NULL DEFAULT NULL,
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '1借阅 2续借 3超时 4归还',
  `start_time` timestamp(0) NULL DEFAULT NULL COMMENT '起借时间',
  `end_time` timestamp(0) NULL DEFAULT NULL COMMENT '截止时间',
  `return_time` timestamp(0) NULL DEFAULT NULL COMMENT '归还时间',
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '借阅记录表' ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of cb_borrow_record
-- ----------------------------
INSERT INTO `cb_borrow_record` VALUES (1, 1, 1, 4, '2021-01-07 17:13:22', '2021-02-07 17:13:24', '2021-01-20 18:44:17', '2021-01-07 17:13:27');
INSERT INTO `cb_borrow_record` VALUES (2, 2, 2, 2, '2021-01-07 17:13:32', '2021-01-07 17:13:35', NULL, '2021-01-07 17:13:39');
INSERT INTO `cb_borrow_record` VALUES (3, 1, 3, 2, '2021-01-14 10:52:00', '2021-02-14 10:52:02', NULL, '2021-01-14 10:52:04');
INSERT INTO `cb_borrow_record` VALUES (4, 1, 3, 4, '2021-01-14 10:52:00', '2021-01-14 10:52:02', '2021-01-26 17:37:39', '2021-01-14 10:52:04');
INSERT INTO `cb_borrow_record` VALUES (5, 1, 4, 4, '2021-01-14 10:52:16', '2021-01-14 10:52:18', '2021-01-26 17:37:39', '2021-01-14 10:52:20');
INSERT INTO `cb_borrow_record` VALUES (6, 1, 7, 4, '2021-01-18 13:39:58', '2021-02-18 13:39:58', '2021-01-26 17:37:39', '2021-01-18 13:39:58');
INSERT INTO `cb_borrow_record` VALUES (7, 1, 4, 4, '2021-01-22 14:26:35', '2021-02-22 14:26:35', '2021-01-22 14:56:11', '2021-01-22 14:26:35');
INSERT INTO `cb_borrow_record` VALUES (8, 1, 5, 4, '2021-01-22 14:26:35', '2021-02-22 14:26:35', '2021-01-22 14:56:11', '2021-01-22 14:26:35');
INSERT INTO `cb_borrow_record` VALUES (9, 1, 6, 4, '2021-01-22 14:26:35', '2021-02-22 14:26:35', '2021-01-22 14:56:11', '2021-01-22 14:26:35');
INSERT INTO `cb_borrow_record` VALUES (10, 1, 2, 1, '2021-01-22 16:02:10', '2021-02-22 16:02:10', NULL, '2021-01-22 16:02:10');
INSERT INTO `cb_borrow_record` VALUES (11, 1, 1, 1, '2021-02-24 00:26:52', '2021-03-24 00:26:52', NULL, '2021-02-24 00:26:52');
INSERT INTO `cb_borrow_record` VALUES (12, 1, 1, 1, '2021-02-24 00:29:37', '2021-03-24 00:29:37', NULL, '2021-02-24 00:29:37');

-- ----------------------------
-- Table structure for cb_browse
-- ----------------------------
DROP TABLE IF EXISTS `cb_browse`;
CREATE TABLE `cb_browse`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `book_id` int(11) NULL DEFAULT NULL,
  `time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of cb_browse
-- ----------------------------
INSERT INTO `cb_browse` VALUES (1, 1, 1, '2021-01-21 15:49:59');
INSERT INTO `cb_browse` VALUES (2, 1, 2, '2021-01-21 15:50:04');
INSERT INTO `cb_browse` VALUES (8, 0, 1, '2021-01-27 12:24:08');
INSERT INTO `cb_browse` VALUES (7, 2, 1, '2021-01-21 16:39:13');
INSERT INTO `cb_browse` VALUES (9, 2, 10, '2021-02-11 02:12:21');
INSERT INTO `cb_browse` VALUES (10, 2, 4, '2021-02-11 02:19:39');
INSERT INTO `cb_browse` VALUES (11, 2, 2, '2021-02-11 02:25:34');
INSERT INTO `cb_browse` VALUES (12, 2, 3, '2021-02-11 02:25:49');
INSERT INTO `cb_browse` VALUES (13, 2, 20, '2021-02-11 03:13:04');
INSERT INTO `cb_browse` VALUES (14, 2, 9, '2021-02-11 03:40:10');
INSERT INTO `cb_browse` VALUES (15, 2, 5, '2021-02-14 17:00:43');
INSERT INTO `cb_browse` VALUES (16, 2, 6, '2021-02-14 17:07:56');
INSERT INTO `cb_browse` VALUES (17, 3, 2, '2021-02-14 18:43:15');
INSERT INTO `cb_browse` VALUES (18, 3, 1, '2021-02-14 18:44:54');
INSERT INTO `cb_browse` VALUES (19, 3, 4, '2021-02-14 18:45:06');
INSERT INTO `cb_browse` VALUES (20, 3, 6, '2021-02-14 18:49:17');
INSERT INTO `cb_browse` VALUES (21, 3, 7, '2021-02-14 18:49:33');
INSERT INTO `cb_browse` VALUES (22, 3, 20, '2021-02-14 21:03:47');
INSERT INTO `cb_browse` VALUES (23, 0, 2, '2021-02-15 01:11:40');
INSERT INTO `cb_browse` VALUES (24, 3, 8, '2021-02-15 02:17:04');
INSERT INTO `cb_browse` VALUES (25, 3, 3, '2021-02-15 17:40:28');
INSERT INTO `cb_browse` VALUES (26, 3, 5, '2021-02-15 17:40:42');
INSERT INTO `cb_browse` VALUES (27, 1, 20, '2021-02-19 02:04:55');
INSERT INTO `cb_browse` VALUES (28, 0, 5, '2021-02-19 06:32:50');
INSERT INTO `cb_browse` VALUES (29, 4, 9, '2021-02-19 06:34:19');
INSERT INTO `cb_browse` VALUES (30, 4, 3, '2021-02-19 06:36:06');
INSERT INTO `cb_browse` VALUES (31, 1, 4, '2021-02-20 03:34:13');

-- ----------------------------
-- Table structure for cb_category
-- ----------------------------
DROP TABLE IF EXISTS `cb_category`;
CREATE TABLE `cb_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `pid` int(11) NOT NULL DEFAULT 0 COMMENT '0为一级分类',
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 375 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cb_category
-- ----------------------------
INSERT INTO `cb_category` VALUES (1, '文学', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (2, '纪实文学', 1, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (3, '民间文学', 1, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (4, '外国诗歌', 1, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (5, '外国随笔', 1, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (6, '文集', 1, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (7, '文学理论', 1, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (8, '戏剧', 1, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (9, '中国古代随笔', 1, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (10, '中国古诗词', 1, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (11, '中国现当代歌', 1, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (12, '中国现当代随笔', 1, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (13, '小说', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (14, '中国当代小说', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (15, '中国古典小说', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (16, '中国近现代小说', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (17, '外国小说', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (18, '财经', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (19, '都市', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (20, '港澳台小说', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (21, '官场', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (22, '惊悚/恐怖', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (23, '军事', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (24, '科幻', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (25, '历史', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (26, '魔幻', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (27, '情感', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (28, '社会', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (29, '武侠', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (30, '乡土', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (31, '影视小说', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (32, '侦探/悬疑/推理', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (33, '职场', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (34, '作品集', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (35, '四大名著', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (36, '世界名著', 13, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (37, '青春文学', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (38, '爱情/情感', 37, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (39, '爆笑/无厘头', 37, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (40, '叛逆/成长', 37, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (41, '校园', 37, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (42, '玄幻/新武侠/魔幻/科幻', 37, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (43, '悬疑/惊悚', 37, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (44, '娱乐/偶像', 37, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (45, '大陆原创', 37, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (46, '港台青春文学', 37, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (47, '韩国青春文学', 37, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (48, '其他国外青春文学', 37, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (49, '少儿', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (50, '0-2岁', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (51, '7岁及以上', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (52, '3-6岁', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (53, '动漫/卡通', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (54, '儿童文学', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (55, '中国儿童文学', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (56, '外国儿童文学', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (57, '科普/百科', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (58, '励志/成长', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (59, '少儿英语', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (60, '绘本', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (61, '艺术课堂', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (62, '益智游戏', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (63, '幼儿启蒙', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (64, '传统文化', 49, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (65, '科普读物', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (66, '地震', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (67, '动物', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (68, '海洋生物', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (69, '昆虫', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (70, '鸟类', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (71, '植物', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (72, '河流', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (73, '海洋', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (74, '环境保护与治理', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (75, '历史', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (76, '气象', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (77, '人类', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (78, '生态', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (79, '星体观测', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (80, '自然灾害', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (81, '其他科普知识', 65, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (83, '动漫/幽默', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (84, '大陆漫画', 83, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (85, '动漫学堂', 83, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (86, '港台漫画', 83, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (87, '日韩漫画', 83, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (88, '欧美漫画', 83, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (89, '其他国外漫画', 83, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (90, '世界经典漫画集', 83, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (91, '小说/名著漫画版', 83, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (92, '幽默/笑话集', 83, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (93, '社会科学', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (94, '教育', 93, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (95, '社会科学类教材', 93, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (96, '社会科学总论', 93, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (97, '社会学', 93, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (98, '图书馆学档案学', 93, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (99, '文化人类学', 93, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (100, '心理学', 93, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (101, '新闻传播出版', 93, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (102, '语言文字', 93, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (103, '历史', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (104, '地方史志', 103, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (105, '考古文物', 103, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (106, '历史知识读物', 103, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (107, '民族史志', 103, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (108, '史料典籍', 103, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (109, '史学理论', 103, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (110, '中国史', 103, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (111, '世界史', 103, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (112, '传记', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (113, '财经人物', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (114, '军事人物', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (115, '科学家', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (116, '历代帝王', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (117, '历史人物', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (118, '社会各界人物', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (119, '人文/社会学家', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (120, '文学家', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (121, '学者', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (122, '艺术家', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (123, '影视明星', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (124, '体育明星', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (125, '政治人物', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (126, '领袖首脑', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (127, '自传', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (128, '宗教人物', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (129, '女性人物', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (130, '综合', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (131, '其他', 112, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (132, '文化', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (133, '地域文化', 132, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (134, '神秘现象', 132, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (135, '世界文化', 132, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (136, '文化理论', 132, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (137, '文化评述', 132, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (138, '中国民俗', 132, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (139, '中国文化', 132, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (140, '艺术', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (141, '艺术理论', 140, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (142, '绘画', 140, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (143, '书法篆刻', 140, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (144, '雕塑', 140, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (145, '工艺美术', 140, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (146, '建筑艺术', 140, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (147, '民间艺术', 140, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (148, '人体艺术', 140, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (149, '设计', 140, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (150, '摄影', 140, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (151, '音乐', 140, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (152, '影视艺术', 140, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (153, '舞台艺术戏曲', 140, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (154, '艺术类考试', 140, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (155, '收藏/鉴赏', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (156, '宝石', 155, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (157, '雕品', 155, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (158, '古代家具', 155, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (159, '其他', 155, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (160, '钱币', 155, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (161, '收藏百科', 155, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (162, '收藏随笔', 155, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (163, '书画', 155, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (164, '陶瓷', 155, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (165, '邮票', 155, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (166, '玉器', 155, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (167, '紫砂壶', 155, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (168, '古籍', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (169, '古籍整理', 168, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (170, '集部', 168, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (171, '经部', 168, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (172, '史类', 168, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (173, '子部', 168, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (174, '地图/地理', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (175, '大洋洲', 174, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (176, '地理', 174, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (177, '非洲', 174, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (178, '国家（地区）概况', 174, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (179, '美洲', 174, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (180, '欧洲', 174, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (181, '其他地图', 174, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (182, '世界地图', 174, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (183, '亚洲', 174, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (184, '中国地图', 174, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (185, '专题地图', 174, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (186, '家庭教育', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (187, '成功案例', 186, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (188, '家教方法', 186, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (189, '青春期教育', 186, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (190, '素质教育', 186, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (191, '心理辅导', 186, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (192, '报考/留学', 186, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (193, '旅游', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (194, '城市自助旅游指南', 193, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (195, '国内自助旅游指南', 193, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (196, '国外自助旅游指南', 193, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (197, '旅游地图/自驾游', 193, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (198, '户外探险', 193, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (199, '旅游地图/地理', 193, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (200, '旅游理论与实务', 193, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (201, '旅游摄影/画册', 193, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (202, '旅游随笔', 193, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (203, '旅游攻略', 193, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (204, '导游专业用书', 193, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (205, '美丽装扮', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (206, '服装搭配', 205, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (207, '化妆', 205, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (208, '减肥/瘦身', 205, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (209, '精油/香水', 205, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (210, '美发/美甲', 205, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (211, '美丽秘籍', 205, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (212, '美容/护肤', 205, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (213, '美容师用书', 205, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (214, '美容瘦身饮食', 205, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (215, '美体/塑形', 205, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (216, '魅力女人', 205, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (217, '饰品/配饰', 205, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (218, '瑜伽普拉提', 205, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (219, '造型设计', 205, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (220, '美食', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (221, '八大菜系', 220, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (222, '保健食谱营养', 220, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (223, '餐饮指南', 220, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (224, '家常食谱', 220, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (225, '世界美食', 220, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (226, '酒饮品', 220, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (227, '茶', 220, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (228, '烹饪理论/厨师手册', 220, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (229, '甜品家庭小制作', 220, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (230, '饮食文化', 220, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (231, '两性关系', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (232, '婚姻', 231, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (233, '恋爱', 231, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (234, '两性之间', 231, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (235, '性', 231, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (236, '孕产妇/育儿', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (237, '儿童疾病防治', 236, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (238, '儿童营养饮食', 236, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (239, '起名儿', 236, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (240, '准备怀孕', 236, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (241, '孕期', 236, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (242, '孕产妇健康', 236, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (243, '孕产百科', 236, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (244, '胎教/优生', 236, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (245, '婴幼儿护理', 236, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (246, '育儿百科', 236, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (247, '早教指南', 236, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (248, '家居/休闲游戏', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (249, '爱车一族', 248, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (250, '安全常识', 248, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (251, '宠物', 248, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (252, '法律自助', 248, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (253, '风水', 248, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (254, '家庭园艺', 248, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (255, '品质生活', 248, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (256, '绒线编织', 248, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (257, '生活窍门', 248, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (258, '手工DIY', 248, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (259, '消费指南', 248, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (260, '游戏', 248, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (261, '占星测试', 248, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (262, '装修装潢', 248, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (263, '工具书', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (264, '汉语工具书', 263, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (265, '英语工具书', 263, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (266, '其他语种工具书', 263, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (267, '百科全书/年鉴', 263, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (268, '文学鉴赏辞典', 263, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (269, '牛津系列', 263, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (270, '朗文系列', 263, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (271, '经济', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (272, '保险', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (273, '财税外贸保险类考试', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (274, '财政税收', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (275, '各部门经济', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (276, '各流派经济学说', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (277, '工具书', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (278, '经济法', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (279, '经济理论', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (280, '经济史', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (281, '经济数学', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (282, '经济学理论', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (283, '贸易政策', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (284, '区域经济', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (285, '通货膨胀', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (286, '统计审计', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (287, '中国经济', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (288, '国际经济', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (289, '经济通俗读物', 271, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (290, '管理', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (291, 'MBA', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (292, 'WTO', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (293, '创业企业与企业家', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (294, '电子商务', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (295, '工具书', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (296, '管理类职称考试', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (297, '管理信息系统', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (298, '会计', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (299, '金融/投资', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (300, '商务沟通', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (301, '商业史传', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (302, '生产与运作管理', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (303, '市场/营销', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (304, '外文原版/影印版', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (305, '一般管理学', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (306, '战略管理', 290, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (307, '个人理财', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (308, '保险', 307, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (309, '彩票', 307, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (310, '购房置业', 307, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (311, '黄金投资', 307, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (312, '基金', 307, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (313, '纳税', 307, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (314, '女性理财', 307, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (315, '期货', 307, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (316, '投资指南', 307, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (317, '外汇', 307, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (318, '证券/股票', 307, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (319, '综合理财', 307, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (320, '成功/励志', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (321, '财商/财富智慧', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (322, '成功/激励', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (323, '出国/留学', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (324, '处世学', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (325, '口才/演讲/辩论', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (326, '礼仪', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (327, '励志经典著作', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (328, '励志小品', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (329, '名人励志', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (330, '名言/格言', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (331, '男性励志', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (332, '女性励志', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (333, '青少年励志', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (334, '情商/情绪管理', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (335, '人际交往', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (336, '人生哲学', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (337, '人在职场', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (338, '心灵与修养', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (339, '性格与习惯', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (340, '智商/智谋', 320, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (341, '保健/心理健康', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (342, '保健/心理健康类考试', 341, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (343, '常见病', 341, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (344, '健康百科', 341, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (345, '健身', 341, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (346, '男性', 341, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (347, '女性', 341, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (348, '心理健康', 341, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (349, '性保健', 341, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (350, '饮食营养食疗', 341, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (351, '孕产妇', 341, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (352, '中老年', 341, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (353, '中医保健', 341, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (354, '哲学/宗教', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (355, '哲学', 354, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (356, '宗教', 354, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (357, '政治军事', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (358, '军事', 357, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (359, '政治', 357, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (360, '自然科学', 0, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (361, '地球科学', 360, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (362, '化学', 360, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (363, '科技史', 360, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (364, '力学', 360, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (365, '生物科学', 360, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (366, '数学', 360, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (367, '天文学', 360, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (368, '物理学', 360, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (369, '自然科学类考试', 360, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (370, '总论', 360, '2021-02-02 15:58:45');
INSERT INTO `cb_category` VALUES (371, 'test', 0, '2021-02-08 16:52:06');
INSERT INTO `cb_category` VALUES (372, 'hello world', 371, '2021-02-08 16:52:06');
INSERT INTO `cb_category` VALUES (373, 'test', 0, '2021-02-08 16:59:19');
INSERT INTO `cb_category` VALUES (374, 'hello world', 373, '2021-02-08 16:59:19');

-- ----------------------------
-- Table structure for cb_collect
-- ----------------------------
DROP TABLE IF EXISTS `cb_collect`;
CREATE TABLE `cb_collect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of cb_collect
-- ----------------------------
INSERT INTO `cb_collect` VALUES (1, 1, 1, '2021-01-14 17:32:49');
INSERT INTO `cb_collect` VALUES (2, 2, 1, '2021-01-14 17:32:49');
INSERT INTO `cb_collect` VALUES (3, 3, 1, '2021-01-14 17:32:49');
INSERT INTO `cb_collect` VALUES (4, 4, 1, '2021-01-14 17:32:49');
INSERT INTO `cb_collect` VALUES (5, 1, 2, '2021-01-14 17:32:49');
INSERT INTO `cb_collect` VALUES (6, 2, 2, '2021-01-14 17:32:49');
INSERT INTO `cb_collect` VALUES (10, 3, 4, '2021-02-14 18:45:11');
INSERT INTO `cb_collect` VALUES (11, 3, 6, '2021-02-14 18:49:25');
INSERT INTO `cb_collect` VALUES (12, 3, 7, '2021-02-14 18:49:40');
INSERT INTO `cb_collect` VALUES (13, 3, 3, '2021-02-15 01:13:07');
INSERT INTO `cb_collect` VALUES (14, 3, 0, '2021-02-15 01:13:19');
INSERT INTO `cb_collect` VALUES (15, 3, 999, '2021-02-15 01:13:57');

-- ----------------------------
-- Table structure for cb_comment
-- ----------------------------
DROP TABLE IF EXISTS `cb_comment`;
CREATE TABLE `cb_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `score` tinyint(4) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cb_comment
-- ----------------------------
INSERT INTO `cb_comment` VALUES (1, 1, 1, '哈哈哈哈哈', 5, '2021-01-15 10:48:00');
INSERT INTO `cb_comment` VALUES (2, 2, 1, '嘎嘎嘎嘎嘎', 4, '2021-01-15 10:48:50');
INSERT INTO `cb_comment` VALUES (3, 3, 1, '反反复复付', 4, '2021-01-15 10:49:15');
INSERT INTO `cb_comment` VALUES (4, 2, 2, '哒哒哒哒哒哒', 2, '2021-01-15 12:05:32');
INSERT INTO `cb_comment` VALUES (5, 2, 3, '少时诵诗书', 5, '2021-01-15 12:05:47');
INSERT INTO `cb_comment` VALUES (6, 1, 2, '愿得一心人', 5, '2021-01-21 11:22:09');
INSERT INTO `cb_comment` VALUES (7, 1, 2, 'put your hands up', 5, '2021-01-27 15:00:14');
INSERT INTO `cb_comment` VALUES (8, 1, 2, 'put your hands up', 5, '2021-02-20 03:22:59');
INSERT INTO `cb_comment` VALUES (9, 1, 3, 'gshhshsbsbb', 5, '2021-02-20 03:27:42');
INSERT INTO `cb_comment` VALUES (10, 1, 4, 'ghvcc', 3, '2021-02-20 03:29:59');

-- ----------------------------
-- Table structure for cb_manager
-- ----------------------------
DROP TABLE IF EXISTS `cb_manager`;
CREATE TABLE `cb_manager`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` tinyint(4) NOT NULL COMMENT '1男 2女 3未知',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '1正常 2禁用',
  `has_rights` tinyint(4) NOT NULL DEFAULT 2 COMMENT '1超管 2普管',
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户申请表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cb_manager
-- ----------------------------
INSERT INTO `cb_manager` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin_all', 1, '15013515010', '/upload/20210224/069af69b-90f8-4f90-a3a3-29a4cef321c6_微信图片_20210128130219.jpg', 1, 1, '2021-02-02 17:48:02');
INSERT INTO `cb_manager` VALUES (2, 'admin_dev', 'e10adc3949ba59abbe56e057f20f883e', 'admin for book manager', 1, '15017515011', NULL, 2, 2, '2021-02-24 10:22:24');

-- ----------------------------
-- Table structure for cb_user
-- ----------------------------
DROP TABLE IF EXISTS `cb_user`;
CREATE TABLE `cb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账号',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` tinyint(4) NULL DEFAULT NULL COMMENT '1男 2女 3未知',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` tinyint(4) NULL DEFAULT 1 COMMENT '1正常 2禁用',
  `auth` tinyint(4) NULL DEFAULT 2 COMMENT '1启用 2禁用',
  `manager_id` int(11) NULL DEFAULT 0 COMMENT '管理员ID',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '读者表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cb_user
-- ----------------------------
INSERT INTO `cb_user` VALUES (1, 'eb6599e995174584ae5e6c72f11ea570', 'admin', 'admin', 1, '15013515010', 'e10adc3949ba59abbe56e057f20f883e', 1, 1, 1, NULL);
INSERT INTO `cb_user` VALUES (2, '9c61df4321ed4de2acfeb507a8bb3cbd', 'KingJames', 'KingJames', 0, NULL, '134ca4ab939125796937682deae46f2c', 1, 1, 0, NULL);
INSERT INTO `cb_user` VALUES (3, '3080f1e83c42468fb6f322f46e157e9c', 'book', 'book', 0, NULL, '821f03288846297c2cf43c34766a38f7', 1, 2, 0, NULL);
INSERT INTO `cb_user` VALUES (4, '0583a007ebf54c1d94a27e9f19b8bbef', '123456', '123456', 0, NULL, '25f9e794323b453885f5181f1b624d0b', 1, 2, 0, NULL);
INSERT INTO `cb_user` VALUES (5, '27c884c0fbb6469d995f72c9c0a3fa24', 'admin_dev', 'admin for book manager', 1, '15017515011', 'e10adc3949ba59abbe56e057f20f883e', 1, 1, 2, NULL);

-- ----------------------------
-- Table structure for cb_user_apply
-- ----------------------------
DROP TABLE IF EXISTS `cb_user_apply`;
CREATE TABLE `cb_user_apply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '姓名',
  `gender` tinyint(4) NULL DEFAULT 1 COMMENT '性别 1男 2女',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号',
  `id_card` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `id_card_positive_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证正面照',
  `id_card_negative_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证反面照',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '1审核通过 2不通过 3待审',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cb_user_apply
-- ----------------------------
INSERT INTO `cb_user_apply` VALUES (4, 1, '测试', 1, '13560608080', '8888777776666', '/upload/1/1/1.jpg', '/upload/1/1/2.jpg', 3, NULL, '2021-01-20 12:59:18');

SET FOREIGN_KEY_CHECKS = 1;

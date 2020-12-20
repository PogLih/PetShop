-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2020 at 07:28 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `petshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `userid` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `totalprice` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`id`, `date`, `userid`, `status`, `totalprice`) VALUES
(6, '2020-12-03', 5, 0, 5780000),
(7, '2020-12-03', 5, 0, 5780000),
(8, '2020-12-03', 2, 0, 64000),
(9, '2020-12-03', 2, 0, 352000),
(10, '2020-12-03', 5, 0, 2922000);

-- --------------------------------------------------------

--
-- Table structure for table `billinfo`
--

CREATE TABLE `billinfo` (
  `id` int(11) NOT NULL,
  `idBill` int(11) NOT NULL,
  `idproduct` int(11) NOT NULL,
  `countItem` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `billinfo`
--

INSERT INTO `billinfo` (`id`, `idBill`, `idproduct`, `countItem`) VALUES
(23, 6, 1, 2),
(24, 6, 1, 2),
(25, 7, 1, 2),
(26, 7, 1, 2),
(27, 8, 2, 1),
(28, 8, 2, 1),
(29, 9, 2, 1),
(30, 9, 6, 1),
(31, 9, 4, 1),
(32, 10, 1, 2),
(33, 10, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `blog`
--

CREATE TABLE `blog` (
  `id` int(11) NOT NULL,
  `cate` int(11) NOT NULL,
  `title` varchar(50) CHARACTER SET utf8 NOT NULL,
  `datepost` datetime DEFAULT current_timestamp(),
  `userid` int(11) NOT NULL,
  `images` varchar(100) CHARACTER SET utf8 NOT NULL,
  `content` varchar(2000) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `blog`
--

INSERT INTO `blog` (`id`, `cate`, `title`, `datepost`, `userid`, `images`, `content`) VALUES
(1, 1, 'Cach cham soc cho poodle sau ShopShopBlogsinh', '2020-11-14 00:00:00', 1, 'hinh.jpg', 'Testne'),
(2, 1, 'Thoi diem nao thi can sieu am cho mang thai', '2020-11-14 13:23:45', 2, 'hinh.jpg', 'Test'),
(3, 1, 'Cach dieu tri benh ung thu mui o cho', '2020-11-14 13:23:45', 3, 'hinh.jpg', 'Test'),
(4, 1, 'Cho bi ho khi van dong manh', '2020-11-14 13:23:45', 4, 'hinh.jpg', 'Nhiều người do lo sợ thú cưng của mình sẽ bị nhiễm bệnh nên vội vàng đưa đi tiêm sớm nhưng điều này lại vô tình khiến kích thích miễn dịch không đạt hiệu quả do kháng thể truyền từ người mẹ sang con gây cản trở vaccine. Thêm vào đó, nếu tiêm vaccine quá sớm còn làm tăng nguy cơ bị phản ứng ở thú cưng. Do đó, việc tiêm vaccine mũi đầu quá sớm không những không đem tới hiệu quả hơn nữa còn có thể gây ảnh hưởng đến cơ thể thú cưng.'),
(5, 1, 'Cho corgi: nhung dieu thu vi ve chung', '2020-11-14 13:23:45', 5, 'hinh.jpg', 'Test'),
(6, 1, 'Nhung dieu can biet khi thien cho duc', '2020-11-14 13:23:45', 1, 'hinh.jpg', 'Test'),
(7, 1, 'Cho chihuahua: nhung su that dang ngac nhien', '2020-11-14 13:23:45', 2, 'hinh.jpg', 'Test'),
(8, 1, 'Cho bichon: nhung dieu ma ban chua tung duoc biet', '2020-11-14 13:23:45', 3, 'hinh.jpg', 'Test'),
(9, 1, 'Shiba-inu chu co den tu xu phu tang', '2020-11-14 13:23:45', 4, 'hinh.jpg', 'Test'),
(10, 1, 'Poodle co bao nhieu loaij khac nhau', '2020-11-14 13:23:45', 5, 'hinh.jpg', 'Test'),
(11, 2, 'sss', '2020-11-19 00:00:00', 1, 'meo1.jpg', 'test 2');

-- --------------------------------------------------------

--
-- Table structure for table `blogcategories`
--

CREATE TABLE `blogcategories` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `blogcategories`
--

INSERT INTO `blogcategories` (`id`, `name`) VALUES
(1, 'Blog ve cho'),
(2, 'Blog ve meo'),
(3, 'Blog ve Hamster');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `cate` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `brand` varchar(50) CHARACTER SET utf8 NOT NULL,
  `images` varchar(200) CHARACTER SET utf8 NOT NULL,
  `status` bit(1) DEFAULT b'0',
  `price` int(11) NOT NULL CHECK (`price` > 0),
  `discount` int(11) DEFAULT 0,
  `height` int(11) DEFAULT 0,
  `width` int(11) DEFAULT 0,
  `length` int(11) DEFAULT 0,
  `typeofpet` varchar(100) CHARACTER SET utf8 DEFAULT 'Mọi loại pet',
  `stage` varchar(100) CHARACTER SET utf8 DEFAULT 'Mọi độ tuổi',
  `description` varchar(200) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `cate`, `name`, `brand`, `images`, `status`, `price`, `discount`,`height`,`width`,`length`,`typeofpet`,`stage`,`description`) VALUES
(1, 1, 'Thuc an cho chooo', 'PRO PAC', 'hinh1.jpg', b'0', 1445000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(2, 2, 'Quan ao cho cho', 'PRO PAC', 'pro1.jpg', b'1', 32000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(3, 3, 'Vat dung an uong', 'PRO PAC', 'pro2.jpg', b'1', 300000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(4, 4, 'Do choi cho cho', 'PRO PAC', 'pro3.jpg', b'1', 200000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(5, 5, 'Nha o cho co', 'Ferplast Atlas', 'pro4.jpg', b'1', 400000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(6, 1, 'Thuc an cho meo', 'Hagen Catit', 'pro5.jpg', b'1', 120000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(7, 2, 'Quan ao cho meo', 'Hagen Catit', 'pro6.jpg', b'1', 320000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(8, 3, 'Vat dung an uong  cho meo', 'Hagen Catit', 'pro7.jpg', b'1', 255000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(9, 4, 'Do choi cho meo', 'Hagen Catit', 'pro8.jpg', b'1', 600000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(10, 5, 'Nha o cho meo', 'Hagen Catit', 'hinh.jpg', b'1', 250000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(11, 1, 'Thuc an cho chuot', 'Hagen', 'hinh.jpg', b'1', 30000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(12, 2, 'vat dung an uong cho chuot', 'Hagen', 'hinh.jpg', b'1', 40000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(13, 3, 'Dung cu ve sinh', 'Hagen', 'hinh.jpg', b'1', 35000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(14, 4, 'Chuong Hamster', 'Hagen', 'hinh.jpg', b'1', 300000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(15, 5, 'Do choi Hamster', 'Hagen', 'hinh.jpg', b'1', 60000, 0,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah'),
(16, 2, 'testthinhpro', '1', 'admin.png', b'0', 666, 1,0,0,0,'Mọi loại pet','Mọi độ tuổi','hahahahhahahahah');

-- --------------------------------------------------------

--
-- Table structure for table `productcategories`
--

CREATE TABLE `productcategories` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productcategories`
--

INSERT INTO `productcategories` (`id`, `name`) VALUES
(1, 'Thuc An'),
(2, 'Quan ao'),
(3, 'Dung cu ve sinh'),
(4, 'Do choi'),
(5, 'Nha o');

-- --------------------------------------------------------

--
-- Table structure for table `productdetail`
--
/*
CREATE TABLE `productdetail` (
  `idproduct` int(11) NOT NULL,
  `height` int(11) DEFAULT 0,
  `width` int(11) DEFAULT 0,
  `length` int(11) DEFAULT 0,
  `typeofpet` varchar(100) CHARACTER SET utf8 DEFAULT 'Mọi loại pet',
  `stage` varchar(100) CHARACTER SET utf8 DEFAULT 'Mọi độ tuổi',
  `description` varchar(200) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productdetail`
--

INSERT INTO `productdetail` (`idproduct`, `height`, `width`, `length`, `typeofpet`, `stage`, `description`) VALUES
(1, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Là loại thức ăn tốt nhất dành cho chó hiện nay ở trên thị trường Việt Nam và toàn thế giới. Với những công\nthức được kiểm tra và đo lường kỹ càng. Sẽ đảm bảo sức khỏe cho chú chó của bạn khi bạn dùng '),
(2, 50, 60, 50, 'Mọi loại pet', 'Mọi độ tuổi', 'Loại quần áo thịnh hành với những chú chó hiện nay. Đem lại sự tươi mới cho chú chó của bạn.'),
(3, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Được làm từ nguyên vật liệu không gây hại cho chú chó của bạn. Có nhiều loại hình màu sắc khác nhau\nđể bạn có thể có nhiều lựa chọn cho chú chó của mình'),
(4, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Đem lại cảm giác mới lạ cho chú chó của bạn. Thay bạn chơi với chúng khi bạn bận.'),
(5, 100, 100, 100, 'Mọi loại pet', 'Mọi độ tuổi', 'Được làm từ loại thép vững chắc không lo chú chó\ncủa bạn bị xổng ra lúc bạn đi vắng. Không gian đủ rộng để chú chó thoải mái chơi đùa'),
(6, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Là loại thức ăn tốt nhất dành cho mèo hiện nay ở trên thị trường Việt Nam và toàn thế giới. Với những công\nthức được kiểm tra và đo lường kỹ càng. Sẽ đảm bảo sức khỏe cho chú mèo của bạn khi bạn dùng '),
(7, 20, 30, 30, 'Mọi loại pet', 'Mọi độ tuổi', 'Loại quần áo thịnh hành với những chú mèo hiện nay. Đem lại sự tươi mới cho chú mèo của bạn.'),
(8, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Được làm từ nguyên vật liệu không gây hại cho chú mèo của bạn. Có nhiều loại hình màu sắc khác nhau\nđể bạn có thể có nhiều lựa chọn cho chú mèo của mình'),
(9, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Giúp mèo giải tỏa stress, có nhiều sản phẩm giúp mèo tự chơi hoặc mài móng. Giúp bạn có thể yên tâm mỗi khi ra ngoài.'),
(10, 40, 40, 40, 'Mọi loại pet', 'Mọi độ tuổi', 'Sản phẩm có nhiều kích cỡ màu sắc khác nhau. Có nhiều sản phẩm đem lại cảm giác hoàn toàn mới lạ\ncho chú mèo của bạn'),
(11, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Thức ăn được trộn từ các loại hoa quả tự nhiên thêm các loại hạt đem lại sức khỏe tốt cho chú chuột của bạn'),
(12, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Những thứ cần thiết để giúp chuột ăn uống'),
(13, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Những thứ cần thiết để giúp chuột vệ sinh, giúp chuột tăng sức đề kháng và sạch sẽ thơm tho hơn.'),
(14, 20, 15, 15, 'Mọi loại pet', 'Mọi độ tuổi', 'Để tránh cho chú chuột chạy lung tung. Bên trong ngôi nhà còn được trang bị đủ \nmọi thứ cần thiết cho chú chuột của bạn vui chơi.'),
(15, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Dụng cụ giúp chuột giảm béo');
*/
-- --------------------------------------------------------

--
-- Table structure for table `servicecategories`
--

CREATE TABLE `servicecategories` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `servicecategories`
--

INSERT INTO `servicecategories` (`id`, `name`) VALUES
(1, 'Dich vu tiem phong'),
(2, 'Dich vu triet san'),
(3, 'Dich vu giu thu cung'),
(4, 'Dich vu tam thu cung'),
(5, 'Dich vu lay rai tai'),
(6, 'Dich vu tia  long'),
(7, 'Dich vu huan luyen'),
(8, 'Dich vu kham tong qua'),
(9, 'Dich vu cham soc tai nha'),
(10, 'Dich vu ghep doi');

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE `services` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `cate` int(11) NOT NULL,
  `price` int(11) NOT NULL DEFAULT 0,
  `images` varchar(200) CHARACTER SET utf8 NOT NULL,
  `status` bit(1) DEFAULT b'1',
  `description` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `discount` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`id`, `name`, `cate`, `price`, `images`, `status`, `description`, `discount`) VALUES
(1, 'Dich vu tiem phong', 1, 150000, 'bg9.jpg', b'1', 'Tiêm vacxin cho vật nuôi, thú cưng chính là giải pháp ngăn ngừa bệnh vô cùng an toàn lại hiệu quả. Những chú chó, mèo, thú cưng được tiêm phòng vacxin chắc chắn sẽ có sức đề kháng cao hơn, có khả năng', 0),
(2, 'Dich vu triet san', 2, 400000, 'bg9.jpg', b'1', 'Triệt sản cho vật nuôi, chó mèo chính xác là một cuộc phẫu thuật cần có độ chính xác cao. Bởi chỉ cần sơ xuất, rất có thế thú cưng của bạn sẽ gặp phải nguy hiểm. Trước khi làm phẫu thuật triệt sản cho', 0),
(3, 'Dich vu giu thu cung', 3, 200000, 'ser1.jpg', b'1', 'Bạn đang chuẩn bị một chuyến đi công tác vài ngày? Hay cả gia đình bạn chuẩn bị đi du lịch, bạn lo lắng không có ai chăm sóc cho thú cưng của bạn? Bạn rất muốn dẫn chúng đi theo những điều kiện ra xôi', 0),
(4, 'Dich vu tam thu cung', 4, 40000, 'ser2.jpg', b'1', 'Để thú cưng phát triển được khỏe mạnh thì việc tắm thường xuyên cho chúng là điều bạn không thể bỏ qua. Không chỉ để loại bỏ bụi bẩn bám trên da hoặc lông, việc tắm, chải lông đúng cách còn giúp thú c', 0),
(5, 'Dich vu lay rai tai', 5, 50000, 'ser3.jpg', b'1', 'Cạo  lông lỗ tai với bột chuyên biệt giúp các bé không bị đau, lấy ráy tai và vệ sinh tai', 0),
(6, 'Dich vu tia long', 6, 60000, 'ser4.jpg', b'1', 'Thú cưng của bạn sẽ trở nên đang yêu hơn với dịch vụ cắt và tạo kiểu tóc đẹp tại Pet Shop', 0),
(7, 'Dich vu huan luyen', 7, 800000, 'Hinh.jpg', b'1', 'Nuôi thú  cưng không đơn giản chỉ là chú chó/mèo đó sẽ sống ở nhà bạn, mà là bạn cần dành thời gian, công sức và tiền bạc của bản thân để quan tâm, chăm sóc cho bé cưng.', 0),
(8, 'Dich vu kham tong quat', 8, 300000, 'Hinh.jpg', b'1', 'Bác sĩ thú y của chúng tôi sẽ muốn kiểm tra con mèo của bạn kỹ lưỡng ít nhất một lần một năm và thường xuyên hơn khi chúng già đi hoặc nếu chúng có nhu cầu y tế đặc biệt. Cuộc hẹn này sẽ có một cách t', 0),
(9, 'Dich vu cham soc tai nha', 9, 700000, 'Hinh.jpg', b'1', 'Là dịch vụ mà các Nhân viên chăm sóc thú cưng (Pet Sitter) sẽ đến chăm sóc thú cưng tại nhà của bạn.\nNếu thú cưng của bạn có nhút nhát và tập tính lãnh thổ cao thì đây là dịch vụ phù hợp nhất dành cho', 0),
(10, 'Dich vu ghep doi', 10, 300000, 'bg9.jpg', b'1', 'Ở đây chúng tôi không làm thế', 0),
(11, 'thinht1', 2, 666, 'music+round+icon+spotify+icon-1320190507294268936.png', b'0', 'pppppppppppp', 0),
(12, 'tiem cho meooooooo', 2, 555555, 'meo4.jpg', b'1', 'asas', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(50) DEFAULT "ROLE_USER",
  `name` varchar(50) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `address` varchar(200) NOT NULL,
  `avatar` varchar(100) NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `role`,`name`,`phone`,`address`) VALUES
(1, 'phong@gmail.com', '$2a$10$SArPnBixTLjETiKuqUl8We1lhkrmx5OvmoI/GPqXllEixq13m0Pga', 'ROLE_USER','Phong dep trai','0123456789','68 bui thi xuan'),
(2, 'chau@gmail.com', '$2a$10$oSZCbUv6MJocYSj13griJely3vD7Q5niyeVUlbCO7njCfFxzbeQye', 'ROLE_USER','Phong dep trai','0123456789','68 bui thi xuan'),
(3, 'hoang@gmail.com', '$2a$10$qUmoYzq.ryjO.vj8gT5Gvu2uBLGRY97a5eMg/vp08jVfp6.THHzta', 'ROLE_USER','Phong dep trai','0123456789','68 bui thi xuan'),
(4, 'minh@gmail.com', '$2a$10$btFJx8zlfGrgED0qGb.QZeDVqHSjeyo9PClrDD3ZPgQv9pEME0dWG', 'ROLE_USER','Phong dep trai','0123456789','68 bui thi xuan'),
(5, 'thinh@gmail.com', '$2a$10$p/9gNp9/dHSher9UeNRRN.x/S4uNU2/yHHckmJzgtrJqQffBO4zS.', 'ROLE_ADMIN','Phong dep trai','0123456789','68 bui thi xuan');


--
-- Indexes for dumped tables
--
--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `b_fk` (`userid`);

--
-- Indexes for table `billinfo`
--
ALTER TABLE `billinfo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bi_b_fk` (`idBill`),
  ADD KEY `bi_p_fk` (`idproduct`);

--
-- Indexes for table `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`),
  ADD KEY `b_bc_fk` (`cate`),
  ADD KEY `b_ac_fk` (`userid`);

--
-- Indexes for table `blogcategories`
--
ALTER TABLE `blogcategories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p_fk` (`cate`);

--
-- Indexes for table `productcategories`
--
ALTER TABLE `productcategories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `productdetail`


--
-- Indexes for table `servicecategories`
--
ALTER TABLE `servicecategories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`id`),
  ADD KEY `s_sc_fk` (`cate`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `billinfo`
--
ALTER TABLE `billinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `blog`
--
ALTER TABLE `blog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `blogcategories`
--
ALTER TABLE `blogcategories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `productcategories`
--
ALTER TABLE `productcategories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `servicecategories`
--
ALTER TABLE `servicecategories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `services`
--
ALTER TABLE `services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `b_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`id`);

--
-- Constraints for table `billinfo`
--
ALTER TABLE `billinfo`
  ADD CONSTRAINT `bi_b_fk` FOREIGN KEY (`idBill`) REFERENCES `bill` (`id`),
  ADD CONSTRAINT `bi_p_fk` FOREIGN KEY (`idproduct`) REFERENCES `product` (`id`);

--
-- Constraints for table `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `b_ac_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `b_bc_fk` FOREIGN KEY (`cate`) REFERENCES `blogcategories` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `p_fk` FOREIGN KEY (`cate`) REFERENCES `productcategories` (`id`);

--
-- Constraints for table `productdetail`
--

--
-- Constraints for table `services`
--
ALTER TABLE `services`
  ADD CONSTRAINT `s_sc_fk` FOREIGN KEY (`cate`) REFERENCES `servicecategories` (`id`);
  
  create table `schedule`
(
    idschedle int(11) auto_increment primary key,
    idservice int(11),
    iduser int(11),
    dateorder datetime DEFAULT current_timestamp(),
    datacheckin datetime DEFAULT current_timestamp(),
    note nvarchar(200),
    CONSTRAINT FK_serviceSchudle FOREIGN KEY (idservice) references services(id),
    CONSTRAINT FK_userSchudle FOREIGN KEY (iduser) references user(id)
);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

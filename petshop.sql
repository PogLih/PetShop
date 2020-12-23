-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 21, 2020 lúc 09:57 AM
-- Phiên bản máy phục vụ: 10.4.14-MariaDB
-- Phiên bản PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `petshop`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `userid` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `totalprice` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `bill`
--

INSERT INTO `bill` (`id`, `date`, `userid`, `status`, `totalprice`) VALUES
(6, '2020-12-03', 5, 3, 5780000),
(7, '2020-12-03', 5, 3, 5780000),
(8, '2020-12-03', 2, 3, 64000),
(9, '2020-12-03', 2, 0, 352000),
(10, '2020-12-03', 5, 0, 2922000),
(11, '2020-12-10', 5, 0, 1000000),
(12, '2020-12-11', 2, 0, 380000),
(13, '2020-12-11', 5, 0, 1435600);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `billinfo`
--

CREATE TABLE `billinfo` (
  `id` int(11) NOT NULL,
  `idBill` int(11) NOT NULL,
  `idproduct` int(11) NOT NULL,
  `countItem` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `billinfo`
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
(33, 10, 2, 1),
(34, 11, 5, 1),
(35, 11, 3, 2),
(36, 12, 12, 2),
(37, 12, 14, 1),
(38, 13, 16, 2),
(39, 13, 15, 1),
(40, 13, 3, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `blog`
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
-- Đang đổ dữ liệu cho bảng `blog`
--

INSERT INTO `blog` (`id`, `cate`, `title`, `datepost`, `userid`, `images`, `content`) VALUES
(1, 1, 'Cach cham soc cho poodle sau ShopShopBlogsinh', '2020-11-14 00:00:00', 1, 'blog1.jpg', 'Nhưng điều ảnh hưởng rõ nét nhất mà mình thấy đó là môi trường sinh sống. Những chú chó hay di chuyển trên bề mặt mềm (trên cỏ) hoặc cứng nhưng trơn (gạch bông) thường khó kiểm soát độ dài móng hơn những chú chó hay di chuyển trên bề mặt cứng và nhám (sàn xi măng hoặc nhựa đường).'),
(2, 1, 'Thoi diem nao thi can sieu am cho mang thai', '2020-11-14 13:23:45', 2, 'blog2.jpg', 'Chỉ cần 1 trong 3 món trên là bạn có thể bắt đầu rồi. Ngoài ra bạn nên chuẩn bị một số vật linh tinh khác như bột ngô, hoặc bột cầm máu và một cái đèn.'),
(3, 1, 'Cach dieu tri benh ung thu mui o cho', '2020-11-14 13:23:45', 3, 'blog3.jpg', 'Suy thận cấp cũng có thể xảy ra nếu lưu lượng máu hoặc lượng oxy được cung cấp đến thận giảm. Ví dụ như chấn thương, mất nước nghiêm trọng và say nắng.'),
(4, 1, 'Cho bi ho khi van dong manh', '2020-11-14 13:23:45', 4, 'blog4.jpg', 'Nhiều người do lo sợ thú cưng của mình sẽ bị nhiễm bệnh nên vội vàng đưa đi tiêm sớm nhưng điều này lại vô tình khiến kích thích miễn dịch không đạt hiệu quả do kháng thể truyền từ người mẹ sang con gây cản trở vaccine. Thêm vào đó, nếu tiêm vaccine quá sớm còn làm tăng nguy cơ bị phản ứng ở thú cưng. Do đó, việc tiêm vaccine mũi đầu quá sớm không những không đem tới hiệu quả hơn nữa còn có thể gây ảnh hưởng đến cơ thể thú cưng.'),
(5, 1, 'Cho corgi: nhung dieu thu vi ve chung', '2020-11-14 13:23:45', 5, 'blog5.jpg', 'Và tương tự ở chó, chúng cũng sẽ không thích bị nhìn như vậy. Cho nên, hãy để việc giao tiếp bằng mắt diễn ra một cách tự nhiên. Tránh việc cố ý nhìn thẳng và chằm chằm vào chú chó của bạn, điều này sẽ khiến chúng khó chịu đấy.'),
(6, 1, 'Nhung dieu can biet khi thien cho duc', '2020-11-14 13:23:45', 1, 'blog6.jpg', 'Tuy nhiên việc giao tiếp bằng mắt sẽ không còn hay ho nữa khi ai đó cứ nhìn bạn chằm chằm. Mình từng nghe ở đâu đó rằng “Khi một ai đó nhìn bạn quá 7 giây. Một là họ yêu bạn, hai là họ sắp giết bạn”. Vì vậy chắc chắn là việc nhìn chằm chằm sẽ gây cho bạn một cảm giác không dễ chịu tí nào.'),
(7, 1, 'Cho chihuahua: nhung su that dang ngac nhien', '2020-11-14 13:23:45', 2, 'blog7.jpg', 'Nhưng như thế thì chưa đủ, vẫn còn. Nếu bạn để ý mỗi khi chú chó của bạn đang nghỉ ngơi, thư giãn nhưng chỉ cần thấy bạn đi ngang, chúng sẽ nhẹ nhàng vẫy đuôi với bạn. Đó cũng là một dấu hiệu nhỏ cho biết rằng chúng rất mừng khi thấy bạn.'),
(8, 1, 'Cho bichon: nhung dieu ma ban chua tung duoc biet', '2020-11-14 13:23:45', 3, 'blog8.jpg', 'Tại sao vậy? Vì chúng cảm thấy an toàn, tin tưởng, và hoàn toàn thoải mái. Nếu như bình thường khi chúng ta ngủ ở một nơi lạ, chúng ta sẽ thường quay lưng vào tường.  Lí do là bởi chúng ta xa lạ, cảm thấy không an toàn với xung quanh. Với cún cũng vậy, chúng sẽ không tin tưởng để quay lưng lại nếu đó là người lạ.'),
(9, 1, 'Shiba-inu chu co den tu xu phu tang', '2020-11-14 13:23:45', 4, 'blog9.jpg', 'Ngoài ra, khi chúng sợ hãi, lo lắng (như khi nghe thấy tiếng sấm chớp). Chúng cũng sẽ có xu hướng tìm đến bạn và nằm quay lưng về phía bạn. Điều này có nghĩa là chúng tin tưởng và xem bạn như một người bảo vệ.'),
(10, 1, 'Poodle co bao nhieu loaij khac nhau', '2020-11-14 13:23:45', 5, 'blog10.jpg', 'Còn gì tuyệt vời hơn là ngủ chung với người mình yêu thương nhỉ? Lại bảo không có đi mấy anh zai. Những chú chó yêu thương bạn sẽ luôn tận dụng mọi cơ hội để có thể được ngủ chung với bạn. Hoặc ít nhất là được ngủ gần bên bạn.'),
(11, 2, 'Blog cho mèo bị ú', '2020-11-19 00:00:00', 1, 'blog11.jpg', 'Việc ngủ chung xuất phát từ tập tính xa xưa của loài sói. Trong tự nhiên, sói thích ngủ theo bầy đàn, hay nói cách khác là các thành viên trong gia đình. Và bé cún của bạn cũng thừa hưởng tập tính đó. Vậy nên đừng bất ngờ khi chúng cứ đòi ngủ chung nhé, chỉ là vì chúng quan tâm đến bạn thôi.'),
(12, 2, 'Moè méo meo mèo meo', '2020-11-30 00:00:00', 2, 'blog12.jpg', 'Đây là một hành vi đã được nghiên cứu hẳn hoi ở Nhật Bản luôn nhé. Nghiên cứu đã chỉ ra chó có rất nhiều biểu cảm trên mặt chúng. Và lông mày của chó sẽ nhướng lên và ngọ nguậy liên tục qua lại khi chúng thấy chủ của chúng.'),
(14, 1, 'Thực tập sinh IT', '2020-12-15 00:00:00', 2, 'pexels-dominika-roseclay-2023384.jpg', 'aaaaaaaa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `blogcategories`
--

CREATE TABLE `blogcategories` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `blogcategories`
--

INSERT INTO `blogcategories` (`id`, `name`) VALUES
(1, 'Blog ve cho'),
(2, 'Blog ve meo'),
(3, 'Blog ve Hamster');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
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
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `cate`, `name`, `brand`, `images`, `status`, `price`, `discount`, `height`, `width`, `length`, `typeofpet`, `stage`, `description`) VALUES
(1, 1, 'Thuc an cho chooo', 'PRO PAC', 'hinh1.jpg', b'0', 1445000, 0, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Sản phẩm được thiết kế gọn, nhẹ, tiện lợi phù hợp để đặt ở bất kỳ đâu, chất liệu vải mềm, mịn, đảm bảo an toàn không gây kích ứng cho vật nuôi. Sản xuất theo tiêu chuẩn thích hợp với thời tiết tại các'),
(2, 2, 'Quan ao cho cho', 'PRO PAC', 'pro1.jpg', b'1', 32000, 0, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Thiết kế hình tròn được đệm bông xung quanh viền và phía dưới ổ nằm, giúp nâng đỡ xương cho thú cưng trong lúc ngủ với những tư thế khác nhau mang lại cảm giác thư giãn, êm ái, và dễ dàng đi sâu vào g'),
(3, 3, 'Vật dụng ăn uống', 'PRO PAC', 'pro2.jpg', b'1', 300000, 0, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Hỗ trợ nâng đỡ xương, cải thiện sức khỏe, đem đến không gian riêng an toàn, thoải mái và 1 giấc ngủ trọn vẹn cho thú cưng.'),
(4, 4, 'Đồ chơi cho chó', 'PRO PAC', 'pro3.jpg', b'1', 200000, 0, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Bạn có thể dễ dàng giặt sạch sản phẩm bằng máy giặt cho những lần sử dụng tiếp theo của các bé.'),
(5, 5, 'Nhà ở cho chó', 'Ferplast Atlas', 'pro4.jpg', b'1', 400000, 0, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Được sản xuất và kiểm định tại Canada, nhập khẩu theo đường chính ngạch về Việt Nam.'),
(6, 1, 'Thức ăn cho mèo', 'Hagen Catit', 'pro5.jpg', b'1', 120000, 0, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Hạn chế không cho mèo ăn quá nhiều, dễ gây béo phì, thừa cân.'),
(7, 2, 'Quần áo cho mèo', 'Hagen Catit', 'pro6.jpg', b'1', 320000, 0, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Tất cả mang lại cho cún cưng một sức khỏe tốt nhất. Với hình dạng của một chiếc gậy có vỏ bọc chất lượng cao. Rất thuận tiện cho việc sử dụng và mang theo. Sản phẩm không cần bảo quản lạnh mà vẫn giữ '),
(8, 3, 'Vật dụng ăn uống cho mèo', 'Hagen Catit', 'pro7.jpg', b'1', 255000, 0, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Xúc xích cho chó vị thịt gà và rau JERHIGH Chicken and Vegetable là phần thưởng xứng đáng dành cho những người bạn bốn chân. Một món ăn ngon được chế biến từ thịt gà trộn với khoai lang và cà rốt. Thị'),
(9, 4, 'Đồ chơi cho mèo', 'Hagen Catit', 'pro8.jpg', b'1', 600000, 0, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Xúc xích cho chó vị thịt gà và rau JERHIGH Chicken and Vegetable là món ăn sáng tạo mới cho thú cưng. Sản phẩm phù hợp với lối sống hiện đại. Tiện ích và dễ sử dụng. JERHIGH Chicken and Vegetable được'),
(10, 5, 'Nhà ở cho mèo', 'Hagen Catit', 'pp8.jpg', b'1', 250000, 0, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Bánh thưởng cho chó vị thịt cừu BUDGE Mutton Flavor bổ sung vitamin và khoáng chất thiết yếu cho cún cưng. Xương dinh dưỡng cho chó giúp làm sạch răng, loại bỏ 99% những mảng cao răng cứng đầu. Hơn nữ'),
(11, 1, 'Thức ăn cho chuột', 'Hagen', 'pp9.jpg', b'1', 30000, 0, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Tinh bột, chiết xuất thực vật, thịt cừu và thịt động vật. Glutein, Vitamin A, E. Bột, đường, sữa. Vitamin, khoáng chất… Sản phẩm với thành phần từ thiên nhiên, không chứa chất bảo quản giúp cho hương '),
(12, 2, 'Vật dụng ăn uống', 'Hagen', 'pp10.jpg', b'1', 40000, 0, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Sử dụng biểu đồ làm hướng dẫn và điều chỉnh khi cần thiết để duy trì cân nặng thích hợp. Khẩu phần cho ăn có thể thay đổi tùy theo độ tuổi, giống, khí hậu và tính khí. Tham khảo ý kiến bác sĩ thú y củ'),
(13, 3, 'Dụng cụ vệ sinh', 'Hagen', 'pp11.jpg', b'1', 35000, 0, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Công thức giàu chất chống oxy hóa này được bổ sung Vitamin A và Vitamin C cùng với các loại rau và trái cây giàu dinh dưỡng'),
(14, 4, 'Chuồng Hamster', 'Hagenggg', '121554434_345532546675731_1662803928902362297_n.png', b'1', 300000, 0, NULL, NULL, NULL, '', '', ''),
(15, 5, 'Đồ chơi Hamster', 'Hagen', 'pp4.jpg', b'1', 60000, 0, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Địu chó mèo AUGUST PET P68033B với nhiều họa tiết nhỏ độc đáo, đa màu sắc tạo nên phong cách thời trong ấn tượng. Sản phẩm được thiết kế giống như chiếc địu của trẻ nhỏ, thú cưng có thể dễ dàng thò đầ'),
(16, 2, 'Đồ cho chó lớn', '1', 'pp6.jpg', b'0', 87800, 1, 0, 0, 0, 'Mọi loại pet', 'Mọi độ tuổi', 'Nhà cho chó bằng nhựa dáng cao XINDING 419A được sản xuất trên dây chuyền công nghệ hiện đại, sản phẩm với màu sắc đa dạng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `productcategories`
--

CREATE TABLE `productcategories` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `productcategories`
--

INSERT INTO `productcategories` (`id`, `name`) VALUES
(1, 'Thuc An'),
(2, 'Quan ao'),
(3, 'Dung cu ve sinh'),
(4, 'Do choi'),
(5, 'Nha oo');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `schedule`
--

CREATE TABLE `schedule` (
  `idschedule` int(11) NOT NULL,
  `idservice` int(11) DEFAULT NULL,
  `iduser` int(11) DEFAULT NULL,
  `dateorder` datetime DEFAULT current_timestamp(),
  `datacheckin` datetime DEFAULT current_timestamp(),
  `note` varchar(200) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `schedule`
--

INSERT INTO `schedule` (`idschedule`, `idservice`, `iduser`, `dateorder`, `datacheckin`, `note`) VALUES
(2, 1, 1, '2020-12-10 00:00:00', '2020-12-30 00:00:00', 'dqwd'),
(4, 2, 2, '2020-12-10 00:00:00', '2021-01-21 00:00:00', 'tesd 1'),
(5, 3, 2, '2020-12-10 00:00:00', '2020-12-30 00:00:00', 'alo'),
(7, 3, 4, '2020-12-11 00:00:00', '2020-12-29 00:00:00', 'ddwqdqdqdqd'),
(9, 5, 5, '2020-12-15 00:00:00', '2020-12-21 00:00:00', 'aaa'),
(12, 5, 5, '2020-12-15 00:00:00', '2020-12-23 00:00:00', 'asd'),
(14, 11, 5, '2020-12-15 00:00:00', '2020-12-29 00:00:00', 'mmmm'),
(15, 12, 5, '2020-12-21 00:00:00', '2020-12-22 00:00:00', 'thinh ggg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `servicecategories`
--

CREATE TABLE `servicecategories` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `servicecategories`
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
-- Cấu trúc bảng cho bảng `services`
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
-- Đang đổ dữ liệu cho bảng `services`
--

INSERT INTO `services` (`id`, `name`, `cate`, `price`, `images`, `status`, `description`, `discount`) VALUES
(1, 'Dich vu tiem phong', 1, 150000, 'ser1.jpg', b'1', 'Tiêm vacxin cho vật nuôi, thú cưng chính là giải pháp ngăn ngừa bệnh vô cùng an toàn lại hiệu quả. Những chú chó, mèo, thú cưng được tiêm phòng vacxin chắc chắn sẽ có sức đề kháng cao hơn, có khả năng', 0),
(2, 'Dich vu triet san', 2, 400000, 'ser2.jpg', b'1', 'Triệt sản cho vật nuôi, chó mèo chính xác là một cuộc phẫu thuật cần có độ chính xác cao. Bởi chỉ cần sơ xuất, rất có thế thú cưng của bạn sẽ gặp phải nguy hiểm. Trước khi làm phẫu thuật triệt sản cho', 0),
(3, 'Dich vu giu thu cung', 3, 200000, 'ser3.jpg', b'1', 'Bạn đang chuẩn bị một chuyến đi công tác vài ngày? Hay cả gia đình bạn chuẩn bị đi du lịch, bạn lo lắng không có ai chăm sóc cho thú cưng của bạn? Bạn rất muốn dẫn chúng đi theo những điều kiện ra xôi', 0),
(4, 'Dich vu tam thu cung', 4, 40000, 'ser4.jpg', b'1', 'Để thú cưng phát triển được khỏe mạnh thì việc tắm thường xuyên cho chúng là điều bạn không thể bỏ qua. Không chỉ để loại bỏ bụi bẩn bám trên da hoặc lông, việc tắm, chải lông đúng cách còn giúp thú c', 0),
(5, 'Dich vu lay rai tai', 5, 50000, 'ser5.jpg', b'1', 'Cạo  lông lỗ tai với bột chuyên biệt giúp các bé không bị đau, lấy ráy tai và vệ sinh tai', 0),
(6, 'Dich vu tia long', 6, 60000, 'ser6.jpg', b'1', 'Thú cưng của bạn sẽ trở nên đang yêu hơn với dịch vụ cắt và tạo kiểu tóc đẹp tại Pet Shop', 0),
(7, 'Dich vu huan luyen', 7, 800000, 'ser7.jpg', b'1', 'Nuôi thú  cưng không đơn giản chỉ là chú chó/mèo đó sẽ sống ở nhà bạn, mà là bạn cần dành thời gian, công sức và tiền bạc của bản thân để quan tâm, chăm sóc cho bé cưng.', 0),
(8, 'Dich vu kham tong quat', 8, 300000, 'ser8.jpg', b'1', 'Bác sĩ thú y của chúng tôi sẽ muốn kiểm tra con mèo của bạn kỹ lưỡng ít nhất một lần một năm và thường xuyên hơn khi chúng già đi hoặc nếu chúng có nhu cầu y tế đặc biệt. Cuộc hẹn này sẽ có một cách t', 0),
(9, 'Dich vu cham soc tai nha', 9, 700000, 'ser9.jpg', b'1', 'Là dịch vụ mà các Nhân viên chăm sóc thú cưng (Pet Sitter) sẽ đến chăm sóc thú cưng tại nhà của bạn.\nNếu thú cưng của bạn có nhút nhát và tập tính lãnh thổ cao thì đây là dịch vụ phù hợp nhất dành cho', 0),
(10, 'Dich vu ghep doi', 10, 300000, 'ser10.jpg', b'1', 'Để thú cưng phát triển được khỏe mạnh thì việc tắm thường xuyên cho chúng là điều bạn không thể bỏ qua. Không chỉ để loại bỏ bụi bẩn bám trên da hoặc lông, việc tắm, chải lông đúng cách còn giúp thú c', 0),
(11, 'thinht1', 2, 666, 'ser11.jpg', b'0', 'Bác sĩ thú y của chúng tôi sẽ muốn kiểm tra con mèo của bạn kỹ lưỡng ít nhất một lần một năm và thường xuyên hơn khi chúng già đi hoặc nếu chúng có nhu cầu y tế đặc biệt. Cuộc hẹn này sẽ có một cách t', 0),
(12, 'tiem cho thinh', 2, 555555, '121554434_345532546675731_1662803928902362297_n.png', b'1', 'Triệt sản cho vật nuôi, chó mèo chính xác là một cuộc phẫu thuật cần có độ chính xác cao. Bởi chỉ cần sơ xuất, rất có thế thú cưng của bạn sẽ gặp phải nguy hiểm. Trước khi làm phẫu thuật triệt sản cho', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role` varchar(50) NOT NULL DEFAULT 'ROLE_USER',
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `avatar` varchar(100) DEFAULT NULL,
  `auth_provider` varchar(15) DEFAULT NULL,
  `verification_code` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `role`, `name`, `phone`, `address`, `avatar`, `auth_provider`, `verification_code`) VALUES
(1, 'phong@gmail.com', '$2a$10$SArPnBixTLjETiKuqUl8We1lhkrmx5OvmoI/GPqXllEixq13m0Pga', 'ROLE_USER', 'Nguyễn Quốc Phong', '0123456789', '68 bui thi xuan', 'phongava.jpg', NULL, NULL),
(2, 'chau@gmail.com', '$2a$10$eympQaJXgKsWjl6g5VcZkuLB.cxrq/MhN8iEWD./7rKYyIFLS4HbG', 'ROLE_USER', 'Hồ Trần Bảo Châu', '0123456789', '68 bui thi xuan', 'chauava.jpg', NULL, NULL),
(3, 'hoang@gmail.com', '$2a$10$qUmoYzq.ryjO.vj8gT5Gvu2uBLGRY97a5eMg/vp08jVfp6.THHzta', 'ROLE_USER', 'Nguyễn Huy Hoàng', '0123456789', '68 bui thi xuan', 'hoangava.jpg', NULL, NULL),
(4, 'tahuythinh@gmail.com', '$2a$10$KNaTYRS9dGY1QU2fES0mmeg7MdjT.AV7Rqw2gZZOjMm1S.k6xuoDK', 'ROLE_USER', 'Nguyễn Hoàng Minh', '0123456789', '68 bui thi xuan', 'minhava.jpg', NULL, 'PCpbsScD213x2'),
(5, 'thinh@gmail.com', '$2a$10$HmqBq6tIFDd1vwT70domteH4J9TK6nBGBuk64SQGfP.GzZ8A5gUZe', 'ROLE_ADMIN', 'Tạ Huy Thịnh', '0123456789', '68 bui thi xuan', 'thinhava.jpg', NULL, NULL),
(8, 'phongnguyen9514@gmail.com', NULL, 'ROLE_USER', 'Phong Mguyễn', NULL, NULL, NULL, NULL, NULL),
(9, 'phong9514@gmail.com', '123', 'ROLE_USER', 'Phong Nguyễn', '123456', 'asd', NULL, 'GOOGLE', NULL);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `b_fk` (`userid`);

--
-- Chỉ mục cho bảng `billinfo`
--
ALTER TABLE `billinfo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bi_b_fk` (`idBill`),
  ADD KEY `bi_p_fk` (`idproduct`);

--
-- Chỉ mục cho bảng `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`),
  ADD KEY `b_bc_fk` (`cate`),
  ADD KEY `b_ac_fk` (`userid`);

--
-- Chỉ mục cho bảng `blogcategories`
--
ALTER TABLE `blogcategories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p_fk` (`cate`);

--
-- Chỉ mục cho bảng `productcategories`
--
ALTER TABLE `productcategories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`idschedule`),
  ADD KEY `FK_serviceSchudle` (`idservice`),
  ADD KEY `FK_userSchudle` (`iduser`);

--
-- Chỉ mục cho bảng `servicecategories`
--
ALTER TABLE `servicecategories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`id`),
  ADD KEY `s_sc_fk` (`cate`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bill`
--
ALTER TABLE `bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `billinfo`
--
ALTER TABLE `billinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT cho bảng `blog`
--
ALTER TABLE `blog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `blogcategories`
--
ALTER TABLE `blogcategories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT cho bảng `productcategories`
--
ALTER TABLE `productcategories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `schedule`
--
ALTER TABLE `schedule`
  MODIFY `idschedule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `servicecategories`
--
ALTER TABLE `servicecategories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `services`
--
ALTER TABLE `services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `b_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `billinfo`
--
ALTER TABLE `billinfo`
  ADD CONSTRAINT `bi_b_fk` FOREIGN KEY (`idBill`) REFERENCES `bill` (`id`),
  ADD CONSTRAINT `bi_p_fk` FOREIGN KEY (`idproduct`) REFERENCES `product` (`id`);

--
-- Các ràng buộc cho bảng `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `b_ac_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `b_bc_fk` FOREIGN KEY (`cate`) REFERENCES `blogcategories` (`id`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `p_fk` FOREIGN KEY (`cate`) REFERENCES `productcategories` (`id`);

--
-- Các ràng buộc cho bảng `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `FK_serviceSchudle` FOREIGN KEY (`idservice`) REFERENCES `services` (`id`),
  ADD CONSTRAINT `FK_userSchudle` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `services`
--
ALTER TABLE `services`
  ADD CONSTRAINT `s_sc_fk` FOREIGN KEY (`cate`) REFERENCES `servicecategories` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

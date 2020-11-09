CREATE schema `Petshop`;
use Petshop;
-- Account--------------------
CREATE TABLE role (
  id bigint(20) NOT NULL auto_increment,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;
CREATE TABLE user (
  id bigint(20) NOT NULL auto_increment,
  email varchar(255) DEFAULT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UKob8kqyqqgmefl0aco34akdtpe (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;


CREATE TABLE users_roles (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  KEY FKt4v0rrweyk393bdgt107vdx0x (role_id),
  KEY FKgd3iendaoyh04b95ykqise6qh (user_id),
  CONSTRAINT FKgd3iendaoyh04b95ykqise6qh FOREIGN KEY (user_id) REFERENCES user (id),
  CONSTRAINT FKt4v0rrweyk393bdgt107vdx0x FOREIGN KEY (role_id) REFERENCES role (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;
-- insert Account
insert into  Account(username,password,role,fullname,address,phone,email  ) 
values('caoboilangtu','nguyenhuyhoang',0,'Nguyen Gia Bao','45 Co Giang quan Phu Nhuan','0753651156','caoboilangtu@gmail.com' );
insert into  Account(   username,password,role,fullname,address,phone,email  ) 
values('chauxinhgai','hotranbaochau',1,'Ho Tran Bao Chau','64 An Nhon'   ,'038009424','chauhtbps08771@fpt.edu.vn' );
insert into  Account(   username,password,role,fullname,address,phone,email  ) 
values('thinhdeptrai','tahuythinh',1,'Ta Huy Thinh','64 An Nhon'   ,'038009425','thinhthps08775@fpt.edu.vn' );
insert into  Account(   username,password,role,fullname,address,phone,email  ) 
values('minhdeptrai','nguyenhoangminh',1,'Nguyen Hoang Minh','64 An Nhon'   ,'038009423','minhnhps08776@fpt.edu.vn' );
insert into  Account(   username,password,role,fullname,address,phone,email  ) 
values('phongdeptrai','nguyenquocphong',1,'Nguyen Quoc Phong','64 An Nhon'   ,'038009425','phongnqps08774@fpt.edu.vn' );
insert into  Account(   username,password,role,fullname,address,phone,email  ) 
values('hoangdeptrai','nguyenhuyhoang',1,'Nguyen Huy Hoang','64 An Nhon'   ,'0857752027','hoangnhps08785@fpt.edu.vn' );
insert into  Account(   username,password,role,fullname,address,phone,email  ) 
values('dogilypetshop','nguyenhuyhoang',0,'Vo Viet Linh','96 Bach Dang quan Binh Thanh'   ,'0916299911','dogilypetshop@gmail.com' );
insert into  Account(   username,password,role,fullname,address,phone,email  ) 
values('vovietlinh','nguyenhuyhoang',0,'Vo Viet Linh','866 Bach Dang quan Binh Thanh'   ,'0916299911','vovietlinh@gmail.com' );
insert into  Account(   username,password,role,fullname,address,phone,email  ) 
values('thanhlongdev','vothanhlong',0,'Vo Thanh Long','Tay Ninh'   ,'0789120352','thanhlongdev12@gmail.com' );
insert into  Account(   username,password,role,fullname,address,phone,email  ) 
values('kehuydiet','nguyenhuyhoang',0,'Nguyen Gia Huy','551 Ha Huy Giap quan 12'   ,'0125221423','kehuydiet@gmail.com' );
-- Product----------------------
create table ProductCategories
(
	id int auto_increment primary key, -- mã loại sản phẩm
    name nvarchar(50) not null-- tên loại sản phẩm
);
-- insert product
insert into ProductCategories(id,name) 
values(1,'Thuc An');
insert into ProductCategories(id,name) 
values(2,'Quan ao');
insert into ProductCategories(id,name)
values(3,'Dung cu ve sinh');
insert into ProductCategories(id,name) 
values(4,'Do choi');
insert into ProductCategories(id,name) 
values(5,'Nha o');
create table Product
(
	id int auto_increment primary key, -- mã sản phẩm
    cate int not null, -- mã loại sản phẩm
    name nvarchar(50) not null, -- tên sản phẩm
    brand nvarchar(50) not null, -- Thương hiệu
    images nvarchar(200) not null, -- hình ảnh
    status bit default 0, -- 0 là hết 1 là có hàng
    price int not null check(price>0), -- giá
    discount int default 0, -- giảm giá
    constraint p_fk foreign key (cate) references ProductCategories(id)	
);
-- insert product
insert into Product(id,cate,name,brand,images,status,price) 
values(1,1,'Thuc an cho cho','PRO PAC','hinh.jpg',1,445000);
insert into Product(id,cate,name,brand,images,status,price) 
values(2,2,'Quan ao cho cho','PRO PAC','hinh.jpg',1,32000);
insert into Product(id,cate,name,brand,images,status,price)  
values(3,3,'Vat dung an uong','PRO PAC','hinh.jpg',1,300000);
insert into Product(id,cate,name,brand,images,status,price) 
values(4,4,'Do choi cho cho','PRO PAC','hinh.jpg',1,200000);
insert into Product(id,cate,name,brand,images,status,price) 
values(5,5,'Nha o cho co','Ferplast Atlas','hinh.jpg',1,400000);
insert into Product(id,cate,name,brand,images,status,price) 
values(6,1,'Thuc an cho meo','Hagen Catit','hinh.jpg',1,120000);
insert into Product(id,cate,name,brand,images,status,price) 
values(7,2,'Quan ao cho meo','Hagen Catit','hinh.jpg',1,320000);
insert into Product(id,cate,name,brand,images,status,price) 
values(8,3,'Vat dung an uong  cho meo','Hagen Catit','hinh.jpg',1,255000);
insert into Product(id,cate,name,brand,images,status,price) 
values(9,4,'Do choi cho meo','Hagen Catit','hinh.jpg',1,600000);
insert into Product(id,cate,name,brand,images,status,price) 
values(10,5,'Nha o cho meo','Hagen Catit','hinh.jpg',1,250000);
insert into Product(id,cate,name,brand,images,status,price) 
values(11,1,'Thuc an cho chuot','Hagen','hinh.jpg',1,30000);
insert into Product(id,cate,name,brand,images,status,price) 
values(12,2,'vat dung an uong cho chuot','Hagen','hinh.jpg',1,40000);
insert into Product(id,cate,name,brand,images,status,price) 
values(13,3,'Dung cu ve sinh','Hagen','hinh.jpg',1,35000);
insert into Product(id,cate,name,brand,images,status,price) 
values(14,4,'Chuong Hamster','Hagen','hinh.jpg',1,300000);
insert into Product(id,cate,name,brand,images,status,price) 
values(15,5,'Do choi Hamster','Hagen','hinh.jpg',1,60000);

create table ProductDetail
(
	idproduct int primary key, -- mã sản phẩm
    height int default 0, -- cao
    width int default 0, -- ngang
    length int default 0, -- rộng
    typeofpet nvarchar(100) default 'Mọi loại pet', -- loại pet
	stage nvarchar(100) default 'Mọi độ tuổi', -- giải đoạn như còn bé, trường thành, già
    description nvarchar(200), -- mô tả
    constraint pd_fk foreign key (idproduct) references Product(id)
);
insert into ProductDetail (idproduct,description) values (1,"Là loại thức ăn tốt nhất dành cho chó hiện nay ở trên thị trường Việt Nam và toàn thế giới. Với những công
thức được kiểm tra và đo lường kỹ càng. Sẽ đảm bảo sức khỏe cho chú chó của bạn khi bạn dùng sản phẩm này.");
insert into ProductDetail (idproduct,height,width,length,description) values (2,
50,60,50,"Loại quần áo thịnh hành với những chú chó hiện nay. Đem lại sự tươi mới cho chú chó của bạn.");
insert into ProductDetail (idproduct,description) values (3,"Được làm từ nguyên vật liệu không gây hại cho chú chó của bạn. Có nhiều loại hình màu sắc khác nhau
để bạn có thể có nhiều lựa chọn cho chú chó của mình");
insert into ProductDetail (idproduct,description) values (4,"Đem lại cảm giác mới lạ cho chú chó của bạn. Thay bạn chơi với chúng khi bạn bận.");
insert into ProductDetail (idproduct,height,width,length,description) values (5,100,100,100,"Được làm từ loại thép vững chắc không lo chú chó
của bạn bị xổng ra lúc bạn đi vắng. Không gian đủ rộng để chú chó thoải mái chơi đùa");
insert into ProductDetail (idproduct,description) values (6,"Là loại thức ăn tốt nhất dành cho mèo hiện nay ở trên thị trường Việt Nam và toàn thế giới. Với những công
thức được kiểm tra và đo lường kỹ càng. Sẽ đảm bảo sức khỏe cho chú mèo của bạn khi bạn dùng sản phẩm này.");
insert into ProductDetail (idproduct,height,width,length,description) values (7,
20,30,30,"Loại quần áo thịnh hành với những chú mèo hiện nay. Đem lại sự tươi mới cho chú mèo của bạn.");
insert into ProductDetail (idproduct,description) values (8,"Được làm từ nguyên vật liệu không gây hại cho chú mèo của bạn. Có nhiều loại hình màu sắc khác nhau
để bạn có thể có nhiều lựa chọn cho chú mèo của mình");
insert into ProductDetail (idproduct,description) values (9,"Giúp mèo giải tỏa stress, có nhiều sản phẩm giúp mèo tự chơi hoặc mài móng. Giúp bạn có thể yên tâm mỗi khi ra ngoài.");
insert into ProductDetail (idproduct,height,width,length,description) values (10,40,40,40,"Sản phẩm có nhiều kích cỡ màu sắc khác nhau. Có nhiều sản phẩm đem lại cảm giác hoàn toàn mới lạ
cho chú mèo của bạn");
insert into ProductDetail (idproduct,description) values (11,"Thức ăn được trộn từ các loại hoa quả tự nhiên thêm các loại hạt đem lại sức khỏe tốt cho chú chuột của bạn");
insert into ProductDetail (idproduct,description) values (12,"Những thứ cần thiết để giúp chuột ăn uống");
insert into ProductDetail (idproduct,description) values (13,"Những thứ cần thiết để giúp chuột vệ sinh, giúp chuột tăng sức đề kháng và sạch sẽ thơm tho hơn.");
insert into ProductDetail (idproduct,height,width,length,description) values (14,20,15,15,"Để tránh cho chú chuột chạy lung tung. Bên trong ngôi nhà còn được trang bị đủ 
mọi thứ cần thiết cho chú chuột của bạn vui chơi.");
insert into ProductDetail (idproduct,description) values (15,"Dụng cụ giúp chuột giảm béo");
-- Bill-----------------------
create table Bill
(
	id int auto_increment primary key, -- mã hoá đơn
	date date NOT NULL default now(), -- ngày xuất hoá đơn
	   username varchar(20) not null, -- người mua hàng
	status int not null default 0,-- 0 Là đang chờ xử lý, 1 là đang chuyển hàng, 2 là đã nhận hàng và thanh toán
	totalprice int default 0, -- tổng tiền
    constraint b_fk foreign key (   username) references Account(   username)
);
-- insert Bill
insert into Bill (username) values("chauxinhgai");
insert into Bill (username) values("minhdeptrai");
insert into Bill (username) values("thinhdeptrai");
insert into Bill (username) values("phongdeptrai");
insert into Bill (username) values("hoangdeptrai");
create table BillInfo
(
	id int auto_increment primary key, -- mã hoá đơn chi tiết
	idBill int NOT NULL, -- mã hoá đơn
	idproduct int NOT NULL, -- mã sản phẩm
	CountItem int NOT NULL default 0, -- số lượng sản phẩm
    price int default 0, -- giá
    constraint bi_b_fk foreign key (idBill) references Bill(id),
    constraint bi_p_fk foreign key (idproduct) references Product(id)
);
-- insert BillInfo
insert into BillInfo (idBill,idproduct,price) values(1,1,"445000");
insert into BillInfo (idBill,idproduct,price) values(1,2,"32000");
insert into BillInfo (idBill,idproduct,price) values(1,3,"300000");
insert into BillInfo (idBill,idproduct,price) values(1,4,"200000");
insert into BillInfo (idBill,idproduct,price) values(1,5,"400000");
---
insert into BillInfo (idBill,idproduct,price) values(2,2,"32000");
insert into BillInfo (idBill,idproduct,price) values(2,1,"32000");
insert into BillInfo (idBill,idproduct,price) values(2,3,"300000");
insert into BillInfo (idBill,idproduct,price) values(2,4,"200000");
insert into BillInfo (idBill,idproduct,price) values(2,5,"400000");
------
insert into BillInfo (idBill,idproduct,price) values(3,3,"300000");
insert into BillInfo (idBill,idproduct,price) values(3,6,"120000");
insert into BillInfo (idBill,idproduct,price) values(3,7,"320000");
insert into BillInfo (idBill,idproduct,price) values(3,8,"255000");
insert into BillInfo (idBill,idproduct,price) values(3,10,"250000");
-----------
insert into BillInfo (idBill,idproduct,price) values(4,4,"200000");
insert into BillInfo (idBill,idproduct,price) values(5,5,"400000");
insert into BillInfo (idBill,idproduct,price) values(1,6,"120000");
insert into BillInfo (idBill,idproduct,price) values(2,7,"320000");
insert into BillInfo (idBill,idproduct,price) values(3,8,"600000");
insert into BillInfo (idBill,idproduct,price) values(4,9,"255000");
insert into BillInfo (idBill,idproduct,price) values(5,10,"600000");
-- Service--------------------
create table ServiceCategories
(
	id int auto_increment primary key, -- mã loại
    name nvarchar(50) not  null -- tên loại
);
-- insert serviceCategories
insert into ServiceCategories(   id,  name   )
values(1,'Dich vu tiem phong'   );
insert into ServiceCategories(   id,  name   )
values(2,'Dich vu triet san'   );
insert into ServiceCategories(   id,  name   )
values(3,'Dich vu giu thu cung'   );
insert into ServiceCategories(   id,  name   )
values(4,'Dich vu tam thu cung'   );
insert into ServiceCategories(   id,  name   )
values(5,'Dich vu lay rai tai'   );
insert into ServiceCategories(   id,  name   )
values(6,'Dich vu tia  long'   );
insert into ServiceCategories(   id,  name   )
values(7,'Dich vu huan luyen'   );
insert into ServiceCategories(   id,  name   )
values(8,'Dich vu kham tong qua'   );
insert into ServiceCategories(   id,  name   )
values(9,'Dich vu cham soc tai nha'   );
insert into ServiceCategories(   id,  name   )
values(10,'Dich vu ghep doi'   );

create table Services
(
	id int auto_increment primary key, -- mã dịch vụ
    name nvarchar(50) not null, -- tên dịch vụ
    cate int not null, -- mã loại dịch vụ
    price int not null default 0, -- giá dịch vụ
    images nvarchar(200) not null, -- Hình dịch vụ
    status bit default 1,-- trạng thái 0 là ngừng phục vụ 1 là có phục vụ
    description nvarchar(200), -- mô tả dịch vụ
    discount int default 0, -- giảm giá
    constraint s_sc_fk foreign key (cate) references ServiceCategories(id)
);
-- insert sever
insert into Services(id,name,cate,price,images,status,description   ) 
values ('  01','Dich vu tiem phong',1,150000,'Hinh.jpg',1,'Tiêm vacxin cho vật nuôi, thú cưng chính là giải pháp ngăn ngừa bệnh vô cùng an toàn lại hiệu quả. Những chú chó, mèo, thú cưng được tiêm phòng vacxin chắc chắn sẽ có sức đề kháng cao hơn, có khả năng chống lại những loại virus, vi khuẩn gây bệnh thường gặp. Từ đó, thú cưng của bạn sẽ có một sức khỏe tốt hơn, phát triển tốt hơn cả về thể chất và ngoại hình.');
insert into Services(id,name,cate,price,images,status,description   ) 
values ('  02','Dich vu triet san',2,400000,'Hinh.jpg',1,'Triệt sản cho vật nuôi, chó mèo chính xác là một cuộc phẫu thuật cần có độ chính xác cao. Bởi chỉ cần sơ xuất, rất có thế thú cưng của bạn sẽ gặp phải nguy hiểm. Trước khi làm phẫu thuật triệt sản cho thú cưng, bạn và bác sĩ thú y phải có sự chuẩn bị vô cùng kỹ lưỡng. Quy trình triệt sản cũng cần phải thực hiện một cách chính xác, an toàn. Chính vì vậy, việc triệt sản cho thú cưng tại các phòng khám, bệnh viện thú y là vô cùng cần thiết.
');
insert into Services(id,name,cate,price,images,status,description   ) 
values ('  03','Dich vu giu thu cung',3,200000,'Hinh.jpg',1,'Bạn đang chuẩn bị một chuyến đi công tác vài ngày? Hay cả gia đình bạn chuẩn bị đi du lịch, bạn lo lắng không có ai chăm sóc cho thú cưng của bạn? Bạn rất muốn dẫn chúng đi theo những điều kiện ra xôi không cho phép bạn làm điều đó. Hãy để dịch vụ giữ thú cưng của 
chúng tôi sẽ giúp đỡ bạn.');
insert into Services(id,name,cate,price,images,status,description   ) 
values ('  04','Dich vu tam thu cung',4,40000,'Hinh.jpg',1,'Để thú cưng phát triển được khỏe mạnh thì việc tắm thường xuyên cho chúng là điều bạn không thể bỏ qua. Không chỉ để loại bỏ bụi bẩn bám trên da hoặc lông, việc tắm, chải lông đúng cách còn giúp thú cưng gọn gàng hơn, xinh đẹp hơn và thẩm mỹ hơn.
');
insert into Services(id,name,cate,price,images,status,description   ) 
values ('  05','Dich vu lay rai tai',5,50000,'Hinh.jpg',1,'Cạo  lông lỗ tai với bột chuyên biệt giúp các bé không bị đau, lấy ráy tai và vệ sinh tai');
insert into Services(id,name,cate,price,images,status,description   ) 
values ('  06','Dich vu tia long',6,60000,'Hinh.jpg',1,'Thú cưng của bạn sẽ trở nên đang yêu hơn với dịch vụ cắt và tạo kiểu tóc đẹp tại Pet Shop');
insert into Services(id,name,cate,price,images,status,description   ) 
values ('  07','Dich vu huan luyen',7,800000,'Hinh.jpg',1,'Nuôi thú  cưng không đơn giản chỉ là chú chó/mèo đó sẽ sống ở nhà bạn, mà là bạn cần dành thời gian, công sức và tiền bạc của bản thân để quan tâm, chăm sóc cho bé cưng.');
insert into Services(id,name,cate,price,images,status,description   ) 
values ('  08','Dich vu kham tong quat',8,300000,'Hinh.jpg',1,'Bác sĩ thú y của chúng tôi sẽ muốn kiểm tra con mèo của bạn kỹ lưỡng ít nhất một lần một năm và thường xuyên hơn khi chúng già đi hoặc nếu chúng có nhu cầu y tế đặc biệt. Cuộc hẹn này sẽ có một cách tiếp cận toàn diện, đảm bảo con mèo của bạn được kiểm tra từ râu của chúng đến chóp đuôi của chúng.
');	
insert into Services(id,name,cate,price,images,status,description   ) 
values ('  09','Dich vu cham soc tai nha',9,700000,'Hinh.jpg',1,'Là dịch vụ mà các Nhân viên chăm sóc thú cưng (Pet Sitter) sẽ đến chăm sóc thú cưng tại nhà của bạn.
Nếu thú cưng của bạn có nhút nhát và tập tính lãnh thổ cao thì đây là dịch vụ phù hợp nhất dành cho thú cưng của bạn. Môi trường sống không bị thay đổi giúp chúng thoải mái và không bị căng thẳng.');
insert into Services(id,name,cate,price,images,status,description   ) 
values ('  10','Dich vu ghep doi',10,300000,'Hinh.jpg',1,'Ở đây chúng tôi không làm thế');
-- Blog-----------------------
create table BlogCategories
(
	id int auto_increment primary key, -- mã loại blog
	name nvarchar(50) not null -- tên loại blog
);
-- inser blogcategories
insert into BlogCategories(id,name) 
values(1,'Blog ve cho');
insert into BlogCategories(id,name) 
values(2,'Blog ve meo');
insert into BlogCategories(id,name) 
values(3,'Blog ve Hamster');
Create table Blog
(
	id int auto_increment primary key, -- mã bog
	cate int not null,-- mã loại blog
	title nvarchar(50) not null, -- tiêu đề
	datepost Datetime default NOW(), -- ngày đăng
	   username varchar(20) not null,-- tài khoản đăng
	images nvarchar(100) not null, -- hình ảnh
	content nvarchar(2000) not null, -- nội dung
	constraint b_bc_fk foreign key (cate) references BlogCategories(id),
    constraint b_ac_fk foreign key (   username) references Account(   username)
);
-- insert blog
insert into Blog(id,cate,title,   username,images,content) 
values(1,1,'Cach cham soc cho poodle sau ShopShopBlogsinh','hoangdeptrai','hinh.jpg','Test');
insert into Blog(id,cate,title,   username,images,content) 
values(2,1,'Thoi diem nao thi can sieu am cho mang thai','hoangdeptrai','hinh.jpg','Test');
insert into Blog(id,cate,title,   username,images,content) 
values(3,1,'Cach dieu tri benh ung thu mui o cho','hoangdeptrai','hinh.jpg','Test');
insert into Blog(id,cate,title,   username,images,content) 
values(4,1,'Cho bi ho khi van dong manh','hoangdeptrai','hinh.jpg','Test');
insert into Blog(id,cate,title,   username,images,content) 
values(5,1,'Cho corgi: nhung dieu thu vi ve chung','hoangdeptrai','hinh.jpg','Test');
insert into Blog(id,cate,title,   username,images,content) 
values(6,1,'Nhung dieu can biet khi thien cho duc','hoangdeptrai','hinh.jpg','Test');
insert into Blog(id,cate,title,   username,images,content) 
values(7,1,'Cho chihuahua: nhung su that dang ngac nhien','hoangdeptrai','hinh.jpg','Test');
insert into Blog(id,cate,title,   username,images,content) 
values(8,1,'Cho bichon: nhung dieu ma ban chua tung duoc biet','hoangdeptrai','hinh.jpg','Test');
insert into Blog(id,cate,title,username,images,content) 
values(9,1,'Shiba-inu chu co den tu xu phu tang','hoangdeptrai','hinh.jpg','Test');
insert into Blog(id,cate,title,username,images,content) 
values(10,1,'Poodle co bao nhieu loaij khac nhau','hoangdeptrai','hinh.jpg','Test');
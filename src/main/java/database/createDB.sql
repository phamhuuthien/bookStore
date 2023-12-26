

create database ecommerce_bookStore;

use ecommerce_bookStore;

select * from Books limit 0,5

-- cretae author  
create table Author(
	authorId varchar(255) primary key,
    authorName varchar(255),
    authorDes varchar(255),
    authorDate date
);
insert into Author(authorId,authorName,authorDes,authorDate)
values ('2','a','abc','2003-08-26'),
('3','a','abc','2003-08-26'),
('4','a','abc','2003-08-26'),
('5','a','abc','2003-08-26'),
('6','a','abc','2003-08-26');

select * from author;

-- create  category
create table Category(
	code varchar(255) primary key,
    titleCategory varchar(255)
);

 
insert into Category(code,titleCategory)
values 
('RT6','Travel'),
('YM7',	'Mystery'),
('IHIF18',	'Historical Fiction'),
('ESRA14',	'Sequential Art'),
('HP10',	'Philosophy'),
('LC8',	'Classics'),
('OR7',	'Romance'),
('IF7',	'Fiction'),
('OWIF14',	'Womens Fiction'),
('HC9',	'Childrens'),
('ER8',	'Religion');

select * from Category


-- create users
create table Users(
	userId varchar(255) primary key ,
    fullName varchar(255),
    userName varchar(255),
    password varchar(255),
    sex varchar(255),
    dateOfBirth Date,
    address varchar(255),
    deliveryAddress varchar(255),
    email varchar(255),
    receiveEmail boolean
);
insert into Users(userId,fullName,userName,password,sex,dateOfBirth,address,deliveryAddress,email,receiveEmail) values
('2','a','b','1','a','2003-09-26','a','a','a',1),
('3','a','a','a','a','2003-09-26','a','a','a',1),
('4','a','1','1','a','2003-09-26','a','a','a',1)
select * from Users
ALTER TABLE Users
ADD role int;

SELECT * FROM Users WHERE userName='a' and password='a'

-- create pay

create table Pay(
	payId varchar(255) primary key,
    payMethods varchar(255)
);
insert into pay(payId,payMethods) values 
('1','thanh toán khi nhận hàng'),
('2','thanh toán online')
select * from pay


-- create books
create table Books(
	idBook varchar(255) primary key,
    title varchar(255),
    authorId varchar(255),
    publicYear varchar(10),
    price double,
    available int,
    description varchar(255),
    code varchar(255),
    fileName varchar(255),
    star double,
	foreign key (authorId) references Author(authorId),
    foreign key (code) references Category(code)
);

ALTER TABLE books MODIFY description text(4294967295  )

insert into Books(idBook,title,authorId,publicYear,price,available,description,code,filename,star) values 
('2','sdsd','1','2313',2,2,'dsad','RT6','dsd',2)


insert into Books(idBook,title,authorId,publicYear,price,available,description,code,filename,star) values 
('ce60436f52c5ee68','Full Moon over Noahg stupid.','1','2022',10,19,' Acclaimed travel writer Rick Antonson sets his adventurous compass on Mount Ararat, exploring the region’s long history, religious mysteries, and complex politics.Mount Ararat is the most fabled mountain in the world. For millennia this massif in eastern Turkey has been rumored as the resting place of Noah’s Ark following the Great Flood. But it also plays a significant ro Acclaimed travel writer Rick Antonson sets his adventurous compass on Mount Ararat, exploring the region’s long history, religious mysteries, and complex politics.Mount Ararat is the most fabled mountain in the world. For millennia this massif in eastern Turkey has been rumored as the resting place of Noah’s Ark following the Great Flood. But it also plays a significant role in the longstanding conflict between Turkey and Armenia.Author Rick Antonson joined a five-member expedition to the mountain’s nearly 17,000-foot summit, trekking alongside a contingent of Armenians, for whom Mount Ararat is the stolen symbol of their country. Antonson weaves vivid historical anecdote with unexpected travel vignettes, whether tracing earlier mountaineering attempts on the peak, recounting the genocide of Armenians and its unresolved debate, or depicting the Kurds’ ambitions for their own nation’s borders, which some say should include Mount Ararat.What unfolds in Full Moon Over Noah’s Ark is one man’s odyssey, a tale told through many stories. Starting with the flooding of the Black Sea in 5600 BCE, through to the Epic of Gilgamesh and the contrasting narratives of the Great Flood known to followers of the Judaic, Christian and Islamic religions, Full Moon Over Noah’s Ark takes readers along with Antonson through the shadows and broad landscapes of Turkey, Iraq, Iran and Armenia, shedding light on a troubled but fascinating area of the world.','RT6','https://books.toscrape.com/media/cache/jpg',4),

('f9705c362f070608','See America: A Celebration of Our National Parks & Treasured Sites','1','2022',10,19,'To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Fe To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Featuring artwork for 75 national parks and monuments across all 50 states, this engaging keepsake volume celebrates the full range of our nations landmarks and treasured wilderness To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Fe To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Featuring artwork for 75 national parks and monuments across all 50 states, this engaging keepsake volume celebrates the full range of our nation s landmarks and treasured wilderness','RT6','https://books.toscrape.com/media/cache/c7/1a/c71a85dbf8c2dbc75cb271026618477c.jpg',3),
('a22124811bfa8350','Its Only the Himalayas','1','2022',10,19,'“Wherever you go, whatever you do, just . . . don’t do anything stupid.” —My MotherDuring her yearlong adventure backpacking from South Africa to Singapore, S. Bedford definitely did a few things her mother might classify as \"stupid.\" She swam with great white sharks in South Africa, ran from lions in Zimbabwe, climbed a Himalayan mountain without training in Nepal, and wa “Wherever you go, whatever you do, just . . . don’t do anything stupid.” —My MotherDuring her yearlong adventure backpacking from South Africa to Singapore, S. Bedford definitely did a few things her mother might classify as \"stupid.\" She swam with great white sharks in South Africa, ran from lions in Zimbabwe, climbed a Himalayan mountain without training in Nepal, and watched as her friend was attacked by a monkey in Indonesia.But interspersed in those slightly more crazy moments, Sue Bedfored and her friend \"Sara the Stoic\" experienced the sights, sounds, life, and culture of fifteen countries. Joined along the way by a few friends and their aging fathers here and there, Sue and Sara experience the trip of a lifetime. They fall in love with the world, cultivate an appreciation for home, and discover who, or what, they want to become.Its Only the Himalayas is the incredibly funny, sometimes outlandish, always entertaining confession of a young backpacker that will inspire you to take your own adventure. ...more','RT6','https://books.toscrape.com/media/cache/6d/41/6d418a73cc7d4ecfd75ca11d854041db.jpg',2)



insert into Books(idBook,title,authorId,publicYear,price,available,description,code,filename,star) values 
('ce604fdsf52c5ee68','Full Moon over Noahg stupid.','1','2022',10,19,' Acclaimed travel writer Rick Antonson sets his adventurous compass on Mount Ararat, exploring the region’s long history, religious mysteries, and complex politics.Mount Ararat is the most fabled mountain in the world. For millennia this massif in eastern Turkey has been rumored as the resting place of Noah’s Ark following the Great Flood. But it also plays a significant ro Acclaimed travel writer Rick Antonson sets his adventurous compass on Mount Ararat, exploring the region’s long history, religious mysteries, and complex politics.Mount Ararat is the most fabled mountain in the world. For millennia this massif in eastern Turkey has been rumored as the resting place of Noah’s Ark following the Great Flood. But it also plays a significant role in the longstanding conflict between Turkey and Armenia.Author Rick Antonson joined a five-member expedition to the mountain’s nearly 17,000-foot summit, trekking alongside a contingent of Armenians, for whom Mount Ararat is the stolen symbol of their country. Antonson weaves vivid historical anecdote with unexpected travel vignettes, whether tracing earlier mountaineering attempts on the peak, recounting the genocide of Armenians and its unresolved debate, or depicting the Kurds’ ambitions for their own nation’s borders, which some say should include Mount Ararat.What unfolds in Full Moon Over Noah’s Ark is one man’s odyssey, a tale told through many stories. Starting with the flooding of the Black Sea in 5600 BCE, through to the Epic of Gilgamesh and the contrasting narratives of the Great Flood known to followers of the Judaic, Christian and Islamic religions, Full Moon Over Noah’s Ark takes readers along with Antonson through the shadows and broad landscapes of Turkey, Iraq, Iran and Armenia, shedding light on a troubled but fascinating area of the world.','RT6','https://books.toscrape.com/media/cache/jpg',4),
('f970fsfsdf362f070608','See America: A Celebration of Our National Parks & Treasured Sites','1','2022',10,19,'To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Fe To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Featuring artwork for 75 national parks and monuments across all 50 states, this engaging keepsake volume celebrates the full range of our nations landmarks and treasured wilderness To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Fe To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Featuring artwork for 75 national parks and monuments across all 50 states, this engaging keepsake volume celebrates the full range of our nation s landmarks and treasured wilderness','RT6','https://books.toscrape.com/media/cache/c7/1a/c71a85dbf8c2dbc75cb271026618477c.jpg',3),
('a2212481asdsa4234350','Its Only the Himalayas','1','2022',10,19,'“Wherever you go, whatever you do, just . . . don’t do anything stupid.” —My MotherDuring her yearlong adventure backpacking from South Africa to Singapore, S. Bedford definitely did a few things her mother might classify as \"stupid.\" She swam with great white sharks in South Africa, ran from lions in Zimbabwe, climbed a Himalayan mountain without training in Nepal, and wa “Wherever you go, whatever you do, just . . . don’t do anything stupid.” —My MotherDuring her yearlong adventure backpacking from South Africa to Singapore, S. Bedford definitely did a few things her mother might classify as \"stupid.\" She swam with great white sharks in South Africa, ran from lions in Zimbabwe, climbed a Himalayan mountain without training in Nepal, and watched as her friend was attacked by a monkey in Indonesia.But interspersed in those slightly more crazy moments, Sue Bedfored and her friend \"Sara the Stoic\" experienced the sights, sounds, life, and culture of fifteen countries. Joined along the way by a few friends and their aging fathers here and there, Sue and Sara experience the trip of a lifetime. They fall in love with the world, cultivate an appreciation for home, and discover who, or what, they want to become.Its Only the Himalayas is the incredibly funny, sometimes outlandish, always entertaining confession of a young backpacker that will inspire you to take your own adventure. ...more','RT6','https://books.toscrape.com/media/cache/6d/41/6d418a73cc7d4ecfd75ca11d854041db.jpg',2),
('ce604334324352c5ee68','Full Moon over Noahg stupid.','1','2022',10,19,' Acclaimed travel writer Rick Antonson sets his adventurous compass on Mount Ararat, exploring the region’s long history, religious mysteries, and complex politics.Mount Ararat is the most fabled mountain in the world. For millennia this massif in eastern Turkey has been rumored as the resting place of Noah’s Ark following the Great Flood. But it also plays a significant ro Acclaimed travel writer Rick Antonson sets his adventurous compass on Mount Ararat, exploring the region’s long history, religious mysteries, and complex politics.Mount Ararat is the most fabled mountain in the world. For millennia this massif in eastern Turkey has been rumored as the resting place of Noah’s Ark following the Great Flood. But it also plays a significant role in the longstanding conflict between Turkey and Armenia.Author Rick Antonson joined a five-member expedition to the mountain’s nearly 17,000-foot summit, trekking alongside a contingent of Armenians, for whom Mount Ararat is the stolen symbol of their country. Antonson weaves vivid historical anecdote with unexpected travel vignettes, whether tracing earlier mountaineering attempts on the peak, recounting the genocide of Armenians and its unresolved debate, or depicting the Kurds’ ambitions for their own nation’s borders, which some say should include Mount Ararat.What unfolds in Full Moon Over Noah’s Ark is one man’s odyssey, a tale told through many stories. Starting with the flooding of the Black Sea in 5600 BCE, through to the Epic of Gilgamesh and the contrasting narratives of the Great Flood known to followers of the Judaic, Christian and Islamic religions, Full Moon Over Noah’s Ark takes readers along with Antonson through the shadows and broad landscapes of Turkey, Iraq, Iran and Armenia, shedding light on a troubled but fascinating area of the world.','RT6','https://books.toscrape.com/media/cache/jpg',4),
('f9705hhjfdg70608','See America: A Celebration of Our National Parks & Treasured Sites','1','2022',10,19,'To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Fe To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Featuring artwork for 75 national parks and monuments across all 50 states, this engaging keepsake volume celebrates the full range of our nations landmarks and treasured wilderness To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Fe To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Featuring artwork for 75 national parks and monuments across all 50 states, this engaging keepsake volume celebrates the full range of our nation s landmarks and treasured wilderness','RT6','https://books.toscrape.com/media/cache/c7/1a/c71a85dbf8c2dbc75cb271026618477c.jpg',3),
('a221asdasd11bfa8350','Its Only the Himalayas','1','2022',10,19,'“Wherever you go, whatever you do, just . . . don’t do anything stupid.” —My MotherDuring her yearlong adventure backpacking from South Africa to Singapore, S. Bedford definitely did a few things her mother might classify as \"stupid.\" She swam with great white sharks in South Africa, ran from lions in Zimbabwe, climbed a Himalayan mountain without training in Nepal, and wa “Wherever you go, whatever you do, just . . . don’t do anything stupid.” —My MotherDuring her yearlong adventure backpacking from South Africa to Singapore, S. Bedford definitely did a few things her mother might classify as \"stupid.\" She swam with great white sharks in South Africa, ran from lions in Zimbabwe, climbed a Himalayan mountain without training in Nepal, and watched as her friend was attacked by a monkey in Indonesia.But interspersed in those slightly more crazy moments, Sue Bedfored and her friend \"Sara the Stoic\" experienced the sights, sounds, life, and culture of fifteen countries. Joined along the way by a few friends and their aging fathers here and there, Sue and Sara experience the trip of a lifetime. They fall in love with the world, cultivate an appreciation for home, and discover who, or what, they want to become.Its Only the Himalayas is the incredibly funny, sometimes outlandish, always entertaining confession of a young backpacker that will inspire you to take your own adventure. ...more','RT6','https://books.toscrape.com/media/cache/6d/41/6d418a73cc7d4ecfd75ca11d854041db.jpg',2),
('ce60436jhjfghc5ee68','Full Moon over Noahg stupid.','1','2022',10,19,' Acclaimed travel writer Rick Antonson sets his adventurous compass on Mount Ararat, exploring the region’s long history, religious mysteries, and complex politics.Mount Ararat is the most fabled mountain in the world. For millennia this massif in eastern Turkey has been rumored as the resting place of Noah’s Ark following the Great Flood. But it also plays a significant ro Acclaimed travel writer Rick Antonson sets his adventurous compass on Mount Ararat, exploring the region’s long history, religious mysteries, and complex politics.Mount Ararat is the most fabled mountain in the world. For millennia this massif in eastern Turkey has been rumored as the resting place of Noah’s Ark following the Great Flood. But it also plays a significant role in the longstanding conflict between Turkey and Armenia.Author Rick Antonson joined a five-member expedition to the mountain’s nearly 17,000-foot summit, trekking alongside a contingent of Armenians, for whom Mount Ararat is the stolen symbol of their country. Antonson weaves vivid historical anecdote with unexpected travel vignettes, whether tracing earlier mountaineering attempts on the peak, recounting the genocide of Armenians and its unresolved debate, or depicting the Kurds’ ambitions for their own nation’s borders, which some say should include Mount Ararat.What unfolds in Full Moon Over Noah’s Ark is one man’s odyssey, a tale told through many stories. Starting with the flooding of the Black Sea in 5600 BCE, through to the Epic of Gilgamesh and the contrasting narratives of the Great Flood known to followers of the Judaic, Christian and Islamic religions, Full Moon Over Noah’s Ark takes readers along with Antonson through the shadows and broad landscapes of Turkey, Iraq, Iran and Armenia, shedding light on a troubled but fascinating area of the world.','RT6','https://books.toscrape.com/media/cache/jpg',4),
('f97054324362f070608','See America: A Celebration of Our National Parks & Treasured Sites','1','2022',10,19,'To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Fe To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Featuring artwork for 75 national parks and monuments across all 50 states, this engaging keepsake volume celebrates the full range of our nations landmarks and treasured wilderness To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Fe To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Featuring artwork for 75 national parks and monuments across all 50 states, this engaging keepsake volume celebrates the full range of our nation s landmarks and treasured wilderness','RT6','https://books.toscrape.com/media/cache/c7/1a/c71a85dbf8c2dbc75cb271026618477c.jpg',3),
('a22124sdfsdfbfa8350','Its Only the Himalayas','1','2022',10,19,'“Wherever you go, whatever you do, just . . . don’t do anything stupid.” —My MotherDuring her yearlong adventure backpacking from South Africa to Singapore, S. Bedford definitely did a few things her mother might classify as \"stupid.\" She swam with great white sharks in South Africa, ran from lions in Zimbabwe, climbed a Himalayan mountain without training in Nepal, and wa “Wherever you go, whatever you do, just . . . don’t do anything stupid.” —My MotherDuring her yearlong adventure backpacking from South Africa to Singapore, S. Bedford definitely did a few things her mother might classify as \"stupid.\" She swam with great white sharks in South Africa, ran from lions in Zimbabwe, climbed a Himalayan mountain without training in Nepal, and watched as her friend was attacked by a monkey in Indonesia.But interspersed in those slightly more crazy moments, Sue Bedfored and her friend \"Sara the Stoic\" experienced the sights, sounds, life, and culture of fifteen countries. Joined along the way by a few friends and their aging fathers here and there, Sue and Sara experience the trip of a lifetime. They fall in love with the world, cultivate an appreciation for home, and discover who, or what, they want to become.Its Only the Himalayas is the incredibly funny, sometimes outlandish, always entertaining confession of a young backpacker that will inspire you to take your own adventure. ...more','RT6','https://books.toscrape.com/media/cache/6d/41/6d418a73cc7d4ecfd75ca11d854041db.jpg',2),
('ce604bfdgfd2c5ee68','Full Moon over Noahg stupid.','1','2022',10,19,' Acclaimed travel writer Rick Antonson sets his adventurous compass on Mount Ararat, exploring the region’s long history, religious mysteries, and complex politics.Mount Ararat is the most fabled mountain in the world. For millennia this massif in eastern Turkey has been rumored as the resting place of Noah’s Ark following the Great Flood. But it also plays a significant ro Acclaimed travel writer Rick Antonson sets his adventurous compass on Mount Ararat, exploring the region’s long history, religious mysteries, and complex politics.Mount Ararat is the most fabled mountain in the world. For millennia this massif in eastern Turkey has been rumored as the resting place of Noah’s Ark following the Great Flood. But it also plays a significant role in the longstanding conflict between Turkey and Armenia.Author Rick Antonson joined a five-member expedition to the mountain’s nearly 17,000-foot summit, trekking alongside a contingent of Armenians, for whom Mount Ararat is the stolen symbol of their country. Antonson weaves vivid historical anecdote with unexpected travel vignettes, whether tracing earlier mountaineering attempts on the peak, recounting the genocide of Armenians and its unresolved debate, or depicting the Kurds’ ambitions for their own nation’s borders, which some say should include Mount Ararat.What unfolds in Full Moon Over Noah’s Ark is one man’s odyssey, a tale told through many stories. Starting with the flooding of the Black Sea in 5600 BCE, through to the Epic of Gilgamesh and the contrasting narratives of the Great Flood known to followers of the Judaic, Christian and Islamic religions, Full Moon Over Noah’s Ark takes readers along with Antonson through the shadows and broad landscapes of Turkey, Iraq, Iran and Armenia, shedding light on a troubled but fascinating area of the world.','RT6','https://books.toscrape.com/media/cache/jpg',4),
('f97sdfsdf2f070608','See America: A Celebration of Our National Parks & Treasured Sites','1','2022',10,19,'To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Fe To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Featuring artwork for 75 national parks and monuments across all 50 states, this engaging keepsake volume celebrates the full range of our nations landmarks and treasured wilderness To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Fe To coincide with the 2016 centennial anniversary of the National Parks Service, the Creative Action Network has partnered with the National Parks Conservation Association to revive and reimagine the legacy of WPA travel posters. Artists from all over the world have participated in the creation of this new, crowdsourced collection of See America posters for a modern era. Featuring artwork for 75 national parks and monuments across all 50 states, this engaging keepsake volume celebrates the full range of our nation s landmarks and treasured wilderness','RT6','https://books.toscrape.com/media/cache/c7/1a/c71a85dbf8c2dbc75cb271026618477c.jpg',3),
('a22124811gjhmmn50','Its Only the Himalayas','1','2022',10,19,'“Wherever you go, whatever you do, just . . . don’t do anything stupid.” —My MotherDuring her yearlong adventure backpacking from South Africa to Singapore, S. Bedford definitely did a few things her mother might classify as \"stupid.\" She swam with great white sharks in South Africa, ran from lions in Zimbabwe, climbed a Himalayan mountain without training in Nepal, and wa “Wherever you go, whatever you do, just . . . don’t do anything stupid.” —My MotherDuring her yearlong adventure backpacking from South Africa to Singapore, S. Bedford definitely did a few things her mother might classify as \"stupid.\" She swam with great white sharks in South Africa, ran from lions in Zimbabwe, climbed a Himalayan mountain without training in Nepal, and watched as her friend was attacked by a monkey in Indonesia.But interspersed in those slightly more crazy moments, Sue Bedfored and her friend \"Sara the Stoic\" experienced the sights, sounds, life, and culture of fifteen countries. Joined along the way by a few friends and their aging fathers here and there, Sue and Sara experience the trip of a lifetime. They fall in love with the world, cultivate an appreciation for home, and discover who, or what, they want to become.Its Only the Himalayas is the incredibly funny, sometimes outlandish, always entertaining confession of a young backpacker that will inspire you to take your own adventure. ...more','RT6','https://books.toscrape.com/media/cache/6d/41/6d418a73cc7d4ecfd75ca11d854041db.jpg',2)

select * from Books 

	


-- create Order
create table Orders(
	orderId varchar(255) primary key,
    userId varchar(255),
    payId varchar(255),
    orderDate date,
    orderStatus varchar(255),
    orderDelivery date,
	foreign key (userId) references Users(userId),
    foreign key (payId) references Pay(payId)
);


create table Order_detail(
	order_detailId varchar(255) primary key,
    idBook varchar(255) ,
    orderId varchar(255) ,
    quality int ,
    price double ,
    discount double,
    VAT double,
    totalPrice double,
    foreign key (idBook) references Books(idBook),
    foreign key (orderId) references Orders(orderId)
);

create table cart (
	cartId varchar(255) primary key,
    userId varchar(255),
    idBook varchar(255),
    quantity int,
    foreign key (idBook) references Books(idBook),
    foreign key (userId) references users(userId)
)

insert into cart(cartId,userId,idBook,quantity) 



use ecommerce_bookstore
select * from orders
select * from order_detail 
select * from books where title ='1,000 Places to See Before You Die'
select * from category
select * from author
select * from users 
select * from pay
select * from cart
where cartId ="035eade0-fb64-4bee-bb0a-ad7953d2a8b1"


SELECT * FROM category where titleCategory="Travel"
 ALTER TABLE category
ADD description varchar(515);

select * from books
where code = "YM7" limit 0,3 



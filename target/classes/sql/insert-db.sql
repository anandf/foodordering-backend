insert into user(userName, password,email, phonenumber) values ('admin', 'admin', 'admin@frontlinedubai.com', '+919999999999');

insert into category(name, description) values ('Lunch', 'Lunch menu (Cut off time: 11:30 AM)');
insert into category(name, description) values('Dinner', 'Dinner menu (Cut off time: 7:30 PM)');

insert into cuisine(name,description) values ('Arabic' , 'Arabic menu');
insert into cuisine(name,description) values ('Continental' , 'Continental menu');
insert into cuisine(name,description) values ('Filipino' , 'Filipino menu');
insert into cuisine(name,description) values ('Indian' , 'Indian menu');
insert into cuisine(name,description) values ('South Indian' , 'South Indian menu');

insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (1,1,'Monday','Tabbouleh, Shish Tawook, Lamb Okra, Kabsa Rice, Arabic Bread, Banana');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (1,1,'Tuesday','Hummus, Grilled Lamb  w/ Rosemary Sauce, Chicken Mulokiya, Lemon Rice, Arabic Bread, Sweet');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (1,1,'Wednesday','Greek Salad, Samak Harra, Chicken Maklouba, Arabic Rice, Arabic Bread, Red Apple');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (1,1,'Thursday','Oriental Salad, Laham Ma Batatas, Fried Fish, Vermicelli Rice, Arabic Bread, Sweet');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (1,1,'Friday','N/A');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (1,1,'Saturday','N/A');

insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (2,1,'Monday','Roast Chicken,Saute Vegetable,Penne Carbonara,Bread Roll,Banana');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (2,1,'Tuesday','Ravioline Beef, Mashed Potato, Buttered Rice, Bread Roll, Apple Struddle');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (2,1,'Wednesday','Chicken Cordon Bleu, Ricotta Spinach, Spaghette Bolognese, Bread Roll, Orange');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (2,1,'Thursday','Grilled Beef With BBQ sauce, Butter Corn & Peas, Vegetable Lasagna, Bread Roll, Banana');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (2,1,'Friday','Fried Fish With Lemon Butter Sauce, Potato Lyonnaise, Tortellini Mushroom Sauce, Bread Roll, Banana');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (2,1,'Saturday','Sweet & Sour Fish, Saute Carrots, Fried Rice, Bread Roll, Pineapple Side Down');

insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (3,1,'Monday',' Kalderetang Manok, Chopsuey, Spring Roll, Plain Rice, Banana');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (3,1,'Tuesday','Chicken Adobo, Ginisang Upo, Plain Rice, Spring Roll, Sweet');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (3,1,'Wednesday','Chicken Afritada, Ginisang Monggo, Plain Rice, Spring Roll, Red Apple');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (3,1,'Thursday','Tinulang Manok, Ginisang Gulay, Spring Roll, Plain Rice, Sweet');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (3,1,'Friday','N/A');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (3,1,'Saturday','N/A');

insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (4,1,'Monday','Chicken Chettinad, Dum Alu, Dal Fry, Basmati Rice, Chapatti, Rasagula');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (4,1,'Tuesday','Chicken Malai Tikka, Bhendi Do Pyaza, Dal Tadka, Basmati Rice, Chapatti, Gulab Jamun');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (4,1,'Wednesday','Pepper Chicken, Butter Paneer, Methi Chole, Basmati Rice, Chapatti, Shahi Tukda');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (4,1,'Thursday','Mutton Masala, Aloo Gobi, Kadai Paneer, Basmati Rice, Chapatti, Rawa Keasri');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (4,1,'Friday','Palak Chicken, Bhendi Do Pyaza, Dal Tadka, Basmati Rice, Chapatti, Gulab Jamun');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (4,1,'Saturday','Pepper Chicken, Butter Paneer, Methi Chole, Basmati Rice, Chapatti, Vermicelli Kheer');

insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (5,1,'Monday','Chettinad Chicken, Avial, Moorucurry, Beans Thoran, Motta Rice, Rice Payasam');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (5,1,'Tuesday','Chicken Varutharacha Curry, Soya Masala, Tomato curry, Raw Banana Thoran, Ada Pradhaman, Motta Rice');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (5,1,'Wednesday','Chicken Pepper, Vegetable Khorma, Vendakka curry, Beet Root Thoran, Motta Rice, Parippu Payasam');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (5,1,'Thursday','Mutton Masala, Theyal, Pumpkin curry, Moong Dal Thoran, Motta Rice, Pal Ada Payasam');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (5,1,'Friday','Chicken Varutharacha Curry, Soya Masala, Tomato curry, Raw Banana Thoran, Gulab Jamun, Motta Rice');
insert into menu(cuisineId,categoryId,dayOfTheWeek,description) values (5,1,'Saturday','Chicken Pepper, Vegetable Khorma, Vendakka curry, Beet Root Thoran, Motta Rice, Vermicelli Payasam');
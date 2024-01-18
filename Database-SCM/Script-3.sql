
-- working in database flipazon

create table categories(
id serial primary key,
name varchar(20) not null unique,
description text not null,
created_at timestamp default current_timestamp
);

insert into categories(name,description) values
('Hardware','Amazing Hardware'),
('Clothing','Fashionable Clothing'),
('Appliances','Full Home Appliances'),
('Utilities','Some Amazing Utils For Home');

select * from categories ;


create table products(
id serial primary key,
name varchar(30) not null,
price float not null check(price > 0),
quantity int check(quantity > -1),
category_id int,
constraint foreign_pro_cat foreign key (category_id) references categories(id),
created_at timestamp default current_timestamp

);


insert into products(name,price,quantity,category_id) values
('Screw Driver',20,100,null),
('Levis Jeans',2000,340,2),
('Piegon Grinder',560,34,3),
('Iphone 14 Plus',86000,12,1),
('Zara Tshirt',4000,15,2),
('Tupperware Bottle',45,100,4);

select * from products;







select * from 
categories c inner join products p
on c.id = p.category_id;



select * from 
categories c ,products p  
where c.id = p.category_id;






--select *from 
--categories c left join products p
--on p.category_id  = c.id;


--select * from products 
--where category_id  is null;


--select *from 
--categories c right join products p
--on p.category_id  = c.id
--where p.category_id is null;




--select *from 
--categories c full join products p
--on p.category_id  = c.id;




create table customers(
id serial primary key,
name varchar(20) not null,
contact varchar(12) not null unique check(length(contact) = 10),
password varchar(20) not null,
created_at timestamp default current_timestamp
);

drop table customers;

insert into customers(name,contact,password) values
('Saurabh','5879887789','saurabh'),
('akash','6778544898','akash'),
('sampada','8745372645','sam');

select * from customers;



create table cartitems (
id serial primary key,
product_id int,
customer_id int,
constraint foreign_product_cart foreign key (product_id) references products(id),
constraint foreign_customer_cart foreign key (customer_id) references customers(id),
quantity int not null check(quantity > 0),
created_at timestamp default current_timestamp
);

select * from products;


insert into cartitems(product_id,customer_id,quantity) values
(2,3,2),
(4,3,4),
(7,4,2);

select * from cartitems;

select * from 
products p inner join cartitems ci
on p.id = ci.product_id
inner join customers c
on c.id = ci.customer_id
where c.name = 'Saurabh';


select * from products p , customers c,cartitems ci
where p.id = ci.product_id
and c.id = ci.customer_id;












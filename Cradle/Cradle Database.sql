

create database Cradle;
use Cradle;

CREATE TABLE `Counters` (
	`counterId` varchar(255) NOT NULL,
	`nextValue` int NOT NULL,
	`initialValue` varchar(255) NOT NULL,
	PRIMARY KEY (`counterId`)
);

insert into counters values ('customer', 100, 'CU');
insert into counters values ('customerAddress', 100, 'CA');
insert into counters values ('order', 100, 'ORD');
insert into counters values ('product', , 'PRD');
select * from Customer;

CREATE TABLE `Customer` (
	`customerId` varchar(255) NOT NULL,
	`firstName` varchar(255) NOT NULL,
	`lastName` varchar(255) NOT NULL,
	`emailId` varchar(255) NOT NULL UNIQUE,
	`mobileNo` varchar(255) NOT NULL UNIQUE,
	`password` varchar(255) NOT NULL,
	PRIMARY KEY (`customerId`)
);

CREATE TABLE `customerAddresses` (
	`addressId` varchar(255) NOT NULL,
	`customerId` varchar(255) NOT NULL,
	`completeAddress` varchar(255) NOT NULL,
	PRIMARY KEY (`addressId`)
);

ALTER TABLE `customerAddresses` ADD CONSTRAINT `customerAddresses_fk0` FOREIGN KEY (`customerId`) REFERENCES `Customer`(`customerId`);

CREATE TABLE `Products` (
	`productId` varchar(255) NOT NULL,
	`productName` varchar(255) NOT NULL,
	`imagePath` varchar(255) NOT NULL,
	PRIMARY KEY (`productId`)
);

insert into products values('PRD1001','Circular Cradle', '../images/Circular-Cradle.jpeg');
insert into products values('PRD1002','Circular Cradle With Cushion', '../images/Circular-Cradle-With-Cushion.jpeg');
insert into products values('PRD1003','Square Cradle', '../images/Square-Cradle.jpeg');

select * from products;
select * from productDetails;

CREATE TABLE `ProductDetails` (
	`productDetailsId` varchar(255) NOT NULL,
	`totalStock` int NOT NULL,
	`unitPrice` int NOT NULL,
	`totalPrice` int NOT NULL,
	`productId` varchar(255) NOT NULL,
	PRIMARY KEY (`productDetailsId`)
);

insert into productDetails values('PRDID1001', 100, 3000, 300000, 'PRD1001');
insert into productDetails values('PRDID1002', 100, 3500, 350000, 'PRD1002');
insert into productDetails values('PRDID1003', 100, 2000, 200000, 'PRD1003');

ALTER TABLE `ProductDetails` ADD CONSTRAINT `ProductDetails_fk0` FOREIGN KEY (`productId`) REFERENCES `Products`(`productId`);

CREATE TABLE `Orders` (
	`orderId` varchar(255) NOT NULL,
	`orderDate` DATE NOT NULL,
	`deliveryDate` DATE NOT NULL,
	`customerId` varchar(255) NOT NULL,
	PRIMARY KEY (`orderId`)
);

ALTER TABLE `Orders` ADD CONSTRAINT `Orders_fk0` FOREIGN KEY (`customerId`) REFERENCES `Customer`(`customerId`);

CREATE TABLE `OrderDetails` (
	`orderId` varchar(255) NOT NULL,
	`orderListId` varchar(255) NOT NULL,
	`productId` varchar(255) NOT NULL,
	`quantity` int NOT NULL,
	PRIMARY KEY (`orderId`)
);

ALTER TABLE `OrderDetails` ADD CONSTRAINT `OrderDetails_fk0` FOREIGN KEY (`orderId`) REFERENCES `Orders`(`orderId`);

ALTER TABLE `OrderDetails` ADD CONSTRAINT `OrderDetails_fk1` FOREIGN KEY (`orderListId`) REFERENCES `ordersList`(`orderListId`);

ALTER TABLE `OrderDetails` ADD CONSTRAINT `OrderDetails_fk2` FOREIGN KEY (`productId`) REFERENCES `ProductDetails`(`productId`);

CREATE TABLE `ordersList` (
	`orderListId` varchar(255) NOT NULL,
	`productId` varchar(255) NOT NULL,
	`quantity` int NOT NULL,
	`createdDate` DATE NOT NULL,
	PRIMARY KEY (`orderListId`)
);

ALTER TABLE `ordersList` ADD CONSTRAINT `ordersList_fk0` FOREIGN KEY (`productId`) REFERENCES `Products`(`productId`);


drop table ProductList;
drop table OrderDetails;
drop table Orders;
drop table productDetails;
drop table products;
drop table customerAddresses;
drop table customer;

select * from Orders;
select * from OrderDetails;









































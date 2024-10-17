CREATE DATABASE IF NOT EXISTS `product_directory` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `product_directory`;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
                           `id` INT NOT NULL AUTO_INCREMENT,
                           `brand` VARCHAR(30) DEFAULT NULL,
                           `category` VARCHAR(30) DEFAULT NULL,
                           `information` VARCHAR(400) DEFAULT NULL,
                           `price` FLOAT,
                           `stock` INT,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO `product` (`brand`, `category`, `information`, `price`, `stock`) VALUES
                                                                                 ('Apple', 'Mobile Phone', 'APPLE iPhone 13 128 GB Akıllı Telefon Starlight MLPG3TU/A', 39000, 10),
                                                                                 ('Apple', 'Laptop', 'APPLE MacBook Pro 14 inc M3 8CPU 10GPU 8GB 512GB Uzay Grisi MTL73TU/A', 60500, 5),
                                                                                 ('Samsung', 'Mobile Phone', 'SAMSUNG Galaxy A05S 4GB/128GB Akıllı Telefon Silver', 7200, 30),
                                                                                 ('Huawei', 'Mobile Phone', 'HUAWEI Pura 70 256 GB Akıllı Telefon Siyah', 38000, 28),
                                                                                 ('JBL', 'Headphone', 'JBL Tune 570BT Bluetooth Kulak Üstü Kulaklık Siyah', 1870, 30);

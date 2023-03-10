CREATE TABLE IF NOT EXISTS employee (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    role VARCHAR(20) DEFAULT 'ROLE_CUSTOMER',
    position VARCHAR(20) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    enabled BOOLEAN DEFAULT TRUE,
    CONSTRAINT unique_name_and_phone_number
        unique (username, phone_number)
);

INSERT INTO employee (username, password, first_name, last_name, role, position, phone_number)
VALUES ('admin', 'admin123', 'admin', 'admin', 'ROLE_EMPLOYEE', 'DIRECTOR', '+79876543210');

INSERT INTO employee (username, password, first_name, last_name, role, position, phone_number)
VALUES ('Ivan', 'Ivan123', 'Ivan', 'Ivanov', 'ROLE_EMPLOYEE', 'ADMINISTRATOR', '+79524823976');

INSERT INTO employee (username, password, first_name, last_name, role, position, phone_number)
VALUES ('Peter', 'Peter123', 'Peter', 'Petrov', 'ROLE_EMPLOYEE', 'SELLER', '+79723914852');

CREATE TABLE IF NOT EXISTS customer (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    role VARCHAR(20) DEFAULT 'ROLE_CUSTOMER',
    address VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    balance NUMERIC(4, 2),
    enabled BOOLEAN DEFAULT TRUE,
    CONSTRAINT unique_name_and_email
        unique (username, email)
);

INSERT INTO customer (username, password, first_name, last_name, role, address, email, enabled)
VALUES ('Inga', 'Inga123', 'Inga', 'Abdullina', 'ROLE_CUSTOMER', 'Санкт-Петербург, Кронверкский пр., 49, 197101', 'inga@gmail.com', true);

CREATE TABLE IF NOT EXISTS product (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(100) NOT NULL,
    colour VARCHAR(100) NOT NULL,
    size VARCHAR(100) NOT NULL,
    price DECIMAL NOT NULL,
    quantity INT NOT NULL,
    picture_url VARCHAR NOT NULL
);

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('футболка', 'CLOTHES', 'белый', 'S', 1050, 30, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('футболка', 'CLOTHES', 'белый', 'M', 1050, 30, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('футболка', 'CLOTHES', 'белый', 'L', 1050, 30, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('футболка', 'CLOTHES', 'черный', 'S', 1050, 30, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('футболка', 'CLOTHES', 'черный', 'M', 1050, 30, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('футболка', 'CLOTHES', 'черный', 'L', 1050, 30, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('майка', 'CLOTHES', 'черный', 'S', 1050, 30, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('майка', 'CLOTHES', 'черный', 'M', 1050, 30, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('майка', 'CLOTHES', 'черный', 'L', 1050, 30, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('майка', 'CLOTHES', 'черный', 'S', 1050, 30, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('майка', 'CLOTHES', 'черный', 'M', 1050, 30, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('майка', 'CLOTHES', 'черный', 'L', 1050, 30, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('лонгслив', 'CLOTHES', 'черный', 'S', 2500, 15, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('лонгслив', 'CLOTHES', 'черный', 'M', 2500, 15, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('лонгслив', 'CLOTHES', 'черный', 'L', 2500, 15, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('лонгслив', 'CLOTHES', 'белый', 'S', 2500, 15, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('лонгслив', 'CLOTHES', 'белый', 'M', 2500, 15, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('лонгслив', 'CLOTHES', 'белый', 'L', 2500, 15, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('лонгслив', 'CLOTHES', 'красный', 'S', 2500, 15, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('лонгслив', 'CLOTHES', 'красный', 'M', 2500, 15, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('лонгслив', 'CLOTHES', 'красный', 'L', 2500, 15, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('шорты', 'CLOTHES', 'черный', 'S', 2000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('шорты', 'CLOTHES', 'черный', 'M', 2000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('шорты', 'CLOTHES', 'черный', 'L', 2000, 10, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('брюки', 'CLOTHES', 'черный', 'S', 3000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('брюки', 'CLOTHES', 'черный', 'M', 3000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('брюки', 'CLOTHES', 'черный', 'L', 3000, 10, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('брюки', 'CLOTHES', 'красный', 'S', 3000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('брюки', 'CLOTHES', 'красный', 'M', 3000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('брюки', 'CLOTHES', 'красный', 'L', 3000, 10, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кроссовки', 'SHOES', 'черный', '39', 4000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кроссовки', 'SHOES', 'черный', '40', 4000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кроссовки', 'SHOES', 'черный', '41', 4000, 10, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кроссовки', 'SHOES', 'красный', '39', 4000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кроссовки', 'SHOES', 'красный', '40', 4000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кроссовки', 'SHOES', 'красный', '41', 4000, 10, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кроссовки', 'SHOES', 'синий', '39', 4000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кроссовки', 'SHOES', 'синий', '40', 4000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кроссовки', 'SHOES', 'синий', '41', 4000, 10, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кеды', 'SHOES', 'черный', '39', 3500, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кеды', 'SHOES', 'черный', '40', 3500, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кеды', 'SHOES', 'черный', '41', 3500, 10, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кеды', 'SHOES', 'красный', '39', 3500, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кеды', 'SHOES', 'красный', '40', 3500, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кеды', 'SHOES', 'красный', '41', 3500, 10, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кеды', 'SHOES', 'синий', '39', 3500, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кеды', 'SHOES', 'синий', '40', 3500, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('кеды', 'SHOES', 'синий', '41', 3500, 10, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('полуботинки', 'SHOES', 'черный', '39', 5000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('полуботинки', 'SHOES', 'черный', '40', 5000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('полуботинки', 'SHOES', 'черный', '41', 5000, 10, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('полуботинки', 'SHOES', 'красный', '39', 5000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('полуботинки', 'SHOES', 'красный', '40', 5000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('полуботинки', 'SHOES', 'красный', '41', 5000, 10, 'temp');

INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('полуботинки', 'SHOES', 'синий', '39', 5000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('полуботинки', 'SHOES', 'синий', '40', 5000, 10, 'temp');
INSERT INTO product (name, type, colour, size, price, quantity, picture_url) VALUES ('полуботинки', 'SHOES', 'синий', '41', 5000, 10, 'temp');

CREATE TABLE IF NOT EXISTS orders (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    final_cost DECIMAL NOT NULL,
    delivery_address VARCHAR(100) NOT NULL,
    created_time TIMESTAMP NOT NULL
);

CREATE TABLE order_product (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    product_amount INT NOT NULL DEFAULT 1
);



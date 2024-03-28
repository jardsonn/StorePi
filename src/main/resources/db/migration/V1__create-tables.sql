-- Table Address
CREATE TABLE IF NOT EXISTS Address
(
    id           BINARY(16) PRIMARY KEY ,
    street       VARCHAR(255) NOT NULL,
    number       VARCHAR(20)  NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    city         VARCHAR(100) NOT NULL,
    state        VARCHAR(100) NOT NULL,
    zip_code     VARCHAR(20)  NOT NULL
);

-- Table Phone
CREATE TABLE IF NOT EXISTS Phone
(
    id     BINARY(16) PRIMARY KEY ,
    number VARCHAR(20) NOT NULL
);

-- Table Category
CREATE TABLE IF NOT EXISTS Category
(
    id   BINARY(16) PRIMARY KEY ,
    name VARCHAR(100) NOT NULL
);

-- Table Brand
CREATE TABLE IF NOT EXISTS Brand
(
    id   BINARY(16) PRIMARY KEY ,
    name VARCHAR(100) NOT NULL
);

-- Table Product
CREATE TABLE IF NOT EXISTS Product
(
    id           BINARY(16) PRIMARY KEY ,
    name         VARCHAR(255)   NOT NULL,
    description  TEXT,
    category_id  BINARY(16),
    brand_id     BINARY(16),
    price        DECIMAL(10, 2) NOT NULL,
    stock        INT            NOT NULL,
    size         VARCHAR(20),
    color        VARCHAR(50),
    release_date DATE,
    FOREIGN KEY (category_id) REFERENCES Category (id),
    FOREIGN KEY (brand_id) REFERENCES Brand (id)
);

CREATE TABLE IF NOT EXISTS ProductImage
(
    id         BINARY(16) PRIMARY KEY ,
    product_id BINARY(16) NOT NULL,
    image_url  TEXT   NOT NULL,
    FOREIGN KEY (product_id) REFERENCES Product (id)
);

-- Table Rating
CREATE TABLE IF NOT EXISTS Rating
(
    id          BINARY(16) PRIMARY KEY ,
    product_id  BINARY(16),
    points      INT NOT NULL,
    comment     TEXT,
    rating_date DATE,
    FOREIGN KEY (product_id) REFERENCES Product (id)
);

-- Table Customer
CREATE TABLE IF NOT EXISTS Customer
(
    id         BINARY(16) PRIMARY KEY ,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    phone_id   BINARY(16),
    address_id BINARY(16),
    FOREIGN KEY (phone_id) REFERENCES Phone (id),
    FOREIGN KEY (address_id) REFERENCES Address (id)
);

-- Table Employee
CREATE TABLE IF NOT EXISTS Employee
(
    id            BINARY(16) PRIMARY KEY ,
    first_name    VARCHAR(255) NOT NULL,
    last_name     VARCHAR(255) NOT NULL,
    job_title     VARCHAR(100) NOT NULL,
    email         VARCHAR(255) NOT NULL UNIQUE,
    password      VARCHAR(255) NOT NULL,
    phone_id      BINARY(16),
    address_id    BINARY(16),
    hire_date     DATE,
    employee_type VARCHAR(50)
);

-- Table Order
CREATE TABLE IF NOT EXISTS `Order`
(
    id           BINARY(16) PRIMARY KEY ,
    customer_id  BINARY(16),
    order_date   DATE,
    status       VARCHAR(50),
    total_amount DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES Customer (id)
);

-- Table OrderItem
CREATE TABLE IF NOT EXISTS OrderItem
(
    id         BINARY(16) PRIMARY KEY ,
    order_id   BINARY(16),
    product_id BINARY(16),
    quantity   INT            NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES `Order` (id),
    FOREIGN KEY (product_id) REFERENCES Product (id)
);

-- Table ShoppingCart
CREATE TABLE IF NOT EXISTS ShoppingCart
(
    id            BINARY(16) PRIMARY KEY ,
    customer_id   BINARY(16),
    creation_date DATETIME,
    status        VARCHAR(50),
    FOREIGN KEY (customer_id) REFERENCES Customer (id)
);

-- Table ShoppingCartItem
CREATE TABLE IF NOT EXISTS ShoppingCartItem
(
    id         BINARY(16) PRIMARY KEY ,
    cart_id    BINARY(16),
    product_id BINARY(16),
    quantity   INT NOT NULL,
    FOREIGN KEY (cart_id) REFERENCES ShoppingCart (id),
    FOREIGN KEY (product_id) REFERENCES Product (id)
);

-- Table OrderHistory
CREATE TABLE IF NOT EXISTS OrderHistory
(
    id            BINARY(16) PRIMARY KEY ,
    order_id      BINARY(16),
    customer_id   BINARY(16),
    purchase_date DATE,
    order_status  VARCHAR(50),
    products      TEXT,
    FOREIGN KEY (order_id) REFERENCES `Order` (id),
    FOREIGN KEY (customer_id) REFERENCES Customer (id)
);

CREATE TABLE IF NOT EXISTS HistoricOrderProduct
(
    historic_order_id BINARY(16),
    product_id        BINARY(16),
    FOREIGN KEY (historic_order_id) REFERENCES OrderHistory (id),
    FOREIGN KEY (product_id) REFERENCES Product (id)
);
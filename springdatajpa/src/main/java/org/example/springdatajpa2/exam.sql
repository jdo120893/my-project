CREATE TABLE customers (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255),
                           email VARCHAR(255) UNIQUE,
                           age INT
);


CREATE TABLE orders (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        product VARCHAR(255),
                        date DATE,
                        customer_id BIGINT,

                        CONSTRAINT fk_order_customer
                            FOREIGN KEY (customer_id)
                                REFERENCES customers(id)
);
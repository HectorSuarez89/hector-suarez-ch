DROP TABLE IF EXISTS price;

CREATE TABLE price (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  price DECIMAL(20,2) NOT NULL,
  time TIMESTAMP DEFAULT NULL
);

CREATE TABLE gift_certificate
(
    id               int         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cert_name        varchar(45) NOT NULL,
    description      varchar(45),
    price            int         NOT NULL,
    create_date      varchar(45) NOT NULL,
    duration         int         NOT NULL,
    last_update_date varchar(45) NOT NULL
);
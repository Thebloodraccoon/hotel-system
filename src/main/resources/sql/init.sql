CREATE DATABASE HotelManagement;

USE HotelManagement;

-- Таблиця t_hotels (Готелі)
CREATE TABLE t_hotels
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50)  NOT NULL,
    address     VARCHAR(255) NOT NULL,
    contact_num VARCHAR(20)  NOT NULL UNIQUE,
    created_at  DATE         NOT NULL
);

-- Таблиця t_guests (Гості)
CREATE TABLE t_guests
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(50)  NOT NULL,
    email        VARCHAR(255) NOT NULL,
    phone_num    VARCHAR(40)  NOT NULL,
    passport_num VARCHAR(255) NOT NULL,
    hotel_id     INT          NOT NULL,
    FOREIGN KEY (hotel_id) REFERENCES t_hotels (id) ON DELETE CASCADE
);

-- Таблиця t_staff (Персонал)
CREATE TABLE t_user
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(255)        NOT NULL,
    email     VARCHAR(255) UNIQUE NOT NULL,
    phone_num VARCHAR(20)         NOT NULL,
    role      ENUM('ADMIN', 'EMPLOYEE') NOT NULL,
    password  VARCHAR(255)        NOT NULL,
    hotel_id  INT                 NOT NULL,
    FOREIGN KEY (hotel_id) REFERENCES t_hotels (id) ON DELETE CASCADE
);

-- Таблиця t_rooms (Номери)
CREATE TABLE t_rooms
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    occupied        BOOLEAN        NOT NULL,
    room_number     VARCHAR(10)    NOT NULL,
    type            ENUM ('SINGLE', 'DOUBLE', 'TWIN', 'SUITE', 'FAMILY', 'CONNECTING') NOT NULL,
    description     VARCHAR(255)   NOT NULL,
    price_per_night DECIMAL(10, 2) NOT NULL,
    capacity        INT            NOT NULL,
    hotel_id        INT            NOT NULL,
    FOREIGN KEY (hotel_id) REFERENCES t_hotels (id) ON DELETE CASCADE
);

-- Таблиця t_services (Послуги)
CREATE TABLE t_services
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50)    NOT NULL,
    description VARCHAR(255)   NOT NULL,
    category    ENUM('CONCIERGE', 'SPA', 'GYM', 'RESTAURANT', 'BAR', 'WIFI', 'PARKING', 'POOL') NOT NULL,
    price       DECIMAL(10, 2) NOT NULL,
    available   BOOLEAN        NOT NULL
);

-- Таблиця t_bookings (Бронювання)
CREATE TABLE t_bookings
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    check_in_date  DATE           NOT NULL,
    check_out_date DATE           NOT NULL,
    total_price    DECIMAL(10, 2) NOT NULL,
    room_id        INT            NOT NULL,
    guest_id       INT            NOT NULL,
    service_id     INT,
    FOREIGN KEY (guest_id) REFERENCES t_guests (id) ON DELETE CASCADE,
    FOREIGN KEY (room_id) REFERENCES t_rooms (id) ON DELETE CASCADE,
    FOREIGN KEY (service_id) REFERENCES t_services (id)
);

-- Таблиця t_payments (Оплати)
CREATE TABLE t_payments
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    total_sum      DECIMAL(10, 2) NOT NULL,
    payment_method VARCHAR(20)    NOT NULL CHECK (payment_method IN ('card', 'cash')),
    created_at     DATE           NOT NULL,
    booking_id     INT            NOT NULL,
    guest_id       INT            NOT NULL,
    FOREIGN KEY (booking_id) REFERENCES t_bookings (id) ON DELETE CASCADE,
    FOREIGN KEY (guest_id) REFERENCES t_guests (id) ON DELETE CASCADE
);

-- Таблиця t_payroll (Розрахунки з персоналом)
CREATE TABLE t_payroll
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    user_id     INT            NOT NULL,
    payment_date DATE           NOT NULL,
    amount       DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES t_user (id) ON DELETE CASCADE
);
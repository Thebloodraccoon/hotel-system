-- Вставка даних у таблицю t_hotels (Готелі)
INSERT INTO t_hotels (name, address, contact_num, created_at)
VALUES ('Hotel A', '123 Main St, City A', '123-456-7890', '2024-06-25');

-- Отримання ID вставленого готелю
SET @hotel_id = LAST_INSERT_ID();

-- Вставка даних у таблицю t_guests (Гості)
INSERT INTO t_guests (name, email, phone_num, passport_num, hotel_id)
VALUES ('John Doe', 'john.doe@example.com', '555-123-4567', 'ABC123456', @hotel_id),
       ('Jane Smith', 'jane.smith@example.com', '555-987-6543', 'XYZ789012', @hotel_id);

-- Вставка даних у таблицю t_staff (Персонал)
INSERT INTO t_user (name, email, phone_num, role, password, hotel_id)
VALUES ('Admin User', 'admin@example.com', '111-222-3333', 'ADMIN', 'adminpass', @hotel_id),
       ('Employee User', 'employee@example.com', '444-555-6666', 'EMPLOYEE', 'employeepass', @hotel_id);

-- Вставка даних у таблицю t_rooms (Номери)
INSERT INTO t_rooms (occupied, room_number, type, description, price_per_night, capacity, hotel_id)
VALUES (false, '101', 'SINGLE', 'Cozy single room with a view', 100.00, 1, @hotel_id),
       (false, '201', 'DOUBLE', 'Spacious double room with balcony', 150.00, 2, @hotel_id);

-- Вставка даних у таблицю t_services (Послуги)
INSERT INTO t_services (name, description, category, price, available)
VALUES ('Concierge Service', 'Personalized guest assistance', 'CONCIERGE', 50.00, true),
       ('Spa Treatment', 'Relaxing spa services', 'SPA', 100.00, true);

-- Отримання ID вставлених послуг
SET @service_id_1 = LAST_INSERT_ID() - 1;
SET @service_id_2 = LAST_INSERT_ID();

-- Вставка даних у таблицю t_bookings (Бронювання)
INSERT INTO t_bookings (check_in_date, check_out_date, total_price, room_id, guest_id, service_id)
VALUES ('2024-07-01', '2024-07-05', 500.00, 1, 1, @service_id_1),
       ('2024-07-02', '2024-07-06', 600.00, 2, 2, @service_id_2);

-- Вставка даних у таблицю t_payments (Оплати)
INSERT INTO t_payments (total_sum, payment_method, created_at, booking_id, guest_id)
VALUES (500.00, 'card', '2024-07-05', 1, 1),
       (600.00, 'cash', '2024-07-06', 2, 2);

-- Вставка даних у таблицю t_payroll (Розрахунки з персоналом)
INSERT INTO t_payroll (user_id, payment_date, amount)
VALUES (1, '2024-07-01', 1500.00),
       (2, '2024-07-01', 1200.00);
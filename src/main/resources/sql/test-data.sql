-- Insert sample hotels
INSERT INTO t_hotels (name, address, contact_num, created_at)
VALUES ('Hotel A', '123 Main St, City A', '123-456-7890', '2024-06-25'),
       ('Hotel B', '456 Elm St, City B', '987-654-3210', '2024-06-25');

INSERT INTO t_guests (name, email, phone_num, passport_num, hotel_id)
VALUES ('John Doe', 'john.doe@example.com', '555-123-4567', 'ABC123456', 1),
       ('Jane Smith', 'jane.smith@example.com', '555-987-6543', 'XYZ789012', 2);
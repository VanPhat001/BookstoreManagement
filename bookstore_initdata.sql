-- Insert data into the customer table
INSERT INTO customer (username, password, email, avatar, name, gender, phone, address)
VALUES 
    ('customer1', 'password1', 'customer1@email.com', 'avatar1.jpg', 'John Doe', 'male', '1234567890', '123 Main St'),
    ('customer2', 'password2', 'customer2@email.com', 'avatar2.jpg', 'Jane Doe', 'female', '9876543210', '456 Oak St'),
    ('customer3', 'password3', 'customer3@email.com', 'avatar3.jpg', 'Bob Smith', 'male', '5556667777', '789 Maple St'),
    ('customer4', 'password4', 'customer4@email.com', 'avatar4.jpg', 'Alice Johnson', 'female', '8889990000', '101 Pine St'),
    ('customer5', 'password5', 'customer5@email.com', 'avatar5.jpg', 'Sam Wilson', 'male', '1112223333', '456 Elm St'),
    ('customer6', 'password6', 'customer6@email.com', 'avatar6.jpg', 'Eva Martinez', 'female', '4445556666', '789 Oak St'),
    ('customer7', 'password7', 'customer7@email.com', 'avatar7.jpg', 'Alex Turner', 'male', '7778889999', '101 Maple St'),
    ('customer8', 'password8', 'customer8@email.com', 'avatar8.jpg', 'Sophia White', 'female', '6667778888', '456 Pine St'),
    ('customer9', 'password9', 'customer9@email.com', 'avatar9.jpg', 'Ryan Brown', 'male', '9990001111', '789 Elm St'),
    ('customer10', 'password10', 'customer10@email.com', 'avatar10.jpg', 'Olivia Davis', 'female', '2223334444', '101 Oak St');

-- Insert data into the admin table
INSERT INTO admin (username, password, email, avatar, name, gender, phone, address)
VALUES 
    ('admin1', 'adminpassword1', 'admin1@email.com', 'admin_avatar1.jpg', 'Admin One', 'male', '1112223333', '789 Elm St'),
    ('admin2', 'adminpassword2', 'admin2@email.com', 'admin_avatar2.jpg', 'Admin Two', 'female', '4445556666', '101 Pine St'),
    ('admin3', 'adminpassword3', 'admin3@email.com', 'admin_avatar3.jpg', 'Admin Three', 'male', '5556667777', '456 Maple St'),
    ('admin4', 'adminpassword4', 'admin4@email.com', 'admin_avatar4.jpg', 'Admin Four', 'female', '8889990000', '789 Oak St'),
    ('admin5', 'adminpassword5', 'admin5@email.com', 'admin_avatar5.jpg', 'Admin Five', 'male', '1234567890', '101 Elm St'),
    ('admin6', 'adminpassword6', 'admin6@email.com', 'admin_avatar6.jpg', 'Admin Six', 'female', '7778889999', '456 Pine St'),
    ('admin7', 'adminpassword7', 'admin7@email.com', 'admin_avatar7.jpg', 'Admin Seven', 'male', '9990001111', '789 Maple St'),
    ('admin8', 'adminpassword8', 'admin8@email.com', 'admin_avatar8.jpg', 'Admin Eight', 'female', '6667778888', '101 Oak St'),
    ('admin9', 'adminpassword9', 'admin9@email.com', 'admin_avatar9.jpg', 'Admin Nine', 'male', '2223334444', '456 Elm St'),
    ('admin10', 'adminpassword10', 'admin10@email.com', 'admin_avatar10.jpg', 'Admin Ten', 'female', '3334445555', '789 Pine St');

-- Insert data into the publisher table
INSERT INTO publisher (name, address, hotline)
VALUES 
    ('Publisher A', '123 Publisher St', '111-222-3333'),
    ('Publisher B', '456 Publisher St', '444-555-6666'),
    ('Publisher C', '789 Publisher St', '777-888-9999'),
    ('Publisher D', '101 Publisher St', '222-333-4444'),
    ('Publisher E', '202 Publisher St', '555-666-7777'),
    ('Publisher F', '303 Publisher St', '888-999-0000'),
    ('Publisher G', '404 Publisher St', '333-444-5555'),
    ('Publisher H', '505 Publisher St', '666-777-8888'),
    ('Publisher I', '606 Publisher St', '999-000-1111'),
    ('Publisher J', '707 Publisher St', '123-456-7890');

-- Insert data into the author table
INSERT INTO author (name, pseudonym)
VALUES 
    ('Author X', 'X-Man'),
    ('Author Y', 'Y-Woman'),
    ('Author Z', 'Z-Person'),
    ('Author W', 'W-Writer'),
    ('Author V', 'V-Scribe'),
    ('Author U', 'U-Poet'),
    ('Author T', 'T-Teller'),
    ('Author S', 'S-Singer'),
    ('Author R', 'R-Reader'),
    ('Author Q', 'Q-Quill');

-- Insert data into the book table
INSERT INTO book (publisher_id, author_id, name, book_cover, price)
VALUES 
    (1, 1, 'Book One', 'book_cover1.jpg', 19.99),
    (2, 2, 'Book Two', 'book_cover2.jpg', 29.99),
    (3, 3, 'Book Three', 'book_cover3.jpg', 39.99),
    (4, 4, 'Book Four', 'book_cover4.jpg', 49.99),
    (5, 5, 'Book Five', 'book_cover5.jpg', 59.99),
    (6, 6, 'Book Six', 'book_cover6.jpg', 69.99),
    (7, 7, 'Book Seven', 'book_cover7.jpg', 79.99),
    (8, 8, 'Book Eight', 'book_cover8.jpg', 89.99),
    (9, 9, 'Book Nine', 'book_cover9.jpg', 99.99),
    (10, 10, 'Book Ten', 'book_cover10.jpg', 109.99);

-- Insert data into the order_detail table
INSERT INTO order_detail (customer_id, created_at)
VALUES 
    (1, NOW()),
    (2, NOW()),
    (3, NOW()),
    (4, NOW()),
    (5, NOW()),
    (6, NOW()),
    (7, NOW()),
    (8, NOW()),
    (9, NOW()),
    (10, NOW());

-- Insert data into the order_item table
INSERT INTO order_item (order_detail_id, book_id, quantity, price)
VALUES 
    (1, 1, 2, 39.98),
    (2, 2, 1, 29.99),
    (3, 3, 3, 119.97),
    (4, 4, 2, 99.98),
    (5, 5, 1, 59.99),
    (6, 6, 4, 279.96),
    (7, 7, 2, 159.98),
    (8, 8, 3, 269.97),
    (9, 9, 1, 99.99),
    (10, 10, 2, 219.98);

-- Insert data into the category table
INSERT INTO category (name, description)
VALUES 
    ('Fiction', 'Books that tell imaginary stories'),
    ('Non-Fiction', 'Books based on real events and facts'),
    ('Mystery', 'Books with suspenseful plots'),
    ('Science Fiction', 'Books that explore futuristic concepts'),
    ('Romance', 'Books centered around love and relationships'),
    ('Thriller', 'Books with intense and thrilling narratives'),
    ('History', 'Books about past events and civilizations'),
    ('Biography', 'Books detailing the life of a person'),
    ('Self-Help', 'Books focused on personal development'),
    ('Fantasy', 'Books set in magical or fantastical worlds');

-- Insert data into the book_category table
INSERT INTO book_category (book_id, category_id)
VALUES 
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10);

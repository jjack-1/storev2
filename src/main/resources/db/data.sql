INSERT INTO user_tb (username, fullname, password, created_at) VALUES ('ssar', '쌀', '1234', now());
INSERT INTO user_tb (username, fullname, password, created_at) VALUES ('cos', '코스', '1234', now());

INSERT INTO store_tb (name, stock, price, created_at) VALUES ('바나나', 100, 3000, now());
INSERT INTO store_tb (name, stock, price, created_at) VALUES ('딸기', 50, 2000, now());

INSERT INTO log_tb (user_id, store_id, qty, total_price, created_at) VALUES (1, 1, 5, 15000, now());
INSERT INTO log_tb (user_id, store_id, qty, total_price, created_at) VALUES (1, 2, 5, 10000, now());
INSERT INTO log_tb (user_id, store_id, qty, total_price, created_at) VALUES (2, 1, 10, 30000, now());
INSERT INTO log_tb (user_id, store_id, qty, total_price, created_at) VALUES (2, 2, 10, 20000, now());
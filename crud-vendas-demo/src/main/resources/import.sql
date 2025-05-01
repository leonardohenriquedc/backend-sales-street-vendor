INSERT INTO tb_users(external_id, name, email, password) values ('wsoknvwrobon', 'Leonardo', 'leohencosta18@gmail.com', '2615');

INSERT INTO tb_users(external_id, name, email, password) values ('27c1a14fc8f75c98238db1fe4b6e7536485797f62375052374196c1d50b2ea61', 'leonardo',	'leo@gmail.com', '$2a$10$Q3nEdxUzfzf37Tpvc170xuaPCbtvIjB7nnuSVFCrFF.HBkjErbD7K');

INSERT INTO tb_products(external_id, name, price) values ('owvnjawjrbo', 'Palha Italiana', 8.60);

INSERT INTO tb_banks(external_id, name, key_pix, img_qr_code) values ('fvonjkwnko', 'Itau', 'snkwbnkbwkno', null);

INSERT INTO tb_roles(role) VALUES ('ROLE_SELLER');
INSERT INTO tb_roles(role) VALUES ('ROLE_ADMIN');

INSERT INTO tb_users_roles(user_id, role_id) values (2, 1);

INSERT INTO tb_payment_methods(method) values ('pix');
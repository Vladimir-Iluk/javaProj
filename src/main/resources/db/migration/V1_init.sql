CREATE TABLE clients (
                         client_id SERIAL PRIMARY KEY,
                         last_name VARCHAR(100) NOT NULL,
                         first_name VARCHAR(100) NOT NULL,
                         patronymic VARCHAR(100),
                         passport_number VARCHAR(20) NOT NULL,
                         passport_series VARCHAR(10) NOT NULL,
                         passport_issued_date DATE NOT NULL
);

CREATE TABLE product_categories (
                                    category_id SERIAL PRIMARY KEY,
                                    name VARCHAR(100) NOT NULL,
                                    notes TEXT
);

CREATE TABLE pawnings (
                          pawning_id SERIAL PRIMARY KEY,
                          category_id INTEGER NOT NULL REFERENCES product_categories(category_id) ON DELETE CASCADE,
                          client_id INTEGER NOT NULL REFERENCES clients(client_id) ON DELETE CASCADE,
                          product_description TEXT NOT NULL,
                          date_received DATE NOT NULL,
                          return_deadline DATE NOT NULL,
                          amount NUMERIC(12, 2) NOT NULL,
                          commission NUMERIC(12, 2) NOT NULL
);
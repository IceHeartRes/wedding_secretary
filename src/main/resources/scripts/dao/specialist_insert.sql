INSERT INTO specialists (name, description, category_code, code)
VALUES (:name, :description, :professional_category_code, :code);

INSERT INTO professional_categories (name, description, code)
VALUES (:professional_category_name, :professional_category_description, :professional_category_code);
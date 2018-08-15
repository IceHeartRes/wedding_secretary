INSERT INTO professional_categories (name, description, code)
VALUES ('1', '2', '3');

INSERT INTO specialists (name, description, category_code, code)
VALUES ('1', '2', '3', '1');

INSERT INTO contacts (code, description, icon_link, type, specialist_code)
VALUES ('1', '4', '5', '6', '1');

INSERT INTO photo (specialist_code, photo_link)
VALUES ('1', '7');

INSERT INTO video_links (specialist_code, video_link)
VALUES ('1', '8');


SELECT
  s.name,
  s.description,
  pc.name        AS professional_category_name,
  pc.description AS professional_category_description,
  pc.code        AS professional_category_code,
  s.code         AS code
FROM specialists s
  JOIN professional_categories pc
    ON s.category_code = pc.code;
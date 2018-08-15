SELECT
  s.code,
  s.name,
  s.description,
  s.category_code,
  ps.code        AS professional_category_code,
  ps.name        AS professional_category_name,
  ps.description AS professional_category_description
FROM specialists s
  JOIN professional_categories ps
    ON ps.code = s.code;

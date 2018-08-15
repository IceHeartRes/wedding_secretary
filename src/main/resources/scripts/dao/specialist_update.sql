UPDATE professional_categories
SET
  description = :professional_category_description,
  name        = :professional_category_name,
  code        = :professional_category_code;

UPDATE specialists
SET
  name          = :name,
  description   = :description,
  category_code = :professional_category_code
WHERE code = :code;

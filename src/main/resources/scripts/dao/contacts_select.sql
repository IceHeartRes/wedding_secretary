SELECT
  c.specialist_code,
  c.description,
  c.icon_link,
  c.type,
  c.code
FROM contacts c
WHERE c.specialist_code = :code;

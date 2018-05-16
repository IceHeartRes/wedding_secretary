SELECT
  o.name,
  o.email,
  o.partition,
  o.phone,
  o.city_code AS code,
  c.name      AS city_name,
  c.time_zone_offset
FROM orders o
  JOIN cities c
    ON o.city_code = c.code;
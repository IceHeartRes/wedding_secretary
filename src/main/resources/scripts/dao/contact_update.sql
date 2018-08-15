UPDATE contacts
SET
  type        = :type,
  description = :description,
  icon_link   = :icon_link
WHERE code = :code
      AND specialist_code = :specialist_code;
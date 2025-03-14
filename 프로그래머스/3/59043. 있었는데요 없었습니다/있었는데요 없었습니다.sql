SELECT ai.ANIMAL_ID, ai.NAME
FROM ANIMAL_INS ai
JOIN ANIMAL_OUTS ao ON ai.ANIMAL_ID = ao.ANIMAL_ID
WHERE TIMESTAMPDIFF(MINUTE, ai.DATETIME, ao.DATETIME) < 0
ORDER BY ai.DATETIME ASC;
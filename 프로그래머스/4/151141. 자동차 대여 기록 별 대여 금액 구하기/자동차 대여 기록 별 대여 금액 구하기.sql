WITH TEMP_CAR_RENTAL_COMPANY_RENTAL_HISTORY AS (
    SELECT HISTORY_ID, CAR_ID, START_DATE, END_DATE,
    CASE 
        WHEN (TIMESTAMPDIFF(DAY, START_DATE, END_DATE)+1) >= 90 THEN "90일 이상"
        WHEN (TIMESTAMPDIFF(DAY, START_DATE, END_DATE)+1) >= 30 THEN "30일 이상"
        WHEN (TIMESTAMPDIFF(DAY, START_DATE, END_DATE)+1) >= 7 THEN "7일 이상"
        ELSE null END AS DURATION_TYPE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY)

SELECT HISTORY_ID, ROUND(crcc.DAILY_FEE * (TIMESTAMPDIFF(DAY, tcrcrh.START_DATE, tcrcrh.END_DATE)+1) * (1-IFNULL(DISCOUNT_RATE/100, 0)), 0) AS FEE
FROM TEMP_CAR_RENTAL_COMPANY_RENTAL_HISTORY tcrcrh
JOIN CAR_RENTAL_COMPANY_CAR crcc ON tcrcrh.CAR_ID = crcc.CAR_ID
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN crcdp ON tcrcrh.DURATION_TYPE = crcdp.DURATION_TYPE
WHERE crcc.CAR_TYPE = "트럭" AND (crcdp.CAR_TYPE = "트럭" OR crcdp.CAR_TYPE IS NULL)
ORDER BY FEE DESC, HISTORY_ID DESC;
SELECT original.ID, 
CASE 
WHEN temp.percent_ranking <= 0.25 THEN "CRITICAL"
WHEN temp.percent_ranking <= 0.50 THEN "HIGH"
WHEN temp.percent_ranking <= 0.75 THEN "MEDIUM"
ELSE "LOW"
END AS COLONY_NAME
FROM ECOLI_DATA original
JOIN (SELECT ID, PERCENT_RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) AS percent_ranking FROM ECOLI_DATA) temp
ON original.ID = temp.ID
ORDER BY original.ID ASC;
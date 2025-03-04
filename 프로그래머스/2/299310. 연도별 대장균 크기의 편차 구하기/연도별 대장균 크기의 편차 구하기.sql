SELECT YEAR(ed.DIFFERENTIATION_DATE) AS YEAR, edd.MAX_SIZE_OF_COLONY - ed.SIZE_OF_COLONY AS YEAR_DEV, ed.ID
FROM ECOLI_DATA ed
JOIN (SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, MAX(SIZE_OF_COLONY) AS MAX_SIZE_OF_COLONY
FROM ECOLI_DATA
GROUP BY YEAR(DIFFERENTIATION_DATE)) edd ON YEAR(ed.DIFFERENTIATION_DATE) = edd.YEAR
ORDER BY YEAR ASC, YEAR_DEV ASC
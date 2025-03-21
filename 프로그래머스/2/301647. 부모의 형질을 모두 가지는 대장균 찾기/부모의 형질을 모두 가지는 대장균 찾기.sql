SELECT child.ID AS ID, child.GENOTYPE AS GENOTYPE, parent.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA child
JOIN ECOLI_DATA parent ON child.PARENT_ID = parent.ID
WHERE parent.GENOTYPE & child.GENOTYPE = parent.GENOTYPE
ORDER BY ID; 

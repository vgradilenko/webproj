SELECT D.ID, D.NAME
FROM DEPARTMENTS D
LEFT JOIN EMPLOYEES E ON E.DEPID = D.ID 
WHERE E.ID IS null;
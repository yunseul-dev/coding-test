-- 코드를 입력하세요 
# COUNT, GROUP BY, IN

SELECT DATE_FORMAT (START_DATE, "%m") AS MONTH, CAR_ID, COUNT(CAR_ID) AS RECORDS FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
WHERE START_DATE >= '2022-08-01' AND START_DATE <= '2022-10-31'  
AND CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
        WHERE START_DATE >= '2022-08-01' AND START_DATE <= '2022-10-31'
        GROUP BY CAR_ID
        HAVING COUNT(CAR_ID) >= 5)
GROUP BY MONTH(START_DATE), CAR_ID
HAVING COUNT(CAR_ID) > 0
ORDER BY MONTH(START_DATE) ASC, CAR_ID DESC;
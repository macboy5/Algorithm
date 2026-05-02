-- 코드를 입력하세요
SELECT ANIMAL_ID,	
        NAME, 
        CASE 
            WHEN SUBSTR(SEX_UPON_INTAKE, 1, 8 ) = 'Neutered' THEN 'O'
            WHEN SUBSTR(SEX_UPON_INTAKE, 1,6 ) = 'Spayed' THEN 'O'
            ELSE 'X'
        END AS 중성화
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC;
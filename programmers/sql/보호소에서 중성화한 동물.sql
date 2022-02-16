select O.ANIMAL_ID, O.ANIMAL_TYPE, O.NAME
from ANIMAL_INS I inner join ANIMAL_OUTS O on I.ANIMAL_ID = O.ANIMAL_ID
where I.SEX_UPON_INTAKE like'Intact%' and O.SEX_UPON_OUTCOME not like'Intact%'
order by I.ANIMAL_ID;
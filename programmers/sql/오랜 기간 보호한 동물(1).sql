select I.NAME, I.DATETIME
from ANIMAL_INS I left outer join ANIMAL_OUTS O on I.ANIMAL_ID = O.ANIMAL_ID
where O.ANIMAL_ID is null
order by I.DATETIME
limit 3;
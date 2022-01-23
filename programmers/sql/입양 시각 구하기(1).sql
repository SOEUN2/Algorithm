select HOUR(DATETIME), count(*)
from ANIMAL_OUTS
where HOUR(DATETIME) between 9 and 19
group by HOUR(DATETIME)
order by HOUR(DATETIME);
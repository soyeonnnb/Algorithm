-- 코드를 입력하세요
SELECT animal_type, count(*)
from animal_ins
where animal_type in ("Cat", "Dog")
group by animal_type
order by animal_type;
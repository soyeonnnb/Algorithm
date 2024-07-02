-- 코드를 입력하세요
SELECT animal_id, name,
case
    when lower(sex_upon_intake) like "%neutered%" or lower(sex_upon_intake) like "%spayed%" then 'O'
    else 'X'
end as '중성화'
from animal_ins 
order by animal_id;
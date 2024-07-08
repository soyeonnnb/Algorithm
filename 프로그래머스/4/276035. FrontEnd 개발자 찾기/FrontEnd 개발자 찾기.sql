-- 코드를 작성해주세요
select distinct id, email, first_name, last_name
from developers
inner join skillcodes
    on skill_code & skillcodes.code = skillcodes.code
where skillcodes.category = "Front End"
order by id
;
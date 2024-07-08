-- 코드를 작성해주세요
select de.dept_id, de.dept_name_en, round(avg(sal), 0) as avg_sal
from hr_employees as em
left join hr_department as de on em.dept_id = de.dept_id
group by dept_id
order by avg(sal) desc;
-- 코드를 입력하세요
SELECT first_half.flavor
from first_half 
    left outer join (
        select flavor, sum(total_order) as total 
        from july
        group by flavor
    ) as mp
    on first_half.flavor = mp.flavor
order by first_half.total_order + mp.total desc
limit 3
;

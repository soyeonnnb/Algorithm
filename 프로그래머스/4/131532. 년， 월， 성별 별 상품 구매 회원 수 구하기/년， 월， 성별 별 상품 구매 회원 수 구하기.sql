-- 코드를 입력하세요
SELECT year(online_sale.sales_date), month(online_sale.sales_date), user_info.gender, count(distinct online_sale.user_id)
from online_sale
left join user_info on user_info.user_id = online_sale.user_id
where user_info.gender is not null
group by date_format(online_sale.sales_date, "%Y-%m"), user_info.gender
order by 1, 2, 3
;
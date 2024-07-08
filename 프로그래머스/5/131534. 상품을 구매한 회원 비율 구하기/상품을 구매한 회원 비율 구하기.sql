-- 코드를 입력하세요
SELECT date_format(os.sales_date, "%Y") as year,
    cast(date_format(os.sales_date, "%m") as unsigned) as month, 
    count(distinct ui.user_id) as purchased_user,
    round(count(distinct ui.user_id)/(
        select count(*)
        from user_info
        where user_info.joined >= "2021-01-01" and user_info.joined < "2022-01-01"
    ), 1) as purchased_ratio
from online_sale as os
    left join user_info as ui
    on ui.user_id = os.user_id
where ui.joined >= "2021-01-01" and ui.joined < "2022-01-01"
group by date_format(os.sales_date, "%Y-%m")
order by os.sales_date
;
-- 코드를 입력하세요
SELECT fp.product_id, fp.product_name, sum(fo.amount) * fp.price as total_sales
from food_product as fp
    right join food_order as fo on fp.product_id = fo.product_id
where fo.produce_date >= "2022-05-01" and fo.produce_date < "2022-06-01"
group by fp.product_id
order by sum(fo.amount) * fp.price desc, fp.product_id;
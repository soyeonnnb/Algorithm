-- 코드를 입력하세요
SELECT rest_info.rest_id, rest_info.rest_name, rest_info.food_type, rest_info.favorites, rest_info.address, round(avg(rest_review.review_score), 2) as score
from rest_info
inner join rest_review on rest_info.rest_id = rest_review.rest_id
where address like "서울%"
group by rest_info.rest_id
order by score desc, favorites desc
;
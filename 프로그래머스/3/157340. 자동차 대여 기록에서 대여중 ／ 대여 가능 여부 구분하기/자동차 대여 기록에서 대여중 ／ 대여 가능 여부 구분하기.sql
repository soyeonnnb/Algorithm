-- 코드를 입력하세요

with avail as (
    select distinct car_id, "대여중" as availability
    from car_rental_company_rental_history
    where start_date <= "2022-10-16" and
        end_date >= "2022-10-16"
)

SELECT car.car_id, 
    case 
        when availability is not null then availability
        else "대여 가능"
    end
as availability
from car_rental_company_rental_history as car
    left join avail on avail.car_id = car.car_id
group by car.car_id
order by car.car_id desc;
-- 코드를 입력하세요
SELECT car.car_id,
    car.car_type, 
    floor(car.daily_fee * 30 / 100 * (100 - plan.discount_rate))  as fee
from car_rental_company_car as car
    left outer join car_rental_company_discount_plan as plan
    on car.car_type = plan.car_type
where car.car_type in ("세단", "SUV") 
    and car.car_id not in (
        select history.car_id 
        from car_rental_company_rental_history as history
        where history.start_date <= "2022-11-30" and history.end_date >= "2022-11-01"
    )
    and plan.duration_type = "30일 이상"
group by car.car_id
having fee >= 500000 and fee < 2000000
order by fee desc, car.car_type, car.car_id desc
;
# -- 코드를 입력하세요
# select P.PRODUCT_ID, P.PRODUCT_NAME, (P.PRICE * O.AMOUNT) as TOTAL_SALES
# from 
#     FOOD_PRODUCT as P
#     inner join (
#         select PRODUCT_ID, sum(AMOUNT) as AMOUNT, PRODUCE_DATE
#         from FOOD_ORDER
#         where DATE_FORMAT(PRODUCE_DATE, '%Y-%m') = '2022-05'
#         group by PRODUCT_ID
#     ) as O
#     on P.PRODUCT_ID = O.PRODUCT_ID
# order by TOTAL_SALES desc, P.PRODUCT_ID asc;


select P.PRODUCT_ID, P.PRODUCT_NAME, (P.PRICE * O.AMOUNT) as TOTAL_SALES
from 
    FOOD_PRODUCT as P
    inner join (
        select PRODUCT_ID, sum(AMOUNT) AS AMOUNT, PRODUCE_DATE
        from FOOD_ORDER
        where DATE_FORMAT(PRODUCE_DATE, '%Y-%m') = '2022-05'
        group by PRODUCT_ID
    ) as O
    on P.PRODUCT_ID = O.PRODUCT_ID
order by TOTAL_SALES desc, P.PRODUCT_ID asc;
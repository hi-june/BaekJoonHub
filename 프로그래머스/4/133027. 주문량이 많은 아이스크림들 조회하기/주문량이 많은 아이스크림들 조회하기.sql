-- 코드를 입력하세요
# select F.FLAVOR
# from 
#     FIRST_HALF as F
#     left join (
#         select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER 
#         from JULY
#         group by FLAVOR
#     ) as J
#     on F.FLAVOR = J.FLAVOR
# order by (F.TOTAL_ORDER + J.TOTAL_ORDER) desc
# limit 3;


select F.FLAVOR
from 
    FIRST_HALF as F
    left join (
        select FLAVOR, SUM(TOTAL_ORDER) as TOTAL_ORDER
        from JULY
        group by FLAVOR
    ) as J
    on F.FLAVOR = J.FLAVOR
order by (F.TOTAL_ORDER + J.TOTAL_ORDER) desc
limit 3;
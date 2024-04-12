-- 코드를 입력하세요
select M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from 
    REST_REVIEW as R
    inner join MEMBER_PROFILE as M
    on R.MEMBER_ID = M.MEMBER_ID
where R.MEMBER_ID = (
    select MEMBER_ID
    from REST_REVIEW
    group by MEMBER_ID
    order by count(MEMBER_ID) desc
    limit 1
)
order by R.REVIEW_DATE asc, R.REVIEW_TEXT asc;

# select MEMBER_ID, count(MEMBER_ID)
# from REST_REVIEW
# group by MEMBER_ID
# order by count(MEMBER_ID) desc;

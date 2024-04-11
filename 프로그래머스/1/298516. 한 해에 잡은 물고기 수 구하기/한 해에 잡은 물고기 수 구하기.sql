-- 코드를 작성해주세요
select count(*) as FISH_COUNT
from FISH_INFO
where DATE_FORMAT(TIME, '%Y') = '2021';

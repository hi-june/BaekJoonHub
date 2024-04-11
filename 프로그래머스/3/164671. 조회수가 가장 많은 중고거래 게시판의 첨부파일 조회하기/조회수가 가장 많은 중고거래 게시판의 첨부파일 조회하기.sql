-- 코드를 입력하세요
select concat('/home/grep/src/', B.BOARD_ID, '/', F.FILE_ID, F.FILE_NAME, F.FILE_EXT) as FILE_PATH
from 
    USED_GOODS_BOARD AS B
    inner join USED_GOODS_FILE AS F
    on B.BOARD_ID = F.BOARD_ID
where B.VIEWS = (select max(VIEWS) from USED_GOODS_BOARD)
order by F.FILE_ID desc;

# SELECT CONCAT("/","home/grep/src","/",b.BOARD_ID,"/",FILE_ID,FILE_NAME, FILE_EXT)FILE_PATH
# FROM USED_GOODS_BOARD as b, USED_GOODS_FILE as f
# WHERE b.BOARD_ID = f.BOARD_ID
# AND VIEWS = (SELECT MAX(VIEWS) 
#              FROM USED_GOODS_BOARD)
# order by FILE_ID desc
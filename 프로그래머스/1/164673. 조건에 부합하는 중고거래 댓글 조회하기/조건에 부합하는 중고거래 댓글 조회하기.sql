-- 코드를 입력하세요 1:32
SELECT board.title, board.board_id, reply.reply_id, reply.writer_id, reply.contents, date_format(reply.created_date, '%Y-%m-%d') as created_date 
from used_goods_board as board 
INNER join used_goods_reply as reply 
on board.board_id = reply.board_id 
where board.created_date >= '2022-10-01' and board.created_date < '2022-11-01' 
order by reply.created_date, board.title;

 # board.created_date >= '2022-10-01' and board.created_date < '2022-11-01' and 
 
 # select * from USED_GOODS_REPLY as r where r.created_date >= '2022-10-01' and r.created_date < '2022-11-01';
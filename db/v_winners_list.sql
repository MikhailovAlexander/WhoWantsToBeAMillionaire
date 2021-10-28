create view v_winners_list as 
select
	gm.gamer_name,
	wn.winner_amount,
	strftime('%d.%m.%Y %H:%M', wn.winner_dt) as winner_dt
from gamer as gm
	inner join(
		select 
			row_number() over(
				partition by wn.gamer_id
				order by 
					wn.winner_amount desc,
					wn.winner_dt desc) as num,
			wn.winner_amount,
			wn.winner_dt,
			wn.gamer_id
		from winner as wn
		order by
			wn.winner_amount desc,
			wn.winner_dt desc
	)wn on wn.gamer_id = gm.gamer_id
where wn.num = 1
order by
	wn.winner_amount desc,
	wn.winner_dt desc;
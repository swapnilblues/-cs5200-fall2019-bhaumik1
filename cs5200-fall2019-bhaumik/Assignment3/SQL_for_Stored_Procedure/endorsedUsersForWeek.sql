delimiter $$
create procedure endorsedUsersForWeek(in start_date date, in end_date date)
begin

    select p.*, view7.no_of_correct_answers from person p
		join
    
			(select user.id as user_id, count(view6.correct_answer) as no_of_correct_answers, view6.* 
				from 
					(select q.*, a.id as answer_id, a.posted_by, a.correct_answer, a.question 
						from question q 	
							join answer a on a.question = q.id 
										     and a.correct_answer = 1 
	                                         and q.posted_on >= start_date 
                                             and q.posted_on <= end_date) 
					as view6
	                join 
						user on user.id = view6.posted_by
	                    group by user.id
						order by no_of_correct_answers desc
						limit 5) 
		as view7
		on p.id = view7.user_id
		order by first_name; 
	
end $$
delimiter ;

call endorsedUsersForWeek('2019-10-15', '2019-10-22');
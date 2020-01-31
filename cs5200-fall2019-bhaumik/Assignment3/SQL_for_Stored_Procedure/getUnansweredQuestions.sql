delimiter $$
create procedure getUnansweredQuestions()
begin
	create view view1 as 
    select q.*, a.id as a_id, a.question, max(a.correct_answer) as correct_ans from question q 
    join answer a on 
    q.id = a.question group by q.id;
    
    create view view2 as 
    select q.id, q.text, q.module, a.id as a_id, a.correct_answer from question q 
    join answer a on 
    q.id = a.question  
    join view1 on
    view1.id = q.id
    and view1.correct_ans = 0;
    
    create view view3 as
    select view2.*, count(view2.id) as no_of_unanswered
    from view2 group by view2.id;
    
    create view view4 as
    select max(no_of_unanswered) as max_no_of_unanswered, view3.text, view3.module
    from view3
    group by view3.module;
    
    select * from view4;
    drop view view1;
    drop view view2;
    drop view view3;
    drop view view4;
    end $$
DELIMITER ;

call getUnansweredQuestions();

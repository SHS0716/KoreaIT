delete from member;
drop sequence member_idx_seq;
create sequence member_idx_seq;
commit;

delete from interlist;
drop sequence interlist_interidx_seq;
create sequence interlist_interidx_seq;
commit;

delete from board;
drop sequence board_bidx_seq;
create sequence board_bidx_seq;
commit;

delete from reply;
drop sequence reply_reidx_seq;
create sequence reply_reidx_seq;
commit;

select * from user_tables;
commit;
select * from member order by idx desc;
select * from interlist order by interidx;
select * from board order by bidx desc;
select * from reply order by reidx;

select interests from interlist where id = 'hong';
select interests from interlist where id = 'lim';
select * from board where bidx = 90;

insert into member (idx, id, password, name, gender, dateofbirthday, email, phone) values (member_idx_seq.nextval, 'hong', '홍길동', '1111', '남자', '19930716', 'hong@naver.com', '01088179307');
insert into member (idx, id, password, name, gender, dateofbirthday, email, phone) values (member_idx_seq.nextval, 'lim', '임꺽정', '2222', '여자', '19950419', 'lim@gmail.com', '01026811007');

insert into interlist (interidx, id, interests) values (interlist_interidx_seq.nextval, 'hong', '사회');
insert into interlist (interidx, id, interests) values (interlist_interidx_seq.nextval, 'hong', '연예');
insert into interlist (interidx, id, interests) values (interlist_interidx_seq.nextval, 'hong', '스포츠');

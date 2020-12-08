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

commit;
select * from user_tables;
select * from member order by idx desc;
select * from interlist order by interidx;
select * from board order by interidx;
select * from reply order by interidx;

select interests from interlist where id = 'hong';
select interests from interlist where id = 'lim';

insert into member (idx, id, password, name, gender, dateofbirthday, email, phone) values (member_idx_seq.nextval, 'hong', 'ȫ�浿', '1111', '����', '19930716', 'hong@naver.com', '01088179307');
insert into member (idx, id, password, name, gender, dateofbirthday, email, phone) values (member_idx_seq.nextval, 'lim', '�Ӳ���', '2222', '����', '19950419', 'lim@gmail.com', '01026811007');

insert into interlist (interidx, id, interests) values (interlist_interidx_seq.nextval, 'hong', '��ȸ');
insert into interlist (interidx, id, interests) values (interlist_interidx_seq.nextval, 'hong', '����');
insert into interlist (interidx, id, interests) values (interlist_interidx_seq.nextval, 'hong', '������');

drop board from hshs;
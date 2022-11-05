drop  table  exam_detail;

Create  table exam_detail(
 idx  number(3)  not  null  primary  key,  -- ���̺�  P.K ����� 
 sno  varchar2(5)  not  null,   -- examtbl ���̺�� �ܷ�Ű�� ������ �÷� ����� 
 addr nvarchar2(100) ,  
 tel  varchar2(15)   
) ;



desc examtbl1011;

alter  table   exam_detail  add  constraint  fk_exame_detail
foreign  key(sno)  references  examtbl1011(sno);

create  sequence  seq_exam_detail; 

insert  into  exam_detail ( idx, sno, addr, tel ) 
values (seq_exam_detail.nextval, '10101', '�泲 ��â��','010-1234-1111' );


insert  into  exam_detail ( idx, sno, addr, tel ) 
values (seq_exam_detail.nextval, '10102', '��õ��','010-999-1111' );

insert  into  exam_detail ( idx, sno, addr, tel ) 
values (seq_exam_detail.nextval, '10201', '���� ���ϱ�','010-0000-1111' );

insert  into  exam_detail ( idx, sno, addr, tel ) 
values (seq_exam_detail.nextval, '10202', '���� ������','010-1111-2222' );

insert  into  exam_detail ( idx, sno, addr, tel ) 
values (seq_exam_detail.nextval, '10304', '���ֽ�','010-1234-6666' );

insert  into  exam_detail ( idx, sno, addr, tel ) 
values (seq_exam_detail.nextval, '10305', '�︪��','010-1234-7777' );

select * from exam_detail;
select * from examtbl1011;

select t.sno, sname, addr, tel 
from examtbl1011 t
left join exam_detail d
on t.sno =d.sno;

Create table exam_img(
idx number(3) not null primary key,
sno varchar2(5) not null,
img nvarchar2(30)
);

alter  table   exam_img  add  constraint  fk_exame_img
foreign  key(sno)  references  examtbl1011(sno);

create sequence seq_exam_img;

Create table examtbl1013 (
 sno char(5)  not  null primary key ,
 sname nvarchar2(10),
 kor  number(3),
 eng  number(3),
 math number(3),
 hist number(3)
) ;

insert into examtbl1013 values('10101','���л�', 75, 85, 90, 60);
insert into examtbl1013 values('10102','���л�', 70, 75, 70, 60);
insert into examtbl1013 values('10103','���л�', 70, 85, 80, 75);
insert into examtbl1013 values('10201','���л�', 90, 85, 100, 50);
insert into examtbl1013 values('10202','Ȳ�л�', 65, 65, 60, 70);
insert into examtbl1013 values('10203','���л�', 45, 55, 50, 55);
insert into examtbl1013 values('10304','õ�л�', 70, 75, 85, 80);
insert into examtbl1013 values('10305','���л�', 100, 85, 90, 90);
insert into examtbl1013 values('10306','���л�', 80, 95, 90, 85);
insert into examtbl1013 values('10307','���л�', 35, 55, 70, 55);

select *  from examtbl1013;


Create table board1026(
seq int not null primary key,
title nvarchar2(20) not null,
writer nvarchar2(10),
content nvarchar2(10),
createDate Date,
cnt int);

Create table member1026(
id varchar2(10) not null primary key,
password varchar2(100) not null,
name nvarchar2(10),
role varchar2(20),
enabled varchar2(6)
);

Create SEQUENCE SEQboard1026
INCREMENT by 1 start with 1001
MAXVALUE 999999;


Create  table  board1026 (
  seq  int  not  null  primary key,
  title  nvarchar2(20) not  null,
  writer  nvarchar2(10),
  content  nvarchar2(10),
  createDate Date ,  
  cnt int
  );
 
  
  
  Create  table  member1026 (
  id  varchar(10) not  null  primary key,
  password  varchar2(100) not  null,
  name  nvarchar2(10),
  role  varchar2(20) , 
  enabled varchar2(6)
  );
 select * from member1026;
 select * from board1026;
Create  SEQUENCE SEQboard1026
INCREMENT by 1  start  with 1001
MAXVALUE  999999;

select * from board1026 b
inner join member1026 m
on b.WRITER = m.ID;


Create table examtbl1031 (
 sno varchar(10)  not  null primary key ,
 sname varchar(20),
 kor  int,
 eng  int,
 math int,
 hist int
) ;

insert into examtbl1031 values('10101','���л�', 75, 85, 90, 60);
insert into examtbl1031 values('10102','���л�', 70, 75, 70, 60);
insert into examtbl1031 values('10103','���л�', 70, 85, 80, 75);
insert into examtbl1031 values('10201','���л�', 90, 85, 100, 50);
insert into examtbl1031 values('10202','Ȳ�л�', 65, 65, 60, 70);
insert into examtbl1031 values('10203','���л�', 45, 55, 50, 55);
insert into examtbl1031 values('10304','õ�л�', 70, 75, 85, 80);
insert into examtbl1031 values('10305','���л�', 100, 85, 90, 90);
insert into examtbl1031 values('10306','���л�', 80, 95, 90, 85);
insert into examtbl1031 values('10307','���л�', 35, 55, 70, 55);

select *  from examtbl1031;

Create table member1031(
 id varchar(20) not null primary key ,
 password varchar(100),
 name nvarchar2(10),
 role varchar(15),
 enabled varchar(15)
) ;

select * from member1031;
select * from member1031;
delete from member1031 where id='member1';
insert  into member1031 (id, password, name, role, enabled)
   values( 'admin', 'admin123', '�ϴ���', 'ROLE_ADMIN', 'enabled' );
   delete from member1031;
   
   drop table tbl_vote_202005;
   
   Create  table  tbl_vote_202005(
  v_jumin  char(13)  not  null  primary key,
  v_name  varchar(20) ,
  m_no  char(1) ,
  v_time  char(4),
  v_area  char(20),
  v_confirm  char(1)
);

insert into tbl_vote_202005 (v_jumin, v_name, m_no, v_time, v_area, v_confirm )
values ('99010110001', '������', '1', '0930', '��1��ǥ��', 'N');
insert into tbl_vote_202005
values ('89010120002', '������', '2', '0930', '��1��ǥ��', 'N');
insert into tbl_vote_202005
values ('69010110003', '������', '3', '0930', '��1��ǥ��', 'Y');
insert into tbl_vote_202005
values ('59010120004', 'ȫ����', '4', '0930', '��1��ǥ��', 'Y');
insert into tbl_vote_202005
values ('79010110005', '������', '5', '0930', '��1��ǥ��', 'Y');
insert into tbl_vote_202005
values ('89010120006', '������', '1', '0930', '��1��ǥ��', 'Y');
insert into tbl_vote_202005
values ('59010110007', '������', '1', '0930', '��1��ǥ��', 'Y');
insert into tbl_vote_202005
values ('49010120008', '������', '3', '0930', '��1��ǥ��', 'Y');
insert into tbl_vote_202005
values ('79010110009', '������', '3', '0930', '��1��ǥ��', 'Y');
insert into tbl_vote_202005
values ('89010120010', '������', '4', '0930', '��1��ǥ��', 'Y');
insert into tbl_vote_202005
values ('99010110011', '������', '5', '0930', '��1��ǥ��', 'Y');
insert into tbl_vote_202005
values ('79010120012', '������', '1', '1330', '��1��ǥ��', 'Y');


insert into tbl_vote_202005
values ('69010110013', '������', '4', '1330', '��2��ǥ��', 'Y');
insert into tbl_vote_202005
values ('89010110014', '������', '2', '1330', '��2��ǥ��', 'Y');
insert into tbl_vote_202005
values ('99010110015', '������', '3', '1330', '��2��ǥ��', 'Y');
insert into tbl_vote_202005
values ('79010110016', '������', '2', '1330', '��2��ǥ��', 'Y');
insert into tbl_vote_202005
values ('89010110017', '������', '4', '1330', '��2��ǥ��', 'Y');
insert into tbl_vote_202005
values ('99010110018', '������', '2', '1330', '��2��ǥ��', 'Y');
insert into tbl_vote_202005
values ('99010110019', '������', '4', '1330', '��2��ǥ��', 'Y');
insert into tbl_vote_202005
values ('79010110020', 'Ȳ����', '5', '1330', '��2��ǥ��', 'Y');
insert into tbl_vote_202005
values ('69010110021', '������', '3', '1330', '��2��ǥ��', 'Y');
insert into tbl_vote_202005
values ('79010110022', '������', '3', '1330', '��2��ǥ��', 'Y');
insert into tbl_vote_202005
values ('99010110023', '������', '1', '1330', '��2��ǥ��', 'Y');
insert into tbl_vote_202005
values ('59010110024', '������', '3', '1330', '��2��ǥ��', 'Y');
?
select  *  from tbl_vote_202005;

drop table tbl_member_202005;

create  table  tbl_member_202005(
m_no  char(1)  not null  primary  key,
m_name  varchar(20),
p_code  char(2),
p_school  char(1),
m_jumin  char(13),
m_city  varchar(20)
);

?

insert into tbl_member_202005 (m_no, m_name,p_code, p_school,m_jumin, m_city  )
values ('1', '���ĺ�', 'P1', '1', '6603011999991', '����ȭ��');
insert into tbl_member_202005
values ('2', '���ĺ�', 'P2', '3', '5503011999992', '�ε鷡��');
insert into tbl_member_202005
values ('3', '���ĺ�', 'P3', '2', '7703011999993', '���Ȳɵ�');
insert into tbl_member_202005
values ('4', '���ĺ�', 'P4', '2', '8803011999994', '���޷���');
insert into tbl_member_202005
values ('5', '���ĺ�', 'P5', '3', '9903011999995', '��������');
?
select  *  from tbl_member_202005;

drop table tbl_party_202005;

Create  table  tbl_party_202005(
 p_code   char(2)  not  null  primary  key,
 p_name  varchar(20) ,
 p_indate  date,
 p_reader  varchar(20),
 p_tel1  char(3),
 p_tel2  char(4),
 p_tel3  char(4)
);

?

insert into tbl_party_202005 (p_code, p_name,p_indate,p_reader, p_tel1,  p_tel2,  p_tel3 )
values ('P1', 'A����', '2010-01-01', '����ǥ', '02', '1111', '0001');
insert into tbl_party_202005
values ('P2', 'B����', '2010-02-01', '���ǥ', '02', '1111', '0002');
insert into tbl_party_202005
values ('P3', 'C����', '2010-03-01', '���ǥ', '02', '1111', '0003');
insert into tbl_party_202005
values ('P4', 'D����', '2010-04-01', '����ǥ', '02', '1111', '0004');
insert into tbl_party_202005
values ('P5', 'E����', '2010-05-01', '�Ӵ�ǥ', '02', '1111', '0005');

select  *  from tbl_party_202005;
drop table ss_user cascade CONSTRAINTS;
drop table ss_board cascade CONSTRAINTS;

drop sequence user_no_seq;
drop sequence ss_no_seq;

create sequence user_no_seq start with 1 increment by 1;
create sequence ss_no_seq start with 1 increment by 1;



create table ss_user(
	user_no number primary key not null,
	email varchar2(30) not null,
	password varchar2(30) not null,
	nickname varchar2(10) not null,
	visiable number default 1,
	admin number default 1
);
-- 유저 테이블
-- 유저에게서 받는 정보는 최소한으로, 로그인을 하기 위한 계정 정보인 이메일, 패스워드와
-- 글쓴이명으로 보일 닉네임만 받음.

create table ss_board(
	ss_no number primary key,
	user_no number,
	title varchar2(50),
	writer_comment varchar2(1000),
	main_content varchar2(4000),
	writer_day varchar2(10),
	hits number(10) default 0,
	recommend number(10) default 0,
	visiable number default 1,
	foreign key(user_no) references ss_user(user_no)
);

-- 게시글 테이블
-- 게시판은 글 고유번호, 글쓴이(회원테이블 외부키), 글 제목, 조회수, 글쓴 날, 추천 횟수, 비추천 횟수, 태그들, 작가 남김 말, 글 내용.
-- 태그의 경우엔 이 테이블에 넣어둘지, 따로 테이블을 빼둬야할지 고민중.

create table ss_tags(
	tag_no number;
	tag_name varchar2(10);
);

create table sstags_list(
	tag_no number;
	ss_no number;
);

select * from ss_board;
select * from ss_board where title like '%1%';
select * from (select * from ss_board where user_no = 2 and title = '타이틀입니다.' order by ss_no desc) where rownum=1;

insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-11', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다1.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-11', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다2.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-11', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다3.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-11', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다4.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-11', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다5.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-12', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다6.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-12', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다7.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-12', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다8.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-12', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다9.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-12', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다10.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-13', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다11.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-13', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다12.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-13', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다13.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-13', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다14.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-13', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-11', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다1.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-11', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다2.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-11', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다3.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-11', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다4.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-11', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다5.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-12', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다6.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-12', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다7.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-12', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다8.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-12', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다9.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-12', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다10.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-13', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다11.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-13', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다12.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-13', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다13.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-13', default, default, default);
insert into ss_board values(ss_no_seq.nextval, 2, '타이틀입니다14.', '글쓴이 코멘트', '메인 컨텐츠', '17-10-13', default, default, default);

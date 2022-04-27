use myblog;

insert into role(code,name) values('ADMIN','ADMIN');
insert into role(code,name) values('USER','USER');

insert into user(username,password,fullname,status, roleid) values('admin','e10adc3949ba59abbe56e057f20f883e','admin',1,1);
insert into user(username,password,fullname,status, roleid) values('user','e10adc3949ba59abbe56e057f20f883e','user',1,2);

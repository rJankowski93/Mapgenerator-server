create table ENCODER_RAW_DATA (
  ID BIGINT(19) auto_increment,
  LEFT BIGINT(19),
  RIGHT BIGINT(19),
);

create table ENCODER_DATA (
  ID BIGINT(19) auto_increment,
  DEGREES DOUBLE(19),
  DISTANCE DOUBLE(19),
);

create table DEVICE (
  ID BIGINT(19) auto_increment,
  NAME varchar(45),
  URL varchar(255),
  BT_ADDRESS varchar(255),
);


INSERT INTO DEVICE(ID, NAME, BT_ADDRESS, URL) VALUES (1, 'HC-06', '201412081693','btspp://201412081693:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE(ID, NAME, BT_ADDRESS, URL) VALUES (2, 'HC-07', '301912081613','btspp://301912081613:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE(ID, NAME, BT_ADDRESS, URL) VALUES (3, 'HC-08', '218412081693','btspp://218412081693:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE(ID, NAME, BT_ADDRESS, URL) VALUES (4, 'HC-09', '211412081793','btspp://211412081793:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE(ID, NAME, BT_ADDRESS, URL) VALUES (5, 'HD-12', '251412081293','btspp://251412081293:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE(ID, NAME, BT_ADDRESS, URL) VALUES (6, 'HC-02', '281412081693','btspp://281412081693:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE(ID, NAME, BT_ADDRESS, URL) VALUES (7, 'HS-03', '2414120841693','btspp://2414120841693:1;authenticate=false;encrypt=false;master=false');
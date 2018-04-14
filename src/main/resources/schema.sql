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
);

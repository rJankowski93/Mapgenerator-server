CREATE TABLE ENCODER_RAW_DATA (
  ID    BIGINT(19) AUTO_INCREMENT,
  LEFT  BIGINT(19),
  RIGHT BIGINT(19),
);

CREATE TABLE ENCODER_DATA (
  ID          BIGINT(19) AUTO_INCREMENT,
  DEGREES     DOUBLE(19),
  DISTANCE    DOUBLE(19),
  RAW_DATA_ID BIGINT(19),
);

CREATE TABLE DEVICE (
  ID         BIGINT(19) AUTO_INCREMENT,
  NAME       VARCHAR(45),
  URL        VARCHAR(255),
  BT_ADDRESS VARCHAR(255),
);


INSERT INTO DEVICE (ID, NAME, BT_ADDRESS, URL)
VALUES (1, 'HC-06', '201412081693', 'btspp://201412081693:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE (ID, NAME, BT_ADDRESS, URL)
VALUES (2, 'HC-07', '301912081613', 'btspp://301912081613:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE (ID, NAME, BT_ADDRESS, URL)
VALUES (3, 'HC-08', '218412081693', 'btspp://218412081693:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE (ID, NAME, BT_ADDRESS, URL)
VALUES (4, 'HC-09', '211412081793', 'btspp://211412081793:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE (ID, NAME, BT_ADDRESS, URL)
VALUES (5, 'HD-12', '251412081293', 'btspp://251412081293:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE (ID, NAME, BT_ADDRESS, URL)
VALUES (6, 'HC-02', '281412081693', 'btspp://281412081693:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE (ID, NAME, BT_ADDRESS, URL)
VALUES (7, 'HS-03', '2414120841693', 'btspp://2414120841693:1;authenticate=false;encrypt=false;master=false');


INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT) VALUES (1, 1300, 1200);
INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT) VALUES (2, 1300, 1200);
INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT) VALUES (3, 1300, 1200);
INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT) VALUES (4, 1300, 1200);
INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT) VALUES (5, 1300, 1200);
INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT) VALUES (6, 1300, 1200);
INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT) VALUES (7, 1300, 1200);
INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT) VALUES (8, 1300, 1200);

INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, RAW_DATA_ID) VALUES (3, 1, 5, 1);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, RAW_DATA_ID) VALUES (4, -10, 50, 2);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, RAW_DATA_ID) VALUES (5, 4, 100, 3);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, RAW_DATA_ID) VALUES (6, 3, 130, 4);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, RAW_DATA_ID) VALUES (1, 5, 123, 5);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, RAW_DATA_ID) VALUES (2, -10, 24, 6);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, RAW_DATA_ID) VALUES (7, -10, 111, 7);
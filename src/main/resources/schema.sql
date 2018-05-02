CREATE TABLE ENCODER_RAW_DATA (
  ID          BIGINT(19) AUTO_INCREMENT,
  LEFT        BIGINT(19),
  RIGHT       BIGINT(19),
  SENSOR      DOUBLE(19),
  DEVICE_NAME VARCHAR(45),
);

CREATE TABLE ENCODER_DATA (
  ID          BIGINT(19) AUTO_INCREMENT,
  DEGREES     DOUBLE(19),
  DISTANCE    DOUBLE(19),
  SENSOR      DOUBLE(19),
  RAW_DATA_ID BIGINT(19),
  DEVICE_NAME VARCHAR(45),
);

CREATE TABLE DEVICE (
  ID         BIGINT(19) AUTO_INCREMENT,
  NAME       VARCHAR(45),
  URL        VARCHAR(255),
  BT_ADDRESS VARCHAR(255),
  DISTANCE_BETWEEN_WHEELS DOUBLE(19),
);


INSERT INTO DEVICE (ID, NAME, BT_ADDRESS, URL, DISTANCE_BETWEEN_WHEELS)
VALUES (1, 'HC-06', '201412081693', 'btspp://201412081693:1;authenticate=false;encrypt=false;master=false', 1000);
INSERT INTO DEVICE (ID, NAME, BT_ADDRESS, URL, DISTANCE_BETWEEN_WHEELS)
VALUES (2, 'HC-07', '301912081613', 'btspp://301912081613:1;authenticate=false;encrypt=false;master=false', 1000);
INSERT INTO DEVICE (ID, NAME, BT_ADDRESS, URL, DISTANCE_BETWEEN_WHEELS)
VALUES (3, 'HC-08', '218412081693', 'btspp://218412081693:1;authenticate=false;encrypt=false;master=false', 1000);
INSERT INTO DEVICE (ID, NAME, BT_ADDRESS, URL)
VALUES (4, 'HC-09', '211412081793', 'btspp://211412081793:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE (ID, NAME, BT_ADDRESS, URL)
VALUES (5, 'HD-12', '251412081293', 'btspp://251412081293:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE (ID, NAME, BT_ADDRESS, URL)
VALUES (6, 'HC-02', '281412081693', 'btspp://281412081693:1;authenticate=false;encrypt=false;master=false');
INSERT INTO DEVICE (ID, NAME, BT_ADDRESS, URL)
VALUES (7, 'HS-03', '2414120841693', 'btspp://2414120841693:1;authenticate=false;encrypt=false;master=false');


INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT, DEVICE_NAME) VALUES (1, 1300, 1200, 'HC-08');
INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT, DEVICE_NAME) VALUES (2, 1300, 1200, 'HC-08');
INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT, DEVICE_NAME) VALUES (3, 1300, 1200, 'HC-08');
INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT, DEVICE_NAME) VALUES (4, 1300, 1200, 'HC-08');
INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT, DEVICE_NAME) VALUES (5, 1300, 1200, 'HC-08');
INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT, DEVICE_NAME) VALUES (6, 1300, 1200, 'HC-08');
INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT, DEVICE_NAME) VALUES (7, 1300, 1200, 'HC-08');
INSERT INTO ENCODER_RAW_DATA (ID, LEFT, RIGHT, DEVICE_NAME) VALUES (8, 1300, 1200, 'HC-08');

INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (1, -1.432096184, 2.5398, 0, 'HC-07', 1);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (2, -0.630228156, 8.721, 0, 'HC-07', 2);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (3, -0.802088513, 9.6798, 1, 'HC-07', 3);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (4, -0.114591406, 9.8328, 1, 'HC-07', 4);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (5, -1.260303847, 9.9042, 1, 'HC-07', 5);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (6, -0.171886823, 9.9144, 1, 'HC-07', 6);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (7, 27.83405394, 9.8226, 1, 'HC-07', 7);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (8, 36.01715173, 9.9144, 2, 'HC-07', 8);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (9, 4.858462919, 9.6594, 2, 'HC-07', 9);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (10, 0.171886823, 9.894, 2, 'HC-07', 10);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (11, -1.145762838, 9.9246, 3, 'HC-07', 11);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (12, -0.114591406, 9.9246, 3, 'HC-07', 12);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (13, -0.973934437, 9.9042, 4, 'HC-07', 13);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (14, -27.65453848, 10.0674, 5, 'HC-07', 14);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (15, -37.01629344, 10.149, 5, 'HC-07', 15);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (16, -8.698796155, 10.0572, 5, 'HC-07', 16);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (17, -1.661112045, 10.047, 5, 'HC-07', 17);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (18, -1.775600527, 10.0368, 6, 'HC-07', 18);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (19, -1.603862771, 10.0674, 7, 'HC-07', 19);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (20, -2.46220173, 9.9756, 8, 'HC-07', 20);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (21, -28.50196028, 10.098, 9, 'HC-07', 21);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (22, -36.35306829, 10.0164, 10, 'HC-07', 22);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (23, -8.64280258, 9.996, 9, 'HC-07', 23);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (24, -3.1480961, 9.9348, 9, 'HC-07', 24);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (25, -3.718993973, 10.0572, 9, 'HC-07', 25);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (26, -3.604869904, 10.0266, 9, 'HC-07', 26);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (27, -3.1480961, 10.1082, 9, 'HC-07', 27);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (28, 26.51919622, 9.5676, 9, 'HC-07', 28);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (29, 35.06885505, 9.7104, 9, 'HC-07', 29);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (30, 3.033837756, 9.5676, 8, 'HC-07', 30);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (31, -3.205215931, 9.9654, 8, 'HC-07', 31);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (32, -4.232173805, 10.1592, 8, 'HC-07', 32);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (33, -4.06118535, 10.1694, 8, 'HC-07', 33);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (34, -4.516985334, 10.2306, 7, 'HC-07', 34);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (35, -29.68314018, 10.149, 6, 'HC-07', 35);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (36, -39.14558932, 10.2306, 5, 'HC-07', 36);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (37, -10.8132564, 10.0164, 4, 'HC-07', 37);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (38, -4.516985334, 10.1796, 3, 'HC-07', 38);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (39, -6.673266453, 10.1592, 3, 'HC-07', 39);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (40, -3.433630362, 10.1694, 3, 'HC-07', 40);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (41, -6.333903108, 10.1694, 2, 'HC-07', 41);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (42, -1.374834781, 4.4982, 1, 'HC-07', 42);
INSERT INTO ENCODER_DATA (ID, DEGREES, DISTANCE, SENSOR, DEVICE_NAME, RAW_DATA_ID)
VALUES (43, 0.114591406, 0.0306, 1, 'HC-07', 43);

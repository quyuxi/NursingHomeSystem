-- 养老院数据
insert into NursingHome
values ('01', '养老院-test-1');
insert into NursingHome
values ('02', '养老院-test-2');
-- 手环XINXI

INSERT INTO RingInfo
VALUES ('93010001', 100, '2020-05-30');
INSERT INTO RingInfo
VALUES ('93010002', 100, '2020-05-30');
INSERT INTO RingInfo
VALUES ('93010003', 100, '2020-05-30');
INSERT INTO RingInfo
VALUES ('93010004', 100, '2020-05-30');
INSERT INTO RingInfo
VALUES ('93010005', 100, '2020-05-30');


-- 老人数据
insert into Elder
values ('93010001', '张一', '男', '1970-01-01', '13323345568', '611000000000000000', '2020-05-30', '壶天大世界', '');



SELECT
    t1.ring_id,
    t3.battery,
    t2.heartRate,
    t2.bloodPressuer,
    t2.temperature,
    t1.lng,
    t1.lat,
    t1.date_time as time
FROM Position as t1
         left join PhysicalData as t2 on t1.date_time=t2.date_time

         left join  RingInfo as t3 on t2.ring_id = t3.ring_id

where t1.ring_id=93010002 and t1.date_time > '2020-06-01' and t1.date_time < '2020-07-01'

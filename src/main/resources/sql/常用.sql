SELECT *
FROM
    Position as t1,
    Posture as t2,
    Physiological as t3,
    RingInfo as t4
WHERE
        t1.date_time=t2.date_time
  and t2.date_time=t3.date_time
  and t3.date_time=t4.date_time
  and t1.date_time > '2020-05-30 11:34:10' and t1.date_time < '2020-05-30 11:54:12'

;


# delete from Posture;
# delete from Position;
# delete from Physiological;
# delete from RingInfo;
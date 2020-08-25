import datetime as dt

d1 = dt.datetime.strptime('2018-07-12 00:00:00','%Y-%m-%d %H:%M:%S')
#print(d1)
#print(((dt("2018-07-12 00:00:00")-dt("2000,01,01,00,00,00")).total_days() + 101))

#date_key_f = udf(lambda x: ((dt.datetime.strptime(x,'%Y-%m-%d %H:%M:%S')-dt.datetime.strptime('2000-01-01 00:00:00','%Y-%m-%d %H:%M:%S')).total_days() + 101), IntegerType())
x = '2000-01-01 00:00:00'
d1 = dt.datetime.strptime(x,'%Y-%m-%d %H:%M:%S')
d2 = dt.datetime.strptime('2000-01-01 00:00:00','%Y-%m-%d %H:%M:%S')
d = (d1-d2).days
print(d)
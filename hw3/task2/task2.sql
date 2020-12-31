SELECT expenses.num, paydate, name, value 
FROM listexpenses.receivers, listexpenses.expenses 
where value > 10000 and receiver=receivers.num
order by num;

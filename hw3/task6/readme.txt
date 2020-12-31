Задание 6
Составить следующие запросы:
вывести список получателей платежей, и сумму платежей по каждому из них;
вывести сумму платежей за тот день, когда был наибольший платеж;
вывести наибольший платеж за тот день, когда сумма платежей была наибольшей.

Запросы представлены в файлах sql1, sql2, sql3 соответственно.

SELECT receivers.name, sum(expenses.value) FROM expenses join receivers where receivers.num = expenses.receiver group by receivers.name;

SELECT paydate,SUM(value) FROM expenses GROUP BY paydate HAVING SUM(value)>=(SELECT SUM(value) FROM expenses GROUP BY paydate ORDER BY SUM(value) DESC LIMIT 1);

SELECT max(max) FROM (SELECT paydate,sum(value) sum_val, max(value) max FROM expenses GROUP BY paydate) sub_tab;
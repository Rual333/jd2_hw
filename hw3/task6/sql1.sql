
SELECT receivers.name, sum(expenses.value) FROM expenses join receivers where receivers.num = expenses.receiver group by receivers.name;
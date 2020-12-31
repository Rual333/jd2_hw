
	

SELECT paydate,SUM(value) FROM expenses GROUP BY paydate HAVING SUM(value)>=(SELECT SUM(value) FROM expenses GROUP BY paydate ORDER BY SUM(value) DESC LIMIT 1);
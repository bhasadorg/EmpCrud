CREATE DEFINER=`bc93d5b8e98740`@`%` PROCEDURE `return_salesRep`()
BEGIN

	DECLARE done INT DEFAULT FALSE;
	DECLARE myid INT;
	DECLARE cur1 CURSOR FOR SELECT employeeNumber from employees WHERE jobTitle = 'Sales Rep' ;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

	OPEN cur1;

	read_loop: LOOP
		IF done THEN
			LEAVE read_loop;
		END IF;

		FETCH cur1 INTO myid;
        SELECT e.firstName, e.lastName, e.email, o.city from employees e, offices o WHERE
        e.officeCode=o.officeCode AND e.employeeNumber=myid;
		#UPDATE table1 SET firstname = (SELECT firstname from table2 WHERE id = myid)
		#WHERE id = myid;
	END LOOP;

	close cur1;

END
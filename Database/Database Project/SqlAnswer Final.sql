	--USE RamenShop
	--FINAL
	--1
	SELECT 	r.RamenId AS [RamenID], r.RamenName, COUNT(rc.IngredientId) AS [Total Ingredient]
	FROM Ramen r
	JOIN Recipe rc ON r.RamenId = rc.RamenId
	JOIN Ingredient ig ON rc.IngredientId = ig.IngredientId
	WHERE ig.IngredientName LIKE '%Ingredients' AND ig.IngredientStock < 25
	GROUP BY r.RamenId, r.RamenName
	HAVING COUNT(rc.IngredientId) > 1

	--2
	SELECT COUNT(st.SalesId) AS [Number of Sales], cs.CustomerName, LEFT(cs.CustomerGender,1) AS [Gender], s.StaffName
	FROM SalesTransaction st
	JOIN Staff s ON st.StaffId = s.StaffId
	JOIN Customer cs ON st.CustomerId = cs.CustomerId
	WHERE s.StaffGender LIKE 'Female' AND ABS(CAST(YEAR(s.StaffDOB)AS int) - CAST(YEAR(cs.CustomerDOB)AS int)) > 5
	GROUP BY cs.CustomerName, s.StaffName, cs.CustomerGender


	--3
	SELECT CONVERT(VARCHAR(20), pt.PurchaseDate, 103) AS [Purchase Date], s.StaffName, sp.SupplierName, COUNT(ptd.IngredientId) AS [Total Ingredient], SUM(ptd.PurchaseQuantity) AS [Total Quantity] 
	FROM PurchaseTransaction pt
	JOIN Staff s ON pt.StaffId = s.StaffId
	JOIN Supplier sp ON pt.SupplierId = sp.SupplierId
	JOIN PurchaseTransactionDetail ptd ON pt.PurchaseId = ptd.PurchaseId
	WHERE YEAR(pt.PurchaseDate) = 2016 AND LEN(sp.SupplierName) < 15
	GROUP BY pt.PurchaseId, pt.PurchaseDate, s.StaffName, sp.SupplierName

	--4
	SELECT cm.CustomerName, cm.CustomerPhone, DATENAME(WEEKDAY, st.SalesDate) AS [Sales Day], COUNT(std.RamenId) AS [Variant Ramen Sold]
	FROM SalesTransaction st
	JOIN Customer cm ON st.CustomerId = cm.CustomerId
	JOIN SalesTransactionDetail std ON st.SalesId = std.SalesId
	WHERE MONTH(st.SalesDate) = 3
	GROUP BY st.SalesId, cm.CustomerName, cm.CustomerPhone, st.SalesDate
	HAVING SUM(std.Quantity) > 10


	--5
	SELECT pt.PurchaseId AS [PurchaseID], it.IngredientName AS [Ramen Ingredient Name], ptd.PurchaseQuantity AS [Quantity], ms.StaffName, REPLACE(ms.StaffPhone, '0', '+62') AS [Staff Phone],  [Staff Salary] = 'Rp. '+ CAST(ms.StaffSalary AS VARCHAR)
	FROM PurchaseTransaction pt, PurchaseTransactionDetail ptd, Staff ms , Ingredient it,
	(SELECT AVG(StaffSalary) AS Average FROM Staff) AS x
	WHERE pt.PurchaseId = ptd.PurchaseId AND
	ms.StaffId = pt.StaffId AND
	it.IngredientId = ptd.IngredientId AND
	ms.StaffSalary > x.Average AND YEAR(PurchaseDate) = 2017

	--6
	SELECT REPLACE(ms.StaffId, 'ST', 'Staff ') AS [StaffId], ms.StaffName, CONVERT(VARCHAR, st.SalesDate, 107) AS [Sales Date], std.Quantity
	FROM Staff ms, SalesTransaction st, SalesTransactionDetail std, 
	(SELECT AVG(StaffSalary) AS Average FROM Staff) AS x
	WHERE ms.StaffId = st.StaffId AND
	st.SalesId = std.SalesId AND
	ms.StaffName LIKE '% % %' AND
	ms.StaffSalary < x.Average

	--7
	SELECT COUNT(std.RamenId) AS [Total Ramen Sold], REVERSE(SUBSTRING(REVERSE(mc.CustomerName), 1, CHARINDEX(' ', REVERSE(mc.CustomerName)) - 1)) AS [Customer Last Name], ms.StaffName, st.SalesDate
	FROM Staff ms, SalesTransaction st, Customer mc, SalesTransactionDetail std,
	(SELECT AVG(Quantity) AS Average FROM SalesTransactionDetail) AS x
	WHERE ms.StaffId = st.StaffId AND
	st.SalesId = std.SalesId AND
	mc.CustomerId = st.CustomerId AND
	std.Quantity < x.Average AND
	LEN(mc.CustomerName) > 15
	GROUP BY mc.CustomerName,  ms.StaffName, st.SalesDate

	--8
	SELECT st.SalesId AS [SalesID], mc.CustomerName, LEFT(mc.CustomerGender, 1) AS [Gender], mr.RamenName AS [Ramen Name], CAST(SUM(mr.RamenPrice) AS varchar) + ' IDR' AS [Total Price]
	FROM SalesTransaction st, Customer mc, SalesTransactionDetail std, Ramen mr,
	(SELECT MIN(RamenPrice) AS Mini
	FROM Ramen) AS X
	WHERE st.CustomerId = mc.CustomerId AND
	st.SalesId = std.SalesId AND
	Std.RamenId = mr.RamenId AND
	mr.RamenPrice > x.Mini AND
	DATEDIFF(YEAR, GETDATE(), mc.CustomerDOB) < 17
	GROUP BY st.SalesId, mc.CustomerName, mc.CustomerGender, mr.RamenName

	--9

	CREATE VIEW ViewSales
	AS
	SELECT cs.CustomerName, COUNT(st.SalesId) AS [Number of Sales], (rm.RamenPrice * std.Quantity) AS [Total Price]
	FROM Customer cs
	JOIN SalesTransaction st ON cs.CustomerId = st.CustomerId
	JOIN SalesTransactionDetail std ON st.SalesId = std.SalesId
	JOIN Ramen rm ON std.RamenId = rm.RamenId
	WHERE YEAR(st.SalesDate) < 2017
	AND cs.CustomerAddress LIKE 'Pasar%'
	GROUP BY cs.CustomerName , st.SalesId, rm.RamenPrice, std.Quantity

	--SELECT * FROM ViewSales

	--10

	CREATE VIEW PurchaseDetail
	AS
	SELECT CAST(SUM(ptd.PurchaseQuantity) AS VARCHAR) + ' Pcs' AS [Number of Item Purchased],COUNT(DISTINCT pt.PurchaseId) AS [Number of Transaction], SupplierName, StaffName
	FROM PurchaseTransaction pt
	JOIN PurchaseTransactionDetail ptd ON pt.PurchaseId = ptd.PurchaseId
	JOIN Supplier sp ON pt.SupplierId = sp.SupplierId
	JOIN Staff sf ON pt.StaffId = sf.StaffId
	WHERE YEAR(pt.PurchaseDate) = 2016
	AND sf.StaffGender LIKE 'Male'
	GROUP BY sp.SupplierName, sf.StaffName

	--SELECT * FROM PurchaseDetail
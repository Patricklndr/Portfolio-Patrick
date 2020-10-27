--d. Simulasi Transaction 
BEGIN TRAN
INSERT INTO Ingredient VALUES
('RI101', 'Crab Stick', 10) --Ingredient yang diperlukan  

INSERT INTO Supplier VALUES
('SP100', 'Toko Achiang', 'Pasar Baru No 88 Street', '081256778199') --Supplier dari Crabstick Tersebut

INSERT INTO Ramen VALUES
('RA100', 'Nobukatsu Ramen', 50000) --Menu Ramen yang ad di toko

INSERT INTO Staff VALUES
('ST100', 'Jeremy Clarke', 'Male', '09/11/1989', 'Gajahmada 88 Street', '0821374638125', 1600000) -- Personal Info Staff Dari Ramen Shop

INSERT INTO Customer VALUES
('CU101', 'Budi Setiawan', '10/06/1990', 'Male', 'Milliarder Street', '081230277398') --Customer Personal Info and Data

INSERT INTO Recipe VALUES
('RA100', 'RI101', 2) --Resep untuk Nobukatsu Ramen

-----------------------------------------------------------------------------------------------------------------------------------------------------
--							>>SIMULATE TRANSACTION<<
------------------------------------------------------------------------------------------------------------------------------------------------------

--Toko Ramen ingin membeli stock bahan baku Crabstick sebanyak 10 Pcs
--Transaksi pembelian stock bahan baku dilakukan pada tanggal 11 November 2019 
--Pembelian dilakukan dari supplier berkode 'SP100' yaitu Toko Achiang yang beralamt pada Pasar Baru No 88
--Pembelian ini dikerjakan oleh Staff berkode 'ST100' yang bernama Jeremy Clarke
--Transaksi pembelian ini berkode 'PU100'
BEGIN TRAN
INSERT INTO PurchaseTransaction VALUES
('PU100','ST100','SP100','11/11/2019')

--Transaksi pembelian berkode 'PU100' 
--Transaksi untuk ingredient berkode 'RI101' (Crab Stick) yang dibeli sebanyak 10 Pcs
INSERT INTO PurchaseTransactionDetail VALUES
('PU100', 'RI101', 10)


--Customer dengan kode 'CU101' bernama Budi Setiawan ingin membeli ramen
--Transaksi pembelian ramen dilakukan pada tanggal 27 November 2019
--Staff yang melayani penjualan ramen berkode 'ST100' bernama Jeremy Clarke
--Transaksi penjualan ini berkode 'SL100'
INSERT INTO SalesTransaction VALUES
('SL100','ST100','CU101','11/27/2019')

--Transaksi penjualan berkode 'SL100' menjual Nobukatsu Ramen yang berkode 'RA100' sebanyak 15 porsi
INSERT INTO  SalesTransactionDetail VALUES
('SL100', 'RA100', 5)


-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: qlthuvien
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bandoc`
--

DROP TABLE IF EXISTS `bandoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bandoc` (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `malop` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idbandoc_UNIQUE` (`id`),
  KEY `id_idx` (`id`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `nguoidung` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bandoc`
--

LOCK TABLES `bandoc` WRITE;
/*!40000 ALTER TABLE `bandoc` DISABLE KEYS */;
INSERT INTO `bandoc` VALUES ('BD01','IT256'),('BD02','IT842'),('BD03','IT453');
/*!40000 ALTER TABLE `bandoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `idnvthuvien` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idnvtvhd_idx` (`idnvthuvien`),
  CONSTRAINT `idnvtvhd` FOREIGN KEY (`idnvthuvien`) REFERENCES `nvthuvien` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `luotmuon`
--

DROP TABLE IF EXISTS `luotmuon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `luotmuon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ngaymuon` date NOT NULL,
  `ngayphaitra` date DEFAULT NULL,
  `mota` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mathebandoc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `matailieu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phieumuonid` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `matbd_idx` (`mathebandoc`),
  KEY `matl_idx` (`matailieu`),
  KEY `mapm_idx` (`phieumuonid`),
  CONSTRAINT `mapm` FOREIGN KEY (`phieumuonid`) REFERENCES `phieumuon` (`id`),
  CONSTRAINT `matbd` FOREIGN KEY (`mathebandoc`) REFERENCES `thebandoc` (`mathe`),
  CONSTRAINT `matl` FOREIGN KEY (`matailieu`) REFERENCES `tailieu` (`matailieu`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luotmuon`
--

LOCK TABLES `luotmuon` WRITE;
/*!40000 ALTER TABLE `luotmuon` DISABLE KEYS */;
INSERT INTO `luotmuon` VALUES (1,'2021-11-09','2021-12-22','','TBD2','TL02',1),(2,'2021-11-09','2021-12-22','','TBD2','TL03',1),(3,'2021-11-09','2021-12-22','','TBD2','TL06',1),(4,'2021-11-10','2021-12-22','','TBD1','TL01',2),(5,'2021-11-10','2021-12-22','','TBD1','TL06',2),(6,'2021-11-10','2021-12-22','','TBD1','TL05',2);
/*!40000 ALTER TABLE `luotmuon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `luotnhap`
--

DROP TABLE IF EXISTS `luotnhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `luotnhap` (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `soluong` int DEFAULT NULL,
  `gia` float DEFAULT NULL,
  `ngaynhap` date DEFAULT NULL,
  `mancc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `matailieu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `idhoadon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `matlln_idx` (`matailieu`),
  KEY `mancc_idx` (`mancc`),
  KEY `idhoadon_idx` (`idhoadon`),
  CONSTRAINT `idhoadon` FOREIGN KEY (`idhoadon`) REFERENCES `hoadon` (`id`),
  CONSTRAINT `mancc` FOREIGN KEY (`mancc`) REFERENCES `nhacungcap` (`mancc`),
  CONSTRAINT `matlln` FOREIGN KEY (`matailieu`) REFERENCES `tailieu` (`matailieu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luotnhap`
--

LOCK TABLES `luotnhap` WRITE;
/*!40000 ALTER TABLE `luotnhap` DISABLE KEYS */;
/*!40000 ALTER TABLE `luotnhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `luottra`
--

DROP TABLE IF EXISTS `luottra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `luottra` (
  `idluotmuon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ngaytra` date DEFAULT NULL,
  `tonthat` int DEFAULT NULL,
  `mota` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idphieutra` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idluotmuon`),
  KEY `idphieutra_idx` (`idphieutra`),
  CONSTRAINT `idphieutra` FOREIGN KEY (`idphieutra`) REFERENCES `phieutra` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luottra`
--

LOCK TABLES `luottra` WRITE;
/*!40000 ALTER TABLE `luottra` DISABLE KEYS */;
/*!40000 ALTER TABLE `luottra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoidung`
--

DROP TABLE IF EXISTS `nguoidung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoidung` (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tentaikhoan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `matkhau` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sdt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `diachi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `tentaikhoan_UNIQUE` (`tentaikhoan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoidung`
--

LOCK TABLES `nguoidung` WRITE;
/*!40000 ALTER TABLE `nguoidung` DISABLE KEYS */;
INSERT INTO `nguoidung` VALUES ('BD01','bandoc01','bandoc01','Nguyễn Văn A','0532549534','Hà Đông, Hà Nội','1999-05-15'),('BD02','bandoc02','bandoc02','Trần Văn B','0579632541','Thanh Hóa','2000-09-09'),('BD03','bandoc03','bandoc03','Nguyễn Thị C','0648976512','Sài Gòn','2005-02-12'),('NV01','nhanvien01','nhanvien01','Nguyễn Đức Mạnh','0679841321','Quảng Bình','2001-03-25'),('NV02','nhanvien02','nhanvien02','Hồ Quang Hiếu','0654987562','Hà Tây','1989-12-31'),('QL01','quanli01','quanli01','Trần Thu Hằng','0984561321','Đông Bắc','1998-01-01');
/*!40000 ALTER TABLE `nguoidung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhacungcap` (
  `mancc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ten` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `diachi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sdt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`mancc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nvquanli`
--

DROP TABLE IF EXISTS `nvquanli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nvquanli` (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bophan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `idquanly` FOREIGN KEY (`id`) REFERENCES `nguoidung` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nvquanli`
--

LOCK TABLES `nvquanli` WRITE;
/*!40000 ALTER TABLE `nvquanli` DISABLE KEYS */;
INSERT INTO `nvquanli` VALUES ('QL01','Chăm sóc khách hàng');
/*!40000 ALTER TABLE `nvquanli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nvthuvien`
--

DROP TABLE IF EXISTS `nvthuvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nvthuvien` (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vitri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `idnv` FOREIGN KEY (`id`) REFERENCES `nguoidung` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nvthuvien`
--

LOCK TABLES `nvthuvien` WRITE;
/*!40000 ALTER TABLE `nvthuvien` DISABLE KEYS */;
INSERT INTO `nvthuvien` VALUES ('NV01','Lao công'),('NV02','Bán hàng');
/*!40000 ALTER TABLE `nvthuvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieumuon`
--

DROP TABLE IF EXISTS `phieumuon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieumuon` (
  `id` int NOT NULL,
  `idnvthuvien` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`idnvthuvien`),
  CONSTRAINT `idnhanvien` FOREIGN KEY (`idnvthuvien`) REFERENCES `nvthuvien` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieumuon`
--

LOCK TABLES `phieumuon` WRITE;
/*!40000 ALTER TABLE `phieumuon` DISABLE KEYS */;
INSERT INTO `phieumuon` VALUES (1,'NV02'),(2,'NV02');
/*!40000 ALTER TABLE `phieumuon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieutra`
--

DROP TABLE IF EXISTS `phieutra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieutra` (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `idnvthuvien` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idnvtvpt_idx` (`idnvthuvien`),
  CONSTRAINT `idnvtvpt` FOREIGN KEY (`idnvthuvien`) REFERENCES `nvthuvien` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieutra`
--

LOCK TABLES `phieutra` WRITE;
/*!40000 ALTER TABLE `phieutra` DISABLE KEYS */;
/*!40000 ALTER TABLE `phieutra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tailieu`
--

DROP TABLE IF EXISTS `tailieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tailieu` (
  `matailieu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ten` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gia` float unsigned zerofill DEFAULT NULL,
  `nxb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `soluong` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tacgia` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`matailieu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tailieu`
--

LOCK TABLES `tailieu` WRITE;
/*!40000 ALTER TABLE `tailieu` DISABLE KEYS */;
INSERT INTO `tailieu` VALUES ('TL01','Lão Hạc',000000050000,'Kim Đồng','5','Nam Cao'),('TL02','Tôi Thấy Hoa Vàng Trên Cỏ Xanh',000000125024,'Thiên Thu','5','Nguyễn Nhật Ánh'),('TL03','Mưa Rào',000000056320,'NXB Trẻ','3','Nhật Duy'),('TL04','TopDev',000000125364,'Algrithm','6','DevPro'),('TL05','300 bài code thiếu nhi',000000205432,'NXB Phan Anh','4','DevSky'),('TL06','Hack não tiếng anh',000000752032,'NXB Văn Hiệp','8','Nguyễn Văn Hiệp');
/*!40000 ALTER TABLE `tailieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thebandoc`
--

DROP TABLE IF EXISTS `thebandoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thebandoc` (
  `mathe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `loaithe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idbandoc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`mathe`),
  UNIQUE KEY `idbandoc_UNIQUE` (`idbandoc`),
  UNIQUE KEY `mathe_UNIQUE` (`mathe`),
  KEY `id_idx` (`loaithe`),
  KEY `idthebd_idx` (`idbandoc`),
  CONSTRAINT `idthebd` FOREIGN KEY (`idbandoc`) REFERENCES `bandoc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thebandoc`
--

LOCK TABLES `thebandoc` WRITE;
/*!40000 ALTER TABLE `thebandoc` DISABLE KEYS */;
INSERT INTO `thebandoc` VALUES ('TBD1','Thường','BD01'),('TBD2','VIP','BD02');
/*!40000 ALTER TABLE `thebandoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-10 18:11:11

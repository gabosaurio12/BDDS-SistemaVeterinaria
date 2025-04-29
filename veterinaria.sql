-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: veterinaria
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cita` (
  `idCita` int NOT NULL AUTO_INCREMENT,
  `tratamiento` text,
  `motivoDeConsulta` text,
  `estadoDeCita` varchar(50) DEFAULT NULL,
  `numeroDeINE` int NOT NULL,
  `idMascota` int NOT NULL,
  `Cedula` int NOT NULL,
  PRIMARY KEY (`idCita`,`numeroDeINE`,`idMascota`,`Cedula`),
  KEY `numeroDeINE` (`numeroDeINE`),
  KEY `idMascota` (`idMascota`),
  KEY `Cedula` (`Cedula`),
  CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`numeroDeINE`) REFERENCES `secretaria` (`numeroDeINE`),
  CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`idMascota`) REFERENCES `mascota` (`idMascota`),
  CONSTRAINT `cita_ibfk_3` FOREIGN KEY (`Cedula`) REFERENCES `veterinario` (`Cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cita_enfermedad`
--

DROP TABLE IF EXISTS `cita_enfermedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cita_enfermedad` (
  `idCita` int NOT NULL,
  `idEnfermedad` int NOT NULL,
  PRIMARY KEY (`idCita`,`idEnfermedad`),
  KEY `idEnfermedad` (`idEnfermedad`),
  CONSTRAINT `cita_enfermedad_ibfk_1` FOREIGN KEY (`idCita`) REFERENCES `cita` (`idCita`),
  CONSTRAINT `cita_enfermedad_ibfk_2` FOREIGN KEY (`idEnfermedad`) REFERENCES `enfermedad` (`idEnfermedad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `idDuenio` int NOT NULL,
  `idProducto` int NOT NULL,
  PRIMARY KEY (`idDuenio`,`idProducto`),
  KEY `idProducto` (`idProducto`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`idDuenio`) REFERENCES `dueno` (`idDuenio`),
  CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `direccion_dueno`
--

DROP TABLE IF EXISTS `direccion_dueno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direccion_dueno` (
  `numeroDeCasa` int NOT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `colonia` varchar(255) DEFAULT NULL,
  `idDuenio` int DEFAULT NULL,
  PRIMARY KEY (`numeroDeCasa`),
  KEY `idDuenio` (`idDuenio`),
  CONSTRAINT `direccion_dueno_ibfk_1` FOREIGN KEY (`idDuenio`) REFERENCES `dueno` (`idDuenio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `direccion_secretaria`
--

DROP TABLE IF EXISTS `direccion_secretaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direccion_secretaria` (
  `numeroDeCasa` int NOT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `colonia` varchar(255) DEFAULT NULL,
  `numeroDeINE` int DEFAULT NULL,
  PRIMARY KEY (`numeroDeCasa`),
  KEY `numeroDeINE` (`numeroDeINE`),
  CONSTRAINT `direccion_secretaria_ibfk_1` FOREIGN KEY (`numeroDeINE`) REFERENCES `secretaria` (`numeroDeINE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `direccion_veterinario`
--

DROP TABLE IF EXISTS `direccion_veterinario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direccion_veterinario` (
  `numeroDeCasa` int NOT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `colonia` varchar(255) DEFAULT NULL,
  `cedula` int DEFAULT NULL,
  PRIMARY KEY (`numeroDeCasa`),
  KEY `cedula` (`cedula`),
  CONSTRAINT `direccion_veterinario_ibfk_1` FOREIGN KEY (`cedula`) REFERENCES `veterinario` (`Cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dueno`
--

DROP TABLE IF EXISTS `dueno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dueno` (
  `idDuenio` int NOT NULL AUTO_INCREMENT,
  `telefono` int DEFAULT NULL,
  `nombreCompleto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idDuenio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `enfermedad`
--

DROP TABLE IF EXISTS `enfermedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enfermedad` (
  `idEnfermedad` int NOT NULL AUTO_INCREMENT,
  `nombreDeEnfermedad` varchar(255) DEFAULT NULL,
  `clasificacionDeEspecie` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idEnfermedad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fechacita_cita`
--

DROP TABLE IF EXISTS `fechacita_cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fechacita_cita` (
  `idCita` int NOT NULL,
  `dia` int DEFAULT NULL,
  `mes` int DEFAULT NULL,
  `anio` int DEFAULT NULL,
  `hora` time DEFAULT NULL,
  PRIMARY KEY (`idCita`),
  CONSTRAINT `fechacita_cita_ibfk_1` FOREIGN KEY (`idCita`) REFERENCES `cita` (`idCita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mascota`
--

DROP TABLE IF EXISTS `mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mascota` (
  `idMascota` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `fechaDeNacimiento` date DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `peso` decimal(10,2) DEFAULT NULL,
  `idDuenio` int DEFAULT NULL,
  PRIMARY KEY (`idMascota`),
  KEY `idDuenio` (`idDuenio`),
  CONSTRAINT `mascota_ibfk_1` FOREIGN KEY (`idDuenio`) REFERENCES `dueno` (`idDuenio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `existencia` int DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `especie` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `secretaria`
--

DROP TABLE IF EXISTS `secretaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `secretaria` (
  `numeroDeINE` int NOT NULL AUTO_INCREMENT,
  `nombreCompleto` varchar(255) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `nombreDeUsuario` varchar(50) DEFAULT NULL,
  `contrasenia` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numeroDeINE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `veterinario`
--

DROP TABLE IF EXISTS `veterinario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veterinario` (
  `Cedula` int NOT NULL,
  `nombreCompleto` varchar(255) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `nombreDeUsuario` varchar(50) DEFAULT NULL,
  `contrasenia` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-04 23:48:52

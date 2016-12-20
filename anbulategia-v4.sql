-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-12-2016 a las 12:54:36
-- Versión del servidor: 5.6.26
-- Versión de PHP: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `anbulategia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bajadokumentua`
--

CREATE TABLE IF NOT EXISTS `bajadokumentua` (
  `DokumentuId` int(11) NOT NULL,
  `Baja` date NOT NULL,
  `Alta` date NOT NULL,
  `BajaArrazoia` text NOT NULL,
  `AltaArrazoia` text NOT NULL,
  `GSZ` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bajadokumentua`
--

INSERT INTO `bajadokumentua` (`DokumentuId`, `Baja`, `Alta`, `BajaArrazoia`, `AltaArrazoia`, `GSZ`) VALUES
(1, '2016-12-20', '2016-12-27', 'Rotura de ligamento lateral derecho', '', 72539302);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `errezeta`
--

CREATE TABLE IF NOT EXISTS `errezeta` (
  `ErrezetaId` int(11) NOT NULL,
  `Botika` text NOT NULL,
  `Data` date NOT NULL,
  `GSZ` int(11) NOT NULL,
  `Iraupena` int(11) NOT NULL,
  `Aginduak` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `errezeta`
--

INSERT INTO `errezeta` (`ErrezetaId`, `Botika`, `Data`, `GSZ`, `Iraupena`, `Aginduak`) VALUES
(1, 'Tryptanol', '2016-12-20', 72539302, 10, 'Gauero oihera joan aurretik dosi bat');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `espezialista`
--

CREATE TABLE IF NOT EXISTS `espezialista` (
  `SNan` int(11) NOT NULL,
  `Espezialitatea` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gaisoa`
--

CREATE TABLE IF NOT EXISTS `gaisoa` (
  `GSZ` int(11) NOT NULL,
  `Izena` text NOT NULL,
  `Abizena1` text NOT NULL,
  `Abizena2` text NOT NULL,
  `Telefonoa` int(11) NOT NULL,
  `Herria` text NOT NULL,
  `Adina` int(11) NOT NULL,
  `Pasahitza` text NOT NULL,
  `SNan` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `gaisoa`
--

INSERT INTO `gaisoa` (`GSZ`, `Izena`, `Abizena1`, `Abizena2`, `Telefonoa`, `Herria`, `Adina`, `Pasahitza`, `SNan`) VALUES
(72539302, 'Inaki', 'Landa', 'Sainz', 943658545, 'Tolosa', 21, '123456', '72539302');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE IF NOT EXISTS `historial` (
  `HistorialId` int(11) NOT NULL,
  `GSZ` int(11) NOT NULL,
  `Gaixotasuna` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`HistorialId`, `GSZ`, `Gaixotasuna`) VALUES
(1, 72539302, 'Eskizofrenia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `idazkaria`
--

CREATE TABLE IF NOT EXISTS `idazkaria` (
  `Id` int(11) NOT NULL,
  `Pasahitza` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `idazkaria`
--

INSERT INTO `idazkaria` (`Id`, `Pasahitza`) VALUES
(11111, '123456'),
(22222, '654321');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `kontsulta`
--

CREATE TABLE IF NOT EXISTS `kontsulta` (
  `GSZ` int(11) NOT NULL,
  `Id` int(11) NOT NULL,
  `Ordua` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `kontsulta`
--

INSERT INTO `kontsulta` (`GSZ`, `Id`, `Ordua`) VALUES
(72539302, 11111, '2016-12-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sendagilea`
--

CREATE TABLE IF NOT EXISTS `sendagilea` (
  `SNan` varchar(8) NOT NULL,
  `Izena` text NOT NULL,
  `Abizena` text NOT NULL,
  `Pasahitza` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sendagilea`
--

INSERT INTO `sendagilea` (`SNan`, `Izena`, `Abizena`, `Pasahitza`) VALUES
('72539302', 'Mikel', 'Badiola', '123456'),
('98765432', 'Utzi', 'Otamendi', '123456');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bajadokumentua`
--
ALTER TABLE `bajadokumentua`
  ADD PRIMARY KEY (`DokumentuId`,`GSZ`),
  ADD KEY `bajadokumentua_ibfk_1` (`GSZ`);

--
-- Indices de la tabla `espezialista`
--
ALTER TABLE `espezialista`
  ADD PRIMARY KEY (`SNan`);

--
-- Indices de la tabla `gaisoa`
--
ALTER TABLE `gaisoa`
  ADD PRIMARY KEY (`GSZ`);

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`HistorialId`);

--
-- Indices de la tabla `idazkaria`
--
ALTER TABLE `idazkaria`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `kontsulta`
--
ALTER TABLE `kontsulta`
  ADD PRIMARY KEY (`GSZ`,`Ordua`);

--
-- Indices de la tabla `sendagilea`
--
ALTER TABLE `sendagilea`
  ADD PRIMARY KEY (`SNan`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bajadokumentua`
--
ALTER TABLE `bajadokumentua`
  MODIFY `DokumentuId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `historial`
--
ALTER TABLE `historial`
  MODIFY `HistorialId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bajadokumentua`
--
ALTER TABLE `bajadokumentua`
  ADD CONSTRAINT `bajadokumentua_ibfk_1` FOREIGN KEY (`GSZ`) REFERENCES `gaisoa` (`GSZ`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

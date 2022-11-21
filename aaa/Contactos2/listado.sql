-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-05-2017 a las 15:16:14
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `listado`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contactos`
--

CREATE TABLE IF NOT EXISTS `contactos` (
  `IdContactos` int(5) NOT NULL,
  `Nombres` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `Apellidos` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Edad` int(2) NOT NULL,
  PRIMARY KEY (`IdContactos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `contactos`
--

INSERT INTO `contactos` (`IdContactos`, `Nombres`, `Apellidos`, `Edad`) VALUES
(1, 'Alejandro', 'Castañeda', 12),
(2, 'JuanITA', 'PerezOSO', 55),
(3, 'Hugo', 'Pelaez', 66),
(4, 'Patricia', 'Velasquez', 24),
(5, 'Keiko', 'Salas', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE IF NOT EXISTS `departamentos` (
  `IdDpto` int(3) NOT NULL AUTO_INCREMENT,
  `NombreDpto` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `Poblacion` int(6) DEFAULT NULL,
  `IdPais` int(11) NOT NULL,
  PRIMARY KEY (`IdDpto`),
  KEY `IdPais` (`IdPais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paises`
--

CREATE TABLE IF NOT EXISTS `paises` (
  `IdPais` int(11) NOT NULL AUTO_INCREMENT,
  `NombrePais` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`IdPais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD CONSTRAINT `departamentos_ibfk_1` FOREIGN KEY (`IdPais`) REFERENCES `paises` (`IdPais`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 04, 2019 at 01:37 PM
-- Server version: 5.6.35
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `f1`
--

-- --------------------------------------------------------

--
-- Table structure for table `pilotos`
--

CREATE TABLE `pilotos` (
  `id` int(11) NOT NULL,
  `piloto` char(100) NOT NULL,
  `equipo` char(100) NOT NULL,
  `motor` char(100) NOT NULL,
  `pais` char(100) NOT NULL,
  `edad` char(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pilotos`
--

INSERT INTO `pilotos` (`id`, `piloto`, `equipo`, `motor`, `pais`, `edad`) VALUES
(1, 'Lewis Hamilton', 'Mercedes', 'Mercedes AMG F1 M08 EQ Power+', 'UK', '32'),
(2, 'Valtteri Bottas', 'Mercedes', 'Mercedes AMG F1 M08 EQ Power+', 'Finlandia', '28'),
(3, 'Daniel', 'RedBull', 'Renault', 'Australia', '28'),
(4, 'Max Verstappen', 'RedBull', 'Renault', 'Holanda', '19'),
(5, 'Sebastian Vettel', 'Ferrari', 'Ferrari 062', 'Alemania', '30'),
(6, 'Kimi Räikkönen', 'Ferrari', 'Ferrari 062', 'Finlandia', '37'),
(7, 'Sergio Pérez', 'Force India', 'Mercedes-AMG F1 M08 EQ Power+', 'México', '27'),
(8, 'Esteban Ocon', 'Force India', 'Mercedes-AMG F1 M08 EQ Power+', 'France', '23'),
(9, 'Lance Stroll', 'Williams', 'Mercedes-AMG F1 M08 EQ Power+', 'Canadá', '18'),
(10, 'Felipe Massa', 'Williams', 'Mercedes-AMG F1 M08 EQ Power+', 'Brasil', '36'),
(11, 'Stoffel Vandoorne', 'McLaren', 'Honda RA617H', 'Bélgica', '25'),
(12, 'Fernando Alonso', 'McLaren', 'Honda RA617H', 'España', '36'),
(13, 'Jenson Button', 'McLaren', 'Honda RA617H', 'Inglaterra', '37'),
(14, 'Daniil Kvyat', 'Toro Rosso', 'Renault R.E.17', 'Rusia', '23'),
(15, 'Carlos Sainz Jr.', 'Toro Rosso', 'Renault R.E.17', 'España', '23'),
(16, 'Romain Grosjean', 'Haas', 'Ferrari 062', 'Francia', '31'),
(17, 'Kevin Magnussen', 'Haas', 'Ferrari 062', 'Dinamarca', '24'),
(18, 'Nico Hülkenberg', 'Renault', 'Renault R.E.17', 'Alemania', '30'),
(19, 'Jolyon Palmer', 'Renault', 'Renault R.E.17', 'Inglaterra', '26'),
(20, 'Marcus Ericsson', 'Sauber', 'Ferrari 061', 'Suecia', '27'),
(22, 'Pascal Wehrlein', 'Sauber', 'Ferrari 061', 'Alemania', '22');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pilotos`
--
ALTER TABLE `pilotos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pilotos`
--
ALTER TABLE `pilotos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 24 Maj 2015, 20:54
-- Wersja serwera: 5.6.24
-- Wersja PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `systeminteligentnegobudynku`
--
CREATE DATABASE IF NOT EXISTS `systeminteligentnegobudynku` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `systeminteligentnegobudynku`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `alarmy`
--

DROP TABLE IF EXISTS `alarmy`;
CREATE TABLE IF NOT EXISTS `alarmy` (
  `id` int(3) NOT NULL,
  `data_alarmu` date NOT NULL,
  `godzina_alarmu` time NOT NULL,
  `zrudlo` int(2) NOT NULL,
  `powod` int(2) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `alarmy`
--

INSERT INTO `alarmy` (`id`, `data_alarmu`, `godzina_alarmu`, `zrudlo`, `powod`) VALUES
(1, '2015-05-24', '11:13:11', 1, 1),
(2, '2015-05-24', '11:13:14', 1, 1),
(3, '2015-05-24', '11:13:23', 2, 1),
(4, '2015-05-24', '11:13:26', 2, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `czujniki`
--

DROP TABLE IF EXISTS `czujniki`;
CREATE TABLE IF NOT EXISTS `czujniki` (
  `id` int(2) NOT NULL,
  `nazwa` varchar(20) NOT NULL,
  `typ` int(2) NOT NULL,
  `stan_aktualny` int(3) NOT NULL,
  `stan_minimalny` int(3) NOT NULL,
  `stan_maksymalny` int(3) NOT NULL,
  `data` date DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `czujniki`
--

INSERT INTO `czujniki` (`id`, `nazwa`, `typ`, `stan_aktualny`, `stan_minimalny`, `stan_maksymalny`, `data`) VALUES
(2, 'okno', 2, 1, 0, 1, '2015-05-24'),
(3, 'okno_duze', 2, 1, 0, 1, '2015-05-24'),
(4, 'otwarciaOkna', 1, 0, 0, 1, NULL),
(5, 'otwarciaOkna', 1, 0, 0, 1, NULL),
(6, 'okno', 1, 0, 1, 2, NULL),
(7, 'okno', 1, 0, 1, 2, NULL),
(9, 'swiatla', 1, 1, 1, 2, NULL),
(10, 'swiatla', 1, 1, 1, 2, NULL),
(11, 'swiatla_1', 1, 1, 1, 2, NULL),
(12, 'swiatla_1', 1, 1, 1, 2, NULL),
(13, 'swiatla_1', 1, 1, 1, 2, NULL),
(14, 'swiatla_1', 1, 1, 1, 2, NULL),
(15, 'swiatla_1', 1, 1, 1, 2, NULL),
(16, 'swiatla_1', 1, 1, 1, 2, NULL),
(17, 'swiatla_1', 1, 1, 1, 2, NULL),
(18, 'swiatla_1', 1, 1, 1, 2, NULL),
(19, 'swiatla_1', 1, 1, 1, 2, NULL),
(20, 'swiatla_1', 1, 1, 1, 2, NULL),
(21, 'swiatla_1', 1, 1, 1, 2, NULL),
(22, 'swiatla_1', 1, 1, 1, 2, NULL),
(23, 'swiatla_1', 1, 1, 1, 2, NULL),
(24, 'swiatla_1', 1, 1, 1, 2, NULL),
(25, 'swiatla_1', 1, 1, 1, 2, NULL),
(26, 'swiatla_1', 1, 1, 1, 2, NULL),
(27, 'swiatla_1', 1, 1, 1, 2, NULL),
(28, 'swiatla_1', 1, 1, 1, 2, NULL),
(29, 'swiatla_1', 1, 1, 1, 2, NULL),
(30, 'swiatla_1', 1, 1, 1, 2, NULL),
(31, 'swiatla_1', 1, 1, 1, 2, NULL),
(32, 'swiatla_1', 1, 1, 1, 2, NULL),
(33, 'swiatla_1', 1, 1, 1, 2, NULL),
(34, 'swiatla_1', 1, 1, 1, 2, NULL),
(35, 'swiatla_1', 1, 1, 1, 2, NULL),
(36, 'swiatla_1', 1, 1, 1, 2, NULL),
(37, 'swiatla_1', 1, 1, 1, 2, NULL),
(38, 'swiatla_1', 1, 1, 1, 2, NULL),
(39, 'swiatla_1', 1, 1, 1, 2, NULL),
(40, 'swiatla_1', 1, 1, 1, 2, NULL),
(41, 'swiatla_1', 1, 1, 1, 2, NULL),
(42, 'swiatla_1', 1, 1, 1, 2, NULL),
(43, 'swiatla_1', 1, 1, 1, 2, NULL),
(44, 'swiatla_1', 1, 1, 1, 2, NULL),
(45, 'swiatla_1', 1, 1, 1, 2, NULL),
(46, 'swiatla_1', 1, 1, 1, 2, NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przekazniki`
--

DROP TABLE IF EXISTS `przekazniki`;
CREATE TABLE IF NOT EXISTS `przekazniki` (
  `id` int(2) NOT NULL,
  `nazwa` varchar(20) NOT NULL,
  `stan_ac` int(1) NOT NULL,
  `data_zmiany` int(7) NOT NULL,
  `zrudlo_zmiany` int(2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `przekazniki`
--

INSERT INTO `przekazniki` (`id`, `nazwa`, `stan_ac`, `data_zmiany`, `zrudlo_zmiany`) VALUES
(1, 'otwarccie_okna', 1, 2030, 2),
(2, 'otwarccie_okna', 1, 2030, 2),
(3, 'przekaznik', 0, 2323, 1),
(4, 'przekaznik', 0, 2323, 1),
(5, 'przekaznik_1', 0, 444, 1),
(6, 'przekaznik_1', 0, 444, 1),
(7, 'przekaznik_1', 0, 444, 1),
(8, 'przekaznik_1', 0, 444, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zdarzenia`
--

DROP TABLE IF EXISTS `zdarzenia`;
CREATE TABLE IF NOT EXISTS `zdarzenia` (
  `id` int(4) NOT NULL,
  `zrudlo` int(2) NOT NULL,
  `czy_odczytany` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `alarmy`
--
ALTER TABLE `alarmy`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `czujniki`
--
ALTER TABLE `czujniki`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `przekazniki`
--
ALTER TABLE `przekazniki`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `zdarzenia`
--
ALTER TABLE `zdarzenia`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `alarmy`
--
ALTER TABLE `alarmy`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT dla tabeli `czujniki`
--
ALTER TABLE `czujniki`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=47;
--
-- AUTO_INCREMENT dla tabeli `przekazniki`
--
ALTER TABLE `przekazniki`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT dla tabeli `zdarzenia`
--
ALTER TABLE `zdarzenia`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

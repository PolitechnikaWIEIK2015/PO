-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 03 Lip 2015, 02:29
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

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `alarmy`
--

CREATE TABLE IF NOT EXISTS `alarmy` (
  `id` int(3) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `element` varchar(20) NOT NULL,
  `powod` int(2) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `alarmy`
--

INSERT INTO `alarmy` (`id`, `date`, `element`, `powod`) VALUES
(1, '2015-05-24 00:00:00', '11:13:11', 1),
(2, '2015-05-24 00:00:00', '11:13:14', 1),
(3, '2015-05-24 00:00:00', '11:13:23', 1),
(4, '2015-05-24 00:00:00', '11:13:26', 1),
(5, '2015-07-03 01:44:24', 'salon', 1),
(6, '2015-07-03 02:02:41', 'Sypialnia_1', 1),
(7, '2015-07-03 02:02:41', 'Sypialnia_3', 1),
(8, '2015-07-03 02:03:43', 'korytarz', 1),
(9, '2015-07-03 02:03:44', 'Sypialnia_1', 1),
(10, '2015-07-03 02:03:44', 'Sypialnia_2', 1),
(11, '2015-07-03 02:03:44', 'Sypialnia_3', 1),
(12, '2015-07-03 02:07:46', 'korytarz', 1),
(13, '2015-07-03 02:07:46', 'Sypialnia_1', 1),
(14, '2015-07-03 02:07:46', 'Sypialnia_2', 1),
(15, '2015-07-03 02:07:47', 'Sypialnia_3', 1),
(16, '2015-07-03 02:08:53', 'korytarz', 3),
(17, '2015-07-03 02:08:54', 'Sypialnia_1', 3),
(18, '2015-07-03 02:08:54', 'Sypialnia_2', 3),
(19, '2015-07-03 02:08:54', 'Sypialnia_3', 3),
(20, '2015-07-03 02:20:20', 'korytarz', 3),
(21, '2015-07-03 02:20:21', 'Sypialnia_1', 3),
(22, '2015-07-03 02:20:21', 'Sypialnia_2', 3),
(23, '2015-07-03 02:20:21', 'Sypialnia_3', 3),
(24, '2015-07-03 02:23:17', 'Sypialnia_1', 2),
(25, '2015-07-03 02:23:18', 'Sypialnia_3', 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `czujniki`
--

CREATE TABLE IF NOT EXISTS `czujniki` (
  `id` int(2) NOT NULL,
  `nazwa` varchar(20) NOT NULL,
  `Zadana` int(2) NOT NULL,
  `stan_aktualny` int(3) NOT NULL,
  `stan_minimalny` int(3) NOT NULL,
  `stan_maksymalny` int(3) NOT NULL,
  `data` date DEFAULT NULL,
  `Stan` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `czujniki`
--

INSERT INTO `czujniki` (`id`, `nazwa`, `Zadana`, `stan_aktualny`, `stan_minimalny`, `stan_maksymalny`, `data`, `Stan`) VALUES
(1, 'salon', 22, 19, 5, 45, '2015-07-02', 1),
(2, 'kuchnia', 22, 19, 5, 45, '2015-07-02', 1),
(3, 'korytarz', 22, 18, 5, 45, '2015-07-02', 1),
(4, 'Sypialnia_1', 22, 21, 5, 45, '2015-07-02', 1),
(5, 'Sypialnia_2', 22, 21, 5, 45, '2015-07-02', 1),
(6, 'Sypialnia_3', 8, 20, 5, 45, '2015-07-02', 1),
(7, 'lazienka', 22, 21, 5, 45, '2015-07-02', 0),
(8, 'p_gospodarcze', 22, 21, 5, 45, '2015-07-02', 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przekazniki`
--

CREATE TABLE IF NOT EXISTS `przekazniki` (
  `id` int(2) NOT NULL,
  `nazwa` varchar(20) NOT NULL,
  `stan_ac` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `przekazniki`
--

INSERT INTO `przekazniki` (`id`, `nazwa`, `stan_ac`) VALUES
(1, 'salon', 0),
(2, 'p_kuchnia', 0),
(3, 'p_Korytarz', 0),
(4, 'p_sypialnia1', 0),
(5, 'p_sypialnia2', 0),
(6, 'p_sypialnia3', 0),
(7, 'p_lazienka', 0),
(8, 'p_gospodarcze', 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zdarzenia`
--

CREATE TABLE IF NOT EXISTS `zdarzenia` (
  `id` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `element` varchar(20) NOT NULL,
  `powod` int(2) NOT NULL,
  `stan` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `zdarzenia`
--

INSERT INTO `zdarzenia` (`id`, `date`, `element`, `powod`, `stan`) VALUES
(1, '2015-07-03 01:40:17', 'p_sypialnia3', 4, 0),
(2, '2015-07-03 01:40:18', 'p_sypialnia3', 5, 1),
(3, '2015-07-03 01:40:59', 'p_sypialnia1', 5, 1),
(4, '2015-07-03 01:42:22', 'p_sypialnia3', 4, 0),
(5, '2015-07-03 01:42:31', 'p_sypialnia3', 5, 1),
(6, '2015-07-03 01:42:36', 'p_sypialnia3', 4, 0),
(7, '2015-07-03 01:43:53', 'p_sypialnia3', 5, 1),
(8, '2015-07-03 01:44:03', 'p_sypialnia2', 5, 1),
(9, '2015-07-03 01:44:07', 'p_sypialnia1', 4, 0),
(10, '2015-07-03 01:44:12', 'p_sypialnia1', 5, 1),
(11, '2015-07-03 01:44:15', 'p_Korytarz', 5, 1),
(12, '2015-07-03 01:44:20', 'p_kuchnia', 5, 1),
(13, '2015-07-03 01:44:24', 'salon', 5, 1),
(14, '2015-07-03 01:55:28', 'p_sypialnia3', 4, 0),
(15, '2015-07-03 01:56:06', 'p_sypialnia3', 5, 1),
(16, '2015-07-03 01:56:42', 'p_sypialnia1', 4, 0),
(17, '2015-07-03 01:56:45', 'p_sypialnia1', 5, 1),
(18, '2015-07-03 02:02:40', 'salon', 4, 0),
(19, '2015-07-03 02:02:41', 'p_kuchnia', 4, 0),
(20, '2015-07-03 02:02:41', 'p_Korytarz', 4, 0),
(21, '2015-07-03 02:02:41', 'p_sypialnia2', 4, 0),
(22, '2015-07-03 02:23:37', 'p_kuchnia', 5, 1),
(23, '2015-07-03 02:23:48', 'p_kuchnia', 4, 0),
(24, '2015-07-03 02:23:48', 'p_sypialnia1', 4, 0),
(25, '2015-07-03 02:23:48', 'p_sypialnia3', 4, 0);

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
  ADD PRIMARY KEY (`id`), ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `alarmy`
--
ALTER TABLE `alarmy`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT dla tabeli `czujniki`
--
ALTER TABLE `czujniki`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT dla tabeli `przekazniki`
--
ALTER TABLE `przekazniki`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT dla tabeli `zdarzenia`
--
ALTER TABLE `zdarzenia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

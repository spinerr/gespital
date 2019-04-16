-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Mar 05 Mars 2019 à 21:36
-- Version du serveur :  5.7.25-0ubuntu0.18.04.2
-- Version de PHP :  7.2.15-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `hopital`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

CREATE TABLE `administrateur` (
  `id_admin` int(11) NOT NULL,
  `pseudo_admin` varchar(110) NOT NULL,
  `mdp_admin` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `administrateur`
--

INSERT INTO `administrateur` (`id_admin`, `pseudo_admin`, `mdp_admin`) VALUES
(1, 'momo', 'passer');

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

CREATE TABLE `consultation` (
  `numero` int(11) NOT NULL,
  `date` date NOT NULL,
  `motifs` varchar(500) NOT NULL,
  `medecin_has_patient_medecin_matricule` int(11) NOT NULL,
  `medecin_has_patient_patient_num_ss` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `consulte`
--

CREATE TABLE `consulte` (
  `medecin_matricule` int(11) NOT NULL,
  `patient_num_ss` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

CREATE TABLE `medecin` (
  `matricule` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `medecin`
--

INSERT INTO `medecin` (`matricule`, `nom`) VALUES
(1, 'ad kd'),
(2, 'jok bgt');

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

CREATE TABLE `medicament` (
  `code` varchar(6) NOT NULL,
  `libelle` varchar(45) NOT NULL,
  `indications` varchar(45) NOT NULL,
  `posologie` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `medicament`
--

INSERT INTO `medicament` (`code`, `libelle`, `indications`, `posologie`) VALUES
('01rrf', 'grygy', 'ryhuj', 'uikèi');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `num_ss` int(11) NOT NULL,
  `nom_p` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `patient`
--

INSERT INTO `patient` (`num_ss`, `nom_p`) VALUES
(1, 'etfftte');

-- --------------------------------------------------------

--
-- Structure de la table `prescrit`
--

CREATE TABLE `prescrit` (
  `medicament_code` varchar(6) NOT NULL,
  `consultation_numero` int(11) NOT NULL,
  `nombre_de_jours` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD PRIMARY KEY (`id_admin`);

--
-- Index pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `medecin_has_patient_medecin_matricule` (`medecin_has_patient_medecin_matricule`),
  ADD KEY `medecin_has_patient_patient_num_ss` (`medecin_has_patient_patient_num_ss`);

--
-- Index pour la table `consulte`
--
ALTER TABLE `consulte`
  ADD KEY `medecin_matricule` (`medecin_matricule`),
  ADD KEY `patient_num_ss` (`patient_num_ss`);

--
-- Index pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`matricule`);

--
-- Index pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`num_ss`);

--
-- Index pour la table `prescrit`
--
ALTER TABLE `prescrit`
  ADD KEY `medicament_code` (`medicament_code`),
  ADD KEY `consultation_numero` (`consultation_numero`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `consultation`
--
ALTER TABLE `consultation`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `consultation_ibfk_1` FOREIGN KEY (`medecin_has_patient_medecin_matricule`) REFERENCES `consulte` (`medecin_matricule`),
  ADD CONSTRAINT `consultation_ibfk_2` FOREIGN KEY (`medecin_has_patient_patient_num_ss`) REFERENCES `consulte` (`patient_num_ss`);

--
-- Contraintes pour la table `consulte`
--
ALTER TABLE `consulte`
  ADD CONSTRAINT `consulte_ibfk_1` FOREIGN KEY (`medecin_matricule`) REFERENCES `medecin` (`matricule`),
  ADD CONSTRAINT `consulte_ibfk_2` FOREIGN KEY (`patient_num_ss`) REFERENCES `patient` (`num_ss`);

--
-- Contraintes pour la table `prescrit`
--
ALTER TABLE `prescrit`
  ADD CONSTRAINT `prescrit_ibfk_1` FOREIGN KEY (`medicament_code`) REFERENCES `medicament` (`code`),
  ADD CONSTRAINT `prescrit_ibfk_2` FOREIGN KEY (`consultation_numero`) REFERENCES `consultation` (`numero`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
